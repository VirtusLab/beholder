package org.virtuslab.beholder.suites

import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.filters.FilterRange

trait RangeFiltersSuite[Formatter] extends BaseSuite[Formatter] {
  self: AppTest =>

  behavior of "range filters"

  it should "should take int range correctly" in baseFilterTest {
    data =>
      import data._

      val a = baseFilter.data
      val coreRange = Some(FilterRange(Some(1), Some(4)))

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
          val capacityRange = Some(FilterRange(minCapacity, maxCapacity))

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
