package org.virtuslab.beholder.filters

import scala.slick.ast.TypedType
import scala.slick.lifted.TableQuery
import org.virtuslab.beholder.filters.forms.FormFilterField
import org.virtuslab.beholder.views.FilterableViews._
import org.virtuslab.unicorn.LongUnicornPlay

private[beholder] object FormFiltersGenerator extends App {
  final def generateCode = {
    (3 to 18).map {
      implicit nr =>
        import org.virtuslab.beholder.utils.CodeGenerationUtils._

        val fieldFilters = fill(nr => s"c${nr}Mapping: FormFilterField[A$nr, B$nr]", ",\n")
        val mappings = fill(n => s"c${n}Mapping")
        val columnsNames = fill("table.c" + _)

        s"""
          |def create[$aTypesWithTypedType,
          |           $bTypes,
          |           T <: BaseView$nr[Entity,
          |             $aTypes]](table: TableQuery[T],
          |                       $fieldFilters):
          |             BaseFormFilter[A1, Entity, T] = {
          |
          |    new BaseFormFilter[A1, Entity, T](table) {
          |
          |      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill($nr)(None)
          |
          |      override protected def filterFields: Seq[FormFilterField[_, _]] =
          |       Seq($mappings)
          |
          |      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
          |       $columnsNames
          |      )
          |    }
          |  }
        """.stripMargin

    }
  }

  println(generateCode.mkString("\n"))
}

/**
 * Author: Krzysztof Romanowski
 */
abstract class FilterFactoryMethods[Entity, FieldType[_, _] <: MappedFilterField[_, _], Formatter] {

  def createFormatter(table: BaseFilter[_, _, _, FieldType[_, _], Formatter]): Formatter

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, B1, B2, B3, B4, B5, T <: BaseView5[Entity, A1, A2, A3, A4, A5]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(5)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5
      )
    }
  }
}
