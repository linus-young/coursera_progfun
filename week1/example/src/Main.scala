package example

object Main extends App {
  println(Lists.sum(List(1, 2, 3)))
  println(Lists.max(List(1, 3, 4, 2)))
  println(Lists.max(List(3, 2, 1, 4)))
  println(Lists.max(List(4, 1, 2, 3)))
  
  println(Lists.max(List()))
}