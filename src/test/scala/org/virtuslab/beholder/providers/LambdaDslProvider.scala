package org.virtuslab.beholder.providers

import org.virtuslab.beholder.filters.json.JsonFilterFields
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.beholder.suites.BaseSuiteData
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

/**
 * Author: Krzysztof Romanowski
 */
trait LambdaDslProvider {
  self: BaseSuiteData =>

  import org.virtuslab.beholder.filters.dsl.JsonDSL._

  def dslFilter(data: FilterSetupData) =
    create(usersMachinesQuery) {
      e =>
        "email" from e._1.email as inText and
          "system" from e._2.system as inText and
          "cores" from e._2.cores as inIntField and
          "created" from e._2.created as inRange(inField("date")) and
          "capacity" from e._2.capacity as JsonFilterFields.ignore
    }

}
