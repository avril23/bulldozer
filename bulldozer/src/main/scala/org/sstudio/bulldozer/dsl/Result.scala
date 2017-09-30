package org.sstudio.bulldozer.dsl

object Result {

  private[this] var _code: Int = _
  private[this] var _body: String = _
  private[this] var _elapsedTime: Long = _

  def code: Int = _code

  def body: String = _body

  def elapsedTime: Long = _elapsedTime

  def setCode(code: Int): Unit = {
    _code = code
  }

  def setBody(body: String): Unit = {
    _body = body
  }

  def setElapsedTime(time: Long): Unit = {
    _elapsedTime = time
  }
}
