package recfun
import common._

object Main {
  def main(args: Array[String]) {

    if (balance("())(".toList))
      println("yes!!")
    else
      println("no!")

    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == r) 1
    else if (c == 0) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)

  /**
   * Exercise 2
   */

  /**
   * Notice: diff doesn't modify the original List only return a new List --Immutable
   *
   */
  def balance(chars: List[Char]): Boolean = {

    /**
     * Wrong version 1
     */
    //   def remove(ch: Char): List[Char] = 
    //      chars diff List(ch)
    // 
    //    def isMatch(chars: List[Char], count: Int): Boolean = {
    //      if (count < 0) false
    //      if (chars.isEmpty) (count == 0)
    //      else if (chars.head == '(') {
    //        isMatch(remove(chars.head), count + 1);
    //      } else if (chars.head == ')') {
    //        isMatch(remove(chars.head), count - 1);
    //      } else {
    //        isMatch(remove(chars.head), count);
    //      }
    //    }

    def isMatch(chars: List[Char], count: Int): Boolean = {
      if (count < 0) false
      else if (chars.isEmpty) (count == 0) // If you use "if" not "else if" here, the function get false last step and still will go this line not return 
      else if (chars.head == '(') {
        isMatch(chars.tail, count + 1);
      } else if (chars.head == ')') {
        isMatch(chars.tail, count - 1);
      } else {
        isMatch(chars.tail, count);
      }
    }

    isMatch(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    /**
     * The elements in List is unique
     */

    var ans = 0

    def utility(mm: Int, ins: List[Int]) {
      if (!ins.isEmpty) {
        if (mm > ins.head) {
          utility(mm - ins.head, ins)
          utility(mm, ins.tail)
        } else if (mm < ins.head) {
          utility(mm, ins.tail)
        } else if (mm - ins.head == 0)
          ans += 1
      }
    }

    utility(money, coins.sorted)
    ans
  }
}
