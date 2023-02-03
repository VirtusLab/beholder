package org.virtuslab.beholder.json

import java.sql.Date

import org.virtuslab.beholder.filters.json.{ JsonFilterFieldsComponent, JsonFiltersComponent, JsonFormatterComponent }
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.{ FilterDefinition, FilterRange }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }
import play.api.libs.json.{ JsObject, JsSuccess }

import scala.concurrent.ExecutionContext.Implicits.global

class JsonRangeTestRepository(override val unicorn: UnicornPlay[Long])
  extends UserMachinesViewComponent
  with JsonFormatterComponent
  with JsonFiltersComponent
  with JsonFilterFieldsComponent
  with UnicornWrapper[Long] {

  import unicorn.profile.api._

  import JsonFilterFields.{
    inOptionRange,
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
      inRange(inIntField),
      inRange(inField[Date]("date")),
      inOptionRange(inField[BigDecimal]("number")),
      inEnum(MachineStatus))

}
class JsonFiltersRangeTest extends BaseTest {

  class BaseFilterData(implicit val f: BaseTest.Fixture) {
    import f._
    import f.unicorn.profile.api._
    lazy val jsonRangeTestRepository = new JsonRangeTestRepository(unicorn)
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = jsonRangeTestRepository.createFilter
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
        result.data
    }
  }

  behavior of "range filters"

  it should "should take int range correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val coreRange = Some(FilterRange(Some(1), Some(4)))
      for {
        all <- allFromDb
        coreRangeData <- doFilters(
          bfd, baseFilter.copy(data = baseFilterData.updated(2, coreRange)))
      } yield {
        coreRangeData should contain theSameElementsAs all
      }
    }
  }

  it should "should take BigDecimal range correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      def testCapacityRange(
        minCapacity: Option[BigDecimal],
        maxCapacity: Option[BigDecimal],
        all: Seq[UserMachineViewRow]) = {
        def isInRange(from: Option[BigDecimal], to: Option[BigDecimal], value: Option[BigDecimal]) = {
          val seq = Seq(from, value, to)
          (seq, seq.tail).zipped.forall {
            case (Some(a), Some(b)) => a <= b
            case (_, _) => true
          }
        }

        val capacityRange = Some(FilterRange(minCapacity, maxCapacity))

        for {
          coreRangeData <- doFilters(
            bfd, baseFilter.copy(data = baseFilterData.updated(4, capacityRange)))
        } yield {
          val fromDbFilteredByCapacity = all.filter(a => isInRange(minCapacity, maxCapacity, a.capacity))
          coreRangeData should contain theSameElementsAs fromDbFilteredByCapacity
        }
      }

      for {
        all <- allFromDb
        _ <- testCapacityRange(Some(1), Some(3), all)
        _ <- testCapacityRange(Some(1), Some(2), all)
        _ <- testCapacityRange(Some(2), Some(2), all)
        _ <- testCapacityRange(None, Some(2), all)
        _ <- testCapacityRange(Some(3), None, all)
        _ <- testCapacityRange(None, None, all)
      } yield ()
    }
  }
}