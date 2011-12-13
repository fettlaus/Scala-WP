package de.haw.scala.A5.T3

object NotInBothMain {

  def main(args: Array[String]): Unit = {
    println(notInBoth(List(1, 2, 5), List(7, 2, 3)))
  }
  /*
   * simple solution but not tailrec
  def notInBoth[T](a1: Seq[T], a2: Seq[T]):Seq[T]= a1.diff(a2)++a2.diff(a1)
  */
  def notInBoth[T](a1: Seq[T], a2: Seq[T]) = {
    import scala.annotation.tailrec
    @tailrec
    def myFold[T](map: Map[T, Boolean], list: Seq[T]): Map[T, Boolean] = {
      if (list.isEmpty)
        map
      else
        myFold(map.updated(list.head, !map.contains(list.head)), list.tail)
    }

    myFold(collection.immutable.HashMap(a1.map((_, true)).toList: _*), a2) collect {
      case (element, in) => element
    } toList
  }

}