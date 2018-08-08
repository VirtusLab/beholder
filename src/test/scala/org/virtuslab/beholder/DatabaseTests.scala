package org.virtuslab.beholder

import org.virtuslab.beholder.model._
import org.virtuslab.beholder.view.UserMachinesView
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import play.api.libs.concurrent.Execution.Implicits._

class DatabaseTests extends AppTest with UserMachinesView {
  "tables" should "be populated" in rollbackWithModel {
    val data = new PopulatedDatabase
    import data._

    for {
      d <- data.populate
      userMachinesFromQuery <- UserMachines.query.result
      users <- Users.query.result
      machineParameters <- MachineParameters.query.result
      teams <- Teams.query.result
      machines <- Machines.query.result
    } yield {
      userMachinesFromQuery should contain theSameElementsAs testUserMachines
      users should contain theSameElementsAs testUsers
      machineParameters should contain theSameElementsAs testMachineParameters
      teams should contain theSameElementsAs testTeams
      // Since big decimal are not easily comparable after return for db we compare only size here
      machines.size shouldEqual testMachines.size
    }
  }
}
