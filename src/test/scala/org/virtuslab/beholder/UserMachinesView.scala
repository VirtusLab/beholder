package org.virtuslab.beholder

import org.virtuslab.beholder.model.{Machines, UserMachines, Users}
import org.virtuslab.beholder.views.FilterableViews
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.Config.driver.QueryExecutor
import scala.slick.lifted.TableQuery

/**
 * Author: Krzysztof Romanowski
 */
trait UserMachinesView extends ModelIncluded {
  self: AppTest =>

  case class UserMachineView(email: String,
                             system: String,
                             cores: Int)


  def createUsersMachineView(implicit session: Session) = {
    //query that is a base for view
    val usersMachinesQuery = for {
      user <- UsersRepository.query
      userMachine <- userMachineQuery if user.id === userMachine.userId
      machine <- MachineRepository.query if machine.id === userMachine.machineId
    } yield (user, machine)


    val tableQuery = FilterableViews.createView(name = "USERS_MACHINE_VIEW",
      apply = UserMachineView.apply _,
      unapply = UserMachineView.unapply _,
      baseQuery = usersMachinesQuery) {
      case (user, machine) =>
        //naming the fields
        ("email" -> user.email,
          "system" -> machine.system,
          "cores" -> machine.cores)
    }


    tableQuery.viewDDL.create

    tableQuery
  }
}
