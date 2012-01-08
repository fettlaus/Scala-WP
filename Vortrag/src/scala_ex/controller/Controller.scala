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
  val v = new View(name)
  val m = new Model
  val mp = v.mainpanel
  
  mp.listenTo(mp.mouse.moves,mp.mouse.clicks)
  mp.reactions +={
          case e:MouseEntered => m.mouseenters = m.mouseenters + 1;update
          case e:MouseExited => m.mouseexits = m.mouseexits + 1;update
          case e:MouseClicked => m.mouseclicks = m.mouseclicks + 1;update
          case e:MousePressed => m.mousepresses = m.mousepresses + 1;update
          case e:MouseReleased => m.mousereleases = m.mousereleases + 1;update
        }
  
  v.listenTo(v.calc)
  v.reactions+={
          case ButtonClicked(b) => println("butt")
        }
  
  def update{
    v.mouseoutput(0).text = m.mouseclicks.toString
    v.mouseoutput(1).text = m.mouseenters.toString
    v.mouseoutput(2).text = m.mouseexits.toString
    v.mouseoutput(3).text = m.mousepresses.toString
    v.mouseoutput(4).text = m.mousereleases.toString
  }
  

}