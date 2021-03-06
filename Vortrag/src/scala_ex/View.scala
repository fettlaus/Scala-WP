package scala_ex

import scala.swing.Frame
import scala.swing.BorderPanel
import scala.swing.MainFrame
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
import scala.swing.ProgressBar
import scala.swing.MenuBar
import scala.swing.Menu
import scala.swing.MenuItem
import scala.swing.Action
import scala.swing.Dialog
import scala.concurrent.ops._

class View(name: String) extends MainFrame {
   val mouseoutput = Array.fill(5)(new Label("0"))
   private val mouselabeltext = Array("Mouse Click:", "Mouse Enter:", "Mouse Exit", "Mouse Pressed:", "Mouse Released:")
   val input = new TextField(25) { text = "200000" }
   val result = new TextArea("Gefundene Primzahlen:\n") { editable = false }
   val progress = new Label
   val pbar = new ProgressBar
   val found = new Label
   var mouseclicks = 0
   var mouseenters = 0
   var mouseexits = 0
   var mousepresses = 0
   var mousereleases = 0

   // === Scala setter & getter
   title = name

   // === Layouts in Panels
   val mainpanel = new BorderPanel {
      menuBar = new MenuBar {
         contents += new Menu("File") {
            contents += new MenuItem(Action("Exit") { System.exit(0) })
         }
         contents += new Menu("Edit") {
            contents += new MenuItem(Action("Copy") { result.selectAll; result.copy })
         }
         contents += new Menu("Help") {
            contents += new MenuItem(Action("About") { Dialog.showMessage(this, "(c)2012\n\nRene Rose\nArne Wischer\nBenjamin Burchard", "About") })
         }
      }

      listenTo(mouse.moves, mouse.clicks)
      // === partial functions
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
         // === Actions & Factory
         contents += Button("Finde") {
                      
            var counter = 0
            // === Threads
            spawn{
               var p = 0
               while(true){               
                  Thread.sleep(1000)
                  found.text = " Op/sec "+(counter-p)
                  p = counter
               }
            }
            
            spawn{
               val max = input.text.toInt
               counter = 0
               result.text = ""
               pbar.max = max
               @tailrec
               def finddivisor(n: Int, testdiv: Int): Int = {
                  if (testdiv * testdiv > n) n
                  else if ((n % testdiv) == 0) testdiv
                  else finddivisor(n, testdiv + 1)
               }
 
               for (i <- 3 to max) {                             
                  counter = i
                  progress.text = i.toString
                  pbar.value = i
                  if (finddivisor(i, 2) == i) result.append(i.toString() + ", ")
               }
            }
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
         contents += pbar
         contents += found
      }, BorderPanel.Position.South)
   }
   

   preferredSize = new Dimension(640, 480)
   peer.setLocation(50, 50)
   contents = mainpanel
   visible = true
}