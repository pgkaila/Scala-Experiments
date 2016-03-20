package be.piyush.algorithm.dijkstra

import java.io.{File, PrintWriter}

import scala.collection.immutable.TreeMap
import scala.collection.mutable
import scala.io.Source

/**
 * @Author Piyush Kaila
 * @Purpose Solving Dijkstra HackerRank problem(https://www.hackerrank.com/challenges/dijkstrashortreach)
 */
class HackerRankProblem {
  def solveTheProblem(file:String): String ={
    var output = List[String]()

    // Read from file or STDIN
    // Use StdIn.readLine() to execute program on HackerRank
    val lines = Source.fromFile(file).getLines()

    val testCases = lines.next().toInt
    for(i<- 1 to testCases ){
      val nodes = mutable.Set[Int]()
      val edges = new mutable.HashMap[Int, mutable.Set[Int]]() with mutable.MultiMap[Int, Int]
      val edgesWithWeight = new mutable.HashMap[Edge,Int]()
      var sourceNode = 0

      val edgesNodesCount = lines.next().split(" ")
      val nodesCount = edgesNodesCount(0).toInt
      val edgesCount = edgesNodesCount(1).toInt

      for (edge <- 1 to edgesCount){
        val edgeData = lines.next().split(" ")
        val source = edgeData(0).toInt
        val destination = edgeData(1).toInt
        val weight = edgeData(2).toInt

        // Storing nodes
        nodes.add(source)
        nodes.add(destination)

        // Storing edges
        edges.addBinding(source, destination)
        edges.addBinding(destination, source)
        val storeWeight = {
          if (!edgesWithWeight.contains(new Edge(source, destination))) {
            weight
          } else {
            Math.min(weight, edgesWithWeight.get(new Edge(source, destination)).get)
          }
        }
        edgesWithWeight(new Edge(source, destination)) = storeWeight
      }
      sourceNode = lines.next().toInt

      val dijkstra = new Dijkstra(nodes, edges, edgesWithWeight, sourceNode)
      val distance = dijkstra.solveDijkstra

      // Generating output In file or STDOUT
      var outputList = new TreeMap[Int, Int]()
      distance.foreach(
        (tuple) => {
          if (tuple._1 != sourceNode) {
            if (tuple._2 != Int.MaxValue) {
              outputList += (tuple._1 -> tuple._2)
            } else {
              outputList += (tuple._1 -> -1)
            }
          }
        }
      )
      // println(outputList.values mkString " ")
      output = output.::(outputList.values mkString " ")
    }

    output.reverse.toIterable mkString "\n"
  }
}

object HackerRankProblem{
  def main(args: Array[String]) {

    val fileName = "test.txt"
    val writer = new PrintWriter(new File(fileName))
    writer.write(
      "5\n" +
        "4 4\n" +
        "1 2 24\n" +
        "1 4 20\n" +
        "3 1 3\n" +
        "4 3 12\n" +
        "1\n" +
        "2 1\n" +
        "1 2 23\n" +
        "1\n" +
        "3 2\n" +
        "1 2 213\n" +
        "3 2 123\n" +
        "1\n" +
        "7 5\n" +
        "1 2 5\n" +
        "3 2 6\n" +
        "3 4 9\n" +
        "5 4 3\n" +
        "6 7 13\n" +
        "3\n" +
        "7 7\n" +
        "1 2 5\n" +
        "2 3 3\n" +
        "3 2 6\n" +
        "2 3 5\n" +
        "3 4 9\n" +
        "5 4 3\n" +
        "6 7 13\n" +
        "3")
    writer.close()

    val hackerRankProblem = new HackerRankProblem
    print(hackerRankProblem.solveTheProblem("test.txt"))
  }
}