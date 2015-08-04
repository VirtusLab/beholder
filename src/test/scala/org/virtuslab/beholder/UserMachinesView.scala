package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.model.{ Machines, Users }
import org.virtuslab.beholder.views.FilterableViews
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

case class UserMachineViewRow(
  email: String,
  system: String,
  cores: Int,
  created: Date,
  capacity: Option[BigDecimal]
)

trait UserMachinesView extends ModelIncluded {
  self: AppTest =>

  lazy val usersMachinesQuery = for {
    user <- TableQuery[Users]
    userMachine <- userMachineQuery if user.id === userMachine.userId
    machine <- TableQuery[Machines] if machine.id === userMachine.machineId
  } yield (user, machine)

  def createUsersMachineView(implicit session: Session) = {
    //query that is a base for view
    new CustomTypeMappers {

      val tableQuery = FilterableViews.createView(
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
            "capacity" -> machine.capacity)
      }

      tableQuery.viewDDL.create
    }.tableQuery
  }
}
