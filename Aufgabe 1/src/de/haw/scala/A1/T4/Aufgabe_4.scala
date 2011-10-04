package de.haw.scala.A1.T4

object Aufgabe_4 {
  
  def max(a:Array[Int])={a.max}
  def max(a:Int,b:Int)={if(a>b)a else b}
  def swap(a:Int,b:Int)=(b,a)
  
  def main(args: Array[String]): Unit = {  
    println(max(1,5))
    println(max(Array(2,8,5,0,454,2,12,53)))
    Array("Hallo ","Welt","!").foreach(print)
    println()
    List("Hallo ","Welt","!").foreach(print)
    println()
    println(swap(3,9))
  }

}