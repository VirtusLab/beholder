package org.virtuslab.beholder.filters.dsl

import org.virtuslab.beholder.filters.json.{ JsonFormatter, JsonFilterField }
import org.virtuslab.beholder.filters.{ BaseFilter, FilterFactoryMethods, BareFilter }
import org.virtuslab.unicorn.LongUnicornPlay
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

class JsonDslFilters[E <: Product](labels: String => String) {
  def createFormatter(table: BareFilter[_, _, _, JsonFilterField[_, _], JsonFormatter[E]]) =
    new JsonFormatter[E](table.filterFields, table.columnsNames, labels)

  type FT = JsonFilterField[_, _]

  case class DslFilter[DbE, T <: Product](table: Query[T, DbE, Seq], filterFields: Seq[FT], columnsNames: Seq[String], mapping: DbE => E)
      extends BareFilter[E, DbE, T, FT, JsonFormatter[E]] {

    override def defaultColumn(table: T): LongUnicornPlay.driver.simple.Column[_] = tableColumns(table).head

    override def columnByName(table: T, name: String): LongUnicornPlay.driver.simple.Column[_] = {
      val map: Map[String, Column[_]] = columnsNames.zip(tableColumns(table))(collection.breakOut)
      map(name)
    }

    override def mappingFunction(e: DbE): E = mapping(e)

    override protected def tableColumns(table: T) = table.productIterator.map(_.asInstanceOf[Column[_]]).toSeq

    override val formatter: JsonFormatter[E] = createFormatter(this)
  }

}

