import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._

object ex3 {
  def circle(): Unit = {
    Image.circle(1).draw()
    Image.circle(10).draw()
    Image.circle(100).draw()
  }

  def type_check(): Image = {
    Image.circle(1)
  }

  def circle_fig_ex(): Unit = {
    Image.circle(30)
      .on(
        Image.circle(10)
          .beside(Image.circle(10))
          .beside(Image.circle(10))
      )
      .draw()
  }

  def evil_eye(): Unit = {
    def evil_sub_eye(d: Double, color: Color): Image = {
      Image.circle(d).fillColor(color).strokeWidth(3)
    }

    evil_sub_eye(100, Color.darkBlue)
      .under(evil_sub_eye(70, Color.white))
      .under(evil_sub_eye(45, Color.cornflowerBlue))
      .under(evil_sub_eye(20.5, Color.black))
      .draw()
  }

  def anagolous_triangle(): Unit = {
    val size = 250.0
    def base_triangle_image(angle: Int) = {
      val spinned_color = Color.darkSlateBlue.spin(angle.degrees)
      Image.triangle(size, size)
        .strokeColor(spinned_color)
        .strokeWidth(30)
        .fillColor(spinned_color.lightness(0.65.normalized))
    }

    base_triangle_image(0).above(
      base_triangle_image(-30)
        .beside(base_triangle_image(30))
    ).draw()

  }

  def archery_target(): Image = {
    Image.circle(225).strokeWidth(3).fillColor(Color.red)
      .under(Image.circle(150).strokeWidth(3).fillColor(Color.white))
      .under(Image.circle(75).strokeWidth(3).fillColor(Color.red))
  }

  def main(args: Array[String]): Unit = {
    archery_target().draw()
  }

}
