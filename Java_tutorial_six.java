//CONTENTS: Intro to OOP, initialising instances and how to use 'self'


public class Java_tutorial_six {

  public static void main(String args[]){
    // object = instance of a class that may contain attributes(instance variables) and methods to model behaviour
    // we will create car objects. So we need to create a new class for this, which can be done in a new
    // java file or within this file outside of the main class we're currently in.

    Car myCar = new Car(); // first is the name of the class. Next is the name for the variable that holds the
    // instance of the class. We called it "myCar". We then type '= new name_of_class' again to assign the
    // variable to the new instance of the class we're making.
    System.out.println(myCar.make); // prints out our instance variable value
    myCar.drive(); // executes the steps in drive()

    System.out.println();

    Car myOtherCar = new Car(); // can make as many instances as we like
    System.out.println(myOtherCar.model);

    System.out.println();
    Human humanOne = new Human("Rick", 65, 70);
    Human humanTwo = new Human("Morty", 16, 50);
    humanOne.eat();
  }
}

public class Car { // strictly speaking, each class should have its own file
  String make = "lamborghini";
  String model = "aventador";
  int year = 2012;
  String color = "black";
  double price = 120000.00;

  void drive() {
    System.out.println("The car drives");
  }

  void brake() {
    System.out.println("You step on the brakes");
  }
}


// CONSTRUCTORS - creating objects/instances with different characteristics. In other words, params in initialize in ruby.
public class Human {
  String name;
  int age;
  double weight;
  Human(String name, int age, double weight) {
    // This is it, we have our constructor or "def inintialize". This will fire
    // automatically when a new instance of the class is instantiated. So currently, in order for us
    // to construct a Human object, we must supply a name age and weight.
    this.name = name;
    this.age = age;
    this.weight = weight;
    // this here is effectively 'self' in ruby to refer to the instance. We're saying:
    //  set the value of this instance being created's name (this.name) to the value supplied as an argument.
    //  and the same for the other instance variables.
    // Constructors allow us to create different instances with the same attributes but different values for those attributes.
    // *** notice how we had to declare the instance variables first above the constructor class ***

    // eat(); We can also call other methods in our constructor function so they fire when instance is created
  }

  void eat() {
    System.out.println(this.name + " is eating"); // again, the 'this' keyword here refers to the instance that
    // the eat() method would be called on e.g. humanTwo.eat();
    // So, using 'this' inside a method definition makes it an instance method
  }
}
