package com.rockthejvm

object ObjectOrientation extends App{

  // Class and Instance - Instance obtained with keyword 'new'
  class Animal {
    val age: Int = 0
    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  // Inheritance
  class Dog(name: String) extends Animal {   // Constructor Definition (arguments)
    override def eat(): Unit =               // This constructor does not become a
      println("The DAWG eating")             // member of the class. To add it as a
                                             // member,you need to add it as a val
  }

  class Cat(val name: String) extends Animal

  val aDog = new Dog("Lassie")


  val aCat = new Cat("Garfield")
  println("aCat name: " + aCat.name)  // aDog.name would not work

  // Subtype Polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat()  // The most derived method will be called at runtime
                         // i.e. It will go to Dog, and then to Animal

  // Abstract Class -  Cannot be instantiated on its own
  abstract class WalkingAnimal {
    val hasLegs = true   // By default, all fields and methods are public
    def walk(): Unit     // this can be restricted by 'private' or 'protected'
    // Private: Only the class has access to the member/method
    // Protected: Class and descendants have access
  }

  // Interface - Ultimate Abstract Type
  trait Carnivore {                 // You can provide implementations in traits
    def eat(animal: Animal): Unit   // Usually traits are used to denote characteristics
                                    // of objects that can be implemented in concrete Classes
  }

  trait Philosopher {
    def ?!(thought: String): Unit // ?! is a valid method name (kinda weird I guess)
  }

  // Multi Trait Inheritance
  // single-class inheritance + multi trait - this is known as 'Mixing'
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("Eating an animal...")
    override def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)   // Both these lines do the same thing
  aCroc eat aDog    // Infix Notation - ONLY available for methods with 1 argument
  aCroc ?! "What if we could fly?"  // Looks like an operator but it's a method

  // Operators - They are methods in Scala
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)   // These 2 are the same

  // Anyonymous Classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat everything")
  }
  // This took some time to get my head around but here is what I learnt:
  // Anonymous classes do not have a class name
  // Anonymous classes are used for one time, quick behaviour etc.
  // Anonymous classes do not have constructor args, unless the trait it uses does
  // Anonymous classes define new behaviour without a class name
  // HERE IS A COMPARISON between the two:
  //
  //   val newDog = new Animal {
  //     override def eat(): Unit = println("big eater")
  //   }
  //   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  //   This would be an anonymous class because I defined
  //   new behaviour and extended animal
  //
  //   And this code would be a normal class with instantiation:
  //
  //   class Dog extends Animal {
  //     override def eat(): Unit = println("big eater")
  //   }
  //
  //   val newDog = new Dog()

  // Singleton Object
  // Singleton has ONLY ONE
  // Unlike classes, you CAN'T create an instance using 'new'
  // Instantiated ONCE by Scala runtime, and this is used everywhere
  object MySingleton {   // The ONLY instance of the MySingleton type
    val mySpecialValue: Int = 204
    def mySpecialMethod(): Int = 9
    def apply(x: Int): Int = x + 1   // The apply keyword can be used in any class
                                     // to allow instances of it to be called like so:
                                     // className(*args here*) and it is the same as:
                                     // className.apply(*args here*)
                                     // Note: it can be used on Singletons too :D
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)   // These two are
  MySingleton(65)         // the SAME


}
