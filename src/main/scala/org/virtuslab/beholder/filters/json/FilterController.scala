package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ ContextedFilterAPI, FilterAPI, FilterDefinition, FilterResult }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple.Session
import play.api.libs.json.JsValue
import play.api.mvc._

trait FilterControllerBase[Context, Entity <: Product] extends Controller {
  protected def formatter: JsonFormatter[Entity]

  protected def callFilter(context: Context, filterDefinition: FilterDefinition): FilterResult[Entity]

  protected def inFilterContext(body: Request[JsValue] => Context => Option[JsValue]): EssentialAction

  final def filterDefinition = inFilterContext { request => _ => Option(formatter.jsonDefinition) }

  final def doFilter: EssentialAction =
    inFilterContext {
      request =>
        context =>
          for {
            filterDefinition <- formatter.filterDefinition(request.body)
            data = callFilter(context, mapFilterData(filterDefinition))
          } yield formatter.results(filterDefinition, data)
    }

  //for filter modification such us setting default parameters etc.
  protected def mapFilterData(data: FilterDefinition) = data
}

abstract class FilterController[Entity <: Product](filter: FilterAPI[Entity, JsonFormatter[Entity]])
    extends FilterControllerBase[Session, Entity] {

  protected def inSession(body: Request[JsValue] => Session => Option[JsValue]): EssentialAction

  override protected def inFilterContext(body: (Request[JsValue]) => (Session) => Option[JsValue]): EssentialAction =
    inSession(body)

  override final protected def callFilter(session: Session, filterDefinition: FilterDefinition): FilterResult[Entity] =
    filter.filterWithTotalEntitiesNumber(filterDefinition)(session)

  override protected final def formatter: JsonFormatter[Entity] = filter.formatter
}

abstract class ContextFilterController[Context, Entity <: Product](contextedFilter: ContextedFilterAPI[Context, Entity, JsonFormatter[Entity]])
    extends FilterControllerBase[Context, Entity] {
  override protected final def formatter: JsonFormatter[Entity] = contextedFilter._formatter

  override protected final def callFilter(context: Context, filterDefinition: FilterDefinition): FilterResult[Entity] = {
    contextedFilter.apply(context).filterWithTotalEntitiesNumber(filterDefinition)(sessionFromContext(context))
  }

  protected def sessionFromContext(context: Context): Session
}