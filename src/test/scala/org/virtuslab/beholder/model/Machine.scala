package org.virtuslab.beholder.model

import scala.slick.session.Session
import org.virtuslab.unicorn.ids._

/** Id class for type-safe joins and queries. */
case class MachineId(id: Long) extends AnyVal with BaseId

/** Companion object for id class, extends IdMapping
  * and brings all required implicits to scope when needed.
  */
object MachineId extends IdCompanion[MachineId]

/** Machine entity.
  *
  * @param id machine id
  * @param url machine email address
  * @param system operating system installed on machine
  * @param cores number of cores that machine posess
  */
case class Machine(id: Option[MachineId],
                url: String,
                system: String,
                cores: Int) extends WithId[MachineId]

/** Table definition for machines. */
object Machines extends IdTable[MachineId, Machine]("MACHINES") {

  def url = column[String]("url", O.NotNull)

  def system = column[String]("system", O.NotNull)

  def cores = column[Int]("cores", O.NotNull)

  def base = url ~ system ~ cores

  override def * = id.? ~: base <> (Machine.apply _, Machine.unapply _)

  override def insertOne(elem: Machine)(implicit session: Session): MachineId =
    saveBase(base, Machine.unapply _)(elem)
}
