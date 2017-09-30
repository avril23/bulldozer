package org.sstudio.bulldozer.dsl.compare

import org.sstudio.bulldozer.dsl.Result

final class AnyCompare(any: Any) extends TCompare[Any] {
  v = any

  override def ===(value: Any): Long = {
    value match {
      case i: Int => super.===(i)
      case str: String => super.===(str)
      case b: Boolean => super.===(b)
      case f: Float => super.===(f)
      case d: Double => super.===(d)
      case bd: BigDecimal => super.===(bd)
      case _ => throw new Exception("Not accepted type.")
    }
    Result.elapsedTime
  }
}
