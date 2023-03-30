package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ BaseFilterComponent, FilterDefinition, Order }
import org.virtuslab.unicorn.UnicornWrapper
import play.api.libs.json._
import sttp.tapir.Schema
import sttp.tapir.SchemaType
import sttp.tapir.FieldName

trait JsonFormatterComponent extends JsonFilterFieldsComponent with BaseFilterComponent {
  self: UnicornWrapper[Long] =>

  class JsonFormatter[Entity <: Product](filterFields: Seq[JsonFilterField[_, _]], dataColumnsNames: Seq[String], label: String => String) {

    private val fieldFormatters = filterFields.zip(dataColumnsNames).map {
      case (single: SingleFieldJsonFilterField[_, _], name) => single.fieldFormatter(name)
      case (varLength: VarLengthJsonFilterField[_, _], _) => varLength.fieldFormatter
    }

    def jsonDefinition: JsValue = JsArray {
      fieldFormatters.flatMap(_.fieldTypeDefinition(label))
    }
    val filterDefinitionSchema: Schema[FilterDefinition] = {
      implicit val filterDataSchema: Schema[Seq[Option[Any]]] = Schema(SchemaType.SProduct(filterFields.zip(dataColumnsNames).flatMap {
        case (single: SingleFieldJsonFilterField[_, _], name) => single.filterSchemas(name)
        case (varLength: VarLengthJsonFilterField[_, _], _) => varLength.filterSchemas("")
      }.toList))
      import sttp.tapir.generic.auto._

      Schema(
        SchemaType.SProduct(
          List(
            SchemaType.SProductField(FieldName("take"), Schema.schemaForOption[Int], fd => Some(fd.take)),
            SchemaType.SProductField(FieldName("skip"), Schema.schemaForOption[Int], fd => Some(fd.skip)),
            SchemaType.SProductField(FieldName("ordering"), Schema.schemaForOption[Order], fd => Some(fd.orderBy)),
            SchemaType.SProductField(FieldName("data"), filterDataSchema, fd => Some(fd.data)),
          )
        )
      )
    }


    private val filterDataFormatter: Format[Seq[Option[Any]]] = new Format[Seq[Option[Any]]] {
      override def writes(o: Seq[Option[Any]]): JsValue = {
        (fieldFormatters, o).zipped.map {
          case (formatter, value) => value.map(formatter.writeFilter).getOrElse(Json.obj())
        }.foldLeft(Json.obj())(_ ++ _)
      }

      override def reads(json: JsValue): JsResult[Seq[Option[Any]]] = json match {
        case jsObject: JsObject =>
          jsObject.keys -- fieldFormatters.flatMap(_.filterColumnNames) match {
            case badFields if badFields.nonEmpty =>
              JsError((JsPath(Nil), JsonValidationError("No such fields in filter: " + badFields)))
            case _ =>
              val fieldResults = fieldFormatters.map(_.readFilter(jsObject))
              val (successes, errors) = fieldResults.partition(_.isSuccess)
              if (errors.isEmpty) {
                JsSuccess(successes.map(_.get))
              } else {
                errors.map(_.asInstanceOf[JsError]).fold(JsError())(_ ++ _)
              }

          }
        case _ => JsError((JsPath(Nil), JsonValidationError("Filter definition must be an object!")))

      }
    }

    import play.api.libs.functional.syntax._
    import play.api.libs.json._

    private implicit val orderingFormatter: Format[Order] = (
      (__ \ "column").format[String] and
      (__ \ "asc").format[Boolean])(Order.apply, unlift(Order.unapply))

    implicit val filterDefinitionFormat: Format[FilterDefinition] =
      ((__ \ "take").formatNullable[Int] and
        (__ \ "skip").formatNullable[Int] and
        (__ \ "ordering").formatNullable[Order] and
        (__ \ "data").format(filterDataFormatter))(FilterDefinition.apply, unlift(FilterDefinition.unapply))

    private implicit val entityWrites: Writes[Entity] = Writes { entity: Entity =>
      fieldFormatters.zip(entity.productIterator.toIterable).map {
        case (formatter, value) => formatter.writeValue(value)
      }.foldLeft(Json.obj())(_ ++ _)
    }

    final def results(from: FilterDefinition, data: FilterResult[Entity]): JsValue = {
      Json.toJson(CompoundResult(from, data))
    }

    final def filterDefinition(from: JsValue): JsResult[FilterDefinition] = filterDefinitionFormat.reads(from)

    final def entities(from: FilterDefinition, data: Seq[Entity]): JsValue = JsObject(Seq(
      "filter" -> Json.toJson(from)(filterDefinitionFormat),
      "data" -> JsArray(data.map(entityWrites.writes))))

  }

}
