package org.virtuslab.beholder

import java.sql.Date

import org.joda.time.DateTime
import org.scalatest.{ BeforeAndAfterEach, FlatSpecLike, Matchers }
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.repositories._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.Play
import play.api.db.slick.DB
import play.api.test.FakeApplication

import scala.slick.lifted.TableQuery

trait BaseTest extends FlatSpecLike with Matchers

trait ModelIncluded {
  self: AppTest =>

  lazy val UsersRepository = new UsersRepository {}

  lazy val MachineRepository = new MachineRepository {}

  lazy val TeamsRepository = new TeamsRepository {}

  lazy val machineParameterRepository = new MachineParameterRepository{}

  lazy val userMachineQuery = TableQuery[UserMachines]


  final def rollbackWithModel[A](func: Session => A): A = rollback {
    implicit session: Session =>
      UsersRepository.create
      MachineRepository.create
      userMachineQuery.ddl.create
      machineParameterRepository.create
      TeamsRepository.create

      func(session)
  }

  class PopulatedDatabase(implicit session: Session) {

    val users = Seq(
      User(None, "a@a.pl", "Ala", "maKota"),
      User(None, "o@a.pl", "Ola", "maPsa")
    ).map(user => user.copy(id = Some(UsersRepository.save(user))))

    val machines = Seq(
      Machine(None, "a@a.pl", "Ubuntu", 4, new Date(DateTime.now().minusHours(24).getMillis), Some(1)),
      Machine(None, "o@a.pl", "Fedora", 1, new Date(DateTime.now().getMillis), Some(3))
    ).map(machine => machine.copy(id = Some(MachineRepository.save(machine))))

    val Seq(user1, user2) = users
    val Seq(machine1, machine2) = machines

    userMachineQuery.insertAll(
      (user1.id.get, machine1.id.get),
      (user2.id.get, machine1.id.get),
      (user2.id.get, machine2.id.get)
    )

    val machineParameters = Seq(
      MachineParameter(None, "displaysCount", "2", machine1.id.get),
      MachineParameter(None, "displaysCount", "1", machine2.id.get),
      MachineParameter(None, "cdDriveSpeed", "x52", machine1.id.get)
    ).map(mp => mp.copy(id = Some(machineParameterRepository.save(mp))))

    val team = Seq(Team(None, user1.id.get, "core", "Ubuntu"))
      .map(t => t.copy(id = Some(TeamsRepository.save(t))))

  }
}

trait AppTest extends BaseTest with BeforeAndAfterEach with ModelIncluded {

  private val testDb = Map(
    "db.default.driver" -> "org.h2.Driver",
    "db.default.url" -> "jdbc:h2:mem:beholder",
    "db.default.user" -> "sa",
    "db.default.password" -> ""
  )

  def withApp[A](func: FakeApplication => A): A = {
    val app = new FakeApplication(additionalConfiguration = testDb)
    Play.start(app)
    val ret = func(app)
    Play.stop()
    ret
  }

  /**
   * Runs function in rolled-back transaction.
   *
   * @param func function to run in rolled-back transaction
   * @tparam A type returned by `f`
   * @return value returned from `f`
   */
  def rollback[A](func: Session => A): A = withApp { implicit app =>
    DB.withTransaction {
      session: Session =>
        val out = func(session)
        session.rollback()
        out
    }
  }
}
