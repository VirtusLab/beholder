package org.virtuslab.beholder.filters

import slick.lifted.Query

import scala.language.higherKinds

trait ConsumerDSL[E, T, FilterType[A, B] <: BeholderFilter[A, B]] {
  protected def createFilter: FilterType[E, T]

  def list: FilterAwareConsumer[E, FilterType[E, T]] = consumed(QueryCollector.list)

  def consumed[R](filterConsumer: QueryCollector[E, T, R]): FilterAwareConsumer[R, FilterType[E, T]] =
    new ConsumerImpl[E, T, R, FilterType[E, T]](createFilter, filterConsumer)

  def consumedAs[R](transformation: QueryCollector[E, T, E] => QueryCollector[E, T, R]) =
    consumed(transformation(QueryCollector.list))

  def aggregatedAs[A](op: Query[T, E, Seq] => Query[_, (E, Option[A]), Seq]) =
    consumedAs(_.leftJoin(op))
}