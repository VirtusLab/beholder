package org.virtuslab.beholder.view

import java.sql.Date

import org.virtuslab.beholder.ModelIncluded
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.views.FilterableViews
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import scala.concurrent.ExecutionContext

case class UserMachineViewRow(
  email: String,
  system: String,
  cores: Int,
  created: Date,
  capacity: Option[BigDecimal],
  userId: UserId,
  machineId: MachineId)

trait UserMachinesView extends ModelIncluded {

  //query that is a base for view
  private lazy val usersMachinesQuery = for {
    user <- Users.query
    userMachine <- UserMachines.query if user.id === userMachine.userId
    machine <- Machines.query if machine.id === userMachine.machineId
  } yield (user, machine)

  private lazy val tableQuery = FilterableViews.createView(
    name = "USERS_MACHINE_VIEW",
    UserMachineViewRow.apply _,
    UserMachineViewRow.unapply _,
    baseQuery = usersMachinesQuery
  ) {
      case (user, machine) =>
        //naming the fields
        ("email" -> user.email,
          "system" -> machine.system,
          "cores" -> machine.cores,
          "created" -> machine.created,
          "capacity" -> machine.capacity,
          "userId" -> user.id,
          "machineId" -> machine.id
        )
    }

  def createUsersMachineView(implicit ec: ExecutionContext): DBIO[Unit] = {
    tableQuery.viewDDL.create
  }

  def dropUsersMachineView(implicit ec: ExecutionContext): DBIO[Unit] = {
    tableQuery.viewDDL.drop
  }

  lazy val viewQuery = tableQuery
}
