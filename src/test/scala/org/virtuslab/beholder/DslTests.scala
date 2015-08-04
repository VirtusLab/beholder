package org.virtuslab.beholder

import java.sql.Date

import org.virtuslab.beholder.filters.dsl.FilterFactory
import org.virtuslab.beholder.filters.json.{ JsonFormatter, JsonFilterFields }
import org.virtuslab.beholder.filters.{ FilterAPI, FilterDefinition }
import org.virtuslab.beholder.providers.{ LambdaDslProvider, PartialFunctionDslProvider }
import org.virtuslab.beholder.suites.{ BaseSuiteData, BaseSuite, FiltersTestSuite }
import org.virtuslab.beholder.filters.json.JsonFilterFields._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

abstract class DslTest extends AppTest with FiltersTestSuite[Unit] {
  override def doFilters(data: BaseFilterData, currentFilter: FilterDefinition): Seq[UserMachineViewRow] = {
    import data._
    filter.filter(currentFilter)
  }
}

trait PartialFunctionDslTest extends DslTest with PartialFunctionDslProvider {
  override def createFilter(data: FilterSetupData): FilterAPI[UserMachineViewRow, Unit] =
    dslFilter(data).mapped(UserMachineViewRow.tupled)
}

trait PartialFunctionDslJsonTest extends JsonFiltersTestsBase with PartialFunctionDslProvider {

  import org.virtuslab.beholder.filters.dsl.JsonDSL._

  override def createFilter(data: FilterSetupData) =
    dslFilter(data).asJson(UserMachineViewRow.tupled)
}

class LambdaDslTests extends DslTest with LambdaDslProvider {
  override def createFilter(data: FilterSetupData): FilterAPI[UserMachineViewRow, Unit] = {
    dslFilter(data).mapped(UserMachineViewRow.tupled)
  }

}

class FilterFactoryTests extends DslTest {
  def createFilter(data: FilterSetupData): FilterAPI[UserMachineViewRow, Unit] = {

    val q = usersMachinesQuery.map {
      case (user, machine) =>
        (user.email, machine.system, machine.cores, machine.created, machine.capacity)
    }

    val names = Seq(
      "email",
      "system",
      "cores",
      "created",
      "capacity"
    )

    val fields = Seq(
      inText,
      inText,
      inIntField,
      inRange(inField[Date]("date")),
      JsonFilterFields.ignore[Option[BigDecimal]]
    )

    FilterFactory.crate(q, fields, names).mapped(UserMachineViewRow.tupled)
  }
}
