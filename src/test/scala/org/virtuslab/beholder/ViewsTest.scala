package org.virtuslab.beholder

import org.virtuslab.beholder.utils.Slick3Invoker
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

class ViewsTest extends AppTest with UserMachinesView {

  "view" should "be queryable" in rollbackWithModel {
    implicit session =>

      val view = createUsersMachineView()

      //      view.schema.create

      new PopulatedDatabase

      val all = view.list

      println(all)
      all.size shouldEqual 3
  }

  "view" should "be creatable" in rollbackWithModel {
    implicit session =>
      val view = createUsersMachineView()
      Slick3Invoker.invokeAction(view.viewDDL.drop)
      Slick3Invoker.invokeAction(view.viewDDL.create)
      Slick3Invoker.invokeAction(view.viewDDL.drop)
  }

}
