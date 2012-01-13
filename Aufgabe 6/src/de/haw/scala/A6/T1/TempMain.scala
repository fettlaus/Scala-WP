package de.haw.scala.A6.T1
import com.sun.org.apache.xpath.internal.operations.Plus
import scala.runtime.ObjectRef

object TempMain {

   trait BaseUnit
   trait Meter extends BaseUnit
   trait Kelvin extends BaseUnit
   trait Second extends BaseUnit
   trait Quantity {
      type unit <: BaseUnit
      def value: Double
      def +[Q <: Quantity](derp: Q) = {
         derp match {
            case derp: Length => Length(value + derp.value)
            case derp: Temperature => Temperature(value + derp.value)
            case derp: Time => Time(value + derp.value)
         }
      }
   }
   trait QMonoid[Q] {
      def plus(x: Q, y: Q): Q
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
   def add[Q: QMonoid](x: Q, y: Q): Q = implicitly[QMonoid[Q]].plus(x, y)

   case class Length(value: Double) extends Quantity { type unit = Meter }
   case class Temperature(value: Double) extends Quantity { type unit = Kelvin }
   case class Time(value: Double) extends Quantity { type unit = Second }

   def main(args: Array[String]): Unit = {
      println(add(Length(1), Length(2.7)))                  // Length(3.7)
      println(add(Temperature(273.15), Temperature(30.0)))  // Temperature(303.15)
      println(add(Time(100), Time(50)))                     // Time(150.0)

      println(Length(1) + Length(2.7))                      // Length(3.7)
      println(Temperature(273.15) + Temperature(30.0))      // Temperature(303.15)
      println(Time(100) + Time(50))                         // Time(150.0)
   }
}