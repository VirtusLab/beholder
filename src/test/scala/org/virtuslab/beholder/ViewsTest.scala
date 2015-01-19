package org.virtuslab.beholder

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

class ViewsTest extends AppTest with UserMachinesView {

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
