package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb._
import sitemap._


case class ParamId1( param1:String )
case class ParamId2( param2:String )


object APost {

  // Create a menu for /user/santo
  val menu = Menu.params[( ParamId1, ParamId2 )]("ParamId1", "ParamId2",
  {
    case uid :: pid :: Nil =>
      (ParamId1(uid), ParamId2(pid)) match {
        case ( (user), (post)) => Full((user, post))
        case _ => Empty
      }
    case _ =>
      Empty
  },
  ft => List(ft._1.param1.toString,ft._2.param2.toString)) / * / *

  lazy val loc = menu.toLoc

}

// a snippet that takes the page parameter information
class APost( di: ( ParamId1, ParamId2 ) ) {

  def render = <div>param1: {di._1.param1} and param2: {di._2.param2}</div>

}
