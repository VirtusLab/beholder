package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.slick.ast.TypedType

/**
 * filter field - there is information how read parameters from form data (mapping)
 * and how create sql's where statement(filter on column) for it
 */
trait FilterField {

  /**
   * filter on column - apply filter form data into sql - default returns true
   * @param column
   * @param value
   * @return
   */
  def doFilter(column: Column[_])(value: Any): Column[Option[Boolean]]
}

abstract class MappedFilterField[A: TypedType, B] extends FilterField {
  override final def doFilter(column: Column[_])(value: Any): Column[Option[Boolean]] =
    filterOnColumn(column.asInstanceOf[Column[A]])(value.asInstanceOf[B])

  protected def filterOnColumn(column: Column[A])(value: B): Column[Option[Boolean]]
}