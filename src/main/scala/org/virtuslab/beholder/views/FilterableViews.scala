package org.virtuslab.beholder.views

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import slick.lifted.{ Shape, RepShape, ShapeLevel }

import scala.reflect.ClassTag
import slick.ast.{ BaseTypedType, TypedType }

class FilterShape[T](val tt: TypedType[T], val shape: Shape[FlatShapeLevel, Rep[T], T, Rep[T]])

object FilterShape {
  import scala.language.implicitConversions

  implicit def baseFilter2FilterShape[T](implicit tt: BaseTypedType[T]): FilterShape[T] = new FilterShape[T](tt, implicitly)
  implicit def baseFilter2FilterOptionShape[T](implicit tt: BaseTypedType[T]): FilterShape[Option[T]] =
    new FilterShape[Option[T]](implicitly[TypedType[Option[T]]], implicitly)
}

trait FilterableViewsImplicits {
  import scala.language.implicitConversions

  protected implicit def fs2S[T: FilterShape] = implicitly[FilterShape[T]].shape
  protected implicit def fs2TT[T: FilterShape]: TypedType[T] = implicitly[FilterShape[T]].tt
}

object FilterableViews extends FilterableViewsGenerateCode with FilterableViewsImplicits {

  /**
   * create view with 2 fields
   * @param name db name of view
   * @param apply from db columns to entity
   * @param unapply from entity to database columns
   * @param baseQuery query for create view - it should returns E
   * @param mappings map E to columns that suits apply function
   * @tparam T entity
   * @tparam E value returns form query (in sense of columns and tables not entities) - usually tuple with tables
   * @tparam A first field
   * @tparam B sec field
   * @return table for this view
   */
  def createView[T: ClassTag, E, A: FilterShape, B: FilterShape](
    name: String,
    apply: (A, B) => T,
    unapply: T => Option[(A, B)],
    baseQuery: Query[E, _, Seq])(mappings: E => ((String, Rep[A]), (String, Rep[B]))): TableQuery[BaseView2[T, A, B]] = {

    var columnsNames = Seq[String]()

    val preparedQuery: Query[_, T, Seq] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2)) =>
              columnsNames = Seq(name1, name2)
              (c1, c2) <> (Function.tupled(apply), unapply)
          }
      }

      for {
        a <- mappedQuery
      } yield a
    }
    TableQuery.apply(tag => new BaseView2[T, A, B](tag, name, columnsNames, apply, unapply, preparedQuery))

  }

  /**
   * Base view for view with 2 fields
   *
   * @param name name of view
   * @param columnNames names of view columns - columnsNames(0) -> c1 etc
   * @param apply to create entity
   * @param unapply to map entity to tuple
   * @param query query that build view
   * @tparam T entity
   * @tparam A first field
   * @tparam B sec field
   */
  class BaseView2[T: ClassTag, A: FilterShape, B: FilterShape](
      tag: Tag,
      name: String,
      val columnNames: Seq[String],
      apply: (A, B) => T,
      unapply: T => Option[(A, B)],
      val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
    def c1 = column[A](columnNames(0))

    def c2 = column[B](columnNames(1))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2)
    )

    implicit val shape: Shape[_ <: slick.lifted.FlatShapeLevel, (slick.lifted.Rep[A], slick.lifted.Rep[B]), (A, B), _] = implicitly

    def * = (c1, c2) <> (apply.tupled, unapply)
  }
}
