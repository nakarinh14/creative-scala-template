import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._

import scala.annotation.tailrec

object ex8 {
  val base_size = 25

  def base_image_recur(count: Int, base: Image)(op: Image => Image): Image = {
    @tailrec
    def recur(count: Int, prevBase: Image): Image = count match {
      case 0 => prevBase
      case n => recur(n-1, op(prevBase))
    }
    recur(count, base)
  }

  def chessboard(count: Int): Image = {
    val redBox = Image.square(base_size).fillColor(Color.red)
    val blackBox = Image.square(base_size).fillColor(Color.black)
    val base = redBox.beside(blackBox).above(blackBox.beside(redBox))
    base_image_recur(count, base)(prev_base => prev_base.beside(prev_base).above(prev_base.beside(prev_base)))
  }

  def sierpinski(count: Int): Image = {
    val base = Image.triangle(base_size, base_size).strokeColor(Color.deepPink).strokeWidth(2)
    base_image_recur(count, base)(prevBase => prevBase.above(prevBase.beside(prevBase)))
  }

  def gradient(count: Int): Image = {
    def generateSquare(bodyColor: Color, strokeColor: Color) = {
      Image.square(50).fillColor(bodyColor).strokeColor(strokeColor).strokeWidth(4)
    }
    val bodyColor = Color.royalBlue
    val strokeColor = Color.blueViolet

    @tailrec
    def recur(count: Int, bodyColor: Color, strokeColor: Color, prevBase: Image): Image = count match {
      case 0 => prevBase
      case n =>
        recur(
          n-1,
          bodyColor.spin(0.2.radians),
          strokeColor.spin(0.2.radians),
          prevBase.beside(generateSquare(bodyColor, strokeColor))
        )
    }
    recur(count, bodyColor, strokeColor, Image.empty)
  }

  def main(args: Array[String]): Unit = {
    gradient(5).draw()
  }
}
