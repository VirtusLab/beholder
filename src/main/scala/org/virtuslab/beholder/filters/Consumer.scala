package org.virtuslab.beholder.filters

import org.virtuslab.beholder.utils.AggregationUtil
import slick.dbio.DBIO
import slick.driver.JdbcDriver
import slick.lifted.{ Rep, Query }

import scala.concurrent.ExecutionContext
import scala.language.{ higherKinds, implicitConversions }

trait FilterConsumer[R] {
  def consume(definition: FilterDefinition)(implicit ec: ExecutionContext): DBIO[FilterResult[R]]

  def run(definition: FilterDefinition)(implicit ec: ExecutionContext): DBIO[Seq[R]]
}

trait FilterAwareConsumer[R, +F] extends FilterConsumer[R] {
  def filter: F
}

case class ConsumerImpl[E, T, R, Filter <: BeholderFilter[E, T]](filter: Filter, collector: QueryCollector[E, T, R])
    extends FilterAwareConsumer[R, Filter] {

  override def consume(definition: FilterDefinition)(implicit ec: ExecutionContext): DBIO[FilterResult[R]] = {
    val query = filter.apply(definition)

    val queryAfterSkip = definition.skip.fold(query)(query.drop)
    val afterTake = definition.take.fold(queryAfterSkip)(queryAfterSkip.take)

    import filter.driver.api._

    val results = collector.runQuery(afterTake, filter)

    for {
      list <- results
      size <- query.length.result
    } yield FilterResult(list, size)
  }

  override def run(definition: FilterDefinition)(implicit ec: ExecutionContext): DBIO[Seq[R]] = collector.runQuery(filter(definition), filter)

}

