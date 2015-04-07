package org.virtuslab.beholder.suites

import java.sql.Date

import org.joda.time.DateTime
import org.virtuslab.beholder.model.{Machine, User}
import org.virtuslab.beholder.views.FilterableViews
import org.virtuslab.beholder.{UserMachineViewRow, AppTest}
import org.virtuslab.beholder.filters.{TableFilterAPI, FilterAPI}
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.tools.nsc.doc.model.Entity


/**
 * Author: Krzysztof Romanowski
 */
trait InitialQueryTestSuite[Formatter] extends FiltersTestSuite[Formatter] {
  self: AppTest =>
  override protected def baseFilterTest[A](testImplementation: (BaseFilterData) => A): A =
    rollbackWithModel {
      implicit session: Session =>
        testImplementation(new InitialQueryFilterData())
    }

  def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow, Formatter]

  val newMail = "b@b.pl"

  class InitialQueryFilterData(implicit session: Session) extends BaseFilterData {
    override lazy val filter: FilterAPI[UserMachineViewRow, Formatter] = createFilter(this)
      .asInstanceOf[TableFilterAPI[UserMachineViewRow, Formatter, FilterableViews.BaseView5[_, String, _, _, _, _]]]
      .withInitialFilter(table => !(table.c1 === newMail)) //cos !== is not working

    val newUser = {
      val i = User(None, newMail, "Bala", "Bma'Kota")
      i.copy(id = Some(UsersRepository.save(i)))
    }

    val newMachine = {
      val m = Machine(None, "b.pl", "Windows", 6, new Date(DateTime.now().getMillis), Some(12))
      m.copy(id = Some(MachineRepository.save(m)))
    }

    userMachineQuery.insert(newUser.id.get -> newMachine.id.get)

    override lazy val allFromDb: Seq[UserMachineViewRow] = {
      val seq: Seq[UserMachineViewRow] = view.list
      seq.filter(_.email != newMail)
    }
  }

  it should "have ignored entity populated" in baseFilterTest {
    data =>
      import data._
      val allInDb: Seq[UserMachineViewRow] = view.list
      val ignored: Set[UserMachineViewRow] = allInDb.toSet -- allFromDb.toSet

      ignored.size shouldEqual 1
      ignored.foreach(_.email shouldEqual newMail)

      val filtered =
        (for(v <- view if !(v.c1 === newMail)) yield v).list

      filtered should contain theSameElementsAs allFromDb

  }

}
