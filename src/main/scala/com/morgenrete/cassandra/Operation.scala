package com.morgenrete.cassandra

/**
 * Created by rwadowski on 09.06.16.
 */
sealed trait Operation {

}

object Operation {

  case object Create extends Operation
  case object Alter extends Operation
  case object Update extends Operation


  def apply(name: String): Operation = Create
}
