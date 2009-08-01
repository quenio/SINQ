package org.sinq

case class DataSet[T](i: Iterable[T]) {
    
  def filter(filter: T => Boolean) = Query(this, filter, null, null)

  def map[R](selector: T => R) = Query(this, null, selector, null)
  
  def foreach(block: T => Unit) = i.foreach(block)

  def select[R](selector: T => R) = i.map(selector)
  
  def where(filter: T => Boolean) = i.filter(filter)
  
}