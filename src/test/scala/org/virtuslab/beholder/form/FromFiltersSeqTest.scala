package org.virtuslab.beholder.form

import java.sql.Date

import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.forms.{ FormFilterComponent, FormFormatterComponent, FromFilterFieldsComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class FormSeqTestRepository(override val unicorn: UnicornPlay[Long])
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
    inRange,
    inIntFieldSeq,
    inOptionRange,
    inEnumSeq
  }

  def createFilter = new CustomTypeMappers {
    val filterGenerator = new FormFilters[UserMachineViewRow].create(
      viewQuery,
      inText,
      inText,
      inIntFieldSeq,
      inRange[Date],
      inOptionRange[BigDecimal],
      inEnumSeq[MachineStatus.type])
  }.filterGenerator

}

class FromFiltersSeqTest extends BaseTest {

  class BaseFilterData(implicit val f: BaseTest.Fixture) {
    import f._
    import f.unicorn.profile.api._
    lazy val filtersTestRepository = new FormSeqTestRepository(unicorn)
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = filtersTestRepository.createFilter
    lazy val baseFilter = filter.emptyFilterData
    lazy val baseFilterData = baseFilter.data
    lazy val allFromDb: DBIO[Seq[UserMachineViewRow]] =
      for {
        view <- userMachinesViewRepository.createUsersMachineView()
        _ <- populatedDatabase
        all <- view.result
      } yield all
  }

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): slick.dbio.DBIO[Seq[UserMachineViewRow]] = {
    import data.filter
    val formatter = filter.formatter
    val formData = formatter.filterForm.fill(currentFilter)

    formatter.filterForm.bind(formData.data).fold(
      errors => fail(s"Form errors ${errors.errors.mkString}"),
      fromForm => filter.filter(fromForm))
  }

  it should "filter by seq(int) only users with one and four core machines" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val usersWithOneOrFourCore = Some(Seq(1, 4))
      for {
        all <- allFromDb
        usersWithOneOrFourCoreMachines <- doFilters(bfd, baseFilter.copy(data = baseFilterData.updated(2, usersWithOneOrFourCore)))
      } yield {
        usersWithOneOrFourCoreMachines should contain theSameElementsAs all
      }
    }
  }

  it should "filter by seq(int) only users with one and three core machine" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val oneOrThreeCore = Some(Seq(1, 3))
      for {
        all <- allFromDb
        usersWithOneOrThreeCoreMachines <- doFilters(bfd, baseFilter.copy(data = baseFilterData.updated(2, oneOrThreeCore)))
      } yield {
        usersWithOneOrThreeCoreMachines should contain theSameElementsAs all.filter(machine => machine.cores == 1 || machine.cores == 3)
      }
    }
  }

  it should "filter by seq(enum) all users together with inactive and broken machines" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val inactiveAndBroken = Some(Seq(MachineStatus.Inactive, MachineStatus.Broken))
      for {
        all <- allFromDb
        usersWithInactiveAndBrokenMachines <- doFilters(bfd, baseFilter.copy(data = baseFilterData.updated(5, inactiveAndBroken)))
      } yield {
        usersWithInactiveAndBrokenMachines.size should be(2)
        usersWithInactiveAndBrokenMachines should contain theSameElementsAs all.filter(machine => machine.status == MachineStatus.Inactive)
      }
    }
  }
}
