package com.morgenrete.cassandra

/**
 * Created by rwadowski on 14.05.16.
 */

sealed trait ColumnType {
  def asText: String
}

object ColumnType {

  case object AsciiColumnType extends ColumnType { override val asText = "ascii" }
  case object BigIntColumnType extends ColumnType { override val asText = "bigint" }
  case object BlobColumnType extends ColumnType { override val asText = "blob" }
  case object BooleanColumnType extends ColumnType { override val asText = "boolean" }
  case object CounterColumnType extends ColumnType { override val asText = "counter" }
  case object DecimalColumnType extends ColumnType { override val asText = "decimal" }
  case object DoubleColumnType extends ColumnType { override val asText = "double" }
  case object FloatColumnType extends ColumnType { override val asText = "float" }
  case object InetColumnType extends ColumnType { override val asText = "inet" }
  case object IntColumnType extends ColumnType { override val asText = "int" }
  case object ListColumnType extends ColumnType { override val asText = "list" }
  case object SetColumnType extends ColumnType { override val asText = "set" }
  case object MapColumnType extends ColumnType { override val asText = "map" }
  case object TextColumnType extends ColumnType { override val asText = "text" }
  case object TimestampColumnType extends ColumnType { override val asText = "timestamp" }
  case object UuidColumnType extends ColumnType { override  val asText = "uuid" }
  case object TimeuuidColumnType extends ColumnType { override val asText = "timeuuid" }
  case object VarCharColumnType extends ColumnType { override val asText = "varchar" }
  case object VarIntColumnType extends ColumnType { override val asText = "varint" }

  val elements = Set(AsciiColumnType, BigIntColumnType, BlobColumnType, BooleanColumnType, CounterColumnType, DecimalColumnType, DoubleColumnType,
                     FloatColumnType, InetColumnType, IntColumnType, ListColumnType, SetColumnType, MapColumnType, TextColumnType, TimestampColumnType,
                     UuidColumnType, TimeuuidColumnType, VarCharColumnType, VarIntColumnType)

  def apply(typeName: String): ColumnType = {
    val name = typeName.toLowerCase
    name match {
      case AsciiColumnType.asText => AsciiColumnType
      case BigIntColumnType.asText => BigIntColumnType
      case BlobColumnType.asText => BlobColumnType
      case BooleanColumnType.asText => BooleanColumnType
      case CounterColumnType.asText => CounterColumnType
      case DecimalColumnType.asText => DecimalColumnType
      case DoubleColumnType.asText => DoubleColumnType
      case FloatColumnType.asText => FloatColumnType
      case InetColumnType.asText => InetColumnType
      case IntColumnType.asText => InetColumnType
      case ListColumnType.asText => ListColumnType
      case SetColumnType.asText => SetColumnType
      case MapColumnType.asText => MapColumnType
      case TextColumnType.asText => TextColumnType
      case TimestampColumnType.asText => TimestampColumnType
      case UuidColumnType.asText => UuidColumnType
      case TimeuuidColumnType.asText => TimeuuidColumnType
      case VarCharColumnType.asText => VarCharColumnType
      case VarIntColumnType.asText => VarIntColumnType
      case _ => throw new Exception(s"Unknown type $typeName of column")
    }
  }
}
