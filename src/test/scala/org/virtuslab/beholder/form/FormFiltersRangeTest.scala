package org.virtuslab.beholder.form

import java.sql.Date

import org.virtuslab.beholder.{ BaseTest, UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.{ FilterDefinition, FilterRange }
import org.virtuslab.beholder.filters.forms.{ FormFilterComponent, FormFormatterComponent, FromFilterFieldsComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext.Implicits.global

class FormRangeTestRepository(override val unicorn: UnicornPlay[Long])
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
    inOptionRange,
    inRange
  }

  def createFilter = new CustomTypeMappers {
    val filterGenerator = new FormFilters[UserMachineViewRow].create(
      viewQuery,
      inText,
      inText,
      inRange[Int],
      inRange[Date],
      inOptionRange[BigDecimal],
      FromFilterFields.ignore[MachineStatus.Value])
  }.filterGenerator

}

class FormFiltersRangeTest extends BaseTest {

  class BaseFilterData(implicit val f: BaseTest.Fixture) {
    import f._
    import f.unicorn.profile.api._
    lazy val formRangeTestRepository = new FormRangeTestRepository(unicorn)
    lazy val query = userMachinesViewRepository.viewQuery
    lazy val filter = formRangeTestRepository.createFilter
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
    val formatter = data.filter.formatter
    val formData = formatter.filterForm.fill(currentFilter)

    formatter.filterForm.bind(formData.data).fold(
      errors => fail(s"Form errors ${errors.errors.mkString}"),
      fromForm => data.filter.filter(fromForm))
  }

  behavior of "range filters"

  it should "should take int range correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      val coreRange = Some(FilterRange(Some(1), Some(4)))
      for {
        all <- allFromDb
        coreRangeData <- doFilters(
          bfd, baseFilter.copy(data = baseFilterData.updated(2, coreRange)))
      } yield {
        coreRangeData should contain theSameElementsAs all
      }
    }
  }

  it should "should take BigDecimal range correctly" in { implicit f =>
    rollbackActionWithModel {
      val bfd = new BaseFilterData
      import bfd._
      def testCapacityRange(
        minCapacity: Option[BigDecimal],
        maxCapacity: Option[BigDecimal],
        all: Seq[UserMachineViewRow]) = {
        def isInRange(from: Option[BigDecimal], to: Option[BigDecimal], value: Option[BigDecimal]) = {
          val seq = Seq(from, value, to)
          (seq, seq.tail).zipped.forall {
            case (Some(a), Some(b)) => a <= b
            case (_, _) => true
          }
        }

        val capacityRange = Some(FilterRange(minCapacity, maxCapacity))

        for {
          coreRangeData <- doFilters(
            bfd, baseFilter.copy(data = baseFilterData.updated(4, capacityRange)))
        } yield {
          val fromDbFilteredByCapacity = all.filter(a => isInRange(minCapacity, maxCapacity, a.capacity))
          coreRangeData should contain theSameElementsAs fromDbFilteredByCapacity
        }
      }

      for {
        all <- allFromDb
        _ <- testCapacityRange(Some(1), Some(3), all)
        _ <- testCapacityRange(Some(1), Some(2), all)
        _ <- testCapacityRange(Some(2), Some(2), all)
        _ <- testCapacityRange(None, Some(2), all)
        _ <- testCapacityRange(Some(3), None, all)
        _ <- testCapacityRange(None, None, all)
      } yield ()
    }
  }

}