package org.virtuslab.beholder.filters.json

import play.api.libs.json._

trait JsonFilterField {

  def fieldTypeDefinition: JsValue

  def writeValue(value: Any): JsValue //= valueWrite.writes(value.asInstanceOf[A])

  def readFilter(value: JsValue): JsResult[Any] //= filterFormat.reads(value)

  def writeFilter(value: Any): JsValue //= filterFormat.writes(value.asInstanceOf[B])

  def isIgnored = false
}

trait MappedJsonFilterField[A, B] extends JsonFilterField{
  protected def filterFormat: Format[B]

  protected def valueWrite: Writes[A]

  override def readFilter(value: JsValue): JsResult[Any] = filterFormat.reads(value)

  override def writeFilter(value: Any): JsValue = filterFormat.writes(value.asInstanceOf[B])

  override def writeValue(value: Any): JsValue = valueWrite.writes(value.asInstanceOf[A])
}