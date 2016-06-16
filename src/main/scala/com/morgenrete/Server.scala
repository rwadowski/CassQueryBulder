package com.morgenrete

/**
 * Created by rwadowski on 09.06.16.
 */

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.config.Config

class Server(val config: Config) {

  implicit val system = ActorSystem()
  implicit val actorMaterializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val route =
    path("test") {
      get {
        complete("Hi")
      }
    }

  def start(): Unit = {
    val port = config.getInt("application.port")
    val bindingFuture = Http().bindAndHandle(route, "localhost", port)
    sys.addShutdownHook({
      bindingFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())
    })
  }
}
