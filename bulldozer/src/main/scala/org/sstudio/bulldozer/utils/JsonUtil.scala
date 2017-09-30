package org.sstudio.bulldozer.utils

import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

object JsonUtil {

  private[this] implicit val formats: Formats = Serialization.formats(NoTypeHints)

  implicit class AnyRefExt(obj: AnyRef) {
    println("obj in anyRefExt")
    println(obj)

    private[this] type Json = Map[String, Any]

    def asJson: String = {
      write(obj)
    }

    def decode: Json = {
      if (obj.isInstanceOf[Json]) {
        obj.asInstanceOf[Json]
      } else {
        parse(obj.toString).extract[Json]
      }
    }
  }

  implicit class AnyExt(obj: Any) {
    println("obj in anyExt")
    println(obj)

    private[this] type Json = Map[String, Any]

    def asJson: String = {
      write(obj.toString)
    }

    def decode: Json = {
      if (obj.isInstanceOf[Json]) {
        obj.asInstanceOf[Json]
      } else {
        parse(obj.toString).extract[Json]
      }
    }
  }

  def decode[T: Manifest](jsonStr: String): Option[T] = {
    parse(jsonStr).extractOpt[T]
  }
}