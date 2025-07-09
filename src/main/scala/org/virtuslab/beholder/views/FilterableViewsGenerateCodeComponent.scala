package org.virtuslab.beholder.views

import org.virtuslab.unicorn.UnicornWrapper
import shapeless.Generic.Aux
import shapeless.{ ::, HNil }
import slick.ast.TypedType
import slick.lifted._
import slickless._

import scala.reflect.ClassTag

/**
 * Generated code for filterable views.
 */

trait FilterableViewsGenerateCodeComponent extends BaseViewComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._
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

              (c1, c2).<>(apply.tupled, unapply)
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

    def * = (c1, c2).<>(apply.tupled, unapply)
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

              (c1, c2, c3).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21).<>(apply.tupled, unapply)
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

              (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22).<>(apply.tupled, unapply)
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

    def * = (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22).<>(apply.tupled, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _]): TableQuery[BaseView23[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView23[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView23[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _]): TableQuery[BaseView24[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView24[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView24[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _]): TableQuery[BaseView25[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView25[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView25[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _]): TableQuery[BaseView26[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView26[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView26[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _]): TableQuery[BaseView27[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView27[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView27[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _]): TableQuery[BaseView28[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView28[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView28[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _]): TableQuery[BaseView29[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView29[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView29[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _]): TableQuery[BaseView30[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView30[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView30[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _]): TableQuery[BaseView31[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView31[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView31[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _]): TableQuery[BaseView32[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView32[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView32[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _]): TableQuery[BaseView33[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView33[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView33[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _]): TableQuery[BaseView34[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView34[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView34[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _]): TableQuery[BaseView35[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView35[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView35[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _]): TableQuery[BaseView36[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView36[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView36[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _]): TableQuery[BaseView37[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView37[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView37[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _]): TableQuery[BaseView38[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView38[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView38[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _]): TableQuery[BaseView39[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView39[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView39[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _]): TableQuery[BaseView40[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView40[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView40[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _]): TableQuery[BaseView41[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView41[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView41[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _]): TableQuery[BaseView42[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView42[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView42[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _]): TableQuery[BaseView43[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView43[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView43[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: (String, Rep[A44]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _]): TableQuery[BaseView44[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: (name44, c44) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43, name44)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView44[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView44[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))
    def c44 = column[A44](columnNames(43))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43),
      columnNames(43) -> (_.c44))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: (String, Rep[A44]) :: (String, Rep[A45]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _]): TableQuery[BaseView45[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: (name44, c44) :: (name45, c45) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43, name44, name45)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView45[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView45[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))
    def c44 = column[A44](columnNames(43))
    def c45 = column[A45](columnNames(44))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43),
      columnNames(43) -> (_.c44),
      columnNames(44) -> (_.c45))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: (String, Rep[A44]) :: (String, Rep[A45]) :: (String, Rep[A46]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _]): TableQuery[BaseView46[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: (name44, c44) :: (name45, c45) :: (name46, c46) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43, name44, name45, name46)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView46[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView46[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))
    def c44 = column[A44](columnNames(43))
    def c45 = column[A45](columnNames(44))
    def c46 = column[A46](columnNames(45))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43),
      columnNames(43) -> (_.c44),
      columnNames(44) -> (_.c45),
      columnNames(45) -> (_.c46))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: (String, Rep[A44]) :: (String, Rep[A45]) :: (String, Rep[A46]) :: (String, Rep[A47]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _]): TableQuery[BaseView47[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: (name44, c44) :: (name45, c45) :: (name46, c46) :: (name47, c47) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43, name44, name45, name46, name47)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView47[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView47[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))
    def c44 = column[A44](columnNames(43))
    def c45 = column[A45](columnNames(44))
    def c46 = column[A46](columnNames(45))
    def c47 = column[A47](columnNames(46))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43),
      columnNames(43) -> (_.c44),
      columnNames(44) -> (_.c45),
      columnNames(45) -> (_.c46),
      columnNames(46) -> (_.c47))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: (String, Rep[A44]) :: (String, Rep[A45]) :: (String, Rep[A46]) :: (String, Rep[A47]) :: (String, Rep[A48]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _], s48: Shape[_ <: ShapeLevel, Rep[A48], A48, _]): TableQuery[BaseView48[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: (name44, c44) :: (name45, c45) :: (name46, c46) :: (name47, c47) :: (name48, c48) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43, name44, name45, name46, name47, name48)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: c48 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView48[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView48[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _], s48: Shape[_ <: ShapeLevel, Rep[A48], A48, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))
    def c44 = column[A44](columnNames(43))
    def c45 = column[A45](columnNames(44))
    def c46 = column[A46](columnNames(45))
    def c47 = column[A47](columnNames(46))
    def c48 = column[A48](columnNames(47))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43),
      columnNames(43) -> (_.c44),
      columnNames(44) -> (_.c45),
      columnNames(45) -> (_.c46),
      columnNames(46) -> (_.c47),
      columnNames(47) -> (_.c48))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: c48 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType, A49: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: A49 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: (String, Rep[A44]) :: (String, Rep[A45]) :: (String, Rep[A46]) :: (String, Rep[A47]) :: (String, Rep[A48]) :: (String, Rep[A49]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _], s48: Shape[_ <: ShapeLevel, Rep[A48], A48, _], s49: Shape[_ <: ShapeLevel, Rep[A49], A49, _]): TableQuery[BaseView49[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48, A49]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: (name44, c44) :: (name45, c45) :: (name46, c46) :: (name47, c47) :: (name48, c48) :: (name49, c49) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43, name44, name45, name46, name47, name48, name49)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: c48 :: c49 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView49[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48, A49](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView49[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType, A49: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: A49 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: A49 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _], s48: Shape[_ <: ShapeLevel, Rep[A48], A48, _], s49: Shape[_ <: ShapeLevel, Rep[A49], A49, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))
    def c44 = column[A44](columnNames(43))
    def c45 = column[A45](columnNames(44))
    def c46 = column[A46](columnNames(45))
    def c47 = column[A47](columnNames(46))
    def c48 = column[A48](columnNames(47))
    def c49 = column[A49](columnNames(48))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43),
      columnNames(43) -> (_.c44),
      columnNames(44) -> (_.c45),
      columnNames(45) -> (_.c46),
      columnNames(46) -> (_.c47),
      columnNames(47) -> (_.c48),
      columnNames(48) -> (_.c49))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: c48 :: c49 :: HNil).<>(apply, unapply)
  }

  def createView[T: ClassTag, E, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType, A49: TypedType, A50: TypedType](
    name: String,
    generic: Aux[T, A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: A49 :: A50 :: HNil],
    baseQuery: Query[E, _, Seq])(
    mappings: E => ((String, Rep[A1]) :: (String, Rep[A2]) :: (String, Rep[A3]) :: (String, Rep[A4]) :: (String, Rep[A5]) :: (String, Rep[A6]) :: (String, Rep[A7]) :: (String, Rep[A8]) :: (String, Rep[A9]) :: (String, Rep[A10]) :: (String, Rep[A11]) :: (String, Rep[A12]) :: (String, Rep[A13]) :: (String, Rep[A14]) :: (String, Rep[A15]) :: (String, Rep[A16]) :: (String, Rep[A17]) :: (String, Rep[A18]) :: (String, Rep[A19]) :: (String, Rep[A20]) :: (String, Rep[A21]) :: (String, Rep[A22]) :: (String, Rep[A23]) :: (String, Rep[A24]) :: (String, Rep[A25]) :: (String, Rep[A26]) :: (String, Rep[A27]) :: (String, Rep[A28]) :: (String, Rep[A29]) :: (String, Rep[A30]) :: (String, Rep[A31]) :: (String, Rep[A32]) :: (String, Rep[A33]) :: (String, Rep[A34]) :: (String, Rep[A35]) :: (String, Rep[A36]) :: (String, Rep[A37]) :: (String, Rep[A38]) :: (String, Rep[A39]) :: (String, Rep[A40]) :: (String, Rep[A41]) :: (String, Rep[A42]) :: (String, Rep[A43]) :: (String, Rep[A44]) :: (String, Rep[A45]) :: (String, Rep[A46]) :: (String, Rep[A47]) :: (String, Rep[A48]) :: (String, Rep[A49]) :: (String, Rep[A50]) :: HNil))(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _], s48: Shape[_ <: ShapeLevel, Rep[A48], A48, _], s49: Shape[_ <: ShapeLevel, Rep[A49], A49, _], s50: Shape[_ <: ShapeLevel, Rep[A50], A50, _]): TableQuery[BaseView50[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48, A49, A50]] = {

    var columnsNames = Seq[String]()
    val apply = generic.from _
    val unapply = generic.to _ andThen (Some(_))

    val preparedQuery: Query[_, T, Seq] = {
      baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1) :: (name2, c2) :: (name3, c3) :: (name4, c4) :: (name5, c5) :: (name6, c6) :: (name7, c7) :: (name8, c8) :: (name9, c9) :: (name10, c10) :: (name11, c11) :: (name12, c12) :: (name13, c13) :: (name14, c14) :: (name15, c15) :: (name16, c16) :: (name17, c17) :: (name18, c18) :: (name19, c19) :: (name20, c20) :: (name21, c21) :: (name22, c22) :: (name23, c23) :: (name24, c24) :: (name25, c25) :: (name26, c26) :: (name27, c27) :: (name28, c28) :: (name29, c29) :: (name30, c30) :: (name31, c31) :: (name32, c32) :: (name33, c33) :: (name34, c34) :: (name35, c35) :: (name36, c36) :: (name37, c37) :: (name38, c38) :: (name39, c39) :: (name40, c40) :: (name41, c41) :: (name42, c42) :: (name43, c43) :: (name44, c44) :: (name45, c45) :: (name46, c46) :: (name47, c47) :: (name48, c48) :: (name49, c49) :: (name50, c50) :: HNil) =>
              columnsNames = Seq(name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21, name22, name23, name24, name25, name26, name27, name28, name29, name30, name31, name32, name33, name34, name35, name36, name37, name38, name39, name40, name41, name42, name43, name44, name45, name46, name47, name48, name49, name50)

              (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: c48 :: c49 :: c50 :: HNil).<>(apply, unapply)
          }
      }
    }
    TableQuery.apply(tag => new BaseView50[T, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48, A49, A50](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  class BaseView50[T: ClassTag, A1: TypedType, A2: TypedType, A3: TypedType, A4: TypedType, A5: TypedType, A6: TypedType, A7: TypedType, A8: TypedType, A9: TypedType, A10: TypedType, A11: TypedType, A12: TypedType, A13: TypedType, A14: TypedType, A15: TypedType, A16: TypedType, A17: TypedType, A18: TypedType, A19: TypedType, A20: TypedType, A21: TypedType, A22: TypedType, A23: TypedType, A24: TypedType, A25: TypedType, A26: TypedType, A27: TypedType, A28: TypedType, A29: TypedType, A30: TypedType, A31: TypedType, A32: TypedType, A33: TypedType, A34: TypedType, A35: TypedType, A36: TypedType, A37: TypedType, A38: TypedType, A39: TypedType, A40: TypedType, A41: TypedType, A42: TypedType, A43: TypedType, A44: TypedType, A45: TypedType, A46: TypedType, A47: TypedType, A48: TypedType, A49: TypedType, A50: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: A49 :: A50 :: HNil) => T,
    unapply: T => Option[(A1 :: A2 :: A3 :: A4 :: A5 :: A6 :: A7 :: A8 :: A9 :: A10 :: A11 :: A12 :: A13 :: A14 :: A15 :: A16 :: A17 :: A18 :: A19 :: A20 :: A21 :: A22 :: A23 :: A24 :: A25 :: A26 :: A27 :: A28 :: A29 :: A30 :: A31 :: A32 :: A33 :: A34 :: A35 :: A36 :: A37 :: A38 :: A39 :: A40 :: A41 :: A42 :: A43 :: A44 :: A45 :: A46 :: A47 :: A48 :: A49 :: A50 :: HNil)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A1], A1, _], s2: Shape[_ <: ShapeLevel, Rep[A2], A2, _], s3: Shape[_ <: ShapeLevel, Rep[A3], A3, _], s4: Shape[_ <: ShapeLevel, Rep[A4], A4, _], s5: Shape[_ <: ShapeLevel, Rep[A5], A5, _], s6: Shape[_ <: ShapeLevel, Rep[A6], A6, _], s7: Shape[_ <: ShapeLevel, Rep[A7], A7, _], s8: Shape[_ <: ShapeLevel, Rep[A8], A8, _], s9: Shape[_ <: ShapeLevel, Rep[A9], A9, _], s10: Shape[_ <: ShapeLevel, Rep[A10], A10, _], s11: Shape[_ <: ShapeLevel, Rep[A11], A11, _], s12: Shape[_ <: ShapeLevel, Rep[A12], A12, _], s13: Shape[_ <: ShapeLevel, Rep[A13], A13, _], s14: Shape[_ <: ShapeLevel, Rep[A14], A14, _], s15: Shape[_ <: ShapeLevel, Rep[A15], A15, _], s16: Shape[_ <: ShapeLevel, Rep[A16], A16, _], s17: Shape[_ <: ShapeLevel, Rep[A17], A17, _], s18: Shape[_ <: ShapeLevel, Rep[A18], A18, _], s19: Shape[_ <: ShapeLevel, Rep[A19], A19, _], s20: Shape[_ <: ShapeLevel, Rep[A20], A20, _], s21: Shape[_ <: ShapeLevel, Rep[A21], A21, _], s22: Shape[_ <: ShapeLevel, Rep[A22], A22, _], s23: Shape[_ <: ShapeLevel, Rep[A23], A23, _], s24: Shape[_ <: ShapeLevel, Rep[A24], A24, _], s25: Shape[_ <: ShapeLevel, Rep[A25], A25, _], s26: Shape[_ <: ShapeLevel, Rep[A26], A26, _], s27: Shape[_ <: ShapeLevel, Rep[A27], A27, _], s28: Shape[_ <: ShapeLevel, Rep[A28], A28, _], s29: Shape[_ <: ShapeLevel, Rep[A29], A29, _], s30: Shape[_ <: ShapeLevel, Rep[A30], A30, _], s31: Shape[_ <: ShapeLevel, Rep[A31], A31, _], s32: Shape[_ <: ShapeLevel, Rep[A32], A32, _], s33: Shape[_ <: ShapeLevel, Rep[A33], A33, _], s34: Shape[_ <: ShapeLevel, Rep[A34], A34, _], s35: Shape[_ <: ShapeLevel, Rep[A35], A35, _], s36: Shape[_ <: ShapeLevel, Rep[A36], A36, _], s37: Shape[_ <: ShapeLevel, Rep[A37], A37, _], s38: Shape[_ <: ShapeLevel, Rep[A38], A38, _], s39: Shape[_ <: ShapeLevel, Rep[A39], A39, _], s40: Shape[_ <: ShapeLevel, Rep[A40], A40, _], s41: Shape[_ <: ShapeLevel, Rep[A41], A41, _], s42: Shape[_ <: ShapeLevel, Rep[A42], A42, _], s43: Shape[_ <: ShapeLevel, Rep[A43], A43, _], s44: Shape[_ <: ShapeLevel, Rep[A44], A44, _], s45: Shape[_ <: ShapeLevel, Rep[A45], A45, _], s46: Shape[_ <: ShapeLevel, Rep[A46], A46, _], s47: Shape[_ <: ShapeLevel, Rep[A47], A47, _], s48: Shape[_ <: ShapeLevel, Rep[A48], A48, _], s49: Shape[_ <: ShapeLevel, Rep[A49], A49, _], s50: Shape[_ <: ShapeLevel, Rep[A50], A50, _]) extends BaseView[A1, T](tag, name) {
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
    def c23 = column[A23](columnNames(22))
    def c24 = column[A24](columnNames(23))
    def c25 = column[A25](columnNames(24))
    def c26 = column[A26](columnNames(25))
    def c27 = column[A27](columnNames(26))
    def c28 = column[A28](columnNames(27))
    def c29 = column[A29](columnNames(28))
    def c30 = column[A30](columnNames(29))
    def c31 = column[A31](columnNames(30))
    def c32 = column[A32](columnNames(31))
    def c33 = column[A33](columnNames(32))
    def c34 = column[A34](columnNames(33))
    def c35 = column[A35](columnNames(34))
    def c36 = column[A36](columnNames(35))
    def c37 = column[A37](columnNames(36))
    def c38 = column[A38](columnNames(37))
    def c39 = column[A39](columnNames(38))
    def c40 = column[A40](columnNames(39))
    def c41 = column[A41](columnNames(40))
    def c42 = column[A42](columnNames(41))
    def c43 = column[A43](columnNames(42))
    def c44 = column[A44](columnNames(43))
    def c45 = column[A45](columnNames(44))
    def c46 = column[A46](columnNames(45))
    def c47 = column[A47](columnNames(46))
    def c48 = column[A48](columnNames(47))
    def c49 = column[A49](columnNames(48))
    def c50 = column[A50](columnNames(49))

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
      columnNames(21) -> (_.c22),
      columnNames(22) -> (_.c23),
      columnNames(23) -> (_.c24),
      columnNames(24) -> (_.c25),
      columnNames(25) -> (_.c26),
      columnNames(26) -> (_.c27),
      columnNames(27) -> (_.c28),
      columnNames(28) -> (_.c29),
      columnNames(29) -> (_.c30),
      columnNames(30) -> (_.c31),
      columnNames(31) -> (_.c32),
      columnNames(32) -> (_.c33),
      columnNames(33) -> (_.c34),
      columnNames(34) -> (_.c35),
      columnNames(35) -> (_.c36),
      columnNames(36) -> (_.c37),
      columnNames(37) -> (_.c38),
      columnNames(38) -> (_.c39),
      columnNames(39) -> (_.c40),
      columnNames(40) -> (_.c41),
      columnNames(41) -> (_.c42),
      columnNames(42) -> (_.c43),
      columnNames(43) -> (_.c44),
      columnNames(44) -> (_.c45),
      columnNames(45) -> (_.c46),
      columnNames(46) -> (_.c47),
      columnNames(47) -> (_.c48),
      columnNames(48) -> (_.c49),
      columnNames(49) -> (_.c50))

    def * = (c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: c26 :: c27 :: c28 :: c29 :: c30 :: c31 :: c32 :: c33 :: c34 :: c35 :: c36 :: c37 :: c38 :: c39 :: c40 :: c41 :: c42 :: c43 :: c44 :: c45 :: c46 :: c47 :: c48 :: c49 :: c50 :: HNil).<>(apply, unapply)
  }

}