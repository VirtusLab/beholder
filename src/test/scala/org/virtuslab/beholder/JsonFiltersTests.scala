package org.virtuslab.beholder

import org.virtuslab.beholder.suites.{ RangeFiltersSuite, FiltersTestSuite, BaseSuite }
import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.filters.json.{ JsonFilterFields, JsonFilters, JsonFormatter }
import play.api.libs.json.JsObject
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import java.sql.Date
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.filters.json.JsonFilterFields.inOptionRange
import org.virtuslab.beholder.filters.json.JsonFilterFields.inRange
import play.api.libs.json.JsObject
import scala.Some
import org.virtuslab.beholder.filters.json.JsonFilterFields.inIntField

trait JsonFiltersTestsBase {
  self: AppTest with BaseSuite[JsonFormatter[UserMachineViewRow]] =>

  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    import data._
    val result = filter.filter(currentFilter)

    filter.formatter.results(currentFilter, result) match {
      case JsObject(Seq(("filter", jsonFilter), _)) =>
        filter.formatter.filterDefinition(jsonFilter) should equal(Some(currentFilter))
    }

    result
  }
}

class JsonFiltersTests extends AppTest with FiltersTestSuite[JsonFormatter[UserMachineViewRow]] with JsonFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow].create(
      data.view,
      inText,
      inText,
      inIntField,
      inRange(inField[Date]("date")),
      JsonFilterFields.ignore[Option[BigDecimal]]
    )
}

class JsonFiltersRangeTests extends AppTest with RangeFiltersSuite[JsonFormatter[UserMachineViewRow]] with JsonFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow].create(
      data.view,
      inText,
      inText,
      inRange(inIntField),
      inRange(inField[Date]("date")),
      inOptionRange(inField[BigDecimal]("number"))
    )
}