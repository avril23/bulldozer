package org.sstudio.bulldozer

import scala.io.Source
import scala.tools.reflect.ToolBox
import java.io.{File, FilenameFilter}
import scala.reflect.runtime.currentMirror

import org.sstudio.bulldozer.exceptions.InvalidDirPathException

private[bulldozer] object TestCaseManager {

  private[this] def getFiles(dirPath: String): List[File] = {
    val dir = new File(dirPath)
    if (dir.isDirectory) {
      val files = dir.listFiles(new FilenameFilter {
        override def accept(dir: File, name: String): Boolean = name.endsWith(".case")
      })
      files.toList.sortBy(f => f.getName)
    } else {
      throw new InvalidDirPathException(s"Path: '$dirPath' is not a directory.")
    }
  }

  def genSourceCode(file: File): String = {
    val sourceCode = Source.fromFile(file).mkString
"""
import org.sstudio.bulldozer.dsl._
import org.sstudio.bulldozer.dsl.Assert._
import org.sstudio.bulldozer.dsl.request._
import org.sstudio.bulldozer.dsl.Implicits._
import org.sstudio.bulldozer.utils.JsonUtil._

"""+ sourceCode
  }

  def runCase(fileCase: File): Long = {
    try {
      val toolbox = currentMirror.mkToolBox()
      val code = genSourceCode(fileCase)
      val tree = toolbox.parse(code)
      val result = toolbox.eval(tree)
      result.asInstanceOf[Long]
    } catch {
      case ex: Exception =>
        val internalEx = ex.getCause
        if (internalEx != null) {
          internalEx match {
            case assertEx: AssertionError =>
              println(Console.RED + "[Assert Error] " + assertEx.toString)
          }
        } else {
          println(Console.RED + "[ERROR] " + ex.getMessage)
          println(Console.RED + "[StackTrace] " + ex.getStackTrace.mkString("\n\t"))
        }
        -1
    }
  }

  def runCases(dir: String): Unit = {
    val files = getFiles(dir)
    println(s"discovered ${files.size} test cases.")
    println(s"starting run test cases...")
    var map = Map.empty[String, Long]
    for (file <- files) {
      val caseName = file.getName.replace(".case", "")
      println(Console.GREEN + s"[INFO] running test case: $caseName.")
      val elapsedTime = runCase(file)
      println(Console.GREEN + s"[INFO] case name: $caseName, elapsedTime: $elapsedTime.")
      map = map.+(caseName -> elapsedTime)
    }
    println(Console.GREEN + "================")
    map.foreach(kv => {
      if (kv._2 == -1) {
        println(Console.RED + kv._1 + "\t" + kv._2 + "ms")
      } else {
        println(Console.YELLOW + kv._1 + "\t" + kv._2 + "ms")
      }
    })
  }
}
