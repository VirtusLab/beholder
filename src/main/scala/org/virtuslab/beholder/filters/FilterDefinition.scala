package org.virtuslab.beholder.filters

import play.api.libs.json.Json

case class Order(column: String, asc: Boolean)

object Order {
  implicit val format = Json.format[Order]
}

/**
 * Base class that is mapped to form.
 * Contains all common and specific (data field of generic type Data) filter data
 *
 * @param take how many elements to take
 * @param skip how many elements to skip before taking
 * @param orderBy field by which ordering is done
 */
case class FilterDefinition(
  take: Option[Int],
  skip: Option[Int],
  orderBy: Option[Order],
  data: Seq[Option[Any]]
)

case class FilterRange[T](from: Option[T], to: Option[T])