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
    //query that is a base for view
    val usersMachinesQuery = for {
      user <- Users
      userMachine <- UserMachines if user.id === userMachine.userId
      machine <- Machines if machine.id === userMachine.machineId
    } yield (user, machine)


    FilterableViews.createView(name = "USERS_MACHINE_VIEW",
      apply = UserMachineView.apply _,
      unapply = UserMachineView.unapply _,
      baseQuery = usersMachinesQuery) {
      case (user, machine) =>
        //naming the fields
        ("email" -> user.email,
          "system" -> machine.system,
          "cores" -> machine.cores)
    }
  }
}
