package be.piyush.algorithm.dijkstra

import scala.collection.mutable

/**
 * @Author: Piyush Kaila
 * @Purpose: Implementation of Dijkstra to find shortest distance. HackerRank problem(https://www.hackerrank.com/challenges/dijkstrashortreach)
 */
class Dijkstra(nodes:mutable.Set[Int], edges:mutable.HashMap[Int, mutable.Set[Int]] with mutable.MultiMap[Int, Int], edgesWithWeight:mutable.HashMap[Edge,Int], sourceNode:Int) {

  val settledNodes = mutable.Set[Int]()
  val unSettledNodes = mutable.Set[Int]()
  val distance = mutable.HashMap[Int, Int]()

//  def solveDijkstra(nodes: mutable.Set[Int], edges: mutable.HashMap[Int, mutable.Set[Int]] with mutable.MultiMap[Int, Int], sourceNode: Int): Unit ={
  def solveDijkstra: mutable.HashMap[Int, Int] ={
    // Setting default distance
    nodes.foreach((node) => distance(node) = Int.MaxValue)
    distance(sourceNode) = 0

    unSettledNodes.add(sourceNode)

    while (unSettledNodes.nonEmpty){
      val node = getNearestNode(unSettledNodes)
      settledNodes.add(node)
      unSettledNodes.remove(node)
      findMinimalDistance(node)
    }
    distance
  }

  def getNearestNode(unSettledNodes: mutable.Set[Int]): Int ={
    var nearest:Int = 0
    unSettledNodes.foreach(
      (node) => {
        if (nearest==0) {
          nearest = node
        } else {
          if (node < nearest){
            nearest = node
          }
        }
      }
    )
    nearest
  }

  def findMinimalDistance(node:Int): Unit = {
    val adjacentNodes = edges.get(node).get
    adjacentNodes.foreach(
      (adjacentNode) => {
        if(distance.get(adjacentNode).get > (distance.get(node).get + edgesWithWeight.get(new Edge(node, adjacentNode)).get)){
          distance(adjacentNode) = distance.get(node).get + edgesWithWeight.get(new Edge(node, adjacentNode)).get
          unSettledNodes.add(adjacentNode)
        }
      }
    )
  }
}

class Edge(source: Int, destination: Int) {

  /**
   * Used https://en.wikipedia.org/wiki/Pairing_function#Cantor_pairing_function
   * @return Int
   */
  override def hashCode: Int = {
    if (source < destination) {
      ((source + destination) * (source + destination + 1) / 2) + destination
    } else {
      ((source + destination) * (source + destination + 1) / 2) + source
    }
  }

  override def equals(o: Any): Boolean = {
    o.hashCode() == this.hashCode
  }
}