package org.virtuslab.beholder.form

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.filters.{ FilterDefinition, FilterRange, Order }
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.forms.{ FormFilterComponent, FormFormatterComponent, FromFilterFieldsComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class FormFiltersTestRepository(override val unicorn: UnicornPlay[Long])
    extends UserMachinesViewComponent
    with FormFormatterComponent
    with FormFilterComponent
    with FromFilterFieldsComponent
    with UnicornWrapper[Long] {

  import unicorn._
  import unicorn.profile.api._
  import play.api.data.format.Formats._
  import FromFilterFields.{
    inText,
    inIntField,
    inRange
  }

  def createFilter = new CustomTypeMappers {
    val filterGenerator = new FormFilters[UserMachineViewRow].create(
      viewQuery,
      inText,
      inText,
      inIntField,
      inRange[Date],
      FromFilterFields.ignore[Option[BigDecimal]],
      FromFilterFields.ignore[MachineStatus.Value]
    )
  }.filterGenerator

}

class FormFiltersTest extends BaseTest {
  lazy val formFiltersTestRepository = new FormFiltersTestRepository(unicorn)
  lazy val baseFilterData = new BaseFilterData
  import baseFilterData._
  import unicorn.profile.api._

  class BaseFilterData {
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = formFiltersTestRepository.createFilter
    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data
    lazy val allFromDb: DBIO[Seq[UserMachineViewRow]] =
      for {
        view <- userMachinesViewRepository.createUsersMachineView()
        _ <- populatedDatabase
        all <- view.result
      } yield all
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): DBIO[Seq[UserMachineViewRow]] = {
    val formatter = data.filter.formatter
    val formData = formatter.filterForm.fill(currentFilter)

    formatter.filterForm.bind(formData.data).fold(
      errors => fail(s"Form errors ${errors.errors.mkString}"),
      fromForm => data.filter.filter(fromForm)
    )
  }

  it should "query all entities for empty filter" in rollbackActionWithModel {
    for {
      all <- allFromDb
      allFromFilter <- doFilters(baseFilterData, baseFilter)
    } yield {
      allFromFilter should contain theSameElementsAs all
    }
  }

  it should "order by argument asc correctly" in rollbackActionWithModel {
    for {
      all <- allFromDb
      orderByCore <- doFilters(baseFilterData, baseFilter.copy(orderBy = Some(Order("cores", asc = true))))
    } yield {
      val fromDbOrderedByCores = all.sortBy(view => (view.cores, view.email))
      orderByCore should contain theSameElementsInOrderAs fromDbOrderedByCores
    }
  }

  it should "order by argument desc correctly" in rollbackActionWithModel {
    for {
      all <- allFromDb
      orderByCoreDesc <- doFilters(baseFilterData, baseFilter.copy(orderBy = Some(Order("cores", asc = false))))
    } yield {
      val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc
    }
  }

  it should "take correctly" in rollbackActionWithModel {
    for {
      all <- allFromDb
      orderByCoreDesc <- doFilters(baseFilterData, baseFilter.copy(orderBy = Some(Order("cores", asc = false)), take = Some(2)))
    } yield {
      val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.take(2)
    }
  }

  it should "skip correctly" in rollbackActionWithModel {
    for {
      all <- allFromDb
      orderByCoreDesc <- doFilters(baseFilterData, baseFilter.copy(orderBy = Some(Order("cores", asc = false)), skip = Some(1)))
    } yield {
      val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
    }
  }

  it should "filter by int field" in rollbackActionWithModel {
    for {
      all <- allFromDb
      orderByCoreDesc <- doFilters(baseFilterData, baseFilter.copy(data = baseFilter.data.updated(2, Some(2))))
    } yield {
      val fromDbOrderedByCoresDesc = all.filter(_.cores == 2)
      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
    }
  }

  //h2db does not have ilike operator
  ignore should "filter by string field" in rollbackActionWithModel {
    for {
      all <- allFromDb
      orderByCoreDesc <- doFilters(baseFilterData, baseFilter.copy(data = baseFilter.data.updated(1, Some("buntu"))))
    } yield {
      val fromDbOrderedByCoresDesc = all.filter(_.system.contains("buntu"))
      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
    }
  }

  ignore should "filter by BigDecimal field" in rollbackActionWithModel {
    for {
      all <- allFromDb
      filteredData <- doFilters(baseFilterData, baseFilter.copy(data = baseFilter.data.updated(4, Some(BigDecimal(1.0)))))
    } yield {
      val fromDbFiltered = all.filter(_.capacity.contains(BigDecimal(1.0)))
      filteredData should contain theSameElementsInOrderAs fromDbFiltered
    }
  }

  it should "not crash for date option" in rollbackActionWithModel {
    val toDate = new Date(DateTime.now().minusHours(24).getMillis)
    val dataRange = Some(FilterRange(None, Some(toDate)))

    val newVersion = baseFilter.copy(data = baseFilterData.baseFilterData.updated(3, dataRange))
    for {
      all <- allFromDb
      withCorrectDates <- doFilters(baseFilterData, newVersion)
    } yield {
      val fromDbWithCorrectDates = all.filter(_.created.before(toDate))
      withCorrectDates should contain theSameElementsInOrderAs fromDbWithCorrectDates
    }
  }

  it should "skip correctly and return correct total amount of entities" in rollbackActionWithModel {
    for {
      all <- allFromDb
      filterData <- filter.filterWithTotalEntitiesNumber(baseFilter.copy(orderBy = Some(Order("cores", asc = false)), skip = Some(1)))
    } yield {
      val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
      filterData.content should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
      filterData.total shouldEqual all.size
    }
  }
}
