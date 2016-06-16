name := "CassQueryBuilder"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies += "org.mockito" % "mockito-all" % "1.9.5"
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
)

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.7"
libraryDependencies += "com.typesafe.akka" %% "akka-http-core" % "2.4.7"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.4.7"
libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.4.7"
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.7"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.6"