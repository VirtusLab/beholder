package org.virtuslab.beholder.filters.dsl

import org.virtuslab.beholder.filters._
import org.virtuslab.unicorn.LongUnicornPlay
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import scala.language.higherKinds
import scala.reflect.macros.whitebox.Context
import scala.language.experimental.macros

/**
 * Created by krzysiek on 26.02.15.
 */
object DSL {

  implicit class Named(name: String) {
    def as[A, B](field: MappedFilterField[A, B]): NamedField[A] = ???
  }

  class NamedField[A] {
    def from(c: Column[A]): NamedFieldColumn = ???
  }

  class NamedFieldColumn {
    def and(name: String): Named = ???
  }

  def create[T, L, FT, E](q: Query[T, L, Seq])(creation: T => NamedFieldColumn): MappableFilterAPI[E, Unit, FT] = macro Implementer.create_imp

}

object Implementer {
  def create_imp(c: Context)(q: c.Tree)(creation: c.Tree): c.Tree = {
    val e = Extractor(c)
    e.implement(creation.asInstanceOf[e.c.Tree], q.asInstanceOf[e.c.Tree]).asInstanceOf[c.Tree]
  }

  case class Extractor(c: Context) {

    import c.universe._

    def implement(code: Tree, queryCode: Tree): Tree = {
      code match {
        case Function(fA, Match(mA, List(CaseDef(pat, guards, body)))) =>
          val a = q"a.map{ case (x, y) => y}"
          def f(b: Tree) = {
            val fun = Function(fA, Match(mA, List(CaseDef(pat, guards, b))))
            fun
          }
          transform(f, body, queryCode)
        //Function(fA, Match(mA, List(CaseDef(pat, guards, body))))

        case Function(vals, body) =>
          transform(body => Function(vals, body), body, queryCode)
        case _ =>
          c.abort(c.enclosingPosition, "unsupported tree shape")
      }

    }

    def transform(funcCreation: Tree => Tree, body: Tree, query: Tree): Tree = {
      var names: List[Tree] = Nil
      var fields: List[Tree] = Nil
      var columns: List[Tree] = Nil

      def pop(t: Tree): Unit = t match {
        case Apply(Select(Apply(TypeApply(Select(Apply(rest, List(name)), _), _), List(field)), _), List(column)) =>
          names = name :: names
          fields = field :: fields
          columns = column :: columns
          rest match {
            case t if t.toString() == "org.virtuslab.beholder.filters.dsl.DSL.Named" =>
            case Select(nextLevel, _) => pop(nextLevel)
            case t =>
              c.error(t.pos, "Unknown tree")
          }
        case tree =>
          c.error(t.pos, "Unknown tree")
      }
      pop(body)

      def seq(args: List[Tree]) =
        Apply(Ident(TermName("Seq")), args)

      def fromString(name: String): Tree = {
        val h :: t = name.split('.').toList
        t.foldLeft(Ident(TermName(h)): Tree) {
          case (tree, name) =>
            Select(tree, TermName(name))
        }
      }

      val provider = Select(c.prefix.tree, TermName("provider"))

      val mappedColumns = columns //.map(column => q"user.name")

      val queryMapping =
        funcCreation(Apply(fromString("scala.Tuple" + columns.size), mappedColumns))

      val qq = q"$query.map($queryMapping)"

      val mapping = fromString("identity")

      val tree = Apply(Select(
        fromString("org.virtuslab.beholder.filters.dsl.FilterFactory"),
        TermName("crate")
      ), List(
        qq,
        seq(fields),
        seq(names)
      ))
      tree
    }
  }

}
