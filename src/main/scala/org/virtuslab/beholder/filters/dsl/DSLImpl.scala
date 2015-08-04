package org.virtuslab.beholder.filters.dsl

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

  val unableToCreateFilterImplementation =
    "We cannot create filter implementation due to above errors"

  private class Extractor(val c: Context) {

    import c.universe._

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
          c.abort(code.pos, unsupportedTreeMessage)
      }
    }

    private case class FilterElements(names: List[Tree], fields: List[Tree], columns: List[Tree])

    private val EmptyFilter = FilterElements(Nil, Nil, Nil)

    private object From {
      def unapply(tree: Tree): Option[(Tree, Tree)] = tree match {
        case Apply(Apply(TypeApply(Select(rest, _), _), List(column)), _) =>
          Some(rest -> column)
        case _ => None
      }
    }

    private object As {
      def unapply(tree: Tree): Option[(Tree, Tree)] = tree match {
        case Apply(TypeApply(Select(rest, _), _), List(field)) =>
          Some(rest -> field)
        case _ => None
      }
    }

    private object Named {
      def unapply(tree: Tree): Option[(Tree, Tree)] = tree match {
        case Apply(NamedProvider(rest), List(name)) =>
          Some(rest -> name)
        case _ => None
      }
    }

    private object NamedProvider {
      def unapply(tree: Tree): Option[Tree] = tree match {
        case Select(rest, TermName("and")) => Some(rest)
        case Select(rest, TermName("string2EmptyName")) =>
          //TODO validate if rest is stable
          Some(EmptyTree)
        case _ => None
      }
    }

    object Starter

    private def filterElements(t: Tree, elements: FilterElements): Option[FilterElements] = t match {
      case rest Named name From column As field =>
        val newElements = FilterElements(name :: elements.names, field :: elements.fields, column :: elements.columns)
        filterElements(rest, newElements)
      case EmptyTree => Some(elements)
      case tree =>
        c.error(t.pos, unsupportedTreeMessage)
        None
    }

    private def seq(args: List[Tree]) = q"Seq(..$args)"

    private def implementFilterCreation(body: Tree, query: Tree)(funcCreation: Tree => Tree): Tree = {
      filterElements(body, EmptyFilter).map { elements =>
        import elements._
        val mappedQuery = {
          val tupleType = c.parse("scala.Tuple" + columns.size)
          val queryMappingFunction = funcCreation(q"$tupleType(..$columns)")
          q"$query.map($queryMappingFunction)"
        }
        val createFun = Select(c.prefix.tree, TermName("crateFilter"))

        val tree = Apply(createFun, List(mappedQuery, seq(fields), seq(names)))
        tree
      }.getOrElse(c.abort(body.pos, unableToCreateFilterImplementation))
    }
  }

}
