package org.virtuslab.beholder.filters.dsl

import org.virtuslab.beholder.filters.{FilterDefinition, FilterField, FilterAPI, BareFilter}
import org.virtuslab.beholder.filters.json.JsonFormatter
import org.virtuslab.unicorn.LongUnicornPlay
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._


trait FormatterProvider[E, Formatter] extends Function1[FilterAPI[E, Formatter], Formatter]

object FilterFactory {
  def crate[E, T <: Product, DbE, FT <: FilterField, Formatter](provider: FormatterProvider[E, Formatter],
                                                                query: Query[T, DbE, Seq],
                                                                fields: Seq[FT],
                                                                names: Seq[String],
                                                                mapping: DbE => E): FilterAPI[E, Formatter] = {
    new BareFilter[E, DbE, T, FT, Formatter]() {
      override protected def table = query

      override def filterFields: Seq[FT] = fields

      override def defaultColumn(table: T): LongUnicornPlay.driver.simple.Column[_] = tableColumns(table).head

      override def columnByName(table: T, name: String): LongUnicornPlay.driver.simple.Column[_] = {
        val map: Map[String, Column[_]] = columnsNames.zip(tableColumns(table))(collection.breakOut)
        map(name)
      }

      override def mappingFunction(e: DbE): E = mapping(e)

      override def columnsNames: Seq[String] = names

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] =
        table.productIterator.map(_.asInstanceOf[Column[_]]).toSeq

      override val formatter: Formatter = provider(this)
    }

  }
}
