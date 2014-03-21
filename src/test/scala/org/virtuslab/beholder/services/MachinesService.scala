package org.virtuslab.beholder.services

import org.virtuslab.unicorn.ids.services.{BaseIdService, BaseIdQueries}
import org.virtuslab.beholder.model.{Machines, Machine, MachineId}

/**
 * Author: Krzysztof Romanowski
 */
/**
 * Queries for machines.
 * It brings all base queries with it from [[service.BaseIdQueries]], but you can add yours as well.
 */
trait MachinesQueries extends BaseIdQueries[MachineId, Machine] {
  override def table = Machines
}

/**
 * Service for machines.
 *
 * It brings all base service methods with it from [[service.BaseIdService]], but you can add yours as well.
 *
 * It's a trait, so you can use your favourite DI method to instantiate/mix it to your application.
 */
trait MachinesService extends BaseIdService[MachineId, Machine] with MachinesQueries