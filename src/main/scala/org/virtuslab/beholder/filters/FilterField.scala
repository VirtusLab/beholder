package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import slick.ast.TypedType

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

abstract class MappedFilterField[A: TypedType, B] extends FilterField {
  override final def doFilter(column: Rep[_])(value: Any): Rep[Option[Boolean]] =
    filterOnColumn(column.asInstanceOf[Rep[A]])(value.asInstanceOf[B])

  protected def filterOnColumn(column: Rep[A])(value: B): Rep[Option[Boolean]]
}