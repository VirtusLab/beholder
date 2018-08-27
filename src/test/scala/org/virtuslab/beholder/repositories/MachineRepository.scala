package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ Machine, MachineComponent }
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class MachineRepository(val unicorn: UnicornPlay[Long]) extends MachineComponent with UnicornWrapper[Long] {
  def save(elem: Machine) = baseMachineRepository.save(elem)

  def create() = baseMachineRepository.create()
}