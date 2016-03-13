package be.piyush.scala

/**
 * @Author Piyush Kaila
 */

trait Singer {
  def sing {
    println( "singing ..." )
  }
}

class Bird extends Singer

class Person {
  def tell {
    println( "here's a little story ..." )
  }
}

object Mixins {
  def main(args: Array[String]) {
    val singingPerson = new Person with Singer // Person who can sing.
    singingPerson.sing

    val person = new Person
    person.tell
  }
}