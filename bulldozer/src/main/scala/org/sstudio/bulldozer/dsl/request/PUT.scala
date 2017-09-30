package org.sstudio.bulldozer.dsl.request

import akka.http.scaladsl.model.{HttpMethod, HttpMethods, HttpRequest, Uri}

import org.sstudio.bulldozer.dsl.{Headers, Params}

object PUT extends TRequest {

  override protected def method: HttpMethod = HttpMethods.PUT

  override protected def makeRequest(uri: Uri): HttpRequest = {
    val headers = Headers.toList
    val params = Params.toMap
    val request = HttpRequest(method, uri, headers)
    setBody(request, params)
  }
}