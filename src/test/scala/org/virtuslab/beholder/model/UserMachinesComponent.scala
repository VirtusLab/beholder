package org.virtuslab.beholder.model

import org.virtuslab.unicorn.UnicornWrapper

trait UserMachinesComponent extends UserComponent with MachineComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._

  class UserMachines(tag: Tag) extends Table[(UserId, MachineId)](tag, "users_machines") {

    def userId = column[UserId]("user_id")

    def userFk = foreignKey("user_fk", userId, TableQuery[Users])(_.id)

    def machineId = column[MachineId]("machine_id")

    def machineFk = foreignKey("machine_fk", machineId, TableQuery[Machines])(_.id)

    def * = (userId, machineId)
  }
  lazy val userMachinesTableQuery = TableQuery[UserMachines]

}
