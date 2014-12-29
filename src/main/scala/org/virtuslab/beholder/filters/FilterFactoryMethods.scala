package org.virtuslab.beholder.filters

import scala.slick.ast.TypedType
import scala.slick.lifted.TableQuery
import org.virtuslab.beholder.views.FilterableViews._
import org.virtuslab.unicorn.LongUnicornPlay

private[beholder] object FormFiltersGenerator extends App {
  final def generateCode = {
    (3 to 18).map {
      implicit nr =>
        import org.virtuslab.beholder.utils.CodeGenerationUtils._

        val fieldFilters = fill(nr => s"c${nr}Mapping: FieldType[A$nr, B$nr]", ",\n")
        val mappings = fill(n => s"c${n}Mapping")
        val columnsNames = fill("table.c" + _)

        s"""
          |def create[$aTypesWithTypedType,
          |           $bTypes,
          |           T <: BaseView$nr[Entity,
          |             $aTypes]](table: TableQuery[T],
          |                       $fieldFilters):
          |             FilterAPI[Entity, Formatter] = {
          |
          |    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
          |
          |      override def formatter: Formatter = createFormatter(this)
          |
          |      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill($nr)(None)
          |
          |      override def filterFields: Seq[FieldType[_, _]] =
          |       Seq[FieldType[_, _]]($mappings)
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

  def create[A1: TypedType, A2: TypedType, A3: TypedType, B1, B2, B3, T <: BaseView3[Entity, A1, A2, A3]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(3)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, B1, B2, B3, B4, T <: BaseView4[Entity, A1, A2, A3, A4]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(4)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4
      )
    }
  }

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

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, B1, B2, B3, B4, B5, B6, T <: BaseView6[Entity, A1, A2, A3, A4, A5, A6]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(6)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, B1, B2, B3, B4, B5, B6, B7, T <: BaseView7[Entity, A1, A2, A3, A4, A5, A6, A7]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(7)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, T <: BaseView8[Entity, A1, A2, A3, A4, A5, A6, A7, A8]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(8)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, T <: BaseView9[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(9)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, T <: BaseView10[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(10)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, T <: BaseView11[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(11)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, T <: BaseView12[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11],
    c12Mapping: FieldType[A12, B12]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(12)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, T <: BaseView13[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11],
    c12Mapping: FieldType[A12, B12],
    c13Mapping: FieldType[A13, B13]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(13)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, T <: BaseView14[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11],
    c12Mapping: FieldType[A12, B12],
    c13Mapping: FieldType[A13, B13],
    c14Mapping: FieldType[A14, B14]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(14)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, T <: BaseView15[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11],
    c12Mapping: FieldType[A12, B12],
    c13Mapping: FieldType[A13, B13],
    c14Mapping: FieldType[A14, B14],
    c15Mapping: FieldType[A15, B15]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(15)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, T <: BaseView16[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11],
    c12Mapping: FieldType[A12, B12],
    c13Mapping: FieldType[A13, B13],
    c14Mapping: FieldType[A14, B14],
    c15Mapping: FieldType[A15, B15],
    c16Mapping: FieldType[A16, B16]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(16)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, T <: BaseView17[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11],
    c12Mapping: FieldType[A12, B12],
    c13Mapping: FieldType[A13, B13],
    c14Mapping: FieldType[A14, B14],
    c15Mapping: FieldType[A15, B15],
    c16Mapping: FieldType[A16, B16],
    c17Mapping: FieldType[A17, B17]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(17)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, T <: BaseView18[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]](
    table: TableQuery[T],
    c1Mapping: FieldType[A1, B1],
    c2Mapping: FieldType[A2, B2],
    c3Mapping: FieldType[A3, B3],
    c4Mapping: FieldType[A4, B4],
    c5Mapping: FieldType[A5, B5],
    c6Mapping: FieldType[A6, B6],
    c7Mapping: FieldType[A7, B7],
    c8Mapping: FieldType[A8, B8],
    c9Mapping: FieldType[A9, B9],
    c10Mapping: FieldType[A10, B10],
    c11Mapping: FieldType[A11, B11],
    c12Mapping: FieldType[A12, B12],
    c13Mapping: FieldType[A13, B13],
    c14Mapping: FieldType[A14, B14],
    c15Mapping: FieldType[A15, B15],
    c16Mapping: FieldType[A16, B16],
    c17Mapping: FieldType[A17, B17],
    c18Mapping: FieldType[A18, B18]
  ): FilterAPI[Entity, Formatter] = {

    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {

      override def formatter: Formatter = createFormatter(this)

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(18)(None)

      override def filterFields: Seq[FieldType[_, _]] =
        Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18
      )
    }
  }

}
