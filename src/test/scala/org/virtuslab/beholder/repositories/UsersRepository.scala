package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ User, _ }
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

class UsersRepository extends BaseIdRepository[UserId, User, Users](Users.query)