package example

import scala.annotation.tailrec
import java.lang
import scala.collection.JavaConverters._

class wordList
{

 private var words: List[java.lang.Integer] = List()


def addWord(temp :java.lang.Integer): Unit =
{
  words ::= temp
}

def getWord() : List[java.lang.Integer] =
{
   words
}
  def getString(x: Any): java.lang.String = x match
    {
       case x: java.lang.Integer => x.toString
       case _ => sumNumb(words)
  }
def oddEven()
{

  words = words.grouped(2).flatMap{

     case List (a,b) => List(0,1)
     case a => List(0)
   }.toList.map(i => i:java.lang.Integer)
  words

}
def sumNumb (items : List[java.lang.Integer]) : java.lang.String =
{
  @tailrec
  def inn (xs : List[java.lang.Integer], acc : java.lang.String) : java.lang.String =
  {
    xs match
      {
      case x :: tail => inn(tail, acc.concat(" ").concat(x.toString).concat(","))
      case Nil => acc
    }
   }
  inn(items, "")
}
}
