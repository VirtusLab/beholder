package org.virtuslab.beholder.utils

import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.Config.driver.QueryExecutor



/*
/**
 * helper for create queries
 * @author krzysiek
 */
case class QueryUtils[A, T <: Table[A]](table: T) {

  /**
   * create query on given field
   * use: val byNameQuery = helper.byFieldQuery(_.name)
   */
  final def byFieldQuery[F](columnFun: T => Column[F])(implicit mapper: BaseTypeMapper[F]) =
    for {
      f <- Parameters[F]
      en <- table if columnFun(en) === f
    } yield en

}
*/

object QueryUtils {
  /**
   * util to print select query sql
   * @param query
   * @return
   */
  def selectStatements(query: Query[Any, Any, Seq]): String =    {
    val exec: QueryExecutor[Seq[Any]] = queryToQueryExecutor(query)
    exec.selectStatement
  }

  //new UnshapedQueryExecutorDef(query).selectStatement

}