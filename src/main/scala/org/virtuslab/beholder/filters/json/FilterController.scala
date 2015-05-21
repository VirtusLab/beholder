package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ ContextedFilterAPI, FilterAPI, FilterDefinition, FilterResult }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple.Session
import play.api.libs.json.{ JsSuccess, JsResult, JsError, JsValue }
import play.api.mvc._

trait FilterControllerBase[Context, Entity <: Product] extends Controller {
  private[beholder] def formatter: JsonFormatter[Entity]

  private[beholder] def callFilter(context: Context, filterDefinition: FilterDefinition): FilterResult[Entity]

  protected def inFilterContext(body: Request[AnyContent] => Context => JsResult[JsValue]): EssentialAction

  final def filterDefinition = inFilterContext { request => _ => JsSuccess(formatter.jsonDefinition) }

  final def doFilter: EssentialAction =
    inFilterContext {
      request =>
        context =>
          request.body.asJson.map(formatter.filterDefinition).map { fd =>
            fd.map {
              filterDefinition =>
                val filterResult = callFilter(context, mapFilterData(filterDefinition))
                formatter.results(filterDefinition, filterResult)
            }
          }.getOrElse(JsError("json expected"))
    }

  //for filter modification such us setting default parameters etc.
  protected def mapFilterData(data: FilterDefinition) = data
}

abstract class FilterController[Entity <: Product](filter: FilterAPI[Entity, JsonFormatter[Entity]])
    extends FilterControllerBase[Session, Entity] {

  protected def inSession(body: Request[AnyContent] => Session => JsResult[JsValue]): EssentialAction

  override protected def inFilterContext(body: (Request[AnyContent]) => (Session) => JsResult[JsValue]): EssentialAction =
    inSession(body)

  override final private[beholder] def callFilter(session: Session, filterDefinition: FilterDefinition): FilterResult[Entity] =
    filter.filterWithTotalEntitiesNumber(filterDefinition)(session)

  override final private[beholder] def formatter: JsonFormatter[Entity] = filter.formatter
}

abstract class ContextFilterController[Context, Entity <: Product](contextedFilter: ContextedFilterAPI[Context, Entity, JsonFormatter[Entity]])
    extends FilterControllerBase[Context, Entity] {
  override private[beholder] final def formatter: JsonFormatter[Entity] = contextedFilter.filterFormatter

  override private[beholder] final def callFilter(context: Context, filterDefinition: FilterDefinition): FilterResult[Entity] = {
    contextedFilter.apply(context).filterWithTotalEntitiesNumber(filterDefinition)(sessionFromContext(context))
  }

  protected def sessionFromContext(context: Context): Session
}