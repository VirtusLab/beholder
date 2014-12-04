package org.virtuslab.beholder.forms

import org.virtuslab.beholder.{ UserMachineViewRow, AppTest }
import org.virtuslab.beholder.suites.RangeFiltersSuite
import org.virtuslab.beholder.filters.FilterDefinition

/**
 * Author: Krzysztof Romanowski
 */
class FormFiltersTests extends AppTest with RangeFiltersSuite {
  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    val formData = data.filter.filterForm.fill(currentFilter)
    data.filter.filterForm.bind(formData.data).fold(
      errors => fail(s"Form errors ${errors.errors.mkString}"),
      fromForm => data.filter.filter(fromForm)(data.session)
    )
  }
}
