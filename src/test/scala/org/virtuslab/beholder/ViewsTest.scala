package org.virtuslab.beholder

import play.api.db.slick.Config.driver.simple._

class ViewsTest extends AppTest with UserMachinesView {

  "view" should "be queryable" in rollbackWithModel {
    implicit session =>

      val view = createUsersMachineView

      new PopulatedDatabase

      val all = view.list

      all.size shouldEqual 3
  }

}
