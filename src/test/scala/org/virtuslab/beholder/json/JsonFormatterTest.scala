package org.virtuslab.beholder.json

import java.sql.Date

import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.filters.json.{ JsonFilterFields, JsonFilters }
import org.virtuslab.beholder.{ UserMachineViewRow, _ }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.json.{ JsObject, JsString }

class JsonFormatterTest extends AppTest with UserMachinesView with ModelIncluded {

  behavior of "JsonFormatter"

  it should "parse data correctly" in rollbackWithModel {
    implicit session =>
      lazy val view = createUsersMachineView

      lazy val filter = new JsonFilters[UserMachineViewRow].create(
        view,
        inText,
        inText,
        inIntField,
        inRange(inField[Date]("date")),
        JsonFilterFields.ignore[Option[BigDecimal]]
      )

      val req = JsObject(Seq("data" -> JsObject(Seq("email" -> JsString("ala")))))

      val data = FilterDefinition(None, None, None, Seq(Some("ala"), None, None, None, None))

      filter.formatter.filterDefinition(req) shouldEqual Some(data)
  }
}
