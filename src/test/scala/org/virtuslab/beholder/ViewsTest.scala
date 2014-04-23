package org.virtuslab.beholder

import scala.slick.lifted.Query
import play.api.db.slick.Config.driver.simple._
import java.sql.Connection


class ViewsTest extends AppTest with UserMachinesView {

  "view" should "be querable" in rollbackWithModel {
    implicit session =>

      val view = createUsersMachineView

      new PopulatedDatabase

      val query = for {
        a <- view
      } yield a


      val all = query.list

      all.size should equal(3)
  }

}
