package org.virtuslab.beholder.consumers

import org.virtuslab.beholder.filters._
import slick.dbio.DBIO

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions
import scala.language.higherKinds


trait FilterConsumer[E, Filter <: BeholderFilter[E, _], R] {
  def filter: Filter

  def consume(definition: FilterDefinition)(implicit ec: ExecutionContext): DBIO[R]
}

case class StandardConsumer[E](override val filter: BeholderFilter[E, _])
  extends FilterConsumer[E, BeholderFilter[E, _], FilterResult[E]]{

  override def consume(filterDefinition: FilterDefinition)(implicit ec: ExecutionContext): DBIO[FilterResult[E]] = {
    val query = filter.apply(filterDefinition)

    val queryAfterSkip = filterDefinition.skip.fold(query)(query.drop)
    val afterTake = filterDefinition.take.fold(queryAfterSkip)(queryAfterSkip.take)

    import filter.driver.api._

    for{
      list <- afterTake.result
      size <- query.length.result
    } yield FilterResult(list, size)
  }
}