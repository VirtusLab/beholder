package org.virtuslab.beholder.views

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import scala.reflect.ClassTag
import slick.lifted.{ TupleShape, Rep, TableQuery, Tag }

/**
 * Generated code for filterable views.
 */
private[beholder] trait FilterableViewsGenerateCode extends FilterableViewsImplicits {

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape](
    name: String,
    apply: (A1, A2, A3) => T,
    unapply: T => Option[(A1, A2, A3)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]))): TableQuery[BaseView3[T, A1, A2, A3]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>

          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3)) =>
              columnsNames = Seq(name1, name2, name3)
              (c1, c2, c3) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView3[T, A1, A2, A3](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView3[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3) => T,
      unapply: T => Option[(A1, A2, A3)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3)
    )

    def * = (c1, c2, c3) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4) => T,
    unapply: T => Option[(A1, A2, A3, A4)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]))): TableQuery[BaseView4[T, A1, A2, A3, A4]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4)) =>
              columnsNames = Seq(name1, name2, name3, name4)
              (c1, c2, c3, c4) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView4[T, A1, A2, A3, A4](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView4[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4) => T,
      unapply: T => Option[(A1, A2, A3, A4)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))
    def c4 = column[A4](columnNames(3))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4)
    )

    def * = (c1, c2, c3, c4) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]))): TableQuery[BaseView5[T, A1, A2, A3, A4, A5]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5)
              (c1, c2, c3, c4, c5) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView5[T, A1, A2, A3, A4, A5](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView5[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))
    def c4 = column[A4](columnNames(3))
    def c5 = column[A5](columnNames(4))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5)
    )

    def * = (c1, c2, c3, c4, c5) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]))): TableQuery[BaseView6[T, A1, A2, A3, A4, A5, A6]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6)
              (c1, c2, c3, c4, c5, c6) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView6[T, A1, A2, A3, A4, A5, A6](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView6[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))
    def c4 = column[A4](columnNames(3))
    def c5 = column[A5](columnNames(4))
    def c6 = column[A6](columnNames(5))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6)
    )

    def * = (c1, c2, c3, c4, c5, c6) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]))): TableQuery[BaseView7[T, A1, A2, A3, A4, A5, A6, A7]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7)
              (c1, c2, c3, c4, c5, c6, c7) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView7[T, A1, A2, A3, A4, A5, A6, A7](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView7[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))
    def c4 = column[A4](columnNames(3))
    def c5 = column[A5](columnNames(4))
    def c6 = column[A6](columnNames(5))
    def c7 = column[A7](columnNames(6))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]))): TableQuery[BaseView8[T, A1, A2, A3, A4, A5, A6, A7, A8]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8)
              (c1, c2, c3, c4, c5, c6, c7, c8) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView8[T, A1, A2, A3, A4, A5, A6, A7, A8](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView8[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))
    def c4 = column[A4](columnNames(3))
    def c5 = column[A5](columnNames(4))
    def c6 = column[A6](columnNames(5))
    def c7 = column[A7](columnNames(6))
    def c8 = column[A8](columnNames(7))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]))): TableQuery[BaseView9[T, A1, A2, A3, A4, A5, A6, A7, A8, A9]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView9[T, A1, A2, A3, A4, A5, A6, A7, A8, A9](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView9[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]))): TableQuery[BaseView10[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView10[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView10[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]))): TableQuery[BaseView11[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView11[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView11[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]))): TableQuery[BaseView12[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView12[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView12[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]))): TableQuery[BaseView13[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView13[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView13[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]))): TableQuery[BaseView14[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView14[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView14[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]))): TableQuery[BaseView15[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView15[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView15[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]))): TableQuery[BaseView16[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView16[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView16[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15),
      columnNames(15) -> (_.c16)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]))): TableQuery[BaseView17[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView17[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView17[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15),
      columnNames(15) -> (_.c16),
      columnNames(16) -> (_.c17)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]))): TableQuery[BaseView18[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView18[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView18[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15),
      columnNames(15) -> (_.c16),
      columnNames(16) -> (_.c17),
      columnNames(17) -> (_.c18)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19]))): TableQuery[BaseView19[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView19[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView19[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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
    def c19 = column[A19](columnNames(18))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15),
      columnNames(15) -> (_.c16),
      columnNames(16) -> (_.c17),
      columnNames(17) -> (_.c18),
      columnNames(18) -> (_.c19)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape, A20: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19]), (String, Rep[A20]))): TableQuery[BaseView20[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19), (name20, c20)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView20[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView20[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape, A20: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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
    def c19 = column[A19](columnNames(18))
    def c20 = column[A20](columnNames(19))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15),
      columnNames(15) -> (_.c16),
      columnNames(16) -> (_.c17),
      columnNames(17) -> (_.c18),
      columnNames(18) -> (_.c19),
      columnNames(19) -> (_.c20)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape, A20: FilterShape, A21: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19]), (String, Rep[A20]), (String, Rep[A21]))): TableQuery[BaseView21[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19), (name20, c20), (name21, c21)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView21[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView21[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape, A20: FilterShape, A21: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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
    def c19 = column[A19](columnNames(18))
    def c20 = column[A20](columnNames(19))
    def c21 = column[A21](columnNames(20))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15),
      columnNames(15) -> (_.c16),
      columnNames(16) -> (_.c17),
      columnNames(17) -> (_.c18),
      columnNames(18) -> (_.c19),
      columnNames(19) -> (_.c20),
      columnNames(20) -> (_.c21)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape, A20: FilterShape, A21: FilterShape, A22: FilterShape](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)],
    baseQuery: Query[E, _, Seq])(
      mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19]), (String, Rep[A20]), (String, Rep[A21]), (String, Rep[A22]))): TableQuery[BaseView22[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19), (name20, c20), (name21, c21), (name22, c22)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22)
              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22) <> (apply.tupled, unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView22[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView22[T: ClassTag, A1: FilterShape, A2: FilterShape, A3: FilterShape, A4: FilterShape, A5: FilterShape, A6: FilterShape, A7: FilterShape, A8: FilterShape, A9: FilterShape, A10: FilterShape, A11: FilterShape, A12: FilterShape, A13: FilterShape, A14: FilterShape, A15: FilterShape, A16: FilterShape, A17: FilterShape, A18: FilterShape, A19: FilterShape, A20: FilterShape, A21: FilterShape, A22: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => T,
      unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
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
    def c19 = column[A19](columnNames(18))
    def c20 = column[A20](columnNames(19))
    def c21 = column[A21](columnNames(20))
    def c22 = column[A22](columnNames(21))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4),
      columnNames(4) -> (_.c5),
      columnNames(5) -> (_.c6),
      columnNames(6) -> (_.c7),
      columnNames(7) -> (_.c8),
      columnNames(8) -> (_.c9),
      columnNames(9) -> (_.c10),
      columnNames(10) -> (_.c11),
      columnNames(11) -> (_.c12),
      columnNames(12) -> (_.c13),
      columnNames(13) -> (_.c14),
      columnNames(14) -> (_.c15),
      columnNames(15) -> (_.c16),
      columnNames(16) -> (_.c17),
      columnNames(17) -> (_.c18),
      columnNames(18) -> (_.c19),
      columnNames(19) -> (_.c20),
      columnNames(20) -> (_.c21),
      columnNames(21) -> (_.c22)
    )

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22) <> (apply.tupled, unapply)
  }

}
