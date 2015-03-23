package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.dsl.FilterFactory
import org.virtuslab.beholder.filters.json.JsonFilterFields
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
        "email" as inText from user.email and
          "system" as inText from machine.system and
          "cores" as inIntField from machine.cores and
          "created" as inRange(inField[Date]("date")) from machine.created and
          "capacity" as JsonFilterFields.ignore[Option[BigDecimal]] from machine.capacity
    }.mapped(UserMachineViewRow.tupled)
  }
}

class PartialFunctionDslTest extends DslTest {
  override def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Unit] = {
    import org.virtuslab.beholder.filters.dsl.DSL._
    create(usersMachinesQuery) {
      e =>
        "email" as inText from e._1.email and
          "system" as inText from e._2.system and
          "cores" as inIntField from e._2.cores and
          "created" as inRange(inField[Date]("date")) from e._2.created and
          "capacity" as JsonFilterFields.ignore[Option[BigDecimal]] from e._2.capacity
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
