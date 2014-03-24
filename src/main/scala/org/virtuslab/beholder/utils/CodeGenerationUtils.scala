package org.virtuslab.beholder.utils

import scala.language.postfixOps

/**
 * Utils for code generation - not used in production code
 * @author krzysiek
 */
object CodeGenerationUtils {
  /**
   * create sequence of string with given function Int => String separated by separator for given numbers (starts with 1)
   * @param baseText
   * @param sep
   * @param to
   * @return
   */
  def fill(baseText: Int => String, sep: String = ", ")(implicit to: Int) = (1 to to).map(baseText).mkString(sep)

  /**
   * create A1, A2, etc
   * @param nr
   * @return
   */
  def aTypes(implicit nr: Int) = fill("A" +)(nr)

  /**
   * create B1, B2, etc
   * @param nr
   * @return
   */
  def bTypes(implicit nr: Int) = fill("B" +)(nr)

  /**
   * create A1:TypeMapper, A2:TypeMapper, etc
   * @param nr
   * @return
   */
  def aTypesWithTypeMappers(implicit nr: Int) = fill(nr => s"A$nr:TypeMapper")(nr)

  /**
   * create B1:Formatter, B2:Formatter, etc
   * @param nr
   * @return
   */
  def bTypesWithFormatter(implicit nr: Int) = fill(nr => s"B$nr:Formatter")(nr)

}
