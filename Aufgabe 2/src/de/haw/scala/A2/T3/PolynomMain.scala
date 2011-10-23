package de.haw.scala.A2.T3

object PolynomMain {

  def polynom(x:Integer,a:Integer*)= a.reduceLeft((a,b)=>a*x+b)
  
  def main(args: Array[String]): Unit = {  
    println(polynom(2,1,2,3,4,5))
  }

}