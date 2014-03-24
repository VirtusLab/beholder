package org.virtuslab.beholder.filters

import scala.slick.lifted.{BaseTypeMapper, Column, TypeMapper}
import play.api.data.{FormError, Mapping}
import play.api.db.slick.Config.driver.simple._
import play.api.data.Forms._
import play.api.data.validation.Constraint
import scala.Enumeration
import play.api.data.format.Formatter
import org.virtuslab.beholder.utils.ILikeExtension._

/**
 * @author krzysiek
 */

/**
 * filter field - there is information how read parameters from form data (mapping)
 * and how create sql's where statement(filter on column) for it
 * @param mapping mapping for B - data for filter
 * @tparam A field type in database
 * @tparam B field type in filter form
 */
abstract class FilterField[A: TypeMapper, B](val mapping: Mapping[B]) {

  /**
   * filter on column - apply filter form data into sql - default returns true
   * @param column
   * @param value
   * @return
   */
  def filterOnColumn(column: Column[A])(value: B): Column[Option[Boolean]]

}

object FilterField {

  private def ignoreMapping[T] = new Mapping[T] {
    val key: String = ""
    val mappings: Seq[Mapping[_]] = Nil
    val constraints: Seq[Constraint[T]] = Nil

    def bind(data: Map[String, String]): Either[Seq[FormError], T] = Left(Nil)

    def unbind(value: T): (Map[String, String], Seq[FormError]) = Map[String, String]() -> Nil

    def withPrefix(prefix: String): Mapping[T] = this

    def verifying(constraints: Constraint[T]*): Mapping[T] = this
  }

  private def rangeMapping[T: Formatter] = tuple(
    "from" -> optional(of[T]),
    "to" -> optional(of[T])
  )

  //API

  /**
   * search in text (ilike)
   */
  object inText extends FilterField[String, String](text) {
    override def filterOnColumn(column: Column[String])(data: String): Column[Option[Boolean]] = column ilike s"%${escape(data)}%"
  }


  /**
   * search in text (ilike) for optional fields
   */
  object inOptionText extends FilterField[Option[String], String](text) {
    override def filterOnColumn(column: Column[Option[String]])(data: String): Column[Option[Boolean]] = column ilike s"%${escape(data)}%"
  }

  /**
   * search in text (ilike)
   * @return
   */
  object inIntField extends FilterField[Int, Int](number) {
    override def filterOnColumn(column: Column[Int])(data: Int): Column[Option[Boolean]] = column === data
  }


  /**
   * simple check boolean
   * @return
   */
  object inBoolean extends FilterField[Boolean, Boolean](boolean) {
    override def filterOnColumn(column: Column[Boolean])(data: Boolean): Column[Option[Boolean]] = column === data
  }

  /**
   * check enum value
   * @tparam T - enum class (eg. Colors.type)
   * @return
   */
  def inEnum[T <: Enumeration](implicit tm: BaseTypeMapper[T#Value], formatter: Formatter[T#Value]): FilterField[T#Value, T#Value] =
    new FilterField[T#Value, T#Value](of[T#Value]) {
      override def filterOnColumn(column: Column[T#Value])(data: T#Value): Column[Option[Boolean]] = column === data
    }

  def inRange[T](implicit tm: BaseTypeMapper[T], f: Formatter[T]): FilterField[T, (Option[T], Option[T])] =
    new FilterField[T, (Option[T], Option[T])](rangeMapping[T]) {
      override def filterOnColumn(column: Column[T])(value: (Option[T], Option[T])): Column[Option[Boolean]] = value match {
        case (Some(from), Some(to)) => column >= from && column <= to
        case (None, Some(to)) => column <= to
        case (Some(from), None) => column >= from
        case _ => ConstColumn(Some(true))
      }
    }

  /**
   * search in range (form contain from and to)
   * @param tm
   * @param f
   * @tparam T
   * @return
   */
  def inOptionRange[T](implicit tm: BaseTypeMapper[T], f: Formatter[T]): FilterField[Option[T], (Option[T], Option[T])] =
    new FilterField[Option[T], (Option[T], Option[T])](rangeMapping[T]) {
      override def filterOnColumn(column: Column[Option[T]])(value: (Option[T], Option[T])): Column[Option[Boolean]] = value match {
        case (Some(from), Some(to)) => column >= from && column <= to
        case (None, Some(to)) => column <= to
        case (Some(from), None) => column >= from
        case _ => ConstColumn(Some(true))
      }
    }

  /**
   * ignore given field in filter
   * @tparam T
   * @return
   */
  def ignore[T: TypeMapper]: FilterField[T, T] = new FilterField[T, T](ignoreMapping[T]) {
    override def filterOnColumn(column: Column[T])(value: T): Column[Option[Boolean]] = ConstColumn(Some(true))
  }
}
