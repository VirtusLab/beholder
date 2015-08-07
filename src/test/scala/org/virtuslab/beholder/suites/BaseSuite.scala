package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.{ AppTest, UserMachineViewRow, UserMachinesView }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

trait BaseSuite[Formatter] extends BaseSuiteData {
  self: AppTest =>

  def createFilter(data: FilterSetupData): FilterAPI[UserMachineViewRow, Formatter]

  protected def baseFilterTest[A](testImplementation: BaseFilterData => A) = rollbackWithModel {
    implicit session: Session =>
      testImplementation(new BaseFilterData())
  }
  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow]

  protected class BaseFilterData(implicit val session: Session) extends FilterSetupData {
    lazy val filter = createFilter(this)

    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data

    lazy val allFromDb: Seq[UserMachineViewRow] = view.list
  }
}

trait BaseSuiteData extends UserMachinesView {
  self: AppTest =>

  protected class FilterSetupData(implicit session: Session) extends PopulatedDatabase {
    val view = createUsersMachineView
  }
}
