package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters._
import play.api.libs.json._
import slick.dbio.DBIO

import scala.concurrent.ExecutionContext


//TODO #26 Make this part of dsl
class JsonConsumer[E: Writes](override val filter: BeholderFilter[E, _] with JsonFilter)
  extends FilterConsumer[E, BeholderFilter[E, _] with JsonFilter, JsValue]{

  private val stanrdResults = new StandardConsumer(filter)

  override def consume(definition: FilterDefinition)(implicit ec: ExecutionContext): DBIO[JsValue] = {
    val jsonDefinition = JsonDefinitionFormatter.formatFor(filter).writes(definition)
    stanrdResults.consume(definition)
      .map(JsonConsumer.writeResults(jsonDefinition))
  }
}


object JsonConsumer{
  import JsonKeys.Results._

  def writeResults[E: Writes](definitionJson: JsValue)
                     (results: FilterResult[E]): JsValue =
    JsObject(Seq(
      filterKey -> definitionJson,
      resultKey -> JsObject(Seq(
        dataKey -> JsArray(results.content.map(implicitly[Writes[E]].writes)),
        totalKey -> JsNumber(results.total)
      ))
    ))
}