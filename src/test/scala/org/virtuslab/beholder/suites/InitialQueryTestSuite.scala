package org.virtuslab.beholder.suites

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.model.{ MachineStatus, Machine, User }
import org.virtuslab.beholder.views.FilterableViews
import org.virtuslab.beholder.{ UserMachineViewRow, AppTest }
import org.virtuslab.beholder.filters.{ TableFilterAPI, FilterAPI }
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import scala.concurrent.ExecutionContext.Implicits.global

trait InitialQueryTestSuite[Formatter] extends FiltersTestSuite[Formatter] {
  self: AppTest =>

  override protected def baseFilterTest[A](testImplementation: (BaseFilterData) => DBIO[A]): Unit =
    rollbackActionWithModel {
      testImplementation(new InitialQueryFilterData())
    }

  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Formatter]

  val newMail = "b@b.pl"

  class InitialQueryFilterData extends BaseFilterData {
    override lazy val filter: FilterAPI[UserMachineViewRow, Formatter] = createFilter(this)
      .asInstanceOf[TableFilterAPI[UserMachineViewRow, Formatter, FilterableViews.BaseView6[_, String, _, _, _, _, _]]]
      .withInitialFilter(table => !(table.c1 === newMail)) //cos !== is not working

    val newUserAction = {
      val user = User(None, newMail, "Bala", "Bma'Kota")
      usersRepository.saveAction(user)
    }

    val newMachineAction = {
      val machine = Machine(None, "b.pl", "Windows", 6, new Date(DateTime.now().getMillis), Some(12), MachineStatus.Inactive)
      machineRepository.saveAction(machine)
    }

    val allAction = newUserAction.zip(newMachineAction).flatMap {
      case (userId, machineId) =>
        userMachineQuery += (userId -> machineId)
    }

    override lazy val allFromDb: DBIO[Seq[UserMachineViewRow]] =
      for {
        view <- createUsersMachineView()
        _ <- populatedDatabase
        _ <- allAction
        all <- view.result
      } yield all.filter(_.email != newMail)

  }

  it should "have ignored entity populated" in baseFilterTest {
    data =>
      import data._
      for {
        all <- allFromDb
        allInDb <- viewQuery.result
        filtered <- (for (v <- viewQuery if !(v.c1 === newMail)) yield v).result
      } yield {
        val ignored = allInDb.toSet -- all.toSet
        ignored.size shouldEqual 1
        ignored.foreach(_.email shouldEqual newMail)
        filtered should contain theSameElementsAs all
      }
  }
}
