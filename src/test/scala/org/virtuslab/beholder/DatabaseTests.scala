package org.virtuslab.beholder

import org.virtuslab.beholder.model._
import org.virtuslab.beholder.view.UserMachinesView
import slick.lifted.TableQuery

class DatabaseTests extends AppTest with UserMachinesView {
  "tables" should "be populated" in rollbackWithModel {
    implicit session =>

      val data = new PopulatedDatabase
      import data._

      userMachineQuery.list should contain theSameElementsAs userMachines
      TableQuery[Users].list should contain theSameElementsAs users
      TableQuery[MachineParameters].list should contain theSameElementsAs machineParameters
      TableQuery[Teams].list should contain theSameElementsAs teams
      // Since big decimal are not easily comparable after return for db we compare only size here
      TableQuery[Machines].list.size shouldEqual machines.size
  }
}
