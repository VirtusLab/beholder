package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.forms.FromFilterFields._
import org.virtuslab.beholder.filters.forms.{ FormFilters, FormFormatter, FromFilterFields }
import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.suites.{ InitialQueryTestSuite, BaseSuite, FiltersTestSuite, RangeFiltersSuite }
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

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

class InitialFormFiltersTests extends FormFiltersTests with InitialQueryTestSuite[FormFormatter]

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
