package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.BaseViewComponent
import org.virtuslab.unicorn.UnicornWrapper
import play.api.libs.json.Json
import slick.ast.Ordering
import slick.lifted.{ ColumnOrdered, Ordered }

import scala.concurrent.ExecutionContext
import sttp.tapir._
import play.api.libs.json.Format
import play.api.libs.json.Reads
import play.api.libs.json.Writes

case class Order(column: String, asc: Boolean)

object Order {
  implicit val format = Json.format[Order]
  implicit val schema = Schema.derived[Order]
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
  data: Seq[Option[Any]])

case class FilterRange[T](from: Option[T], to: Option[T])

object FilterRange {
  import sttp.tapir.Schema
  import play.api.libs.functional.syntax._
  import play.api.libs.json._
  def schema[T: Schema](tname: String) = Schema.derived[FilterRange[T]].name(Schema.SName(s"FilterRange_$tname"))
  implicit def rangeFormat[T: Format]: Format[FilterRange[T]] =
    ((__ \ "from").formatNullable[T] and
      (__ \ "to").formatNullable[T])(FilterRange.apply, unlift(FilterRange.unapply))

}

trait BaseFilterComponent extends BaseViewComponent with FilterFieldComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._

  /**
   * Base filter class, contains public operations for all filters instances.
   *
   * @param table table to filter on
   * @tparam Id          table id
   * @tparam Entity      table entity
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

    protected def tableColumns(table: FilterTable): Seq[Rep[_]]

    protected def columnsFilters[T](table: FilterTable, data: Seq[Option[Any]]): Seq[Rep[Option[Boolean]]] = {
      assert(data.size == filterFields.size, "Wrong numbers of columns")

      filterFields.zip(data).zip(tableColumns(table)).flatMap {
        case ((columnDef, dataElem), column) =>
          dataElem.map(columnDef.doFilter(column))
      }
    }

    /**
     * applies filter data into query where clauses
     */
    protected final def filters(data: Seq[Option[Any]], initialFilter: FilterTable => Rep[Boolean])(table: FilterTable): Rep[Option[Boolean]] = {
      columnsFilters(table, data).foldLeft(initialFilter(table).asInstanceOf[Rep[Option[Boolean]]]) {
        _ && _
      }
    }

    /**
     * @return data representing empty filter - query for all entities in table
     */
    final override def emptyFilterData: FilterDefinition = FilterDefinition(None, None, None, emptyFilterDataInner)

    private type FilterQuery = Query[FilterTable, FilterTable#TableElementType, Seq]

    private def createFilter(data: FilterDefinition, initialFilter: FilterTable => Rep[Boolean]): FilterQuery = {
      table.filter(filters(data.data, initialFilter))
        .sortBy {
          inQueryTable =>
            val globalColumns =
              order(data)(inQueryTable).map {
                case (column, asc) => if (asc) ColumnOrdered(column, Ordering()).asc else ColumnOrdered(column, Ordering()).desc
              }.toIndexedSeq.flatMap(_.columns)
            new Ordered(globalColumns ++ ColumnOrdered(inQueryTable.id, Ordering()).asc.columns)
        }
    }

    private def takeAndSkip(data: FilterDefinition, filter: FilterQuery): DBIO[Seq[Entity]] = {
      val afterTake = data.take.fold(filter)(filter.take)
      val afterSkip = data.skip.fold(afterTake)(afterTake.drop)

      afterSkip.result
    }

    override protected def doFilter(
      data: FilterDefinition,
      initialFilter: FilterTable => Rep[Boolean]): DBIO[Seq[Entity]] =
      takeAndSkip(data, createFilter(data, initialFilter))

    override protected def doFilterWithTotalEntitiesNumber(
      data: FilterDefinition,
      initialFilter: FilterTable => Rep[Boolean])(
      implicit
      executionContext: ExecutionContext): DBIO[FilterResult[Entity]] = {

      val filter = createFilter(data, initialFilter)
      val lengthAction = filter.length.result
      lengthAction.zip(takeAndSkip(data, filter)).map {
        case (length, takenAndSkipped) =>
          FilterResult(takenAndSkipped, length)
      }
    }

    //ordering
    private def order(data: FilterDefinition)(table: FilterTable): Option[(Rep[_], Boolean)] =
      data.orderBy.map { case order => (table.columnByName(order.column), order.asc) }
  }

  trait TableFilterAPI[Entity, Formatter, QueryBase] extends FilterAPI[Entity, Formatter] {

    /**
     * copy this filter with this initial filter.
     * Returned filter will always yield entities that match  newInitialFilter
     */
    def withInitialFilter(newInitialFilter: QueryBase => Rep[Boolean]): TableFilterAPI[Entity, Formatter, QueryBase] = {
      val org = this
      new TableFilterAPI[Entity, Formatter, QueryBase] {
        override def emptyFilterData: FilterDefinition = org.emptyFilterData

        override protected def doFilterWithTotalEntitiesNumber(
          data: FilterDefinition,
          initialFilter: (QueryBase) => Rep[Boolean])(
          implicit
          executionContext: ExecutionContext): DBIO[FilterResult[Entity]] =

          org.doFilterWithTotalEntitiesNumber(data, newInitialFilter)

        override protected def doFilter(
          data: FilterDefinition,
          initialFilter: (QueryBase) => Rep[Boolean]): DBIO[Seq[Entity]] =
          org.doFilter(data, newInitialFilter)

        override val formatter: Formatter = org.formatter
      }
    }

    /**
     * copy this filter with this initial filter.
     * Returned filter will always yield entities that match  newInitialFilter
     */
    def withContextInitialFilter[Context](newInitialFilter: Context => QueryBase => Rep[Boolean]): ContextedFilterAPI[Context, Entity, Formatter] = {
      val org = this
      new ContextedFilterAPI[Context, Entity, Formatter] {
        override def apply(context: Context): FilterAPI[Entity, Formatter] = withInitialFilter(newInitialFilter(context))

        override private[beholder] def filterFormatter: Formatter = org.formatter
      }
    }

    protected def doFilter(
      data: FilterDefinition,
      initialFilter: QueryBase => Rep[Boolean]): DBIO[Seq[Entity]]

    protected def doFilterWithTotalEntitiesNumber(
      data: FilterDefinition,
      initialFilter: QueryBase => Rep[Boolean])(
      implicit
      executionContext: ExecutionContext): DBIO[FilterResult[Entity]]

    override final def filter(data: FilterDefinition): DBIO[Seq[Entity]] =
      doFilter(data, _ => LiteralColumn(true))

    override final def filterWithTotalEntitiesNumber(data: FilterDefinition)(
      implicit
      executionContext: ExecutionContext): DBIO[FilterResult[Entity]] =
      doFilterWithTotalEntitiesNumber(data, _ => LiteralColumn(true))
  }

  trait FilterAPI[Entity, Formatter] {

    def filter(data: FilterDefinition): DBIO[Seq[Entity]]

    def filterWithTotalEntitiesNumber(data: FilterDefinition)(
      implicit
      executionContext: ExecutionContext): DBIO[FilterResult[Entity]]

    def emptyFilterData: FilterDefinition

    val formatter: Formatter
  }

  abstract class ContextedFilterAPI[Context, Entity, Formatter] extends (Context => FilterAPI[Entity, Formatter]) {
    private[beholder] def filterFormatter: Formatter
  }

  case class FilterResult[T](data: Seq[T], total: Int) {

    def this(data: Seq[T]) {
      this(data, data.size)
    }
  }

  object FilterResult {

    import play.api.libs.json._

    implicit def reads[T: Reads]: Reads[FilterResult[T]] = Json.reads[FilterResult[T]]
    implicit def writes[T: Writes]: Writes[FilterResult[T]] = Json.writes[FilterResult[T]]
    def schema[T: Schema](tname: String): Schema[FilterResult[T]] = Schema.derived[FilterResult[T]].name(Schema.SName(s"FilterResult_$tname"))
  }

  case class CompoundResult[T](filter: FilterDefinition, result: FilterResult[T])

  object CompoundResult {
    implicit def writes[T: Writes](implicit fdw: Writes[FilterDefinition]): Writes[CompoundResult[T]] = {
      Json.writes[CompoundResult[T]]
    }
    implicit def reads[T: Reads](implicit fdr: Reads[FilterDefinition]): Reads[CompoundResult[T]] = {
      Json.reads[CompoundResult[T]]
    }
    def schema[T: Schema](tname: String)(implicit fds: Schema[FilterDefinition]) = {
      Schema(
        SchemaType.SProduct(
          List(
            SchemaType.SProductField[CompoundResult[T], FilterDefinition](FieldName("filter"), fds, _ => None),
            SchemaType.SProductField[CompoundResult[T], FilterResult[T]](FieldName("data"), FilterResult.schema(tname), _ => None))))
    }
  }

}