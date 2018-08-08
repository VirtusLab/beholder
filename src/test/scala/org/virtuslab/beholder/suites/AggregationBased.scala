package org.virtuslab.beholder.suites

//TODO #37 Create aggregation collector tests

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.model.MachineParameter
import org.virtuslab.beholder.view.UserMachineViewRow

trait AggregationBased extends ConsumerBaseTest[Aggregated[UserMachineViewRow, MachineParameter]] {
  self: BaseSuite =>
  override def compare(data: BaseFilterData,
    collected: Seq[Aggregated[UserMachineViewRow, MachineParameter]],
    expected: Seq[UserMachineViewRow]): Unit = {

    collected.map(_.from) should contain theSameElementsInOrderAs expected

    collected.foreach {
      case Aggregated(userMachine, parameters) =>
        val expectedParameters = data.testMachineParameters.filter(_.machine == userMachine.machineId)

        parameters should contain theSameElementsAs expectedParameters
    }
  }
}
