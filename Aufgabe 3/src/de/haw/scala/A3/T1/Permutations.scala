package de.haw.scala.A3.T1

/**
 * @author Arne Wischer <Fettlaus@gmail.com>
 *
 * Sources:
 * http://daily-scala.blogspot.com/2009/11/varargs.html
 * http://fupeg.blogspot.com/2009/04/tail-recursion-in-scala.html
 * http://www.scala-lang.org/api/current/scala/collection/immutable/Vector$.html
 */
object Permutations {
  object NaP extends s{
    override def toString = "NaP"
      override def apply(x:Int) = -1
  }
  object s{
    def apply(elm:Int){ this(elm)}
    def apply(elms:Int*) = {
     if(elms.distinct.sorted!=elms.sorted)
       NaP
     else
       new s(elms:_*)
    }
  }
  class s(val elm:Int*){
    def apply(num:Int) = elm(num-1)
    
    override def toString = "s("+elm.mkString(",")+")"
    override def equals(in:Any)={
      in match{
        case k:s if(k.elm==elm) => true
        case _=> false
      }
    }
    def cycles = {      
      val r = for(i<-Vector(elm:_*)) // kein toVector :(        
        yield {
        def cy(k:Int,l:List[Int]):List[Int]={
          if(this(k)==i)
            l
          else
            this(k)::cy(this(k),l)
      }
        cy(i,i::List()).sorted
      }      
      r.distinct
    }
    
    def fixPoints = {
      val k = for(i<-elm.toIterable;if(this(i)==i))
            yield i
      k.toList
    }
}
    
}