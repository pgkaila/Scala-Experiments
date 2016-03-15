package be.piyush.scala.algorithm

import java.io.{File, PrintWriter}

import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.reflect.io

/**
 * @Author: Piyush Kaila
 * @Purpose: Test cases for Dijkstra HackerRank problem(https://www.hackerrank.com/challenges/dijkstrashortreach)
 */
class DijkstraSuite extends FunSuite with BeforeAndAfter{

  before {
    val writer = new PrintWriter(new File("test.txt" ))
    writer.write(
      "1\n" +
      "4 4\n" +
      "1 2 24\n" +
      "1 4 20\n" +
      "3 1 3\n" +
      "4 3 12\n" +
      "1")
    writer.close()
  }

  test("Shortest path between start and destination case") {
    val dijkstra:Dijkstra = new Dijkstra
    assert(dijkstra.findShortestPath.equals("24 3 15"))
  }

  after {
    val file = new File("test.txt")
    file.delete()
  }

}
