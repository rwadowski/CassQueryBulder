package com.morgenrete.config.cf

/**
 * Created by rwadowski on 14.05.16.
 */
case class CFConf(opName: String,
                  name: String,
                  members: Iterable[ColumnConf],
                  key: KeyConf,
                  existsClause: Boolean = false,
                  options: Iterable[String])
