package recfun

import java.util

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   * Pascal’s triangle
    *1
    *1 1
    *1 2 1
    *1 3 3 1
    *1 4 6 4 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2
    * Write a recursive function which verifies the balancing of parentheses in a string,
    * which we represent as a List[Char] not a String. For example,
    *
    * the function should @return true for the following strings:
    *
    * (if (zero? x) max (/ 1 x))
    * I told him (that it’s not (yet) done). (But he wasn’t listening)
    *
    * The function should @return false for the following strings:
    *
    * :-)
    * ())(
    *
    * There are three methods on List[Char] that are useful for this exercise:
    *
    * `chars.isEmpty`: Boolean returns whether a list is empty
    * `chars.head`: Char returns the first element of the list
    * `chars.tail`: List[Char] returns the list without the first element
   */
    def balance(chars: List[Char]): Boolean = {
      def balanced(chars: List[Char], open : Int): Boolean ={
        if(chars.isEmpty) open == 0
        else
          if (chars.head == '(') balanced(chars.tail, open + 1)
        else
          if (chars.head == ')') open > 0 && balanced(chars.tail, open - 1)
          else balanced(chars.tail, open)
      }

      balanced(chars, 0)
 }
  
  /**
   * Exercise 3
    *
    * Write a recursive function that counts how many different ways
    * you can make change for an amount,
    * given a list of coin denominations.
    * For example,
    * there are 3 ways to give change for 4
    * if you have coins with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.
    *
    * Do this exercise by implementing the countChange function in `Main.scala`.
    * This function takes an amount to change,
    * and a list of unique denominations for the coins.
    *
    * Its signature is as follows:
    *
    * Once again, you can make use of functions
    * `isEmpty`, `head` and `tail` on the list of integers coins.
    *
    * **Hint:** Think of the degenerate cases.
    * How many ways can you give change for 0 CHF(swiss money)?
    * How many ways can you give change for >0 CHF,
    * if you have no coins?
    *
    */
    def countChange(money: Int, coins: List[Int]): Int = {
      def loop(money:Int, coins: List[Int]): Int = {
        if(money < 0 || coins.isEmpty) 0
        else if (money == 0) 1
        else loop(money, coins.tail) + loop(money - coins.head, coins)
      }

      loop(money, coins)
    }
  }
