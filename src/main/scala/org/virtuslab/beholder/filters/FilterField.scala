package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import slick.ast.BaseTypedType

import scala.reflect.ClassTag

/**
 * filter field - there is information how read parameters from form data (mapping)
 * and how create sql's where statement(filter on column) for it
 */
trait FilterField {

  /**
   * filter on column - apply filter form data into sql - default returns true
   */
  def doFilter(column: Rep[_])(value: Any): Rep[Option[Boolean]]
}

class MappedFilterField[A: BaseTypedType: ClassTag] extends FilterField {
  override final def doFilter(column: Rep[_])(value: Any): Rep[Option[Boolean]] =
    filterShapes(column.asInstanceOf[Rep[A]]).apply(value)

  protected def filterOnValue(column: Rep[A], value: A): Rep[Option[Boolean]] =
    (column === value).?

  protected def filterOnRange(column: Rep[A], value: FilterRange[A]): Rep[Option[Boolean]] =
    value match {
      case FilterRange(Some(from), Some(to)) => column >= from && column <= to
      case FilterRange(None, Some(to)) => column <= to
      case FilterRange(Some(from), None) => column >= from
      case _ => LiteralColumn(Some(true))
    }

  protected def filterOnAlternative(column: Rep[A], value: FilterAlternative[A]): Rep[Option[Boolean]] = {
    val initial: Rep[Option[Boolean]] = LiteralColumn(Some(true))
    value.options.foldLeft(initial) {
      _ || filterOnValue(column, _)
    }
  }

  //TODO Options?
  protected def filterShapes(column: Rep[A]): PartialFunction[Any, Rep[Option[Boolean]]] = {
    case range: FilterRange[A] => filterOnRange(column, range)
    case alternative: FilterAlternative[A] => filterOnAlternative(column, alternative)
    case value: A => filterOnValue(column, value)
    case value => throw new IllegalAccessException(s"Bad shape: $value for column: $column for ") //TODO shape -> ???
  }
}

class EnumField[T <: Enumeration](implicit tm: BaseTypedType[T#Value]) extends MappedFilterField[T#Value]

class IgonredField[T: BaseTypedType] extends FilterField {
  override def doFilter(column: Rep[_])(value: Any): Rep[Option[Boolean]] = LiteralColumn(Some(true))
}
