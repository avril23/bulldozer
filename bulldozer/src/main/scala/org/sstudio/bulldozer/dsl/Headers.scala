package org.sstudio.bulldozer.dsl

import akka.http.scaladsl.model.HttpHeader
import akka.http.scaladsl.model.headers.RawHeader

object Headers {

  private[this] var headers: Map[String, String] = Map.empty

  def :=(headerList: List[KeyValue]): Headers.type = {
    headers = headers.++(headerList.map(p => p.toKvStr))
    this
  }

  def toList: List[HttpHeader] = {
    headers.map(h => RawHeader(h._1, h._2)).toList
  }
}
