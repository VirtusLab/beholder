package org.virtuslab.beholder.consumers.json
/*

import org.virtuslab.beholder.consumers.FilterAwareConsumer
import org.virtuslab.beholder.filters.{BeholderFilter, FilterDefinition, FilterResult}
import org.virtuslab.beholder.filters.json.JsonFilter
import play.api.libs.json._


trait JsonConsumer {
  def doFilter(input: JsValue): JsResult[JsValue]

  def filterDefinition: JsValue
}

trait JsonFilterAwareConsumer[E, T, R] extends FilterAwareConsumer[E, T, FilterResult[R]] with JsonConsumer{
  override def filter: BeholderFilter[E, T] with JsonFilter

  def resultWrites: Writes[R]

  def doFilter(input: JsValue): JsResult[JsValue] ={
    val definitionFormatter = JsonDefinitionFormatter.formatFor(filter)

    //TODO - exception handling
    definitionFormatter.reads(input)
      .map(apply)
      .map(JsonConsumer.writeResults(input, resultWrites))
  }

  override def filterDefinition: JsValue = filter.jsonDefinition
}

object JsonConsumer{
  import JsonKeys.Results._

  def writeResults[R](definitionJson: JsValue,
                      resultWrites: Writes[R])
                     (results: FilterResult[R]): JsValue =
    JsObject(Seq(
      filterKey -> definitionJson,
      resultKey -> JsObject(Seq(
        dataKey -> JsArray(results.content.map(resultWrites.writes)),
        totalKey -> JsNumber(results.total)
      ))
    ))
}
*/
