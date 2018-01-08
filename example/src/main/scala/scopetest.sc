object scopetest{
  val x = 0
  def f(y : Int) = y + 1
  val result = {
    val x = f(3)
    x*x
  } + x


  def s = 3
  def str = "string is powerful"
  str

  val str2 = "when it called, and evalued"
  str2

  lazy val str3 = "when it evalurd, and it execute"
}


