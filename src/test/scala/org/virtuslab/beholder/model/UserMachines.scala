package org.virtuslab.beholder.model

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

class UserMachines(tag: Tag) extends Table[(UserId, MachineId)](tag, "users_machines") {

  def userId = column[UserId]("user_id")

  def userFk = foreignKey("user_fk", userId, Users.query)(_.id)

  def machineId = column[MachineId]("machine_id")

  def machineFk = foreignKey("machine_fk", machineId, Machines.query)(_.id)

  def * = (userId, machineId)
}

object UserMachines {
  val query = TableQuery[UserMachines]
}