package de.haw.scala.A2.T2

object ParallelTasks {
  object Task {
    def apply(code: => Unit): Task = new Task(code)
  }

  class Task (code: => Unit) extends Thread {
    def ||(other: Task): Task = { 
      if (!isAlive) start
      if (!other.isAlive) other.start
      other
    }

    override def run() = code
  }

  def main(args: Array[String]) {
    import Thread._
    println("1 2 3 4")
    Task(for (i <- 0 to 4) { sleep(300); println("o - - -") }) ||
    Task(for (i <- 0 to 3) { sleep(200); println("- o - -") }) ||
    Task(for (i <- 0 to 9) { sleep(100); println("- - o -") }) ||
    Task(for (i <- 0 to 3) { sleep(400); println("- - - o") })
  }
}