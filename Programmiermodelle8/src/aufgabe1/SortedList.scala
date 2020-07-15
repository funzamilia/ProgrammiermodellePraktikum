

package aufgabe1

class SortedList private (val list : List[Int]) {
  
  def sort(xs : List[Int]): List[Int] = xs match{
    case pivot::ys =>
      sort(ys filter (pivot >)) ::: List(pivot) ::: sort(ys filter (pivot <=))
    case Nil => Nil
  }
  
  def add (num : Int) :SortedList = 
    new SortedList(sort(list ::: List(num)))
  
   def apply(i : Int) = 
     list(i)
  
  override def toString: String =
    list.toString()
  
}

object SortedList{
  def apply() = new SortedList(Nil)
 
  def main(args : Array[String]) = {
    val list=SortedList()
    val list123=list.add(3).add(2).add(1)
    val list1235=list.add(3).add(2).add(1).add(5)
    val list12235=list.add(3).add(2).add(1).add(5).add(2)
    println(list123)
    println(list123(2))
    println(list1235)
    println(list12235)
  }
}