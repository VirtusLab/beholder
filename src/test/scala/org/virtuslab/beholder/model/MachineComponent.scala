package org.virtuslab.beholder.model

import java.sql.Date
import java.util

import org.virtuslab.unicorn.LongUnicornPlayIdentifiers.IdCompanion
import org.virtuslab.unicorn.{ BaseId, UnicornWrapper, WithId }
import play.api.data.FormError
import play.api.libs.json._
import play.api.data.format.{ Formats, Formatter }

import scala.language.implicitConversions

trait BaseEnum {
  self: Enumeration =>

  //for play forms
  implicit lazy val mappingFormatter: Formatter[Value] = new Formatter[Value] {

    override val format = Some(("format.numeric", Nil))

    override def bind(key: String, data: Map[String, String]): Either[Seq[FormError], Value] =
      Formats.intFormat.bind(key, data).right.map(apply)

    override def unbind(key: String, value: Value): Map[String, String] =
      Map(key -> value.id.toString)

  }

  //for json forms
  implicit val format = new Format[Value] {
    override def writes(o: Value): JsValue = JsNumber(o.id)
    override def reads(json: JsValue): JsResult[Value] = json.asOpt[Int].map(apply).map(JsSuccess(_)).getOrElse(JsError("format invalid"))
  }

}

trait EnumColumnMapper {
  self: UnicornWrapper[Long] =>
  import unicorn.profile.api._

  def enumTypeMapper(e: Enumeration): BaseColumnType[e.Value] =
    MappedColumnType.base[e.Value, Int](
      int => int.id,
      id => e.apply(id))

}

object MachineStatus extends Enumeration with BaseEnum {

  val Active = Value(1, "active")
  val Inactive = Value(2, "inactive")
  val Broken = Value(3, "broken")

}
/** Id class for type-safe joins and queries. */
case class MachineId(id: Long) extends BaseId[Long]

/**
 * Companion object for id class, extends IdMapping
 * and brings all required implicits to scope when needed.
 */
object MachineId extends IdCompanion[MachineId]

/**
 * Machine entity.
 *
 * @param id machine id
 * @param url machine email address
 * @param system operating system installed on machine
 * @param cores number of cores that machine posess
 * @param capacity capacity of that machine
 */
case class Machine(
  id: Option[MachineId],
  url: String,
  system: String,
  cores: Int,
  created: Date,
  capacity: Option[BigDecimal],
  status: MachineStatus.Value) extends WithId[Long, MachineId]

trait MachineComponent extends EnumColumnMapper {
  self: UnicornWrapper[Long] =>

  import unicorn._
  import unicorn.profile.api._

  implicit val stateTypeMapper = enumTypeMapper(MachineStatus)

  /**
   * commons enum method for use with slick and play
   */

  /** Table definition for machines. */
  class Machines(tag: Tag) extends IdTable[MachineId, Machine](tag, "MACHINES") {

    def url = column[String]("url")

    def system = column[String]("system")

    def cores = column[Int]("cores")

    def created = column[Date]("created")

    def capacity = column[Option[BigDecimal]]("capacity")

    def status = column[MachineStatus.Value]("status")

    override def * = (id.?, url, system, cores, created, capacity, status) <> (Machine.tupled, Machine.unapply)

  }

  class BaseMachineRepository extends BaseIdRepository[MachineId, Machine, Machines](TableQuery[Machines])

  val baseMachineRepository = new BaseMachineRepository()
}
