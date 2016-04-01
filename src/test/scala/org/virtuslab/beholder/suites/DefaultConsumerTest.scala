package org.virtuslab.beholder.suites


import org.virtuslab.beholder.{TestInvoker, BaseTest}
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.view.UserMachineViewRow

trait MappedCollectorTest[E, R] extends BaseTest {
  self: BaseSuite =>


  def createConsumer(data: BaseFilterData):  FilterConsumer[_, _, R]

  def compare(data: BaseFilterData, collected: R, expected: Seq[UserMachineViewRow], totalCounnt: Int): Unit

  override def testResults(data: BaseFilterData,
                           definition: FilterDefinition,
                           expected: Seq[UserMachineViewRow],
                           totalCount: Int): Unit = {
    import data._
    import scala.concurrent.ExecutionContext.Implicits.global

    val consumer = createConsumer(data)

    val results = TestInvoker.invokeAction(consumer.consume(definition))

    compare(data, results, expected, totalCount)
  }
}

trait FilterResultTest[E] extends MappedCollectorTest[E, FilterResult[E]]{
  self: BaseSuite =>
}


trait DefaultConsumerTest extends MappedCollectorTest[UserMachineViewRow, FilterResult[UserMachineViewRow]] {
  self: BaseSuite =>



  def createFilter(data: BaseFilterData): LightFilter[UserMachineViewRow, _]


  override def createConsumer(data: BaseFilterData) = createFilter(data).consumed

  override def compare(data: BaseFilterData,
                       collected: FilterResult[UserMachineViewRow],
                       expected: Seq[UserMachineViewRow],
                       totalCounnt: Int): Unit = {
    collected.total shouldEqual totalCounnt
    collected.content should contain theSameElementsAs expected
  }
}
