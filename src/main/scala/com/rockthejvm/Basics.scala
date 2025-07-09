package com.rockthejvm

object Basics extends App {

  // Defining a value
  val meaningOfLife: Int = 42   // this is a constant, a val cannot
                                // be reassigned

  val aBoolean = false          // This is auto assigned due to the value

  // Int, Boolean, Char, Double, Float, String and others

  val aString = "I love scala"
  val anInterpolatedString = s"The Meaning of Life is $meaningOfLife"


  // Expressions - structures that can be reduced to a value

  val anExpression = 2 + 3

  // If -Expression-

  val ifExpression = if (meaningOfLife > 43) 56 else 999
  println("If Expression: " + ifExpression)

  val chainedIfExpression = {
    if (meaningOfLife > 45) 56
    else if (meaningOfLife < 0) 111
    else if (meaningOfLife > 0) 555   // This should be the output
    else 0
  }

  println("Chained Expression: " + chainedIfExpression)

  // Code Blocks

  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    aLocalValue + 3   // The last expression(70) becomes
                      // the value of the code block
  }

  println("Code block: " + aCodeBlock)

  // Functions

  def myFunction(x: Int, y:String): String = {
    y + " " + x
  }

  // Recursion - In scala we dont use loops or iteration - HEAVILY discouraged

  def factorial(n: Int): Int =
    if (n <=1) 1
    else n * factorial(n-1)

  println("Factorial: " + factorial(5))

  // Unit Type - No meaningful value === "void" in other languages
  // type of SIDE EFFECTS - they don't carry any value that can be used
  // and example is the println function
  println("This has no meaningful value")

  def returningUnitFunction(): Unit = {
    println("I dont love returning Unit")
  }

  val theUnit = ()

  println("Returning Unit: " + returningUnitFunction())
  println("The Unit: " + theUnit)

  val myExample = {
    if (returningUnitFunction() == theUnit) true
    else false
  }

  println(myExample)

}
