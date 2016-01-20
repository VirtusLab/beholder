package org.virtuslab.beholder.views

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.DDL
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

import scala.language.existentials
import scala.slick.lifted.{ TableQuery, Tag }

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
  protected val columns: Seq[(String, this.type => Column[_])]
  private lazy val columnsMap: Map[String, this.type => Column[_]] = columns.toMap

  final def columnsNames = columns.map(_._1)

  /**
   * find column by name
   */
  def columnByName[A](name: String): Column[_] =
    columnsMap(name).apply(this)

  /**
   * column that is tread as view 'id' - it is use eg. for default sort
   */
  def id: Column[Id]

  /**
   * query that build this view
   */
  def query: Query[_, Entity, Seq]

}

object BaseView {

  implicit class WithViewDDL(val query: TableQuery[_ <: BaseView[_, _]]) extends AnyVal {
    def viewDDL = ViewDDL(query.baseTableRow)
  }

  case class ViewDDL(table: BaseView[_, _]) extends DDL {
    protected def createPhase1: Iterable[String] = {
      val viewName = table.viewName
      val fields = table.columns.map { case (name, _) => '"' + name + '"' }.mkString(", ")
      val query = selectStatements(table.query)

      s"CREATE VIEW $viewName ($fields) \n\t AS $query" :: Nil
    }

    protected def createPhase2: Iterable[String] = Nil

    protected def dropPhase1: Iterable[String] = s"DROP VIEW ${table.viewName};" :: Nil

    protected def dropPhase2: Iterable[String] = Nil

    /**
     * util to print select query sql
     */
    private def selectStatements(query: Query[_, _, Seq]): String = query.selectStatement

  }

}