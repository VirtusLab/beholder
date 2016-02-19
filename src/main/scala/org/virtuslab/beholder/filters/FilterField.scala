package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.slick.ast.{BaseTypedType, TypedType}

/**
 * filter field - there is information how read parameters from form data (mapping)
 * and how create sql's where statement(filter on column) for it
 */
trait FilterField {

  /**
   * filter on column - apply filter form data into sql - default returns true
   */
  def doFilter(column: Column[_])(value: Any): Column[Option[Boolean]]
}

abstract class MappedFilterField[A: TypedType, B] extends FilterField {
  override final def doFilter(column: Column[_])(value: Any): Column[Option[Boolean]] =
    filterOnColumn(column.asInstanceOf[Column[A]])(value.asInstanceOf[B])

  protected def filterOnColumn(column: Column[A])(value: B): Column[Option[Boolean]]
}

class EnumField[T <: Enumeration](implicit tm: BaseTypedType[T#Value])  extends MappedFilterField[T#Value, T#Value]{
  override protected def filterOnColumn(column: Column[T#Value])(value: T#Value): Column[Option[Boolean]] = column === value
}

class IdentityField[T: BaseTypedType] extends MappedFilterField[T, T]{
  override protected def filterOnColumn(column: Column[T])(value: T): Column[Option[Boolean]] = column === value
}

class RangeField[T: BaseTypedType] extends MappedFilterField[T, FilterRange[T]]{
  override def filterOnColumn(column: Column[T])(value: FilterRange[T]): Column[Option[Boolean]] = {
    value match {
      case FilterRange(Some(from), Some(to)) => column >= from && column <= to
      case FilterRange(None, Some(to)) => column <= to
      case FilterRange(Some(from), None) => column >= from
      case _ => LiteralColumn(Some(true))
    }
  }
}

class IgonredField[T: BaseTypedType] extends MappedFilterField[T, Any]{
  override protected def filterOnColumn(column: Column[T])(value: Any): Column[Option[Boolean]] = LiteralColumn(Some(true))
}
