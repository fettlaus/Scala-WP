package de.haw.scala.A4.T2

object ListMain {
	def sequenceOption[A](lst: List[Option[A]]): Option[List[A]] ={
	  if(lst.contains(None)) None
	  else Some(lst.flatMap(a => a))
	}
  def main(args: Array[String]): Unit = {  
    println(sequenceOption(List(Some(1),Some(2),None))) // None
    println(sequenceOption(List(Some("Hallo"),Some("Welt")))) // Some(List(Hallo, Welt))
  }

}