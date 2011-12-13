package de.haw.scala.A3.T1

/**
 * @author Arne Wischer <Fettlaus@gmail.com>
 *
 * Sources:
 * http://daily-scala.blogspot.com/2009/11/varargs.html
 * http://fupeg.blogspot.com/2009/04/tail-recursion-in-scala.html
 * http://www.scala-lang.org/api/current/scala/collection/immutable/Vector$.html
 * http://jim-mcbeath.blogspot.com/2009/05/scala-functions-vs-methods.html
 */
object Permutations {
  object NaP extends s {
    override def toString = "NaP"
    override def apply(x: Int) = -1
    override def cycles = Vector(List[Int]())
  }
  object s {
    def apply(elm: Int) { this(elm) }
    def apply(elms: Int*) = {
      if (elms.distinct.sorted != elms.sorted)
        NaP
      else
        new s(elms: _*)
    }
  }
  class s(val elm: Int*) extends Function1[Int, Int] {
    def apply(num: Int): Int = elm(num - 1)

    override def toString = "s(" + elm.mkString(",") + ")"
    override def equals(in: Any) = {
      in match {
        case k: s if (k.elm == elm) => true
        case _ => false
      }
    }

    /**
     * Idea new code by Christian Braun
     */
    def cycles = {
      import scala.annotation._
      @tailrec def cy(s: Int, k: Int, l: List[Int]): List[Int] = {
        if (k == s) l else cy(s, this(k), k :: l)
      }
      elm.foldLeft(Vector[List[Int]]())((p, q) => if (p.flatten.contains(q)) p else p :+ cy(q, this(q), List(q)))
      //old/own code
      /*
      val r = for (i <- Vector(elm: _*))     
      yield {
        @tailrec def cy(k: Int, l: List[Int]): List[Int] = {
          if (k == i)
            l
          else
            cy(this(k),k:: l)
        }
        cy(this(i), i :: List()).sorted
      }
      r.distinct
      */
    }

    def fixPoints = {
      val k = for (i <- elm.toIterable; if (this(i) == i))
        yield i
      k.toList
    }
  }

}