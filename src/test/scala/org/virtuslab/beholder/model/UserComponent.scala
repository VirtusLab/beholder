package org.virtuslab.beholder.model

import org.virtuslab.unicorn.LongUnicornPlayIdentifiers.IdCompanion
import org.virtuslab.unicorn.{ BaseId, UnicornWrapper, WithId }

/** Id class for type-safe joins and queries. */
case class UserId(id: Long) extends BaseId[Long]

/**
 * Companion object for id class, extends IdMapping
 * and brings all required implicits to scope when needed.
 */
object UserId extends IdCompanion[UserId]

/**
 * User entity.
 *
 * @param id        user id
 * @param email     user email address
 * @param lastName  lastName
 * @param firstName firstName
 */
case class User(
  id: Option[UserId],
  email: String,
  firstName: String,
  lastName: String) extends WithId[Long, UserId]

trait UserComponent {
  self: UnicornWrapper[Long] =>

  import unicorn._
  import unicorn.profile.api._

  /** Table definition for users. */
  class Users(tag: Tag) extends IdTable[UserId, User](tag, "USERS") {

    def email = column[String]("email")

    def firstName = column[String]("first_name")

    def lastName = column[String]("last_name")

    override def * = (id.?, email, firstName, lastName).<>(User.tupled, User.unapply)
  }

  class BaseUsersRepository extends BaseIdRepository[UserId, User, Users](TableQuery[Users])

  lazy val baseUserBaseRepository = new BaseUsersRepository

}