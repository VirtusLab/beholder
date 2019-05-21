package org.virtuslab.beholder.json

import java.sql.Date

import org.scalatest.LoneElement
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.json.{ JsonFilterFieldsComponent, JsonFiltersComponent, JsonFormatterComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }
import play.api.libs.json.{ Format, JsObject, JsString, JsSuccess, Json, Writes, __ }

import scala.concurrent.ExecutionContext.Implicits.global

class JsonFiltersVarLengthRepository(override val unicorn: UnicornPlay[Long])
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

  val inFirstAndSecondPart = new VarLengthJsonFilterField[String, (String, String)]("Text", "firstPart", "secondPart") {

    override val dataObjWrites: Writes[String] = Writes { t: String =>
      Json.obj(
        "firstPart" -> JsString(t.substring(0, 3)),
        "secondPart" -> JsString(t.substring(3, 6)))
    }

    override val filterObjFormat: Format[(String, String)] = {
      import play.api.libs.functional.syntax._
      import play.api.libs.json._
      (
        (__ \ 'firstPart).formatWithDefault("") and
        (__ \ 'secondPart).formatWithDefault("")).tupled
    }

    override protected def filterOnColumn(column: Rep[String])(value: (String, String)): Rep[Option[Boolean]] = {
      val (first, second) = value
      (column.substring(0, 3).? === first) ||
        (column.substring(3, 6).? === second)
    }
  }

  def createFilter: FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] = {
    new JsonFilters[UserMachineViewRow](identity).create(
      viewQuery,
      inText,
      inFirstAndSecondPart,
      inIntFieldSeq,
      inRange(inField[Date]("date")),
      inOptionRange(inField[BigDecimal]("number")),
      inEnumSeq(MachineStatus))
  }
}

class JsonFiltersVarLengthTest extends BaseTest with LoneElement {

  val jsonFiltersVarLengthRepository = new JsonFiltersVarLengthRepository(unicorn)
  val baseFilterData = new BaseFilterData
  import baseFilterData._

  import unicorn.profile.api._
  class BaseFilterData {
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = jsonFiltersVarLengthRepository.createFilter
    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data
    lazy val allFromDb: DBIO[Seq[UserMachineViewRow]] =
      for {
        view <- userMachinesViewRepository.createUsersMachineView()
        _ <- populatedDatabase
        all <- view.result
      } yield all
  }

  def doFilter(firstPart: String, secondPart: String): DBIO[Seq[UserMachineViewRow]] = {
    val filterDefinition = filter.formatter.filterDefinition(
      Json.obj("data" -> Json.obj("firstPart" -> firstPart, "secondPart" -> secondPart))).get
    val resultAction = filter.filterWithTotalEntitiesNumber(filterDefinition)
    resultAction.map {
      result =>
        filter.formatter.results(filterDefinition, result) match {
          case JsObject(fields) =>
            filter.formatter.filterDefinition(fields("filter")) should equal(JsSuccess(filterDefinition))
        }
        result.content
    }
  }

  it should "filter by both splits of column" in rollbackActionWithModel {
    for {
      _ <- allFromDb
      ubu_ntu <- doFilter("Ubu", "ntu")
      ub_unt <- doFilter("Ub", "unt")
      fed_ntu <- doFilter("Fed", "ntu")
    } yield {
      ubu_ntu.map(_.system).distinct.loneElement shouldEqual "Ubuntu"
      ub_unt should be(empty)
      fed_ntu.map(_.system).distinct should contain theSameElementsAs Seq("Ubuntu", "Fedora")
    }
  }

}
