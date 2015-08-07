package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.slick.ast.TypedCollectionTypeConstructor
import scala.slick.lifted.Ordered

/**
 * Author: Krzysztof Romanowski
 */
abstract class FilterImplementation[E, DbE, T, FT <: FilterField, Formatter] extends MappableFilterAPI[E, Formatter, FT, T] {

  private type FilterQuery = Query[T, DbE, Seq]

  private type BoolColumn = Column[Option[Boolean]]

  protected def table: FilterQuery

  protected def tableColumns(table: T): Seq[Column[_]]

  def mappingFunction(e: DbE): E

  def columnByName(table: T, name: String): Column[_]

  def defaultColumn(table: T): Column[_]

  override final protected def globalInitialFilter(table: T): Column[Option[Boolean]] = LiteralColumn(Some(true))

  /**
   * Empty data for filter representing empty filter (all fields in tuple (type M) are filled with Empty)
   */
  protected def emptyFilterDataInner: Seq[Option[Any]] = columnsNames.map(_ => None)

  protected def columnsFilters(table: T, data: Seq[Option[Any]]): Seq[Column[Option[Boolean]]] = {
    assert(data.size == filterFields.size, "Wrong numbers of columns")

    filterFields.zip(data).zip(tableColumns(table)).flatMap {
      case ((columnDef, dataElem), column) =>
        dataElem.map(columnDef.doFilter(column))
    }
  }

  /**
   * applies filter data into query where clauses
   */
  protected def filters(data: Seq[Option[Any]], initialFilter: T => BoolColumn)(table: T): BoolColumn = {
    columnsFilters(table, data).foldLeft(initialFilter(table): BoolColumn) {
      _ && _
    }
  }

  /**
   * @return data representing empty filter - query for all entities in table
   */
  final override def emptyFilterData: FilterDefinition = FilterDefinition(None, None, None, emptyFilterDataInner)

  private def createFilter(data: FilterDefinition, initialFilter: T => BoolColumn): FilterQuery = {
    table
      .filter(filters(data.data, initialFilter))
      .sortBy {
        inQueryTable =>
          val columns = data.orderBy.map {
            order =>
              val column = columnByName(inQueryTable, order.column)
              if (order.asc) column.asc else column.desc
          }.toSeq.flatMap(_.columns)
          val defaultColumns = defaultColumn(inQueryTable).asc.columns
          new Ordered(columns ++ defaultColumns)
      }
  }

  private def takeAndSkip(data: FilterDefinition, filter: FilterQuery)(implicit session: Session): Seq[E] = {
    val afterTake = data.take.fold(filter)(filter.take)
    val afterSkip = data.skip.fold(afterTake)(afterTake.drop)

    afterSkip.to(TypedCollectionTypeConstructor.forArray).mapResult(mappingFunction).list
  }

  /**
   * filter and sort all entities with given data
   */
  override protected def doFilter(
    data: FilterDefinition,
    initialFilter: (T) => Column[Option[Boolean]]
  )(implicit session: Session): Seq[E] =
    takeAndSkip(data, createFilter(data, initialFilter))

  override protected def doFilterWithTotalEntitiesNumber(
    data: FilterDefinition,
    initialFilter: (T) => Column[Option[Boolean]]
  )(implicit session: Session): FilterResult[E] = {
    val filter = createFilter(data, initialFilter)
    FilterResult(takeAndSkip(data, filter), filter.length.run)
  }

}
