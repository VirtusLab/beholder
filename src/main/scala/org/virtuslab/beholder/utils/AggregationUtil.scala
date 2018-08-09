package org.virtuslab.beholder.utils

import org.virtuslab.beholder.filters.Aggregated

object AggregationUtil {
  def aggregateResult[E, A](result: Seq[(E, Option[A])]): Seq[Aggregated[E, A]] = {
    result match {
      case Nil => Nil
      case (e, a) +: tail =>
        tail.foldLeft(Seq(Aggregated(e, a.toSet))) {
          case (current +: rest, (e, Some(a))) if current.from == e =>
            Aggregated(e, current.data + a) +: rest
          case (current, (e, a)) =>
            Aggregated(e, a.toSet) +: current
        }.reverse
    }
  }

}
