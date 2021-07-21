package org.virtuslab.beholder

import org.virtuslab.beholder.model._
import org.virtuslab.beholder.views.FilterableViewsComponent
import org.virtuslab.unicorn.UnicornWrapper
import shapeless.{ Generic, ::, HNil }

trait LargeElementsViewComponent
  extends FilterableViewsComponent
  with LargeComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._

  lazy val largeElementsQuery: Query[LargeElements, LargeElement, Seq] = for {
    element <- TableQuery[LargeElements]
  } yield (element)

  lazy val largeElementsViewTableQuery = createView(
    "LARGE_ELEMENTS",
    Generic[LargeElement],
    largeElementsQuery) {
      case (e) =>
        //naming the fields
        "id" -> e.id.? ::
          "f1" -> e.f1 ::
          "f2" -> e.f2 ::
          "f3" -> e.f3 ::
          "f4" -> e.f4 ::
          "f5" -> e.f5 ::
          "f6" -> e.f6 ::
          "f7" -> e.f7 ::
          "f8" -> e.f8 ::
          "f9" -> e.f9 ::
          "f10" -> e.f10 ::
          "f11" -> e.f11 ::
          "f12" -> e.f12 ::
          "f13" -> e.f13 ::
          "f14" -> e.f14 ::
          "f15" -> e.f15 ::
          "f16" -> e.f16 ::
          "f17" -> e.f17 ::
          "f18" -> e.f18 ::
          "f19" -> e.f19 ::
          "f20" -> e.f20 ::
          "f21" -> e.f21 ::
          "f22" -> e.f22 ::
          HNil
    }

  def viewQuery = largeElementsViewTableQuery

}