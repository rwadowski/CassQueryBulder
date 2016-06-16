package com.morgenrete.cassandra

/**
 * Created by rwadowski on 14.05.16.
 */

sealed trait ColumnType {
  def asText: String = this.getClass.getName
}

object ColumnType {

  case object Ascii extends ColumnType { override val asText = "ascii" }
  case object BigInt extends ColumnType { override val asText = "bigint" }
  case object Blob extends ColumnType { override val asText = "blob" }
  case object Boolean extends ColumnType { override val asText = "boolean" }
  case object Counter extends ColumnType { override val asText = "counter" }
  case object Decimal extends ColumnType { override val asText = "decimal" }
  case object Double extends ColumnType { override val asText = "double" }
  case object Float extends ColumnType { override val asText = "float" }
  case object Inet extends ColumnType { override val asText = "inet" }
  case object Int extends ColumnType { override val asText = "int" }
  case object List extends ColumnType { override val asText = "list" }
  case object Set extends ColumnType { override val asText = "set" }
  case object Map extends ColumnType { override val asText = "map" }
  case object Text extends ColumnType { override val asText = "text" }
  case object Timestamp extends ColumnType { override val asText = "timestamp" }
  case object Uuid extends ColumnType { override  val asText = "uuid" }
  case object Timeuuid extends ColumnType { override val asText = "timeuuid" }
  case object VarChar extends ColumnType { override val asText = "varchar" }
  case object VarInt extends ColumnType { override val asText = "varint" }

  val elements = {
    import scala.reflect.runtime.universe._
    val symbol = typeOf[ColumnType].typeSymbol.asClass
    symbol.knownDirectSubclasses
          .map{s => s.owner.typeSignature.member(s.name.toTermName)}
          .map{s => reflect.runtime.currentMirror.reflectModule(s.asModule).instance.asInstanceOf[ColumnType]}
  }

  private val typesMap = elements.map{s => s.asText.toLowerCase -> s}.toMap

  def apply(typeName: String): ColumnType = typesMap(typeName.toLowerCase)
}
