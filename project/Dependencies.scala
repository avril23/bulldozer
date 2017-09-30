package org.sstudio.bulldozer.build

import sbt._

object Dependencies {

  private[this] val akkaHttpVersion = "10.0.9"
  private[this] val json4sVersion = "3.5.3"

  val scalaCompiler: ModuleID = "org.scala-lang" % "scala-compiler" % "2.11.11"
  val typesafeConfig: ModuleID = "com.typesafe" % "config" % "1.3.0"
  val jodaTime: ModuleID = "joda-time" % "joda-time" % "2.3"
  val akka: ModuleID = "com.typesafe.akka" %% "akka-actor" % "2.4.14"
  val akkaHttp: ModuleID = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  val akkaHttpCore: ModuleID = "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion
  val scalaj: ModuleID = "org.scalaj" % "scalaj-http_2.11" % "2.3.0"
  val json4s: ModuleID = "org.json4s" % "json4s-native_2.11" % json4sVersion
}