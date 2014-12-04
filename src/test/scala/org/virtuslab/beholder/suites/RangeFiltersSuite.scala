package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters.forms.FilterField
import FilterField._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.data.format.Formats._
import org.virtuslab.unicorn.LongUnicornPlay._
import java.sql.Date
import org.virtuslab.beholder.filters.forms.FormFilters
import org.virtuslab.beholder.{ UserMachineViewRow, UserMachinesView, AppTest }
import org.virtuslab.beholder.filters.FilterDefinition

trait RangeFiltersSuite extends UserMachinesView {
  self: AppTest =>

  def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow]

  private def userMachineFilter()(implicit session: Session) = {
    val view = createUsersMachineView
    new CustomTypeMappers {
      val filterGenerator = new FormFilters[UserMachineViewRow].create(
        view,
        inText,
        inText,
        inRange[Int],
        inRange[Date],
        inOptionRange[BigDecimal]
      )
    }.filterGenerator
  }

  private def baseFilterTest[A](testImplementation: BaseFilterData => A) = rollbackWithModel {
    implicit session: Session =>
      testImplementation(new BaseFilterData())
  }

  protected class BaseFilterData(implicit val session: Session) extends PopulatedDatabase {
    val filter = userMachineFilter()
    val baseFilter = filter.emptyFilterData
    val baseFilterData = baseFilter.data

    val allFromDb = filter.table.list
  }

  behavior of "range filters"

  it should "should take int range correctly" in baseFilterTest {
    data =>
      import data._

      val a = baseFilter.data
      val coreRange = Some((Some(1), Some(4)))

      val coreRangeData = doFilters(data, baseFilter.copy(data = a.updated(2, coreRange)))

      coreRangeData should contain theSameElementsAs allFromDb
  }

  it should "should take BigDecimal range correctly" in baseFilterTest {
    data =>
      {
        def testCapacityRange(minCapacity: Option[BigDecimal], maxCapacity: Option[BigDecimal]) = {

          def isInRange(from: Option[BigDecimal], to: Option[BigDecimal], value: Option[BigDecimal]) = {
            val seq = Seq(from, value, to)
            (seq, seq.tail).zipped.forall {
              case (Some(a), Some(b)) => a <= b
              case (_, _) => true
            }
          }

          import data._
          val fromDbFilteredByCapacity = allFromDb.filter(a => isInRange(minCapacity, maxCapacity, a.capacity))
          val a = baseFilter.data
          val capacityRange = Some((minCapacity, maxCapacity))

          val coreRangeData = doFilters(data, baseFilter.copy(data = a.updated(4, capacityRange)))

          coreRangeData should contain theSameElementsAs fromDbFilteredByCapacity
        }

        testCapacityRange(Some(1), Some(3))
        testCapacityRange(Some(1), Some(2))
        testCapacityRange(Some(2), Some(2))
        testCapacityRange(None, Some(2))
        testCapacityRange(Some(3), None)
        testCapacityRange(None, None)
      }
  }

}
