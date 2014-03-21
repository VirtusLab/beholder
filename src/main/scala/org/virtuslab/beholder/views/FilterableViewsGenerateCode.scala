package org.virtuslab.beholder.views

import scala.slick.ast.Node
import scala.slick.driver.BasicQueryTemplate
import play.api.db.slick.Config.driver.simple._
import org.virtuslab.unicorn.ids._

/**
 * @author krzysiek
 */
trait FilterableViewsGenerateCode {
  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper](name: String,
                                                                       apply: (A1, A2, A3) => T,
                                                                       unapply: T => Option[(A1, A2, A3)],
                                                                       baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]))): BaseView3[T, A1, A2, A3] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3)) =>
              columnsNames = Seq(name1, name2, name3)
              c1 ~ c2 ~ c3 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView3[T, A1, A2, A3](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView3[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper](name: String,
                                                                     val columnNames: Seq[String],
                                                                     apply: (A1, A2, A3) => T,
                                                                     unapply: T => Option[(A1, A2, A3)],
                                                                     val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3))

    def * = c1 ~ c2 ~ c3 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper](name: String,
                                                                                       apply: (A1, A2, A3, A4) => T,
                                                                                       unapply: T => Option[(A1, A2, A3, A4)],
                                                                                       baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]))): BaseView4[T, A1, A2, A3, A4] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4)) =>
              columnsNames = Seq(name1, name2, name3, name4)
              c1 ~ c2 ~ c3 ~ c4 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView4[T, A1, A2, A3, A4](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView4[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper](name: String,
                                                                                     val columnNames: Seq[String],
                                                                                     apply: (A1, A2, A3, A4) => T,
                                                                                     unapply: T => Option[(A1, A2, A3, A4)],
                                                                                     val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4))

    def * = c1 ~ c2 ~ c3 ~ c4 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper](name: String,
                                                                                                       apply: (A1, A2, A3, A4, A5) => T,
                                                                                                       unapply: T => Option[(A1, A2, A3, A4, A5)],
                                                                                                       baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]))): BaseView5[T, A1, A2, A3, A4, A5] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView5[T, A1, A2, A3, A4, A5](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView5[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper](name: String,
                                                                                                     val columnNames: Seq[String],
                                                                                                     apply: (A1, A2, A3, A4, A5) => T,
                                                                                                     unapply: T => Option[(A1, A2, A3, A4, A5)],
                                                                                                     val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper](name: String,
                                                                                                                       apply: (A1, A2, A3, A4, A5, A6) => T,
                                                                                                                       unapply: T => Option[(A1, A2, A3, A4, A5, A6)],
                                                                                                                       baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]))): BaseView6[T, A1, A2, A3, A4, A5, A6] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView6[T, A1, A2, A3, A4, A5, A6](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView6[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper](name: String,
                                                                                                                     val columnNames: Seq[String],
                                                                                                                     apply: (A1, A2, A3, A4, A5, A6) => T,
                                                                                                                     unapply: T => Option[(A1, A2, A3, A4, A5, A6)],
                                                                                                                     val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper](name: String,
                                                                                                                                       apply: (A1, A2, A3, A4, A5, A6, A7) => T,
                                                                                                                                       unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7)],
                                                                                                                                       baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]))): BaseView7[T, A1, A2, A3, A4, A5, A6, A7] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView7[T, A1, A2, A3, A4, A5, A6, A7](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView7[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper](name: String,
                                                                                                                                     val columnNames: Seq[String],
                                                                                                                                     apply: (A1, A2, A3, A4, A5, A6, A7) => T,
                                                                                                                                     unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7)],
                                                                                                                                     val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper](name: String,
                                                                                                                                                       apply: (A1, A2, A3, A4, A5, A6, A7, A8) => T,
                                                                                                                                                       unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8)],
                                                                                                                                                       baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]))): BaseView8[T, A1, A2, A3, A4, A5, A6, A7, A8] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView8[T, A1, A2, A3, A4, A5, A6, A7, A8](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView8[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper](name: String,
                                                                                                                                                     val columnNames: Seq[String],
                                                                                                                                                     apply: (A1, A2, A3, A4, A5, A6, A7, A8) => T,
                                                                                                                                                     unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8)],
                                                                                                                                                     val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper](name: String,
                                                                                                                                                                       apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => T,
                                                                                                                                                                       unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)],
                                                                                                                                                                       baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]))): BaseView9[T, A1, A2, A3, A4, A5, A6, A7, A8, A9] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView9[T, A1, A2, A3, A4, A5, A6, A7, A8, A9](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView9[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper](name: String,
                                                                                                                                                                     val columnNames: Seq[String],
                                                                                                                                                                     apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => T,
                                                                                                                                                                     unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)],
                                                                                                                                                                     val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper](name: String,
                                                                                                                                                                                        apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T,
                                                                                                                                                                                        unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)],
                                                                                                                                                                                        baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]))): BaseView10[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView10[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView10[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper](name: String,
                                                                                                                                                                                       val columnNames: Seq[String],
                                                                                                                                                                                       apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T,
                                                                                                                                                                                       unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)],
                                                                                                                                                                                       val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper](name: String,
                                                                                                                                                                                                         apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T,
                                                                                                                                                                                                         unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)],
                                                                                                                                                                                                         baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]))): BaseView11[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView11[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView11[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper](name: String,
                                                                                                                                                                                                        val columnNames: Seq[String],
                                                                                                                                                                                                        apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T,
                                                                                                                                                                                                        unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)],
                                                                                                                                                                                                        val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper](name: String,
                                                                                                                                                                                                                          apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T,
                                                                                                                                                                                                                          unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)],
                                                                                                                                                                                                                          baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]), (String, Column[A12]))): BaseView12[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView12[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView12[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper](name: String,
                                                                                                                                                                                                                         val columnNames: Seq[String],
                                                                                                                                                                                                                         apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T,
                                                                                                                                                                                                                         unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)],
                                                                                                                                                                                                                         val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    def c12 = column[A12](columnNames(11))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11),
      columnNames(11) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c12))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper](name: String,
                                                                                                                                                                                                                                           apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T,
                                                                                                                                                                                                                                           unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)],
                                                                                                                                                                                                                                           baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]), (String, Column[A12]), (String, Column[A13]))): BaseView13[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView13[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView13[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper](name: String,
                                                                                                                                                                                                                                          val columnNames: Seq[String],
                                                                                                                                                                                                                                          apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T,
                                                                                                                                                                                                                                          unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)],
                                                                                                                                                                                                                                          val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    def c12 = column[A12](columnNames(11))

    def c13 = column[A13](columnNames(12))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11),
      columnNames(11) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c12),
      columnNames(12) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c13))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper](name: String,
                                                                                                                                                                                                                                                            apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T,
                                                                                                                                                                                                                                                            unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)],
                                                                                                                                                                                                                                                            baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]), (String, Column[A12]), (String, Column[A13]), (String, Column[A14]))): BaseView14[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView14[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView14[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper](name: String,
                                                                                                                                                                                                                                                           val columnNames: Seq[String],
                                                                                                                                                                                                                                                           apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T,
                                                                                                                                                                                                                                                           unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)],
                                                                                                                                                                                                                                                           val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    def c12 = column[A12](columnNames(11))

    def c13 = column[A13](columnNames(12))

    def c14 = column[A14](columnNames(13))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11),
      columnNames(11) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c12),
      columnNames(12) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c13),
      columnNames(13) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c14))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper](name: String,
                                                                                                                                                                                                                                                                             apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T,
                                                                                                                                                                                                                                                                             unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)],
                                                                                                                                                                                                                                                                             baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]), (String, Column[A12]), (String, Column[A13]), (String, Column[A14]), (String, Column[A15]))): BaseView15[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView15[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView15[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper](name: String,
                                                                                                                                                                                                                                                                            val columnNames: Seq[String],
                                                                                                                                                                                                                                                                            apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T,
                                                                                                                                                                                                                                                                            unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)],
                                                                                                                                                                                                                                                                            val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    def c12 = column[A12](columnNames(11))

    def c13 = column[A13](columnNames(12))

    def c14 = column[A14](columnNames(13))

    def c15 = column[A15](columnNames(14))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11),
      columnNames(11) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c12),
      columnNames(12) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c13),
      columnNames(13) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c14),
      columnNames(14) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c15))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper](name: String,
                                                                                                                                                                                                                                                                                              apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T,
                                                                                                                                                                                                                                                                                              unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)],
                                                                                                                                                                                                                                                                                              baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]), (String, Column[A12]), (String, Column[A13]), (String, Column[A14]), (String, Column[A15]), (String, Column[A16]))): BaseView16[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 ~ c16 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView16[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView16[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper](name: String,
                                                                                                                                                                                                                                                                                             val columnNames: Seq[String],
                                                                                                                                                                                                                                                                                             apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T,
                                                                                                                                                                                                                                                                                             unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)],
                                                                                                                                                                                                                                                                                             val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    def c12 = column[A12](columnNames(11))

    def c13 = column[A13](columnNames(12))

    def c14 = column[A14](columnNames(13))

    def c15 = column[A15](columnNames(14))

    def c16 = column[A16](columnNames(15))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11),
      columnNames(11) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c12),
      columnNames(12) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c13),
      columnNames(13) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c14),
      columnNames(14) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c15),
      columnNames(15) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c16))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 ~ c16 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper, A17: TypeMapper](name: String,
                                                                                                                                                                                                                                                                                                               apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T,
                                                                                                                                                                                                                                                                                                               unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)],
                                                                                                                                                                                                                                                                                                               baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]), (String, Column[A12]), (String, Column[A13]), (String, Column[A14]), (String, Column[A15]), (String, Column[A16]), (String, Column[A17]))): BaseView17[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 ~ c16 ~ c17 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView17[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView17[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper, A17: TypeMapper](name: String,
                                                                                                                                                                                                                                                                                                              val columnNames: Seq[String],
                                                                                                                                                                                                                                                                                                              apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T,
                                                                                                                                                                                                                                                                                                              unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)],
                                                                                                                                                                                                                                                                                                              val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    def c12 = column[A12](columnNames(11))

    def c13 = column[A13](columnNames(12))

    def c14 = column[A14](columnNames(13))

    def c15 = column[A15](columnNames(14))

    def c16 = column[A16](columnNames(15))

    def c17 = column[A17](columnNames(16))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11),
      columnNames(11) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c12),
      columnNames(12) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c13),
      columnNames(13) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c14),
      columnNames(14) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c15),
      columnNames(15) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c16),
      columnNames(16) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c17))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 ~ c16 ~ c17 <> (apply, unapply)
  }

  def createView[T, E, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper, A17: TypeMapper, A18: TypeMapper](name: String,
                                                                                                                                                                                                                                                                                                                                apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T,
                                                                                                                                                                                                                                                                                                                                unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)],
                                                                                                                                                                                                                                                                                                                                baseQuery: Query[E, _])(mappings: E => ((String, Column[A1]), (String, Column[A2]), (String, Column[A3]), (String, Column[A4]), (String, Column[A5]), (String, Column[A6]), (String, Column[A7]), (String, Column[A8]), (String, Column[A9]), (String, Column[A10]), (String, Column[A11]), (String, Column[A12]), (String, Column[A13]), (String, Column[A14]), (String, Column[A15]), (String, Column[A16]), (String, Column[A17]), (String, Column[A18]))): BaseView18[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18)
              c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 ~ c16 ~ c17 ~ c18 <> (apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }
    new BaseView18[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](name, columnsNames, apply, unapply, preparedQuery)
  }

  class BaseView18[T, A1: TypeMapper, A2: TypeMapper, A3: TypeMapper, A4: TypeMapper, A5: TypeMapper, A6: TypeMapper, A7: TypeMapper, A8: TypeMapper, A9: TypeMapper, A10: TypeMapper, A11: TypeMapper, A12: TypeMapper, A13: TypeMapper, A14: TypeMapper, A15: TypeMapper, A16: TypeMapper, A17: TypeMapper, A18: TypeMapper](name: String,
                                                                                                                                                                                                                                                                                                                               val columnNames: Seq[String],
                                                                                                                                                                                                                                                                                                                               apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T,
                                                                                                                                                                                                                                                                                                                               unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)],
                                                                                                                                                                                                                                                                                                                               val query: BasicQueryTemplate[_, T])
    extends BaseView[A1, T](name) {
    def c1 = column[A1](columnNames(0))

    def c2 = column[A2](columnNames(1))

    def c3 = column[A3](columnNames(2))

    def c4 = column[A4](columnNames(3))

    def c5 = column[A5](columnNames(4))

    def c6 = column[A6](columnNames(5))

    def c7 = column[A7](columnNames(6))

    def c8 = column[A8](columnNames(7))

    def c9 = column[A9](columnNames(8))

    def c10 = column[A10](columnNames(9))

    def c11 = column[A11](columnNames(10))

    def c12 = column[A12](columnNames(11))

    def c13 = column[A13](columnNames(12))

    def c14 = column[A14](columnNames(13))

    def c15 = column[A15](columnNames(14))

    def c16 = column[A16](columnNames(15))

    def c17 = column[A17](columnNames(16))

    def c18 = column[A18](columnNames(17))

    override def id = c1

    override protected val columns = Map(
      columnNames(0) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c1),
      columnNames(1) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c2),
      columnNames(2) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c3),
      columnNames(3) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c4),
      columnNames(4) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c5),
      columnNames(5) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c6),
      columnNames(6) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c7),
      columnNames(7) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c8),
      columnNames(8) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c9),
      columnNames(9) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c10),
      columnNames(10) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c11),
      columnNames(11) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c12),
      columnNames(12) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c13),
      columnNames(13) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c14),
      columnNames(14) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c15),
      columnNames(15) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c16),
      columnNames(16) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c17),
      columnNames(17) -> ((t: BaseTable[T]) => t.asInstanceOf[this.type].c18))

    def * = c1 ~ c2 ~ c3 ~ c4 ~ c5 ~ c6 ~ c7 ~ c8 ~ c9 ~ c10 ~ c11 ~ c12 ~ c13 ~ c14 ~ c15 ~ c16 ~ c17 ~ c18 <> (apply, unapply)
  }

}
