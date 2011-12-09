package de.haw.scala.A5.T1

object EitherListMain {

  def main(args: Array[String]): Unit = {  
    val customers = List(Left(Person("P1")),Left(Person("P2")),
    					Right(Company(Person("CEO1"))), Left(Person("P3")),
    					Right(Company(Person("CEO2"))),Right(Company(Person("CEO3"))),
    					Left(Person("P3")))
	println(customers);
    println(customers.partition(_.isLeft))
    println(customers.flatMap(_.left.toSeq))
    println(customers.flatMap(_.right.toSeq))
  }
  
  case class Company(person:Person)
  case class Person(name:String)

}