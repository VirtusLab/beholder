package org.virtuslab.beholder.json

import java.sql.Date

import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.forms.FromFilterFieldsComponent
import org.virtuslab.beholder.filters.json.{ JsonFilterFieldsComponent, JsonFiltersComponent, JsonFormatterComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }
import play.api.libs.json.{ JsObject, JsSuccess }

import scala.concurrent.ExecutionContext.Implicits.global

class JsonSeqTestRepository(override val unicorn: UnicornPlay[Long])
  extends UserMachinesViewComponent
  with JsonFormatterComponent
  with JsonFiltersComponent
  with JsonFilterFieldsComponent
  with UnicornWrapper[Long] {

  import unicorn.profile.api._

  import JsonFilterFields.{
    inOptionRange,
    inText,
    inIntFieldSeq,
    inRange,
    inField,
    inEnumSeq
  }

  def createFilter: FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow](identity).create(
      viewQuery,
      inText,
      inText,
      inIntFieldSeq,
      inRange(inField[Date]("date")),
      inOptionRange(inField[BigDecimal]("number")),
      inEnumSeq(MachineStatus))

}

class JsonFiltersSeqTest extends BaseTest {

  class BaseFilterData(implicit val f: BaseTest.Fixture) {
    import f._
    import f.unicorn.profile.api._
    lazy val jsonSeqTestRepository = new JsonSeqTestRepository(unicorn)
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = jsonSeqTestRepository.createFilter
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

  it should "filter by seq(int) only users with one and four core machines" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val usersWithOneOrFourCore = Some(Seq(1, 4))
      for {
        all <- allFromDb
        usersWithOneOrFourCoreMachines <- doFilters(bfd, baseFilter.copy(data = baseFilterData.updated(2, usersWithOneOrFourCore)))
      } yield {
        usersWithOneOrFourCoreMachines should contain theSameElementsAs all
      }
    }
  }

  it should "filter by seq(int) only users with one and three core machine" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val oneOrThreeCore = Some(Seq(1, 3))
      for {
        all <- allFromDb
        usersWithOneOrThreeCoreMachines <- doFilters(bfd, baseFilter.copy(data = baseFilterData.updated(2, oneOrThreeCore)))
      } yield {
        usersWithOneOrThreeCoreMachines should contain theSameElementsAs all.filter(machine => machine.cores == 1 || machine.cores == 3)
      }
    }
  }

  it should "filter by seq(enum) all users together with inactive and broken machines" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val inactiveAndBroken = Some(Seq(MachineStatus.Inactive, MachineStatus.Broken))
      for {
        all <- allFromDb
        usersWithInactiveAndBrokenMachines <- doFilters(bfd, baseFilter.copy(data = baseFilterData.updated(5, inactiveAndBroken)))
      } yield {
        usersWithInactiveAndBrokenMachines.size should be(2)
        usersWithInactiveAndBrokenMachines should contain theSameElementsAs all.filter(machine => machine.status == MachineStatus.Inactive)
      }
    }
  }
}
