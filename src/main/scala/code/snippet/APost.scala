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
  val menu = Menu.param[( ParamId1, ParamId2 )]("ParamId1", "ParamId2",
  {
    case ParamId1(p1) :: ParamId1(p2) :: Nil =>
      Full( (p1, p2) )
    case _ =>
      Empty
  },
  params => List(params._1.id.toString,params._2.id.toString)) / * / *

  lazy val loc = menu.toLoc

  def render = "*" #> loc.currentValue.map(_.docId)

}

// a snippet that takes the page parameter information
class APost( di: ( ParamId1, ParamId2 ) ) {
  def render = <div>param1: {di._1.param1}, param2 {di._2.param2}</div>
}
