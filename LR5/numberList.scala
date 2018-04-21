package example

import scala.annotation.tailrec
class numberList
{

 private var number: List[Integer] = List()

 def minTail(): Integer =
 {
   @tailrec
  def minRecursion(numbers : List[Integer], smalest: Integer) : Integer =
   {
     numbers match {
      case Nil => smalest
      case x::tail =>
         val newMin = if(x < smalest) x else smalest
         minRecursion(tail, newMin)
     }
   }
  minRecursion(number,number.head)
 }
  def minNotTail():Integer =
  {
    def min(s1: Integer, s2:Integer): Integer = if (s1 < s2) s1 else s2
    number.reduceLeft(min)
  }

  def extremumNotTail(low : Integer, high : Integer) : (Integer, Integer) =
  {
    var min:Integer = java.lang.Integer.MAX_VALUE
    var max:Integer = java.lang.Integer.MIN_VALUE

    for( i  <- number if (i >= low && i <= high))
    {
      if(i < min) min=i;
      if(i > max) max = i;
    }
    (min,max)
  }

  def  extremumTail(low : Integer, high : Integer) : (Integer, Integer) =
  {
    @tailrec
    def extremum(numbers : List[Integer], low : Integer, high : Integer, smalest : Integer, biggest : Integer) : (Integer, Integer) =
    {
      numbers match
      {
        case Nil => (smalest, biggest)
        case x::tail =>
          val newMin = if(x < smalest &&(x >= low && x <= high) ) x else smalest
          val newMax = if(x > biggest &&(x >= low && x <= high)) x else biggest
          extremum(tail,low, high, newMin, newMax)
      }
    }
   extremum(number,low,high,java.lang.Integer.MAX_VALUE,java.lang.Integer.MIN_VALUE )
  }
def addNumber(temp : Integer): Unit =
{
  number ::= temp
}

}
