package org.virtuslab.beholder.suites

import org.virtuslab.beholder.{ UserMachineViewRow, AppTest }
import org.virtuslab.beholder.filters.FilterRange
import scala.concurrent.ExecutionContext.Implicits.global

trait RangeFiltersSuite[Formatter] extends BaseSuite[Formatter] {
  self: AppTest =>

  behavior of "range filters"

  it should "should take int range correctly" in baseFilterTest {
    data =>
      import data._
      val coreRange = Some(FilterRange(Some(1), Some(4)))
      for {
        all <- allFromDb
        coreRangeData <- doFilters(data, baseFilter.copy(data = baseFilterData.updated(2, coreRange)))
      } yield {
        coreRangeData should contain theSameElementsAs all
      }
  }

  it should "should take BigDecimal range correctly" in baseFilterTest {
    data =>
      {
        import data._
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
            coreRangeData <- doFilters(data, baseFilter.copy(data = baseFilterData.updated(4, capacityRange)))
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
