package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.FilterableViewsGenerateCodeComponent
import org.virtuslab.unicorn.UnicornWrapper

import slick.ast.TypedType
/**
 * Generated code
 */

trait FilterFactoryMethodsComponent extends FilterFieldComponent with BaseFilterComponent
  with FilterableViewsGenerateCodeComponent {
  self: UnicornWrapper[Long] =>

  import unicorn._
  import unicorn.profile.api._

  abstract class FilterFactoryMethods[Entity, FieldType[_, _] <: MappedFilterField[_, _], Formatter] {

    def createFormatter(table: BaseFilter[_, _, _, FieldType[_, _], Formatter]): Formatter

    def create[A1: TypedType, A2: TypedType, B1, B2, T <: BaseView2[Entity, A1, A2]](
      table: TableQuery[T],
      c1Mapping: FieldType[A1, B1],
      c2Mapping: FieldType[A2, B2]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(2)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, B1, B2, B3, T <: BaseView3[Entity, A1, A2, A3]](
      table: TableQuery[T],
      c1Mapping: FieldType[A1, B1],
      c2Mapping: FieldType[A2, B2],
      c3Mapping: FieldType[A3, B3]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(3)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, B1, B2, B3, B4, T <: BaseView4[Entity, A1, A2, A3, A4]](
      table: TableQuery[T],
      c1Mapping: FieldType[A1, B1],
      c2Mapping: FieldType[A2, B2],
      c3Mapping: FieldType[A3, B3],
      c4Mapping: FieldType[A4, B4]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(4)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, B1, B2, B3, B4, B5, T <: BaseView5[Entity, A1, A2, A3, A4, A5]](
      table: TableQuery[T],
      c1Mapping: FieldType[A1, B1],
      c2Mapping: FieldType[A2, B2],
      c3Mapping: FieldType[A3, B3],
      c4Mapping: FieldType[A4, B4],
      c5Mapping: FieldType[A5, B5]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(5)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, B1, B2, B3, B4, B5, B6, T <: BaseView6[Entity, A1, A2, A3, A4, A5, A6]](
      table: TableQuery[T],
      c1Mapping: FieldType[A1, B1],
      c2Mapping: FieldType[A2, B2],
      c3Mapping: FieldType[A3, B3],
      c4Mapping: FieldType[A4, B4],
      c5Mapping: FieldType[A5, B5],
      c6Mapping: FieldType[A6, B6]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(6)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6)
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
      c7Mapping: FieldType[A7, B7]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(7)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7)
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
      c8Mapping: FieldType[A8, B8]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(8)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8)
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
      c9Mapping: FieldType[A9, B9]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(9)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9)
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
      c10Mapping: FieldType[A10, B10]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(10)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10)
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
      c11Mapping: FieldType[A11, B11]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(11)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11)
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
      c12Mapping: FieldType[A12, B12]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(12)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12)
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
      c13Mapping: FieldType[A13, B13]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(13)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13)
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
      c14Mapping: FieldType[A14, B14]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(14)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14)
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
      c15Mapping: FieldType[A15, B15]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(15)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15)
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
      c16Mapping: FieldType[A16, B16]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(16)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16)
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
      c17Mapping: FieldType[A17, B17]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(17)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17)
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
      c18Mapping: FieldType[A18, B18]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(18)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, T <: BaseView19[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(19)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, T <: BaseView20[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(20)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, T <: BaseView21[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(21)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, T <: BaseView22[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(22)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, T <: BaseView23[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(23)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, T <: BaseView24[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(24)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, T <: BaseView25[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(25)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, T <: BaseView26[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(26)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, T <: BaseView27[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(27)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, T <: BaseView28[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(28)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, T <: BaseView29[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(29)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, T <: BaseView30[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(30)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, T <: BaseView31[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(31)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, T <: BaseView32[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(32)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, T <: BaseView33[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(33)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, T <: BaseView34[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(34)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, T <: BaseView35[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(35)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, T <: BaseView36[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(36)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, T <: BaseView37[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(37)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, T <: BaseView38[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(38)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, T <: BaseView39[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(39)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, T <: BaseView40[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(40)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, T <: BaseView41[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(41)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, T <: BaseView42[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(42)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, T <: BaseView43[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(43)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, B44, T <: BaseView44[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43],
      c44Mapping: FieldType[A44, B44]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(44)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping, c44Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43, table.c44)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, B44, B45, T <: BaseView45[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43],
      c44Mapping: FieldType[A44, B44],
      c45Mapping: FieldType[A45, B45]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(45)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping, c44Mapping, c45Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43, table.c44, table.c45)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, B44, B45, B46, T <: BaseView46[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43],
      c44Mapping: FieldType[A44, B44],
      c45Mapping: FieldType[A45, B45],
      c46Mapping: FieldType[A46, B46]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(46)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping, c44Mapping, c45Mapping, c46Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43, table.c44, table.c45, table.c46)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, B44, B45, B46, B47, T <: BaseView47[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43],
      c44Mapping: FieldType[A44, B44],
      c45Mapping: FieldType[A45, B45],
      c46Mapping: FieldType[A46, B46],
      c47Mapping: FieldType[A47, B47]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(47)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping, c44Mapping, c45Mapping, c46Mapping, c47Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43, table.c44, table.c45, table.c46, table.c47)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, B44, B45, B46, B47, B48, T <: BaseView48[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43],
      c44Mapping: FieldType[A44, B44],
      c45Mapping: FieldType[A45, B45],
      c46Mapping: FieldType[A46, B46],
      c47Mapping: FieldType[A47, B47],
      c48Mapping: FieldType[A48, B48]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(48)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping, c44Mapping, c45Mapping, c46Mapping, c47Mapping, c48Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43, table.c44, table.c45, table.c46, table.c47, table.c48)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType, A49: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, B44, B45, B46, B47, B48, B49, T <: BaseView49[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48, A49]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43],
      c44Mapping: FieldType[A44, B44],
      c45Mapping: FieldType[A45, B45],
      c46Mapping: FieldType[A46, B46],
      c47Mapping: FieldType[A47, B47],
      c48Mapping: FieldType[A48, B48],
      c49Mapping: FieldType[A49, B49]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(49)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping, c44Mapping, c45Mapping, c46Mapping, c47Mapping, c48Mapping, c49Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43, table.c44, table.c45, table.c46, table.c47, table.c48, table.c49)
      }
    }

    def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType, A49: TypedType, A50: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31, B32, B33, B34, B35, B36, B37, B38, B39, B40, B41, B42, B43, B44, B45, B46, B47, B48, B49, B50, T <: BaseView50[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48, A49, A50]](
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
      c18Mapping: FieldType[A18, B18],
      c19Mapping: FieldType[A19, B19],
      c20Mapping: FieldType[A20, B20],
      c21Mapping: FieldType[A21, B21],
      c22Mapping: FieldType[A22, B22],
      c23Mapping: FieldType[A23, B23],
      c24Mapping: FieldType[A24, B24],
      c25Mapping: FieldType[A25, B25],
      c26Mapping: FieldType[A26, B26],
      c27Mapping: FieldType[A27, B27],
      c28Mapping: FieldType[A28, B28],
      c29Mapping: FieldType[A29, B29],
      c30Mapping: FieldType[A30, B30],
      c31Mapping: FieldType[A31, B31],
      c32Mapping: FieldType[A32, B32],
      c33Mapping: FieldType[A33, B33],
      c34Mapping: FieldType[A34, B34],
      c35Mapping: FieldType[A35, B35],
      c36Mapping: FieldType[A36, B36],
      c37Mapping: FieldType[A37, B37],
      c38Mapping: FieldType[A38, B38],
      c39Mapping: FieldType[A39, B39],
      c40Mapping: FieldType[A40, B40],
      c41Mapping: FieldType[A41, B41],
      c42Mapping: FieldType[A42, B42],
      c43Mapping: FieldType[A43, B43],
      c44Mapping: FieldType[A44, B44],
      c45Mapping: FieldType[A45, B45],
      c46Mapping: FieldType[A46, B46],
      c47Mapping: FieldType[A47, B47],
      c48Mapping: FieldType[A48, B48],
      c49Mapping: FieldType[A49, B49],
      c50Mapping: FieldType[A50, B50]): TableFilterAPI[Entity, Formatter, T] = {

      new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
        override val formatter: Formatter = createFormatter(this)

        override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(50)(None)

        override def filterFields: Seq[FieldType[_, _]] =
          Seq[FieldType[_, _]](c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping, c19Mapping, c20Mapping, c21Mapping, c22Mapping, c23Mapping, c24Mapping, c25Mapping, c26Mapping, c27Mapping, c28Mapping, c29Mapping, c30Mapping, c31Mapping, c32Mapping, c33Mapping, c34Mapping, c35Mapping, c36Mapping, c37Mapping, c38Mapping, c39Mapping, c40Mapping, c41Mapping, c42Mapping, c43Mapping, c44Mapping, c45Mapping, c46Mapping, c47Mapping, c48Mapping, c49Mapping, c50Mapping)

        override protected def tableColumns(table: T): Seq[Rep[_]] = Seq(
          table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18, table.c19, table.c20, table.c21, table.c22, table.c23, table.c24, table.c25, table.c26, table.c27, table.c28, table.c29, table.c30, table.c31, table.c32, table.c33, table.c34, table.c35, table.c36, table.c37, table.c38, table.c39, table.c40, table.c41, table.c42, table.c43, table.c44, table.c45, table.c46, table.c47, table.c48, table.c49, table.c50)
      }
    }
  }
}

