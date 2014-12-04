package org.virtuslab.beholder.forms

import org.virtuslab.beholder.suites.RangeFiltersSuite
import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.{ UserMachineViewRow, AppTest }

/**
 * Author: Krzysztof Romanowski
 */
class FormRangeFilterTest extends AppTest with RangeFiltersSuite {
  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] =
    data.filter.filter(currentFilter)(data.session)
}
