package org.virtuslab.beholder.json

import java.sql.Date

import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.filters.json.{ JsonFormatter, JsonFilterFields, JsonFilters }
import org.virtuslab.beholder.{ UserMachineViewRow, _ }
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import play.api.libs.json._

class JsonFormatterTest extends AppTest with UserMachinesView with ModelIncluded {

  behavior of "JsonFormatter"

  def createFilter(labels: String => String)(implicit session: Session) = {
    val view = createUsersMachineView
    new JsonFilters[UserMachineViewRow](labels).create(
      view,
      inText,
      inText,
      inIntField,
      inRange(inField[Date]("date")),
      JsonFilterFields.ignore[Option[BigDecimal]]
    )
  }

  it should "create filter definition from json defining data field" in rollbackWithModel {
    implicit session =>
      //given
      lazy val filter = createFilter(identity)
      val jsonFilterData = JsObject(Seq("data" -> JsObject(Seq("email" -> JsString("ala")))))
      val expectedFilterDefinition = FilterDefinition(
        take = None,
        skip = None,
        orderBy = None,
        data = Seq(Some("ala"), None, None, None, None))
      val jsonFormatter: JsonFormatter[UserMachineViewRow] = filter.formatter

      //when
      val builtFilterDefinition: JsResult[FilterDefinition] = jsonFormatter.filterDefinition(jsonFilterData)

      //then
      builtFilterDefinition shouldEqual JsSuccess(expectedFilterDefinition)
  }

  it should "create json definition correctly" in rollbackWithModel {
    implicit session =>

      lazy val filter = createFilter(name => s"Label: $name")

      val definition = filter.formatter.jsonDefinition

      println(definition)

      def stringValue(on: JsObject, name: String) = (on \ name).get match {
        case JsString(value) => value
        case _ => fail(s"Field $name fro $on is not string!")
      }

      definition match {
        case JsArray(values) =>
          values.foreach {
            case v: JsObject =>
              s"Label: ${stringValue(v, "key")}" shouldEqual stringValue(v, "label")
            case _ => fail("definition must contains objects")
          }
        case _ => fail("definition must be a array")
      }

  }
}
