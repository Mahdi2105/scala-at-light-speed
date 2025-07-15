package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

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

  // "Pseudo Collections": Option, Try (These 2 are monads)
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

  // Async Programming
  // Evaluate something on another thread
  // Futures
  val aFuture = Future {
    println("Loading....")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }
  // Here the second println would not run because the main thread would have
  //    ended before it could execute - so it does not run
  // To combat this, we can make the main thread wait a little longer
  Thread.sleep(2000)

  // Future is a "collection" which has a value when it is evaluated

  // Implicits
  // 1) Implicit Arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs)
  // myImplicitInt is automatically assigned as an argument for aMethodWithImplicitArgs

  // 2) Implicit Conversions
  implicit class MyRichInt(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven())
  // Because this shouldn't normally work, it looks for an
  //    implicit wrapper to try make it work

}
