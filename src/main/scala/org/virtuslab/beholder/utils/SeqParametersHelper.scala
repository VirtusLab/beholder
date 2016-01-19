package org.virtuslab.beholder.utils

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

object SeqParametersHelper {

  def isColumnValueInsideSeq[A](column: Column[A])(dataSeq: Seq[A])(isEqual: (Column[A], A) => Column[Option[Boolean]]): Column[Option[Boolean]] = {
    if (dataSeq.isEmpty) {
      LiteralColumn(Option(true))
    } else {
      dataSeq.foldLeft(Option(false): Column[Option[Boolean]])((acc, data) => acc || isEqual(column, data))
    }
  }
}
