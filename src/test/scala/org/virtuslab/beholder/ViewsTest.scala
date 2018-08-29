package org.virtuslab.beholder

import scala.concurrent.ExecutionContext.Implicits.global

class ViewsTest extends BaseTest {
  import userMachinesViewRepository._
  import unicorn.profile.api._

  "view" should "be queryable" in rollbackActionWithModel {
    for {
      _ <- populatedDatabase
      view <- userMachinesViewRepository.createUsersMachineView()
      all <- view.result
    } yield all.size shouldEqual 3
  }

  "view" should "be creatable" in rollbackActionWithModel {

    for {
      _ <- createUsersMachineView()
      _ <- drop()
      _ <- create()
      _ <- drop()
    } yield ()
  }

}
