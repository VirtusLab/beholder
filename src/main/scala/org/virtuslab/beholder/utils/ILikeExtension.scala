package org.virtuslab.beholder.utils

import scala.language.implicitConversions
import slick.ast.Library.SqlOperator
import slick.ast.ScalaBaseType.booleanType
import slick.ast._
import slick.lifted._

/**
 * companion object for ILikeExtension
 * to work import iLikeExtension from its body in scope
 */
object ILikeExtension {

  val ILIKE = new SqlOperator("ilike")

  /**
   * escape underscores, percent signs and backslashes as they have special meaning in PostgreSQL's LIKE function
   * @see https://www.postgresql.org/docs/current/functions-matching.html#FUNCTIONS-LIKE
   */
  def escape(text: String) = text
    .replace(raw"\", raw"\\")
    .replace("%", raw"\%")
    .replace("_", raw"\_")

  implicit def iLikeExtension(c: Rep[String]) = new ILikeExtension(c)

  implicit def iLikeMappedExtension(c: Rep[MappedTo[String]]) = new ILikeExtension(c)

  implicit def iLikeOptionExtension(c: Rep[Option[String]]) = new ILikeExtension(c)

  implicit def seq2Ordered[T <% Ordered](t: IndexedSeq[T]) = new Ordered(t.flatMap(_.columns))
}

/**
 * Adds ilike operator to slick.
 */
class ILikeExtension[B](val c: Rep[B]) extends AnyVal with ExtensionMethods[String, B] {

  def ilike[R](e: String)(implicit om: o#arg[String, B]#to[Boolean, R]) =
    om.column(ILikeExtension.ILIKE, n, LiteralNode(e))

  override protected[this] implicit def b1Type: TypedType[String] = ???
}