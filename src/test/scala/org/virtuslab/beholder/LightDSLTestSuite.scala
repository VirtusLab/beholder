package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.suites._
import org.virtuslab.beholder.view.UserMachineViewRow
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

class LightDSLJoinFiltersTests extends AppTest with JoinSuite {
  import LightDSLFilter._

  //TODO test table based filter
  //TODO test different DSLs

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

class LightDSLFiltersTests extends AppTest with FiltersTestSuite with DefaultCollectorTest {
  override def createFilter(data: BaseFilterData) = {
    import LightDSLFilter._

    fromView(data.view) and
      "email" as in[String] and
      "system" as in[String] and
      "cores" as in[Int] and
      "created" as in[Date] and
      "capacity" as in[BigDecimal]
  }
}
/*

class LightDSLQueryFiltersTests extends AppTest with FiltersTestSuite with MappedCollectorTest[(User, Machine)]  {
  def createFilter(data: BaseFilterData) = {
    import LightDSLFilter._

    fromTable(userJoinMachinesQuery)(_._1.email) and
      "email" as in[String] from (_._1.email) and
      "system" as in[String] from (_._2.system) and
      "cores" as in[Int] from (_._2.cores) and
      "created" as in[Date] from (_._2.created) and
      "capacity" as in[BigDecimal] fromOpt (_._2.capacity)
  }

  private def toMachineViewRow(data: (User, Machine)): UserMachineViewRow = {
    val  (user, machine) = data

    UserMachineViewRow(
        user.email,
        machine.system,
        machine.cores,
        machine.created,
        machine.capacity,
        user.id.get,
        machine.id.get
      )
  }

  override def compare(data: BaseFilterData, fromFilter: Seq[(User, Machine)], expected: Seq[UserMachineViewRow]): Unit = {
    fromFilter.map(toMachineViewRow) should contain theSameElementsAs expected
  }
}*/
/*
class LightDSLAggregationFiltersTests extends AppTest with AggregationTestSuite {
  override def createUserMachinesFilter(data: BaseFilterData): FilterAPI[Aggregated[UserMachineViewRow, MachineParameter]] = {
    import LightDSLFilter._


    fromTable(userJoinMachinesQuery)(_._1.email) and
      "email" as in[String] from (_._1.email) and
      "system" as in[String] from (_._2.system) and
      "cores" as in[Int] from (_._2.cores) and
      "created" as in[Date] from (_._2.created) and
      "capacity" as in[BigDecimal] fromOpt (_._2.capacity) collector {
        new InMemoryAggregator(TableQuery[MachineParameters])(_.c ==)
    }

  }
}*/
