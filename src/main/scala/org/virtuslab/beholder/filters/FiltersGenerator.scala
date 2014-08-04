package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.FilterableViews.BaseView2
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.data.Forms._
import play.api.data.Mapping
import scala.slick.ast.TypedType

final class FiltersGenerator[Entity] extends FiltersGeneratedCode[Entity] {

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
  def create[A1: TypedType, A2: TypedType, T <: BaseView2[Entity, A1, A2], B1, B2](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2])](table) {
      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2]) = (None, None)

      protected def filters(data: (Option[B1], Option[B2]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2) =>
          val realTable = obtainRealTable
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }
}

/**
 * Generates inners of FiltersGeneratedCode class
 */
private[beholder] object FiltersGenerator extends App {
  final def generateCode = {
    (3 to 18).map {
      implicit nr =>
        import org.virtuslab.beholder.utils.CodeGenerationUtils._

        val fieldFilters = fill(nr => s"c${nr}Mapping: FilterField[A$nr, B$nr]", ",\n")
        val options = fill(nr => s"Option[B$nr]")
        val columnsNames = fill("c" + _)
        val filterMappings = fill(nr => s"realTable.columnNames(${nr - 1}) -> optional(c${nr}Mapping.mapping)", ",\n")
        val queryFilters = fill(nr => s"c$nr.map(c${nr}Mapping.filterOnColumn(realTable.c$nr))", ",\n")
        val nones = fill(nr => "None")
        s"""
          |def create[$aTypesWithTypedType, $bTypes, T <: BaseView$nr[Entity, $aTypes]](table: TableQuery[T],
          |                                                                   $fieldFilters
          | ): BaseFilter[A1, Entity, T, ($options)] = {
          |
          |    def obtainRealTable = table.shaped.value
          |
          |    new BaseFilter[A1, Entity, T, ($options)](table) {
          |
          |      private val realTable = obtainRealTable
          |
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
          |          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
          |            _ && _
          |          }
          |      }
          |    }
          |  }""".stripMargin
    }
  }

  println(generateCode.mkString("\n"))
}