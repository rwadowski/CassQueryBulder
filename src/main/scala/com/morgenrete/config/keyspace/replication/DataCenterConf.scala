package com.morgenrete.config.keyspace.replication

/**
 * Created by rwadowski on 14.05.16.
 */
case class DataCenterConf(name: String, rf: Int) {

  def asText: String = s" '$name': $rf"
}
