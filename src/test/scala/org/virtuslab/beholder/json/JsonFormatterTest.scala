package org.virtuslab.beholder.json

import java.sql.Date

import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.filters.json.{ JsonFormatter, JsonFilterFields, JsonFilters }
import org.virtuslab.beholder.{ UserMachineViewRow, _ }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.json.{ JsArray, JsObject, JsString }

trait BaseJsonFormatterTest extends AppTest with UserMachinesView with ModelIncluded {

  behavior of "JsonFormatter"

  def createFilter(labels: String => String)(implicit session: Session): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]]

  it should "parse data correctly" in rollbackWithModel {
    implicit session =>

      lazy val filter = createFilter(identity)

      val req = JsObject(Seq("data" -> JsObject(Seq("email" -> JsString("ala")))))

      val data = FilterDefinition(None, None, None, Seq(Some("ala"), None, None, None, None))

      filter.formatter.filterDefinition(req) shouldEqual Some(data)
  }

  it should "create json definition correctly" in rollbackWithModel {
    implicit session =>

      lazy val filter = createFilter(name => s"Label: $name")

      val definition = filter.formatter.jsonDefinition

      println(definition)

      def stringValue(on: JsObject, name: String) = on \ name match {
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

class JsonFormatterTest extends BaseJsonFormatterTest {
  override def createFilter(labels: String => String)(implicit session: Session): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] = {
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
}

class JsonDslFormatterTest extends BaseJsonFormatterTest {

  import org.virtuslab.beholder.filters.dsl.JsonDSL._

  override def createFilter(labels: String => String)(implicit session: Session): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] = {
    create(usersMachinesQuery) {
      case (user, machine) =>
        "email" from user.email as inText and
          "system" from machine.system as inText and
          "cores" from machine.cores as inIntField and
          "created" from machine.created as inRange(inField("date")) and
          "capacity" from machine.capacity as JsonFilterFields.ignore
    }.jsonFormatted(UserMachineViewRow.tupled, labels)
  }
}