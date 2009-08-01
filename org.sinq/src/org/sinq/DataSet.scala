// Copyright 2009 Quenio dos Santos. All rights reserved.
package org.sinq

case class DataSet[T](i: Iterable[T]) {
    
  def filter(filter: T => Boolean) = Query(this, filter, null, null, false)

  def map[R](selector: T => R) = Query(this, null, selector, null, false)
  
  def foreach(block: T => Unit) = i.foreach(block)

  def select[R](selector: T => R) = i.map(selector)
  
  def where(filter: T => Boolean) = i.filter(filter)
  
}
