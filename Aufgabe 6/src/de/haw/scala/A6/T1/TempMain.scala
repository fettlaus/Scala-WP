package de.haw.scala.A6.T1

object TempMain {

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
      class op(x: Q) {
         def +(p: Q) = plus(x, p)
      }
   }
   object QMonoid {
      implicit object AddLength extends QMonoid[Length] {
         def plus(x: Length, y: Length): Length = Length(x.value + y.value)
      }
      implicit object AddTemperature extends QMonoid[Temperature] {
         def plus(x: Temperature, y: Temperature): Temperature = Temperature(x.value + y.value)
      }
      implicit object AddTime extends QMonoid[Time] {
         def plus(x: Time, y: Time): Time = Time(x.value + y.value)
      }
   }
   def add[Q <: Quantity](x: Q, y: Q)(implicit m: QMonoid[Q]): Q = m.plus(x, y)
   implicit def w[Q <: Quantity](k: Q)(implicit m: QMonoid[Q]): QMonoid[Q]#op = new m.op(k)

   case class Length(value: Double) extends Quantity { type unit = Meter }
   case class Temperature(value: Double) extends Quantity { type unit = Kelvin }
   case class Time(value: Double) extends Quantity { type unit = Second }

   def main(args: Array[String]): Unit = {
      println(add(Length(1), Length(2.7))) // Length(3.7)
      println(add(Temperature(273.15), Temperature(30.0))) // Temperature(303.15)
      println(add(Time(100), Time(50))) // Time(150.0)

      println(Length(1) + Length(2.7)) // Length(3.7)
      println(Temperature(273.15) + Temperature(30.0)) // Temperature(303.15)
      println(Time(100) + Time(50)) // Time(150.0)
   }
}