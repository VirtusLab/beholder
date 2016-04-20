package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.{ AppTest, UserMachineViewRow, UserMachinesView }
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import scala.concurrent.ExecutionContext.Implicits.global

trait BaseSuite[Formatter] extends UserMachinesView {
  self: AppTest =>
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Formatter]

  protected def baseFilterTest[A](testImplementation: BaseFilterData => DBIO[A]) = rollbackActionWithModel {
    testImplementation(new BaseFilterData())
  }

  protected class BaseFilterData {

    val query = viewQuery
    lazy val filter = createFilter(this)
    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data
    lazy val allFromDb: DBIO[Seq[UserMachineViewRow]] =
      for {
        view <- createUsersMachineView()
        _ <- populatedDatabase
        all <- view.result
      } yield all
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): DBIO[Seq[UserMachineViewRow]]
}
