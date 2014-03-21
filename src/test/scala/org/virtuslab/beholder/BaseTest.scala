package org.virtuslab.beholder

import org.scalatest._
import play.api.Play
import play.api.db.slick.DB
import play.api.test.FakeApplication
import org.virtuslab.beholder.model._
import play.api.db.slick.Config.driver.simple._
import org.virtuslab.beholder.services._
import scala.slick.session.Session

trait BaseTest extends FlatSpecLike with Matchers

trait ModelIncuded {
  self: AppTest =>
  val UsersService = new UsersService {}

  val MachinesService = new MachinesService {}

  def rollbackWithModel[A](func: Session => A): A = rollback {
    implicit session: Session =>
      Users.ddl.create
      Machines.ddl.create
      UserMachines.ddl.create
      func(session)
  }

  class PopulatedDatabase(implicit session: Session) {

    val users = Seq(
      User(None, "a@a.pl", "Ala", "maKota"),
      User(None, "o@a.pl", "Ola", "maPsa")
    ).map(user => user.copy(id = Some(UsersService.save(user))))

    val machines = Seq(
      Machine(None, "a@a.pl", "Ubuntu", 4),
      Machine(None, "o@a.pl", "Fedora", 1)
    ).map(machine => machine.copy(id = Some(MachinesService.save(machine))))

    val Seq(user1, user2) = users
    val Seq(machine1, machine2) = machines

    UserMachines.insertAll(
      (user1.id.get, machine1.id.get),
      (user2.id.get, machine1.id.get),
      (user2.id.get, machine2.id.get)
    )
  }

}

trait AppTest extends BaseTest with BeforeAndAfterEach with ModelIncuded {

  private val testDb = Map(
    "db.default.driver" -> "org.h2.Driver",
    "db.default.url" -> "jdbc:h2:mem:unicorn",
    "db.default.user" -> "sa",
    "db.default.password" -> ""
  )

  implicit var app: FakeApplication = _

  override protected def beforeEach(data: TestData): Unit = {
    app = new FakeApplication(additionalConfiguration = testDb)
    Play.start(app)
    super.beforeEach()
  }

  override protected def afterEach(data: TestData): Unit = {
    Play.stop()
    super.afterEach()
  }

  /**
   * Runs function in rolled-back transaction.
   *
   * @param func function to run in rolled-back transaction
   * @tparam A type returned by `f`
   * @return value returned from `f`
   */
  def rollback[A](func: Session => A): A = DB.withTransaction {
    session: Session =>
      val out = func(session)
      session.rollback()
      out
  }
}
