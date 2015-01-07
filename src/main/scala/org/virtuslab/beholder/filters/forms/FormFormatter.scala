package org.virtuslab.beholder.filters.forms

import play.api.data.{ FormError, Form, Mapping }
import org.virtuslab.beholder.filters.{ Order, FilterDefinition }
import play.api.data.Forms._
import play.api.data.format.Formatter

case class FormFormatter(filterFields: Seq[FormFilterField[_, _]], columnsNames: Seq[String]) {

  private def fieldName(key: String)(name: String) = s"$key.$name"

  private val dataFormatter = new Formatter[Seq[Option[Any]]] {
    override def bind(key: String, data: Map[String, String]): Either[Seq[FormError], Seq[Option[Any]]] = {

      Right((columnsNames zip filterFields).map {
        case (name, column) => column.bind(fieldName(key)(name))(data) match {
          case Left(_) => None
          case Right(value) => Option(value)
        }
      })
    }

    override def unbind(key: String, value: Seq[Option[Any]]): Map[String, String] = {
      value.zip(columnsNames zip filterFields).flatMap {
        case (Some(value), (name, filterField)) => filterField.unbind(fieldName(key)(name))(value)
        case (None, _) => Map[String, String]()
      }(collection.breakOut)
    }
  }

  private val orderingFormatter = new Formatter[Order] {
    def ascKey(key: String) = s"$key.asc"

    def columnKey(key: String) = s"$key.column"

    override def bind(key: String, data: Map[String, String]): Either[Seq[FormError], Order] = {
      data.get(columnKey(key)).fold[Either[Seq[FormError], Order]](Left(Seq(FormError(key, "no field to order by")))) { value =>
        data.get(ascKey(key)) match {
          case Some("true") => Right(Order(value, true))
          case Some("false") => Right(Order(value, false))
          case _ => Left(Seq(FormError(ascKey(columnKey(key)), "Asc field not set!")))
        }
      }
    }

    override def unbind(key: String, value: Order): Map[String, String] = {
      Map(columnKey(key) -> value.column, ascKey(key) -> value.asc.toString)
    }
  }

  private val baseFilterEntityMapping = mapping(
    "take" -> optional(number),
    "skip" -> optional(number),
    "ordering" -> optional(of(orderingFormatter)),
    "data" -> of(dataFormatter)
  )(FilterDefinition.apply)(FilterDefinition.unapply)

  /**
   * from mapping for this filter
   * @return
   */
  protected def filterMapping: Mapping[FilterDefinition] = baseFilterEntityMapping

  /**
   * form for this filter
   * @return
   */
  final def filterForm = Form(filterMapping)
}

