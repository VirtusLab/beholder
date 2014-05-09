package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.BaseView
import play.api.data.{ Form, Mapping }
import play.api.db.slick.Config.driver.simple._
import scala.slick.lifted.TableQuery
import scala.slick.lifted.Ordered

/**
 * Base class that is mapped to form.
 * Contains all common and specific (data field of generic type Data) filter data
 *
 * @param take how many elements to take
 * @param skip how many elements to skip before taking
 * @param orderBy field by which ordering is done
 * @param data
 * @tparam Data type of filter data
 */
case class FilterDefinition[Data](take: Option[Int],
  skip: Option[Int],
  orderBy: Option[Order],
  data: Data)

case class Order(column: String, asc: Boolean)

/**
 * Base filter class, contains public operations for all filters instances.
 *
 * @param table table to filter on
 * @tparam Id table id
 * @tparam Entity table entity
 * @tparam Table table class (usually View.type)
 * @tparam FilteredData filter data type (usually tuple with data)
 */
abstract class BaseFilter[Id, Entity, Table <: BaseView[Id, Entity], FilteredData](val table: TableQuery[Table]) {

  /**
   * from mapping for this filter
   * @return
   */
  protected def filterMapping: Mapping[FilterDefinition[FilteredData]]

  /**
   * Empty data for filter representing empty filter (all fields in tuple (type M) are filled with Empty)
   */
  protected def emptyFilterDataInner: FilteredData

  /**
   * applies filter data into query where clauses
   * @param data
   * @param table
   * @return
   */
  protected def filters(data: FilteredData)(table: Table): Column[Option[Boolean]]

  /**
   * @return data representing empty filter - query for all entities in table
   */
  final def emptyFilterData = FilterDefinition(None, None, None, emptyFilterDataInner)

  /**
   * form for this filter
   * @return
   */
  final def filterForm = Form(filterMapping)

  /**
   * filter and sort all entities with given data
   * @param data
   * @param session
   * @return
   */
  final def filter(data: FilterDefinition[FilteredData])(implicit session: Session): Seq[Entity] = {
    val base = table.filter(filters(data.data)).sortBy {
      inQueryTable =>
        val globalColumns =
          order(data)(inQueryTable).map {
            case (column, asc) => if (asc) column.asc else column.desc
          }.toSeq.flatMap(_.columns)
        new Ordered(globalColumns ++ inQueryTable.id.asc.columns)
    }

    val afterTake = data.take.fold(base)(base.take)
    val afterSkip = data.skip.fold(afterTake)(afterTake.drop)

    afterSkip.list
  }

  //ordering
  private def order(data: FilterDefinition[FilteredData])(table: Table): Option[(Column[_], Boolean)] =
    data.orderBy.map { case order => (table.columnByName(order.column), order.asc) }
}
