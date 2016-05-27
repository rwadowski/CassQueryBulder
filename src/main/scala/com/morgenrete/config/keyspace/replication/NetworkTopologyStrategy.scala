package com.morgenrete.config.keyspace.replication

/**
 * Created by rwadowski on 14.05.16.
 */
object NetworkTopologyStrategy {

  def apply(map: Map[String, Int]): NetworkTopologyStrategy = {
    new NetworkTopologyStrategy(map.map{case (dc, rf) => dc -> DataCenterConf(dc, rf)}.values)
  }
}

class NetworkTopologyStrategy(dataCenters: Iterable[DataCenterConf]) extends ReplicationConf{
  override def asText: String = {
    val dcAsText = dataCenters.map(_.asText).mkString(",")
    s"{'class': 'NetworkTopologyStrategy', $dcAsText}"
  }
}
