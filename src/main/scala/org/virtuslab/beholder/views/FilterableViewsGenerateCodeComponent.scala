package org.virtuslab.beholder.views

import org.virtuslab.unicorn.UnicornWrapper
import slick.ast.TypedType
import slick.lifted.TupleShape

import scala.reflect.ClassTag

/**
 * Generated code for filterable views.
 */

trait FilterableViewsGenerateCodeComponent extends BaseViewComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._
  import unicorn.profile._
  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType](
    name: String,
    apply: (A1, A2) => T,
    unapply: T => Option[(A1, A2)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _]): TableQuery[BaseView2[T, A1, A2]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2)) =>
              columnsNames = Seq(name1, name2)

              implicit val tupleShape = new TupleShape(s1, s2)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2]), (A1, A2), _]]

              (c1, c2) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView2[T, A1, A2](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView2[T: ClassTag, A1: TypedType, A2: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2) => T,
    unapply: T => Option[(A1, A2)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _]) extends BaseView[A1, T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2))

    implicit val tupleShape = new TupleShape(s1, s2)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2]), (A1, A2), _]]

    def * = (c1, c2) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType](
    name: String,
    apply: (A1, A2, A3) => T,
    unapply: T => Option[(A1, A2, A3)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _]): TableQuery[BaseView3[T, A1, A2, A3]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3)) =>
              columnsNames = Seq(name1, name2, name3)

              implicit val tupleShape = new TupleShape(s1, s2, s3)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3]), (A1, A2, A3), _]]

              (c1, c2, c3) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView3[T, A1, A2, A3](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView3[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3) => T,
    unapply: T => Option[(A1, A2, A3)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _]) extends BaseView[A1, T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3))

    implicit val tupleShape = new TupleShape(s1, s2, s3)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3]), (A1, A2, A3), _]]

    def * = (c1, c2, c3) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType](
    name: String,
    apply: (A1, A2, A3, A4) => T,
    unapply: T => Option[(A1, A2, A3, A4)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _]): TableQuery[BaseView4[T, A1, A2, A3, A4]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4)) =>
              columnsNames = Seq(name1, name2, name3, name4)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4]), (A1, A2, A3, A4), _]]

              (c1, c2, c3, c4) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView4[T, A1, A2, A3, A4](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView4[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4) => T,
    unapply: T => Option[(A1, A2, A3, A4)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _]) extends BaseView[A1, T](tag, name) {
    def c1 = column[A1](columnNames(0))
    def c2 = column[A2](columnNames(1))
    def c3 = column[A3](columnNames(2))
    def c4 = column[A4](columnNames(3))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2),
      columnNames(2) -> (_.c3),
      columnNames(3) -> (_.c4))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4]), (A1, A2, A3, A4), _]]

    def * = (c1, c2, c3, c4) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _]): TableQuery[BaseView5[T, A1, A2, A3, A4, A5]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5]), (A1, A2, A3, A4, A5), _]]

              (c1, c2, c3, c4, c5) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView5[T, A1, A2, A3, A4, A5](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView5[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(4) -> (_.c5))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5]), (A1, A2, A3, A4, A5), _]]

    def * = (c1, c2, c3, c4, c5) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _]): TableQuery[BaseView6[T, A1, A2, A3, A4, A5, A6]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6]), (A1, A2, A3, A4, A5, A6), _]]

              (c1, c2, c3, c4, c5, c6) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView6[T, A1, A2, A3, A4, A5, A6](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView6[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(5) -> (_.c6))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6]), (A1, A2, A3, A4, A5, A6), _]]

    def * = (c1, c2, c3, c4, c5, c6) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _]): TableQuery[BaseView7[T, A1, A2, A3, A4, A5, A6, A7]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7]), (A1, A2, A3, A4, A5, A6, A7), _]]

              (c1, c2, c3, c4, c5, c6, c7) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView7[T, A1, A2, A3, A4, A5, A6, A7](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView7[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(6) -> (_.c7))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7]), (A1, A2, A3, A4, A5, A6, A7), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _]): TableQuery[BaseView8[T, A1, A2, A3, A4, A5, A6, A7, A8]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8]), (A1, A2, A3, A4, A5, A6, A7, A8), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView8[T, A1, A2, A3, A4, A5, A6, A7, A8](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView8[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(7) -> (_.c8))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8]), (A1, A2, A3, A4, A5, A6, A7, A8), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _]): TableQuery[BaseView9[T, A1, A2, A3, A4, A5, A6, A7, A8, A9]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9]), (A1, A2, A3, A4, A5, A6, A7, A8, A9), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView9[T, A1, A2, A3, A4, A5, A6, A7, A8, A9](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView9[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(8) -> (_.c9))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9]), (A1, A2, A3, A4, A5, A6, A7, A8, A9), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _]): TableQuery[BaseView10[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView10[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView10[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(9) -> (_.c10))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _]): TableQuery[BaseView11[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView11[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView11[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(10) -> (_.c11))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _]): TableQuery[BaseView12[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView12[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView12[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(11) -> (_.c12))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _]): TableQuery[BaseView13[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView13[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView13[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(12) -> (_.c13))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _]): TableQuery[BaseView14[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView14[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView14[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(13) -> (_.c14))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _]): TableQuery[BaseView15[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView15[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView15[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(14) -> (_.c15))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _]): TableQuery[BaseView16[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView16[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView16[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(15) -> (_.c16))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _]): TableQuery[BaseView17[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView17[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView17[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(16) -> (_.c17))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _]): TableQuery[BaseView18[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView18[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView18[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(17) -> (_.c18))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _]): TableQuery[BaseView19[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView19[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView19[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(18) -> (_.c19))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19]), (String, Rep[A20])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _]): TableQuery[BaseView20[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19), (name20, c20)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19], Rep[A20]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView20[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView20[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(19) -> (_.c20))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19], Rep[A20]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19]), (String, Rep[A20]), (String, Rep[A21])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _]): TableQuery[BaseView21[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19), (name20, c20), (name21, c21)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19], Rep[A20], Rep[A21]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView21[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView21[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(20) -> (_.c21))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19], Rep[A20], Rep[A21]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21) <> (apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType](
    name: String,
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]), (String, Rep[A2]), (String, Rep[A3]), (String, Rep[A4]), (String, Rep[A5]), (String, Rep[A6]), (String, Rep[A7]), (String, Rep[A8]), (String, Rep[A9]), (String, Rep[A10]), (String, Rep[A11]), (String, Rep[A12]), (String, Rep[A13]), (String, Rep[A14]), (String, Rep[A15]), (String, Rep[A16]), (String, Rep[A17]), (String, Rep[A18]), (String, Rep[A19]), (String, Rep[A20]), (String, Rep[A21]), (String, Rep[A22])))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _]): TableQuery[BaseView22[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2), (name3, c3), (name4, c4), (name5, c5), (name6, c6), (name7, c7), (name8, c8), (name9, c9), (name10, c10), (name11, c11), (name12, c12), (name13, c13), (name14, c14), (name15, c15), (name16, c16), (name17, c17), (name18, c18), (name19, c19), (name20, c20), (name21, c21), (name22, c22)) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22)

              implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22)
                .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19], Rep[A20], Rep[A21], Rep[A22]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22), _]]

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22) <> (apply.tupled, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView22[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView22[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => T,
    unapply: T => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _]) extends BaseView[A1, T](tag, name) {
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
      columnNames(21) -> (_.c22))

    implicit val tupleShape = new TupleShape(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22)
      .asInstanceOf[Shape[_ <: FlatShapeLevel, (Rep[A1], Rep[A2], Rep[A3], Rep[A4], Rep[A5], Rep[A6], Rep[A7], Rep[A8], Rep[A9], Rep[A10], Rep[A11], Rep[A12], Rep[A13], Rep[A14], Rep[A15], Rep[A16], Rep[A17], Rep[A18], Rep[A19], Rep[A20], Rep[A21], Rep[A22]), (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22), _]]

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22) <> (apply.tupled, unapply)
  }
}