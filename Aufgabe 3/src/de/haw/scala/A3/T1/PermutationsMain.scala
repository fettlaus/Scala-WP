package de.haw.scala.A3.T1

/**
 * @author Arne Wischer <Fettlaus@gmail.com>
 *
 */
object PermutationsMain {

  def main(args: Array[String]): Unit = {
    import Permutations._
    val s1 = s(2, 4, 5, 1, 3)
    val s2 = s(2, 4, 5, 1, 3)
    val s3 = s(2, 4, 1, 5, 3)
    println(s1) // s(2,4,5,1,3)
    println(s1 == s2) // true
    println(s1 == s3) // false   
    println(s1(3)) // 5
    println(s3(3)) // 1
    println(s1 cycles) // Vector(List(1,2,4),List(3,5))
    println(s3 cycles) // Vector(List(1,2,4,5,3))
    println(s(1, 2, 3, 4, 5) fixPoints) // List(1,2,3,4,5)
    val err1 = s(2, 5, 8, 5, 4, 6, 3)
    val err2 = s(2, 5, 8, 5, 4, 6, 3, 1)
    println(err1) // NaP
    println(err2) // NaP

    println(NaP cycles) // Vector(List())

    println(NaP fixPoints) // List()

    println(NaP(10)) // -1

    def foo (f: Int => Int, g: Int => Double, x: Int) = g(f(x)) 
    println(foo(s(1,6,4,2,3,5), Array(1.0,-1.0,1,4.0,-3.0), 4)) //1.0

  }

}