package org.virtuslab.beholder.views

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.DDL
import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

import scala.language.existentials
import slick.lifted.{ TableQuery, Tag }

//TODO #33 move to 2.0 spirit
abstract class BaseView[Entity](tag: Tag, val viewName: String) extends BaseTable[Entity](tag, viewName) {

  /**
   *
   */
  protected val columns: Seq[(String, this.type => Rep[_])]
  private lazy val columnsMap: Map[String, this.type => Rep[_]] = columns.toMap

  final def columnsNames = columns.map(_._1)

  /**
   * find column by name
   */
  def columnByName(name: String): Rep[_] =
    columnsMap(name).apply(this)

  def typedColumnByName[T](name: String): Rep[T] =
    columnsMap(name).apply(this).asInstanceOf[Rep[T]]

  /**
   * column that is tread as view 'id' - it is use eg. for default sort
   */
  def id: Rep[_]

  /**
   * query that build this view
   */
  def query: Query[_, Entity, Seq]

}

object BaseView {

  implicit class WithViewDDL(val query: TableQuery[_ <: BaseView[_]]) extends AnyVal {
    def viewDDL = ViewDDL(query.shaped.value)
  }

  case class ViewDDL(table: BaseView[_]) extends DDL {
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
    private def selectStatements(query: Query[_, _, Seq]): String = query.result.statements.mkString

  }

}