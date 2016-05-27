package com.morgenrete.config.keyspace

import com.morgenrete.config.cf.CFConf
import com.morgenrete.config.keyspace.replication.ReplicationConf
import com.morgenrete.config.udt.UDTConf

/**
 * Created by rwadowski on 14.05.16.
 */
class KeyspaceConf(val name: String,
                   val replication: ReplicationConf,
                   val durableWrites: DurableWritesConf,
                   val types: Seq[UDTConf],
                   val columnFamilies: Set[CFConf]) {

//  val createKeyspaceQuery = {
//    val replicationQueryPart = replication.asText
//    val durableWritesQueryPart = durableWrites.asText
//    s" CREATE KEYSPACE $name WITH $replicationQueryPart AND $durableWritesQueryPart ;"
//  }
//
//  val createTypesQuery = {
//    s""
//  }
//
//  val createColumnFamiliesQuery = {
//    s""
//  }
//
//  def asText: String = {
//    s"""$createKeyspaceQuery"""
//  }
}
