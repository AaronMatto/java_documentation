// CONTENTS: Inheritance, Method Overriding, Super Keyword


public class Java_tutorial_9 {
  public static void main(String args[]){
    // INHERITANCE
    // inheritance = the process where one class acquires the instance variables and methods of another.

    Car car = new Car();
    Bicycle bike = new Bicycle();
    System.out.println(car.go()); // prints "The vehicle is moving"
    System.out.println(bike.speed); // prints 0.0
    System.out.println(car.doors); // prints 4
    System.out.println(bike.pedals); // prints 2
    System.out.println();
    // so use inheritance if many classes you want to make have a lot of characteristics/behaviour in common.


    // METHOD OVERRIDING
    // method overriding = declaring a method in a sub class, which has already been defined in a parent class.
    // Such that, the child can have its own unique definition of that method e.g. toString().
    Dog dog = new Dog();
    System.out.println(dog.speak()); // prints "The dog barks" NOT "The animal speaks"
    System.out.println();

    // SUPER KEYWORD
    // super = a keyword that refers to the superclass(parent) of an object. Very similar to
    // "this" keyword.
    Hero hero1 = new Hero("Batman", 42, "money");
    // so when we create a Hero object, we pass in a name, age and power. When we construct a hero object,
    // our parameters are set up to accept a name, age and power. We immediately send the name and age values
    // via super() to the person class where its constructor assigns an age and a name.
    System.out.println(hero1.age); // this is how we're able to type this
    System.out.println();
    // So when we create a Hero object, we're also creating a Person object ?
    // Every Hero is a Person but not every Person is a Hero ?
    // So this Hero, hero1, is a Person with name "Batman" and age 42... hero1 is also a Hero with power "money"
    Hero hero2 = new Hero("superman", 43, "everything");
    System.out.println(hero2.toString());



  }

}

// INHERITANCE
public class Vehicle { // The parent class or "super" class. Car and bicyle are sub or child classes.
  double speed;

  String go() {
    return "This vehicle is moving";
  }


  String stop() {
    return "This vehicle is stopped";
  }
}


public class Car extends Vehicle {
  // we make a class inherit from its parent by typing "extend PARENT_NAME"
  // when creating the child
  // so we have created Car class which inherits from Vehicle

  // now we can add characteristics and behaviour unique to cars only:
  int wheels = 4;
  int doors = 4;
}

public class Bicycle extends Vehicle {
  int wheels = 2;
  int pedals = 2;
}


// METHOD OVERRIDING
public class Animal {

  String speak() {
    return "The animal speaks";
  }
}

public class Dog extends Animal {

  @Override // this is convention when creating an overriding method for readability.
  String speak(){
    return "The dog barks";
  }
}


//SUPER KEYWORD
public class Person {
  String name;
  int age;

  Person(String name, int age){
    this.name = name;
    this.age = age;
  }

  public String toString() {
    return this.name + "\n" + this.age + "\n";
  }
}

public class Hero extends Person {

  String power;

  Hero(String name, int age, String power){
    super(name, age);
    // Since we declared name and age variables in the Person class, we should assign these values
    // within the constructor for the Person class. Hero class only has a power variable declared so
    // it is assigned within this specific class. i.e. variables should be assigned in the class they
    // are declared in. We do this by using super() in the constructor of the child class and passing in
    // the relevant arguments for the variables declared in the parent class. Notice we still have to
    // declare all the variables in the child's constructor even though we use super().
    // super is referring to the parent class, it is essentially "this" but for parent of current class.
    // this ONLY refers to the class it is used in.
    this.power = power;
  }

  // We can also use the super keyword to call a method within the super class.
  public String toString() {
    return super.toString() + this.power;
    // look in the superclass for a method called toString();
    // then add this classes instance variable power to its output.
  }
}
