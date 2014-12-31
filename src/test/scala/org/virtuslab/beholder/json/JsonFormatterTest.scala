package org.virtuslab.beholder.json

import org.virtuslab.beholder._
import org.virtuslab.beholder.filters.json.{JsonFilterFields, JsonFilters, JsonFormatter}
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import java.sql.Date
import org.virtuslab.beholder.UserMachineViewRow
import org.virtuslab.beholder.suites.BaseSuite
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.json.{JsString, JsObject}
import org.virtuslab.beholder.filters.FilterDefinition

/**
 * Author: Krzysztof Romanowski
 */
class JsonFormatterTest extends AppTest with UserMachinesView with ModelIncluded {

  behavior of "JsonFormatter"

  it should "parse data corrently" in rollbackWithModel {
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

      val data = FilterDefinition(None, None, None, Seq(Some("ala")))

      data should equal(data)
  }
}
