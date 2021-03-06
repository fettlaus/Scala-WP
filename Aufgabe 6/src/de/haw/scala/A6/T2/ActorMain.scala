package de.haw.scala.A6.T2

object ActorMain {

  def main(args: Array[String]): Unit = {
    replyReactor.start
    replyReactor ! (Low, "lp1")
    replyReactor ! (Normal, "np1")
    replyReactor ! (High, "hp1")
    Thread.sleep(50)
    replyReactor ! (Low, "lp2")
    replyReactor ! (Normal, "np2")
    replyReactor ! (Low, "lp3")
    replyReactor ! (Low, "lp4")
    replyReactor ! (High, "hp2")
    replyReactor ! (High, "hp3")
    replyReactor ! (Low, "lp5")
    replyReactor ! (High, "hp4")
    replyReactor ! (Normal, "np3")
  }

  // Solution by Daniela Niemeyer
  // modified by Arne Wischer
  object High
  object Normal
  object Low

  import scala.actors._
  object replyReactor extends ReplyReactor {

    def act {
      loop {
        reactWithin(0) {
          case (High, s) => println(s)
          case TIMEOUT => {
            reactWithin(0) {
              case (High, s) => println(s)
              case (Normal, s) => println(s)
              case TIMEOUT => {
                reactWithin(0) {
                  case (High, s) => println(s)
                  case (Normal, s) => println(s)
                  case (Low, s) => println(s)
                  case TIMEOUT => {
                    reactWithin(100) {
                      case m: (Any, String) => this ! m
                      case TIMEOUT => exit
                    }
                  }
                }
              }
            }

          }

        }

      }

    }
  }

}