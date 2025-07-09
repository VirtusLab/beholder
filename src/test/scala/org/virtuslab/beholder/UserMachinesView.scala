package org.virtuslab.beholder

import java.sql.Date
import org.virtuslab.beholder.model.{ MachineStatus, UserMachinesComponent }
import org.virtuslab.beholder.views.FilterableViewsComponent
import org.virtuslab.unicorn.UnicornWrapper

import scala.concurrent.ExecutionContext.Implicits.global
import sttp.tapir.Schema

case class UserMachineViewRow(
  email: String,
  system: String,
  cores: Int,
  created: Date,
  capacity: Option[BigDecimal],
  status: MachineStatus.Value)

trait UserMachinesViewComponent
  extends FilterableViewsComponent
  with UserMachinesComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._

  implicit val dateSchema: Schema[Date] = Schema.string[Date].format("yyyy-MM-dd")

  //query that is a base for view
  lazy val usersMachinesQuery = for {
    user <- TableQuery[Users]
    userMachine <- userMachinesTableQuery if user.id === userMachine.userId
    machine <- TableQuery[Machines] if machine.id === userMachine.machineId
  } yield (user, machine)

  val e: (String, String, Int, Date, Option[BigDecimal], MachineStatus.Value) => UserMachineViewRow = UserMachineViewRow.apply _
  val f: UserMachineViewRow => Option[(String, String, Int, Date, Option[BigDecimal], MachineStatus.Value)] = UserMachineViewRow.unapply _
  lazy val userMachinesViewTableQuery: Foo = createView(
    "USER_MACHINE_VIEW",
    UserMachineViewRow.apply _,
    UserMachineViewRow.unapply _,
    usersMachinesQuery) {
      case (user, machine) =>
        //naming the fields
        ("email" -> user.email,
          "system" -> machine.system,
          "cores" -> machine.cores,
          "created" -> machine.created,
          "capacity" -> machine.capacity,
          "status" -> machine.status)
    }

  type Foo = unicorn.profile.api.TableQuery[BaseView6[UserMachineViewRow, String, String, Int, Date, Option[scala.BigDecimal], MachineStatus.Value]]

  def createUsersMachineView(): DBIO[Foo] = {
    userMachinesViewTableQuery.viewDDL.create.map(_ => userMachinesViewTableQuery)
  }

  def create() = userMachinesViewTableQuery.viewDDL.create

  def drop() = userMachinesViewTableQuery.viewDDL.drop

  def viewQuery = userMachinesViewTableQuery

}