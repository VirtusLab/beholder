package org.virtuslab.beholder

import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.suites.FiltersTestSuite

class PureFilterTest extends AppTest with FiltersTestSuite {
  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    data.filter.filter(currentFilter)(data.session)
  }
}
