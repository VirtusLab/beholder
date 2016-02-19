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
   * escape text so can spoil sql reqexp
   *
   * @param text
   * @return
   */
  def escape(text: String) = text.replace("%", "\\%").replace("_", "\\_")

  implicit def iLikeExtension(c: Rep[String]) = new ILikeExtension(c)

  implicit def iLikeMappedExtension(c: Rep[MappedTo[String]]) = new ILikeExtension(c)

  implicit def iLikeOptionExtension(c: Rep[Option[String]]) = new ILikeExtension(c)

  implicit def seq2Ordered[T <% Ordered](t: Seq[T]) = new Ordered(t.flatMap(_.columns))
}

/**
 * Adds ilike operator to slick.
 */
class ILikeExtension[B](val c: Rep[B]) extends AnyVal with ExtensionMethods[String, B] {

  override protected[this] implicit def b1Type: TypedType[String] = implicitly

  def ilike[R](e: String)(implicit om: o#arg[String, B]#to[Boolean, R]) =
    om.column(ILikeExtension.ILIKE, n, LiteralNode(e))

}
