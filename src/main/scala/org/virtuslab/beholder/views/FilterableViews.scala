package org.virtuslab.beholder.views

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.reflect.ClassTag
import scala.slick.ast.TypedType
import scala.slick.lifted.{ Column, TableQuery, Tag }

object FilterableViews extends FilterableViewsGenerateCode {

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
  def createView[T: ClassTag, E, A: TypedType, B: TypedType](
    name: String,
    apply: (A, B) => T,
    unapply: T => Option[(A, B)],
    baseQuery: Query[E, _, Seq]
  )(mappings: E => ((String, Column[A]), (String, Column[B]))): TableQuery[BaseView2[T, A, B]] = {

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
      val query: Query[_, T, Seq]
  ) extends BaseView[T](tag, name) {
    def c1 = column[A](columnNames(0))

    def c2 = column[B](columnNames(1))

    override def id = c1

    override protected val columns: Seq[(String, this.type => Column[_])] = Seq(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2)
    )

    def * = (c1, c2) <> (apply.tupled, unapply)
  }
}
