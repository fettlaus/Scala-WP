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

object Haller extends Sex with Person with Student {

  val male = true
  val name = "Olaf Haller"
  // addr missing in toString
  val addr = "irrelevant"
  val matr = 123456
  def inlecture = util.Random.nextBoolean
  override def toString = "Haller(" + name + "," + (if (male) "m" else "f") + "," + matr + ",studiert" + (if (inlecture) "" else " nicht") + ")"

}

object HallerMain {
  def main(args: Array[String]): Unit = for (i <- 1 to 5) println(Haller)
}