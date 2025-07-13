package com.rockthejvm

import scala.util.{Success, Failure, Try}

object Advanced extends App {

  // Lazy Evaluation - Not evaluated until its first used
  // Useful in infinite collections
  // Normal vals are evaluated when they are initiated, hence why in the example
  //    below, if there was no 'lazy' at the start, the println would run
  lazy val aLazyVal = 2
  lazy val lazyValWithSideEffects = {   // Because it is a lazy val,
    println("I am so very lazy")        //  this won't be printed - until used
    43
  }

  val eagerValue = lazyValWithSideEffects + 1
  // NOW println would run because 'lazyValWithSideEffects' is being used

  // "Pseudo Collections": Option, Try
  // Option - Checks for null
  def methodWhichCanReturnNull(): String = "Hello, Scala"
  //  if (methodWhichCanReturnNull() == null) {
  //    // Defensive Code Against Null
  //  }
  // However, in Scala this can be done:
  val anOption = Option(methodWhichCanReturnNull())   // Returns: Some("Hello Scala")
  // Option is like a container with 0 or 1 item:
  //    -> Some(value) -  if not null
  //    -> None - if null

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  println("Option String Processing: " + stringProcessing)

  // Try - Guards against methods which can throw exceptions
  def methodWhichCanThrowException(): String = throw new RuntimeException()

  //  try {
  //    methodWhichCanThrowException()
  //  } catch {
  //    case e: Exception => "Defend against exception"
  //  }
  // Instead scala has a better way:
  val aTry = Try(methodWhichCanThrowException())
  // Try is a collection with either:
  //    -> Value - If code went well
  //    -> Exception - If an exception is thrown

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }

  println("Try String Processing: " + anotherStringProcessing)

}
