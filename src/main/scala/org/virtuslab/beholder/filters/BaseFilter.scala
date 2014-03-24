package org.virtuslab.beholder.filters

import play.api.data.Forms._
import play.api.data.{Form, Mapping}
import scala.language.postfixOps
import play.api.db.slick.Config.driver.simple._
import scala.slick.lifted.{Query, Column, TypeMapper}
import org.virtuslab.beholder.views.{FilterableViews, BaseView}
import FilterableViews.BaseView2
import org.virtuslab.beholder.views.BaseView

/**
 * base class that is mapped to form
 * it contain all common and specific (data field of genric type D) filter data
 * @param take
 * @param skip
 * @param orderBy
 * @param asc
 * @param data
 * @tparam D type of filter data
 */
case class BaseFilterEntity[D](take: Option[Int],
                               skip: Option[Int],
                               orderBy: Option[String],
                               asc: Boolean,
                               data: D)

/**
 * base filter class - it contains public operations for all filters instances
 * @param table table to filter on
 * @tparam I table id
 * @tparam E table entity
 * @tparam T table class (usually View.type)
 * @tparam M filter data type (usually tuple with data)
 */
abstract class BaseFilter[I, E, T <: BaseView[I, E], M](val table: T) {

  /**
   * from mapping for this filter
   * @return
   */
  protected def filterMapping: Mapping[BaseFilterEntity[M]]

  /**
   * Empty data for filter representing empty filter (all fields in tuple (type M) are filled with Empty)
   */
  protected def emptyFilterDataInner: M

  /**
   * applies filter data into query where clauses
   * @param data
   * @param table
   * @return
   */
  protected def filters(data: M)(table: T): Column[Option[Boolean]]

  /**
   * @return data representing empty filter - query for all entities in table
   */
  final def emptyFilterData = BaseFilterEntity(None, None, None, asc = true, emptyFilterDataInner)

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
  final def filter(data: BaseFilterEntity[M])(implicit session: Session): Seq[E] = {
    val base = Query(table).filter(filters(data.data)).sortBy {
      inQueryTable =>
        val globalColumns =
          order(data)(inQueryTable).map(c =>
            if (data.asc)
              c.asc
            else
              c.desc
          ).toSeq.flatMap(_.columns)
        new scala.slick.lifted.Ordered(globalColumns ++ inQueryTable.id.asc.columns)
    }

    val fromBase = base.list()

    val afterTake = data.take.map(base.take).getOrElse(base)
    val afterSkip = data.skip.map(afterTake.drop).getOrElse(afterTake)

    afterSkip.list()
  }

  //ordering
  private def order(data: BaseFilterEntity[M])(table: T): Option[Column[_]] = data.orderBy.flatMap(table.columnByName(table))
}

/**
 * genereates inners of FiltersGeneratedCode class
 */
object FiltersGenerator extends App {
  final def generateCode = {
    (3 to 18).map {
      implicit nr =>
        import org.virtuslab.beholder.utils.CodeGenerationUtils._

        val fieldFilters = fill(nr => s"c${nr}Mapping: FilterField[A$nr, B$nr]", ",\n")
        val options = fill(nr => s"Option[B$nr]")
        val columnsNames = fill("c" +)
        val filterMappings = fill(nr => s"table.columnNames(${nr - 1}) -> optional(c${nr}Mapping.mapping)", ",\n")
        val queryFilters = fill(nr => s"c$nr.map(c${nr}Mapping.filterOnColumn(table.c$nr))", ",\n")
        val nones = fill(nr => "None")
        s"""
          |def create[$aTypesWithTypeMappers, $bTypes, T <: BaseView$nr[E, $aTypes]](table: T,
          |                                                                   $fieldFilters
          | ): BaseFilter[A1, E, T, ($options)] = {
          |
          |    new BaseFilter[A1, E, T, ($options)](table) {
          |      def filterMapping: Mapping[BaseFilterEntity[($options)]] = baseFilterEntityMapping(tuple(
          |        $filterMappings
          |      ))
          |
          |      override protected def emptyFilterDataInner: ($options) = ($nones)
          |
          |      protected def filters(data: ($options))(table: T): Column[Option[Boolean]] = data match {
          |        case ($columnsNames) =>
          |          Seq(
          |            $queryFilters
          |          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
          |            _ && _
          |          }
          |      }
          |    }
          |  }""".stripMargin
    }
  }

  println(generateCode.mkString("\n"))
}

class FiltersGenerator[E] extends FiltersGeneratedCode[E] {

  /**
   * create filter for 2 fields view
   * All other create method are base on this one
   * @param table view for filter on
   * @param c1Mapping mapping for first field
   * @param c2Mapping mapping for sec field
   * @tparam A1 type of first field
   * @tparam A2 type of sec field
   * @tparam T type of view (View.type)
   * @tparam B1 filter data types for first field
   * @tparam B2 filter data types for sec field
   * @return
   */
  final def create[A1: TypeMapper, A2: TypeMapper, T <: BaseView2[E, A1, A2], B1, B2](table: T,
                                                                                c1Mapping: FilterField[A1, B1],
                                                                                c2Mapping: FilterField[A2, B2]): BaseFilter[A1, E, T, (Option[B1], Option[B2])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2]) = (None, None)

      protected def filters(data: (Option[B1], Option[B2]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
            _ && _
          }
      }
    }
  }
}