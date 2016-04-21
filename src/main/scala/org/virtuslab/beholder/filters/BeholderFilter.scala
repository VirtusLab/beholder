package org.virtuslab.beholder.filters

import slick.driver.JdbcDriver
import slick.lifted.{Query, Rep}



trait BaseFilter {
  protected def filterFields: Map[String, FilterField]

  val driver: JdbcDriver
}

trait BeholderFilter[E, T] extends (FilterDefinition => Query[T, E, Seq]) with BaseFilter {
  protected def filterColumns(from: T): Map[String, Rep[_]]

  protected def defaultOrder(from: T): Rep[_]
}

import scala.language.{higherKinds, implicitConversions}

object BeholderFilter{

  implicit class ConsumedBeholderFilter[E, T, F[FE, TE] <: BeholderFilter[FE, TE]](val createFilter: F[E, T])
    extends ConsumerDSL[E, T, F]
}
