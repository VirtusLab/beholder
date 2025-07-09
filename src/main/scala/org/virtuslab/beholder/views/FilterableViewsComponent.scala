package org.virtuslab.beholder.views

import org.virtuslab.unicorn.UnicornWrapper
import slick.lifted.TupleShape

import scala.reflect.ClassTag
import slick.ast.TypedType

trait FilterableViewsComponent extends FilterableViewsGenerateCodeComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._

  /**
   * Base view for view with 2 fields
   * @param name name of view
   * @param columnNames names of view columns - columnsNames(0) -> c1 etc
   * @param apply to create entity
   * @param unapply to map entity to tuple
   * @param query query that build view
   * @tparam T entity
   * @tparam A first field
   * @tparam B sec field
   */
  class BaseView2[T: ClassTag, A: TypedType, B: TypedType](
    tag: Tag,
    name: String,
    val columnNames: Seq[String],
    apply: (A, B) => T,
    unapply: T => Option[(A, B)],
    val query: Query[_, T, Seq])(implicit s1: Shape[_ <: ShapeLevel, Rep[A], A, _], s2: Shape[_ <: ShapeLevel, Rep[B], B, _]) extends BaseView[A, T](tag, name) {
    def c1 = column[A](columnNames(0))

    def c2 = column[B](columnNames(1))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2))

    implicit val tupleShape = new TupleShape(s1, s2).asInstanceOf[Shape[_ <: slick.lifted.FlatShapeLevel, (slick.lifted.Rep[A], slick.lifted.Rep[B]), (A, B), _]]

    def * = (c1, c2).<>(apply.tupled, unapply)
  }
  // }

}
