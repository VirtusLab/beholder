package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model._
import play.api.db.slick.Config.driver.simple._
import org.virtuslab.unicorn.ids.repositories._
import scala.slick.lifted.TableQuery


/**
 * Service for users.
 *
 * It brings all base service methods with it from [[service.BaseIdService]], but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
class UsersRepository extends BaseIdRepository[UserId, User, Users]("Users", TableQuery[Users])