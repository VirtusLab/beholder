package org.virtuslab.beholder.model

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import slick.lifted.Tag

/** Id class for type-safe joins and queries. */
case class TeamId(id: Long) extends AnyVal with BaseId

/**
 * Companion object for id class, extends IdMapping
 * and brings all required implicits to scope when needed.
 */
object TeamId extends IdCompanion[TeamId]

/**
 * Team entity.
 *
 * @param id Team id
 */
case class Team(
  id: Option[TeamId],
  admin: UserId,
  teamName: String,
  system: String) extends WithId[TeamId]

/** Table definition for Teams. */
class Teams(tag: Tag) extends IdTable[TeamId, Team](tag, "TeamS") {

  def admin = column[UserId]("admin", O.NotNull)

  def teamName = column[String]("teamName", O.NotNull)
  def system = column[String]("system", O.NotNull)

  override def * = (id.?, admin, teamName, system) <> (Team.tupled, Team.unapply)
}