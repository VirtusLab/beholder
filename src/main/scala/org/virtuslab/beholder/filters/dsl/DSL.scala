package org.virtuslab.beholder.filters.dsl

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.filters.json.{ JsonFormatter, JsonFilterField }
import org.virtuslab.unicorn.LongUnicornPlay
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import scala.language.higherKinds
import scala.reflect.macros.whitebox.Context

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

}

class JsonMacroFilters[Entity <: Product](labels: String => String) extends DSLFilters[Entity, JsonFilterField, JsonFormatter[Entity]] {
  override def createFormatter(table: BareFilter[_, _, _, JsonFilterField[_, _], JsonFormatter[Entity]]) =
    new JsonFormatter[Entity](table.filterFields, table.columnsNames, labels)
}

abstract class DSLFilters[E, FT[_, _] <: MappedFilterField[_, _], Formatter] {

  import DSL._

  type EndDsl = NamedFieldColumn

  def createFormatter(table: BareFilter[_, _, _, FT[_, _], Formatter]): Formatter

  import scala.language.experimental.macros

  case class DslFilter[DbE, T <: Product](table: Query[T, DbE, Seq], filterFields: Seq[FT], columnsNames: Seq[String], mapping: DbE => E)
      extends BareFilter[E, DbE, T, FT, JsonFormatter[E]] {

    override def defaultColumn(table: T): LongUnicornPlay.driver.simple.Column[_] = tableColumns(table).head

    override def columnByName(table: T, name: String): LongUnicornPlay.driver.simple.Column[_] = {
      val map: Map[String, Column[_]] = columnsNames.zip(tableColumns(table))(collection.breakOut)
      map(name)
    }

    override def mappingFunction(e: DbE): E = mapping(e)

    override protected def tableColumns(table: T) = table.productIterator.map(_.asInstanceOf[Column[_]]).toSeq

    override val formatter: JsonFormatter[E] = createFormatter(this)
  }

  def create[T, L](q: Query[T, L, Seq])(creation: T => EndDsl): FilterAPI[E, Formatter] = macro Implementer.create_imp[E, Formatter]
}

object Implementer {
  def create_imp[E, F](c: Context)(q: c.Tree)(creation: c.Tree): c.Tree = {
    val e = Extractor(c)
    e.implement(creation.asInstanceOf[e.c.Tree]).asInstanceOf[c.Tree]
  }

  case class Extractor(c: Context) {

    import c.universe._

    def implement(code: Tree): Tree = {
      code match {
        case Function(fA, Match(mA, List(CaseDef(pat, guards, body)))) =>
          transform(body => Function(fA, Match(mA, List(CaseDef(pat, guards, body)))), body)
        case _ =>
          c.abort(c.enclosingPosition, "unsupported tree shape")
      }

    }

    def transform(funcCreation: Tree => Tree, body: Tree): Tree = {
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
        case _ =>
          c.error(t.pos, "Unknown tree")
      }
      pop(body)

      def seq(args: List[Tree]) =
        Apply(Ident("Seq"), args)

      val query = ???

      Apply(Ident("DslFilter"), List(seq(fields), seq(names)))
    }

  }

}
