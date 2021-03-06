import java.util.Random;

// CONTENTS: OOP continued: scope (as it is different to ruby in java for oop), Overloaded constructors,
// toString(); method,




public class Java_tutorial_7 {
  public static void main(String args[]) {
    // SCOPE
    DiceRoller dice = new DiceRoller(); // creating the new instance automatically outputs the random number from roll();
    DiceRoller dice_two = new DiceRoller();
    dice_two.roll_again(); // gives us a random number also

    System.out.println();

    // OVERLOADED CONSTRUCTORS
    Pizza pizza_one = new Pizza("thicc crust", "tomato", "mozzarella", "pepperoni");
    // need matching args as params are the rules. Need 4 strings.
    System.out.println("Your pizza ingredients:");
    System.out.println(pizza_one.bread);
    System.out.println(pizza_one.sauce);
    System.out.println(pizza_one.cheese);
    System.out.println(pizza_one.topping);

    System.out.println();

    Pizza pizza_two = new Pizza("thin crust", "tomato", "mozzarella");
    System.out.println("Your second pizza ingredients:");
    System.out.println(pizza_two.bread);
    System.out.println(pizza_two.sauce);
    System.out.println(pizza_two.cheese);
    // so here we were able to create a pizza and supply only three params instead of 4 due to our
    // overloaded constructor methods. The second constructor only requires 3 params and hence has
    // a different signature. This is done in Ruby as def initialize(args = {}).
    // We can create a constructor with no params if we want to be able to create an instance with no variables.
    System.out.println();

    Car my_car = new Car();
    System.out.println(my_car.toString());

    System.out.println();

    System.out.println(my_car);
  }
}




// SCOPE
public class DiceRoller {

  Random random_object_two = new Random();
  // random_object_two is a global variable hence can use in roll_again();. It could also have been
  // assigned to 'new Random()' in constructor if we liked

  DiceRoller(){ // this is our constructor
    Random random_object = new Random(); // local! Only visible to constructor
    // random_object = new Random(); We could also do this if we declare random object outside constructor
    // i.e. can declare a variable outside it and assign it in constructor meaning it is global but assigned a value
    // when an instance is instantiated.
    // int number = 0;
    // roll();  - This will not work even if roll() had no params. Why? If roll() had no params, it would
    // not have access to our instance variable random_object. In other words, instance
    // variables are locally scoped to the constructor. An alternative
    roll(random_object);
  }

  void roll(Random random_object_param) {
    int number = random_object_param.nextInt(6) + 1; // .nextInt generates a random number between 0-5
    System.out.println(number);
  }

  void roll_again () { // same method but use global variables
    int number = random_object_two.nextInt(6) + 1;
    System.out.println(number);
  }
  // local = declared inside a method and visible only to that method
  // global = declared outside method but within a class and visible to all parts
  // of that class
}




// OVERLOADED CONSTRUCTORS
// overloaded constructors = multiple constructors in one class but have different parameters,
//                           much like an overloaded method
//                           name + params = signature
// So different constructors with the same name have different signatures

public class Pizza {
  String bread;
  String sauce;
  String cheese;
  String topping;


  Pizza(String bread, String sauce, String cheese, String topping) {
    this.bread = bread;
    this.sauce = sauce;
    this.cheese = cheese;
    this.topping = topping;
  }

  Pizza(String bread, String sauce, String cheese) {
    this.bread = bread;
    this.cheese = cheese;
    this.sauce = sauce;
  }


}


// TO STRING METHOD
//  toString(); = special method that all objects natrually inherit, that returns a string which
//                "textually represents" the object it was called on. Can be used
//                implicitly or explicitly.

// example
public class Car {
  String make = "ford";
  String model = "mustang";
  String color = "red";
  int year = 2021;

  // if we wanted to display each of these before we'd have:
  // Car my_car = new Car();
  // System.out.println(my_car.make)
  // A print line statement for every variable once we'd created an instance of the class
  // System.out.println(my_car) will just give us the address of the instance in memory
  // System.out.println() actually implicitly uses toString(); behind the scenes
  // System.out.println(my_car.toString()) will return the same as line 126
  // We can Over Ride (method over-riding is another topic) the toString(); method within
  // our Car class so that when it's called on an instance it does something else


  public String toString() {
    String myString = make + "\n" + model + "\n" + color + "\n" + year;
    return myString;
  }

  // now when we call System.out.println(my_car.toString()) , myString is returned
  // We can also just do this: System.out.println(my_car) , as remember toString() is implicitly called
  // by System.out.println(); !
  // see examples in main method
}
