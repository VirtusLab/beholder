package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model._
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.slick.lifted.TableQuery

/**
 * Service for machines.
 *
 * It brings all base service methods with it from [[org.virtuslab.unicorn.LongUnicornPlay.BaseIdRepository]],
 * but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
class MachineParameterRepository
  extends BaseIdRepository[MachineParameterId, MachineParameter, MachineParameters](TableQuery[MachineParameters])