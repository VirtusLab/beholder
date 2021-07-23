package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.FilterFactoryMethodsComponent
import org.virtuslab.unicorn.UnicornWrapper

trait JsonFiltersComponent extends FilterFactoryMethodsComponent with JsonFormatterComponent {
  self: UnicornWrapper[Long] =>

  class JsonFilters[Entity <: Product](labels: String => String) extends FilterFactoryMethods[Entity, JsonFilterField, JsonFormatter[Entity]] {

    override def createFormatter(table: BaseFilter[_, _, _, JsonFilterField[_, _], JsonFormatter[Entity]]) =
      new JsonFormatter[Entity](table.filterFields, table.columnsNames, labels)
  }
}
