package org.virtuslab.beholder.filters

/**
 * Utils
 *
 * @author Jerzy Müller
 */
trait FilterUtils {

  private def getValue(s: String) = if (s.matches("[+-]?\\d+")) Some(Integer.parseInt(s)) else None

  /**
   *
   * @param value
   * @param pattern
   * @param convert
   * @tparam A
   * @return
   */
  def filterField[A](value: Option[String], pattern: String, convert: String => Option[A]): Seq[A] =
    value.map(_.split(pattern).toSeq).getOrElse(Seq.empty).flatMap(string => convert(string))

  /**
   *
   * @param value
   * @param pattern
   * @return
   */
  def textFilterField(value: Option[String], pattern: String): Seq[String] =
    filterField(value, pattern, Some.apply)

  /**
   *
   * @param value
   * @param pattern
   * @return
   */
  def intFilterField(value: Option[String], pattern: String): Seq[Int] =
    filterField(value, pattern, getValue)

  /**
   *
   * @param value
   * @param pattern
   * @return
   */
  def userId(value: Option[String], pattern: String): Seq[Int] =
    filterField(value, pattern, getValue)

  /**
   *
   * @param value
   * @param pattern
   * @param mapping
   * @tparam T
   * @return
   */
  def mappedToIntFilterField[T](value: Option[String], pattern: String, mapping: Int => T): Seq[T] =
    filterField(value, pattern, s => getValue(s).map(mapping))

}

/**
 *
 */
object FilterUtils extends FilterUtils