package org.virtuslab.beholder.json

import org.virtuslab.beholder.filters.FilterDefinition
import org.virtuslab.beholder._
import play.api.libs.json._

import scala.concurrent.ExecutionContext.Implicits.global

class JsonFormatterTest
  extends BaseTest {

  it should "create filter definition from json defining data field" in { implicit f =>
    import f.userMachinesViewRepository
    rollbackActionWithModel {
      for {
        filter <- userMachinesViewRepository.createFilter(identity)
      } yield {
        val req = JsObject(Seq("data" -> JsObject(Seq("email" -> JsString("ala")))))
        val data = FilterDefinition(None, None, None, Seq(Some("ala"), None, None, None, None, None))
        filter.formatter.filterDefinition(req) shouldEqual JsSuccess(data)
      }
    }
  }

  it should "create json definition correctly" in { implicit f =>
    import f.userMachinesViewRepository
    rollbackActionWithModel {
      for {
        filter <- userMachinesViewRepository.createFilter(name => s"Label: $name")
      } yield {

        val definition = filter.formatter.jsonDefinition

        def stringValue(on: JsObject, name: String) = (on \ name).get match {
          case JsString(value) => value
          case _ => fail(s"Field $name fro $on is not string!")
        }

        definition match {
          case JsArray(values) =>
            values.foreach {
              case v: JsObject =>
                s"Label: ${stringValue(v, "key")}" shouldEqual stringValue(v, "label")
              case _ => fail("definition must contains objects")
            }
          case _ => fail("definition must be a array")
        }
      }
    }
  }
}
