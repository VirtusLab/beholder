package org.virtuslab.beholder.filters.json

import org.virtuslab.beholder.filters.{ FilterAwareConsumer, FilterConsumer, FilterDefinition }
import play.api.libs.json._
import play.api.mvc._
import slick.dbio.DBIO

import scala.concurrent.{ ExecutionContext, Future }

abstract class JsonFilterController[E: Writes](implicit ec: ExecutionContext) extends Controller {

  /** Used for carring errors in futures */
  private case class JsonFilterControllerFailure(result: Result) extends Throwable

  private def badRequest(msg: String) = Future.failed(JsonFilterControllerFailure(BadRequest(msg)))

  protected def consumer: FilterAwareConsumer[E, JsonFilter]

  protected def runQuery[A](from: DBIO[A]): Future[A]

  protected def notJsonBodyMessage = "Expecting json"

  protected def definitionParseErrorMessage(failure: JsError) =
    s"Invalid json for this filter: ${JsError.toFlatForm(failure)}."

  private def parseDefinition(from: JsValue): Future[FilterDefinition] = {
    JsonDefinitionFormatter.formatFor(consumer.filter).reads(from)
      .map(v => Future.apply(v)).recoverTotal {
        case failure => badRequest(definitionParseErrorMessage(failure))
      }
  }

  final def doFilter() = Action.async { request =>

    val json = request.body.asJson match {
      case Some(js) => Future(js)
      case _ => badRequest(notJsonBodyMessage)
    }

    val future = for {
      js <- json
      filterDefinition <- parseDefinition(js)
      actions = consumer.consume(filterDefinition)
      result <- runQuery(actions)
    } yield Ok(ResultWritter.formatResults(consumer.filter)(result, filterDefinition))

    future.recover {
      case JsonFilterControllerFailure(result) => result
    }
  }

  final def filterDefinition() = Action(_ => Ok(consumer.filter.jsonDefinition))
}
