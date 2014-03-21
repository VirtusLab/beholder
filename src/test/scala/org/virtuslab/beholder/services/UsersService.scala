package org.virtuslab.beholder.services

import org.virtuslab.beholder.model._
import play.api.db.slick.Config.driver.simple._
import org.virtuslab.unicorn.ids.services._

/**
 * Queries for users.
 * It brings all base queries with it from [[service.BaseIdQueries]], but you can add yours as well.
 */
trait UsersQueries extends BaseIdQueries[UserId, User] {
  override def table = Users
}

/**
 * Service for users.
 *
 * It brings all base service methods with it from [[service.BaseIdService]], but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
trait UsersService extends BaseIdService[UserId, User] with UsersQueries