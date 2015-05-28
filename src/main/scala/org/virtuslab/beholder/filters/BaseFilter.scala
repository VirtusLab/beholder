package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.json.Json

import scala.slick.ast.TypedCollectionTypeConstructor
import scala.slick.lifted.Ordered

case class Order(column: String, asc: Boolean)

object Order {
  implicit val format = Json.format[Order]
}

/**
 * Base class that is mapped to form.
 * Contains all common and specific (data field of generic type Data) filter data
 *
 * @param take how many elements to take
 * @param skip how many elements to skip before taking
 * @param orderBy field by which ordering is done
 */
case class FilterDefinition(
  take: Option[Int],
  skip: Option[Int],
  orderBy: Option[Order],
  data: Seq[Option[Any]]
)

case class FilterRange[T](from: Option[T], to: Option[T])

/**
 * Base filter class, contains public operations for all filters instances.
 *
 * @param table table to filter on
 * @tparam Id table id
 * @tparam Entity table entity
 * @tparam FilterTable table class (usually View.type)
 */
abstract class BaseFilter[Id, Entity, FilterTable <: BaseView[Id, Entity], FieldType <: FilterField, Formatter](val table: TableQuery[FilterTable])
    extends TableFilterAPI[Entity, Formatter, FilterTable] {

  def columnsNames: Seq[String] = table.shaped.value.columnsNames

  /**
   * Empty data for filter representing empty filter (all fields in tuple (type M) are filled with Empty)
   */
  protected def emptyFilterDataInner: Seq[Option[Any]]

  def filterFields: Seq[FieldType]

  protected def tableColumns(table: FilterTable): Seq[Column[_]]

  protected def columnsFilters(table: FilterTable, data: Seq[Option[Any]]): Seq[Column[Option[Boolean]]] = {
    assert(data.size == filterFields.size, "Wrong numbers of columns")

    filterFields.zip(data).zip(tableColumns(table)).flatMap {
      case ((columnDef, dataElem), column) =>
        dataElem.map(columnDef.doFilter(column))
    }
  }

  /**
   * applies filter data into query where clauses
   */
  protected final def filters(data: Seq[Option[Any]], initialFilter: FilterTable => Column[Boolean])(table: FilterTable): Column[Option[Boolean]] = {
    columnsFilters(table, data).foldLeft(initialFilter(table).asInstanceOf[Column[Option[Boolean]]]) {
      _ && _
    }
  }

  /**
   * @return data representing empty filter - query for all entities in table
   */
  final override def emptyFilterData: FilterDefinition = FilterDefinition(None, None, None, emptyFilterDataInner)

  private type FilterQuery = Query[FilterTable, FilterTable#TableElementType, Seq]

  private def createFilter(data: FilterDefinition, initialFilter: FilterTable => Column[Boolean]): FilterQuery = {
    table.filter(filters(data.data, initialFilter))
      .sortBy {
        inQueryTable =>
          val globalColumns =
            order(data)(inQueryTable).map {
              case (column, asc) => if (asc) column.asc else column.desc
            }.toSeq.flatMap(_.columns)
          new Ordered(globalColumns ++ inQueryTable.id.asc.columns)
      }
  }

  private def takeAndSkip(data: FilterDefinition, filter: FilterQuery)(implicit session: Session): Seq[Entity] = {
    val afterTake = data.take.fold(filter)(filter.take)
    val afterSkip = data.skip.fold(afterTake)(afterTake.drop)

    afterSkip.to(TypedCollectionTypeConstructor.forArray).list
  }

  override protected def doFilter(
    data: FilterDefinition,
    initialFilter: FilterTable => Column[Boolean]
  )(implicit session: Session): Seq[Entity] =
    takeAndSkip(data, createFilter(data, initialFilter))

  override protected def doFilterWithTotalEntitiesNumber(
    data: FilterDefinition,
    initialFilter: FilterTable => Column[Boolean]
  )(implicit session: Session): FilterResult[Entity] = {
    val filter = createFilter(data, initialFilter)
    FilterResult(takeAndSkip(data, filter), filter.length.run)
  }

  //ordering
  private def order(data: FilterDefinition)(table: FilterTable): Option[(Column[_], Boolean)] =
    data.orderBy.map { case order => (table.columnByName(order.column), order.asc) }
}

object BaseFilter {
  val initialEmptyFilter: Nothing => Column[Option[Boolean]] = _ => LiteralColumn(Some(true))
}

trait TableFilterAPI[Entity, Formatter, QueryBase] extends FilterAPI[Entity, Formatter] {

  /**
   * copy this filter with this initial filter.
   * Returned filter will always yield entities that match  newInitialFilter
   */
  def withInitialFilter(newInitialFilter: QueryBase => Column[Boolean]): TableFilterAPI[Entity, Formatter, QueryBase] = {
    val org = this
    new TableFilterAPI[Entity, Formatter, QueryBase] {
      override def emptyFilterData: FilterDefinition = org.emptyFilterData

      override protected def doFilterWithTotalEntitiesNumber(
        data: FilterDefinition,
        initialFilter: (QueryBase) => Column[Boolean]
      )(implicit session: Session): FilterResult[Entity] =
        org.doFilterWithTotalEntitiesNumber(data, newInitialFilter)

      override protected def doFilter(
        data: FilterDefinition,
        initialFilter: (QueryBase) => Column[Boolean]
      )(implicit session: Session): Seq[Entity] =
        org.doFilter(data, newInitialFilter)

      override val formatter: Formatter = org.formatter
    }
  }

  /**
   * copy this filter with this initial filter.
   * Returned filter will always yield entities that match  newInitialFilter
   */
  def withContextInitialFilter[Context](newInitialFilter: Context => QueryBase => Column[Boolean]): ContextedFilterAPI[Context, Entity, Formatter] = {
    val org = this
    new ContextedFilterAPI[Context, Entity, Formatter] {
      override def apply(context: Context): FilterAPI[Entity, Formatter] = withInitialFilter(newInitialFilter(context))

      override private[beholder] def filterFormatter: Formatter = org.formatter
    }
  }

  protected def doFilter(
    data: FilterDefinition,
    initialFilter: QueryBase => Column[Boolean]
  )(implicit session: Session): Seq[Entity]

  protected def doFilterWithTotalEntitiesNumber(
    data: FilterDefinition,
    initialFilter: QueryBase => Column[Boolean]
  )(implicit session: Session): FilterResult[Entity]

  override final def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity] =
    doFilter(data, _ => LiteralColumn(true))

  override final def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[Entity] =
    doFilterWithTotalEntitiesNumber(data, _ => LiteralColumn(true))
}

trait FilterAPI[Entity, Formatter] {
  def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity]

  def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[Entity]

  def emptyFilterData: FilterDefinition

  val formatter: Formatter
}

abstract class ContextedFilterAPI[Context, Entity, Formatter] extends (Context => FilterAPI[Entity, Formatter]) {
  private[beholder] def filterFormatter: Formatter
}

case class FilterResult[T](content: Seq[T], total: Int) {

  def this(data: Seq[T]) {
    this(data, data.size)
  }
}

object FilterResult {

  import play.api.libs.functional.syntax._
  import play.api.libs.json.Format._
  import play.api.libs.json._

  implicit def format[T](implicit f: Format[T]): Format[FilterResult[T]] = (
    (__ \ "data").format[Seq[T]] and
    (__ \ "total").format[Int]
  )(FilterResult.apply, unlift(FilterResult.unapply))
}