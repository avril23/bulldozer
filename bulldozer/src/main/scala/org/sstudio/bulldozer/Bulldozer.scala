package org.sstudio.bulldozer

object Bulldozer {

  def printHelp(): Unit = {
    val helpInfo =
      """
      -------------------------------------
      | Help
      |  command: --cases [folder: String]
      -------------------------------------
      """
    println(Console.YELLOW + helpInfo)
  }

  def main(args: Array[String]): Unit = {
    args.length match {
      case 2 =>
        val (command, dir) = (args(0), args(1))
        if (command == "--cases") {
          TestCaseManager.runCases(dir)
        } else {
          printHelp()
        }
      case _ => printHelp()
    }
  }
}




