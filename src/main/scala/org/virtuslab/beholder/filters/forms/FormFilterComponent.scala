package org.virtuslab.beholder.filters.forms

import org.virtuslab.beholder.filters.{ BaseFilterComponent, FilterFactoryMethodsComponent }
import org.virtuslab.unicorn.UnicornWrapper

trait FormFilterComponent
  extends FromFilterFieldsComponent
  with BaseFilterComponent
  with FilterFactoryMethodsComponent
  with FormFormatterComponent {
  self: UnicornWrapper[Long] =>

  class FormFilters[Entity] extends FilterFactoryMethods[Entity, FormFilterField, FormFormatter] {
    override def createFormatter(table: BaseFilter[_, _, _, FormFilterField[_, _], FormFormatter]): FormFormatter =
      new FormFormatter(table.filterFields, table.columnsNames)
  }
}

