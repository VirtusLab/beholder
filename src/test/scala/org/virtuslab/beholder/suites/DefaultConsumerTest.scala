package org.virtuslab.beholder.suites


import org.virtuslab.beholder.model.{Machine, User}
import org.virtuslab.beholder.{TestInvoker, BaseTest}
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.view.UserMachineViewRow

trait ConsumerBaseTest[R] extends BaseTest {
  self: BaseSuite =>


  def createConsumer(data: BaseFilterData):  FilterConsumer[R]

  def compare(data: BaseFilterData, collected: Seq[R], expected: Seq[UserMachineViewRow]): Unit ={
    collected should contain theSameElementsInOrderAs expected
  }

  override def testResults(data: BaseFilterData,
                           definition: FilterDefinition,
                           expected: Seq[UserMachineViewRow],
                           totalCount: Int): Unit = {
    import data._
    import scala.concurrent.ExecutionContext.Implicits.global

    val consumer = createConsumer(data)

    val results = TestInvoker.invokeAction(consumer.consume(definition))

    results.total shouldEqual totalCount

    compare(data, results.content, expected)
  }
}

trait ViewBasedTest extends ConsumerBaseTest[UserMachineViewRow]{
  self: BaseSuite =>
}


trait QueryBasedTest extends ConsumerBaseTest[(User, Machine)]{
  self: BaseSuite =>

  override def compare(data: BaseFilterData,
                       collected: Seq[(User, Machine)],
                       expected: Seq[UserMachineViewRow]): Unit = {
    val expectedIds = expected.map(r => r.machineId -> r.userId)
    val collectedIds = collected.map{
      case (user, machine) =>  machine.id.get -> user.id.get
    }
    collectedIds should contain theSameElementsInOrderAs expectedIds
  }
}
