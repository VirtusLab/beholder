package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters.{FilterConstrains, LightFilter, FilterAPI, FilterDefinition}
import org.virtuslab.beholder.views.BaseView
import org.virtuslab.beholder.{ AppTest, UserMachineViewRow, UserMachinesView }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

trait BaseSuite extends UserMachinesView {
  self: AppTest =>
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow]

  protected def baseFilterTest[A](testImplementation: BaseFilterData => A) = rollbackWithModel {
    implicit session: Session =>
      testImplementation(new BaseFilterData())
  }

  protected class BaseFilterData(implicit val session: Session) extends PopulatedDatabase {

    val view = createUsersMachineView

    lazy val filter = createFilter(this)

    lazy val baseFilter = FilterDefinition.empty

    def updatedDefinition(field: String, value: Any, definition: FilterDefinition = baseFilter) =
      definition.copy(
        constrains = definition.constrains.copy(
          fieldConstrains = definition.constrains.fieldConstrains + (field -> value)))

    def addJoin(name: String, constrains: FilterConstrains, definition: FilterDefinition = baseFilter) =
      definition.copy(
        constrains = definition.constrains.copy(
          nestedConstrains = definition.constrains.nestedConstrains + (name -> constrains)
        )
      )


    lazy val allFromDb = view.list
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    import data._

    val res = filter.filterWithTotalEntitiesNumber(currentFilter)
    res.content
  }
}
