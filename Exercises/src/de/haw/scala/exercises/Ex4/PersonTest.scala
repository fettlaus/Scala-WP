package de.haw.scala.exercises.Ex4

object PersonTest {

  def main(args: Array[String]) {
    val a = Array(new Person("She-Ra"), new Person("He-Man"), new Person("Skeletor"))
    println(a.mkString("Array(", ",", ")"))
    a(1).address = "Grayskull"
    println(a.mkString("Array(", ",", ")"))
  }

  class Person(val name: String, var address: String = "HH", var age: Int = 30) {
    override def toString = "Person(" + name + "," + address + "," + age + ")"
  }
}