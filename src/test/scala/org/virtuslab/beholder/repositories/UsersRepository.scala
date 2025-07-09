package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ User, UserComponent, UserId }
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class UsersRepository(val unicorn: UnicornPlay[Long]) extends UserComponent with UnicornWrapper[Long] {

  import unicorn.profile.api.DBIO

  def save(elem: User): DBIO[UserId] = baseUserBaseRepository.save(elem)

  def create(): DBIO[Unit] = baseUserBaseRepository.create()

}
