package org.sstudio.bulldozer.build

import sbt._

object Resolvers {
  private[this] val mvn2 = Resolver.url("mvn 2", url("http://central.maven.org/maven2"))
  private[this] val typesafeRepo = Resolver.url("Typesafe Repository", url("http://repo.typesafe.com/typesafe/releases/"))
  //  private[this] val conjarsRepo = Resolver.url("conjars", url("http://conjars.org/repo/"))
  val list: Seq[Resolver] = Seq(mvn2, typesafeRepo)
}