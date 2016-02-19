package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import slick.driver.JdbcDriver

import scala.language.higherKinds
import scala.language.implicitConversions

//TODO create function based dsl: case (a, b) => "ala" from a.ala and "ola" from o.ola
abstract class DSLBase[DSLField <: FilterField, FilterType[E, T] <: LightFilter[E, T], FieldMapper[_]] {

  def create[E,  T <: BaseView[E]](viewFilterState: ViewFilterState[E,  T]): FilterType[E, T]
  def create[E,  T](viewFilterState: FilterQueryState[E,  T]): FilterType[E, T]

  final implicit def state2Filter[E,  T <: BaseView[E]](viewFilterState: ViewFilterState[E,  T]): FilterType[E,  T] =
    create(viewFilterState)

  final implicit def state2Filter[E,  T](tableFilterState: FilterQueryState[E,  T]): FilterType[E,  T] =
    create(tableFilterState)

  protected class TableBasedFilter[E,  T](state: FilterQueryState[E,  T]) extends LightFilter[E,  T] {
    override def baseQuery: FilterQuery = state.baseQuery

    override protected def filterFields: Map[String, FilterField] = state.fields

    override protected def defaultOrder(from: T): Rep[_] = state.order(from)

    override protected def filterColumns(from: T): Map[String, Rep[_]] = state.columns.mapValues(_.apply(from))

    override val driver: JdbcDriver = state.forDriver
  }

  protected class ViewBasedFilter[E,  T <: BaseView[E]](state: ViewFilterState[E,  T]) extends LightFilter[E,  T] {
    override def baseQuery: FilterQuery = state.table

    override  def defaultOrder(q: T): Rep[_] = q.id

    override protected def filterFields: Map[String, FilterField] = state.fields

    override protected def filterColumns(from: T): Map[String, Rep[_]] =
      state.fields.map{ case (name, _) => name -> from.columnByName(name)}.toMap

    override val driver: JdbcDriver = state.forDriver

  }

  protected case class ViewFilterState[E,  T <: BaseView[E]](table: Query[T, E, Seq],
      fields: Map[String, DSLField],
      val forDriver: JdbcDriver) {

    def and(name: String): AndDSL = new AndDSL(name)

    class AndDSL(name: String) {
      def asUntyped(field: DSLField): ViewFilterState[E,  T] =
        ViewFilterState.this.copy(fields = fields + (name -> field))

      def as[A: FieldMapper](field: MappedFilterField[A] with DSLField): ViewFilterState[E,  T] =
        asUntyped(field)
    }
  }

  protected case class FilterQueryState[E,  T](
      val baseQuery: Query[T, E, Seq],
      val fields: Map[String, DSLField],
      val columns: Map[String, T => Rep[_]],
      val order: T => Rep[_],
      val forDriver: JdbcDriver) {

    def and(name: String): AndDSL = new AndDSL(name)

    def and[A: FieldMapper](name: String, col: T => Rep[A]): FilterQueryState[E,  T] = and(name).from(col)

    class AndDSL(name: String) {
      case class asUnsafe(field: DSLField) {
        def from(column: T => Rep[_]): FilterQueryState[E,  T] =
          FilterQueryState.this.copy(
            fields = fields + (name -> field),
            columns = columns + (name -> column)
          )
      }

      case class as[A: FieldMapper, B](field: MappedFilterField[A] with DSLField) {
        def from(column: T => Rep[A]): FilterQueryState[E,  T] =
          FilterQueryState.this.copy(
            fields = fields + (name -> field),
            columns = columns + (name -> column)
          )

        def fromOpt(column: T => Rep[Option[A]]): FilterQueryState[E,  T] =
          FilterQueryState.this.copy(
            fields = fields + (name -> field),
            columns = columns + (name -> column)
          )
      }

      def from[A: FieldMapper](col: T => Rep[A]): FilterQueryState[E,  T] =
        as(in[A]).from(col)
    }

    def orderedBy(newOrder: T => Rep[_]): FilterQueryState[E,  T] =
      copy(order = newOrder)

  }

  def fromTable[E, T](filter: Query[T, E, Seq])(order: T => Rep[_])(implicit jdbcDriver: JdbcDriver) =
    new FilterQueryState[E, T](filter, Map(), Map(), order, jdbcDriver)

  def fromView[E, T <: BaseView[E]](table: Query[T, E, Seq])(implicit jdbcDriver: JdbcDriver): ViewFilterState[E, T] =
    new ViewFilterState(table, Map.empty, jdbcDriver)

  def in[T: FieldMapper]: DSLField with MappedFilterField[T]

  def inText: DSLField with MappedFilterField[String]

  def inEnum[T <: Enumeration](implicit to: FieldMapper[T#Value]): DSLField with MappedFilterField[T#Value]
}
