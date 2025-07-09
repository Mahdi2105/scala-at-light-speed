package com.rockthejvm

object FunctionalProgramming extends App{

  // Scala is an Object Orientated Language
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("bob")
  bob.apply(33)
  bob(33)                       // Invoking bob as a function due to apply

  // Scala runs on the JVM
  // Functional Programming:
  //  - Compose Functions
  //  - Pass functions as Args
  //  - Return functions as results

  // FunctionX
  // ALL Scala functions are instances of these FUNCTION_X types
  // FunctionX: Function1, Function2... Function22 (22 max number of args allowed on func)
  val simpleIncrementor = new Function1[Int, Int] {   // Takes an Int, Returns an Int
    override def apply (arg: Int): Int = arg + 1      // arg can be named anything, e.g. num
  }

  simpleIncrementor.apply(23)   // Returns 24
  simpleIncrementor(55)         // Returns 56

  println(simpleIncrementor(99))

  val stringConcat = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = s"$arg1 $arg2"
  }

  println(stringConcat("My name is:", "Mahdi"))

  // Syntax Sugars - alternative syntax to replace heavier boilerplate
  // val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  // This is the same as:
  //    val doubler = new Function1[Int, Int] {
  //      override def apply(x: Int): Int = 2 * x
  //    }

  // This can be further simplified to:
  val doubler: Int => Int = (x: Int) => 2 * x

  // And this further to:
  // val doubler = (x: Int) => 2* x

  // Higher Order Functions
  // Take functions as arg and/or return functions as results
  val aMappedList = List(1, 2, 3).map((x: Int) => x + 1)   // Do NOT need to clarify that
  println(aMappedList)                                     // x should be an Int because
                                                           // it is auto inferred, but I did

  // val aFlapMappedList = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  // Here is the same thing with alternative syntax (spacing):
  val aFlapMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  }
  // Without flatMap it would look like:
  // List(List(1, 2), List(2, 4), List(3, 6))
  println(aFlapMappedList)

  // val aFilteredList = List(1, 2, 3, 4, 5).filter { x =>
  //   x <= 3
  // }
  // Here is a shorter syntax:
  val aFilteredList = List(1, 2, 3, 4, 5).filter(_ <= 3) // _ is the same as:
  println(aFilteredList)                                 // arg => arg

  // All pairs between 1, 2, 3 and 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap { number =>
    List('a', 'b', 'c').map { letter =>
      s"$number$letter"
    }
  }

  println(allPairs)

}
