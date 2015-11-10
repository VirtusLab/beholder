package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.{ AppTest, UserMachineViewRow, UserMachinesView }
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

trait BaseSuite[Formatter] extends UserMachinesView {
  self: AppTest =>
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Formatter]

  protected def baseFilterTest[A](testImplementation: BaseFilterData => A) = rollbackWithModel {
    implicit session: Session =>
      testImplementation(new BaseFilterData())
  }

  protected class BaseFilterData(implicit val session: Session) extends PopulatedDatabase {

    val view = createUsersMachineView

    //Slick3Invoker.invokeAction(view.schema.create)

    lazy val filter = createFilter(this)

    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data

    lazy val allFromDb: Seq[UserMachineViewRow] = view.list
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow]
}
