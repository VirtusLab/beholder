package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ FilterConstrains, FilterDefinition, Order }
import play.api.data.validation.ValidationError
import play.api.libs.json._

object JsonDefinitionFormatter {

  import play.api.libs.functional.syntax._
  import play.api.libs.json._

  private def mapped[A, B](format: OFormat[A])(apply: A => B, unapply: B => A) = new OFormat[B] {
    override def writes(o: B): JsObject = format.writes(unapply(o))

    override def reads(json: JsValue): JsResult[B] = format.reads(json).map(apply)
  }

  private def nullableWithDefault[A](format: OFormat[Option[A]])(default: A): OFormat[A] =
    mapped(format)(_.getOrElse(default), x => Some(x).filter(_ != default))

  private def columnReads(jsonFilter: JsonFilter) = new Reads[String] {
    override def reads(json: JsValue): JsResult[String] = json match {
      case JsString(name) if jsonFilter.jsonField(name).isDefined =>
        JsSuccess(name)
      case _ =>
        JsError(ValidationError(s"No such field $json in filter ${jsonFilter.name}"))
    }
  }

  private def orderFormat(filter: JsonFilter): Format[Order] = (
    (__ \ "column").format[String](columnReads(filter)) and
    nullableWithDefault((__ \ "asc").formatNullable[Boolean])(true)
  )(Order.apply, unlift(Order.unapply))

  def formatFor(filter: JsonFilter): Format[FilterDefinition] = {
    val forOrdering = mapped[Option[Order], Seq[Order]](
      (__ \ "ordering").formatNullable(orderFormat(filter))
    )(_.toSeq, _.headOption)

    val forData = nullableWithDefault((__ \ "data").formatNullable(new JsonConstrainsFormatter(filter)))(FilterConstrains())

    ((__ \ "take").formatNullable[Int] and
      (__ \ "skip").formatNullable[Int] and
      forOrdering and
      forData)(FilterDefinition.apply, unlift(FilterDefinition.unapply))
  }
}

case class FieldDef(path: Array[String], data: JsValue) {

  def isNested = path.length > 1

  def name = path.head

  def dropParent = copy(path = path.tail)
}

case class JsonConstrainsFormatter(filter: JsonFilter) extends Format[FilterConstrains] {

  override def reads(json: JsValue): JsResult[FilterConstrains] =
    json match {
      case JsObject(fields) =>
        createConstrains(fields.map {
          case (name, fieldJson) => FieldDef(name.split('.'), fieldJson)
        })
      case _ =>
        JsError("Constrains must be converted from object.")
    }

  override def writes(o: FilterConstrains): JsValue = JsObject(jsonFields(o))

  private def jsonFields(filterConstrains: FilterConstrains): Seq[(String, JsValue)] = {
    val fromNested = filterConstrains.nestedConstrains.flatMap {
      case (nestedName, constrains) => jsonFields(constrains).map {
        case (fieldName, value) => s"$nestedName.$fieldName" -> value
      }
    }
    val fromFields = filterConstrains.fieldConstrains.toSeq.map {
      case (name, value) =>
        val filterField = filter.jsonField(name)
          .getOrElse(throw new IllegalArgumentException(s"Filter ${filter.name} hasn't got field: $name"))
        name -> filterField.writeFilter(value)
    }

    fromFields ++ fromNested
  }

  def createConstrains(fields: Iterable[FieldDef]): JsResult[FilterConstrains] = {
    val (nested, inner) = fields.partition(_.isNested)

    val foldStart: JsResult[FilterConstrains] = JsSuccess(FilterConstrains())
    val withInners = inner.foldLeft(foldStart)(appendFields)
    val withNested = nested.groupBy(_.name).foldLeft(withInners)(appendNested)

    withNested
  }

  private def appendFields(to: JsResult[FilterConstrains], fieldDef: FieldDef): JsResult[FilterConstrains] = {
    filter.jsonField(fieldDef.name) match {
      case Some(field) =>
        val result = field.readFilter(fieldDef.data)

        to.flatMap { constrains =>
          result.map(constrains.addFieldConstrain(fieldDef.name))
        }
      case _ =>
        to.flatMap(_ => JsError(s"Field ${fieldDef.name} cannot be mapped field to ${filter.name}"))
    }
  }

  private def appendNested(to: JsResult[FilterConstrains],
    fields: (String, Iterable[FieldDef])): JsResult[FilterConstrains] = {
    val (name, newFields) = fields
    val nestedResult = for {
      nestedFilter <- filter.nestedFilterFor(name)
      formatter = JsonConstrainsFormatter(nestedFilter)
    } yield formatter.createConstrains(newFields.map(_.dropParent))

    to.flatMap { result =>
      nestedResult.getOrElse(JsError(s"Missing nested filter for $name in filter ${filter.name}.")).map(result.addNested(name))
    }

  }
}