package org.virtuslab.beholder.filters

import org.virtuslab.beholder.utils.ILikeExtension._
import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.slick.ast.{TypedType, BaseTypedType}
import scala.util.Try



object LightDSLFilter {

  case class ViewFilter[E, T <: BaseView[E]](override val table: Query[T, T#TableElementType, Seq],
                                             override protected val fields: Map[String, FilterField])
    extends LightFilter[E, T] with ViewBasedFilter[E, T] with MappedFieldsFilter {

    def and(name: String): AndDSL = new AndDSL(name)

    class AndDSL(name: String) {
      def as(field: FilterField): ViewFilter[E, T] =
        ViewFilter(table, fields + (name -> field))
    }
  }

  class TableFilter[E, T <: Table[E]](override val table: Query[T, T#TableElementType, Seq],
                                              override protected val fields: Map[String, FilterField],
                                              override protected val columns: Map[String, T => Column[_]],
                                              override protected val order: T => Column[_])
    extends MappedColumnsFilter[E, T] with MappedFieldsFilter{

    def and(name: String): AndDSL = new AndDSL(name)

    def and[A: BaseTypedType](name: String, col: T => Column[A]): TableFilter[E, T] = and(name).from(col)

    class AndDSL(name: String) {
      case class asUnsafe(field: FilterField) {
        def from(column: T => Column[_]): TableFilter[E, T] =
          new TableFilter(
            table = table,
            fields = fields + (name -> field),
            columns = columns + (name -> column),
            order = order)
      }

      case class as[A: TypedType, B](field: MappedFilterField[A, B]) {
        def from(column: T => Column[A]): TableFilter[E, T] =
          new TableFilter(
            table = table,
            fields = fields + (name -> field),
            columns = columns + (name -> column),
            order = order)
      }

      def from[A: BaseTypedType](col: T => Column[A]): TableFilter[E, T] =
        as(new IdentityField[A]).from(col)

      def fromMapped[A: BaseTypedType, B](inColumn: MappedFilterField[A, A] => MappedFilterField[A, B])
                                         (col: T => Column[A]): TableFilter[E, T] =
        as(inColumn(new IdentityField[A])).from(col)

    }

    def orderedBy(newOrder: T => Column[_]): LightFilter[E, T] =
      new TableFilter(table, fields, columns, newOrder)

  }

  def fromTable[E, T <: Table[E]](filter: Query[T, E, Seq])( order: T => Column[_]) =
    new TableFilter[E, T](filter, Map(), Map(), order)


  def fromView[E, T <: BaseView[E]](table: Query[T, E, Seq]): ViewFilter[E, T] =
    new ViewFilter(table, Map.empty)


  def in[T: BaseTypedType] = new IdentityField[T]

  val inText =  new MappedFilterField[String, String] {
    override def filterOnColumn(column: Column[String])(data: String): Column[Option[Boolean]] = column ilike s"%${escape(data)}%"
  }

  def inRange[T: BaseTypedType] = new RangeField[T]
}
