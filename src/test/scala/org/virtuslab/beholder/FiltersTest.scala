package org.virtuslab.beholder

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.filters.FilterField._
import play.api.db.slick.Config.driver.simple._

class FiltersTest extends AppTest with UserMachinesView {

  def userMachineFilter()(implicit session: Session) = {
    val view = createUsersMachineView

    new FiltersGenerator[UserMachineView].create(view,
      inText,
      inText,
      inIntField
    )
  }

  def baseFilterTest[A](testImplementation: BaseFilterData => A) = rollbackWithModel {
    implicit session: Session =>
      testImplementation(new BaseFilterData())
  }

  class BaseFilterData(implicit val session: Session) extends PopulatedDatabase {
    val filter = userMachineFilter()
    val baseFilter = filter.emptyFilterData
    val baseFilterData = baseFilter.data

    val allFromDb = filter.table.list
  }

  "filter" should "query all entities for empty filter" in baseFilterTest {
    data =>
      import data._
      val all = filter.filter(baseFilter)

      all should contain theSameElementsAs allFromDb
  }

  "filter" should "order by argument asc correctly" in baseFilterTest {
    data =>
      import data._

      val fromDbOrderedByCores = allFromDb.sortBy(view => (view.cores, view.email))
      val orderByCore = filter.filter(baseFilter.copy(orderBy = Some("cores")))

      orderByCore should contain theSameElementsInOrderAs fromDbOrderedByCores
  }

  "filter" should "order by argument desc correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = filter.filter(baseFilter.copy(orderBy = Some("cores"), asc = false))
      val fromDbOrderedByCoresDesc = allFromDb.sortBy(view => (-view.cores, view.email))

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc
  }

  "filter" should "take correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = filter.filter(baseFilter.copy(orderBy = Some("cores"), asc = false, take = Some(2)))
      val fromDbOrderedByCoresDesc = allFromDb.sortBy(view => (-view.cores, view.email))

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.take(2)
  }

  "filter" should "skip correctly" in baseFilterTest {
    data =>
      import data._
      val orderByCoreDesc = filter.filter(baseFilter.copy(orderBy = Some("cores"), asc = false, skip = Some(1)))
      val fromDbOrderedByCoresDesc = allFromDb.sortBy(view => (-view.cores, view.email))

      orderByCoreDesc should contain theSameElementsInOrderAs fromDbOrderedByCoresDesc.drop(1)
  }
}