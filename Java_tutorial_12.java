import java.util.InputMismatchException;
import java.util.Scanner;

// CONTENTS: Polymorphism, dynamic polymorphism, exception handling & finally block

public class Java_tutorial_12 {
    public static void main(String args[]) {

    // POLYMORPHISM = greek words poly, meaning "many", and morph, meaning "form". So, "many forms".
    //                The ability of an object to identify as more than one type

    // Let's say we're having a race and we can enter all different types of vehicles into this race.
    // The vehicles don't have to be the same.

    Car car = new Car();
    Bicycle bike = new Bicycle();
    Boat boat = new Boat();
    // lets put all our vehicles in an array
    Vehicle[] racers = {car,bike,boat}; // Notice the data type! It is Vehicle since our car, bike and
    // boat are all examples of vehicles. If I put Car[] or Bicycle[] or Boat[] it wouldn't work as
    // they are all distinct objects and the data type has to be consistent for each element.
    // So if you want to make an array of objects that are different types, you have to find what type
    // they have in commmon and make an array of that type.
    // So our Vehicle object is polymorphic as it can identiy as multiple types. It is also abstract.

    // This is an enhanced for loop to iterate through all of our vehicles.
    // i represents each vehicle in the racers array. We call the 'go' method for each one.
    for(Vehicle i : racers) {
      System.out.println(i.go());

    }
    System.out.println();



    // DYNAMIC POLYMORPHISM
    // dynamic: In programming, 'dynamic' means after the compilation phase, during the runtime.
    // so dynamic polymorphism is the ability of an object to take different forms after the program
    // is already running.
    // We want to create a dog or cat object, both are child class of the Animal class.
    // But, we will let the user choose whether they create a dog or a cat.
    // So a new Dog or Cat instance will need to be declared but only after the user chooses i.e.
    // after the program is running.
    // Remember, we use the Scanner in Java to get user input

    Scanner scanner = new Scanner(System.in);
    System.out.println("What animal do you want to make? \n1 = dog \n2 = cat");
    Animal animal;
    // This is one of the benefits of dynamic polymorphism. We can decalre an object and make space for
    // it in memory even if we don't know exactly what type of object we want yet. Here we said we want
    // an animal and we made room in the program for an animal object. But, we don't know what animal it
    // will be - a dog, or a cat.
    int choice = scanner.nextInt();

    if (choice == 1) {
      animal = new Dog(); // at this point, our animal decalred object assumes a form. Its form inherits
      // and overrides (if relevant) all methods & variables from parent class.
      System.out.println(animal.speak());
    } else if (choice == 2 ){
      animal = new Cat();
      System.out.println(animal.speak());
    } else {
      System.out.println("That choice was invalid");
    }
    System.out.println();


    // EXCEPTION HANDLING
    // exception = an event that occurs during the execution of a program that disrupts the normal flow
    // of instructions in it.
    // Lets say we have a program that divides two numbers and displays the result.
    Scanner scanner1 = new Scanner(System.in);

    try {
      System.out.println("Enter a whole number to divide: ");
      int x = scanner1.nextInt();
      System.out.println("Enter a whole number to divide by: ");
      int y = scanner1.nextInt();
      scanner1.close();
      int z = x / y;
      System.out.println("Result: " + z);
    }
    catch(ArithmeticException excep) {
      System.out.println("You can't divide by 0 fool!");
    }
    // if we divide by 0 we get an Arithmetic Exception. We can prevent this by using a 'try block'.
    // which is like an if statement but for seeing if a piece of code can be executed. If an exception
    // is encountered, the code in our 'catch block' is executed. The catch() is expecting a certain type
    // of exception, which in our case is the ArithmeticException. The type of exception is the data type
    // here for the catch param, which we've called 'excep'

    catch(InputMismatchException excep) {
      System.out.println("Please enter a number");
    }

    // catch(Exception e) {} This is a general catch block to catch all exceptions but it's considered lazy.

    // FINALLY BLOCK
    // a finally block will always execute whether or not we encounter an exception.
    finally {
      System.out.println("This will always print");
      scanner.close();
      scanner1.close(); // a good use of the finally block is to close any scanners or files open
    }
  }

}


// POLYMORPHISM
abstract class Vehicle {
  abstract String go();
}

public class Car extends Vehicle {

  @Override
  public String go (){
    return "The car begins moving";
  }
}

public class Bicycle extends Vehicle {

  @Override
  public String go() {
    return "The bicycle begins moving";
  }
}

public class Boat extends Vehicle {

  @Override
  public String go() {
    return "The boat begins moving";
  }
}

// DYNAMIC POLYMORPHISM
abstract class Animal {

  abstract String speak();
}

public class Dog extends Animal {

  @Override
  public String speak() {
    return "*bark*";
  }
}

public class Cat extends Animal {

  @Override
  public String speak() {
    return "*meow*";
  }
}
