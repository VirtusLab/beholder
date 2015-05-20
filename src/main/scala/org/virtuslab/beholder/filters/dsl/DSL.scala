package org.virtuslab.beholder.filters.dsl

import org.virtuslab.beholder.filters._
import org.virtuslab.beholder.filters.json.{ JsonFilterField, JsonFormatter, JsonFilterFieldImpl }
import org.virtuslab.unicorn.LongUnicornPlay
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import scala.language.higherKinds
import scala.reflect.macros.whitebox.Context
import scala.language.experimental.macros

object DSL {

  trait Mappable[S, E, NS]

  implicit class EmptyName(name: String) extends Named[Unit](name)

  class Named[S](name: String) {
    def from[A, NS](c: Column[A])(implicit shaper: Mappable[S, A, NS]): NamedFieldColumn[NS, A] = ???
  }

  class CompleteRow[S] {
    def and(name: String): Named[S] = ???
  }

  class NamedFieldColumn[S, A] {
    def as[B](field: MappedFilterField[A, B]): CompleteRow[S] = ???
  }

  def create[T, L, FT, E](query: Query[T, L, Seq])(creation: T => CompleteRow[E]): MappableFilterAPI[E, Unit, FT] = macro DSLImpl.create_imp

  //generated mappable implicits

  implicit def unitShape[A]: Mappable[Unit, A, Tuple1[A]] = ???

  implicit def tuple1Shape[A, B]: Mappable[Tuple1[A], B, (A, B)] = ???

  implicit def tuple2Shape[A1, A2, A3]: Mappable[(A1, A2), A3, (A1, A2, A3)] = ???

  implicit def tuple3Shape[A1, A2, A3, A4]: Mappable[(A1, A2, A3), A4, (A1, A2, A3, A4)] = ???

  implicit def tuple4Shape[A1, A2, A3, A4, A5]: Mappable[(A1, A2, A3, A4), A5, (A1, A2, A3, A4, A5)] = ???

  implicit def tuple5Shape[A1, A2, A3, A4, A5, A6]: Mappable[(A1, A2, A3, A4, A5), A6, (A1, A2, A3, A4, A5, A6)] = ???

  implicit def tuple6Shape[A1, A2, A3, A4, A5, A6, A7]: Mappable[(A1, A2, A3, A4, A5, A6), A7, (A1, A2, A3, A4, A5, A6, A7)] = ???

  implicit class JsonFieldedFilter[E <: Product, Formatter, FT <: JsonFilterField](filter: MappableFilterAPI[E, Formatter, FT]) {
    def jsonFormatted[NE <: Product](mapping: E => NE, names: String => String): FilterAPI[NE, JsonFormatter[NE]] =
      filter.mapped(mapping).withFormat(filter => new JsonFormatter[NE](filter.filterFields, filter.columnsNames, names))

    def asJson[NE <: Product](applyFun: E => NE) = jsonFormatted(applyFun, identity)

    def asJson = jsonFormatted(identity, identity)
  }

}

