package org.virtuslab.beholder.json

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.json.{ JsonFilterFieldsComponent, JsonFiltersComponent, JsonFormatterComponent }
import org.virtuslab.beholder.filters.{ FilterDefinition, FilterRange, Order }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }
import play.api.libs.json.{ JsObject, JsSuccess }

import scala.concurrent.ExecutionContext.Implicits.global

class JsonFiltersTestRepository(override val unicorn: UnicornPlay[Long])
  extends UserMachinesViewComponent
  with JsonFormatterComponent
  with JsonFiltersComponent
  with JsonFilterFieldsComponent
  with UnicornWrapper[Long] {

  import unicorn.profile.api._

  import JsonFilterFields.{
    inText,
    inIntField,
    inRange,
    inField,
    inEnum
  }

  def createFilter: FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow](identity).create(
      viewQuery,
      inText,
      inText,
      inIntField,
      inRange(inField[Date]("date")),
      JsonFilterFields.ignore[Option[BigDecimal]],
      inEnum(MachineStatus))

}

class JsonFiltersTest extends BaseTest {

  class BaseFilterData(implicit val f: BaseTest.Fixture) {
    import f._
    import f.unicorn.profile.api._
    lazy val jsonFiltersTestRepository = new JsonFiltersTestRepository(unicorn)
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = jsonFiltersTestRepository.createFilter
    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data
    lazy val allFromDb: DBIO[Seq[UserMachineViewRow]] =
      for {
        view <- userMachinesViewRepository.createUsersMachineView()
        _ <- populatedDatabase
        all <- view.result
      } yield all
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): slick.dbio.DBIO[Seq[UserMachineViewRow]] = {
    import data.filter
    val resultAction = filter.filterWithTotalEntitiesNumber(currentFilter)
    resultAction.map {
      result =>
        filter.formatter.results(currentFilter, result) match {
          case JsObject(fields) =>
            filter.formatter.filterDefinition(fields("filter")) should equal(JsSuccess(currentFilter))
        }
        result.content
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
        orderByCore <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("cores", asc = true))))
      } yield {
        val fromDbOrderedByCores = all.sortBy(view => (view.cores, view.email))
        orderByCore should contain theSameElementsInOrderAs fromDbOrderedByCores
      }
    }
  }

  it should "order by argument desc correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("cores", asc = false))))
      } yield {
        val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc
      }
    }
  }

  it should "take correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("cores", asc = false)), take = Some(2)))
      } yield {
        val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.take(2)
      }
    }
  }

  it should "skip correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(bfd, baseFilter.copy(orderBy = Some(Order("cores", asc = false)), skip = Some(1)))
      } yield {
        val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
      }
    }
  }

  it should "filter by int field" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(bfd, baseFilter.copy(data = baseFilter.data.updated(2, Some(2))))
      } yield {
        val fromDbOrderedByCoresDesc = all.filter(_.cores == 2)
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
      }
    }
  }

  //h2db does not have ilike operator
  ignore should "filter by string field" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(bfd, baseFilter.copy(data = baseFilter.data.updated(1, Some("buntu"))))
      } yield {
        val fromDbOrderedByCoresDesc = all.filter(_.system.contains("buntu"))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
      }
    }
  }

  ignore should "filter by BigDecimal field" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      for {
        all <- allFromDb
        filteredData <- doFilters(bfd, baseFilter.copy(data = baseFilter.data.updated(4, Some(BigDecimal(1.0)))))
      } yield {
        val fromDbFiltered = all.filter(_.capacity.contains(BigDecimal(1.0)))
        filteredData should contain theSameElementsInOrderAs fromDbFiltered
      }
    }
  }

  it should "not crash for date option" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val toDate = new Date(DateTime.now().minusHours(24).getMillis)
      val dataRange = Some(FilterRange(None, Some(toDate)))

      val newVersion = baseFilter.copy(data = baseFilterData.updated(3, dataRange))
      for {
        all <- allFromDb
        withCorrectDates <- doFilters(bfd, newVersion)
      } yield {
        val fromDbWithCorrectDates = all.filter(_.created.before(toDate))
        withCorrectDates should contain theSameElementsInOrderAs fromDbWithCorrectDates
      }
    }
  }

  it should "skip correctly and return correct total amount of entities" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
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
}