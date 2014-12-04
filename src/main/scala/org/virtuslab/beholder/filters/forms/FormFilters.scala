package org.virtuslab.beholder.filters.forms

import org.virtuslab.beholder.filters.BaseFilter
import scala.slick.ast.TypedType
import org.virtuslab.beholder.views.FilterableViews._
import scala.slick.lifted.TableQuery
import org.virtuslab.unicorn.LongUnicornPlay

class FormFilters[Entity] {

  def create[A1: TypedType, A2: TypedType, A3: TypedType, B1, B2, B3, T <: BaseView3[Entity, A1, A2, A3]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(3)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, B1, B2, B3, B4, T <: BaseView4[Entity, A1, A2, A3, A4]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(4)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, B1, B2, B3, B4, B5, T <: BaseView5[Entity, A1, A2, A3, A4, A5]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(5)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, B1, B2, B3, B4, B5, B6, T <: BaseView6[Entity, A1, A2, A3, A4, A5, A6]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(6)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, B1, B2, B3, B4, B5, B6, B7, T <: BaseView7[Entity, A1, A2, A3, A4, A5, A6, A7]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(7)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, T <: BaseView8[Entity, A1, A2, A3, A4, A5, A6, A7, A8]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(8)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, T <: BaseView9[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(9)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, T <: BaseView10[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(10)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, T <: BaseView11[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(11)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, T <: BaseView12[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11],
    c12Mapping: FormFilterField[A12, B12]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(12)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, T <: BaseView13[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11],
    c12Mapping: FormFilterField[A12, B12],
    c13Mapping: FormFilterField[A13, B13]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(13)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, T <: BaseView14[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11],
    c12Mapping: FormFilterField[A12, B12],
    c13Mapping: FormFilterField[A13, B13],
    c14Mapping: FormFilterField[A14, B14]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(14)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, T <: BaseView15[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11],
    c12Mapping: FormFilterField[A12, B12],
    c13Mapping: FormFilterField[A13, B13],
    c14Mapping: FormFilterField[A14, B14],
    c15Mapping: FormFilterField[A15, B15]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(15)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, T <: BaseView16[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11],
    c12Mapping: FormFilterField[A12, B12],
    c13Mapping: FormFilterField[A13, B13],
    c14Mapping: FormFilterField[A14, B14],
    c15Mapping: FormFilterField[A15, B15],
    c16Mapping: FormFilterField[A16, B16]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(16)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, T <: BaseView17[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11],
    c12Mapping: FormFilterField[A12, B12],
    c13Mapping: FormFilterField[A13, B13],
    c14Mapping: FormFilterField[A14, B14],
    c15Mapping: FormFilterField[A15, B15],
    c16Mapping: FormFilterField[A16, B16],
    c17Mapping: FormFilterField[A17, B17]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(17)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17
      )
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, T <: BaseView18[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]](
    table: TableQuery[T],
    c1Mapping: FormFilterField[A1, B1],
    c2Mapping: FormFilterField[A2, B2],
    c3Mapping: FormFilterField[A3, B3],
    c4Mapping: FormFilterField[A4, B4],
    c5Mapping: FormFilterField[A5, B5],
    c6Mapping: FormFilterField[A6, B6],
    c7Mapping: FormFilterField[A7, B7],
    c8Mapping: FormFilterField[A8, B8],
    c9Mapping: FormFilterField[A9, B9],
    c10Mapping: FormFilterField[A10, B10],
    c11Mapping: FormFilterField[A11, B11],
    c12Mapping: FormFilterField[A12, B12],
    c13Mapping: FormFilterField[A13, B13],
    c14Mapping: FormFilterField[A14, B14],
    c15Mapping: FormFilterField[A15, B15],
    c16Mapping: FormFilterField[A16, B16],
    c17Mapping: FormFilterField[A17, B17],
    c18Mapping: FormFilterField[A18, B18]
  ): BaseFormFilter[A1, Entity, T] = {

    new BaseFormFilter[A1, Entity, T](table) {

      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill(18)(None)

      override protected def filterFields: Seq[FormFilterField[_, _]] =
        Seq(c1Mapping, c2Mapping, c3Mapping, c4Mapping, c5Mapping, c6Mapping, c7Mapping, c8Mapping, c9Mapping, c10Mapping, c11Mapping, c12Mapping, c13Mapping, c14Mapping, c15Mapping, c16Mapping, c17Mapping, c18Mapping)

      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
        table.c1, table.c2, table.c3, table.c4, table.c5, table.c6, table.c7, table.c8, table.c9, table.c10, table.c11, table.c12, table.c13, table.c14, table.c15, table.c16, table.c17, table.c18
      )
    }
  }

}

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
