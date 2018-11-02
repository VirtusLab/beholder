package org.virtuslab.beholder.repositories

import java.sql.Date

import org.virtuslab.beholder.{ UserMachineViewRow, UserMachinesViewComponent }
import org.virtuslab.beholder.filters.forms.FromFilterFieldsComponent
import org.virtuslab.beholder.filters.json.{ JsonFiltersComponent, JsonFormatterComponent }
import org.virtuslab.beholder.model.MachineStatus
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

import scala.concurrent.ExecutionContext

class UserMachinesViewRepository(val unicorn: UnicornPlay[Long]) extends UserMachinesViewComponent
  with JsonFormatterComponent
  with JsonFiltersComponent
  with FromFilterFieldsComponent
  with UnicornWrapper[Long] {

  import unicorn.profile.api._

  import JsonFilterFields.{
    inText,
    inIntFieldSeq,
    inRange,
    inField,
    inTextSeq
  }

  lazy val tableQuery = viewQuery

  def createView = createUsersMachineView()

  def createFilter(labels: String => String)(implicit ex: ExecutionContext) = {
    createUsersMachineView().map {
      view =>
        new JsonFilters[UserMachineViewRow](labels).create(
          view,
          inText,
          inTextSeq,
          inIntFieldSeq,
          inRange(inField[Date]("date")),
          JsonFilterFields.ignore[Option[BigDecimal]],
          JsonFilterFields.ignore[MachineStatus.Value])
    }
  }
}
