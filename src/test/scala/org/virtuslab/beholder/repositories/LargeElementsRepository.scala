package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ LargeComponent, LargeElement }
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class LargeElementsRepository(val unicorn: UnicornPlay[Long]) extends LargeComponent with UnicornWrapper[Long] {
  def save(elem: LargeElement) = baseLargeElementsRepository.save(elem)

  def create() = baseLargeElementsRepository.create

}
