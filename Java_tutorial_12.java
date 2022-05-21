// CONTENTS: Polymorphism, dynamic polymorphism, exception handling



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
  }

}

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
