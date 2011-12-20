package de.haw.scala.A5.T3

object NotInBothMain {

  def main(args: Array[String]): Unit = {
    println(notInBoth(List(1, 2, 5), List(7, 2, 3)))
  }
  /*
   * simple solution but not tailrec
  def notInBoth[T](a1: Seq[T], a2: Seq[T]):Seq[T]= a1.diff(a2)++a2.diff(a1)
  */
  
  /*
   * Lösung von Nils Evers
   */
  def notInBoth[T](a1: Seq[T], a2: Seq[T]): Seq[T] = {
    import collection.immutable.HashSet 
    import scala.annotation.tailrec
    @tailrec
    def nib[T](s1: HashSet[T], s2:HashSet[T], res: HashSet[T]): HashSet[T] = {
        if(s1.isEmpty) return s2 ++ res
        if(s2(s1.head)) nib(s1.tail, s2-s1.head, res)
        else nib(s1.tail, s2-s1.head, res+s1.head)
    }
    nib(HashSet() ++ a1, HashSet() ++ a2, HashSet()).toList
}

}