package org.virtuslab.beholder.suites

import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.model.MachineStatus
import scala.concurrent.ExecutionContext.Implicits.global

trait EnumFilterTestSuite[Formatter] extends BaseSuite[Formatter] {
  self: AppTest =>

  it should "filter all users with inactive machines" in baseFilterTest {
    data =>
      import data._

      val inactive = Some(MachineStatus.Inactive)
      val usersWithInactiveMachinesAction = doFilters(data, baseFilter.copy(data = baseFilterData.updated(5, inactive)))
      for {
        all <- allFromDb
        usersWithInactiveMachines <- usersWithInactiveMachinesAction
      } yield {
        usersWithInactiveMachines should contain theSameElementsAs all.filter(machine => machine.status == MachineStatus.Inactive)
      }
  }
}
