package org.virtuslab.beholder.utils

import org.virtuslab.beholder.BaseTest

class ILikeExensionTest extends BaseTest {
  it should "properly escape underscores, percent signs and backslashes" in { _ =>
    // GIVEN
    val troublesomeStrings = Seq(
      raw"underscore_",
      raw"percent%",
      raw"""backslash\""",
      raw"double-underscore__",
      raw"double-percent%%",
      raw"double-backslash\\",
      raw"""underscore_percent%backslash\""")

    // WHEN
    val escapeResults = troublesomeStrings.map(ILikeExtension.escape)

    // THEN
    val expectedEscapeResults = Seq(
      raw"underscore\_",
      raw"percent\%",
      raw"backslash\\",
      raw"double-underscore\_\_",
      raw"double-percent\%\%",
      raw"double-backslash\\\\",
      raw"underscore\_percent\%backslash\\")

    escapeResults shouldEqual expectedEscapeResults
  }
}
