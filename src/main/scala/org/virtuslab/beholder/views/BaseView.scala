package org.virtuslab.beholder.views


import scala.language.existentials
import org.virtuslab.unicorn.ids.BaseTable
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.Config.driver.DDL
import org.virtuslab.beholder.utils.QueryUtils
import scala.slick.lifted.{TableQuery, Tag}


/**
 *
 * @param viewName name of view
 * @tparam I entity id - not in a sence of lemma id cos there is no constraints on type
 * @tparam A entity
 */
abstract class BaseView[I, A](tag: Tag, val viewName: String) extends BaseTable[A](tag, viewName) {

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
  def id: Column[I]

  /**
   * query that build this view
   * @return
   */
  def query: Query[_, A, Seq]

}

object BaseView {


  implicit class WithViewDDL(val query: TableQuery[_ <: BaseView[_, _]]) extends AnyVal {
    def viewDDL = ViewDDL(query.asInstanceOf[TableQuery[_ <: BaseView[Any, Any]]].shaped.value)
  }

  case class ViewDDL(table: BaseView[Any, Any]) extends DDL {
    protected def createPhase1: Iterable[String] = {
      val viewName = table.viewName
      val fields = table.columns.keys.map(name => '"' + name + '"').mkString(", ")
      val query = QueryUtils.selectStatements(table.query)

      s"create view $viewName ($fields) \n\t as $query" :: Nil
    }

    protected def createPhase2: Iterable[String] = Nil

    protected def dropPhase1: Iterable[String] = s"DROP VIEW ${table.viewName};" :: Nil

    protected def dropPhase2: Iterable[String] = Nil
  }

}