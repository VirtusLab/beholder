package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.User
import org.virtuslab.beholder.model._
import org.virtuslab.unicorn.UnicornPlay._
import org.virtuslab.unicorn.UnicornPlay.driver.simple._
import scala.slick.lifted.TableQuery

class UsersRepository extends BaseIdRepository[UserId, User, Users](TableQuery[Users])