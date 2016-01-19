package org.virtuslab.beholder.suites

import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.model.MachineStatus

trait SeqFilterTestSuite[Formatter] extends BaseSuite[Formatter] {
  self: AppTest =>

  it should "filter by seq(int) only users with one and four core machines" in baseFilterTest {
    data =>
      import data._

      val a = baseFilter.data
      val usersWithOneOrFourCore = Some(Seq(1, 4))

      val usersWithOneOrFourCoreMachines = doFilters(data, baseFilter.copy(data = a.updated(2, usersWithOneOrFourCore)))

      usersWithOneOrFourCoreMachines should contain theSameElementsAs allFromDb
  }

  it should "filter by seq(int) only users with one and three core machine" in baseFilterTest {
    data =>
      import data._

      val a = baseFilter.data
      val oneOrThreeCore = Some(Seq(1, 3))

      val usersWithOneOrThreeCoreMachines = doFilters(data, baseFilter.copy(data = a.updated(2, oneOrThreeCore)))

      usersWithOneOrThreeCoreMachines should contain theSameElementsAs allFromDb.filter(machine => machine.cores == 1 || machine.cores == 3)
  }

  it should "filter by seq(enum) all users together with inactive and broken machines" in baseFilterTest {
    data =>
      import data._

      val a = baseFilter.data
      val inactiveAndBroken = Some(Seq(MachineStatus.Inactive, MachineStatus.Broken))

      val usersWithInactiveAndBrokenMachines = doFilters(data, baseFilter.copy(data = a.updated(5, inactiveAndBroken)))

      usersWithInactiveAndBrokenMachines.size should be(2)
      usersWithInactiveAndBrokenMachines should contain theSameElementsAs allFromDb.filter(machine => machine.status == MachineStatus.Inactive)
  }

}
