package org.virtuslab.beholder.filters.json

import org.joda.time.{ DateTime, LocalDate }
import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.utils.ILikeExtension._
import org.virtuslab.beholder.utils.SeqParametersHelperComponent
import org.virtuslab.unicorn.UnicornWrapper
import play.api.libs.functional.syntax._
import play.api.libs.json._
import slick.ast.{ BaseTypedType, TypedType }
import sttp.tapir._
import sttp.tapir.Schema._

trait JsonFilterFieldsComponent extends FilterFieldComponent with SeqParametersHelperComponent {
  self: UnicornWrapper[Long] =>

  import unicorn._
  import unicorn.profile.api._
  import CustomTypeMappers._

  private object SingleFieldTypeDefinition {
    def get(name: String, label: String, dataType: String): JsObject = {
      Json.obj(
        "key" -> JsString(name),
        "label" -> JsString(label),
        "type" -> JsString(dataType))
    }
  }

  trait JsonFieldFormatter {
    def fieldTypeDefinition(label: String => String): Seq[JsValue]
    def filterColumnNames: Seq[String]
    def writeValue(value: Any): JsObject
    def readFilter(obj: JsObject): JsResult[Option[Any]]
    def writeFilter(value: Any): JsObject
  }

  abstract sealed class JsonFilterField[Data: TypedType, Filter] extends MappedFilterField[Data, Filter] {
    def filterSchemas(name: String): Seq[SchemaType.SProductField[Seq[Option[Any]]]]
  }

  abstract class SingleFieldJsonFilterField[Data: TypedType, Filter] extends JsonFilterField[Data, Filter] {
    def fieldFormatter(name: String): JsonFieldFormatter
    override def filterSchemas(name: String): Seq[SchemaType.SProductField[Seq[Option[Any]]]] = Seq(SchemaType.SProductField(FieldName(name, name), filterSchema.asOption, _ => None))
    def filterSchema: Schema[Filter]
  }

  abstract class SingleFieldJsonFilterFieldFromFormat[Data: TypedType: Writes, Filter: Format](dataType: String) extends SingleFieldJsonFilterField[Data, Filter] {
    protected def formatterFieldAppendix(name: String, label: String => String): JsObject = Json.obj()
    def fieldFormatter(name: String): JsonFieldFormatter = {
      new JsonFieldFormatter {
        override def fieldTypeDefinition(label: String => String): Seq[JsValue] = {
          Seq(SingleFieldTypeDefinition.get(name, label(name), dataType) ++ formatterFieldAppendix(name, label))
        }
        override def filterColumnNames: Seq[String] = Seq(name)
        override def writeValue(value: Any): JsObject = Json.obj(name -> Json.toJson(value.asInstanceOf[Data]))
        override def readFilter(obj: JsObject): JsResult[Option[Filter]] = {
          obj.value.get(name).fold[JsResult[Option[Filter]]](JsSuccess(None))(value => Json.fromJson(value).map(Some(_)))
        }
        override def writeFilter(value: Any): JsObject = Json.obj(name -> Json.toJson(value.asInstanceOf[Filter]))
      }
    }
  }

  abstract class VarLengthJsonFilterField[Data: TypedType, Filter](dataType: String, fields: String*) extends JsonFilterField[Data, Filter] {
    def dataObjWrites: Writes[Data]
    def filterObjFormat: Format[Filter]
    val fieldFormatter: JsonFieldFormatter = {
      new JsonFieldFormatter {
        override def fieldTypeDefinition(label: String => String): Seq[JsValue] = fields.map(field => SingleFieldTypeDefinition.get(field, label(field), dataType))
        override def filterColumnNames: Seq[String] = fields
        override def writeValue(value: Any): JsObject = dataObjWrites.writes(value.asInstanceOf[Data]).asInstanceOf[JsObject]
        override def readFilter(obj: JsObject): JsResult[Option[Filter]] = JsSuccess(filterObjFormat.reads(obj).asOpt)
        override def writeFilter(value: Any): JsObject = filterObjFormat.writes(value.asInstanceOf[Filter]).asInstanceOf[JsObject]
      }
    }
  }

  object JsonFilterFields {
    /**
     * find exact number
     */
    object inIntField extends SingleFieldJsonFilterFieldFromFormat[Int, Int]("Int") {
      override protected def filterOnColumn(column: Rep[Int])(data: Int): Rep[Option[Boolean]] = column.? === data
      override def filterSchema: Schema[Int] = Schema.schemaForInt
    }

    /**
     * check if value is in given sequence
     */
    object inIntFieldSeq extends SingleFieldJsonFilterFieldFromFormat[Int, Seq[Int]]("IntSeq") {
      override protected def filterOnColumn(column: Rep[Int])(dataSeq: Seq[Int]): Rep[Option[Boolean]] = {
        SeqParametersHelper.isColumnValueInsideSeq(column)(dataSeq)((column, data) => column.? === data)
      }
      def filterSchema: Schema[Seq[Int]] = Schema.schemaForIterable
    }

