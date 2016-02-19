package org.virtuslab.beholder.suites

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.filters._

trait FiltersTestSuite extends BaseSuite {
  self: AppTest =>

  /*
    UserMachineViewRow(a@a.pl,Ubuntu,4,2014-12-05,Some(1.00))
    UserMachineViewRow(o@a.pl,Ubuntu,4,2014-12-05,Some(1.00))
    UserMachineViewRow(o@a.pl,Fedora,1,2014-12-05,Some(3.00))
   */

  it should "query all entities for empty filter" in baseFilterTest {
    data =>
      import data._
      val all = doFilters(data, baseFilter)

      all should contain theSameElementsAs allFromDb
  }

  it should "order by argument asc correctly" in baseFilterTest {
    data =>
      import data._

      val fromDbOrderedByCores = allFromDb.sortBy(view => (view.cores, view.email))
      val orderByCore = doFilters(data, baseFilter.copy(orderBy = Seq(Order("cores", asc = true))))

      orderByCore should contain theSameElementsInOrderAs fromDbOrderedByCores
  }

  it should "order by argument desc correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = doFilters(data, baseFilter.copy(orderBy = Seq(Order("cores", asc = false))))
      val fromDbOrderedByCoresDesc = allFromDb.sortBy(view => (-view.cores, view.email))

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc
  }

  it should "take correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = doFilters(data, baseFilter.copy(orderBy = Seq(Order("cores", asc = false)), take = Some(2)))
      val fromDbOrderedByCoresDesc = allFromDb.sortBy(view => (-view.cores, view.email))

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.take(2)
  }

  it should "skip correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = doFilters(data, baseFilter.copy(orderBy = Seq(Order("cores", asc = false)), skip = Some(1)))
      val fromDbOrderedByCoresDesc = allFromDb.sortBy(view => (-view.cores, view.email))

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
  }

  it should "filter by int field" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = doFilters(data, updatedDefinition("cores", 2))
      val fromDbOrderedByCoresDesc = allFromDb.filter(_.cores == 2)

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
  }

  //h2db does not have ilike operator
  ignore should "filter by string field" in baseFilterTest {
    data =>
      import data._
      val newSystem = "buntu"
      val orderByCoreDesc = doFilters(data, updatedDefinition("system", newSystem))
      val fromDbOrderedByCoresDesc = allFromDb.filter(_.system.contains(newSystem))

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
  }

  it should "not crash for date option" in baseFilterTest {
    data =>
      import data._
      val toDate = new Date(DateTime.now().minusHours(24).getMillis)
      val dataRange = FilterRange(None, Some(toDate))

      val newVersion = updatedDefinition("created", dataRange)
      val fromdbWithCorrectDates = allFromDb.filter(_.created.before(toDate))

      val withCorrectDates = doFilters(data, newVersion)
      withCorrectDates should contain theSameElementsInOrderAs fromdbWithCorrectDates
  }

  it should "skip correctly and return correct total amount of entities" in baseFilterTest {
    data =>
      import data._

      val filterData = filter.filterWithTotalEntitiesNumber(
        baseFilter.copy(orderBy = Seq(Order("cores", asc = false)), skip = Some(1)))
      val fromDbOrderedByCoresDesc = allFromDb.sortBy(view => (-view.cores, view.email))

      filterData.content should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)

      filterData.total shouldEqual allFromDb.size

  }
}