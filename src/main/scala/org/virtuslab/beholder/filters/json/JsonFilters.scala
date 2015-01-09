package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ BaseFilter, FilterFactoryMethods }

class JsonFilters[Entity <: Product] extends FilterFactoryMethods[Entity, JsonFilterField, JsonFormatter[Entity]] {
  override def createFormatter(table: BaseFilter[_, _, _, JsonFilterField[_, _], JsonFormatter[Entity]]) =
    new JsonFormatter[Entity](table.filterFields, table.columnsNames)
}
