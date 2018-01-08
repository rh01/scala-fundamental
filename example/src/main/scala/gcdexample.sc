import scala.annotation.tailrec

object gcdexample{

  /*
  Using Eulid method to find two value
   */
  @tailrec
  def gcd(a:Int, b:Int):Int =
    if(b == 0) a else gcd(b, a%b)

  gcd(5, 6)


  def factorial(x: Int):Int =
    if(x == 0) 1  else x*factorial(x - 1)


  factorial(4)

}