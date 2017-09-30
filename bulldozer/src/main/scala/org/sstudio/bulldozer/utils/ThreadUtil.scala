package org.sstudio.bulldozer.utils

import java.util.concurrent.{ExecutorService, Executors}

import scala.concurrent.ExecutionContext

object ThreadUtil {

  implicit val dataCanvasEc = new ExecutionContext {

    val threadPool: ExecutorService = Executors.newCachedThreadPool()

    def execute(runnable: Runnable): Unit = threadPool.submit(runnable)

    def reportFailure(t: Throwable) {}
  }
}
