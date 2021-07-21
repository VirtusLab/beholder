package org.virtuslab.beholder.utils.generators

import org.virtuslab.beholder.utils.generators.CodeGenerationUtils._

private[beholder] object FilterableViewsGenerator extends App {

  println(generate.mkString("\n\n"))

  /**
   * generate code for [db.FilterableViewsGenerateCode]
   */
  def generate = (2 to 22).map(generateForCaseClass) ++ (23 to 50).map(generateForHList)

  /** create code for single "create view method" */
  private def generateForCaseClass(nr: Int) = {

    implicit val _nr = nr

    val columns = fill(nr => s"\n    (String, Rep[A$nr])")(nr)

    val finalTuple = fill("name" + _)
    val matchParameters = fill(nr => s"(name$nr, c$nr)")
    val mapping = fill("c" + _)

    val sNames = fill("s" + _)
    val shapes = fill(nr => s"s$nr: Shape[_<: ShapeLevel, Rep[A$nr], A$nr, _]")
    val reps = fill(nr => s"Rep[A$nr]")

    val columnsMap = fill(nr => s" columnNames(${nr - 1}) -> (_.c$nr)", ",\n")
    val columnsFunctions = fill(nr => s"    def c$nr = column[A$nr](columnNames(${nr - 1}))", "\n")

    s"""
      |def createView[T: ClassTag, E, $aTypesWithTypedType](name: String,
      |                                                             apply: ($aTypes) => T,
      |                                                             unapply: T => Option[($aTypes)],
      |                                                             baseQuery: Query[E, _, Seq])(
      |mappings: E => ($columns))(implicit $shapes): TableQuery[BaseView$nr[T, $aTypes]] = {
      |
      |
      |    var columnsNames = Seq[String]()
      |
      |    val preparedQuery: Query[_, T, Seq] = {
      |      baseQuery.map {
      |        t =>
      |         mappings(t) match {
      |            case ($matchParameters) =>
      |              columnsNames = Seq($finalTuple)
      |
      |              implicit val tupleShape = new TupleShape($sNames)
      |                 .asInstanceOf[Shape[_ <: FlatShapeLevel, ($reps), ($aTypes), _]]
      |
      |              ($mapping) <>(apply.tupled, unapply)
      |          }
      |      }
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
      |                                                           val query: Query[_, T, Seq])(implicit $shapes) extends BaseView[A1, T](tag, name) {
      |$columnsFunctions
      |
      |    override def id = c1
      |
      |    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
      |      $columnsMap)
      |
      |    implicit val tupleShape = new TupleShape($sNames)
      |       .asInstanceOf[Shape[_ <: FlatShapeLevel, ($reps), ($aTypes), _]]
      |
      |    def * = ($mapping) <> (apply.tupled, unapply)
      |  }
    """.stripMargin
  }

  private def generateForHList(nr: Int) = {

    implicit val _nr = nr

    val columns = fill(nr => s"\n    (String, Rep[A$nr])", " :: ")(nr) + " :: HNil"

    val finalTuple = fill("name" + _)
    val matchParameters = fill(nr => s"(name$nr, c$nr)", " :: ") + " :: HNil"
    val mapping = fill("c" + _, " :: ") + " :: HNil"

    val shapes = fill(nr => s"s$nr: Shape[_<: ShapeLevel, Rep[A$nr], A$nr, _]")

    val columnsMap = fill(nr => s" columnNames(${nr - 1}) -> (_.c$nr)", ",\n")
    val columnsFunctions = fill(nr => s"    def c$nr = column[A$nr](columnNames(${nr - 1}))", "\n")

    s"""
       |def createView[T: ClassTag, E, $aTypesWithTypedType](name: String,
       |                                                             generic: Aux[T, ${aTypes(_nr, " :: ")} :: HNil],
       |                                                             baseQuery: Query[E, _, Seq])(
       |mappings: E => ($columns))(implicit $shapes): TableQuery[BaseView$nr[T, $aTypes]] = {
       |
       |
       |    var columnsNames = Seq[String]()
       |    val apply = generic.from _
       |    val unapply = generic.to _ andThen (Some(_))
       |
       |    val preparedQuery: Query[_, T, Seq] = {
       |      baseQuery.map {
       |        t =>
       |         mappings(t) match {
       |            case ($matchParameters) =>
       |              columnsNames = Seq($finalTuple)
       |
       |              ($mapping) <> (apply, unapply)
       |          }
       |      }
       |    }
       |    TableQuery.apply(tag => new BaseView$nr[T, $aTypes](tag, name, columnsNames, apply, unapply, preparedQuery))
       |
       |  }
       |
       |
       |  class BaseView$nr[T: ClassTag, $aTypesWithTypedType](tag: Tag,
       |                                                           name: String,
       |                                                           val columnNames: Seq[String],
       |                                                           apply: (${aTypes(_nr, ":: ")} :: HNil) => T,
       |                                                           unapply: T => Option[(${aTypes(_nr, ":: ")} :: HNil)],
       |                                                           val query: Query[_, T, Seq])(implicit $shapes) extends BaseView[A1, T](tag, name) {
       |$columnsFunctions
       |
       |    override def id = c1
       |
       |    override protected val columns: Seq[(String, this.type => Rep[_])] = Seq(
       |      $columnsMap)
       |
       |    def * = ($mapping) <> (apply, unapply)
       |  }
    """.stripMargin
  }
}
