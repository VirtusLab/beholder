package org.virtuslab.beholder.suites

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.view.UserMachineViewRow

trait FiltersTestSuite extends BaseSuite with RangeFiltersSuite {

  // TODO add enums
  // TODO add negative tests
  /*
    UserMachineViewRow(a@a.pl,Ubuntu,4,2014-12-05,Some(1.00))
    UserMachineViewRow(o@a.pl,Ubuntu,4,2014-12-05,Some(1.00))
    UserMachineViewRow(o@a.pl,Fedora,1,2014-12-05,Some(3.00))
   */

  it should "query all entities for empty filter" in baseFilterTest {
    data =>
      import data._

      filtering(FilterDefinition.empty) shouldResultIn allUserMachineRows
  }

  it should "order by argument asc correctly" in baseFilterTest {
    data =>
      import data._

      val fromDbOrderedByCores = allUserMachineRows.sortBy(view => (view.cores, view.email))
      val orderByCore = FilterDefinition.empty.withOrder("cores")

      filtering(orderByCore) shouldResultIn fromDbOrderedByCores
  }

  it should "order by argument desc correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc =  FilterDefinition.empty.withOrder("cores", asc = false)
      val fromDbOrderedByCoresDesc = allUserMachineRows.sortBy(view => (-view.cores, view.email))

      filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
  }

  it should "take correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = FilterDefinition.empty.withOrder("cores", asc = false).copy(take = Some(2))
      val fromDbOrderedByCoresDesc = allUserMachineRows.sortBy(view => (-view.cores, view.email))

      filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
  }

  it should "skip correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = FilterDefinition.empty.withOrder("cores", asc = false).copy(skip = Some(1))
      val fromDbOrderedByCoresDesc = allUserMachineRows.sortBy(view => (-view.cores, view.email))

      filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
  }

  it should "filter by int field" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = updatedDefinition("cores", 4)
      val fromDbOrderedByCoresDesc = allUserMachineRows.filter(_.cores == 4)

      filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
  }

  //h2db does not have ilike operator
  ignore should "filter by string field" in baseFilterTest {
    data =>
      import data._
      val newSystem = "buntu"
      val orderByCoreDesc = updatedDefinition("system", newSystem)
      val fromDbOrderedByCoresDesc = allUserMachineRows.filter(_.system.contains(newSystem))

      filtering(orderByCoreDesc) shouldResultIn fromDbOrderedByCoresDesc
  }

  it should "not crash for date option" in baseFilterTest {
    data =>
      import data._
      val toDate = new Date(DateTime.now().minusHours(24).getMillis)
      val dataRange = FilterRange(None, Some(toDate))

      val newVersion = updatedDefinition("created", dataRange)
      val fromdbWithCorrectDates = allUserMachineRows.filter(_.created.before(toDate))

      filtering(newVersion) shouldResultIn fromdbWithCorrectDates
  }
}