package org.virtuslab.beholder.view

import org.virtuslab.beholder.AppTest
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import play.api.libs.concurrent.Execution.Implicits._

class ViewsTest extends AppTest with UserMachinesView {

  "view" should "be queryable" in rollbackWithModel {

    val data = new PopulatedDatabase

    for {
      _ <- createUsersMachineView
      _ <- data.populate
      all <- viewQuery.result
      _ <- dropUsersMachineView
    } yield {
      all.size shouldEqual 3
    }
  }

  "view" should "be creatable" in rollbackWithModel {
    for {
      _ <- viewQuery.viewDDL.create
      _ <- viewQuery.viewDDL.drop
      _ <- viewQuery.viewDDL.create
      _ <- viewQuery.viewDDL.drop
    } yield ()
  }

}
