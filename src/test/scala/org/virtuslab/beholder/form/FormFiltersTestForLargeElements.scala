package org.virtuslab.beholder.form

import org.virtuslab.beholder.filters.forms.{ FormFilterComponent, FormFormatterComponent, FromFilterFieldsComponent }
import org.virtuslab.beholder.filters.{ FilterDefinition, Order }
import org.virtuslab.beholder.model.{ LargeElement, LargeElementId }
import org.virtuslab.beholder.{ BaseTest, LargeElementsViewComponent }
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class FormFiltersTestForLargeElementsRepository(override val unicorn: UnicornPlay[Long])
  extends LargeElementsViewComponent
  with FormFormatterComponent
  with FormFilterComponent
  with FromFilterFieldsComponent
  with UnicornWrapper[Long] {

  import FromFilterFields.{ inIntField, inText }
  import unicorn._
  import unicorn.profile.api._

  def createFilter = new CustomTypeMappers {
    val filterGenerator = new FormFilters[LargeElement].create(
      viewQuery,
      FromFilterFields.ignore[Option[LargeElementId]],
      inText,
      inIntField,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText,
      inText)
  }.filterGenerator

}

class FormFiltersTestForLargeElements extends BaseTest {

  class BaseFilterData(implicit val f: BaseTest.Fixture) {
    import f._
    import f.unicorn.profile.api._
    lazy val formFiltersTestForLargeElementsRepository = new FormFiltersTestForLargeElementsRepository(unicorn)
    lazy val query = formFiltersTestForLargeElementsRepository.viewQuery
    lazy val filter = formFiltersTestForLargeElementsRepository.createFilter
    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data
    lazy val allFromDb: DBIO[Seq[LargeElement]] =
      for {
        _ <- populatedDatabase
        all <- query.result
      } yield all
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): slick.dbio.DBIO[Seq[LargeElement]] = {
    import data.filter
    val formatter = filter.formatter
    val formData = formatter.filterForm.fill(currentFilter)

    formatter.filterForm.bind(formData.data).fold(
      errors => fail(s"Form errors ${errors.errors.mkString}"),
      fromForm => filter.filter(fromForm))
  }

  it should "query all entities for empty filter" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        allFromFilter <- doFilters(bfd, baseFilter)
      } yield {
        allFromFilter should contain theSameElementsAs all
      }
    }
  }

  it should "order by argument asc correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByFirstField <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("f1", asc = true))))
      } yield {
        val fromDbOrderedByFirstField = all.sortBy(view => (view.f1, view.f1))
        orderByFirstField should contain theSameElementsInOrderAs fromDbOrderedByFirstField
      }
    }
  }

  it should "order by argument desc correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByFirstField <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("f1", asc = false))))
      } yield {
        val fromDbOrderedByFirstField = all.sortBy(view => (view.f1, view.f1)).reverse
        orderByFirstField should contain theSameElementsInOrderAs fromDbOrderedByFirstField
      }
    }
  }

  it should "take correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByFirstField <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("f1", asc = false)), take = Some(2)))
      } yield {
        val fromDbOrderedByFirstField = all.sortBy(view => (view.f1, view.f1)).reverse
        orderByFirstField should contain theSameElementsInOrderAs fromDbOrderedByFirstField.take(2)
      }
    }
  }

  it should "skip correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByFirstField <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("f1", asc = false)), skip = Some(1)))
      } yield {
        val fromDbOrderedByFirstField = all.sortBy(view => (view.f1, view.f1)).reverse
        orderByFirstField should contain theSameElementsInOrderAs fromDbOrderedByFirstField.drop(1)
      }
    }
  }

  it should "filter by int field" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByIntField <- doFilters(bfd, baseFilter.copy(data = baseFilter.data.updated(2, Some(10))))
      } yield {
        val fromDbOrderedByIntField = all.filter(_.f2 == 2)
        orderByIntField should contain theSameElementsInOrderAs fromDbOrderedByIntField.drop(1)
      }
    }
  }

  it should "skip correctly and return correct total amount of entities" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        filterData <- filter.filterWithTotalEntitiesNumber(baseFilter.copy(orderBy = Some(Order("f1", asc = false)), skip = Some(1)))
      } yield {
        val fromDbOrderedByFirstField = all.sortBy(view => (view.f1)).reverse
        filterData.content should contain theSameElementsInOrderAs fromDbOrderedByFirstField.drop(1)
        filterData.total shouldEqual all.size
      }
    }
  }

}
