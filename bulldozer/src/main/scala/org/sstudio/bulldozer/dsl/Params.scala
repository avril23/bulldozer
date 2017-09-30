package org.sstudio.bulldozer.dsl

object Params {

  private[this] var params: Map[String, Any] = Map.empty

  def :=(paramList: List[KeyValue]) : Params.type = {
    params = params.++(paramList.map(p => p.toKv))
    this
  }

  def toMap: Map[String, Any] = params
}