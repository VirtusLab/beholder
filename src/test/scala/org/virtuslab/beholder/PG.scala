package org.virtuslab.beholder

import java.sql.Date


import org.virtuslab.beholder.model._

import scala.slick.lifted.TableQuery
import org.virtuslab.unicorn.LongUnicornPlay._

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._


/*

class PG extends JsonFiltersTests {

  val view = TableQuery[MachineParameters]

  /*val machineParametersFilter = new JsonFilters[MachineParameter](identity).create(
    q,
    inText,
    inText,
    JsonFilterFields.ignore[MachineId]
  )*/

  it should "work with joins" in baseFilterTest {
    data =>
      import data._
      val all = doFilters(data, baseFilter)

      all should contain theSameElementsAs allFromDb
  }


  def findParameter(name: String)(q: Query[Machines, Machine, Seq]):Query[Machines, Machine, Seq] =
    for{
      v <- q
      mp <- TableQuery[MachineParameters] if mp.name === name && mp.machine === v.id
    } yield v

  "test" should "work?" in rollbackWithModel{
    implicit session =>
      val data = new PopulatedDatabase()

      import data._

      val gbq =
        Option(TableQuery[Machines])
          .map( findParameter("displaysCount"))
          .map( findParameter("cdDriveSpeed"))
            .get

      val reduced = gbq.groupBy(identity).map{
        case (m, group) => m
      }

      println(reduced.list.mkString("############\n", "\n", "\n################"))
  }

}
*/
