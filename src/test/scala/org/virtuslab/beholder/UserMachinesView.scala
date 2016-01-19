package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.model.{ MachineStatus, Machines, Users }
import org.virtuslab.beholder.views.FilterableViews
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.json._

case class UserMachineViewRow(
  email: String,
  system: String,
  cores: Int,
  created: Date,
  capacity: Option[BigDecimal],
  status: MachineStatus.Value
)

trait UserMachinesView extends ModelIncluded {
  self: AppTest =>

  def createUsersMachineView(implicit session: Session) = {
    //query that is a base for view
    new CustomTypeMappers {
      val usersMachinesQuery = for {
        user <- TableQuery[Users]
        userMachine <- userMachineQuery if user.id === userMachine.userId
        machine <- TableQuery[Machines] if machine.id === userMachine.machineId
      } yield (user, machine)

      val tableQuery = FilterableViews.createView(
        name = "USER_MACHINE_VIEW",
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
            "status" -> machine.status)
      }

      tableQuery.viewDDL.create
    }.tableQuery
  }
}
