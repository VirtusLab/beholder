package org.virtuslab.beholder.model

import java.sql.Date

import org.virtuslab.unicorn.LongUnicornPlay._
import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._
import play.api.data.FormError
import play.api.libs.json._
import play.api.data.format.{ Formats, Formatter }

/**
 * commons enum method for use with slick and play
 */
trait BaseEnum {
  self: Enumeration =>

  /**
   * Type mapper placed here is resolved automatically and does not need to be imported anywhere.
   */
  implicit val typeMapper: BaseColumnType[Value] = MappedColumnType.base[Value, Int](int => int.id, id => apply(id))

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

object MachineStatus extends Enumeration with BaseEnum {

  val Active = Value(1, "active")
  val Inactive = Value(2, "inactive")
  val Broken = Value(3, "broken")

}
/** Id class for type-safe joins and queries. */
case class MachineId(id: Long) extends AnyVal with BaseId

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
  status: MachineStatus.Value
) extends WithId[MachineId]

/** Table definition for machines. */
class Machines(tag: Tag) extends IdTable[MachineId, Machine](tag, "MACHINES") {

  def url = column[String]("url", O.NotNull)

  def system = column[String]("system", O.NotNull)

  def cores = column[Int]("cores", O.NotNull)

  def created = column[Date]("created", O.NotNull)

  def capacity = column[Option[BigDecimal]]("capacity")

  def status = column[MachineStatus.Value]("status")

  override def * = (id.?, url, system, cores, created, capacity, status) <> (Machine.tupled, Machine.unapply)
}
