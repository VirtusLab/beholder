package org.virtuslab.beholder.filters

case class FilterResult[T](content: Seq[T], total: Int) {
  def this(data: Seq[T]) {
    this(data, data.size)
  }
}


object FilterResult {

  import play.api.libs.functional.syntax._
  import play.api.libs.json.Format._
  import play.api.libs.json._

  implicit def format[T](implicit f: Format[T]): Format[FilterResult[T]] = (
    (__ \ "data").format[Seq[T]] and
      (__ \ "total").format[Int]
    )(FilterResult.apply, unlift(FilterResult.unapply))
}
