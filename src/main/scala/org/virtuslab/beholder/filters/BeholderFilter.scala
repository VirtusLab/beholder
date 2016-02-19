package org.virtuslab.beholder.filters

import org.virtuslab.beholder.consumers.StandardConsumer
import slick.driver.JdbcDriver
import slick.lifted.{Query, Rep}


/**
  * Author: Krzysztof Romanowski
  */
trait BeholderFilter[E, T] extends (FilterDefinition => Query[T, E, Seq]) {

  protected def filterFields: Map[String, FilterField]

  protected def filterColumns(from: T): Map[String, Rep[_]]

  protected def defaultOrder(from: T): Rep[_]

  val driver: JdbcDriver
}

object BeholderFilter{
  implicit class consumedBeholderFilter[E](filter: BeholderFilter[E, _]){
    def consumed = new StandardConsumer[E](filter) //TODO better DSL!
  }
}
