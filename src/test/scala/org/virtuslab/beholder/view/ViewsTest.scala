package org.virtuslab.beholder.view

import org.virtuslab.beholder.AppTest
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

class ViewsTest extends AppTest with UserMachinesView {

  //TODO rename this!!
  "view" should "be queryable" in rollbackWithModel {
    implicit session =>

      val view = createUsersMachineView

      new PopulatedDatabase

      val all = view.list

      all.size shouldEqual 3
  }

  "view" should "be creatable" in rollbackWithModel {
    implicit session =>
      val view = createUsersMachineView
      view.viewDDL.drop
      view.viewDDL.create
      view.viewDDL.drop
  }

}
