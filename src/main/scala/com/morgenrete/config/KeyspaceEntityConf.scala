package com.morgenrete.config

import com.morgenrete.config.keyspace.KeyspaceConf

/**
 * Created by rwadowski on 14.05.16.
 */
trait KeyspaceEntityConf {
  def asText(keyspaceConfig: KeyspaceConf): String
}
