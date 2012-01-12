package de.haw.scala.A6.T1

object TempMain {

   def main(args: Array[String]): Unit = {
      println(add(Length(1),Length(2.7)))                   // Length(3.7)
      println(add(Temperature(273.15),Temperature(30.0)))   // Temperature(303.15)
      println(add(Time(100),Time(50)))                      // Time(150.0)
    
      println(Length(1)+Length(2.7))                        // Length(3.7)
      println(Temperature(273.15)+Temperature(30.0))        // Temperature(303.15)
      println(Time(100)+Time(50))                           // Time(150.0)
   }
   trait BaseUnit
   trait Meter extends BaseUnit
   trait Kelvin extends BaseUnit
   trait Second extends BaseUnit
   trait Quantity {
      type unit <: BaseUnit
      def value: Double
   }
   trait QMonoid[Q <: Quantity] {
      def plus(x: Q, y: Q): Q 
   }

}