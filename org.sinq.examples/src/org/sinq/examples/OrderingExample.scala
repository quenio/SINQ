package org.sinq.examples

import scala.collection.mutable
import org.sinq._

object OrderingExample {
  def main(args : Array[String]) : Unit = {
      val nameSet = mutable.Set(
          "Burke", "Connor", "Frank", 
          "Everett", "Albert", "George", 
          "Harris", "David", "Joe", "Lili")
      val names = DataSet(nameSet)

      // C# classic example:
      // var query = from s in names
      //             where s.Length == 5
      //             orderBy s.Length, s
      //             select s.ToUpper();
      val query = for(s <- names if s.length >= 5) yield s.toUpperCase()
      
      val sortedQuery = query.sortBy(s => (s.length, s))
      
      for(item <- sortedQuery) {
        println(item);
      }
      println("---")
      
      nameSet += "Jonas";
      for(item <- sortedQuery) {
        println(item);
      }
  }
}
