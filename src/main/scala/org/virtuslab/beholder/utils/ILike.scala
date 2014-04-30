package org.virtuslab.beholder.utils

import scala.language.implicitConversions
import scala.slick.ast.Library.SqlOperator
import scala.slick.ast.ScalaBaseType.booleanType
import scala.slick.ast._
import scala.slick.lifted._

/**
 * companion object for ILikeExtension
 * to work import iLikeExtension from its body in scope
 */
object ILikeExtension {
  val ILIKE = new SqlOperator("ilike")

  /**
   * escape text so can spoil sql reqexp
   * @param text
   * @return
   */
  def escape(text: String) = text.replace("%", "\\%").replace("_", "\\_")

  implicit def iLikeExtension(c: Column[String]) = new ILikeExtension(c)

  implicit def iLikeOptionExtension(c: Column[Option[String]]) = new ILikeExtension(c)

  implicit def seq2Ordered[T <% Ordered](t: Seq[T]) = new Ordered(t.flatMap(_.columns))
}

/**
 * Adds ilike operator to slick.
 */
class ILikeExtension[B](val c: Column[B]) extends AnyVal with ExtensionMethods[String, B] {

  def ilike[R](e: String)(implicit om: o#arg[String, String]#to[Boolean, R]) =
    om.column(ILikeExtension.ILIKE, n, LiteralNode(e))

}