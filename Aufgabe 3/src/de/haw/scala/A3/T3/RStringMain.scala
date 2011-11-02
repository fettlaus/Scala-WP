package de.haw.scala.A3.T3

object RStringMain {

  def main(args: Array[String]): Unit = {
    val rs = RString("hello there")
    println(rs(1)) //101
    println(rs(1,3)) //ell
    println(rs(1 to 3)) //ell
    println(rs(-3,2)) //er
    println(rs(-4 to -2)) //her
    println(rs(-2 to -4)) //Rnil
    println(rs("th[aeiou]".r)) //the
    println(rs("lo")) //lo
    println(rs("bye")) //Rnil
    println(rs.scan("(...)".r).deep) //Array(hel, lo , the)
    println(rs.scan("lo").deep) //Array(lo)
    println(rs.scan("e").deep) // Array(e, e, e)
  }

}