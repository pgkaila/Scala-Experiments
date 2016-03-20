package be.piyush.bindingstest

/**
 * @Author Piyush Kaila
 */

object Test {
  def main(args: Array[String]): Unit = {
    println("testSamePackage")
    testSamePackage()
    println("\ntestWildcardImport")
    testWildcardImport()
    println("\ntestExplicitImport")
    testExplicitImport()
    println("\ntestInlineDefinition")
    testInlineDefinition()
  }

  def testSamePackage(): Unit ={
    println(x)
  }

  def testWildcardImport(): Unit = {
    import Wildcard._
    println(x)
  }

  def testExplicitImport(): Unit = {
    import Explicit.x
    import Wildcard._
    println(x)
  }

  def testInlineDefinition(): Unit = {
    def x = "Object x defined inline"
    import Explicit.x
    import Wildcard._
    println(x)
  }

  object Wildcard {
    def x = "Object bound from Wildcard object"
  }

  object Explicit {
    def x = "Object bound from Explicit object"
  }


}