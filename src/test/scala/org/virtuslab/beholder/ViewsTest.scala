package org.virtuslab.beholder

import scala.concurrent.ExecutionContext.Implicits.global

class ViewsTest extends BaseTest {

  "view" should "be queryable" in { implicit f =>
    import f._
    import f.unicorn.profile.api._
    rollbackActionWithModel {
      for {
        _ <- populatedDatabase
        view <- userMachinesViewRepository.createUsersMachineView()
        all <- view.result
      } yield all.size shouldEqual 3
    }
  }

  "view" should "be creatable" in { implicit f =>
    rollbackActionWithModel {
      import f.userMachinesViewRepository._
      for {
        _ <- createUsersMachineView()
        _ <- drop()
        _ <- create()
        _ <- drop()
      } yield ()
    }
  }

}
