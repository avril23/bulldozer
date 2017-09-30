package org.sstudio.bulldozer.utils

import java.nio.ByteBuffer

object BinaryUtil {

  private[this] val UTF8_ENCODING = "utf-8"

  def decode(data: Array[Byte]): String = decode(data, 0, data.length)

  def decode(data: Array[Byte], offset: Int, length: Int): String = {
    new String(data, offset, length, UTF8_ENCODING)
  }

  def toShort(data: Array[Byte]): Short = toShort(data, 0, data.length)

  def toShort(data: Array[Byte], offset: Int, length: Int): Short = {
    ByteBuffer.wrap(data, offset, length).getShort
  }

  def toInt(data: Array[Byte]): Int = toInt(data, 0, data.length)

  def toInt(data: Array[Byte], offset: Int, length: Int): Int = {
    ByteBuffer.wrap(data, offset, length).getInt
  }

  def toStrLine(data: Array[Byte]): String = data.mkString(",")

  def toBytes(x: Int): Array[Byte] = {
    val buf = new Array[Byte](4)
    buf(0) = (x >>> 24).asInstanceOf[Byte]
    buf(1) = (x >>> 16).asInstanceOf[Byte]
    buf(2) = (x >>> 8).asInstanceOf[Byte]
    buf(3) = x.asInstanceOf[Byte]
    buf
  }

  def toBytes(x: Short): Array[Byte] = {
    val buf = new Array[Byte](2)
    buf(0) = (x >>> 8).toByte
    buf(1) = x.toByte
    buf
  }

  def toBytes(x: String): Array[Byte] = {
    val len = x.length
    val buf = new Array[Byte](len)
    for (i <- 0 until len)
      buf(i) = x(i).toByte
    buf
  }
}