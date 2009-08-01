// Copyright 2009 Quenio dos Santos. All rights reserved.
package org.sinq.examples

import scala.collection.mutable
import org.sinq._

object ClassicExample {
  def main(args : Array[String]) : Unit = {
      val nameSet = mutable.Set(
          "Burke", "Connor", "Frank", 
          "Everett", "Albert", "George", 
          "Harris", "David")
      val names = DataSet(nameSet)

      // C# classic example:
      // var query = from s in names
      //             where s.Length == 5
      //             select s.ToUpper();
      val query = for(s <- names if s.length() == 5) yield s.toUpperCase(); 
      
      for(item <- query) {
        println(item);
      }
      println("---")
      
      nameSet += "Jonas";
      for(item <- query) {
        println(item);
      }
  }
}
