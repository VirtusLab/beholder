package org.virtuslab.beholder.repositories

import play.api.db.slick.Config.driver.simple._
import org.virtuslab.unicorn.ids.repositories._
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.model.User
import scala.slick.lifted.TableQuery

class UsersRepository extends BaseIdRepository[UserId, User, Users]("Users", TableQuery[Users])