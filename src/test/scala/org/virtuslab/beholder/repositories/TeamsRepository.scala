package org.virtuslab.beholder.repositories

import org.virtuslab.beholder.model._
import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

class TeamsRepository extends BaseIdRepository[TeamId, Team, Teams](Teams.query)