package org.virtuslab.beholder.filters
/*
import scala.slick.lifted.{ Query, Column, TypeMapper }
import play.api.data.Mapping
import play.api.db.slick.Config.driver.simple._
import play.api.data.Forms._
import org.virtuslab.beholder.views.FilterableViews
import FilterableViews._


/**
 * @author krzysiek
 */
trait FiltersGeneratedCode[E] {

  def baseFilterEntityMapping[D](dataMapping: Mapping[D]) = mapping(
    "take" -> optional(number),
    "skip" -> optional(number),
    "orderBy" -> optional(text),
    "asc" -> boolean,
    "data" -> dataMapping
  )(BaseFilterEntity.apply)(BaseFilterEntity.unapply)
/*
  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, B1, B2, B3, T <: BaseView3[E, A1, A2, A3]](table: T,
                                                                                                        c1Mapping: FilterField[A1, B1],
                                                                                                        c2Mapping: FilterField[A2, B2],
                                                                                                        c3Mapping: FilterField[A3, B3]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3]) = (None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, B1, B2, B3, B4, T <: BaseView4[E, A1, A2, A3, A4]](table: T,
                                                                                                                                c1Mapping: FilterField[A1, B1],
                                                                                                                                c2Mapping: FilterField[A2, B2],
                                                                                                                                c3Mapping: FilterField[A3, B3],
                                                                                                                                c4Mapping: FilterField[A4, B4]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4]) = (None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, B1, B2, B3, B4, B5, T <: BaseView5[E, A1, A2, A3, A4, A5]](table: T,
                                                                                                                                                        c1Mapping: FilterField[A1, B1],
                                                                                                                                                        c2Mapping: FilterField[A2, B2],
                                                                                                                                                        c3Mapping: FilterField[A3, B3],
                                                                                                                                                        c4Mapping: FilterField[A4, B4],
                                                                                                                                                        c5Mapping: FilterField[A5, B5]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5]) = (None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, B1, B2, B3, B4, B5, B6, T <: BaseView6[E, A1, A2, A3, A4, A5, A6]](table: T,
                                                                                                                                                                                c1Mapping: FilterField[A1, B1],
                                                                                                                                                                                c2Mapping: FilterField[A2, B2],
                                                                                                                                                                                c3Mapping: FilterField[A3, B3],
                                                                                                                                                                                c4Mapping: FilterField[A4, B4],
                                                                                                                                                                                c5Mapping: FilterField[A5, B5],
                                                                                                                                                                                c6Mapping: FilterField[A6, B6]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6]) = (None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, B1, B2, B3, B4, B5, B6, B7, T <: BaseView7[E, A1, A2, A3, A4, A5, A6, A7]](table: T,
                                                                                                                                                                                                        c1Mapping: FilterField[A1, B1],
                                                                                                                                                                                                        c2Mapping: FilterField[A2, B2],
                                                                                                                                                                                                        c3Mapping: FilterField[A3, B3],
                                                                                                                                                                                                        c4Mapping: FilterField[A4, B4],
                                                                                                                                                                                                        c5Mapping: FilterField[A5, B5],
                                                                                                                                                                                                        c6Mapping: FilterField[A6, B6],
                                                                                                                                                                                                        c7Mapping: FilterField[A7, B7]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7]) = (None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, T <: BaseView8[E, A1, A2, A3, A4, A5, A6, A7, A8]](table: T,
                                                                                                                                                                                                                                c1Mapping: FilterField[A1, B1],
                                                                                                                                                                                                                                c2Mapping: FilterField[A2, B2],
                                                                                                                                                                                                                                c3Mapping: FilterField[A3, B3],
                                                                                                                                                                                                                                c4Mapping: FilterField[A4, B4],
                                                                                                                                                                                                                                c5Mapping: FilterField[A5, B5],
                                                                                                                                                                                                                                c6Mapping: FilterField[A6, B6],
                                                                                                                                                                                                                                c7Mapping: FilterField[A7, B7],
                                                                                                                                                                                                                                c8Mapping: FilterField[A8, B8]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8]) = (None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, T <: BaseView9[E, A1, A2, A3, A4, A5, A6, A7, A8, A9]](table: T,
                                                                                                                                                                                                                                                        c1Mapping: FilterField[A1, B1],
                                                                                                                                                                                                                                                        c2Mapping: FilterField[A2, B2],
                                                                                                                                                                                                                                                        c3Mapping: FilterField[A3, B3],
                                                                                                                                                                                                                                                        c4Mapping: FilterField[A4, B4],
                                                                                                                                                                                                                                                        c5Mapping: FilterField[A5, B5],
                                                                                                                                                                                                                                                        c6Mapping: FilterField[A6, B6],
                                                                                                                                                                                                                                                        c7Mapping: FilterField[A7, B7],
                                                                                                                                                                                                                                                        c8Mapping: FilterField[A8, B8],
                                                                                                                                                                                                                                                        c9Mapping: FilterField[A9, B9]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9]) = (None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, T <: BaseView10[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]](table: T,
                                                                                                                                                                                                                                                                                    c1Mapping: FilterField[A1, B1],
                                                                                                                                                                                                                                                                                    c2Mapping: FilterField[A2, B2],
                                                                                                                                                                                                                                                                                    c3Mapping: FilterField[A3, B3],
                                                                                                                                                                                                                                                                                    c4Mapping: FilterField[A4, B4],
                                                                                                                                                                                                                                                                                    c5Mapping: FilterField[A5, B5],
                                                                                                                                                                                                                                                                                    c6Mapping: FilterField[A6, B6],
                                                                                                                                                                                                                                                                                    c7Mapping: FilterField[A7, B7],
                                                                                                                                                                                                                                                                                    c8Mapping: FilterField[A8, B8],
                                                                                                                                                                                                                                                                                    c9Mapping: FilterField[A9, B9],
                                                                                                                                                                                                                                                                                    c10Mapping: FilterField[A10, B10]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10]) = (None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, T <: BaseView11[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]](table: T,
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
                                                                                                                                                                                                                                                                                                               c11Mapping: FilterField[A11, B11]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11]) = (None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, T <: BaseView12[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]](table: T,
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
                                                                                                                                                                                                                                                                                                                                          c12Mapping: FilterField[A12, B12]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping),
        table.columnNames(11) -> optional(c12Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12]) = (None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11)),
            c12.map(c12Mapping.filterOnColumn(table.c12))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, T <: BaseView13[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]](table: T,
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
                                                                                                                                                                                                                                                                                                                                                                     c13Mapping: FilterField[A13, B13]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping),
        table.columnNames(11) -> optional(c12Mapping.mapping),
        table.columnNames(12) -> optional(c13Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13]) = (None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11)),
            c12.map(c12Mapping.filterOnColumn(table.c12)),
            c13.map(c13Mapping.filterOnColumn(table.c13))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, T <: BaseView14[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]](table: T,
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
                                                                                                                                                                                                                                                                                                                                                                                                c14Mapping: FilterField[A14, B14]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping),
        table.columnNames(11) -> optional(c12Mapping.mapping),
        table.columnNames(12) -> optional(c13Mapping.mapping),
        table.columnNames(13) -> optional(c14Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11)),
            c12.map(c12Mapping.filterOnColumn(table.c12)),
            c13.map(c13Mapping.filterOnColumn(table.c13)),
            c14.map(c14Mapping.filterOnColumn(table.c14))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, T <: BaseView15[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]](table: T,
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
                                                                                                                                                                                                                                                                                                                                                                                                                           c15Mapping: FilterField[A15, B15]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping),
        table.columnNames(11) -> optional(c12Mapping.mapping),
        table.columnNames(12) -> optional(c13Mapping.mapping),
        table.columnNames(13) -> optional(c14Mapping.mapping),
        table.columnNames(14) -> optional(c15Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11)),
            c12.map(c12Mapping.filterOnColumn(table.c12)),
            c13.map(c13Mapping.filterOnColumn(table.c13)),
            c14.map(c14Mapping.filterOnColumn(table.c14)),
            c15.map(c15Mapping.filterOnColumn(table.c15))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, T <: BaseView16[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]](table: T,
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                      c16Mapping: FilterField[A16, B16]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping),
        table.columnNames(11) -> optional(c12Mapping.mapping),
        table.columnNames(12) -> optional(c13Mapping.mapping),
        table.columnNames(13) -> optional(c14Mapping.mapping),
        table.columnNames(14) -> optional(c15Mapping.mapping),
        table.columnNames(15) -> optional(c16Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11)),
            c12.map(c12Mapping.filterOnColumn(table.c12)),
            c13.map(c13Mapping.filterOnColumn(table.c13)),
            c14.map(c14Mapping.filterOnColumn(table.c14)),
            c15.map(c15Mapping.filterOnColumn(table.c15)),
            c16.map(c16Mapping.filterOnColumn(table.c16))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper, A17: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, T <: BaseView17[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]](table: T,
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 c17Mapping: FilterField[A17, B17]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping),
        table.columnNames(11) -> optional(c12Mapping.mapping),
        table.columnNames(12) -> optional(c13Mapping.mapping),
        table.columnNames(13) -> optional(c14Mapping.mapping),
        table.columnNames(14) -> optional(c15Mapping.mapping),
        table.columnNames(15) -> optional(c16Mapping.mapping),
        table.columnNames(16) -> optional(c17Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11)),
            c12.map(c12Mapping.filterOnColumn(table.c12)),
            c13.map(c13Mapping.filterOnColumn(table.c13)),
            c14.map(c14Mapping.filterOnColumn(table.c14)),
            c15.map(c15Mapping.filterOnColumn(table.c15)),
            c16.map(c16Mapping.filterOnColumn(table.c16)),
            c17.map(c17Mapping.filterOnColumn(table.c17))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }

  def create[A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper, A17: TypeMapper, A18: TypeMapper, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, T <: BaseView18[E, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]](table: T,
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            c18Mapping: FilterField[A18, B18]): BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18])] = {

    new BaseFilter[A1, E, T, (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18])](table) {
      def filterMapping: Mapping[BaseFilterEntity[(Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18])]] = baseFilterEntityMapping(tuple(
        table.columnNames(0) -> optional(c1Mapping.mapping),
        table.columnNames(1) -> optional(c2Mapping.mapping),
        table.columnNames(2) -> optional(c3Mapping.mapping),
        table.columnNames(3) -> optional(c4Mapping.mapping),
        table.columnNames(4) -> optional(c5Mapping.mapping),
        table.columnNames(5) -> optional(c6Mapping.mapping),
        table.columnNames(6) -> optional(c7Mapping.mapping),
        table.columnNames(7) -> optional(c8Mapping.mapping),
        table.columnNames(8) -> optional(c9Mapping.mapping),
        table.columnNames(9) -> optional(c10Mapping.mapping),
        table.columnNames(10) -> optional(c11Mapping.mapping),
        table.columnNames(11) -> optional(c12Mapping.mapping),
        table.columnNames(12) -> optional(c13Mapping.mapping),
        table.columnNames(13) -> optional(c14Mapping.mapping),
        table.columnNames(14) -> optional(c15Mapping.mapping),
        table.columnNames(15) -> optional(c16Mapping.mapping),
        table.columnNames(16) -> optional(c17Mapping.mapping),
        table.columnNames(17) -> optional(c18Mapping.mapping)
      ))

      override protected def emptyFilterDataInner: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18]) = (None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

      protected def filters(data: (Option[B1], Option[B2], Option[B3], Option[B4], Option[B5], Option[B6], Option[B7], Option[B8], Option[B9], Option[B10], Option[B11], Option[B12], Option[B13], Option[B14], Option[B15], Option[B16], Option[B17], Option[B18]))(table: T): Column[Option[Boolean]] = data match {
        case (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18) =>
          Seq(
            c1.map(c1Mapping.filterOnColumn(table.c1)),
            c2.map(c2Mapping.filterOnColumn(table.c2)),
            c3.map(c3Mapping.filterOnColumn(table.c3)),
            c4.map(c4Mapping.filterOnColumn(table.c4)),
            c5.map(c5Mapping.filterOnColumn(table.c5)),
            c6.map(c6Mapping.filterOnColumn(table.c6)),
            c7.map(c7Mapping.filterOnColumn(table.c7)),
            c8.map(c8Mapping.filterOnColumn(table.c8)),
            c9.map(c9Mapping.filterOnColumn(table.c9)),
            c10.map(c10Mapping.filterOnColumn(table.c10)),
            c11.map(c11Mapping.filterOnColumn(table.c11)),
            c12.map(c12Mapping.filterOnColumn(table.c12)),
            c13.map(c13Mapping.filterOnColumn(table.c13)),
            c14.map(c14Mapping.filterOnColumn(table.c14)),
            c15.map(c15Mapping.filterOnColumn(table.c15)),
            c16.map(c16Mapping.filterOnColumn(table.c16)),
            c17.map(c17Mapping.filterOnColumn(table.c17)),
            c18.map(c18Mapping.filterOnColumn(table.c18))
          ).flatten.foldLeft(ConstColumn(Some(true)): Column[Option[Boolean]]) {
              _ && _
            }
      }
    }
  }*/
}
*/
