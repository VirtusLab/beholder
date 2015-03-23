package org.virtuslab.beholder.filters.dsl

import scala.reflect.macros.whitebox
import scala.reflect.macros.whitebox.Context

/**
 * Author: Krzysztof Romanowski
 */
object DSLImpl {
  def create_imp(c: Context)(query: c.Tree)(creation: c.Tree): c.Tree = {
    val extractor = new Extractor(c)
    extractor.implement(
      creation.asInstanceOf[extractor.c.Tree],
      query.asInstanceOf[extractor.c.Tree]
    ).asInstanceOf[c.Tree]
  }

  def unsupportedTreeMessage =
    """This tree is unsupported. Supported shapes:
      | create(query){case (a, b, ... ) => fieldDeclarations }
      | or
      | create(query){(a, b, ...) => fieldDeclarations }
      | where fieldDeclarations:
      | "name" as inText from user.name and
      | ... and
      | "cores" as inTest from machine.cores
    """.stripMargin

  private class Extractor(val c: Context) {

    import c.universe._

    var names: List[Tree] = Nil
    var fields: List[Tree] = Nil
    var columns: List[Tree] = Nil

    private object FieldDefinition {
      def unapply(tree: Tree): Option[(Tree, Tree, Tree, Tree)] = tree match {
        case Apply(Select(Apply(Apply(TypeApply(Select(Apply(rest, List(name)), _), _), List(field)), _), _), List(column)) =>
          Some((rest, name, field, column))
        case _ => None
      }
    }

    def implement(code: c.Tree, query: c.Tree): Tree = {
      code match {
        case Function(List(functionArg), Match(selector, List(CaseDef(pattern, guards, body)))) =>
          implementFilterCreation(body, query) {
            newBody =>
              c.untypecheck(Function(List(functionArg), Match(selector, List(CaseDef(pattern, guards, newBody)))))
          }
        case Function(args, body) =>
          implementFilterCreation(body, query) {
            newBody => Function(args, newBody)
          }
        case _ =>
          c.abort(c.enclosingPosition, unsupportedTreeMessage)
      }
    }

    def implementFilterCreation(body: Tree, query: Tree)(funcCreation: Tree => Tree): Tree = {
      newField(body)

      val mappedQuery = {
        val tupleType = c.parse("scala.Tuple" + columns.size)
        val queryMappingFunction = funcCreation(q"$tupleType(..$columns)")
        q"$query.map($queryMappingFunction)"
      }
      val createFun = q"org.virtuslab.beholder.filters.dsl.FilterFactory.crate"

      val tree = Apply(createFun, List(mappedQuery, seq(fields), seq(names)))
      tree
    }

    private def newField(t: Tree): Unit = t match {
      case FieldDefinition(rest, name, field, column) =>
        names = name :: names
        fields = field :: fields
        columns = column :: columns
        rest match {
          case q"org.virtuslab.beholder.filters.dsl.DSL.EmptyName" =>
          case Select(nextLevel, _) =>
            newField(nextLevel)
          case _ =>
            c.error(t.pos, unsupportedTreeMessage)
        }
      case tree =>
        c.error(t.pos, unsupportedTreeMessage)
    }

    def seq(args: List[Tree]) = q"Seq(..$args)"
  }
}
