package com.morgenrete.config.keyspace.replication

/**
 * Created by rwadowski on 14.05.16.
 */
case class SimpleStrategy(rf: Int) extends ReplicationConf{
  override def asText: String = s"{'class': 'SimpleStrategy', 'replication_factor': $rf}"
}
