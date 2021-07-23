package org.virtuslab.beholder.model

import org.virtuslab.unicorn.LongUnicornPlayIdentifiers.IdCompanion
import org.virtuslab.unicorn.{ BaseId, UnicornWrapper, WithId }
import shapeless.{ Generic, HNil }
import slickless._

case class LargeElementId(id: Long) extends BaseId[Long]

object LargeElementId extends IdCompanion[LargeElementId]

case class LargeElement(
  id: Option[LargeElementId],
  f1: String,
  f2: Int,
  f3: String,
  f4: String,
  f5: String,
  f6: String,
  f7: String,
  f8: String,
  f9: String,
  f10: String,
  f11: String,
  f12: String,
  f13: String,
  f14: String,
  f15: String,
  f16: String,
  f17: String,
  f18: String,
  f19: String,
  f20: String,
  f21: String,
  f22: String) extends WithId[Long, LargeElementId]

trait LargeComponent {
  self: UnicornWrapper[Long] =>

  import unicorn._
  import unicorn.profile.api._

  class LargeElements(tag: Tag) extends IdTable[LargeElementId, LargeElement](tag, "LARGE_ELEMENTS") {

    def f1 = column[String]("f1")
    def f2 = column[Int]("f2")
    def f3 = column[String]("f3")
    def f4 = column[String]("f4")
    def f5 = column[String]("f5")
    def f6 = column[String]("f6")
    def f7 = column[String]("f7")
    def f8 = column[String]("f8")
    def f9 = column[String]("f9")
    def f10 = column[String]("f10")
    def f11 = column[String]("f11")
    def f12 = column[String]("f12")
    def f13 = column[String]("f13")
    def f14 = column[String]("f14")
    def f15 = column[String]("f15")
    def f16 = column[String]("f16")
    def f17 = column[String]("f17")
    def f18 = column[String]("f18")
    def f19 = column[String]("f19")
    def f20 = column[String]("f20")
    def f21 = column[String]("f21")
    def f22 = column[String]("f22")

    override def * = (id.? :: f1 :: f2 :: f3 :: f4 :: f5 :: f6 :: f7 :: f8 :: f9 :: f10 :: f11 :: f12 :: f13
      :: f14 :: f15 :: f16 :: f17 :: f18 :: f19 :: f20 :: f21 :: f22 :: HNil).mappedWith(Generic[LargeElement])
  }

  class LargeElementRepository extends BaseIdRepository[LargeElementId, LargeElement, LargeElements](TableQuery[LargeElements])

  lazy val baseLargeElementsRepository = new LargeElementRepository

}