package org.virtuslab.beholder.views

import org.virtuslab.beholder.utils.QueryUtils
import org.virtuslab.unicorn.ids.BaseTable
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.Config.driver.DDL
import scala.slick.lifted.{TableQuery, Tag}

import scala.language.existentials

/**
 *
 * @param viewName name of view
 * @tparam Id entity id - not in a sence of lemma id cos there is no constraints on type
 * @tparam Entity entity
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
  def columnByName(table: this.type)(name: String): Option[Column[_]] =
    columns.get(name).map(_.apply(table))

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
      val query = QueryUtils.selectStatements(table.query)

      s"CREATE VIEW $viewName ($fields) \n\t AS $query" :: Nil
    }

    protected def createPhase2: Iterable[String] = Nil

    protected def dropPhase1: Iterable[String] = s"DROP VIEW ${table.viewName};" :: Nil

    protected def dropPhase2: Iterable[String] = Nil
  }

}