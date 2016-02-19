package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model._
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import slick.lifted.TableQuery

/**
 * Service for projects.
 *
 * It brings all base service methods with it from [[org.virtuslab.unicorn.LongUnicornPlay.BaseIdRepository]],
 * but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
class ProjectRepository extends BaseIdRepository[ProjectId, Project, Projects](TableQuery[Projects])