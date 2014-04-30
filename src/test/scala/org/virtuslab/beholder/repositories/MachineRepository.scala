package org.virtuslab.beholder.repositories

import org.virtuslab.unicorn.ids.repositories.BaseIdRepository
import org.virtuslab.beholder.model.{Machines, Machine, MachineId}
import scala.slick.lifted.TableQuery
import play.api.db.slick.Config.driver.simple._

/**
 * Service for machines.
 *
 * It brings all base service methods with it from [[org.virtuslab.unicorn.ids.repositories.BaseIdRepository]],
 * but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
class MachineRepository extends BaseIdRepository[MachineId, Machine, Machines]("Machines", TableQuery[Machines])