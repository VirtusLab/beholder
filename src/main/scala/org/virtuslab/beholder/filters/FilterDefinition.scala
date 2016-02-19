package org.virtuslab.beholder.filters



case class Order(column: String, asc: Boolean)

object Order {
}


case class FilterConstrains(fieldConstrains: Map[String, Any] = Map.empty,
                            nestedConstrains: Map[String, FilterConstrains] = Map.empty)

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
                             orderBy: Seq[Order],
                             constrains:  FilterConstrains
                           )

object FilterDefinition{
  def empty = FilterDefinition(None, None, Nil, FilterConstrains(Map(), Map()))
}

case class FilterRange[T](from: Option[T], to: Option[T])

case class FilterResult[T](content: Seq[T], total: Int) {

  def this(data: Seq[T]) {
    this(data, data.size)
  }
}