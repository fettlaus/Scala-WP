package de.haw.scala.A2.T1

object Aufgabe_1 {

  def main(args: Array[String]) {
    println(collatzIterative(23).mkString("Iterative: [", ", ", "]"))
    println(collatz(23).mkString("Recursive: [", ", ", "]"))
  }

  def collatz(n:Int): Array[Int] = {
    if (n == 1) Array(1)
    else if (n%2 == 0) n +: collatz(n/2)
    else n +: collatz(n*3+1)
  }
  
  def collatzIterative(n: Int): Array[Int] = {
    var arr = Array[Int]()
    var i = n
    while (i != 1) {
      arr = arr :+ i
      if (i%2 == 0) i = i/2
      else i = i*3+1
    }
    arr :+ i
  }
}
