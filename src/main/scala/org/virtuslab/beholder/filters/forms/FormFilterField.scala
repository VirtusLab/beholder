package org.virtuslab.beholder.filters.forms

import org.virtuslab.beholder.filters.FilterField
import scala.slick.ast.TypedType
import play.api.data.Mapping
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple.Column

/**
 * Author: Krzysztof Romanowski
 */
abstract class FormFilterField[A: TypedType, B](val mapping: Mapping[B]) extends FilterField {
  /**
   * filter on column - apply filter form data into sql - default returns true
   * @param column
   * @param value
   * @return
   */
  override final def doFilter(column: Column[_])(value: Any): Column[Option[Boolean]] =
    filterOnColumn(column.asInstanceOf[Column[A]])(value.asInstanceOf[B])

  def filterOnColumn(column: Column[A])(value: B): Column[Option[Boolean]]
}
