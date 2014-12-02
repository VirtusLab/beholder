package org.virtuslab.beholder

import org.virtuslab.beholder.filters.{FilterDefinition, BaseFilter}
import org.virtuslab.beholder.suites.FiltersTestSuite

/**
 * Author: Krzysztof Romanowski
 */
class PureFilterTest extends AppTest with FiltersTestSuite{
  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    data.filter.filter(currentFilter)(data.session)
  }
}
