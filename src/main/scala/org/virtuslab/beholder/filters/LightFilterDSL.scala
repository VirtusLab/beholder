package org.virtuslab.beholder.filters

import org.virtuslab.beholder.utils.ILikeExtension._
import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import slick.ast.BaseTypedType

import scala.reflect.ClassTag

class LightDslMapper[A](implicit val btt: BaseTypedType[A], val ct: ClassTag[A])

object LightDslMapper {
  implicit def create[A: ClassTag: BaseTypedType] = new LightDslMapper[A]
}

object LightDSLFilter extends DSLBase[FilterField, LightFilter, LightDslMapper] {
  override def create[E, T <: BaseView[E]](viewFilterState: LightDSLFilter.ViewFilterState[E, T]): LightFilter[E,  T] =
    new ViewBasedFilter[E, T](viewFilterState)

  override def create[E,  T](viewFilterState: LightDSLFilter.FilterQueryState[E,  T]): LightFilter[E,  T] =
    new TableBasedFilter[E,  T](viewFilterState)

  override def in[T: LightDslMapper]: FilterField with MappedFilterField[T] = {
    val formatter: LightDslMapper[T] = implicitly
    import formatter._
    new MappedFilterField[T]
  }

  override val inText = new MappedFilterField[String] {
    override protected def filterOnValue(column: Rep[String], data: String): Rep[Option[Boolean]] = column.? ilike s"%${escape(data)}%"
  }

  override def inEnum[T <: Enumeration](implicit to: LightDslMapper[T#Value]): FilterField with MappedFilterField[T#Value] =
    in[T#Value]
}
