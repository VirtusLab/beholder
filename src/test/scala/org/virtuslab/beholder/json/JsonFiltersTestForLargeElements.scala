package org.virtuslab.beholder.json

import org.joda.time.DateTime
import org.virtuslab.beholder.filters.json.{ JsonFilterFieldsComponent, JsonFiltersComponent, JsonFormatterComponent }
import org.virtuslab.beholder.filters.{ FilterDefinition, FilterRange, Order }
import org.virtuslab.beholder.model.{ LargeElement, LargeElementId }
import org.virtuslab.beholder.{ BaseTest, LargeElementsViewComponent, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }
import play.api.libs.json.{ JsObject, JsSuccess }

import java.sql.Date
import scala.concurrent.ExecutionContext.Implicits.global

class JsonFiltersTestForLargeElementsRepository(override val unicorn: UnicornPlay[Long])
  extends LargeElementsViewComponent
  with JsonFormatterComponent
  with JsonFiltersComponent
  with JsonFilterFieldsComponent
  with UnicornWrapper[Long] {

  import JsonFilterFields.{ inIntField, inText, ignore }
  import unicorn.profile.api._

  def createFilter: FilterAPI[LargeElement, JsonFormatter[LargeElement]] =
    new JsonFilters[LargeElement](identity).create(
      viewQuery,
      ignore[Option[LargeElementId]],
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

}

class JsonFiltersTestForLargeElements extends BaseTest {

  class BaseFilterData(implicit val f: BaseTest.Fixture) {
    import f._
    import f.unicorn.profile.api._
    lazy val jsonFiltersTestForLargeElementsRepository = new JsonFiltersTestForLargeElementsRepository(unicorn)
    lazy val query = jsonFiltersTestForLargeElementsRepository.viewQuery
    lazy val filter = jsonFiltersTestForLargeElementsRepository.createFilter
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
    val resultAction = filter.filterWithTotalEntitiesNumber(currentFilter)
    resultAction.map {
      result =>
        filter.formatter.results(currentFilter, result) match {
          case JsObject(fields) =>
            filter.formatter.filterDefinition(fields("filter")) should equal(JsSuccess(currentFilter))
        }
        result.data
    }
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
        val fromDbOrderedByFirstField = all.sortBy(view => (view.f1)).reverse
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
        val fromDbOrderedByFirstField = all.sortBy(view => view.f1).reverse
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
        val fromDbOrderedByFirstField = all.sortBy(view => (view.f1)).reverse
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
        orderByFirstField <- doFilters(bfd, baseFilter.copy(data = baseFilter.data.updated(2, Some(3))))
      } yield {
        val fromDbOrderedByFirstField = all.filter(_.f2 == 3)
        orderByFirstField should contain theSameElementsInOrderAs fromDbOrderedByFirstField.drop(1)
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
        filterData.data should contain theSameElementsInOrderAs fromDbOrderedByFirstField.drop(1)
        filterData.total shouldEqual all.size
      }
    }
  }

}