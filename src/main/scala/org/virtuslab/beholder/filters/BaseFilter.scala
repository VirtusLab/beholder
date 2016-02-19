package org.virtuslab.beholder.filters

import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._


/**
 * Base filter class, contains public operations for all filters instances.
 *
 * @param table table to filter on
 * @tparam Id table id
 * @tparam Entity table entity
 * @tparam FilterTable table class (usually View.type)
 */
abstract class BaseFilter[Id, Entity, FilterTable <: BaseView[Entity], FieldType <: FilterField, Formatter](val table: TableQuery[FilterTable])
    extends LightFilter[Entity, FilterTable] {

  private lazy val fieldMap = (columnsNames zip filterFields).toMap

  final def columnsNames: Seq[String] = table.shaped.value.columnsNames

  override final def fieldFor(name: String): Option[FieldType] = fieldMap.get(name)

  override final def columnFor(q: FilterTable, name: String): Option[Column[_]] =
    Some(tableColumns(q).apply(columnsNames.indexOf(name)))

  override def defaultOrder(q: FilterTable): Column[_] = q.id

  /**
   * Empty data for filter representing empty filter (all fields in tuple (type M) are filled with Empty)
   */
  protected def emptyFilterDataInner: Seq[Option[Any]]

  def filterFields: Seq[FieldType]

  protected def tableColumns(table: FilterTable): Seq[Column[_]]
}