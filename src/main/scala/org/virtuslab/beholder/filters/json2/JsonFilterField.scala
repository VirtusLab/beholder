package org.virtuslab.beholder.filters.json2

import org.joda.time.DateTime
import org.virtuslab.beholder.filters.{FilterRange, MappedFilterField}
import org.virtuslab.beholder.utils.ILikeExtension._
import org.virtuslab.unicorn.LongUnicornPlay.CustomTypeMappers._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.libs.functional.syntax._
import play.api.libs.json._

import scala.slick.ast.{ BaseTypedType, TypedType }

abstract class JsonFilterField[A: TypedType, B] extends MappedFilterField[A, B] {
  def fieldTypeDefinition: JsValue

  protected def filterFormat: Format[B]

  protected def valueWrite: Writes[A]

  final def writeValue(value: Any): JsValue = valueWrite.writes(value.asInstanceOf[A])

  final def readFilter(value: JsValue): JsResult[Any] = filterFormat.reads(value)

  final def writeFilter(value: Any): JsValue = filterFormat.writes(value.asInstanceOf[B])

  def isIgnored = false
}

abstract class ImplicitlyJsonFilterFiled[A: TypedType: Writes, B: Format](dataTypeName: String)
    extends JsonFilterField[A, B] {
  override def fieldTypeDefinition: JsValue = JsString(dataTypeName)

  override protected def valueWrite: Writes[A] = implicitly

  override protected def filterFormat: Format[B] = implicitly
}

object JsonFilterFields {

  /**
   * search in text (ilike)
   */
  object inIntField extends ImplicitlyJsonFilterFiled[Int, Int]("Int") {
    override protected def filterOnColumn(column: Column[Int])(data: Int): Column[Option[Boolean]] = column === data
  }

  object inBigDecimal extends ImplicitlyJsonFilterFiled[BigDecimal, BigDecimal]("bigDecimal") {
    override protected def filterOnColumn(column: Column[BigDecimal])(data: BigDecimal): Column[Option[Boolean]] = column === data
  }

  /**
   * simple check boolean
   */
  object inBoolean extends ImplicitlyJsonFilterFiled[Boolean, Boolean]("Boolean") {
    override def filterOnColumn(column: Column[Boolean])(data: Boolean): Column[Option[Boolean]] = column === data
  }

  /**
   * search in text (ilike)
   */
  object inText extends ImplicitlyJsonFilterFiled[String, String]("Text") {
    override def filterOnColumn(column: Column[String])(data: String): Column[Option[Boolean]] = column ilike s"%${escape(data)}%"
  }

  /**
   * search in text (ilike) for optional fields
   */
  object inOptionText extends ImplicitlyJsonFilterFiled[Option[String], String]("OptionalText") {
    override def filterOnColumn(column: Column[Option[String]])(data: String): Column[Option[Boolean]] = column ilike s"%${escape(data)}%"
  }

  object inDateTime extends ImplicitlyJsonFilterFiled[DateTime, DateTime]("DateTime") {
    override def filterOnColumn(column: Column[DateTime])(data: DateTime): Column[Option[Boolean]] = column === data
  }

  /**
   * check enum value
    *
    * @tparam T - enum class (eg. Colors.type)
   */
  def inEnum[T <: Enumeration](enum: T)(implicit tm: BaseTypedType[T#Value], formatter: Format[T#Value]): JsonFilterField[T#Value, T#Value] = {
    new JsonFilterField[T#Value, T#Value] {
      override def fieldTypeDefinition: JsValue = JsArray(
        enum.values.toList.map(v => Json.toJson(v.asInstanceOf[T#Value]))
      )

      override protected def valueWrite: Writes[T#Value] = implicitly

      override protected def filterFormat: Format[T#Value] = implicitly

      override protected def filterOnColumn(column: Column[T#Value])(value: T#Value): Column[Option[Boolean]] = column === value
    }
  }

  private implicit def rangeFormat[T: Format]: Format[FilterRange[T]] =
    ((__ \ "from").format[Option[T]] and
      (__ \ "to").format[Option[T]])(FilterRange.apply, unlift(FilterRange.unapply))

  def inField[T: BaseTypedType: Format](typeName: String) =
    new ImplicitlyJsonFilterFiled[T, T](typeName) {
      override def filterOnColumn(column: Column[T])(data: T): Column[Option[Boolean]] = column === data
    }

  def inRange[T: BaseTypedType: Format](baseType: JsonFilterField[T, T]): JsonFilterField[T, FilterRange[T]] =
    new JsonFilterField[T, FilterRange[T]] {
      override def filterOnColumn(column: Column[T])(value: FilterRange[T]): Column[Option[Boolean]] = {
        value match {
          case FilterRange(Some(from), Some(to)) => column >= from && column <= to
          case FilterRange(None, Some(to)) => column <= to
          case FilterRange(Some(from), None) => column >= from
          case _ => LiteralColumn(Some(true))
        }
      }

      override def fieldTypeDefinition: JsValue = JsObject(Seq(
        "type" -> JsString("range"),
        "dataType" -> baseType.fieldTypeDefinition
      ))

      override protected def valueWrite: Writes[T] = implicitly

      override protected def filterFormat: Format[FilterRange[T]] = implicitly
    }

  def inOptionRange[T: BaseTypedType: Format](baseType: JsonFilterField[T, T]): JsonFilterField[Option[T], FilterRange[T]] =
    new JsonFilterField[Option[T], FilterRange[T]] {
      override def filterOnColumn(column: Column[Option[T]])(value: FilterRange[T]): Column[Option[Boolean]] = {
        value match {
          case FilterRange(Some(from), Some(to)) => column >= from && column <= to
          case FilterRange(None, Some(to)) => column <= to
          case FilterRange(Some(from), None) => column >= from
          case _ => LiteralColumn(Some(true))
        }
      }

      override def fieldTypeDefinition: JsValue = JsObject(Seq(
        "type" -> JsString("range"),
        "dataType" -> baseType.fieldTypeDefinition
      ))

      override protected def valueWrite: Writes[Option[T]] = implicitly

      import play.api.libs.json._

      override protected def filterFormat: Format[FilterRange[T]] = rangeFormat
    }

  /**
   * Ignores given field in filter.
   */
  def ignore[T: TypedType: Writes]: JsonFilterField[T, T] = new JsonFilterField[T, T] {

    override def fieldTypeDefinition: JsValue = JsNull

    override protected def valueWrite: Writes[T] = implicitly

    override protected def filterFormat: Format[T] = new Format[T] {
      override def reads(json: JsValue): JsResult[T] = JsError()

      override def writes(o: T): JsValue = JsNull
    }

    override def filterOnColumn(column: Column[T])(value: T): Column[Option[Boolean]] = LiteralColumn(Some(true))

    override def isIgnored: Boolean = true
  }
}