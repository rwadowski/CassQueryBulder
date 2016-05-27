package com.morgenrete.query.udt

import com.morgenrete.config.keyspace.KeyspaceConf
import com.morgenrete.config.udt.UDTConf

/**
 * Created by rwadowski on 15.05.16.
 */
class UDTQuery(val conf: UDTConf) {

  def text(keyspace: KeyspaceConf): String = {
    val list = conf.members.map {field => s"|${field.name} ${field.typeName.toUpperCase}"}
    val existsClauseText = if(conf.existsClause) "IF NOT EXISTS" else new String
    val op = conf.opName.toUpperCase
    list.isEmpty match {
      case false =>
        s"""$op TYPE $existsClauseText ${keyspace.name}.${conf.name} (
        ${list.mkString(",\n")}
        |);""".stripMargin
      case true =>
        s"""$op TYPE $existsClauseText ${keyspace.name}.${conf.name};"""
    }
  }
}
