object newtonmethod {
  def sqrt(x: Double):Double =  {
    def sqrtIter(guess: Double, x: Double): Double = {
      if (isGoodEough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)
    }

    def isGoodEough(guess: Double, x: Double) =
      abs(guess * guess - x) < 0.001

    def abs(x: Double): Double = if (x < 0) -x else x

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    sqrtIter(1.0, x)
  }


  sqrt(2)
  sqrt(4)
  sqrt(5)
  sqrt(6)
  sqrt(1e-6)

}
