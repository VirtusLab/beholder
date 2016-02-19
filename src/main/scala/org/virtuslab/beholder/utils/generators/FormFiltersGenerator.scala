package org.virtuslab.beholder.utils.generators

import org.virtuslab.beholder.utils.generators.CodeGenerationUtils._

private[beholder] object FormFiltersGenerator extends App {
  //TODO remove/update this!
  final def generateCode = {
    (3 to 18).map {
      implicit nr =>

        val fieldFilters = fill(nr => s"c${nr}Mapping: FieldType[A$nr, B$nr]", ",\n")
        val mappings = fill(n => s"c${n}Mapping")
        val columnsNames = fill("table.c" + _)

        s"""
          |def create[$aTypesWithTypedType,
          |           $bTypes,
          |           T <: BaseView$nr[Entity,
          |             $aTypes]](table: TableQuery[T],
          |                       $fieldFilters):
          |             TableFilterAPI[Entity, Formatter, T] = {
          |
          |    new BaseFilter[A1, Entity, T, FieldType[_, _], Formatter](table) {
          |      override val formatter: Formatter = createFormatter(this)
          |
          |      override protected def emptyFilterDataInner: Seq[Option[Any]] = Seq.fill($nr)(None)
          |
          |      override def filterFields: Seq[FieldType[_, _]] =
          |       Seq[FieldType[_, _]]($mappings)
          |
          |      override protected def tableColumns(table: T): Seq[LongUnicornPlay.driver.simple.Column[_]] = Seq(
          |       $columnsNames
          |      )
          |    }
          |  }
        """.stripMargin

    }
  }

  println(generateCode.mkString("\n"))
}