// CONTENTS: Array of objects, pass objects as arguments to method, static keyword modifier


public class Java_tutorial_8 {

  public static void main(String args[]) {
    // ARRAY OBJECTS
      // remember, when creating an array we decalre data type it holds, then [] for an array,
      // then variable name, then =, then new, data type again and finally the no. of elements it will hold:
      // int[] numbers = new int[5];
      // what about an array of objects?
      Food[] refrigerator = new Food[3];
      // here we first declare the object (data) that will be stored in the array followed by [],
      // then name of variable to store array in, then =, then new, data type again and no. of elements
      // so our array refrigerator is going to store 3 instances of Food class
      Food food1 = new Food("pizza");
      Food food2 = new Food("burger");
      Food food3 = new Food("banana");

      refrigerator[0] = food1;
      refrigerator[1] = food2;
      refrigerator[2] = food3;
      System.out.println(refrigerator[0]); // prints out address of food1 in memory
      System.out.println(refrigerator[0].name); // prints "pizza"



      Food[] refirgerator_two = {food1, food2, food3}; // another way of creating the array and
      // assigining the instances but assigining them straight away instead

    // OBJECT ARGUMENTS
      // we have two classes below: Car and Garage. We want to create instances of Car to send to Garage
      Garage garage = new Garage();
      Car car = new Car("BMW");
      System.out.println(garage.park(car));  // prints "The BMW is parked in the garage"

      System.out.println();

    // STATIC keyword
      Friend friend1 = new Friend("Spongebob");
      System.out.println(Friend.numberOfFriends); // as it is a class method, it means every instance
      // of Friend has this variable and every instance has the same value for it
      // prints 1 as we have created one instance of Friend. So really, this variable numberOfFriends
      // is just counting our instances for us.
      // Friend friend2 = new Friend("Patrick");
      // System.out.println(Friend.numberOfFriends); would print 2 since friend1 and friend2
      // are sharing the numberOfFriends variable as there is only one copy of it. The class itself
      // owns the variable. Like using self in method definition in Ruby.
      // It is also possible to access the static variable using the named instance of an object:
      System.out.println(friend1.numberOfFriends); // This is not recommended, hence the warning underline.
      // if we removed static keyword from where we declared numberOfFriends, line 41 wouldn't work
      // friend1.numberOfFriends would print 1 even if we made several instances of Friend, as each
      // instance would have their own variable numberOfFriends and not share a copy. This variable
      // would simply be incremented by 1 upon creating the instance itself and hence
      // that instance.numberOfFriends would only ever return 1.
      System.out.println();
      Friend.displayFriends(); // this is an example of a static method! It is a class method.
      // static methods can also take instances of their class as arguments.


  }
}

// ARRAY OBJECTS
public class Food {
  String name;
  Food(String name) {
    this.name = name;
  }
}


// OBJECT ARGUMENTS
public class Garage {

  String park(Car car_object){
    // What's key here is that when we declare the data type of the parameter, we state it as the class
    // of the object that the method is expecting to use
    return ("The " + car_object.name + " is parked in the garage.");
  }
}


public class Car {
  String name;
  Car(String name) {
    this.name = name;
  }
}

// STATIC KEYWORD modifier
  // 'static' is a key word, it is a modifier. A single copy of the variable or method it is used
  // to create will be made and shared. The class "owns" the static member, so it is shared by all
  // instances of that class. So basically, it is a CLASS variable or CLASS method. Example:

public class Friend {

  String name;
  static int numberOfFriends; // this means all instances of the class Friend have the integer variable
  // numberOfFriends;

  Friend(String name) {
    this.name = name;
    numberOfFriends++; // so now, every time a new instance of friend is made, we add 1 to the number
    // of friends that our Friend class has.
  }

  static void displayFriends() {
    System.out.println("You have " + numberOfFriends + " friends");
  }



}
