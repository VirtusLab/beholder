package org.virtuslab.beholder.filters.json2

import org.virtuslab.beholder.filters.{ FilterDefinition, FilterResult, Order }
import play.api.data.validation.ValidationError
import play.api.libs.json.{ JsObject, _ }

class JsonFormatter[Entity <: Product](filterFields: Seq[JsonFilterField[_, _]], columnsNames: Seq[String], label: String => String) {
/*

  private def jsonFieldDefinition(name: String, field: JsonFilterField[_, _]): JsObject = JsObject(Seq(
    "key" -> JsString(name),
    "label" -> JsString(label(name)),
    "type" -> field.fieldTypeDefinition
  ))

  def jsonDefinition: JsValue =
    JsArray(columnsNames.zip(filterFields)
      .filterNot(_._2.isIgnored)
      .map(Function.tupled(jsonFieldDefinition)))

  import play.api.libs.functional.syntax._
  import play.api.libs.json._

  private implicit val orderingFormatter: Format[Order] = (
    (__ \ "column").format[String] and
    (__ \ "asc").format[Boolean]
  )(Order.apply, unlift(Order.unapply))

  private val filterDataFormatter: Format[Map[String, Any]] = new Format[Map[String, Any]] {
    override def writes(data: Map[String, Any]): JsValue = JsObject(
      filterFields.zip(data).map {
        case ( filterField, (name, value)) =>
            name -> filterField.writeFilter(value)
      }
    )

    override def reads(json: JsValue): JsResult[Map[String, Any]] = json match {
      case jsObject: JsObject =>
        jsObject.keys -- columnsNames.toSet match {
          case badFields if badFields.nonEmpty =>
            JsError((JsPath(Nil), ValidationError("No such fields in filter: " + badFields)))
          case _ =>
            jsObject.value.zip(filterFields).map{
              case ((name, value), filterField) =>
                name -> filterField.readFilter(value)
            }
            val fieldResults = columnsNames.map(jsObject.value.get).zip(filterFields).map {
              case (Some(value), field) => field.readFilter(value).map(Option.apply)
              case (None, _) => JsSuccess(None)
            }
            val (successes, errors) = fieldResults.partition(_.isSuccess)
            if (errors.isEmpty) {
              JsSuccess(successes.map(_.get))
            } else {
              errors.map(_.asInstanceOf[JsError]).fold(JsError())(_ ++ _)
            }

        }
      case _ => JsError((JsPath(Nil), ValidationError("Filter definition must be an object!")))

    }
  }

  implicit val filterDefinitionFormat: Format[FilterDefinition] =
    ((__ \ "take").formatNullable[Int] and
      (__ \ "skip").formatNullable[Int] and
      (__ \ "ordering").formatNullable[Order] and
      (__ \ "data").format(filterDataFormatter))(FilterDefinition.apply, unlift(FilterDefinition.unapply))

  private def entity2Json(data: Entity): JsValue =
    JsObject(
      columnsNames.zip(filterFields).zip(data.productIterator.toIterable).map {
        case ((name, filterFiled), value) => name -> filterFiled.writeValue(value)
      }
    )

  final def filterDefinition(from: JsValue): Option[FilterDefinition] = from.asOpt(filterDefinitionFormat)

  final def entities(from: FilterDefinition, data: Seq[Entity]): JsValue = JsObject(Seq(
    "filter" -> Json.toJson(from)(filterDefinitionFormat),
    "data" -> JsArray(data.map(entity2Json))
  ))

  final def results(from: FilterDefinition, data: FilterResult[Entity]): JsValue = JsObject(Seq(
    "filter" -> Json.toJson(from)(filterDefinitionFormat),
    "result" -> JsObject(Seq(
      "data" -> JsArray(data.content.map(entity2Json)),
      "total" -> JsNumber(data.total)
    ))
  ))
*/

}
