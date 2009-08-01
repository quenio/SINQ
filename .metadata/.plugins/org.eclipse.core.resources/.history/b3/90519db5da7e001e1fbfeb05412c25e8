package org.sinq.examples

import scala.collection.mutable
import org.sinq._

object SimplestExample {

  def main(args : Array[String]) : Unit = {
      val nameSet = mutable.Set("Burke", "Connor", "Frank");
      val names = DataSet(nameSet);

      // Simplest example in C#:
      // var query = from s in names
      //             select s.Length;
      val query = for(s <- names) yield s.length; 
      
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
