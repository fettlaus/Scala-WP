package de.haw.scala.A2.T2

object PositionMain {
  def main(args: Array[String]): Unit = {
    println(new Position(3, 4))
    val p1 = new Position()
    println(p1.x + ", " + p1.y)
    val p2 = new Position(3)
    println(p2.x + ", " + p2.y)
    println(new Position(-1, 4))
  }
}