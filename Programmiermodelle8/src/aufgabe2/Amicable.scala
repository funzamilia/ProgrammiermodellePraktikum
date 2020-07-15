package aufgabe2

class Amicable {
  
}

object Amicable{
  def main(args : Array[String]) :Unit = {
    
    def sumDividers (number : Int) :List[Int] =
      (1 until number).filter(v => number % v == 0).toList
    
    def isAmicable (a : Int, b : Int) :Boolean = 
      if (sumDividers(a).sum == b) true
      else false
    
    println(isAmicable(220, 284))
    println(isAmicable(220, 220))
    println(isAmicable(220, 283))
  }
}