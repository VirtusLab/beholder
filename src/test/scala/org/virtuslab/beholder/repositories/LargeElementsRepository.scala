package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.{ LargeComponent, LargeElement, LargeElementId }
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class LargeElementsRepository(val unicorn: UnicornPlay[Long]) extends LargeComponent with UnicornWrapper[Long] {

  import unicorn.profile.api.DBIO

  def save(elem: LargeElement): DBIO[LargeElementId] = baseLargeElementsRepository.save(elem)

  def create(): DBIO[Unit] = baseLargeElementsRepository.create()

}
