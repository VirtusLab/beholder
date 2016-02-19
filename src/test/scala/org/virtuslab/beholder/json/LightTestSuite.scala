package org.virtuslab.beholder.json

import java.sql.Date

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.suites._
import org.virtuslab.beholder.view.UserMachineViewRow
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import org.virtuslab.beholder.filters.json.JsonDSL
import org.virtuslab.beholder._

class JsonDSLJoinFiltersTests extends AppTest with JoinSuite {
  import JsonDSL._

  override def createTeamFilter(data: BaseFilterData) =
      fromTable(TableQuery[Teams])(_.teamName) and
        "teamName" from (_.teamName) and
        "system" from (_.system) //TODO in Range

  override def createBaseFilter(data: BaseFilterData) =
      fromView(data.view) and
        "email" as in[String] and
        "system" as in[String] and
        "cores" as in[Int] and
        "created" as in[Date] and
        "capacity" as in[BigDecimal]
}

class JsonFiltersTests extends AppTest with FiltersTestSuite with DefaultCollectorTest  {
  def createFilter(data: BaseFilterData) = {
    import JsonDSL._

    fromView(data.view) and
      "email" as in[String] and
      "system" as in[String] and
      "cores" as in[Int] and
      "created" as in[Date] and
      "capacity" as in[BigDecimal]

  }
}