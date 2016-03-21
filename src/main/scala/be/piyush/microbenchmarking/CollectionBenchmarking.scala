package be.piyush.microbenchmarking

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

import scala.collection.{immutable, _}
import scala.util.Random

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 21/3/16, 1:46 AM
 * Purpose: microbenchmarking to check performance of mutable and immutable HashMap
 */

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime, Mode.Throughput, Mode.SampleTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class CollectionBenchmarking {

  @Benchmark
  @OperationsPerInvocation(2)
  def mutableHashMap: Unit ={
    val map = new mutable.HashMap[String, Long]()
    val r = new Random()
    r.setSeed(1000L)
    for (i <- 1 to 1000000) {
      val number = r.nextLong()
      map(number.toString) = number
    }
  }

  @Benchmark
  @OperationsPerInvocation(2)
  def immutableHashMap: Unit ={
    var map = new immutable.HashMap[String, Long]()
    val r = new Random()
    r.setSeed(1000L)
    for (i <- 1 to 1000000) {
      val number = r.nextLong()
      map = map.+(number.toString -> number)
    }
  }
}