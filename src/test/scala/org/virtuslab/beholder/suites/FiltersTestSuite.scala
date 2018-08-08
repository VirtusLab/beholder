package org.virtuslab.beholder.suites

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.view.UserMachinesView
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import scala.concurrent.ExecutionContext.Implicits.global

trait FiltersTestSuite extends BaseSuite with RangeFiltersSuite with UserMachinesView {

  // TODO #36 create tests for enums
  // TODO #36 create negative tests
  /*
    UserMachineViewRow(a@a.pl,Ubuntu,4,2014-12-05,Some(1.00))
    UserMachineViewRow(o@a.pl,Ubuntu,4,2014-12-05,Some(1.00))
    UserMachineViewRow(o@a.pl,Fedora,1,2014-12-05,Some(3.00))
   */

  it should "query all entities for empty filter" in baseFilterTest {
    data =>
      import data._
      for {
        _ <- createUsersMachineView
        userMachines <- viewQuery.result
      } yield {
        filtering(FilterDefinition.empty) shouldResultIn userMachines
      }
  }

  it should "order by argument asc correctly" in baseFilterTest {
    data =>
      import data._
      for {
        _ <- createUsersMachineView
        fromDbOrderedByCores <- viewQuery.result.map(_.sortBy(view => (view.cores, view.email)))
        orderByCore = FilterDefinition.empty.withOrder("cores")
      } yield {
        filtering(orderByCore) shouldResultIn fromDbOrderedByCores
      }
  }

  it should "order by argument desc correctly" in baseFilterTest {
    data =>
      import data._
      for {
        _ <- createUsersMachineView
        fromDbOrderedByCoresDesc <- viewQuery.result.map(_.sortBy(view => (-view.cores, view.email)))
        orderByCoreDesc = FilterDefinition.empty.withOrder("cores", asc = false)
      } yield {
        filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
      }
  }

  it should "take correctly" in baseFilterTest {
    data =>
      import data._
      for {
        _ <- createUsersMachineView
        fromDbOrderedByCoresDesc <- viewQuery.result.map(_.sortBy(view => (-view.cores, view.email)))
        orderByCoreDesc = FilterDefinition.empty.withOrder("cores", asc = false).copy(take = Some(2))
      } yield {
        filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
      }
  }

  it should "skip correctly" in baseFilterTest {
    data =>
      import data._
      for {
        _ <- createUsersMachineView
        fromDbOrderedByCoresDesc <- viewQuery.result.map(_.sortBy(view => (-view.cores, view.email)))
        orderByCoreDesc = FilterDefinition.empty.withOrder("cores", asc = false).copy(skip = Some(1))
      } yield {
        filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
      }
  }

  it should "filter by int field" in baseFilterTest {
    data =>
      import data._
      for {
        _ <- createUsersMachineView
        fromDbOrderedByCoresDesc <- viewQuery.result.map(_.filter(_.cores == 4))
        orderByCoreDesc = updatedDefinition("cores", 4)
      } yield {
        filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
      }
  }

  //h2db does not have ilike operator
  ignore should "filter by string field" in baseFilterTest {
    data =>
      import data._
      val newSystem = "buntu"
      for {
        _ <- createUsersMachineView
        fromDbOrderedByCoresDesc <- viewQuery.result.map(_.filter(_.system.contains(newSystem)))
        orderByCoreDesc = updatedDefinition("system", newSystem)
      } yield {
        filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
      }
  }

  it should "not crash for date option" in baseFilterTest {
    data =>
      import data._
      val toDate = new Date(DateTime.now().minusHours(24).getMillis)
      val dataRange = FilterRange(None, Some(toDate))
      for {
        _ <- createUsersMachineView
        fromdbWithCorrectDates <- viewQuery.result.map(_.filter(_.created.before(toDate)))
        newVersion = updatedDefinition("created", dataRange)
      } yield {
        filtering(newVersion) shouldResultIn fromdbWithCorrectDates
      }
  }
}