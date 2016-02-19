package org.virtuslab.beholder.filters.json

import java.sql.Date

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.views.BaseView
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._
import play.api.libs.json._
import slick.ast.BaseTypedType

import scala.reflect.ClassTag

case class JsonTypedType[A](fieldJsonDefinition: JsValue)(
  implicit val ct: ClassTag[A],
  implicit val typed: BaseTypedType[A],
  implicit val format: Format[A])

object JsonTypedType {
  def apply[A: ClassTag: BaseTypedType: Format](name: String): JsonTypedType[A] = JsonTypedType(JsString(name))

  def apply[A: ClassTag: BaseTypedType: Format]: JsonTypedType[A] =
    apply(implicitly[ClassTag[A]].runtimeClass.getSimpleName)

}

object JsonDSL
    extends DSLBase[FilterField with JsonFilterField, JsonFilterImpl, JsonTypedType]
    with JsonTypedTypeImplicits {

  override def create[E, T](viewFilterState: JsonDSL.FilterQueryState[E, T]): JsonFilterImpl[E, T] =
    new TableBasedFilter(viewFilterState) with JsonFilterImpl[E, T] {
      override protected def jsonFields: Map[String, JsonFilterField] = viewFilterState.fields
    }

  override def create[E, T <: BaseView[E]](viewFilterState: JsonDSL.ViewFilterState[E, T]): JsonFilterImpl[E, T] =
    new ViewBasedFilter[E, T](viewFilterState) with JsonFilterImpl[E, T] {
      override protected def jsonFields: Map[String, JsonFilterField] = viewFilterState.fields
    }

  override def in[T: JsonTypedType]: MappedFilterField[T] with JsonFilterField = {
    val formatter: JsonTypedType[T] = implicitly
    import formatter._ //TODO report to Jetbrians
    new IdentityJsonField[T]
  }

  override def inText: MappedFilterField[String] with JsonFilterField = in[String](stringJsonTypedField)

  override def inEnum[T <: Enumeration](implicit to: JsonTypedType[T#Value]): FilterField with JsonFilterField with MappedFilterField[T#Value] =
    in[T#Value]

  def inEnum[T <: Enumeration](enum: T)(implicit to: BaseTypedType[T#Value],
    formatter: Format[T#Value]): FilterField with JsonFilterField with MappedFilterField[T#Value] =
    in[T#Value](forEnumeration(enum))

}

trait JsonTypedTypeImplicits {
  implicit val intJsonTypedField = JsonTypedType[Int]
  implicit val stringJsonTypedField = JsonTypedType[String]
  implicit val bigDecimalJsonTypedField = JsonTypedType[BigDecimal]
  implicit val booleanJsonTypedField = JsonTypedType[Boolean]
  implicit val dateJsonTypedField = JsonTypedType[Date]

  def forEnumeration[T <: Enumeration](enum: T)(implicit to: BaseTypedType[T#Value], formatter: Format[T#Value]): JsonTypedType[T#Value] =
    JsonTypedType[T#Value](
      JsArray(enum.values.toSeq.map(v => Json.toJson(v.asInstanceOf[T#Value])))
    )

}
