import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._

object ex7 {
  val aBox = Image.square(20).fillColor(Color.royalBlue)

  def stacks(num: Int): Image = num match {
    case 0 => Image.empty
    case n => aBox.above(stacks(n-1))
  }

  val tmpB = Image.square(20).fillColor(Color.red)
  def alternate(num: Int): Image = num match {
    case a if a % 2 == 0 => aBox
    case b if b % 2 == 1 => tmpB
  }

  val baseImage = Image.circle(20).fillColor(Color.red)
  val addOn = Image.circle(20).fillColor(Color.blue)
  def cross(count: Int): Image = count match {
    case 0 => baseImage
    case n =>
      addOn.beside(
        addOn.above(addOn.below(cross(n-1)))
      ).beside(addOn)
  }

  def main(args: Array[String]): Unit = {
//    val baseImage = Image.circle(20).fillColor(Color.red)
//    val addOn = Image.circle(20).fillColor(Color.blue)
//
//    addOn.beside(
//      addOn.above(addOn.below(baseImage))
//    ).beside(addOn).draw()
    cross(2).draw()
  }

}
