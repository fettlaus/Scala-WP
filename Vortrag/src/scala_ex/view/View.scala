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

class View(name: String) extends Frame {
   val mouseoutput = Array.fill(5)(new Label("0"))
   private val mouselabeltext = Array("Mouse Click:", "Mouse Enter:", "Mouse Exit", "Mouse Pressed:", "Mouse Relesed:")
   val input = new TextField(25)
   val result = new TextArea("Gefundene Primzahlen:\n")
   val progress = new Label()
   val calc = new Button("Finde")
   title = name

   val mainpanel = new BorderPanel {

      // Top (North)
      add(new FlowPanel {
         contents += new Label("Finde alle Primzahlen bis:")
         contents += input
         contents += calc
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
         contents += new Label("erlege gerade Zahl XYZ")
      }, BorderPanel.Position.South)
   }

   preferredSize = new Dimension(640, 480)
   peer.setLocation(50, 50)
   contents = mainpanel
   visible = true
}