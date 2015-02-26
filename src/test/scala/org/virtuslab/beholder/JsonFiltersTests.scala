package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.dsl.{ JsonMacroFilters, JsonDslFilters }
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.filters.json.{ JsonFilterFields, JsonFilters, JsonFormatter }
import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.suites.{ BaseSuite, FiltersTestSuite, RangeFiltersSuite }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.json.JsObject

trait JsonFiltersTestsBase {
  self: AppTest with BaseSuite[JsonFormatter[UserMachineViewRow]] =>

  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    import data._
    val result = filter.filterWithTotalEntitiesNumber(currentFilter)

    filter.formatter.results(currentFilter, result) match {
      case JsObject(Seq(("filter", jsonFilter), _)) =>
        filter.formatter.filterDefinition(jsonFilter) should equal(Some(currentFilter))
    }

    result.content
  }
}

class JsonFiltersTests extends AppTest with FiltersTestSuite[JsonFormatter[UserMachineViewRow]] with JsonFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow](identity).create(
      data.view,
      inText,
      inText,
      inIntField,
      inRange(inField[Date]("date")),
      JsonFilterFields.ignore[Option[BigDecimal]]
    )
}

class JsonDslFiltersTests extends AppTest with FiltersTestSuite[JsonFormatter[UserMachineViewRow]] with JsonFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] = {

    val dsl = new JsonDslFilters[UserMachineViewRow](identity)

    val q = usersMachinesQuery.map {
      case (user, machine) =>
        //naming the fields
        (user.email, machine.system, machine.cores,
          machine.created,
          machine.capacity)
    }

    val names = Seq(
      "email",
      "system",
      "cores",
      "created",
      "capacity"
    )

    val fields = Seq(
      inText,
      inText,
      inIntField,
      inRange(inField[Date]("date")),
      JsonFilterFields.ignore[Option[BigDecimal]]
    )

    new dsl.DslFilter(q, fields, names, UserMachineViewRow.tupled)
  }
}

class JsonMacroDslFiltersTests extends AppTest with FiltersTestSuite[JsonFormatter[UserMachineViewRow]] with JsonFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] = {
    import org.virtuslab.beholder.filters.dsl.DSL._
    new JsonMacroFilters[UserMachineViewRow](identity).create(usersMachinesQuery) {
      case (user, machine) =>
        /* "email" as inText from user.email and
          "system" as inText from machine.system and
          "cores" as inIntField from machine.cores and*/
        "created" as inRange(inField[Date]("date")) from machine.created and
          "capacity" as JsonFilterFields.ignore[Option[BigDecimal]] from machine.capacity
    }
  }
}

class JsonFiltersRangeTests extends AppTest with RangeFiltersSuite[JsonFormatter[UserMachineViewRow]] with JsonFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, JsonFormatter[UserMachineViewRow]] =
    new JsonFilters[UserMachineViewRow](identity).create(
      data.view,
      inText,
      inText,
      inRange(inIntField),
      inRange(inField[Date]("date")),
      inOptionRange(inField[BigDecimal]("number"))
    )
}