package org.virtuslab.beholder.suites

import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.model.MachineStatus
import scala.concurrent.ExecutionContext.Implicits.global

trait SeqFilterTestSuite[Formatter] extends BaseSuite[Formatter] {
  self: AppTest =>

  it should "filter by seq(int) only users with one and four core machines" in baseFilterTest {
    data =>
      import data._
      val usersWithOneOrFourCore = Some(Seq(1, 4))
      for {
        all <- allFromDb
        usersWithOneOrFourCoreMachines <- doFilters(data, baseFilter.copy(data = baseFilterData.updated(2, usersWithOneOrFourCore)))
      } yield {
        usersWithOneOrFourCoreMachines should contain theSameElementsAs all
      }
  }

  it should "filter by seq(int) only users with one and three core machine" in baseFilterTest {
    data =>
      import data._
      val oneOrThreeCore = Some(Seq(1, 3))
      for {
        all <- allFromDb
        usersWithOneOrThreeCoreMachines <- doFilters(data, baseFilter.copy(data = baseFilterData.updated(2, oneOrThreeCore)))
      } yield {
        usersWithOneOrThreeCoreMachines should contain theSameElementsAs all.filter(machine => machine.cores == 1 || machine.cores == 3)
      }
  }

  it should "filter by seq(enum) all users together with inactive and broken machines" in baseFilterTest {
    data =>
      import data._
      val inactiveAndBroken = Some(Seq(MachineStatus.Inactive, MachineStatus.Broken))
      for {
        all <- allFromDb
        usersWithInactiveAndBrokenMachines <- doFilters(data, baseFilter.copy(data = baseFilterData.updated(5, inactiveAndBroken)))
      } yield {
        usersWithInactiveAndBrokenMachines.size should be(2)
        usersWithInactiveAndBrokenMachines should contain theSameElementsAs all.filter(machine => machine.status == MachineStatus.Inactive)
      }
  }
}
