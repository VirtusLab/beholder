package org.virtuslab.beholder.model

import java.sql.Date

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

/** Id class for type-safe joins and queries. */
case class MachineParameterId(id: Long) extends AnyVal with BaseId

/**
 * Companion object for id class, extends IdMapping
 * and brings all required implicits to scope when needed.
 */
object MachineParameterId extends IdCompanion[MachineParameterId]

/**
 * MachineParameter entity.
 *
 * @param id MachineParameter id
 * @param url MachineParameter email address
 * @param system operating system installed on MachineParameter
 * @param cores number of cores that MachineParameter posess
 * @param capacity capacity of that MachineParameter
 */
case class MachineParameter(
  id: Option[MachineParameterId],
  name: String,
  value: String,
  machine: MachineId
) extends WithId[MachineParameterId]

/** Table definition for MachineParameters. */
class MachineParameters(tag: Tag) extends IdTable[MachineParameterId, MachineParameter](tag, "MachineParameterS") {

  def name = column[String]("name", O.NotNull)

  def value = column[String]("value", O.NotNull)

  def machine = column[MachineId]("machine", O.NotNull)


  override def * = (id.?, name, value, machine) <> (MachineParameter.tupled, MachineParameter.unapply)
}
