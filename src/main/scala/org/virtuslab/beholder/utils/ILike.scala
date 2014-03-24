package org.virtuslab.beholder.utils

import scala.slick.ast.Library.SqlOperator
import scala.slick.lifted.{ExtensionMethods, Ordered, Column}
import scala.slick.ast.Node


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

  implicit def iLikeExtension(c: Column[String]): ILikeExtension[String] = new ILikeExtension(c)

  implicit def iLikeOptionExtension(c: Column[Option[String]]): ILikeExtension[Option[String]] = new ILikeExtension(c)

  implicit def seq2Ordered[T <% Ordered](t: Seq[T]) = new Ordered(t.flatMap(_.columns))

}

/**
 * adds ilkie operator to slick
 */
class ILikeExtension[K](val c: Column[K]) extends AnyVal with ExtensionMethods[K, K] {

  def ilike[P2, R](e: Column[P2])(implicit om: o#arg[String, P2]#to[Boolean, R]) =
    om(ILikeExtension.ILIKE.column(n, Node(e)))
}