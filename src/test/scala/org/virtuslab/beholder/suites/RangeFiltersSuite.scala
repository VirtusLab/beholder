package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters.FilterRange
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import scala.concurrent.ExecutionContext.Implicits.global

trait RangeFiltersSuite extends BaseSuite {

  it should "should take int range correctly" in baseFilterTest {
    data =>
      import data._

      val coreRange = FilterRange(Some(1), Some(4))
      val coreRangeData = updatedDefinition("cores", coreRange)

      for {
        _ <- createUsersMachineView
        allUserMachineRows <- viewQuery.result
      } yield {
        filtering(coreRangeData) shouldResultIn allUserMachineRows
      }

  }

  it should "should take BigDecimal range correctly" in baseFilterTest {
    data =>
      import data._

      def testCapacityRange(minCapacity: Option[BigDecimal], maxCapacity: Option[BigDecimal]) = {

        def isInRange(from: Option[BigDecimal], to: Option[BigDecimal], value: Option[BigDecimal]) = {
          val seq = Seq(from, value, to)
          (seq, seq.tail).zipped.forall {
            case (Some(a), Some(b)) => a <= b
            case (_, _) => true
          }
        }
        val capacityRange = FilterRange(minCapacity, maxCapacity)

        val coreRangeData = updatedDefinition("capacity", capacityRange)

        for {
          _ <- createUsersMachineView
          fromDbFilteredByCapacity <- viewQuery.result.map(_.filter(a => isInRange(minCapacity, maxCapacity, a.capacity)))
        } yield {
          filtering(coreRangeData) shouldResultIn fromDbFilteredByCapacity
        }
      }

      testCapacityRange(Some(1), Some(3))
      testCapacityRange(Some(1), Some(2))
      testCapacityRange(Some(2), Some(2))
      testCapacityRange(None, Some(2))
      testCapacityRange(Some(3), None)
      testCapacityRange(None, None)

  }
}
