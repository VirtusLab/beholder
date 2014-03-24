package org.virtuslab.beholder

import org.virtuslab.beholder.model._
import play.api.db.slick.Config.driver.simple._
import org.virtuslab.beholder.model.User
import org.virtuslab.beholder.views.FilterableViews
import scala.slick.jdbc.StaticQuery


/**
 * Author: Krzysztof Romanowski
 */
class ManyToManyView extends AppTest with UserMachinesView {


  "views rows" should "queried from view" in rollbackWithModel {
    implicit session: Session =>
      val view = createUsersMachineView
      view.ddl.create

      val db = new PopulatedDatabase()
      import db._


      val s = session.conn.createStatement().executeQuery("show tables")

    Query(view).list().size should equal(3)
  }


}
