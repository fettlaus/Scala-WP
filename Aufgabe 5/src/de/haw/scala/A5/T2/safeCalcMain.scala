package de.haw.scala.A5.T2

object safeCalcMain {

  def safeCalc[A](func:(A=>A)*)(value:A):Either[Throwable,A]={
    try{
      if(func.length<1)
        throw new IllegalArgumentException("function-argument(s) missing")
    Right(func.foldLeft(value)((b,a)=>a(b)))
    }catch{
      case e => Left(e)
    }
  }
  
  def main(args: Array[String]): Unit = {
    println(safeCalc()())
    println(safeCalc((s:String)=>s.reverse)("Hallo"))
    println(safeCalc((s: String) => s.reverse,
    				(s: String) => s.toUpperCase,
					(s: String) => s.reverse)("Hallo"))
	println(safeCalc((x:Int) => x+1,(x: Int) => x*x)(2))
	println(safeCalc((x:Int) => x+1,(x: Int) => x*x, (x: Int) => 100/(x-9))(2))
	import scala.math._
	println(safeCalc((x:Double) => log(x),(x:Double) => exp(x))(10.0))
	println(safeCalc((x:Double) => log(x),(x:Double) => exp(x),
					(x:Double) => sqrt(-x))(10.0))
	println(safeCalc((p:Person) => Person(p.name.substring(5)))(Person("Otto")))
  }
  
  case class Person(val name:String)

}