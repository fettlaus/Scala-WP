package de.haw.scala.A2.T4

// some sources:
// http://dotneverland.blogspot.com/2009/09/quick-sample-of-lists-and-tuples-in.html
// http://stackoverflow.com/questions/2627919/scala-how-can-i-sort-an-array-of-tuples-by-their-second-element
// http://alan.dipert.org/post/307586762/polyglot-folding-ruby-clojure-scala

object Rundreise {
  def distance(c1:Int,c2:Int)=100/(if(c1>c2)(c1-c2)else(c2-c1))
  
  def main(args: Array[String]): Unit = {
  val l = List(1,2,3,4)
  val k = for(i<-l.permutations)
    yield i.zip(i.tail).foldLeft(List[Int]())((list,b)=>distance(b._1,b._2)::list).sum
  println(l.permutations.zip(k).toList.sortBy(_._2).head)
  }
}