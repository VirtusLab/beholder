package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.dsl.FilterFactory
import org.virtuslab.beholder.filters.json.{ JsonFormatter, JsonFilterFields }
import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.suites.FiltersTestSuite
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

abstract class DslTest extends AppTest with FiltersTestSuite[Unit] {
  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    import data._
    filter.filter(currentFilter)
  }
}

class LambdaDslTests extends DslTest {
  override def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Unit] = {
    import org.virtuslab.beholder.filters.dsl.DSL._
    create(usersMachinesQuery) {
      case (user, machine) =>
        "email" from user.email as inText and
          "system" from machine.system as inText and
          "cores" from machine.cores as inIntField and
          "created" from machine.created as inRange(inField[Date]("date")) and
          "capacity" from machine.capacity as JsonFilterFields.ignore
    }.mapped(UserMachineViewRow.tupled)
  }
}

class PartialFunctionDslTest extends DslTest {
  override def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Unit] = {
    import org.virtuslab.beholder.filters.dsl.DSL._
    create(usersMachinesQuery) {
      e =>
        "email" from e._1.email as inText and
          "system" from e._2.system as inText and
          "cores" from e._2.cores as inIntField and
          "created" from e._2.created as inRange(inField[Date]("date")) and
          "capacity" from e._2.capacity as JsonFilterFields.ignore[Option[BigDecimal]]
    }.mapped(UserMachineViewRow.tupled)
  }

}

class FilterFactoryTests extends DslTest {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Unit] = {

    val q = usersMachinesQuery.map {
      case (user, machine) =>
        (user.email, machine.system, machine.cores, machine.created, machine.capacity)
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

    FilterFactory.crate(q, fields, names).mapped(UserMachineViewRow.tupled)
  }
}
