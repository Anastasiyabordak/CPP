package example

import scala.annotation.tailrec
import java.lang
import scala.collection.JavaConverters._

class wordList
{

 private var words: List[java.lang.String] = List()


def addWord(temp :java.lang.String): Unit =
{
  words ::= temp
}

  def deleteDublicate() : List[java.lang.String] =
  {
    words = words.distinct
    words
  }
def getWord() : List[java.lang.String] =
{
 words
}
  def reverse() :List[java.lang.String] =
  {
   words =  words.foldLeft(List[java.lang.String]()){(right,left) => left :: right}
   words
  }
  def getString(): java.lang.String =
  {
    sumWords(words.filter((x: java.lang.String )=> x.charAt(0) == x.charAt(0).toUpper))
  }
  def sumWords(items : List[java.lang.String]) : java.lang.String =
  {
    @tailrec
    def inn(xs: List[java.lang.String], acc: java.lang.String): String =
    {
      xs match
        {
        case x :: tail =>inn(tail, acc.concat(" ").concat(x))
        case Nil => acc
      }
    }
    inn(items, "")
  }
}
