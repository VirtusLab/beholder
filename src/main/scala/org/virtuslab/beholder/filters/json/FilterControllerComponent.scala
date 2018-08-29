package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ BaseFilterComponent, FilterDefinition }
import org.virtuslab.unicorn.UnicornWrapper
import play.api.libs.json._
import play.api.mvc._

import scala.concurrent.ExecutionContext

case class NoContext()

trait FilterControllerComponent extends BaseFilterComponent with JsonFormatterComponent {
  self: UnicornWrapper[Long] =>

  import unicorn.profile.api._

  trait FilterControllerBase[Context, Entity <: Product] extends Controller {
    private[beholder] def formatter: JsonFormatter[Entity]

    private[beholder] def callFilter(context: Context, filterDefinition: FilterDefinition): DBIO[FilterResult[Entity]]

    implicit def executionContext: ExecutionContext

    protected def inFilterContext(body: Request[AnyContent] => Context => DBIO[JsResult[JsValue]]): EssentialAction

    final def filterDefinition = inFilterContext { request => context => DBIO.successful(JsSuccess(formatter.jsonDefinition)) }

    final def doFilter: EssentialAction =
      inFilterContext {
        request =>
          context =>
            request.body.asJson.map(formatter.filterDefinition).map {
              case JsSuccess(filterDefinition, path) =>
                val filterResultAction = callFilter(context, mapFilterData(filterDefinition, context))
                filterResultAction.map {
                  filterResult =>
                    val formatResults = formatter.results(filterDefinition, modifyFilterResults(filterResult, filterDefinition, context))
                    JsSuccess(formatResults, path)
                }

              case other =>
                DBIO.successful(JsError("json expected"))
            }.getOrElse(DBIO.successful(JsError("json expected")))
      }

    //for filter modification such us setting default parameters etc.
    protected def mapFilterData(data: FilterDefinition, context: Context) = data

    //for result modification such as sorting or fetching additional data
    protected def modifyFilterResults(results: FilterResult[Entity], filterDefinition: FilterDefinition, context: Context) = results
  }

  abstract class FilterController[Entity <: Product](filter: FilterAPI[Entity, JsonFormatter[Entity]])
      extends FilterControllerBase[NoContext, Entity] {

    override protected def inFilterContext(body: (Request[AnyContent]) => NoContext => DBIO[JsResult[JsValue]]): EssentialAction

    override final private[beholder] def callFilter(context: NoContext, filterDefinition: FilterDefinition): DBIO[FilterResult[Entity]] =
      filter.filterWithTotalEntitiesNumber(filterDefinition)

    override final private[beholder] def formatter: JsonFormatter[Entity] = filter.formatter
  }

  abstract class ContextFilterController[Context, Entity <: Product](contextedFilter: ContextedFilterAPI[Context, Entity, JsonFormatter[Entity]])
      extends FilterControllerBase[Context, Entity] {
    override private[beholder] final def formatter: JsonFormatter[Entity] = contextedFilter.filterFormatter

    override private[beholder] final def callFilter(context: Context, filterDefinition: FilterDefinition): DBIO[FilterResult[Entity]] = {
      contextedFilter.apply(context).filterWithTotalEntitiesNumber(filterDefinition)
    }

  }
}