    object inBigDecimal extends SingleFieldJsonFilterFieldFromFormat[BigDecimal, BigDecimal]("bigDecimal") {
      override protected def filterOnColumn(column: Rep[BigDecimal])(data: BigDecimal): Rep[Option[Boolean]] = column.? === data
      def filterSchema: Schema[BigDecimal] = Schema.schemaForBigDecimal
    }

    /**
     * simple check boolean
     */
    object inBoolean extends SingleFieldJsonFilterFieldFromFormat[Boolean, Boolean]("Boolean") {
      override def filterOnColumn(column: Rep[Boolean])(data: Boolean): Rep[Option[Boolean]] = column.? === data
      def filterSchema: Schema[Boolean] = Schema.schemaForBoolean
    }

    /**
     * search in text (ilike)
     */
    object inText extends SingleFieldJsonFilterFieldFromFormat[String, String]("Text") {
      override def filterOnColumn(column: Rep[String])(data: String): Rep[Option[Boolean]] = column.? ilike s"%${escape(data)}%"
      def filterSchema: Schema[String] = Schema.schemaForString
    }

    /**
     * check if text is in given text sequence (ilike)
     */
    object inTextSeq extends SingleFieldJsonFilterFieldFromFormat[String, Seq[String]]("TextSeq") {
      override def filterOnColumn(column: Rep[String])(data: Seq[String]): Rep[Option[Boolean]] = {
        SeqParametersHelper.isColumnValueInsideSeq(column)(data)((column, d) => column.? ilike s"%${escape(d)}%")
      }
      def filterSchema: Schema[Seq[String]] = Schema.schemaForIterable
    }

    /**
     * search in text (ilike) for optional fields
     */
    object inOptionText extends SingleFieldJsonFilterFieldFromFormat[Option[String], String]("OptionalText") {
      override def filterOnColumn(column: Rep[Option[String]])(data: String): Rep[Option[Boolean]] = column ilike s"%${escape(data)}%"
      def filterSchema: Schema[String] = Schema.schemaForString
    }

    val inDateTime: SingleFieldJsonFilterFieldFromFormat[DateTime, DateTime] = {
      import play.api.libs.json.JodaReads.jodaDateReads
      import play.api.libs.json.JodaWrites.jodaDateWrites
      implicit val format = new Format[DateTime] {
        override def writes(o: DateTime): JsValue = jodaDateWrites("yyyy-MM-dd HH:mm").writes(o)
        override def reads(json: JsValue): JsResult[DateTime] = jodaDateReads("yyyy-MM-dd HH:mm").reads(json)
      }
      new SingleFieldJsonFilterFieldFromFormat[DateTime, DateTime]("DateTime") {
        override def filterOnColumn(column: Rep[DateTime])(data: DateTime): Rep[Option[Boolean]] = column.? === data
        def filterSchema: Schema[DateTime] = Schema.string[DateTime].format("yyyy-MM-dd HH:mm")
      }
    }

    val inLocalDate: SingleFieldJsonFilterFieldFromFormat[LocalDate, LocalDate] = {
      import play.api.libs.json.JodaReads._
      import play.api.libs.json.JodaWrites._
      new SingleFieldJsonFilterFieldFromFormat[LocalDate, LocalDate]("LocalDate") {
        override def filterOnColumn(column: Rep[LocalDate])(data: LocalDate): Rep[Option[Boolean]] = column.? === data
        def filterSchema: Schema[LocalDate] = Schema.string[LocalDate].format("yyyy-MM-dd")
      }
    }

