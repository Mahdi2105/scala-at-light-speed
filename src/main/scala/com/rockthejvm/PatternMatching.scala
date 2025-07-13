package com.rockthejvm

object PatternMatching extends App {

  // Switch Expression
  val anInt = 55
  val order = anInt match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => anInt + "th"
  }
  // Pattern Match is an EXPRESSION
  // So it can be reduced to a value

  println(order)   // Returns: 55th

  // Case Class Decomposition
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43)   // Person.apply("Bob", 43) - Dont need 'new' keyword

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  } // Matching against the structure - so bob needs to be in the structure
    // of Person with a name and age

  println(personGreeting)

  // Deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDesc = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I dont know what you're talking about"
  }

  println(bandDesc)

  // Deconstructing Lists
  val aList = List(1, 2, 3)
  val listDesc = aList match {
    case List(_, 2, _) => "List containing 2 at index 1"
    case _ => "Unknown List"
  }
  // Here List(_, 2, _) means it can only contain 3 elements with '2' in the middle
  // To search for 2 anywhere in the middle, you can do: case _ :+ 2 :+ _ =>
  // If no match, it will throw MatchError, so case _ is recommended
  // Pattern Matching will try all the cases in sequence

  println(listDesc)
}
