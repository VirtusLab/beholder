package org.virtuslab.beholder

import org.joda.time.DateTime
import org.scalatest.matchers.should.Matchers
import org.scalatest.{Matchers => _, _}
import org.scalatestplus.play.guice.GuiceFakeApplicationFactory
import org.virtuslab.beholder.model.{LargeElement, Machine, MachineStatus, User}
import org.virtuslab.beholder.repositories._
import org.virtuslab.unicorn._
import play.api.db.slick.DatabaseConfigProvider
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.{Application, Configuration, Play}
import slick.dbio.DBIOAction
import slick.jdbc.JdbcProfile

import java.sql.Date
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Try}

trait BaseTest extends flatspec.FixtureAnyFlatSpecLike with Matchers with GuiceFakeApplicationFactory {
  import BaseTest.Fixture

  override type FixtureParam = Fixture

  private def createFixture(dbSuffix: String): Fixture = {
    val testDb = Configuration(
      "slick.dbs.default.driver" -> "slick.driver.H2Driver$",
      "slick.dbs.default.db.driver" -> "org.h2.Driver",
      "slick.dbs.default.db.url" -> ("jdbc:h2:mem:beholder-" + dbSuffix),
      "slick.dbs.default.db.user" -> "sa",
      "slick.dbs.default.db.password" -> "",
      "slick.dbs.default.db.connectionTimeout" -> "10000")

    val fakeApp: Application = new GuiceApplicationBuilder(configuration = testDb).build()

    val unicorn: UnicornPlay[Long] with HasJdbcProfile =
      new LongUnicornPlay(DatabaseConfigProvider.get[JdbcProfile](fakeApp))

    val machineRepository = new MachineRepository(unicorn)
    val usersRepository = new UsersRepository(unicorn)
    val userMachinesTableQuery = new UserMachinesRepository(unicorn)
    val largeElementsRepository = new LargeElementsRepository(unicorn)
    val userMachinesViewRepository = new UserMachinesViewRepository(unicorn)
    Fixture(
      unicorn, fakeApp, machineRepository, usersRepository, userMachinesTableQuery, userMachinesViewRepository, largeElementsRepository)
  }

  object RollbackException extends Exception

  def setup(f: Fixture): slick.dbio.DBIO[Unit] = {
    DBIOAction.successful(())
  }

  def withFixture(test: OneArgTest): Outcome = {
    val dbSuffix = scala.util.Random.nextInt().toHexString
    var fakeApp: Option[Application] = None
    try {
      val theFixture = createFixture(dbSuffix)
      import theFixture.unicorn.profile.api._
      fakeApp = Some(theFixture.app)
      val DB = theFixture.unicorn.db
      Await.result(DB.run(sqlu"""DROP ALL OBJECTS"""), Duration.Inf)
      withFixture(test.toNoArgTest(theFixture))
    } finally {
      fakeApp.foreach(Play.stop)
    }
  }

  /**
   * Runs action in rolled-back transaction.
   *
   * @param func function to run in rolled-back transaction
   * @tparam Result type returned by `f`
   * @return value returned from `f`
   */
  def rollbackActionWithModel[Result](func: => slick.dbio.DBIO[Result])(implicit f: Fixture): Unit = {
    import f._
    import f.unicorn.profile.api._
    val out = (for {
      _ <- usersRepository.create()
      _ <- machineRepository.create()
      _ <- largeElementRepository.create()
      _ <- userMachinesTableQuery.tableQuery.schema.create
      _ <- setup(f)
      _ <- func
      _ <- DBIO.failed(RollbackException)
    } yield ()).transactionally

    val DB = DatabaseConfigProvider.get(app).db

    Try(Await.result(DB.run(out), Duration.Inf)) match {
      case Failure(RollbackException) =>
      case Failure(other) => throw other
    }
  }

  def populatedDatabase(implicit f: Fixture): slick.dbio.DBIO[Unit] = {
    import f._
    import f.unicorn.profile.api._
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

    val largeElementsAction = DBIO.sequence(
      Seq(
        LargeElement(
          None,
          "f",
          1,
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f",
          "f"),
        LargeElement(
          None,
          "a",
          2,
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a",
          "a")).map { largeElement =>
          largeElementRepository.save(largeElement)
        })

    usersAction.zip(machinesAction).flatMap {
      case (users, machines) =>
        val Seq(user1, user2) = users
        val Seq(machine1, machine2) = machines
        userMachinesTableQuery.tableQuery ++= Seq(
          (user1.id.get, machine1.id.get),
          (user2.id.get, machine1.id.get),
          (user2.id.get, machine2.id.get))
    } >> largeElementsAction >> DBIO.successful(())
  }

}

object BaseTest {
  case class Fixture(
    unicorn: UnicornPlay[Long] with HasJdbcProfile,
    app: Application,
    machineRepository: MachineRepository,
    usersRepository: UsersRepository,
    userMachinesTableQuery: UserMachinesRepository,
    userMachinesViewRepository: UserMachinesViewRepository,
    largeElementRepository: LargeElementsRepository,
    )
}

