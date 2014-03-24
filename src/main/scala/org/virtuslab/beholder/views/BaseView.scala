package org.virtuslab.beholder.views

import scala.slick.lifted._
import scala.slick.driver.BasicQueryTemplate
import scala.language.existentials
import org.virtuslab.unicorn.ids.BaseTable

case class ViewDDL(table: BaseView[_, _]) extends DDL {
  protected def createPhase1: Iterable[String] =
    s"""create view ${table.tableName} (${
      table.create_*.map(c => '"' + c.name + '"').mkString(", ")
    }) \n\t as ${
      table.query.selectStatement
    };""".stripMargin :: Nil

  protected def createPhase2: Iterable[String] = Nil

  protected def dropPhase1: Iterable[String] = s"DROP VIEW ${table.tableName};" :: Nil

  protected def dropPhase2: Iterable[String] = Nil
}

/**
 *
 * @param viewName name of view
 * @tparam I entity id - not in a sence of lemma id cos there is no constraints on type
 * @tparam A entity
 */
abstract class BaseView[I, A](viewName: String) extends BaseTable[A](viewName) {

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
  def id: Column[I]

  /**
   * query that build this view
   * @return
   */
  def query: BasicQueryTemplate[_, A]

  /**
   * modified ddl for view
   * @return
   */
  override def ddl: DDL = ViewDDL(this)
}
