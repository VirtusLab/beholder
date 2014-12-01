package org.virtuslab.beholder.filters.forms

import play.api.data.{ Form, Mapping }
import org.virtuslab.beholder.filters.{ BaseFilter, FilterDefinition }
import org.virtuslab.beholder.views.BaseView
import scala.slick.lifted.TableQuery

/**
 * Author: Krzysztof Romanowski
 */
abstract class BaseFormFilter[Id, Entity, Table <: BaseView[Id, Entity]](table: TableQuery[Table])
    extends BaseFilter[Id, Entity, Table, FormFilterField[_, _]](table) {

  /**
   * from mapping for this filter
   * @return
   */
  protected def filterMapping: Mapping[FilterDefinition] = ???

  /**
   * form for this filter
   * @return
   */
  final def filterForm = Form(filterMapping)
}
