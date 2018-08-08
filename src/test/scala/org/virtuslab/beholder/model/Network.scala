package org.virtuslab.beholder.model

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

/** Id class for type-safe joins and queries. */
case class NetworkId(id: Long) extends AnyVal with BaseId

/**
 * Companion object for id class, extends IdMapping
 * and brings all required implicits to scope when needed.
 */
object NetworkId extends IdCompanion[NetworkId]

/**
 * Network entity.
 *
 * @param id Network id
 * @param url Network email address
 * @param system operating system installed on Network
 * @param cores number of cores that Network posess
 * @param capacity capacity of that Network
 */
case class Network(
  id: Option[NetworkId],
  mask: String,
  address: String,
  admin: UserId) extends WithId[NetworkId]

/** Table definition for Networks. */
class Networks(tag: Tag) extends IdTable[NetworkId, Network](tag, "NetworkS") {

  def mask = column[String]("mask")

  def address = column[String]("address")

  def admin = column[UserId]("admin")

  override def * = (id.?, mask, address, admin) <> (Network.tupled, Network.unapply)
}

object Networks {
  val query = TableQuery[Networks]
}