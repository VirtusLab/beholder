package org.virtuslab.beholder.filters.json2

import org.virtuslab.beholder.filters.{ BaseFilter, FilterFactoryMethods }

class JsonFilters[Entity <: Product](labels: String => String) extends FilterFactoryMethods[Entity, JsonFilterField, JsonFormatter[Entity]] {
  /*override*/ def createFormatter(table: BaseFilter[_, _, _, JsonFilterField[_, _], JsonFormatter[Entity]]) =
    new JsonFormatter[Entity](table.filterFields, table.columnsNames, labels)
}
