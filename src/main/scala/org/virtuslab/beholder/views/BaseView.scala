package org.virtuslab.beholder.views

import org.virtuslab.unicorn.ids.BaseTable
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.Config.driver.DDL
import play.api.db.slick.Config.driver.QueryExecutor
import scala.slick.lifted.{ TableQuery, Tag }

import scala.language.existentials

/**
 *
 * @param viewName name of view
 * @tparam Id entity id type
 * @tparam Entity entity type
 */
abstract class BaseView[Id, Entity](tag: Tag, val viewName: String) extends BaseTable[Entity](tag, viewName) {

  /**
   *
   */
  protected val columns: Map[String, this.type => Column[_]]

  /**
   * find column by name
   * @param name
   * @return
   */
  def columnByName[A](name: String): Column[_] =
    columns(name).apply(this)

  /**
   * column that is tread as view 'id' - it is use eg. for default sort
   * @return
   */
  def id: Column[Id]

  /**
   * query that build this view
   * @return
   */
  def query: Query[_, Entity, Seq]

}

object BaseView {

  implicit class WithViewDDL(val query: TableQuery[_ <: BaseView[_, _]]) extends AnyVal {
    def viewDDL = ViewDDL(query.shaped.value)
  }

  case class ViewDDL(table: BaseView[_, _]) extends DDL {
    protected def createPhase1: Iterable[String] = {
      val viewName = table.viewName
      val fields = table.columns.keys.map(name => '"' + name + '"').mkString(", ")
      val query = selectStatements(table.query)

      s"CREATE VIEW $viewName ($fields) \n\t AS $query" :: Nil
    }

    protected def createPhase2: Iterable[String] = Nil

    protected def dropPhase1: Iterable[String] = s"DROP VIEW ${table.viewName};" :: Nil

    protected def dropPhase2: Iterable[String] = Nil

    /**
     * util to print select query sql
     * @param query
     * @return
     */
    private def selectStatements(query: Query[_, _, Seq]): String = {
      val castedQuery = query.asInstanceOf[Query[Any, Any, Seq]]
      val exec: QueryExecutor[Seq[Any]] = queryToQueryExecutor(castedQuery)
      exec.selectStatement
    }
  }

}