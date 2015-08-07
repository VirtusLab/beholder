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
abstract class TabledFilterImplementation[Id, Entity, FilterTable <: BaseView[Id, Entity], FieldType <: FilterField, Formatter](val table: TableQuery[FilterTable])
    extends FilterImplementation[Entity, Entity, FilterTable, FieldType, Formatter] {

  override def columnsNames: Seq[String] = table.shaped.value.columnsNames

  override def mappingFunction(e: Entity): Entity = e

  override def columnByName(table: FilterTable, name: String): Column[_] = table.columnByName(name)

  override def defaultColumn(table: FilterTable): Column[_] = table.id
}

