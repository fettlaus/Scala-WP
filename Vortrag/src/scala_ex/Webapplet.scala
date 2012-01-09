package scala_ex

import scala.swing.Applet

class Webapplet extends Applet {
   object ui extends UI{
      def init(){
         val v = new View("Webapp")
         contents = v.mainpanel
      }
   }

}