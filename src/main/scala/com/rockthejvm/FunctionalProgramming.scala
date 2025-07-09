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
  val simpleIncrementor = new Function1[Int, Int] {  // Takes an Int, Returns an Int
    override def apply (arg: Int): Int = arg + 1     // arg can be named anything, e.g. num
  }

  simpleIncrementor.apply(23)  // Returns 24
  simpleIncrementor(55)        // Returns 56

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
}
