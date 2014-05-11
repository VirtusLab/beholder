package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ Machines, Machine, MachineId }
import org.virtuslab.unicorn.UnicornPlay._
import org.virtuslab.unicorn.UnicornPlay.driver.simple._
import scala.slick.lifted.TableQuery

/**
 * Service for machines.
 *
 * It brings all base service methods with it from [[org.virtuslab.unicorn.UnicornPlay.BaseIdRepository]],
 * but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
class MachineRepository extends BaseIdRepository[MachineId, Machine, Machines](TableQuery[Machines])