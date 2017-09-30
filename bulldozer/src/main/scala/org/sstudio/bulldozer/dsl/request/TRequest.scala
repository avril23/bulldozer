package org.sstudio.bulldozer.dsl.request

import scala.collection._
import akka.util.ByteString
import scala.concurrent.Await
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import org.sstudio.bulldozer.dsl.Result
import org.sstudio.bulldozer.utils.JsonUtil._
import org.sstudio.bulldozer.utils.StopWatchUtil
import org.sstudio.bulldozer.Const.{ACTOR_MATERIALIZER, ACTOR_SYSTEM}

trait TRequest {

  private[this] val READ_TIMEOUT = 90.seconds

  protected def method: HttpMethod

  protected def makeRequest(uri: Uri): HttpRequest

  protected def setBody(request: HttpRequest, params: Map[String, Any]): HttpRequest = {
    val entity = HttpEntity(ContentTypes.`application/json`, params.asJson)
    request.withEntity(entity)
  }

  protected def doRequest(request: HttpRequest): HttpResponse = {
    val req = request.withMethod(method)
    val stopWatch = new StopWatchUtil()
    stopWatch.start()
    val response = Await.result[HttpResponse](Http().singleRequest(req), READ_TIMEOUT)
    val elapsedTime = stopWatch.stop()
    Result.setElapsedTime(elapsedTime)
    response
  }

  def >>(uri: String): this.type = {
    val request = makeRequest(uri)
    val resp = doRequest(request)
    Result.setCode(resp.status.intValue())
    resp.entity.dataBytes.runFold(ByteString(""))(_ ++ _).foreach(body => {
      Result.setBody(body.utf8String)
    })
    this
  }
}
