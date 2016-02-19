package org.virtuslab.beholder.filters.json2

import org.virtuslab.beholder.filters.FilterResult

object FilterResultMapping {

  import play.api.libs.functional.syntax._
  import play.api.libs.json.Format._
  import play.api.libs.json._

  implicit def format[T](implicit f: Format[T]): Format[FilterResult[T]] = (
    (__ \ "data").format[Seq[T]] and
      (__ \ "total").format[Int]
    )(FilterResult.apply, unlift(FilterResult.unapply))
}