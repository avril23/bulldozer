package org.sstudio.bulldozer.dsl

object Assert {

  private[this] var _code: Int = _
  private[this] var _body: String = _

  def code: Int = {
    _code = Result.code
    Result.code
  }

  def body: String = {
    _body = Result.body
    Result.body
  }

  def apply(expr: Long): Long = {
    expr
  }
}