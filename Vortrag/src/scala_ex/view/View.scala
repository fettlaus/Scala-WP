package scala_ex.view

import scala.swing.Frame
import scala.swing.BorderPanel
import scala.swing.Button
import scala.swing.FlowPanel
import scala.swing.Label
import scala.swing.TextField
import scala.swing.GridPanel
import java.awt.Dimension
import java.awt.BorderLayout
import scala.swing.TextArea

class View(name:String) extends Frame {
  private val mouseoutput = Array.fill(5)(new Label("0"))
    title = name   
    val panel = new BorderPanel{
      // Top (North)
      add(new FlowPanel{
        contents += new Label("Finde Primzahlen bis:")
        contents += new TextField(9)
        contents += new Button("Finde")
      },BorderPanel.Position.North)
      
      // Left (West)
      add(new GridPanel(2,1){
        contents += new Label("Maus Events")
        contents += new GridPanel(5,2){
          for(m <- mouseoutput){
            contents += new Label("Hallo")
            contents += m
          }
        }
      },BorderPanel.Position.West)
      
      // Right (East)
      add(new FlowPanel{
        contents += new Label("Hallo Welt")
        },BorderPanel.Position.East)
        
        // Center
      add(new FlowPanel{
        contents += new TextArea("Gefundene Primzahlen:\n"){
          lineWrap = true
          columns = 40
          rows = 40
          editable = false
          text += " 2,3,5,7,...\n"
        }
      },BorderPanel.Position.Center)
      
      // Bottom (South)
      add(new FlowPanel{
        contents += new Label("Aktuelle Zahl:")
        contents += new Label("erlege gerade Zahl XYZ")
      },BorderPanel.Position.South)
      
      
    }
  preferredSize = new Dimension(640,480)
  peer.setLocation(50,50)
    contents = panel
    visible = true
}