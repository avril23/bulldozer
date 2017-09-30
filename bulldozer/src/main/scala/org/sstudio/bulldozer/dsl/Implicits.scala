package org.sstudio.bulldozer.dsl

import org.sstudio.bulldozer.dsl.compare._
import org.sstudio.bulldozer.dsl.compare.{AnyCompare, IntCompare, StringCompare}


// noinspection ScalaStyle
// scalastyle:off
object Implicits {

  implicit def toParam(str: String): KeyValue = new KeyValue(str)

  implicit def toList1(kvs: KeyValue): List[KeyValue] = List(kvs)

  implicit def toList2(kvs: (KeyValue, KeyValue)): List[KeyValue] = List(kvs._1, kvs._2)

  implicit def toList3(kvs: (KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3)
  }

  implicit def toList4(kvs: (KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4)
  }

  implicit def toList5(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5)
  }

  implicit def toList6(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6)
  }

  implicit def toList7(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7)
  }

  implicit def toList8(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8)
  }

  implicit def toList9(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9)
  }

  implicit def toList10(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10)
  }

  implicit def toList11(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11)
  }

  implicit def toList12(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12)
  }

  implicit def toList13(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13)
  }

  implicit def toList14(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14)
  }

  implicit def toList15(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15)
  }

  implicit def toList16(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15, kvs._16)
  }

  implicit def toList17(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15, kvs._16, kvs._17)
  }

  implicit def toList18(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15, kvs._16, kvs._17, kvs._18)
  }

  implicit def toList19(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15, kvs._16, kvs._17, kvs._18, kvs._19)
  }

  implicit def toList20(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15, kvs._16, kvs._17, kvs._18, kvs._19, kvs._20)
  }

  implicit def toList21(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15, kvs._16, kvs._17, kvs._18, kvs._19, kvs._20, kvs._21)
  }

  implicit def toList22(kvs: (KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue, KeyValue)): List[KeyValue] = {
    List(kvs._1, kvs._2, kvs._3, kvs._4, kvs._5, kvs._6, kvs._7, kvs._8, kvs._9, kvs._10, kvs._11, kvs._12, kvs._13, kvs._14, kvs._15, kvs._16, kvs._17, kvs._18, kvs._19, kvs._20, kvs._21, kvs._22)
  }

  implicit def toIntCompare(int: Int): IntCompare = {
    new IntCompare(int)
  }

  implicit def toStrCompare(str: String): StringCompare = {
    new StringCompare(str)
  }

  implicit def toAnyCompare(any: Any): AnyCompare = {
    new AnyCompare(any)
  }
}

// scalastyle:on