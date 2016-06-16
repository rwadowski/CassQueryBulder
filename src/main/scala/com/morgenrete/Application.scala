package com.morgenrete

import com.typesafe.config.ConfigFactory

/**
 * Created by rwadowski on 14.05.16.
 */
object Application {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.load
    println(s"Running server on ${config.getInt("application.port")} port")
    val server = new Server(config)

    server.start()
  }
}
