package org.sstudio.bulldozer.dsl

final class KeyValue(key: String) {

  private[this] val _key = key
  private[this] var _value: Any = _

  def :=(value: Any): KeyValue = {
    _value = value
    this
  }

  def toKv: (String, Any) = {
    _key -> _value
  }

  def toKvStr: (String, String) = {
    _key -> _value.toString
  }

  def ~(kv: KeyValue): KeyValue = {
    this
  }
}
