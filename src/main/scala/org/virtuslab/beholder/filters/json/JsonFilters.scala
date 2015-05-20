package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ BaseFilter, FilterFactoryMethods }

class JsonFilters[Entity <: Product](labels: String => String) extends FilterFactoryMethods[Entity, JsonFilterFieldImpl, JsonFormatter[Entity]] {
  override def createFormatter(table: BaseFilter[_, _, _, JsonFilterFieldImpl[_, _], JsonFormatter[Entity]]) =
    new JsonFormatter[Entity](table.filterFields, table.columnsNames, labels)
}
