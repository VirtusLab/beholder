package org.virtuslab.beholder

import org.virtuslab.beholder.filters.FilterField._
import org.virtuslab.beholder.filters._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.data.format.Formats._
import org.virtuslab.unicorn.LongUnicornPlay._
import java.sql.Date

class RangeFiltersTest extends AppTest with UserMachinesView {

  private def userMachineFilter()(implicit session: Session) = {
    val view = createUsersMachineView
    new CustomTypeMappers {
      val filterGenerator = new FiltersGenerator[UserMachineView].create(view,
        inText,
        inText,
        inRange[Int],
        inRange[Date],
        inOptionRange[BigDecimal]
      )
    }.filterGenerator
  }

  private def baseFilterTest[A](testImplementation: BaseFilterData => A) = rollbackWithModel {
    implicit session: Session =>
      testImplementation(new BaseFilterData())
  }

  private class BaseFilterData(implicit val session: Session) extends PopulatedDatabase {
    val filter = userMachineFilter()
    val baseFilter = filter.emptyFilterData
    val baseFilterData = baseFilter.data

    val allFromDb = filter.table.list
  }

  behavior of "range filters"

  it should "should take int range correctly" in baseFilterTest {
    data =>
      import data._

      val a = baseFilter.data
      val coreRange = Some((Some(1), Some(4)))

      val coreRangeData = filter.filter(baseFilter.copy(data = a.copy(_3 = coreRange)))

      coreRangeData should contain theSameElementsAs allFromDb
  }

}
