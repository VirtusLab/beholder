package org.virtuslab.beholder

import java.sql.Date

import org.joda.time.DateTime
import org.scalatest.{ BeforeAndAfterEach, FlatSpecLike, Matchers }
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.repositories._
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import org.virtuslab.unicorn.utils.Invoker
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import play.api.test.FakeApplication

import slick.lifted.TableQuery

object TestInvoker extends Invoker

trait BaseTest extends FlatSpecLike with Matchers

trait ModelIncluded extends AppTest {

  lazy val UsersRepository = new UsersRepository {}

  lazy val MachineRepository = new MachineRepository {}

  lazy val TeamsRepository = new TeamsRepository {}

  lazy val ProjectRepository = new ProjectRepository()

  lazy val machineParameterRepository = new MachineParameterRepository {}

  lazy val userMachineQuery = TableQuery[UserMachines]

  lazy val userJoinMachinesQuery = for {
    user <- TableQuery[Users]
    userMachine <- userMachineQuery if user.id === userMachine.userId
    machine <- TableQuery[Machines] if machine.id === userMachine.machineId
  } yield (user, machine)

  final def rollbackWithModel[A](func: Session => A): A = rollback {
    implicit session: Session =>
      UsersRepository.create()
      MachineRepository.create()
      TestInvoker.invokeAction(userMachineQuery.schema.create)
      machineParameterRepository.create()
      TeamsRepository.create()
      ProjectRepository.create()

      func(session)
  }

  class PopulatedDatabase(implicit session: Session) {

    val users = Seq(
      User(None, "a@a.pl", "Ala", "maKota"),
      User(None, "o@a.pl", "Ola", "maPsa")
    ).map(user => user.copy(id = Some(UsersRepository.save(user))))

    val machines = Seq(
      Machine(None, "a.a.pl", "Ubuntu", 4, new Date(DateTime.now().minusHours(24).getMillis), Some(1.00)),
      Machine(None, "o.a.pl", "Fedora", 1, new Date(DateTime.now().getMillis), Some(3.00))
    ).map(machine => machine.copy(id = Some(MachineRepository.save(machine))))

    val Seq(user1, user2) = users
    val Seq(machine1, machine2) = machines

    val userMachines = Seq(
      (user1.id.get, machine1.id.get),
      (user2.id.get, machine1.id.get),
      (user2.id.get, machine2.id.get)
    )

    TestInvoker.invokeAction(userMachineQuery ++= userMachines)

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

    val machineParameters = Seq(machine1.id.get -> machine1Parameters, machine1.id.get -> machine2Parameters).flatMap{
      case (machineId, values) =>
        values.map {
          case (name, value) =>
            val mp = MachineParameter(None, name, value, machineId)
            val id = machineParameterRepository.save(mp)
            mp.copy(id = Option(id))
        }
    }

 /*   val machineParameters = Seq(
      MachineParameter(None, "displaysCount", "2", machine1.id.get),
      MachineParameter(None, "displaysCount", "1", machine2.id.get),
      MachineParameter(None, "cdDriveSpeed", "x52", machine1.id.get),
      MachineParameter(None, "cdDriveSpeed", "x52", machine1.id.get)

    ).map(mp => mp.copy(id = Some(machineParameterRepository.save(mp))))
*/
    val teams = Seq(Team(None, user1.id.get, "core", "Ubuntu"))
      .map(t => t.copy(id = Some(TeamsRepository.save(t))))

    val projects = Seq(
      Project(None, "Beholder", None, user1.id.get, ProjectType.Outer),
      Project(None, "Unicorn", None, user2.id.get, ProjectType.Outer),
      Project(None, "ProjectX", teams.head.id, user1.id.get, ProjectType.Inner),
      Project(None, "ProjectX-2.0", teams.head.id, user2.id.get, ProjectType.Evaluation)
    )
  }
}

trait AppTest extends BaseTest with BeforeAndAfterEach {

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
    DB.withTransaction { //TODO remove old method
      session: Session =>
        val out = func(session)
        session.rollback()
        out
    }
  }

  def DB = DatabaseConfigProvider.get(play.api.Play.current).db.asInstanceOf[driver.profile.backend.DatabaseDef]
}
