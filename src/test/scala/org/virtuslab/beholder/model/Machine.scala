package org.virtuslab.beholder.model

import java.sql.Date

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

/** Id class for type-safe joins and queries. */
case class MachineId(id: Long) extends AnyVal with BaseId

/**
 * Companion object for id class, extends IdMapping
 * and brings all required implicits to scope when needed.
 */
object MachineId extends IdCompanion[MachineId]

/**
 * Machine entity.
 *
 * @param id machine id
 * @param url machine email address
 * @param system operating system installed on machine
 * @param cores number of cores that machine posess
 * @param capacity capacity of that machine
 */
case class Machine(
  id: Option[MachineId],
  url: String,
  system: String,
  cores: Int,
  created: Date,
  capacity: Option[BigDecimal]) extends WithId[MachineId]

/** Table definition for machines. */
class Machines(tag: Tag) extends IdTable[MachineId, Machine](tag, "MACHINES") {

  def url = column[String]("url")

  def system = column[String]("system")

  def cores = column[Int]("cores")

  def created = column[Date]("created")

  def capacity = column[Option[BigDecimal]]("capacity")

  override def * = (id.?, url, system, cores, created, capacity) <> (Machine.tupled, Machine.unapply)
}
