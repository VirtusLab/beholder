package org.virtuslab.beholder

import java.sql.Date

import org.joda.time.DateTime
import org.scalatest.{ BeforeAndAfterEach, FlatSpecLike, Matchers }
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.repositories._
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import play.api.test.FakeApplication

import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, ExecutionContext }
import scala.util.{ Failure, Success, Try }

trait BaseTest extends FlatSpecLike with Matchers

trait ModelIncluded extends AppTest {

  lazy val UsersRepository = new UsersRepository {}

  lazy val MachineRepository = new MachineRepository {}

  lazy val TeamsRepository = new TeamsRepository {}

  lazy val ProjectRepository = new ProjectRepository()

  lazy val machineParameterRepository = new MachineParameterRepository {}

  lazy val userJoinMachinesQuery = for {
    user <- Users.query
    userMachine <- UserMachines.query if user.id === userMachine.userId
    machine <- Machines.query if machine.id === userMachine.machineId
  } yield (user, machine)

  final def rollbackWithModel[A](func: => DBIO[A])(implicit ec: ExecutionContext): Unit = rollbackAction {
    for {
      _ <- MachineRepository.createAction()
      _ <- UsersRepository.createAction()
      _ <- UserMachines.query.schema.create
      _ <- machineParameterRepository.createAction()
      _ <- TeamsRepository.createAction()
      _ <- ProjectRepository.createAction()
      result <- func
    } yield result
  }

  class PopulatedDatabase {

    var testUsers: Seq[User] = Seq.empty
    var testMachines: Seq[Machine] = Seq.empty
    var testMachineParameters: Seq[MachineParameter] = Seq.empty
    var testUserMachines: Seq[(UserId, MachineId)] = Seq.empty
    var testTeams: Seq[Team] = Seq.empty

    def populate(implicit ec: ExecutionContext): DBIO[Unit] = {
      for {
        Seq(user1, user2) <- populateUsers
        Seq(machine1, machine2) <- populateMachines
        userMachines <- populateUserMachines(user1, user2, machine1, machine2)
        machineParameters <- populateMachineParameters(machine1)
        team <- populateTeams(user1)
      } yield {
        testUsers = Seq(user1, user2)
        testMachines = Seq(machine1, machine2)
        testMachineParameters = machineParameters
        testUserMachines = userMachines
        testTeams = Seq(team)
      }
    }

    private def populateUsers(implicit ec: ExecutionContext): DBIO[Seq[User]] = {
      DBIO.sequence(Seq(
        User(None, "a@a.pl", "Ala", "maKota"),
        User(None, "o@a.pl", "Ola", "maPsa")
      ).map(user => UsersRepository.saveAction(user).map(id => user.copy(id = Some(id)))))
    }

    private def populateMachines(implicit ec: ExecutionContext): DBIO[Seq[Machine]] = {
      DBIO.sequence(Seq(
        Machine(None, "a.a.pl", "Ubuntu", 4, new Date(DateTime.now().minusHours(24).getMillis), Some(1.00)),
        Machine(None, "o.a.pl", "Fedora", 1, new Date(DateTime.now().getMillis), Some(3.00))
      ).map(machine => MachineRepository.saveAction(machine).map(id => machine.copy(id = Some(id)))))
    }

    private def populateUserMachines(user1: User, user2: User, machine1: Machine, machine2: Machine)(implicit ec: ExecutionContext): DBIO[Seq[(UserId, MachineId)]] = {
      val userMachines = Seq(
        (user1.id.get, machine1.id.get),
        (user2.id.get, machine1.id.get),
        (user2.id.get, machine2.id.get)
      )
      (UserMachines.query ++= userMachines).map(_ => userMachines)
    }

    private def populateMachineParameters(machine1: Machine)(implicit ec: ExecutionContext): DBIO[Seq[MachineParameter]] = {
      val machine1Parameters = Map(
        "displayCount" -> "2",
        "cdDriveSpeed" -> "x52",
        "color" -> "red"
      )
      val machine2Parameters = Map(
        "displayCount" -> "2",
        "cdDriveSpeed" -> "x52",
        "color" -> "red"
      )

      DBIO.sequence(Seq(machine1.id.get -> machine1Parameters, machine1.id.get -> machine2Parameters).flatMap {
        case (machineId, values) =>
          values.map {
            case (name, value) =>
              val mp = MachineParameter(None, name, value, machineId)
              machineParameterRepository.saveAction(mp).map(id => mp.copy(id = Option(id)))
          }
      })
    }

    private def populateTeams(user: User)(implicit ec: ExecutionContext): DBIO[Team] = {
      val team = Team(None, user.id.get, "core", "Ubuntu")
      TeamsRepository.saveAction(team).map(id => team.copy(id = Some(id)))
    }

  }
}

//TODO #34 migrate tests to slick 3.0 approach
trait AppTest extends BaseTest with BeforeAndAfterEach {

  import play.api.libs.concurrent.Execution.Implicits._

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

  object RollbackException extends Exception

  /**
   * Runs action in rolled-back transaction.
   *
   * @param func function to run in rolled-back transaction
   * @tparam Result type returned by `f`
   * @return value returned from `f`
   */
  def rollbackAction[Result](func: => DBIO[Result]): Unit = withApp { implicit app =>
    val out = func.flatMap(_ => DBIO.failed(RollbackException)).transactionally
    Try(Await.result(DB.run(out), Duration.Inf)) match {
      case Failure(RollbackException) => ()
      case Failure(other) => throw other
      case Success(_) => ()
    }
  }

  def DB = DatabaseConfigProvider.get(play.api.Play.current).db.asInstanceOf[driver.profile.backend.DatabaseDef]
}
