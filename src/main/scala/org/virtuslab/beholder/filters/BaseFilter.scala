package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.BaseView
import play.api.libs.json.Json
import scala.slick.lifted.Ordered
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import scala.slick.ast.TypedCollectionTypeConstructor

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
 * @param data
 */
case class FilterDefinition(
  take: Option[Int],
  skip: Option[Int],
  orderBy: Option[Order],
  data: Seq[Option[Any]]
)

object FilterDefinition {
  implicit val format = Json.format[FilterDefinition]
}

case class FilterRange[T](from: Option[T], to: Option[T])

/**
 * Base filter class, contains public operations for all filters instances.
 *
 * @param table table to filter on
 * @tparam Id table id
 * @tparam Entity table entity
 * @tparam Table table class (usually View.type)
 */
abstract class BaseFilter[Id, Entity, Table <: BaseView[Id, Entity], FieldType <: FilterField, Formatter](val table: TableQuery[Table]) extends FilterAPI[Entity, Formatter] {

  def columnsNames: Seq[String] = table.shaped.value.columnsNames

  /**
   * Empty data for filter representing empty filter (all fields in tuple (type M) are filled with Empty)
   */
  protected def emptyFilterDataInner: Seq[Option[Any]]

  def filterFields: Seq[FieldType]

  protected def tableColumns(table: Table): Seq[Column[_]]

  protected def columnsFilters(table: Table, data: Seq[Option[Any]]): Seq[Column[Option[Boolean]]] = {
    assert(data.size == filterFields.size, "Wrong numbers of columns")

    filterFields.zip(data).zip(tableColumns(table)).flatMap {
      case ((columnDef, data), column) =>
        data.map(columnDef.doFilter(column))
    }
  }

  /**
   * applies filter data into query where clauses
   * @param data
   * @param table
   * @return
   */
  protected def filters(data: Seq[Option[Any]])(table: Table): Column[Option[Boolean]] = {
    columnsFilters(table, data).foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
      _ && _
    }
  }

  /**
   * @return data representing empty filter - query for all entities in table
   */
  final override def emptyFilterData: FilterDefinition = FilterDefinition(None, None, None, emptyFilterDataInner)

  /**
   * filter and sort all entities with given data
   * @param data
   * @param session
   * @return
   */
  final override def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity] = {
    val base = table.filter(filters(data.data))
      .sortBy {
        inQueryTable =>
          val globalColumns =
            order(data)(inQueryTable).map {
              case (column, asc) => if (asc) column.asc else column.desc
            }.toSeq.flatMap(_.columns)
          new Ordered(globalColumns ++ inQueryTable.id.asc.columns)
      }

    val afterTake = data.take.fold(base)(base.take)
    val afterSkip = data.skip.fold(afterTake)(afterTake.drop)

    afterSkip.to(TypedCollectionTypeConstructor.forArray).list
  }

  //ordering
  private def order(data: FilterDefinition)(table: Table): Option[(Column[_], Boolean)] =
    data.orderBy.map { case order => (table.columnByName(order.column), order.asc) }
}

trait FilterAPI[Entity, Formatter] {
  def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity]

  def emptyFilterData: FilterDefinition

  def formatter: Formatter
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