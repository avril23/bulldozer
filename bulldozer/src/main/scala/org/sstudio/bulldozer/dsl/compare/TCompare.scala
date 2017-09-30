package org.sstudio.bulldozer.dsl.compare

import org.sstudio.bulldozer.dsl.Result

trait TCompare[T] {

  var v: T = _

  def ===(value: T): Long = {
    assert(v == value, s"value('$v') is not excepted('$value').")
    Result.elapsedTime
  }
}
