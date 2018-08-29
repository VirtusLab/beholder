package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ User, UserComponent }
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }
import scala.concurrent.ExecutionContext.Implicits.global

class UsersRepository(val unicorn: UnicornPlay[Long]) extends UserComponent with UnicornWrapper[Long] {
  def save(elem: User) = baseUserBaseRepository.save(elem)

  def create() = baseUserBaseRepository.create

}
