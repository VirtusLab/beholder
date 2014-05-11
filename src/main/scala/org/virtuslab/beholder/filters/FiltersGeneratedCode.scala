package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.FilterableViews._
import org.virtuslab.unicorn.UnicornPlay.driver.simple._
import play.api.data.Forms._
import play.api.data.Mapping
import scala.slick.ast.TypedType
import scala.slick.lifted.{ Column, LiteralColumn, TableQuery }

private[filters] trait BaseFilterData {

  def baseFilterEntityMapping[D](dataMapping: Mapping[D]) = mapping(
    "take" -> optional(number),
    "skip" -> optional(number),
    "orderBy" -> optional(text),
    "asc" -> boolean,
    "data" -> dataMapping
  )(
      (take, skip, orderBy, asc, data) => FilterDefinition[D](take, skip, orderBy.map(Order(_, asc)), data)
    )(
        filter => Some((filter.take, filter.skip, filter.orderBy.map(_.column), filter.orderBy.fold(true)(_.asc), filter.data))
      )
}

/**
 * Generated code for filters
 * @tparam Entity
 */
protected[beholder] trait FiltersGeneratedCode[Entity] extends BaseFilterData {

  def create[A1: TypedType, A2: TypedType, A3: TypedType, B1, B2, B3, T <: BaseView3[Entity, A1, A2, A3]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3]) = (None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, B1, B2, B3, B4, T <: BaseView4[Entity, A1, A2, A3, A4]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4]) = (None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, B1, B2, B3, B4, B5, T <: BaseView5[Entity, A1, A2, A3, A4, A5]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5]) = (None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, B1, B2, B3, B4, B5, B6, T <: BaseView6[Entity, A1, A2, A3, A4, A5, A6]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6]) = (None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, B1, B2, B3, B4, B5, B6, B7, T <: BaseView7[Entity, A1, A2, A3, A4, A5, A6, A7]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7]) = (None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, T <: BaseView8[Entity, A1, A2, A3, A4, A5, A6, A7, A8]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8]) = (None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, T <: BaseView9[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9]) = (None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, T <: BaseView10[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10]) = (None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, T <: BaseView11[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11]) = (None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, T <: BaseView12[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11],
    c12Mapping: FilterField[A12, B12]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping),
        realTable.columnNames(11) -> optional(c12Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12]) = (None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11)),
            c12.map(c12Mapping.filterOnColumn(realTable.c12))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, T <: BaseView13[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11],
    c12Mapping: FilterField[A12, B12],
    c13Mapping: FilterField[A13, B13]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping),
        realTable.columnNames(11) -> optional(c12Mapping.mapping),
        realTable.columnNames(12) -> optional(c13Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13]) = (None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11)),
            c12.map(c12Mapping.filterOnColumn(realTable.c12)),
            c13.map(c13Mapping.filterOnColumn(realTable.c13))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, T <: BaseView14[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11],
    c12Mapping: FilterField[A12, B12],
    c13Mapping: FilterField[A13, B13],
    c14Mapping: FilterField[A14, B14]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping),
        realTable.columnNames(11) -> optional(c12Mapping.mapping),
        realTable.columnNames(12) -> optional(c13Mapping.mapping),
        realTable.columnNames(13) -> optional(c14Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11)),
            c12.map(c12Mapping.filterOnColumn(realTable.c12)),
            c13.map(c13Mapping.filterOnColumn(realTable.c13)),
            c14.map(c14Mapping.filterOnColumn(realTable.c14))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, T <: BaseView15[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11],
    c12Mapping: FilterField[A12, B12],
    c13Mapping: FilterField[A13, B13],
    c14Mapping: FilterField[A14, B14],
    c15Mapping: FilterField[A15, B15]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping),
        realTable.columnNames(11) -> optional(c12Mapping.mapping),
        realTable.columnNames(12) -> optional(c13Mapping.mapping),
        realTable.columnNames(13) -> optional(c14Mapping.mapping),
        realTable.columnNames(14) -> optional(c15Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11)),
            c12.map(c12Mapping.filterOnColumn(realTable.c12)),
            c13.map(c13Mapping.filterOnColumn(realTable.c13)),
            c14.map(c14Mapping.filterOnColumn(realTable.c14)),
            c15.map(c15Mapping.filterOnColumn(realTable.c15))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, T <: BaseView16[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11],
    c12Mapping: FilterField[A12, B12],
    c13Mapping: FilterField[A13, B13],
    c14Mapping: FilterField[A14, B14],
    c15Mapping: FilterField[A15, B15],
    c16Mapping: FilterField[A16, B16]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping),
        realTable.columnNames(11) -> optional(c12Mapping.mapping),
        realTable.columnNames(12) -> optional(c13Mapping.mapping),
        realTable.columnNames(13) -> optional(c14Mapping.mapping),
        realTable.columnNames(14) -> optional(c15Mapping.mapping),
        realTable.columnNames(15) -> optional(c16Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11)),
            c12.map(c12Mapping.filterOnColumn(realTable.c12)),
            c13.map(c13Mapping.filterOnColumn(realTable.c13)),
            c14.map(c14Mapping.filterOnColumn(realTable.c14)),
            c15.map(c15Mapping.filterOnColumn(realTable.c15)),
            c16.map(c16Mapping.filterOnColumn(realTable.c16))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, T <: BaseView17[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11],
    c12Mapping: FilterField[A12, B12],
    c13Mapping: FilterField[A13, B13],
    c14Mapping: FilterField[A14, B14],
    c15Mapping: FilterField[A15, B15],
    c16Mapping: FilterField[A16, B16],
    c17Mapping: FilterField[A17, B17]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping),
        realTable.columnNames(11) -> optional(c12Mapping.mapping),
        realTable.columnNames(12) -> optional(c13Mapping.mapping),
        realTable.columnNames(13) -> optional(c14Mapping.mapping),
        realTable.columnNames(14) -> optional(c15Mapping.mapping),
        realTable.columnNames(15) -> optional(c16Mapping.mapping),
        realTable.columnNames(16) -> optional(c17Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11)),
            c12.map(c12Mapping.filterOnColumn(realTable.c12)),
            c13.map(c13Mapping.filterOnColumn(realTable.c13)),
            c14.map(c14Mapping.filterOnColumn(realTable.c14)),
            c15.map(c15Mapping.filterOnColumn(realTable.c15)),
            c16.map(c16Mapping.filterOnColumn(realTable.c16)),
            c17.map(c17Mapping.filterOnColumn(realTable.c17))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, T <: BaseView18[Entity, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]](table: TableQuery[T],
    c1Mapping: FilterField[A1, B1],
    c2Mapping: FilterField[A2, B2],
    c3Mapping: FilterField[A3, B3],
    c4Mapping: FilterField[A4, B4],
    c5Mapping: FilterField[A5, B5],
    c6Mapping: FilterField[A6, B6],
    c7Mapping: FilterField[A7, B7],
    c8Mapping: FilterField[A8, B8],
    c9Mapping: FilterField[A9, B9],
    c10Mapping: FilterField[A10, B10],
    c11Mapping: FilterField[A11, B11],
    c12Mapping: FilterField[A12, B12],
    c13Mapping: FilterField[A13, B13],
    c14Mapping: FilterField[A14, B14],
    c15Mapping: FilterField[A15, B15],
    c16Mapping: FilterField[A16, B16],
    c17Mapping: FilterField[A17, B17],
    c18Mapping: FilterField[A18, B18]): BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18])] = {

    def obtainRealTable = table.shaped.value

    new BaseFilter[A1, Entity, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18])](table) {

      private val realTable = obtainRealTable

      def filterMapping: Mapping[FilterDefinition[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18])]] = baseFilterEntityMapping(tuple(
        realTable.columnNames(0) -> optional(c1Mapping.mapping),
        realTable.columnNames(1) -> optional(c2Mapping.mapping),
        realTable.columnNames(2) -> optional(c3Mapping.mapping),
        realTable.columnNames(3) -> optional(c4Mapping.mapping),
        realTable.columnNames(4) -> optional(c5Mapping.mapping),
        realTable.columnNames(5) -> optional(c6Mapping.mapping),
        realTable.columnNames(6) -> optional(c7Mapping.mapping),
        realTable.columnNames(7) -> optional(c8Mapping.mapping),
        realTable.columnNames(8) -> optional(c9Mapping.mapping),
        realTable.columnNames(9) -> optional(c10Mapping.mapping),
        realTable.columnNames(10) -> optional(c11Mapping.mapping),
        realTable.columnNames(11) -> optional(c12Mapping.mapping),
        realTable.columnNames(12) -> optional(c13Mapping.mapping),
        realTable.columnNames(13) -> optional(c14Mapping.mapping),
        realTable.columnNames(14) -> optional(c15Mapping.mapping),
        realTable.columnNames(15) -> optional(c16Mapping.mapping),
        realTable.columnNames(16) -> optional(c17Mapping.mapping),
        realTable.columnNames(17) -> optional(c18Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(realTable.c1)),
            c2.map(c2Mapping.filterOnColumn(realTable.c2)),
            c3.map(c3Mapping.filterOnColumn(realTable.c3)),
            c4.map(c4Mapping.filterOnColumn(realTable.c4)),
            c5.map(c5Mapping.filterOnColumn(realTable.c5)),
            c6.map(c6Mapping.filterOnColumn(realTable.c6)),
            c7.map(c7Mapping.filterOnColumn(realTable.c7)),
            c8.map(c8Mapping.filterOnColumn(realTable.c8)),
            c9.map(c9Mapping.filterOnColumn(realTable.c9)),
            c10.map(c10Mapping.filterOnColumn(realTable.c10)),
            c11.map(c11Mapping.filterOnColumn(realTable.c11)),
            c12.map(c12Mapping.filterOnColumn(realTable.c12)),
            c13.map(c13Mapping.filterOnColumn(realTable.c13)),
            c14.map(c14Mapping.filterOnColumn(realTable.c14)),
            c15.map(c15Mapping.filterOnColumn(realTable.c15)),
            c16.map(c16Mapping.filterOnColumn(realTable.c16)),
            c17.map(c17Mapping.filterOnColumn(realTable.c17)),
            c18.map(c18Mapping.filterOnColumn(realTable.c18))
          ).flatten.foldLeft(LiteralColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }
}

