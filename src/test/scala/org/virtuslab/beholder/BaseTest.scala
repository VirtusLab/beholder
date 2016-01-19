package org.virtuslab.beholder

import java.sql.Date

import org.joda.time.DateTime
import org.scalatest.{ BeforeAndAfterEach, FlatSpecLike, Matchers }
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.repositories._
import org.virtuslab.beholder.utils.Slick3Invoker
import org.virtuslab.unicorn.LongUnicornPlay.driver
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import play.api.test.FakeApplication

import slick.lifted.TableQuery

import scala.concurrent.Await
import scala.concurrent.duration._

trait BaseTest extends FlatSpecLike with Matchers

trait ModelIncluded {
  self: AppTest =>

  protected val queryTimeout = Duration.Inf

  lazy val usersRepository = new UsersRepository()

  lazy val machineRepository = new MachineRepository()

  lazy val userMachineQuery = TableQuery[UserMachines]

  final def rollbackWithModel[A](func: Session => A): A = rollback {
    implicit session: Session =>
      usersRepository.create()
      machineRepository.create()
      Slick3Invoker.invokeAction(userMachineQuery.schema.create)
      func(session)
  }

  class PopulatedDatabase(implicit session: Session) {

    val users = Seq(
      User(None, "a@a.pl", "Ala", "maKota"),
      User(None, "o@a.pl", "Ola", "maPsa")
    ).map { user =>
        val userId = usersRepository.save(user)
        val userWithId = user.copy(id = Some(userId))
        userWithId
      }

    val machines = Seq(
      Machine(None, "a.a.pl", "Ubuntu", 4, new Date(DateTime.now().minusHours(24).getMillis), Some(1), MachineStatus.Inactive),
      Machine(None, "o.a.pl", "Fedora", 1, new Date(DateTime.now().getMillis), Some(3), MachineStatus.Active)
    ).map(machine => machine.copy(id = Some(MachineRepository.save(machine))))

    val Seq(user1, user2) = users
    val Seq(machine1, machine2) = machines

    Slick3Invoker.invokeAction(userMachineQuery ++= Seq(
      (user1.id.get, machine1.id.get),
      (user2.id.get, machine1.id.get),
      (user2.id.get, machine2.id.get)
    ))
  }
}

trait AppTest extends BaseTest with BeforeAndAfterEach with ModelIncluded {

  private val testDb = Map(
    "slick.dbs.default.driver" -> "slick.driver.H2Driver$",
    "slick.dbs.default.db.driver" -> "org.h2.Driver",
    "slick.dbs.default.db.url" -> "jdbc:h2:mem:beholder",
    "slick.dbs.default.db.user" -> "sa",
    "slick.dbs.default.db.password" -> ""
  )

  def withApp[A](func: FakeApplication => A): A = {
    val app = new FakeApplication(additionalConfiguration = testDb)
    Play.start(app)
    val ret = func(app)
    Play.stop(app)
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

  def DB = DatabaseConfigProvider.get(play.api.Play.current).db.asInstanceOf[driver.profile.backend.DatabaseDef]
}
