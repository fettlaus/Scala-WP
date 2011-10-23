package de.haw.scala.A3.T1

object Permutations {
  case class s(elm:Int*){
    def apply(num:Int) = elm(num-1)    
    override def toString = "s("+elm.mkString(",")+")"
    
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