package be.piyush.scala.algorithm.dijkstra

import java.io.{File, PrintWriter}

import org.scalatest.FunSuite

/**
 * @Author Piyush Kaila
 * @Purpose: Test cases for Dijkstra HackerRank problem(https://www.hackerrank.com/challenges/dijkstrashortreach)
 */
class HackerRankProblemSuite extends FunSuite{

  test("Dijkstra HackerRank problem testcase #1") {
    val fileName = "1.txt"
    val writer = new PrintWriter(new File(fileName))
    writer.write(
      "1\n" +
        "4 4\n" +
        "1 2 24\n" +
        "1 4 20\n" +
        "3 1 3\n" +
        "4 3 12\n" +
        "1")
    writer.close()
    val hackerRankProblem = new HackerRankProblem
    assert(hackerRankProblem.solveTheProblem(fileName).equals("24 3 15"))
    val file = new File(fileName)
    file.delete()
  }
  test("Dijkstra HackerRank problem testcase #2") {
    val fileName = "2.txt"
    val writer = new PrintWriter(new File(fileName))
    writer.write(
      "1\n" +
        "2 1\n" +
        "1 2 23\n" +
        "1")
    writer.close()
    val hackerRankProblem = new HackerRankProblem
    assert(hackerRankProblem.solveTheProblem(fileName).equals("23"))
    val file = new File(fileName)
    file.delete()
  }
  test("Dijkstra HackerRank problem testcase #3") {
    val fileName = "3.txt"
    val writer = new PrintWriter(new File(fileName))
    writer.write(
      "1\n" +
        "3 2\n" +
        "1 2 213\n" +
        "3 2 123\n" +
        "1")
    writer.close()
    val hackerRankProblem = new HackerRankProblem
    assert(hackerRankProblem.solveTheProblem(fileName).equals("213 336"))
    val file = new File(fileName)
    file.delete()
  }
  test("Dijkstra HackerRank problem testcase #4") {
    val fileName = "4.txt"
    val writer = new PrintWriter(new File(fileName))
    writer.write(
      "1\n" +
        "7 5\n" +
        "1 2 5\n" +
        "3 2 6\n" +
        "3 4 9\n" +
        "5 4 3\n" +
        "6 7 13\n" +
        "3")
    writer.close()
    val hackerRankProblem = new HackerRankProblem
    assert(hackerRankProblem.solveTheProblem(fileName).equals("11 6 9 12 -1 -1"))
    val file = new File(fileName)
    file.delete()
  }
  test("Dijkstra HackerRank problem testcase #5") {
    val fileName = "5.txt"
    val writer = new PrintWriter(new File(fileName))
    writer.write(
      "1\n" +
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
    assert(hackerRankProblem.solveTheProblem(fileName).equals("8 3 9 12 -1 -1"))
    val file = new File(fileName)
    file.delete()
  }
  test("Dijkstra HackerRank problem testcase #6") {
    val fileName = "6.txt"
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
    val op = hackerRankProblem.solveTheProblem(fileName)
    print(op)
    assert(op.equals("24 3 15\n23\n213 336\n11 6 9 12 -1 -1\n8 3 9 12 -1 -1"))
    val file = new File(fileName)
    file.delete()
  }

}
