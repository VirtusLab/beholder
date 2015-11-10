package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ Machine, MachineId, Machines }
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import slick.lifted.TableQuery

/**
 * Service for machines.
 *
 * It brings all base service methods with it from [[org.virtuslab.unicorn.LongUnicornPlay.BaseIdRepository]],
 * but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
class MachineRepository extends BaseIdRepository[MachineId, Machine, Machines](TableQuery[Machines])