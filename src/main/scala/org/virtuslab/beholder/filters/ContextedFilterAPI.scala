package org.virtuslab.beholder.filters

/**
 * Author: Krzysztof Romanowski
 */
abstract class ContextedFilterAPI[Context, Entity, Formatter] extends (Context => FilterAPI[Entity, Formatter]) {
  private[beholder] def filterFormatter: Formatter
}
