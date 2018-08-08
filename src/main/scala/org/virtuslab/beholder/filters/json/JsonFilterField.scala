package org.virtuslab.beholder.filters
package json

import play.api.libs.functional.syntax._

import slick.ast.BaseTypedType
import play.api.libs.json._

import scala.reflect.ClassTag

trait JsonFilterField {
  def fieldTypeDefinition: JsValue

  def readFilter(value: JsValue): JsResult[Any]

  def writeFilter(value: Any): JsValue

  def isIgnored = false
}

trait MappedJsonFilterField[B] extends JsonFilterField {
  protected def valueFormat: Format[B]

  protected def ct: ClassTag[B]

  protected val rangeFormat: Format[FilterRange[B]] = {
    val defaultFormat: Format[FilterRange[B]] = ((__ \ "from").formatNullable(valueFormat) and
      (__ \ "to").formatNullable(valueFormat))(FilterRange.apply, unlift(FilterRange.unapply))

    new Format[FilterRange[B]] {
      override def writes(o: FilterRange[B]): JsValue = defaultFormat.writes(o)

      override def reads(json: JsValue): JsResult[FilterRange[B]] =
        defaultFormat.reads(json).filterNot(JsError("Range cannot be empty!"))(_.isEmpty)
    }
  }

  protected val alternativeFormat: Format[FilterAlternative[B]] = {
    implicit def forValue = valueFormat

    val reads = JsPath.read[Seq[B]].map(FilterAlternative.apply)
    val seqWrites = JsPath.write[Seq[B]]
    val writes = Writes[FilterAlternative[B]](v => seqWrites.writes(v.options))
    Format(reads, writes)
  }

  def tryAlso(current: JsResult[Any], newOne: JsResult[Any]): JsResult[Any] = {
    (current, newOne) match {
      case (error: JsError, error2: JsError) => error ++ error2
      case (error: JsError, succes: JsSuccess[Any]) => succes
      case _ => current
    }
  }

  override def readFilter(value: JsValue): JsResult[Any] =
    tryAlso(rangeFormat.reads(value), tryAlso(alternativeFormat.reads(value), valueFormat.reads(value)))

  override def writeFilter(value: Any): JsValue = {
    implicit val bct = ct
    value match {
      case range: FilterRange[B] => rangeFormat.writes(range)
      case alternative: FilterAlternative[B] => alternativeFormat.writes(alternative)
      case value: B => valueFormat.writes(value)
      case other =>
        throw new IllegalArgumentException( //TODO #28 Beholder exceptions
          s"$value of class ${value.getClass.getName} is passed to JsonFilterField[${ct.runtimeClass.getName}]")
    }
  }

}

class IdentityJsonField[A: ClassTag: BaseTypedType: JsonTypedType] extends MappedFilterField[A] with MappedJsonFilterField[A] {
  private def jsonTypeType = implicitly[JsonTypedType[A]]

  // TODO report to Jetbrain - when implementing ct ClassManifest is inserted instead of ClassTag
  //override protected implicit def ct: ClassManifest[A] = ???

  override protected def ct: ClassTag[A] = implicitly[ClassTag[A]]

  override protected def valueFormat: Format[A] = jsonTypeType.format

  override def fieldTypeDefinition: JsValue = jsonTypeType.fieldJsonDefinition
}
