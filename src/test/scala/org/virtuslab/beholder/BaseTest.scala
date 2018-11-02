package org.virtuslab.beholder

import java.sql.Date

import org.joda.time.DateTime
import org.scalatest._
import org.scalatestplus.play.guice.GuiceFakeApplicationFactory
import org.virtuslab.beholder.model.{ Machine, MachineStatus, User }
import org.virtuslab.beholder.repositories.{ MachineRepository, UserMachinesRepository, UserMachinesViewRepository, UsersRepository }
import org.virtuslab.unicorn._
import play.api.db.slick.DatabaseConfigProvider
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.{ Configuration, Play }
import slick.jdbc.JdbcProfile

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{ Failure, Try }

trait BaseTest extends FlatSpecLike with Matchers with BeforeAndAfterAll with BeforeAndAfterEach with GuiceFakeApplicationFactory {

  private val testDb = Configuration(
    "slick.dbs.default.driver" -> "slick.driver.H2Driver$",
    "slick.dbs.default.db.driver" -> "org.h2.Driver",
    "slick.dbs.default.db.url" -> "jdbc:h2:mem:beholder",
    "slick.dbs.default.db.user" -> "sa",
    "slick.dbs.default.db.password" -> "")

  val app = {
    val fake = new GuiceApplicationBuilder(configuration = testDb).build()
    Play.start(fake)
    fake
  }

  val unicorn: UnicornPlay[Long] with HasJdbcProfile =
    new LongUnicornPlay(DatabaseConfigProvider.get[JdbcProfile](app))

  import unicorn.profile.api._

  lazy val machineRepository = new MachineRepository(unicorn)
  lazy val usersRepository = new UsersRepository(unicorn)
  lazy val userMachinesTableQuery = new UserMachinesRepository(unicorn)
  lazy val userMachinesViewRepository = new UserMachinesViewRepository(unicorn)

  object RollbackException extends Exception

  override protected def beforeEach(): Unit = {
    val DB = DatabaseConfigProvider.get(app).db

    Await.result(DB.run(sqlu"""DROP ALL OBJECTS"""), Duration.Inf)

    super.beforeEach()
  }

  override protected def afterAll(): Unit = {
    Play.stop(app)
    super.afterEach()
  }

  /**
   * Runs action in rolled-back transaction.
   *
   * @param func function to run in rolled-back transaction
   * @tparam Result type returned by `f`
   * @return value returned from `f`
   */
  def rollbackActionWithModel[Result](func: => DBIO[Result]): Unit = {
    val out = (for {
      _ <- usersRepository.create()
      _ <- machineRepository.create()
      _ <- userMachinesTableQuery.tableQuery.schema.create
      _ <- func
      _ <- DBIO.failed(RollbackException)
    } yield ()).transactionally

    val DB = DatabaseConfigProvider.get(app).db

    Try(Await.result(DB.run(out), Duration.Inf)) match {
      case Failure(RollbackException) =>
      case Failure(other) => throw other
    }
  }

  def populatedDatabase: DBIO[Option[Int]] = {

    val usersAction = DBIO.sequence(
      Seq(
        User(None, "a@a.pl", "Ala", "maKota"),
        User(None, "o@a.pl", "Ola", "maPsa")).map { user =>

          val userIdAction = usersRepository.save(user)
          userIdAction.map {
            userId =>
              user.copy(id = Some(userId))
          }
        })
    val machinesAction = DBIO.sequence(
      Seq(
        Machine(None, "a.a.pl", "Ubuntu", 4, new Date(DateTime.now().minusHours(24).getMillis), Some(1), MachineStatus.Inactive),
        Machine(None, "o.a.pl", "Fedora", 1, new Date(DateTime.now().getMillis), Some(3), MachineStatus.Active)).map {
          machine =>
            val machineIdAction = machineRepository.save(machine)
            machineIdAction.map {
              machineId =>
                machine.copy(id = Some(machineId))
            }
        })
    usersAction.zip(machinesAction).flatMap {
      case (users, machines) =>
        val Seq(user1, user2) = users
        val Seq(machine1, machine2) = machines
        userMachinesTableQuery.tableQuery ++= Seq(
          (user1.id.get, machine1.id.get),
          (user2.id.get, machine1.id.get),
          (user2.id.get, machine2.id.get))
    }
  }

}

