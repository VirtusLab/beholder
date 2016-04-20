package org.virtuslab.beholder

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import scala.concurrent.ExecutionContext.Implicits.global

class ViewsTest extends AppTest with UserMachinesView {

  "view" should "be queryable" in rollbackActionWithModel {
    for {
      _ <- populatedDatabase
      view <- createUsersMachineView()
      all <- view.result
    } yield {
      all.size shouldEqual 3
    }
  }

  "view" should "be creatable" in rollbackActionWithModel {
    for {
      view <- createUsersMachineView()
      _ <- view.viewDDL.drop
      _ <- view.viewDDL.create
      _ <- view.viewDDL.drop
    } yield ()
  }

}
