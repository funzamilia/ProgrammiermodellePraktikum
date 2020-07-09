import scala.annotation.tailrec


object ScalaMain{
  def main(args : Array[String]) : Unit = {
    
    //Aufgabe 1:
    def digits (num : Int) =
      num.toString().length()
     
    assert(1==digits (1))
    assert(2==digits (12))
    assert(3==digits (123))
    assert(4==digits (1234))
    
    //Aufgabe 2:
    def g (n : Int) :Int =
      if (n > 1) return g_help(n - 1, 3, 3, 1)
      else return n
    
    @tailrec def g_help (n : Int, i : Int, g1 : Int, g2 : Int) :Int =
      if (n > 1) return g_help(n - 1, i + 1, ((3 * g1) + (2 * g2)), g1)
      else return g1
      
    assert(0==g(0))
    assert(1==g(1))
    assert(3==g(2))
    assert(11==g(3))
    assert(39==g(4))
    
    //Aufgabe 3:
    def isPerfect (number : Int) :Boolean =
      return (isPerfect_help(number / 2, 0) == number)
      
    @tailrec def isPerfect_help (num : Int, accu : Int) :Int =
      if (num == 1) return (accu + 1)
      else return isPerfect_help ((num - (num / 2)), (accu + num))
      
    assert(!isPerfect(5))
    assert(isPerfect(6))
    assert(isPerfect(28))
      
    //Aufgabe 4:
    def isISBNFormat (isbn : String) :Boolean =
     return (isbn.matches("\\d\\-\\d{3}\\-\\d{5}\\-\\d"))
     
   assert(isISBNFormat("3-770-40001-1"))
   assert(!isISBNFormat("3-770-400012-1"))
   assert(!isISBNFormat("3-770-40001=1"))
   
   //Aufgabe 5:
   def isISBN (isbn : String) :Boolean =
     if (isISBNFormat(isbn)) return isISBN_help(isbn.replaceAll("-", ""), 0)
     else return false
     
   @tailrec def isISBN_help (rest : String, accu : Int) :Boolean =
     if (rest.length() == 0) return ((accu % 11) == 0)
     else return isISBN_help(rest.dropRight(1), (accu + (((rest.charAt(rest.length() - 1)).toInt) * rest.length())))
   
   assert( isISBN("3-770-40001-1"))
   assert(!isISBN("3-770-400012-1"))
   assert(!isISBN("3-770-40001-2"))
  }
}