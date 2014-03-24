package org.virtuslab.beholder.views

import scala.slick.driver.BasicQueryTemplate
import play.api.db.slick.Config.driver.simple._
import org.virtuslab.unicorn.ids.BaseTable
import org.virtuslab.beholder.utils
import org.virtuslab.beholder.utils.CodeGenerationUtils._
import scala.slick.lifted.Column

/**
 * @author krzysiek
 */
object FilterableViews extends App with FilterableViewsGenerateCode {

  import language.postfixOps

  /**
   * generate code for [db.FilterableViewsGenerateCode]
   * @return
   */
  def generate = {
    (3 to 18).map {
      implicit nr =>
        import utils.CodeGenerationUtils._

        val columns = fill(nr => s"\n(String, Column[A$nr])")(nr)

        val finalTuple = fill("name" +)
        val matchParameters = fill(nr => s"(name$nr, c$nr)")
        val mapping = fill("c" +, " ~ ")
        val columnsMap = fill(nr => s" columnNames(${nr - 1}) -> (_.c$nr)", ",\n")
        val columnsFunctions = fill(nr => s"def c$nr = column[A$nr](columnNames(${nr - 1}))", "\n")

        s"""def createView[T, E, $aTypesWithTypeMappers](name: String,
          |                              apply: ($aTypes) => T,
          |                              unapply: T => Option[($aTypes)],
          |                              baseQuery: Query[E, _])
          |                             (mappings: E => ($columns)):
          | BaseView$nr[T, $aTypes] = {
          |
          |    var columnsNames = Seq[String]()
          |
          |    val preparedQuery: BasicQueryTemplate[_, T] = {
          |      val mappedQuery = baseQuery.map {
          |        t =>
          |          mappings(t) match {
          |            case ($matchParameters) =>
          |              columnsNames = Seq($finalTuple)
          |              $mapping <>(apply, unapply)
          |          }
          |      }
          |
          |      for {
          |        u <- Parameters[Unit]
          |        a <- mappedQuery
          |      } yield a
          |    }
          |    new BaseView$nr[T, $aTypes](name, columnsNames, apply, unapply, preparedQuery)
          |}
          |
          |
          |class BaseView$nr[T, $aTypesWithTypeMappers](name: String,
          |                        val columnNames: Seq[String],
          |                        apply: ($aTypes) => T,
          |                        unapply: T => Option[($aTypes)],
          |                        val query: BasicQueryTemplate[_, T])
          |                            extends BaseView[A1, T](name) {
          |     $columnsFunctions
          |
          |     override def id = c1
          |
          |     override protected val columns: Map[String, this.type => Column[_]] = Map(
          |         $columnsMap)
          |     def * = $mapping <> (apply, unapply)
          |}""".stripMargin

    }
  }

  /**
   * create view with 2 fields
   * @param name db name of view
   * @param apply from db columns to entity
   * @param unapply from entity to database columns
   * @param baseQuery query for create view - it should returns E
   * @param mappings map E to columns that suits apply function
   * @tparam T entity
   * @tparam E value returns form query (in sence of columns and tables not entities) - usually tuple with tables
   * @tparam A first field
   * @tparam B sec field
   * @return table for this view
   */
  def createView[T, E, A: TypeMapper, B: TypeMapper](name: String,
                                                     apply: (A, B) => T,
                                                     unapply: T => Option[(A, B)],
                                                     baseQuery: Query[E, _])(mappings: E => ((String, Column[A]), (String, Column[B]))): BaseView2[T, A, B] = {

    var columnsNames = Seq[String]()

    val preparedQuery: BasicQueryTemplate[_, T] = {
      val mappedQuery = baseQuery.map {
        t =>
          mappings(t) match {
            case ((name1, c1), (name2, c2)) =>
              columnsNames = Seq(name1, name2)
              c1 ~ c2 <>(apply, unapply)
          }
      }

      for {
        u <- Parameters[Unit]
        a <- mappedQuery
      } yield a
    }

    new BaseView2[T, A, B](name, columnsNames, apply, unapply, preparedQuery)
  }

  /**
   * Base view for view with 2 fields
   * @param name name of view
   * @param columnNames names of view columns - columnsNames(0) -> c1 etc
   * @param apply to create entity
   * @param unapply to map entity to tuple
   * @param query query that build view
   * @tparam T entity
   * @tparam A first field
   * @tparam B sec field
   */
  class BaseView2[T, A: TypeMapper, B: TypeMapper](name: String,
                                                   val columnNames: Seq[String],
                                                   apply: (A, B) => T,
                                                   unapply: T => Option[(A, B)],
                                                   val query: BasicQueryTemplate[_, T]) extends BaseView[A, T](name) {
    def c1 = column[A](columnNames(0))

    def c2 = column[B](columnNames(1))

    override def id = c1

    override protected val columns: Map[String, this.type => Column[_]] = Map(
      columnNames(0) -> (_.c1),
      columnNames(1) -> (_.c2))

    def * = c1 ~ c2 <>(apply, unapply)
  }

  //for code genration
  println(generate.mkString("\n\n"))
}