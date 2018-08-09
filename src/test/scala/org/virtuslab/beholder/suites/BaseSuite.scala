package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.view.{ UserMachineViewRow, UserMachinesView }
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import scala.concurrent.ExecutionContext

trait BaseSuite extends UserMachinesView {

  def testResults(data: BaseFilterData, definition: FilterDefinition, expected: Seq[UserMachineViewRow], totalCount: Int): DBIO[Unit]

  protected def baseFilterTest[A](testImplementation: BaseFilterData => DBIO[A])(implicit ec: ExecutionContext) = rollbackWithModel {
    testImplementation(new BaseFilterData())
  }

  protected class BaseFilterData(implicit ec: ExecutionContext) extends PopulatedDatabase {

    case class filtering(query: FilterDefinition) {
      def shouldResultIn(expected: Seq[UserMachineViewRow]): DBIO[Unit] = {
        //val result = doFullFilter(BaseFilterData.this, fromFilter)

        val dropedAndSkiped = {
          val dropped = expected.drop(query.skip.getOrElse(0))
          query.take.map(dropped.take).getOrElse(dropped)
        }

        testResults(BaseFilterData.this, query, dropedAndSkiped, expected.size)
      }

    }

    val view = viewQuery

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
  }
}
