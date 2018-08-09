package org.virtuslab.beholder.suites

import org.virtuslab.beholder.filters.{ FilterConsumer, FilterConstrains, ImplementedFilter }
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.view.UserMachineViewRow
import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import scala.concurrent.ExecutionContext.Implicits.global

trait JoinSuite extends FiltersTestSuite with ViewBasedTest {

  //TODO #36 add 3 nested deep
  //TODO #36 negative tests

  def createTeamFilter(data: BaseFilterData): ImplementedFilter[Team, Teams]

  def createBaseFilter(data: BaseFilterData): ImplementedFilter[UserMachineViewRow, _ <: BaseView[UserMachineViewRow]]

  private val adminJoinName = "admin"

  override def createConsumer(data: BaseFilterData): FilterConsumer[UserMachineViewRow] = {
    val userMachineFilter = createBaseFilter(data)
    val teamFilter = createTeamFilter(data)

    userMachineFilter.join(adminJoinName, teamFilter)(
      (um, t) => t.admin === um.typedColumnByName[UserId]("userId")
    ).list
  }

  it should "perform simple join" in baseFilterTest {
    data =>
      import data._

      def testTeamName(testTeamName: String) = {
        for {
          _ <- createUsersMachineView
          allTeams <- Teams.query.result.map(_.toSet)
          fromDbOrderedByCores <- view.result.map(_.filter(v => allTeams.exists(t => t.admin == v.userId && t.teamName == testTeamName)))
          filterDefinition = addJoin(adminJoinName, FilterConstrains(fieldConstrains = Map("teamName" -> testTeamName)))
        } yield {
          filtering(filterDefinition) shouldResultIn fromDbOrderedByCores
        }
      }

      testTeamName("core")
      testTeamName("non-existing")
  }

  it should "avoid name clashes" in baseFilterTest {
    data =>
      import data._
      for {
        _ <- createUsersMachineView
        allTeams <- Teams.query.result.map(_.toSet)
        fromDbOrderedByCores <- view.result.map(_.filter(v => allTeams.exists(t => t.admin == v.userId && t.system == "Ubuntu")))
        filterDefinition = addJoin(adminJoinName, FilterConstrains(fieldConstrains = Map("system" -> "Ubuntu")))
      } yield {
        filtering(filterDefinition) shouldResultIn fromDbOrderedByCores
      }
  }

  it should "fails on nonexisting join" in baseFilterTest {
    data =>
      import data._

      val filterDefinition = addJoin(adminJoinName, FilterConstrains(fieldConstrains = Map("nonExisting" -> "bum")))

      intercept[IllegalArgumentException] {
        filtering(filterDefinition) shouldResultIn Nil
      }
      DBIO.successful(())
  }

}
