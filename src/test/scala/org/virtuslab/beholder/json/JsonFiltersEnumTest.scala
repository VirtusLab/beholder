package org.virtuslab.beholder.json

import java.sql.Date

import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.forms.FromFilterFieldsComponent
import org.virtuslab.beholder.filters.json.{ JsonFiltersComponent, JsonFormatterComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }
import play.api.libs.json.{ JsObject, JsSuccess }
import sttp.tapir._

import scala.concurrent.ExecutionContext.Implicits.global

class JsonEnumTestRepository(override val unicorn: UnicornPlay[Long])
  extends UserMachinesViewComponent
  with JsonFormatterComponent
  with JsonFiltersComponent
  with FromFilterFieldsComponent
  with UnicornWrapper[Long] {

  import unicorn.profile.api._

  import JsonFilterFields.{
    inOptionRange,
    inText,
    inIntFieldSeq,
    inRange,
    inField,
    inEnum
  }

  def createFilter: FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow](identity).create(
      viewQuery,
      inText,
      inText,
      inIntFieldSeq,
      inRange(inField[Date]("date")),
      inOptionRange(inField[BigDecimal]("number")),
      inEnum(MachineStatus))

}

class JsonFiltersEnumTest extends BaseTest {

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

  it should "filter all users with inactive machines" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val inactive = Some(MachineStatus.Inactive)
      val usersWithInactiveMachinesAction = doFilters(
        bfd, baseFilter.copy(data = baseFilterData.updated(5, inactive)))
      for {
        all <- allFromDb
        usersWithInactiveMachines <- usersWithInactiveMachinesAction
      } yield {
        usersWithInactiveMachines should contain theSameElementsAs all.filter(machine => machine.status == MachineStatus.Inactive)
      }
    }
  }
}
