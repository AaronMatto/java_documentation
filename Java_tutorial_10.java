// Packages are just a collection of classes. Classes are a collection of code.

// CONTENTS: Abstract Keyword, Access Modifiers & Packages

public class Java_tutorial_10 {
  public static void main(String args[]) {
    // ABSTRACT CLASSES
    // abstract: abstract classes cannot be instantiated, but they can have a subclass
    //           abstract methods are declared without an implementation/body

    // Vehicle vehicle = new Vehicle();
    Car car = new Car();
    // we can create instances of these classes as normal, but we may not want to be able to do so
    // using the abstract keyword adds a layer of security
    // lets say we walk into a car dealership and we ask a salesperson for a vehicle. They say 'what kind?'
    // I reply 'Nah, just a vehicle'. This doesn't make sense as saying I want a vehicle is too generic.
    // A vehicle is an idea here, it's abstract, we need a specific type of vehicle.
    // So, what we can do to prevent someone from creating an instance of a class that is too vague/abstract
    // is to use the 'abstract' modifier. Hence the error on line 12, we can no longer create instances of
    // the 'Vehicle' class. We can however still create instances of its children i.e. Car.

    // ABSTRACT METHODS
    System.out.println(car.go());


    // ACCESS MODIFIERS
    // access modifiers also add a layer of security to programs. There are 3 access modifiers:
    // Modifier        Class        Package        Subclass        World
    // public            Y             Y               Y             Y
    // protected         Y             Y               Y             N
    // no modifier       Y             Y               N             N
    // private           Y             N               N             N

    // GO TO package2/Asub

  }
}


public abstract class Vehicle {

  abstract String go(); // {} We don't need curly braces as abstract methods don't have a body
  // this forces us to implement/define the method in one of the child classes.
  // In our case, the Car class MUST implement the method go(); or else we get an error.
}

public class Car extends Vehicle {

  @Override // we are technically overriding the method even though it has no body in Vehicle.
  String go(){ // the return type of this method "String" must be the same as in Vehicle.
    return "The driver is driving the car.";
  }

}
