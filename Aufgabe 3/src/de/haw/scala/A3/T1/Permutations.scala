package de.haw.scala.A3.T1

object Permutations {
  case class s(elm:Int*){
    def apply(num:Int) = elm(num-1)    
    override def toString = "s("+elm.mkString(",")+")"
    
    def cycles = {
      val p = elm.diff(this.fixPoints)
      val r = for(i<-Vector(p)) // kein toVector :( 
          // Hier knirscht es noch arg
        //for(i <- p;if(i != p(i)))
        yield i
      r
    }
    
    def fixPoints = {
      val k = for(i<-elm.toIterable;if(this(i)==i))
            yield i
      k.toList
    }
  }
    
}