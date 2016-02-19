package org.virtuslab.beholder.suites

import org.virtuslab.beholder._
import org.virtuslab.beholder.filters.{FilterConstrains, FilterAPI, FilterDefinition, LightFilter}
import org.virtuslab.beholder.model._
import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._


trait JoinSuite extends FiltersTestSuite {
  self: AppTest =>

  def createTeamFilter(data: BaseFilterData): LightFilter[Team, Teams]

  def createUserMachineFilter(data: BaseFilterData): LightFilter[UserMachineViewRow, _ <: BaseView[UserMachineViewRow]]

  private val adminJoinName = "admin"

  final override def createFilter(data: BaseFilterData): FilterAPI[UserMachineViewRow] = {
    createUserMachineFilter(data).join(adminJoinName, createTeamFilter(data))(
      (um, t) => t.admin === um.typedColumnByName[UserId]("userId"))
  }


  it should "perform simple join" in baseFilterTest {
    data =>
      import data._

      def testTeamName(testTeamName: String) = {
        val allTeams = TableQuery[Teams].list.toSet

        val fromDbOrderedByCores =
          allFromDb.filter(v => allTeams.exists(t => t.admin == v.userId && t.teamName == testTeamName))

        val filterDefinition = addJoin(adminJoinName, FilterConstrains(fieldConstrains = Map("teamName" -> testTeamName)))

        val orderByCore = doFilters(data, filterDefinition)

        orderByCore should contain theSameElementsInOrderAs fromDbOrderedByCores
      }

      testTeamName("core")
      testTeamName("non-existing")
  }

  it should "perform avoid name clashes" in baseFilterTest {
    data =>
      import data._

      val allTeams = TableQuery[Teams].list.toSet



      val fromDbOrderedByCores =
        allFromDb.filter(v => allTeams.exists(t => t.admin == v.userId && t.system == "Ubuntu"))

      val filterDefinition = addJoin(adminJoinName, FilterConstrains(fieldConstrains = Map("system" -> "Ubuntu")))

      val orderByCore = doFilters(data, filterDefinition)

      orderByCore should contain theSameElementsInOrderAs fromDbOrderedByCores
  }

  it should "fails on nonexisting join" in baseFilterTest {
    data =>
      import data._

      val filterDefinition = addJoin(adminJoinName, FilterConstrains(fieldConstrains = Map("nonExisting" -> "bum")))

      intercept[IllegalArgumentException] { doFilters(data, filterDefinition) }
  }

}
