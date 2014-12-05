package org.virtuslab.beholder.filters.forms

import org.virtuslab.beholder.filters.{ FilterFactoryMethods, BaseFilter }
import scala.slick.ast.TypedType
import org.virtuslab.beholder.views.FilterableViews._
import scala.slick.lifted.TableQuery
import org.virtuslab.unicorn.LongUnicornPlay

class FormFilters[Entity] extends FilterFactoryMethods[Entity, FormFilterField, FormFormatter] {
  override def createFormatter(table: BaseFilter[_, _, _, FormFilterField[_, _], FormFormatter]): FormFormatter =
    new FormFormatter(table.filterFields, table.columnsNames)
}