    /**
     * check enum value
     * @tparam T - enum class (eg. Colors.type)
     */
    def inEnum[T <: Enumeration](enum: T)(implicit tm: BaseTypedType[T#Value], formatter: Format[T#Value], schema: Schema[T#Value]): SingleFieldJsonFilterFieldFromFormat[T#Value, T#Value] = {
      new SingleFieldJsonFilterFieldFromFormat[T#Value, T#Value]("") {
        override def formatterFieldAppendix(name: String, label: String => String): JsObject = Json.obj(
          "type" -> JsArray(enum.values.toList.map(v => Json.toJson(v.asInstanceOf[T#Value]))))
        override protected def filterOnColumn(column: Rep[T#Value])(value: T#Value): Rep[Option[Boolean]] = column.? === value
        def filterSchema: Schema[T#Value] = schema
      }
    }

    /**
     * check if enum value is in given sequence
     * @tparam T - enum class (eg. Colors.type)
     */
    def inEnumSeq[T <: Enumeration](enum: T)(implicit tm: BaseTypedType[T#Value], formatter: Format[T#Value], schema: Schema[T#Value]): SingleFieldJsonFilterFieldFromFormat[T#Value, Seq[T#Value]] = {
      implicit val format = new Format[Seq[T#Value]] {
        override def reads(json: JsValue): JsResult[Seq[T#Value]] = JsSuccess(json.as[Seq[T#Value]])
        override def writes(o: Seq[T#Value]): JsValue = JsArray(o.map(Json.toJson(_)))
      }
      new SingleFieldJsonFilterFieldFromFormat[T#Value, Seq[T#Value]]("") {
        override def formatterFieldAppendix(name: String, label: String => String): JsObject = Json.obj(
          "type" -> JsArray(enum.values.toList.map(v => Json.toJson(v.asInstanceOf[T#Value]))))
        override protected def filterOnColumn(column: Rep[T#Value])(dataSeq: Seq[T#Value]): Rep[Option[Boolean]] = {
          SeqParametersHelper.isColumnValueInsideSeq(column)(dataSeq)((column, data) => column.? === data)
        }
        def filterSchema: Schema[Seq[T#Value]] = Schema.schemaForIterable
      }
    }

    def inField[T: BaseTypedType: Format: Schema](typeName: String) =
      new SingleFieldJsonFilterFieldFromFormat[T, T](typeName) {
        override def filterOnColumn(column: Rep[T])(data: T): Rep[Option[Boolean]] = column.? === data
        def filterSchema: Schema[T] = implicitly[Schema[T]]
      }

    def inFieldSeq[T: BaseTypedType: Format: Schema](typeName: String) =
      new SingleFieldJsonFilterFieldFromFormat[T, Seq[T]](typeName) {
        override def filterOnColumn(column: Rep[T])(dataSeq: Seq[T]): Rep[Option[Boolean]] = {
          SeqParametersHelper.isColumnValueInsideSeq(column)(dataSeq)((column, data) => column.? === data)
        }
        def filterSchema: Schema[Seq[T]] = Schema.schemaForIterable
      }

    def inRange[T: BaseTypedType: Format](baseType: SingleFieldJsonFilterField[T, T]): SingleFieldJsonFilterFieldFromFormat[T, FilterRange[T]] = {
      new SingleFieldJsonFilterFieldFromFormat[T, FilterRange[T]]("range") {
        override def filterOnColumn(column: Rep[T])(value: FilterRange[T]): Rep[Option[Boolean]] = {
          value match {
            case FilterRange(Some(from), Some(to)) => column.? >= from && column.? <= to
            case FilterRange(None, Some(to)) => column.? <= to
            case FilterRange(Some(from), None) => column.? >= from
            case _ => LiteralColumn(Some(true))
          }
        }

        override protected def formatterFieldAppendix(name: String, label: String => String): JsObject = Json.obj(
          "innerType" -> (baseType.fieldFormatter(name).fieldTypeDefinition(label).headOption.getOrElse(JsNull): JsValue))
        def filterSchema: Schema[FilterRange[T]] = {
          implicit val tSchema = baseType.filterSchema
          FilterRange.schema[T]
        }
      }
    }

    def inOptionRange[T: BaseTypedType: Format](baseType: SingleFieldJsonFilterField[T, T]): SingleFieldJsonFilterFieldFromFormat[Option[T], FilterRange[T]] = {
      implicit val optionTWrites: Writes[Option[T]] = new Writes[Option[T]] {
        override def writes(o: Option[T]) = o.map(implicitly[Writes[T]].writes).getOrElse(JsNull)
      }
      new SingleFieldJsonFilterFieldFromFormat[Option[T], FilterRange[T]]("range") {
        override def filterOnColumn(column: Rep[Option[T]])(value: FilterRange[T]): Rep[Option[Boolean]] = {
          value match {
            case FilterRange(Some(from), Some(to)) => column >= from && column <= to
            case FilterRange(None, Some(to)) => column <= to
            case FilterRange(Some(from), None) => column >= from
            case _ => LiteralColumn(Some(true))
          }
        }

        override protected def formatterFieldAppendix(name: String, label: String => String): JsObject = Json.obj(
          "innerType" -> (baseType.fieldFormatter(name).fieldTypeDefinition(label).headOption.getOrElse(JsNull): JsValue))
        def filterSchema: Schema[FilterRange[T]] = {
          implicit val tSchema = baseType.filterSchema
          FilterRange.schema[T]
        }
      }
    }

    /**
     * Ignores given field in filter.
     */
    def ignore[T: TypedType: Writes]: SingleFieldJsonFilterField[T, T] = {
      new SingleFieldJsonFilterField[T, T] {
        override def filterOnColumn(column: Rep[T])(value: T): Rep[Option[Boolean]] = LiteralColumn(Some(true))
        override def fieldFormatter(name: String): JsonFieldFormatter = new JsonFieldFormatter {
          override def fieldTypeDefinition(label: String => String): Seq[JsValue] = Seq.empty
          override def filterColumnNames: Seq[String] = Seq(name)
          override def writeValue(value: Any): JsObject = Json.obj(name -> implicitly[Writes[T]].writes(value.asInstanceOf[T]))
          override def readFilter(obj: JsObject): JsResult[Option[T]] = JsSuccess(None)
          override def writeFilter(value: Any): JsObject = Json.obj(name -> implicitly[Writes[T]].writes(value.asInstanceOf[T]))
        }
        def filterSchema: Schema[T] = Schema.schemaForUnit.as[T]
      }
    }
  }
}
