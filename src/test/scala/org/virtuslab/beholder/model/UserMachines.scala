package org.virtuslab.beholder.model

import play.api.db.slick.Config.driver.simple._
import scala.slick.lifted.ColumnBase


/**
 * Author: Krzysztof Romanowski
 */
object UserMachines extends Table[(UserId, MachineId)]("users_machines") {


  def userId = column[UserId]("user_id")

  def userFk = foreignKey("user_fk", userId, Users)(_.id)

  def machineId = column[MachineId]("machine_id")

  def machineFk = foreignKey("machine_fk", machineId, Machines)(_.id)

  def * = userId ~ machineId

  //view
}
