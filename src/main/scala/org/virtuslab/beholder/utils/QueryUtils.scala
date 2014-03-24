package org.virtuslab.beholder.utils

import play.api.db.slick.Config.driver.simple._
import scala.slick.lifted.BaseTypeMapper
import scala.slick.driver.BasicQueryTemplate

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

object QueryUtils {
  /**
   * util to print select query sql
   * @param query
   * @tparam A
   * @tparam B
   * @return
   */
  def selectStatements[A, B](query: Query[A, B]): String = Parameters[Unit].flatMap(_ => query).selectStatement

  /**
   * util to print select query sql
   * @param query
   * @tparam A
   * @tparam B
   * @return
   */
  def selectStatements[A, B](query: BasicQueryTemplate[A, B]): String = query.selectStatement
}