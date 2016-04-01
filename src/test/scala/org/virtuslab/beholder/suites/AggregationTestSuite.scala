package org.virtuslab.beholder.suites

//TODO #37 Create aggregation collector tests
/*
import org.virtuslab.beholder.AppTest
import org.virtuslab.beholder.consumers.{Collectors, TableAwareCollectors, Consumer}
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.model.{MachineParameters, MachineParameter, UserId}
import org.virtuslab.beholder.view.UserMachineViewRow
import slick.lifted.{TableQuery, Query}

trait AggregationTestSuite extends FilterResultTest[Aggregated[UserMachineViewRow, MachineParameter]] {
  self: BaseSuite =>



 /* private def aggregate(res: Seq[UserMachineViewRow]): Seq[SystemPerUsers] =
    res.groupBy(_.system).map {
      case (system, rows) =>
        SystemPerUsers(system, rows.map(_.userId))
    }.toSeq
*/



  override def compare(data: BaseFilterData,
                       collected: FilterResult[Aggregated[UserMachineViewRow, MachineParameter]],
                       expected: Seq[UserMachineViewRow], totalCounnt: Int): Unit = ???

  override def collector: Unit = {
    Collectors.forFilter(createFilter(???)).joinAndAggregate(_.joinLeft(TableQuery[MachineParameters]))


  }

  : Consumer[FilterDefinition, Query[_, Aggregated[UserMachineViewRow, MachineParameter], Seq], FilterResult[Aggregated[UserMachineViewRow, MachineParameter]]] = ???


}
*/