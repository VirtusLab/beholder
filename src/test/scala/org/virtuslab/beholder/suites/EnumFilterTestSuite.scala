package org.virtuslab.beholder.suites

import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.model.MachineStatus

trait EnumFilterTestSuite[Formatter] extends BaseSuite[Formatter] {
  self: AppTest =>

  it should "filter all users with inactive machines" in baseFilterTest {
    data =>
      import data._

      val a = baseFilter.data
      val inactive = Some(MachineStatus.Inactive)

      val usersWithInactiveMachines = doFilters(data, baseFilter.copy(data = a.updated(5, inactive)))

      //usersWithInactiveMachines.size should be(2)
      usersWithInactiveMachines should contain theSameElementsAs allFromDb.filter(machine => machine.status == MachineStatus.Inactive)
  }

}
