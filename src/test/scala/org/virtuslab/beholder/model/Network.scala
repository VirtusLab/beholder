package org.virtuslab.beholder.model

import java.sql.Date

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

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
  admin: UserId
) extends WithId[NetworkId]

/** Table definition for Networks. */
class Networks(tag: Tag) extends IdTable[NetworkId, Network](tag, "NetworkS") {

  def mask = column[String]("mask", O.NotNull)

  def address = column[String]("address", O.NotNull)

  def admin = column[UserId]("admin", O.NotNull)

  override def * = (id.?, mask, address, admin) <> (Network.tupled, Network.unapply)
}
