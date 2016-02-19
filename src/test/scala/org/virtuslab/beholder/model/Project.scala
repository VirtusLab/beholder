package org.virtuslab.beholder.model

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import slick.lifted.ProvenShape

object ProjectType extends Enumeration {
  val Inner = Value("inner")
  val Outer = Value("outer")
  val Evaluation = Value("evaluation")

  implicit val myEnumMapper = MappedColumnType.base[Value, String](
    e => e.toString,
    s => withName(s) //TODO util for that?
  )
}

/** Id class for type-safe joins and queries. */
case class ProjectId(id: Long) extends AnyVal with BaseId

/**
 * Companion object for id class, extends IdMapping
 * and brings all required implicits to scope when needed.
 */
object ProjectId extends IdCompanion[ProjectId]

case class Project(
  id: Option[ProjectId],
  name: String,
  team: Option[TeamId],
  owner: UserId,
  projectType: ProjectType.Value) extends WithId[ProjectId]

/** Table definition for projects. */
class Projects(tag: Tag) extends IdTable[ProjectId, Project](tag, "PROJECTS") {

  def name = column[String]("NAME")
  def team = column[TeamId]("TEAM")
  def owner = column[UserId]("OWNER")
  def projectType = column[ProjectType.Value]("PROJECT_TYPE")

  override def * = (id.?, name, team.?, owner, projectType) <> (Project.tupled, Project.unapply)
}