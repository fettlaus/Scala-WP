package de.haw.scala.A5.T3

object NotInBothMain {

  def main(args: Array[String]): Unit = {
    println(notInBoth(List(1,2,5),List(7,2,3)))
  }
  
  def notInBoth[T](a1: Seq[T], a2: Seq[T]):Seq[T]= a1.diff(a2)++a2.diff(a1)

}