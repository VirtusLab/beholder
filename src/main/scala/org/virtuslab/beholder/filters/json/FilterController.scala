package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple.Session
import play.api.libs.json.JsValue
import play.api.mvc._

abstract class FilterController[Entity <: Product](filter: FilterAPI[Entity, JsonFormatter[Entity]]) extends Controller {

  type FilterContext

  protected def getSession(t: FilterContext): Session

  protected def getRequest(t: FilterContext): Request[JsValue]

  protected def inFilterContext(body: FilterContext => Option[JsValue]): EssentialAction

  final def filterDefinition = inFilterContext { _: FilterContext =>
    Option(filter.formatter.jsonDefinition)
  }

  //for filter modification such us setting default parameters etc.
  protected def mapFilterData(data: FilterDefinition) = data

  final def doFilter: EssentialAction =
    inFilterContext {
      context: FilterContext =>
        for {
          filterDefinition <- filter.formatter.filterDefinition(getRequest(context).body)
          data = filter.filterWithTotalEntitiesNumber(mapFilterData(filterDefinition))(getSession(context))
        } yield filter.formatter.results(filterDefinition, data)
    }
}