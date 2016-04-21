package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.LightDSLFilter._
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.suites._
import org.virtuslab.beholder.view.UserMachineViewRow
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

class LightDSLJoinFiltersTests extends AppTest with JoinSuite {
  import LightDSLFilter._

  //TODO  #36 test table based filter
  //TODO  #36 test different DSLs forms

  override def createTeamFilter(data: BaseFilterData) = create {
    fromTable(TableQuery[Teams])(_.teamName) and
      "teamName" from (_.teamName) and
      "system" from (_.system)
  }

  override def createBaseFilter(data: BaseFilterData) = create {
    fromView(data.view) and
      "email" as in[String] and
      "system" as in[String] and
      "cores" as in[Int] and
      "created" as in[Date] and
      "capacity" as in[BigDecimal]
  }
}

class LightDSLFiltersTests extends AppTest with FiltersTestSuite with ViewBasedTest {
  override def createConsumer(data: BaseFilterData) = {
    import LightDSLFilter._

    fromView(data.view) and
      "email" as in[String] and
      "system" as in[String] and
      "cores" as in[Int] and
      "created" as in[Date] and
      "capacity" as in[BigDecimal] list
  }
}


class LightDSLQueryFiltersTests extends AppTest with FiltersTestSuite with QueryBasedTest {

  override def createConsumer(data: BaseFilterData): FilterConsumer[(User, Machine)] = {
    import LightDSLFilter._


    val filter = fromTable(userJoinMachinesQuery)(_._1.email) and
      "email" from (_._1.email) and
      "system" from (_._2.system) and
      "cores" from (_._2.cores) and
      "created" from (_._2.created) and
      "capacity" fromOpt (_._2.capacity)

    val anotherForm = fromTable(userJoinMachinesQuery)(_._1.email) and
      "email" as in[String] from (_._1.email) and
      "system" as in[String] from (_._2.system) and
      "cores" as in[Int] from (_._2.cores) and
      "created" as in[Date] from (_._2.created) and
      "capacity" as in[BigDecimal] fromOpt (_._2.capacity)

    anotherForm.aggregatedAs(
      _.joinLeft(TableQuery[MachineParameters]).on(_._2.id === _.machine)
    )

    filter.list
  }
}

class LightDSLAggregationFiltersTests extends AppTest with FiltersTestSuite with AggregationBased  {
  override def createConsumer(data: BaseFilterData) = {
    fromView(data.view) and
      "email" as in[String] and
      "system" as in[String] and
      "cores" as in[Int] and
      "created" as in[Date] and
      "capacity" as in[BigDecimal] aggregatedAs(
      _.joinLeft(TableQuery[MachineParameters]).on(_.c7 === _.machine)
    )
  }

}
