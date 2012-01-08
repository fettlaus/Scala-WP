package scala_ex.controller
import scala_ex.view._
import scala_ex.model._


class Controller(name:String) {
  val view = new View(name)
  val model = new Model

}