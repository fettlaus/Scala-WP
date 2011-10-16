package de.haw.scala.A2.T2

class Position(val x:Integer = 0,val y:Integer = 0) {
  def this(x: Integer) = this(x,0)
  if (x<0||y<0)
    throw new IllegalArgumentException("x und y müssen größer/gleich Null sein!")
  override def toString = "Position("+x+","+y+")"
}

object Position{
  def apply(x:Integer,y:Integer) = new Position(x,y)
}