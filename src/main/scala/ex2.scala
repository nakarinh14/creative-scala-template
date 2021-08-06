object ex2 {
  def sub1(): Int = 50 + 5 - 13
  def sub2(): String = {
    var tmp = "aa"
    tmp ++ "bb"

    tmp = "aa"
    tmp.++("bb")
  }
  def sub3() = {
    1 + 2 * 3
  }

  def main(args: Array[String]): Unit = {
    println(sub2)
    println(sub3())
  }
}
