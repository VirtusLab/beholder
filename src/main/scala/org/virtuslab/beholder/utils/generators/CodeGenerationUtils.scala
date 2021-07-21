package org.virtuslab.beholder.utils.generators

/**
 * Utils for code generation - not used in production code
 */
private[beholder] object CodeGenerationUtils {

  /**
   * create sequence of string with given function Int => String separated by separator for given numbers (starts with 1)
   */
  def fill(baseText: Int => String, sep: String = ", ")(implicit to: Int) = (1 to to).map(baseText).mkString(sep)

  /**
   * create A1, A2, etc
   */
  def aTypes(implicit nr: Int, sep: String = ", ") = fill("A" + _, sep)(nr)

  /**
   * create B1, B2, etc
   */
  def bTypes(implicit nr: Int, sep: String = ", ") = fill("B" + _, sep)(nr)

  /**
   * create A1:TypeMapper, A2:TypeMapper, etc
   */
  def aTypesWithTypedType(implicit nr: Int) = fill(nr => s"A$nr:TypedType")(nr)

  /**
   * create B1:Formatter, B2:Formatter, etc
   */
  def bTypesWithFormatter(implicit nr: Int) = fill(nr => s"B$nr:Formatter")(nr)

}
