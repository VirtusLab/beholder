package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.filters.json.{ JsonFilterFields, JsonFilters, JsonFormatter }
import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.suites._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.json.{ JsSuccess, JsObject }

trait JsonFiltersTestsBase extends AppTest with BaseSuite[JsonFormatter[UserMachineViewRow]] {

  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    import data._
    val result = filter.filterWithTotalEntitiesNumber(currentFilter)

    filter.filterFormatter.results(currentFilter, result) match {
      case JsObject(Seq(("filter", jsonFilter), _)) =>
        filter.filterFormatter.filterDefinition(jsonFilter) should equal(JsSuccess(currentFilter))
    }

    result.content
  }
}

class JsonFiltersTests extends JsonFiltersTestsBase {
  def createFilter(data: FilterSetupData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow](identity).create(
      data.view,
      inText,
      inText,
      inIntField,
      inRange(inField[Date]("date")),
      JsonFilterFields.ignore[Option[BigDecimal]]
    )
}

class InitialFiltersJsonTests extends JsonFiltersTests with InitialQueryTestSuite[JsonFormatter[UserMachineViewRow]]

class ContextedFitlerJsonTests extends JsonFiltersTests with ContextedFitlerTestSuite[JsonFormatter[UserMachineViewRow]]

class JsonFiltersRangeTests extends JsonFiltersTestsBase {
  def createFilter(data: FilterSetupData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow](identity).create(
      data.view,
      inText,
      inText,
      inRange(inIntField),
      inRange(inField[Date]("date")),
      inOptionRange(inField[BigDecimal]("number"))
    )
}