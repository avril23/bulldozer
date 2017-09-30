package org.sstudio.bulldozer.utils

import org.joda.time.DateTime

final class StopWatchUtil {

  private var _startTime = 0L
  private var _elapsedTime = 0L

  def elapsedTime: Long = _elapsedTime

  def start(): DateTime = {
    _startTime = System.currentTimeMillis()
    DateTime.now()
  }

  def stop(): Long = {
    if (_startTime == 0L) {
      throw new Exception("Please start stopwatch first")
    }
    val endTime = System.currentTimeMillis()
    val diff = endTime - _startTime
    _elapsedTime = diff
    diff
  }
}