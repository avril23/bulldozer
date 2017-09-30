package org.sstudio.bulldozer.dsl.request

import akka.http.scaladsl.model.{HttpMethod, HttpMethods, HttpRequest, Uri}
import org.sstudio.bulldozer.dsl.{Headers, Params}

object GET extends TRequest {

  override protected def method: HttpMethod = HttpMethods.GET

  override protected def makeRequest(uri: Uri): HttpRequest = {
    val headers = Headers.toList
    val params = Params.toMap
    val uriWithParams = if (params.isEmpty) {
      uri
    } else {
      val queryString = params./:("")((ret, kv) => ret + kv._1 + "=" + kv._2.toString + "&")
      uri.withRawQueryString(queryString.substring(0, queryString.length - 1))
    }
    HttpRequest(method, uriWithParams, headers)
  }
}

