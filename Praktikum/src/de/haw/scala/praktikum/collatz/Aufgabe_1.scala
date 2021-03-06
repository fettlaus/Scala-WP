package de.haw.scala.praktikum.collatz

object Aufgabe_1 {

  def main(args: Array[String]) {
    println(collatzIterative(23).mkString("Iterative: [", ", ", "]"))
    println(collatz(23).mkString("Recursive: [", ", ", "]"))
    println(collatzAppend(23).mkString("Append: [", ", ", "]"))
  }

  def collatz(n: Int): Array[Int] = {
    if (n == 1) Array(1)
    else if (n % 2 == 0) n +: collatz(n / 2)
    else n +: collatz(n * 3 + 1)
  }

  def collatzIterative(n: Int): Array[Int] = {
    var arr = Array[Int]()
    var i = n
    while (i != 1) {
      arr = arr :+ i
      if (i % 2 == 0) i = i / 2
      else i = i * 3 + 1
    }
    arr :+ i
  }

  def collatzAppend(n: Int): Array[Int] = {
    import scala.collection.mutable.ArrayBuffer
    def colHelp(n: Int): ArrayBuffer[Int] = {
      if (n == 1) ArrayBuffer(1)
      else if (n % 2 == 0) colHelp(n / 2) += n
      else colHelp(3 * n + 1) += n
    }
    colHelp(n).reverse.toArray
  }
}
