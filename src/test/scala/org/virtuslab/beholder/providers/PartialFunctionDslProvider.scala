package org.virtuslab.beholder.providers

import org.virtuslab.beholder.filters.json.JsonFilterFields
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.suites.BaseSuiteData
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

/**
 * Author: Krzysztof Romanowski
 */
trait PartialFunctionDslProvider {
  self: BaseSuiteData =>

  import org.virtuslab.beholder.filters.dsl.JsonDSL._

  def dslFilter(data: FilterSetupData) =
    create(usersMachinesQuery) {
      case (user, machine) =>
        "email" from user.email as inText and
          "system" from machine.system as inText and
          "cores" from machine.cores as inIntField and
          "created" from machine.created as inRange(inField("date")) and
          "capacity" from machine.capacity as JsonFilterFields.ignore
    }

}