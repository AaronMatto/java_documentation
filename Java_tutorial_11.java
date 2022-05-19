// CONTENTS: Encapsulation, Copy Objects,

public class Java_tutorial_11 {

  public static void main(String args[]) {

    // ENCAPSULATION
      // encapsulation = attributes of a class will be hidden or private,
      //                 - Can only be accessed only through methods (getters and setters)
      //                 - You should make attributes private if you don't have a reason to make them
      //                   public or protected.

      Car car = new Car("Chevrolet", "Camaro", 2021);
      // System.out.println(car.make); This won't work becaue make is a private variable.
      // We can use a getter method in the Car class
      System.out.println(car.getMake()); // This works. The method is public. This is how we can access a
      // private attribute

      // How can we change the values of the private attributes of an object? Setters!
      // car.year = 2022; This won't work.

      car.setYear(2022); // This now works!
      System.out.println();
      System.out.println(car.getYear());
      System.out.println();
      // So, using private keyword, the variables aren't directly accessible to read or write.
      // They can be read and written using getters and setters.

    // COPY OBJECTS
      Car car1 = new Car("Chevrolet", "Camaro", 2021);
      Car car2 = new Car("Ford", "Mustang", 2022);

      System.out.println(car1); // prints address of car1 object in memory
      System.out.println(car2); // prints address of car2 object in memory
      System.out.println();
      System.out.println(car1.getMake());
      System.out.println(car1.getModel());
      System.out.println(car1.getYear());
      System.out.println();
      System.out.println(car2.getMake());
      System.out.println(car2.getModel());
      System.out.println(car2.getYear());

      // Now, if we want to copy car 1's values into car2 you'd think we do this
      // car2 = car1;      ......BUT WE DON'T WANT TO DO THIS! WHY? Uncomment line below to see
      // System.out.println(car2); ...We can see here that the address of car2 in memeory becomes that
      // of car1! It appears car2 has all the values of car1, however, car2 is no longer a distinct
      // object from car1. Essentially, car1 and car2 are now the EXACT same car. They point to the same
      // car in memory. So how do we actually copy an instance of the Car class? We create a method in it
      car2.copy(car1);
      System.out.println();
      // Now car2's values are a copy of car1 BUT it remains a distinct object in memory
      System.out.println(car1);
      System.out.println(car2);

      // We can copy an instance's values when we are creating a new instance of the same class too:
      // line 121.
      Car car3 = new Car(car1);
      System.out.println(car3); // a new distinct car.


  }
}

public class Car {
  private String make;
  private String model;
  private int year;


  Car(String make, String model, int year) {
    this.make = make; // setMake(make)

    // this.model = model;
    setModel(model);

    // this.year = year;
    setYear(year);
  }

  // Getters
  public String getMake(){
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  // Setters
  public void setMake(String make) {
    this.make = make; // This means we no longer need line 35 in the constructor, so could comment it out!
    // Instead, we'd place our setMake method there instead. See below for an example.
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setYear(int year) {
    this.year = year;
  }

  // COPY
  public void copy(Car car_instance){
    this.setMake(car_instance.getMake());
    this.setModel(car_instance.getModel());
    this.setYear(car_instance.getYear());
    // 'this' refers to the object or instance that is getting its values changed (car2 in our example)
    // car_instance refers to the object that is BEING copied (car1 in our example)
    // so we use setters for the object to become the copy and getters for the object being copied.
    // we pass in the instance of the object being copied
    // this always refers to the instance that CALLS the method hence we have car2.copy(car1);
    // car is is CALLING the copy method to copy another instance of car.
    // 'this' instance i.e. car2.setMake etc
  }

  // Creating a new instance with the same values as another via an overloaded constructor.
  // This constructor takes an instance to be copied as an argument
  Car(Car car_instance) {
    this.copy(car_instance);
  }
  // we simply call our copy method.



}
