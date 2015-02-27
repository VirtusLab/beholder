package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.json.JsonFilterFields
import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.suites.FiltersTestSuite
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

class DslTests extends AppTest with FiltersTestSuite[Unit] {
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

  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    import data._
    filter.filterWithTotalEntitiesNumber(currentFilter).content
  }
}