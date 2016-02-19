package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.FilterDefinition
import play.api.mvc._
import play.api.libs.json._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api.Session
/*
abstract class FilterController[Entity: Writes](filter: JsonAwareFilter[Entity]) extends Controller {

  //TODO - move json to different project and best controller also

  protected def inSession(body: Request[AnyContent] => Session => JsResult[JsValue]): EssentialAction

  final def filterDefinition = inSession { request =>
    _ =>
      JsSuccess(filter.jsonDefinition)
  }

  //for filter modification such us setting default parameters etc.
  protected def mapFilterData(data: FilterDefinition) = data

  final def doFilter(): EssentialAction =
    inSession {
      request =>
        implicit session =>
          for {
            json <- request.body.asJson.fold[JsResult[JsValue]](JsError("not valid json"))(js => JsSuccess(js))
            filterDefinition <- JsonDefinitionFormatter.formatFor(filter).reads(json)
            data = filter.filterWithTotalEntitiesNumber(mapFilterData(filterDefinition))
          } yield ResultWritter.formatResults(filter)(data, filterDefinition)
    }
} *///TODO Contexted filters
/*

abstract class ContextFilterController[Context, Entity <: Product](contextedFilter: ContextedFilterAPI[Context, Entity, JsonFormatter[Entity]])
  extends FilterControllerBase[Context, Entity] {
  override private[beholder] final def formatter: JsonFormatter[Entity] = contextedFilter.filterFormatter

  override private[beholder] final def callFilter(context: Context, filterDefinition: FilterDefinition): FilterResult[Entity] = {
    contextedFilter.apply(context).filterWithTotalEntitiesNumber(filterDefinition)(sessionFromContext(context))
  }

  protected def sessionFromContext(context: Context): Session
}


/**
  * copy this filter with this initial filter.
  * Returned filter will always yield entities that match  newInitialFilter
  */
def withContextInitialFilter[Context](newInitialFilter: Context => QueryBase => Column[Boolean]): ContextedFilterAPI[Context, Entity, Formatter] = {
  val org = this
  new ContextedFilterAPI[Context, Entity, Formatter] {
  override def apply(context: Context): FilterAPI[Entity, Formatter] = withInitialFilter(newInitialFilter(context))

  override private[beholder] def filterFormatter: Formatter = org.formatter
}
}
*/
