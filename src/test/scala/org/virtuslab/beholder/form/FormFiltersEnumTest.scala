package org.virtuslab.beholder.form

import java.sql.Date
import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.forms.{ FormFilterComponent, FormFormatterComponent, FromFilterFieldsComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class FormEnumTestRepository(override val unicorn: UnicornPlay[Long])
  extends UserMachinesViewComponent
  with FormFormatterComponent
  with FormFilterComponent
  with FromFilterFieldsComponent
  with UnicornWrapper[Long] {

  import unicorn._
  import unicorn.profile.api._
  import play.api.data.format.Formats._
  import FromFilterFields.{
    inText,
    inIntField,
    inRange,
    inOptionRange,
    inEnum
  }

  def createFilter = new CustomTypeMappers {
    val filterGenerator = new FormFilters[UserMachineViewRow].create(
      viewQuery,
      inText,
      inText,
      inIntField,
      inRange[Date],
      inOptionRange[BigDecimal],
      inEnum[MachineStatus.type])
  }.filterGenerator

}

class FormFiltersEnumTest extends BaseTest {
  lazy val formEnumTestRepository = new FormEnumTestRepository(unicorn)
  lazy val baseFilterData = new BaseFilterData

  import baseFilterData._
  import unicorn.profile.api._

  class BaseFilterData {
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = formEnumTestRepository.createFilter
    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data
    lazy val allFromDb: DBIO[Seq[UserMachineViewRow]] =
      for {
        view <- userMachinesViewRepository.createUsersMachineView()
        _ <- populatedDatabase
        all <- view.result
      } yield all
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): DBIO[Seq[UserMachineViewRow]] = {
    val formatter = data.filter.formatter
    val formData = formatter.filterForm.fill(currentFilter)

    formatter.filterForm.bind(formData.data).fold(
      errors => fail(s"Form errors ${errors.errors.mkString}"),
      fromForm => data.filter.filter(fromForm))
  }

  it should "filter all users with inactive machines" in rollbackActionWithModel {
    val inactive = Some(MachineStatus.Inactive)
    val usersWithInactiveMachinesAction = doFilters(
      baseFilterData, baseFilter.copy(data = baseFilterData.baseFilterData.updated(5, inactive)))
    for {
      all <- allFromDb
      usersWithInactiveMachines <- usersWithInactiveMachinesAction
    } yield {
      usersWithInactiveMachines should contain theSameElementsAs all.filter(machine => machine.status == MachineStatus.Inactive)
    }
  }

}