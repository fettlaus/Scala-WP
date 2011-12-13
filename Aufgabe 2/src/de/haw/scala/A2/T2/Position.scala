package de.haw.scala.A2.T2

class Position(val x: Int = 0, val y: Int = 0) {
  def this(x: Int) = this(x, 0)
  if (x < 0 || y < 0)
    throw new IllegalArgumentException("x und y mÃ¼ssen grÃ¶Ãer/gleich Null sein!")
  override def toString = "Position(" + x + "," + y + ")"
}

object Position {
  def apply(x: Int, y: Int) = new Position(x, y)
}