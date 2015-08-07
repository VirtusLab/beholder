package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

trait FilterAPI[Entity, Formatter] {

  def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity]

  def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[Entity]

  def emptyFilterData: FilterDefinition

  private[beholder] def filterFormatter: Formatter
}