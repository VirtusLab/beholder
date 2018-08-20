package org.virtuslab.beholder.utils

import org.virtuslab.unicorn.LongUnicornPlay.driver.api._

object SeqParametersHelper {

  def isColumnValueInsideSeq[A](column: Rep[A])(dataSeq: Seq[A])(isEqual: (Rep[A], A) => Rep[Option[Boolean]]): Rep[Option[Boolean]] = {
    if (dataSeq.isEmpty) {
      LiteralColumn(Option(true))
    } else {
      dataSeq.foldLeft(Option(false): Rep[Option[Boolean]])((acc, data) => acc || isEqual(column, data))
    }
  }
}