package com.morgenrete.config.keyspace

/**
 * Created by rwadowski on 14.05.16.
 */
case class DurableWritesConf(enabled: Boolean = true) {

  def asText: String = s"DURABLE_WRITES = $enabled"
}
