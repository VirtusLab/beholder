package org.virtuslab.beholder.utils

import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.Config.driver.QueryExecutor



object QueryUtils {
  /**
   * util to print select query sql
   * @param query
   * @return
   */
  def selectStatements(query: Query[_, _, Seq]): String =    {
    val castedQuery = query.asInstanceOf[Query[Any, Any, Seq]]
    val exec: QueryExecutor[Seq[Any]] = queryToQueryExecutor(castedQuery)
    exec.selectStatement
  }

}