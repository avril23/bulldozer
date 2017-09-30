package org.sstudio.bulldozer

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Const {

  private[bulldozer] implicit lazy val ACTOR_SYSTEM = ActorSystem("BulldozerSystem")
  private[bulldozer] implicit lazy val ACTOR_MATERIALIZER = ActorMaterializer()
}
