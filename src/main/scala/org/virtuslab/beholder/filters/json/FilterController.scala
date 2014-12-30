package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ FilterDefinition, FilterAPI }
import play.api.mvc._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple.Session
import play.api.libs.json.JsValue

/**
 * Author: Krzysztof Romanowski
 */
abstract class FilterController[Entity <: Product](filter: FilterAPI[Entity, JsonFormatter[Entity]]) extends Controller {

  def inSession[T](body: Request[AnyContent] => Session => Option[JsValue]): Action[T]

  final def filterDefinition = inSession { request =>
    _ =>
      Option(filter.formatter.jsonDefinition)
  }

  //for filter modification such us setting default parameters etc.
  protected def mapFilterData(data: FilterDefinition) = data

  final def doFilter =
    inSession {
      request =>
        implicit session =>
          for {
            json <- request.body.asJson
            filterDefinition <- filter.formatter.filterDefinition(json)
            data = filter.filter(mapFilterData(filterDefinition))
          } yield filter.formatter.results(filterDefinition, data)
    }
}
