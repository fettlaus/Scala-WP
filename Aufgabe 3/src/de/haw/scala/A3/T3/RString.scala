package de.haw.scala.A3.T3

object RString {
	def apply(args:String)={
	  new RString(args)
	}
}

class RString(arg:String){
  import scala.util.matching._
  object Rnil { override def toString = "Rnil" }
  def apply(i:Int) = if(i<arg.length && i>=0) arg(i).toInt else Rnil
  def apply(i:Int,num:Int):AnyRef = apply(Range(i,i+num))
  def apply(s:String) = if(arg.contains(s)) s else Rnil
  def apply(r:Regex) = r.findFirstIn(arg).get
  def apply(s:Range):AnyRef={
    try{
      if(s.head<0)
        arg.substring(arg.length+s.head,arg.length+s.last+1)
      else
        arg.substring(s.head,s.last+1)
    }catch{case _ => Rnil }
  }
}