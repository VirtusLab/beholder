package org.virtuslab.beholder.json

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.consumers.json.JsonDefinitionFormatter
import org.virtuslab.beholder.view.UserMachinesView
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import org.virtuslab.beholder.{AppTest, ModelIncluded}
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.filters.json._
import play.api.libs.json._

class FormatterTestSuite extends AppTest with UserMachinesView with ModelIncluded {

  import org.virtuslab.beholder.filters.json.JsonDSL._

  //TODO test ranges, and alternatives for all fields

  private def createFilter(labels: String => String)(implicit session: Session) = {
    val view = createUsersMachineView
    fromView(view) and
      "email" as in[String] and
      "system" as in[String] and
      "cores" as in[Int] and
      "created" as in[Date] and
      "capacity" as in[BigDecimal]
  }

  private def createFormat(labels: String => String)(implicit session: Session) =
    JsonDefinitionFormatter.formatFor(createFilter(labels))

  private def createJson(fields: (String, JsValue)*) =
    JsObject(Seq("data" -> JsObject(fields.toSeq)))

  private def createFilterDefinition(constrains: FilterConstrains => FilterConstrains) =
    FilterDefinition.empty.copy(constrains = constrains(FilterConstrains()))

  private def testFailure(format: Format[FilterDefinition])(js: JsValue) = {
    val result = format.reads(js)
    result.isError shouldEqual true
  }

  private def testFormat(format: Format[FilterDefinition])(js: JsValue, filter: FilterDefinition) = {
    val filterFromJs = format.reads(js)

    filterFromJs shouldEqual JsSuccess(filter)

    val jsFromFilter = format.writes(filter)

    jsFromFilter shouldEqual (js)
  }

  it should "create filter definition from range fields" in rollbackWithModel {
    implicit session =>
      val format = createFormat(identity)

      def testRange(from: Option[String], to: Option[String]) = {
        val rangeJs = JsObject(Seq("from" -> from, "to" -> to).collect { case (name, Some(value)) => name -> JsString(value) })
        val js = createJson("system" -> rangeJs)

        val filter = createFilterDefinition(_.addFieldConstrain("system")(FilterRange(from, to)))
        testFormat(format)(js, filter)
      }

      testRange(Some("a"), Some("b"))
      testRange(Some("a"), None)
      testRange(None, Some("b"))
  }

  it should "create filter definition from json defining data field" in rollbackWithModel {
    implicit session =>
      val format = createFormat(identity)

      def testFilterFormatter(data: (String, (Any, JsValue))*)(implicit session: Session) = {
        val forJson = data.map(d => d._1 -> d._2._2)
        val forDefinion = data.map(d => d._1 -> d._2._1)

        val json = createJson(forJson: _*)
        val definition = createFilterDefinition {
          filter =>
            forDefinion.foldLeft(filter) {
              case (filter, (name, value)) =>
                filter.addFieldConstrain(name)(value)
            }
        }

        testFormat(format)(json, definition)
      }

      testFilterFormatter(
        "email" -> ("ala" -> JsString("ala"))
      )

      testFilterFormatter(
        "cores" -> (1 -> JsNumber(1))
      )

      val capacity: BigDecimal = 2

      testFilterFormatter(
        "capacity" -> (capacity -> JsNumber(capacity))
      )

      val date = new Date(DateTime.now().withTimeAtStartOfDay.getMillis)
      val dateFormatter = implicitly[Format[Date]]

      testFilterFormatter(
        "created" -> (date -> dateFormatter.writes(date))
      )

      testFilterFormatter(
        "capacity" -> (capacity -> JsNumber(capacity)),
        "cores" -> (1 -> JsNumber(1)),
        "email" -> ("ala" -> JsString("ala")),
        "created" -> (date -> dateFormatter.writes(date))
      )
  }

  it should "fail on bad filter field definition" in rollbackWithModel {
    implicit session =>
      val format = createFormat(identity)

      testFailure(format)(createJson("cores" -> JsString("")))

      testFailure(format)(createJson("cores2" -> JsString("")))
  }

  it should "read standard fields in filter" in rollbackWithModel {
    implicit session =>
      val format = createFormat(identity)

      val js = JsObject(Seq(
        "take" -> JsNumber(1),
        "skip" -> JsNumber(2)
      ))

      val expected = FilterDefinition.empty.copy(take = Some(1), skip = Some(2))

      testFormat(format)(js, expected)
  }

  it should "read order correctly" in rollbackWithModel {
    implicit session =>
      val format = createFormat(identity)

      def filterWithOrdering(orderingDef: (String, JsValue)*) = JsObject(Seq("ordering" -> JsObject(orderingDef)))

      val withoutAscJs = filterWithOrdering("column" -> JsString("cores"))
      val withoutAscFilter = FilterDefinition.empty.withOrder("cores")

      testFormat(format)(withoutAscJs, withoutAscFilter)

      val desccJs = filterWithOrdering("column" -> JsString("cores"), "asc" -> JsBoolean(false))
      val descFilter = FilterDefinition.empty.withOrder("cores", false)

      testFormat(format)(withoutAscJs, withoutAscFilter)

      val onNonExisting = filterWithOrdering("column" -> JsString("cores2"))

      testFailure(format)(onNonExisting)
  }

  //TODO test nested filters

  //TODO definition tests

}
