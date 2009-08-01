// Copyright 2009 Quenio dos Santos. All rights reserved.
package org.sinq

case class Query[T, S, K <% Ordered[K]](
  dataSet: DataSet[T], filter: T => Boolean, selector: T => S, sortKey: S => K, desc: Boolean) {
  
  def map[R](newSelector: T => R) = Query(dataSet, filter, newSelector, null, false)
  
  def foreach(block: S => Unit) {
    val s = selection
    if (s != null) {
      if (sortKey == null) {
        s.foreach(block)
      } else {
        sort(s.toList).foreach(block)
      }
    }
  }
  
  def orderBy[N <% Ordered[N]](newKey: S => N) = Query(dataSet, filter, selector, newKey, false)

  def orderByDesc[N <% Ordered[N]](newKey: S => N) = Query(dataSet, filter, selector, newKey, true)

  private def filtered = 
    if (filter == null) 
      null
    else 
      dataSet.where(filter)
  
  private def selection =
    if (selector == null)
      null
    else {
      val f = filtered
      if (f == null)
        dataSet.select(selector)
      else
        f.map(selector)
    }
  
  private def sort(list: List[S]) = {
    var join = (list map sortKey zip list) 
    var sorted = if (desc) join sort (_._1 > _._1) else join sort (_._1 < _._1)
    sorted map (_._2)
  }
}
