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

  trait FilterControllerBase[Context, Entity <: Product] extends BaseController {
    private[beholder] def formatter: JsonFormatter[Entity]

    private[beholder] def callFilter(context: Context, filterDefinition: FilterDefinition): DBIO[FilterResult[Entity]]

    implicit def executionContext: ExecutionContext

    protected def inFilterContext(body: Request[AnyContent] => Context => DBIO[JsResult[JsValue]]): EssentialAction

    final def filterDefinition = inFilterContext { request => context => DBIO.successful(JsSuccess(jsonDefinition)) }

    final def jsonDefinition = formatter.jsonDefinition

    final def doFilter: EssentialAction = inFilterContext { request => context =>
      deserialize(request.body, context) match {
        case err: JsError => DBIO.successful(err)
        case JsSuccess(definition, path) => filterAndModifyResult(definition, context).map(formatter.results(definition, _)).map(JsSuccess(_))
      }
    }

    final def doFilterWithAction(action: FilterResult[Entity] => JsPath => DBIO[JsResult[JsValue]]): EssentialAction = inFilterContext { request => context =>
      deserialize(request.body, context) match {
        case err: JsError => DBIO.successful(err)
        case JsSuccess(definition, path) => callFilter(context, definition).flatMap(result => action(result)(path))
      }
    }

    final def filterAndModifyResult(definition: FilterDefinition, context: Context): DBIO[FilterResult[Entity]] = {
      callFilter(context, definition).map(modifyFilterResults(_, definition, context))
    }

    private def deserialize(filterDefinitionContent: AnyContent, context: Context): JsResult[FilterDefinition] = {
      filterDefinitionContent.asJson.map(formatter.filterDefinition)
        .getOrElse(JsError("json expected"))
        .map(mapFilterData(_, context))
    }

    //for filter modification such us setting default parameters etc.
    protected def mapFilterData(data: FilterDefinition, context: Context): FilterDefinition = data

    //for result modification such as sorting or fetching additional data
    protected def modifyFilterResults(results: FilterResult[Entity], filterDefinition: FilterDefinition, context: Context): FilterResult[Entity] = results
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
