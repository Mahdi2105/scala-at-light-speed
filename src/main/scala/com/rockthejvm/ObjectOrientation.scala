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
    val hasLegs = true   // By default all fields and methods are public
    def walk(): Unit     // this can be restricted by 'private' or 'protected'
    // Private: Only the class has access to the member/method
    // Protected: Class and descendants have access
  }

  // Interface - Ultimate Abstract Type
  trait Carnivore {                 // You can provide implementations in traits
    def eat(animal: Animal): Unit   // Usually traits are used to denote characteristics
                                    // of objects that can be implemented in concrete Classes
  }

  // Multi Trait Inheritance
  // single-class inheritance + multi trait - this is known as 'Mixing'
  class Crocodile extends Animal with Carnivore {
    override def eat(animal: Animal): Unit = println("Eating an animal...")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)   // Both these lines do the same thing
  aCroc eat aDog    // Infix Notation - ONLY available for methods with 1 argument

}
