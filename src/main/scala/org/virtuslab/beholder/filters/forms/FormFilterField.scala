package org.virtuslab.beholder.filters.forms

import scala.slick.ast.{ BaseTypedType, TypedType }
import play.api.data.{ FormError, Mapping }
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import org.virtuslab.beholder.filters.{ FilterRange, MappedFilterField }
import play.api.data.validation.Constraint
import play.api.data.format.Formatter
import play.api.data.Forms._
import org.virtuslab.beholder.utils.ILikeExtension._
import scala.Some

abstract class FormFilterField[A: TypedType, B](mapping: Mapping[B]) extends MappedFilterField[A, B] {

  final def bind(name: String)(data: Map[String, String]): Either[Seq[FormError], B] = mapping.withPrefix(name).bind(data)

  final def unbind(name: String)(value: Any): Map[String, String] = mapping.withPrefix(name).unbind(value.asInstanceOf[B])
}

object FromFilterFields {
  private def ignoreMapping[T] = new Mapping[T] {
    val key = ""
    val mappings: Seq[Mapping[_]] = Nil
    val constraints: Seq[Constraint[T]] = Nil

    def bind(data: Map[String, String]): Either[Seq[FormError], T] = Left(Nil)

    def unbindAndValidate(value: T): (Map[String, String], Seq[FormError]) = Map[String, String]() -> Nil

    def withPrefix(prefix: String): Mapping[T] = this

    def verifying(constraints: Constraint[T]*): Mapping[T] = this

    override def unbind(value: T): Map[String, String] = Map[String, String]()
  }

  private def rangeMapping[T: Formatter] = mapping(
    "from" -> optional(of[T]),
    "to" -> optional(of[T])
  )(FilterRange.apply _)(FilterRange.unapply _)

  //API

  /**
   * search in text (ilike)
   * @return
   */
  object inIntField extends FormFilterField[Int, Int](number) {
    override def filterOnColumn(column: Column[Int])(data: Int): Column[Option[Boolean]] = column === data
  }

  /**
   * simple check boolean
   * @return
   */
  object inBoolean extends FormFilterField[Boolean, Boolean](boolean) {
    override def filterOnColumn(column: Column[Boolean])(data: Boolean): Column[Option[Boolean]] = column === data
  }

  /**
   * search in text (ilike)
   */
  object inText extends FormFilterField[String, String](text) {
    override def filterOnColumn(column: Column[String])(data: String): Column[Option[Boolean]] = column ilike s"%${escape(data)}%"
  }

  /**
   * search in text (ilike) for optional fields
   */
  object inOptionText extends FormFilterField[Option[String], String](text) {
    override def filterOnColumn(column: Column[Option[String]])(data: String): Column[Option[Boolean]] = column ilike s"%${escape(data)}%"
  }

  /**
   * check enum value
   * @tparam T - enum class (eg. Colors.type)
   * @return
   */
  def inEnum[T <: Enumeration](implicit tm: BaseTypedType[T#Value], formatter: Formatter[T#Value]): FormFilterField[T#Value, T#Value] =
    inField[T#Value]

  def inField[T](implicit tm: BaseTypedType[T], formatter: Formatter[T]): FormFilterField[T, T] =
    new FormFilterField[T, T](of[T]) {
      override def filterOnColumn(column: Column[T])(data: T): Column[Option[Boolean]] = column === data
    }

  def inRange[T](implicit tm: BaseTypedType[T], f: Formatter[T]): FormFilterField[T, FilterRange[T]] =
    new FormFilterField[T, FilterRange[T]](rangeMapping[T]) {
      override def filterOnColumn(column: Column[T])(value: FilterRange[T]): Column[Option[Boolean]] = {
        value match {
          case FilterRange(Some(from), Some(to)) => column >= from && column <= to
          case FilterRange(None, Some(to)) => column <= to
          case FilterRange(Some(from), None) => column >= from
          case _ => LiteralColumn(Some(true))
        }
      }
    }

  /**
   * Search in range (form contain from and to).
   * @param tm
   * @param f
   * @tparam T
   * @return
   */
  def inOptionRange[T](implicit tm: BaseTypedType[T], f: Formatter[T]): FormFilterField[Option[T], FilterRange[T]] =
    new FormFilterField[Option[T], FilterRange[T]](rangeMapping[T]) {
      override def filterOnColumn(column: Column[Option[T]])(value: FilterRange[T]): Column[Option[Boolean]] = value match {
        case FilterRange(Some(from), Some(to)) => column >= from && column <= to
        case FilterRange(None, Some(to)) => column <= to
        case FilterRange(Some(from), None) => column >= from
        case _ => LiteralColumn(Some(true))
      }
    }

  /**
   * Ignores given field in filter.
   * @tparam T
   * @return
   */
  def ignore[T: TypedType]: FormFilterField[T, T] = new FormFilterField[T, T](ignoreMapping[T]) {
    override def filterOnColumn(column: Column[T])(value: T): Column[Option[Boolean]] = LiteralColumn(Some(true))
  }
}