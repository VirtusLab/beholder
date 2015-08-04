package org.virtuslab.beholder.filters

import org.virtuslab.unicorn.LongUnicornPlay.driver.simple._

/**
 * Author: Krzysztof Romanowski
 */
trait MappableFilterAPI[Entity, Formatter, FT, TableEntity] extends FilterAPI[Entity, Formatter] {

  def columnsNames: Seq[String]

  def filterFields: Seq[FT]

  protected def globalInitialFilter(table: TableEntity): Column[Option[Boolean]]

  protected def doFilter(data: FilterDefinition,
                         initialFilter: TableEntity => Column[Option[Boolean]])
                        (implicit session: Session): Seq[Entity]


  protected def doFilterWithTotalEntitiesNumber(data: FilterDefinition,
                                                initialFilter: TableEntity => Column[Option[Boolean]])
                                               (implicit session: Session): FilterResult[Entity]


  override final def filterWithTotalEntitiesNumber(data: FilterDefinition)(implicit session: Session): FilterResult[Entity] =
    doFilterWithTotalEntitiesNumber(data, globalInitialFilter)

  override final def filter(data: FilterDefinition)(implicit session: Session): Seq[Entity] =
    doFilter(data, globalInitialFilter)


  private type ThisType = MappableFilterAPI[Entity, Formatter, FT, TableEntity]

  private class MappedFilter[NE, NF](parent: ThisType)
                                    (mappingFun: Entity => NE, foramtterFunc: ThisType => NF)
    extends MappableFilterAPI[NE, NF, FT, TableEntity] {

    override def columnsNames: Seq[String] = parent.columnsNames

    override protected def doFilterWithTotalEntitiesNumber(data: FilterDefinition,
                                                           initialFilter: (TableEntity) => Column[Option[Boolean]])
                                                          (implicit session: Session): FilterResult[NE] = {
      val res = parent.doFilterWithTotalEntitiesNumber(data, initialFilter)
      res.copy(content = res.content.map(mappingFun))
    }

    override def filterFields: Seq[FT] = parent.filterFields

    override protected def doFilter(data: FilterDefinition, initialFilter: (TableEntity) => Column[Option[Boolean]])(implicit session: Session): Seq[NE] =
      parent.doFilter(data, initialFilter).map(mappingFun)

    override def emptyFilterData: FilterDefinition = parent.emptyFilterData

    override private[beholder] def filterFormatter: NF = foramtterFunc(parent)

    override protected def globalInitialFilter(table: TableEntity): Column[Option[Boolean]] = parent.globalInitialFilter(table)
  }

  def withFormat[NF](f: MappableFilterAPI[Entity, Formatter, FT, TableEntity] => NF): FilterAPI[Entity, NF] =
    new MappedFilter(this)(identity, f)

  def mapped[NE](mapping: Entity => NE): MappableFilterAPI[NE, Formatter, FT, TableEntity] =
    new MappedFilter(this)(mapping, _.filterFormatter)

  /**
   * Copy this filter with new initial filter.
   * Returned filter will always yield entities that match  newInitialFilter
   */
  def withInitialFilter(newInitialFilter: TableEntity => Column[Boolean]): MappableFilterAPI[Entity, Formatter, FT, TableEntity] =
    new MappedFilter(this)(identity, _.filterFormatter) {
      override protected def globalInitialFilter(table: TableEntity): Column[Option[Boolean]] =
        newInitialFilter(table)
    }

  /**
   * Create new ContextedFilter based on this filter.
   * Returned filter will always yield entities that match  newInitialFilter
   */
  def withContextInitialFilter[Context](newInitialFilter: Context => TableEntity => Column[Boolean]): ContextedFilterAPI[Context, Entity, Formatter] = {
    val org = this
    new ContextedFilterAPI[Context, Entity, Formatter] {
      override def apply(context: Context): FilterAPI[Entity, Formatter] = withInitialFilter(newInitialFilter(context))

      private[beholder] def filterFormatter: Formatter = org.filterFormatter
    }
  }
}
