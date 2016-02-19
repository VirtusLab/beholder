package org.virtuslab.beholder.model

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import slick.lifted.TableQuery
import slick.lifted.Tag

class UserMachines(tag: Tag) extends Table[(UserId, MachineId)](tag, "users_machines") {

  def userId = column[UserId]("user_id")

  def userFk = foreignKey("user_fk", userId, TableQuery[Users])(_.id)

  def machineId = column[MachineId]("machine_id")

  def machineFk = foreignKey("machine_fk", machineId, TableQuery[Machines])(_.id)

  def * = (userId, machineId)
}
