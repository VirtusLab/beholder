package org.virtuslab.beholder

import org.virtuslab.beholder.model.{Machines, UserMachines, Users}
import org.virtuslab.beholder.views.FilterableViews
import play.api.db.slick.Config.driver.simple._

/**
 * Author: Krzysztof Romanowski
 */
trait UserMachinesView {
  case class UserMachineView(email: String,
                             system: String,
                             cores: Int)


  def createUsersMachineView() = {
    val usersMachinesQuery = for {
      user <- Users
      userMachine <- UserMachines if user.id === userMachine.userId
      machine <- Machines if machine.id === userMachine.machineId
    } yield (user, machine)

    FilterableViews.createView("USERS_MACHINE_VIEW",
      UserMachineView.apply _,
      UserMachineView.unapply _,
      usersMachinesQuery) {
      case (user, machine) =>
        ("email" -> user.email,
          "system" -> machine.system,
          "cores" -> machine.cores)
    }
  }
}
