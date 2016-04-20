package org.virtuslab.beholder.suites

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.filters._
import scala.concurrent.ExecutionContext.Implicits.global

trait FiltersTestSuite[Formatter] extends BaseSuite[Formatter] {
  self: AppTest =>

  it should "query all entities for empty filter" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        allFromFilter <- doFilters(data, baseFilter)
      } yield {
        allFromFilter should contain theSameElementsAs all
      }
  }

  it should "order by argument asc correctly" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        orderByCore <- doFilters(data, baseFilter.copy(orderBy = Some(Order("cores", asc = true))))
      } yield {
        val fromDbOrderedByCores = all.sortBy(view => (view.cores, view.email))
        orderByCore should contain theSameElementsInOrderAs fromDbOrderedByCores
      }
  }

  it should "order by argument desc correctly" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(data, baseFilter.copy(orderBy = Some(Order("cores", asc = false))))
      } yield {
        val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc
      }
  }

  it should "take correctly" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(data, baseFilter.copy(orderBy = Some(Order("cores", asc = false)), take = Some(2)))
      } yield {
        val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.take(2)
      }
  }

  it should "skip correctly" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(data, baseFilter.copy(orderBy = Some(Order("cores", asc = false)), skip = Some(1)))
      } yield {
        val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
      }
  }

  it should "filter by int field" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(data, baseFilter.copy(data = baseFilter.data.updated(2, Some(2))))
      } yield {
        val fromDbOrderedByCoresDesc = all.filter(_.cores == 2)
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
      }
  }

  //h2db does not have ilike operator
  ignore should "filter by string field" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        orderByCoreDesc <- doFilters(data, baseFilter.copy(data = baseFilter.data.updated(1, Some("buntu"))))
      } yield {
        val fromDbOrderedByCoresDesc = all.filter(_.system.contains("buntu"))
        orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
      }
  }

  ignore should "filter by BigDecimal field" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        filteredData <- doFilters(data, baseFilter.copy(data = baseFilter.data.updated(4, Some(BigDecimal(1.0)))))
      } yield {
        val fromDbFiltered = all.filter(_.capacity.contains(BigDecimal(1.0)))
        filteredData should contain theSameElementsInOrderAs fromDbFiltered
      }
  }

  it should "not crash for date option" in baseFilterTest {
    data =>
      import data._
      val toDate = new Date(DateTime.now().minusHours(24).getMillis)
      val dataRange = Some(FilterRange(None, Some(toDate)))

      val newVersion = baseFilter.copy(data = baseFilterData.updated(3, dataRange))
      for {
        all <- allFromDb
        withCorrectDates <- doFilters(data, newVersion)
      } yield {
        val fromDbWithCorrectDates = all.filter(_.created.before(toDate))
        withCorrectDates should contain theSameElementsInOrderAs fromDbWithCorrectDates
      }
  }

  it should "skip correctly and return correct total amount of entities" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        filterData <- filter.filterWithTotalEntitiesNumber(baseFilter.copy(orderBy = Some(Order("cores", asc = false)), skip = Some(1)))
      } yield {
        val fromDbOrderedByCoresDesc = all.sortBy(view => (-view.cores, view.email))
        filterData.content should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
        filterData.total shouldEqual all.size
      }
  }
}