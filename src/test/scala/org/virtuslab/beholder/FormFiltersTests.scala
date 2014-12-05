package org.virtuslab.beholder

import org.virtuslab.beholder.suites.{ BaseSuite, FiltersTestSuite, RangeFiltersSuite }
import org.virtuslab.beholder.filters.FilterAPI
import org.virtuslab.beholder.filters.forms.{ FromFilterFields, FormFilters, FormFormatter }
import org.virtuslab.beholder.filters.forms.FromFilterFields._
import org.virtuslab.beholder.filters.FilterDefinition
import java.sql.Date
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

/**
 * Author: Krzysztof Romanowski
 */
trait FormFiltersTestsBase {
  self: AppTest with BaseSuite[FormFormatter] =>

  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    val formatter = data.filter.formatter
    val formData = formatter.filterForm.fill(currentFilter)
    formatter.filterForm.bind(formData.data).fold(
      errors => fail(s"Form errors ${errors.errors.mkString}"),
      fromForm => data.filter.filter(fromForm)(data.session)
    )
  }
}

class FormFiltersTests extends AppTest with FiltersTestSuite[FormFormatter] with FormFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, FormFormatter] = new CustomTypeMappers {

    import play.api.data.format.Formats._

    val filterGenerator = new FormFilters[UserMachineViewRow].create(
      data.view,
      inText,
      inText,
      inIntField,
      inRange[Date],
      FromFilterFields.ignore[Option[BigDecimal]]
    )
  }.filterGenerator
}

class FormRangeFiltersTests extends AppTest with RangeFiltersSuite[FormFormatter] with FormFiltersTestsBase {
  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, FormFormatter] = new CustomTypeMappers {

    import play.api.data.format.Formats._

    val filterGenerator = new FormFilters[UserMachineViewRow].create(
      data.view,
      inText,
      inText,
      inRange[Int],
      inRange[Date],
      inOptionRange[BigDecimal]
    )
  }.filterGenerator

}
