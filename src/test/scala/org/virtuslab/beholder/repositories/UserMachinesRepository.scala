package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model.UserMachinesComponent
import org.virtuslab.unicorn.{ UnicornPlay, UnicornWrapper }

class UserMachinesRepository(val unicorn: UnicornPlay[Long]) extends UserMachinesComponent with UnicornWrapper[Long] {
  lazy val tableQuery = userMachinesTableQuery
}
