package org.virtuslab.beholder.consumers.json

import org.virtuslab.beholder.filters.json.JsonFilter
import org.virtuslab.beholder.filters.{FilterDefinition, FilterResult}
import play.api.libs.json._


object ResultWritter {
  import JsonKeys.Results._

  def formatResults[E: Writes](filter: JsonFilter)(results: FilterResult[E], definition: FilterDefinition): JsValue = {
    val writes = implicitly[Writes[E]].writes _
    JsObject(Seq(
      filterKey -> JsonDefinitionFormatter.formatFor(filter).writes(definition),
      resultKey -> JsObject(Seq(
        dataKey -> JsArray(results.content.map(writes)),
        totalKey -> JsNumber(results.total)
      ))
    ))
  }
}

