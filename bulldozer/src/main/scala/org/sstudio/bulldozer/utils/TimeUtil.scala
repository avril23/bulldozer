package org.sstudio.bulldozer.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}
import org.joda.time._
import org.joda.time.format.DateTimeFormat

object TimeUtil {

  def defaultFormatPattern: String = "yyyy-MM-dd HH:mm:ss.SSS"

  def getNowTimeStamp: String = {
    DateTime.now().toString("MM/dd/yyyy hh:mm:ss")
  }

  def getNowTimeStamp(pattern: String): String = DateTime.now().toString(pattern)

  def getTimeStamp: String = {
    DateTime.now().toString("yyyyMMddHHmmss")
  }

  def addMinutes(ts: Timestamp, minutes: Int): Timestamp = {
    val cal = Calendar.getInstance()
    cal.setTime(ts)
    cal.add(Calendar.MINUTE, minutes)
    val date = cal.getTime
    convertToTimestamp(date)
  }

  def convertToTimestamp(d: Date): Timestamp = {
    val sdf = new SimpleDateFormat(defaultFormatPattern)
    val time = sdf.format(d)
    Timestamp.valueOf(time)
  }

  def convertToTimestamp(dateStr: String): Timestamp = {
    Timestamp.valueOf(dateStr)
  }

  def convertToDateTime(ts: Timestamp): DateTime = {
    val sdf = new SimpleDateFormat(defaultFormatPattern)
    val tsString = sdf.format(ts)
    val df = DateTimeFormat.forPattern(defaultFormatPattern)
    DateTime.parse(tsString, df)
  }

  def getDateTimeMax: DateTime = {
    //yyyy-mm-dd hh:mm:ss[.fffffffff]
    val maxDateTimeStr = "2099-12-31 23:59:59"
    convertToDateTime(convertToTimestamp(maxDateTimeStr))
  }

  def formatDateString(dateStr: String, formatter: String): String = {
    try {
      val df = DateTimeFormat.forPattern(defaultFormatPattern)
      val dateTime = DateTime.parse(dateStr, df)
      dateTime.toString(formatter)
    }
    catch {
      case ex: Exception => println(ex.getStackTrace.mkString("\n"))
        dateStr
    }
  }
}
