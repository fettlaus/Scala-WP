package de.haw.scala.exercises.Ex4

object TypeCount {
  def main(args: Array[String]): Unit = {
    println(count(true, (), (), false, 'a', 1.0, 2, true, 2L, 1F, 10:Byte));
  }
  def count[N <: AnyVal](vals: N*): Tuple4[Int, Int, Int, Int] = {
    vals.foldLeft((0, 0, 0, 0))((c, e) => e match {
      case _: Unit 		=> (c._1 + 1, c._2, c._3, c._4);
      case _: Boolean 	=> (c._1, c._2 + 1, c._3, c._4);
      case _: Double 	=> (c._1, c._2, c._3, c._4 + 1);
      case _: Float 	=> (c._1, c._2, c._3, c._4 + 1);
      case _ 			=> (c._1, c._2, c._3 + 1, c._4);
    });
  }
}
