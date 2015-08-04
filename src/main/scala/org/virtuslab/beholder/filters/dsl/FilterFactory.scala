package org.virtuslab.beholder.filters.dsl

import org.virtuslab.beholder.filters._
import org.virtuslab.unicorn.LongUnicornPlay
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

object FilterFactory {
  def crate[T <: Product, E, FT <: FilterField](
    query: Query[T, E, Seq],
    fields: Seq[FT],
    names: Seq[String]
  ): MappableFilterAPI[E, Unit, FT, T] = {
    new FilterImplementation[E, E, T, FT, Unit]() {
      override protected def table = query

      override def filterFields: Seq[FT] = fields

      override def defaultColumn(table: T): LongUnicornPlay.driver.simple.Column[_] = tableColumns(table).head

      override def columnByName(table: T, name: String): LongUnicornPlay.driver.simple.Column[_] = {
        val map: Map[String, Column[_]] = columnsNames.zip(tableColumns(table))(collection.breakOut)
        map(name)
      }

      override def mappingFunction(e: E): E = e

      override def columnsNames: Seq[String] = names

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] =
        table.productIterator.map(_.asInstanceOf[Column[_]]).toSeq

      override private[beholder] def filterFormatter: Unit = {}
    }

  }
}
