package scala_ex.controller
import scala_ex.view._
import scala_ex.model._
import scala.swing.event.MouseEntered
import scala.swing.event.MouseExited
import scala.swing.event.MouseClicked
import scala.swing.event.MouseReleased
import scala.swing.event.MousePressed
import scala.swing.event.ButtonClicked
import scala.swing.event.ButtonClicked


class Controller(name:String) {
  val view = new View(name)
  val model = new Model
  val m = view.mainpanel
  
  m.listenTo(m.mouse.moves,m.mouse.clicks)
  m.reactions +={
          case e:MouseEntered => view.mouseoutput(1).text = (view.mouseoutput(1).text.toInt+1).toString
          case e:MouseExited => view.mouseoutput(2).text = (view.mouseoutput(2).text.toInt+1).toString
          case e:MouseClicked => view.mouseoutput(0).text = (view.mouseoutput(0).text.toInt+1).toString
          case e:MousePressed => view.mouseoutput(3).text = (view.mouseoutput(3).text.toInt+1).toString
          case e:MouseReleased => view.mouseoutput(4).text = (view.mouseoutput(4).text.toInt+1).toString
        }
  
  view.listenTo(view.calc)
  view.reactions+={
          case ButtonClicked(b) => println("butt")
        }
  

}