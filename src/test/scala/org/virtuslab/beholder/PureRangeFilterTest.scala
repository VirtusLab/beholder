package org.virtuslab.beholder

import org.virtuslab.beholder.suites.RangeFiltersSuite
import org.virtuslab.beholder.filters.FilterDefinition

/**
 * Author: Krzysztof Romanowski
 */
class PureRangeFilterTest extends AppTest with RangeFiltersSuite{
  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] =
    data.filter.filter(currentFilter)(data.session)
}
