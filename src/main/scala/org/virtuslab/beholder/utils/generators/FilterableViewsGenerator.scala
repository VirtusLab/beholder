package org.virtuslab.beholder.utils.generators

import org.virtuslab.beholder.utils.generators.CodeGenerationUtils._

private[beholder] object FilterableViewsGenerator extends App {

  println(generate.mkString("\n\n"))

  /**
   * generate code for [db.FilterableViewsGenerateCode]
   */
  def generate = (3 to 18).map(generateSingle)

  /** create code for single "create view method" */
  private def generateSingle(nr: Int) = {

    implicit val _nr = nr

    val columns = fill(nr => s"\n    (String, Rep[A$nr])")(nr)
    val justColumns = fill(nr => s"Rep[A$nr]")(nr)

    val finalTuple = fill("name" + _)
    val matchParameters = fill(nr => s"(name$nr, c$nr)")
    val mapping = fill("c" + _)
    val columnsMap = fill(nr => s" columnNames(${nr - 1}) -> (_.c$nr)", ",\n")
    val columnsFunctions = fill(nr => s"    def c$nr = column[A$nr](columnNames(${nr - 1}))", "\n")

    s"""
      |def createView[T: ClassTag, E, $aTypesWithTypedType](name: String,
      |                                                             apply: ($aTypes) => T,
      |                                                             unapply: T => Option[($aTypes)],
      |                                                             baseQuery: Query[E, _, Seq])(
      |mappings: E => ($columns)): TableQuery[BaseView$nr[T, $aTypes]] = {
      |
      |
      |    var columnsNames = Seq[String]()
      |
      |    val preparedQuery: Query[_, T, Seq] = {
      |      val mappedQuery = baseQuery.map {
      |        t =>
      |         mappings(t) match {
      |            case ($matchParameters) =>
      |              columnsNames = Seq($finalTuple)
      |
      |              implicit val shape: Shape[_ <: slick.lifted.FlatShapeLevel,
      |                 ($justColumns),
      |                 ($aTypes), _] = implicitly
      |
      |              ($mapping) <>(apply.tupled, unapply)
      |          }
      |      }
      |
      |      for {
      |        a <- mappedQuery
      |      } yield a
      |    }
      |    TableQuery.apply(tag => new BaseView$nr[T, $aTypes](tag, name, columnsNames, apply, unapply, preparedQuery))
      |
      |  }
      |
      |
      |  class BaseView$nr[T: ClassTag, $aTypesWithTypedType](tag: Tag,
      |                                                           name: String,
      |                                                           val columnNames: Seq[String],
      |                                                           apply: ($aTypes) => T,
      |                                                           unapply: T => Option[($aTypes)],
      |                                                           val query: Query[_, T, Seq]) extends BaseView[T](tag, name) {
      |$columnsFunctions
      |
      |    override def id = c1
      |
      |    override protected val columns: Seq[(String, this.type => Column[_])] = Seq(
      |      $columnsMap)
      |
      |    implicit val shape: Shape[_ <: slick.lifted.FlatShapeLevel,
      |      ($justColumns),
      |      ($aTypes), _] = implicitly
      |
      |    def * = ($mapping) <>(apply.tupled, unapply)
      |  }
    """.stripMargin
  }
}
