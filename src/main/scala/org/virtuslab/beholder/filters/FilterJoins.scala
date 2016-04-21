package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import slick.driver.JdbcDriver

trait FilterJoins[E, T] {
  self: ImplementedFilter[E, T] =>

  type FilterJoin = (FilterConstrains, JdbcDriver) => FilterQuery => FilterQuery

  var _joins: Map[String, FilterJoin] = Map.empty

  protected def joins: Map[String, FilterJoin] = _joins

  // TODO #29 dsl for joins
  def join[NET, NT](name: String,
    from: ImplementedFilter[NET, NT])(on: (T, NT) => Rep[Boolean])(implicit t1Shape: Shape[FlatShapeLevel, T, E, T]): ImplementedFilter[E, T] = {
    val join: FilterJoin = (data, driver) => query =>
      for {
        ft <- query
        tt <- from.filterOnQuery(data) if on(ft, tt)
      } yield ft

    _joins += name -> join
    this
  }
}
