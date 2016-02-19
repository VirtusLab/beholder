package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.view.{UserMachineViewRow, UserMachinesView}
import org.virtuslab.beholder.{AppTest, BaseTest}
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

trait BaseSuite extends UserMachinesView {

  def testResults(data: BaseFilterData, definition: FilterDefinition, expected: Seq[UserMachineViewRow], totalCount: Int)

  protected def baseFilterTest[A](testImplementation: BaseFilterData => A) = rollbackWithModel {
    implicit session: Session =>
      testImplementation(new BaseFilterData())
  }



  protected class BaseFilterData(implicit val session: Session) extends PopulatedDatabase {

    case class filtering(query: FilterDefinition) {
      def shouldResultIn(expected: Seq[UserMachineViewRow]): Unit = {
        //val result = doFullFilter(BaseFilterData.this, fromFilter)

        val dropedAndSkiped = {
          val dropped = expected.drop(query.skip.getOrElse(0))
          query.take.map(dropped.take).getOrElse(dropped)
        }

        testResults(BaseFilterData.this, query, dropedAndSkiped, expected.size)
      }
    }

    val view = createUsersMachineView

    def updatedDefinition(field: String, value: Any, definition: FilterDefinition = FilterDefinition.empty) =
      definition.copy(
        constrains = definition.constrains.copy(
          fieldConstrains = definition.constrains.fieldConstrains + (field -> value)
        )
      )

    def addJoin(name: String, constrains: FilterConstrains, definition: FilterDefinition = FilterDefinition.empty) =
      definition.copy(
        constrains = definition.constrains.copy(
          nestedConstrains = definition.constrains.nestedConstrains + (name -> constrains)
        )
      )

    lazy val allUserMachineRows: Seq[UserMachineViewRow] = view.list

    lazy val allProjects: Seq[Project] = TableQuery[Projects].list
  }
}
