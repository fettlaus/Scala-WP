package de.haw.scala.A2.T1

trait Sex {
  val male: Boolean
}

trait Person {
  val name: String
  val addr: String
}

trait Student {
  val matr: Int
  def inlecture: Boolean
}

object Haller extends Sex with Person with Student{
   
  val male = true
  val name = "Olaf Haller"
  val addr = "123456"
  val matr = 123456
  import Math._
  def inlecture = if (random > 0.5) true else false
  override def toString = "Haller("+name+","+(if(male) "m" else "f")+","+matr+",studiert"+(if(inlecture)""else" nicht")+")"

}

object HallerTest{
    def main(args: Array[String]): Unit = for(i <-1 to 5) println(Haller) 
}