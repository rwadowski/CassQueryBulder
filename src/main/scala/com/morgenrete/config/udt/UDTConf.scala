package com.morgenrete.config.udt

/**
 * Created by rwadowski on 15.05.16.
 */
case class UDTConf(opName: String, name: String, members: Iterable[UDTMember], existsClause: Boolean = false)
