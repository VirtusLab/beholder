package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay
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

abstract class BareFilter[E, DbE, T, FT <: FilterField, Formatter] extends MappableFilterAPI[E, Formatter, FT] {

  private type FilterQuery = Query[T, DbE, Seq]

  protected def table: FilterQuery

  protected def tableColumns(table: T): Seq[Column[_]]

  def mappingFunction(e: DbE): E

  def columnByName(table: T, name: String): Column[_]

  def defaultColumn(table: T): Column[_]

  /**
   * Empty data for filter representing empty filter (all fields in tuple (type M) are filled with Empty)
   */
  //TODO
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
  protected def filters(data: Seq[Option[Any]])(table: T): Column[Option[Boolean]] = {
    columnsFilters(table, data).foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
      _ && _
    }
  }

  /**
   * @return data representing empty filter - query for all entities in table
   */
  final override def emptyFilterData: FilterDefinition = FilterDefinition(None, None, None, emptyFilterDataInner)

  private def createFilter(data: FilterDefinition): FilterQuery = {
    table.filter(filters(data.data))
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
  final override def filter(data: FilterDefinition)(implicit session: Session): Seq[E] =
    takeAndSkip(data, createFilter(data))

  override def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[E] = {
    val filter = createFilter(data)
    FilterResult(takeAndSkip(data, filter), filter.length.run)
  }
}

/**
 * Base filter class, contains public operations for all filters instances.
 *
 * @param table table to filter on
 * @tparam Id table id
 * @tparam Entity table entity
 * @tparam FilterTable table class (usually View.type)
 */
abstract class BaseFilter[Id, Entity, FilterTable <: BaseView[Id, Entity], FieldType <: FilterField, Formatter](val table: TableQuery[FilterTable])
    extends BareFilter[Entity, Entity, FilterTable, FieldType, Formatter] {

  override def columnsNames: Seq[String] = table.shaped.value.columnsNames

  override def mappingFunction(e: Entity): Entity = e

  override def columnByName(table: FilterTable, name: String): Column[_] = table.columnByName(name)

  override def defaultColumn(table: FilterTable): Column[_] = table.id
}

trait FilterAPI[Entity, Formatter] {

  def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity]

  def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[Entity]

  def emptyFilterData: FilterDefinition

  val formatter: Formatter
}

trait MappableFilterAPI[Entity, Formatter, FT] extends FilterAPI[Entity, Formatter] {

  def columnsNames: Seq[String]

  def filterFields: Seq[FT]

  private val parentObject = this

  def withFormat[NF](f: MappableFilterAPI[Entity, Formatter, FT] => NF): FilterAPI[Entity, NF] = new MappableFilterAPI[Entity, NF, FT] {
    override def columnsNames: Seq[String] = parentObject.columnsNames

    override def filterFields: Seq[FT] = parentObject.filterFields

    override def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity] = parentObject.filter(data)

    override def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[Entity] =
      parentObject.filterWithTotalEntitiesNumber(data)

    override def emptyFilterData: FilterDefinition = parentObject.emptyFilterData

    override val formatter: NF = f(parentObject)
  }

  def mapped[NE](mapping: Entity => NE): FilterAPI[NE, Formatter] = new MappableFilterAPI[NE, Formatter, FT] {
    override def columnsNames: Seq[String] = parentObject.columnsNames

    override def filterFields: Seq[FT] = parentObject.filterFields

    override def filter(data: FilterDefinition)(implicit session: Session): Seq[NE] =
      parentObject.filter(data).map(mapping)

    override def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[NE] = {
      val res = parentObject.filterWithTotalEntitiesNumber(data)
      res.copy(content = res.content.map(mapping))
    }

    override def emptyFilterData: FilterDefinition = parentObject.emptyFilterData

    override val formatter: Formatter = parentObject.formatter
  }

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