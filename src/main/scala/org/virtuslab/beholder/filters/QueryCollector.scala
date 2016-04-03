package org.virtuslab.beholder.filters

import org.virtuslab.beholder.utils.AggregationUtil
import slick.dbio._
import slick.lifted.Query

import scala.concurrent.ExecutionContext

trait QueryCollector[E, T, R] {
  def runQuery(q: Query[T, E, Seq], filter: BaseFilter)(implicit ec: ExecutionContext): DBIO[Seq[R]]
}

object QueryCollector{
  implicit class Opts[E, T, R](baseCollector: QueryCollector[E, T, R]){
    def mapQuery[A, _](qMap: Query[T, E, Seq] => Query[_, A, Seq])=
      new QueryCollector[E, T, A] {
        override def runQuery(q: Query[T, E, Seq], filter: BaseFilter)(implicit ec: ExecutionContext): DBIO[Seq[A]] = {
          import filter.driver.api._
          qMap(q).result
        }
      }


    def mapResult[RN](mapper: Seq[R] => Seq[RN]) = new QueryCollector[E, T, RN] {
      override def runQuery(q: Query[T, E, Seq], filter: BaseFilter)(implicit ec: ExecutionContext): DBIO[Seq[RN]] =
        baseCollector.runQuery(q, filter).map(mapper)
    }

    def map[RN](mapper: R => RN) = mapResult(_.map(mapper))

    def leftJoin[A](doJoin: Query[T, E, Seq] => Query[_, (E, Option[A]), Seq]) =
      mapQuery(doJoin).mapResult(AggregationUtil.aggregateResult)
  }

  def list[E, T] = new QueryCollector[E, T, E] {

    override def runQuery(q: Query[T, E, Seq], filter: BaseFilter)(implicit ec: ExecutionContext): DBIO[Seq[E]] = {
      import filter.driver.api._
      q.result
    }
  }
}