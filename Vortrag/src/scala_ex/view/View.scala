package scala_ex.view

import scala.swing.Frame
import scala.swing.BorderPanel
import scala.swing.Button
import scala.swing.FlowPanel
import scala.swing.Label
import scala.swing.TextField
import scala.swing.GridPanel
import java.awt.Dimension
import scala.swing.TextArea
import scala.swing.event.MouseEvent
import scala.swing.event.MouseEntered
import scala.swing.event.MouseEntered
import scala.swing.event.MouseExited
import scala.swing.event.MouseClicked
import scala.swing.event.MouseReleased
import scala.swing.event.MousePressed
import scala.swing.Reactions
import scala.swing.Panel
import scala.swing.ScrollPane
import scala.actors.Actor
import scala.annotation.tailrec

class View(name: String) extends Frame {
   val mouseoutput = Array.fill(5)(new Label("0"))
   private val mouselabeltext = Array("Mouse Click:", "Mouse Enter:", "Mouse Exit", "Mouse Pressed:", "Mouse Relesed:")
   val input = new TextField(25) { text = "100" }
   val result = new TextArea("Gefundene Primzahlen:\n")
   val progress = new Label()
   var mouseclicks = 0
   var mouseenters = 0
   var mouseexits = 0
   var mousepresses = 0
   var mousereleases = 0

   title = name

   val mainpanel = new BorderPanel {

      listenTo(mouse.moves, mouse.clicks)
      reactions += {
         case e: MouseEntered => mouseenters = mouseenters + 1; mouseoutput(1).text = mouseenters.toString
         case e: MouseExited => mouseexits = mouseexits + 1; mouseoutput(2).text = mouseexits.toString
         case e: MouseClicked => mouseclicks = mouseclicks + 1; mouseoutput(0).text = mouseclicks.toString
         case e: MousePressed => mousepresses = mousepresses + 1; mouseoutput(3).text = mousepresses.toString
         case e: MouseReleased => mousereleases = mousereleases + 1; mouseoutput(4).text = mousereleases.toString
      }

      // Top (North)
      add(new FlowPanel {
         contents += new Label("Finde alle Primzahlen bis:")
         contents += input
         // Actions & Actors
         contents += Button("Finde") {
            println("Ich rechne nun!")
            val max = input.text.toInt
            new Actor {
               def act() {
                  result.text = ""

                  @tailrec
                  def finddivisor(n: Int, testdiv: Int): Int = {
                     if (testdiv * testdiv > n) n
                     else if ((n % testdiv) == 0) testdiv
                     else finddivisor(n, testdiv + 1)
                  }

                  for (i <- 3 to max) {
                     progress.text = i.toString
                     if (finddivisor(i, 2) == i) result.append(i.toString() + ", ")
                  }
               }
            }.start()
         }
      }, BorderPanel.Position.North)

      // Left (West)
      val d = add(new GridPanel(2, 1) {
         contents += new Label("Maus Events")
         contents += new GridPanel(5, 2) {
            for (i <- 0 to mouseoutput.length - 1) {
               contents += new Label(mouselabeltext(i))
               contents += mouseoutput(i)
            }
         }
      }, BorderPanel.Position.West)

      // Right (East)
      add(new FlowPanel {
         contents += new Label("Hallo Welt")
      }, BorderPanel.Position.East)

      // Center
      add(new BorderPanel {
         result.lineWrap = true
         add(new ScrollPane(result), BorderPanel.Position.Center)
      }, BorderPanel.Position.Center)

      // Bottom (South)
      add(new FlowPanel {
         contents += new Label("Aktuelle Zahl:")
         contents += progress
      }, BorderPanel.Position.South)
   }

   preferredSize = new Dimension(640, 480)
   peer.setLocation(50, 50)
   contents = mainpanel
   visible = true
}