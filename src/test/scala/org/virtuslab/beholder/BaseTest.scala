package org.virtuslab.beholder

import java.sql.Date

import org.joda.time.DateTime
import org.scalatest.{ BeforeAndAfterEach, FlatSpecLike, Matchers }
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.repositories._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import play.api.test.FakeApplication
import slick.lifted.TableQuery

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{ Failure, Try }

trait BaseTest extends FlatSpecLike with Matchers

trait ModelIncluded {
  self: AppTest =>

  protected val queryTimeout = Duration.Inf

  lazy val usersRepository = new UsersRepository()

  lazy val machineRepository = new MachineRepository()

  lazy val userMachineQuery = TableQuery[UserMachines]

  object RollbackException extends Exception

  def populatedDatabase: DBIO[Option[Int]] = {

    val usersAction = DBIO.sequence(
      Seq(
        User(None, "a@a.pl", "Ala", "maKota"),
        User(None, "o@a.pl", "Ola", "maPsa")
      ).map { user =>
          val userIdAction = usersRepository.save(user)
          userIdAction.map {
            userId =>
              user.copy(id = Some(userId))
          }
        }
    )

    val machinesAction = DBIO.sequence(
      Seq(
        Machine(None, "a.a.pl", "Ubuntu", 4, new Date(DateTime.now().minusHours(24).getMillis), Some(1), MachineStatus.Inactive),
        Machine(None, "o.a.pl", "Fedora", 1, new Date(DateTime.now().getMillis), Some(3), MachineStatus.Active)
      ).map {
          machine =>
            val machineIdAction = machineRepository.save(machine)
            machineIdAction.map {
              machineId =>
                machine.copy(id = Some(machineId))
            }
        }
    )

    usersAction.zip(machinesAction).flatMap {
      case (users, machines) =>
        val Seq(user1, user2) = users
        val Seq(machine1, machine2) = machines

        userMachineQuery ++= Seq(
          (user1.id.get, machine1.id.get),
          (user2.id.get, machine1.id.get),
          (user2.id.get, machine2.id.get)
        )
    }
  }

  /**
   * Runs action in rolled-back transaction.
   *
   * @param func function to run in rolled-back transaction
   * @tparam Result type returned by `f`
   * @return value returned from `f`
   */
  def rollbackActionWithModel[Result](func: => DBIO[Result]): Unit = withApp { implicit app =>

    val createAndRunAction = for {
      _ <- usersRepository.create()
      _ <- machineRepository.create()
      _ <- userMachineQuery.schema.create
    } yield ()

    val out = createAndRunAction
      .flatMap(_ => func)
      .flatMap(_ => DBIO.failed(RollbackException)).transactionally

    val DB = DatabaseConfigProvider.get(app).db

    Try(Await.result(DB.run(out), 10.seconds)) match {
      case Failure(RollbackException) =>
      case Failure(other) => throw other
    }
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

}