// CONTENTS: while loops, for loops, nested loops, arrays, 2D arrays, String methods
import java.util.Scanner;

public class Java_tutorial_3 {
  public static void main (String[] args) {
    // LOOPS
      // While loops. Continue to perform a block of code while a conidition is true.
      Scanner scanner = new Scanner(System.in);
      String name = "";
      while(name == "") {  // could also use name.isBlank()
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
      }

      System.out.println("Hello " + name);

      // Do while loops will always perform one loop of the code and THEN check if the condition is true
      int age = 4;
      do {
        System.out.println("What's your age?");
        age = scanner.nextInt();
      } while (age < 3);

      // For Loops. Executes a block of code a limited amount of times. Same as JS.
      for (int i = 0; i <= 10; i += 2) {   // we can increment i by 1 with i++ OR decrement with i -= 2 etc.
        System.out.println(i);

      }

      // Nested loops
      int rows;
      int columns;
      String symbol = "";
      System.out.println("Enter number of rows");
      rows = scanner.nextInt();
      System.out.println("Enter number of columns");
      columns = scanner.nextInt();
      System.out.println("Enter a symbol");
      symbol = scanner.next();

      for (int i = 1; i <= rows; i++) {
        System.out.println(); // This creates a new line
        for (int j = 1; j <= columns; j++) { // the value of j is reset to 1 with each new value of i
          System.out.print(symbol);
        }
      }

    // ARRAYS
      System.out.println();
      System.out.println(); // just making new lines in terminal output for clarity
      String[] cars = {"Ford", "Mercedes", "Ferrari"}; // IN JAVA ALL ELEMENTS MUST BE THE SAME DATA TYPE ...   int[] nums    would only accept integers
      System.out.println(cars[2]); // prints ferrari
      // cars[3] = "Lambo"; // This will not add a new element to our array and will error
      cars[0] = "BMW"; // This re-assigns the value of the element at index 0 to "BMW"

      // An additional way to create an array is by first allocating the amount of elements it will hold and then
      // storing the values for them later on in the program
      String[] cars_two = new String[3]; // This is saying we are going assign 3 elements to this array. These will be
      // string objects hence 'new String'. So 3 is the length of the array.
      cars_two[0] = "BMW";
      cars_two[1] = "Tesla";
      cars_two[2] = "Porsche";

    // ITERATE through an array
      for (int i = 0; i < cars_two.length; i++) {
        System.out.println(cars_two[i]);
      }

      System.out.println();

    // 2D ARRAYS
      String[][] cars_three = new String[3][3]; //the first 3 is rows and the second 3 is columns
      // String[][] cars_three = {
      //                           {"Camaro", "Corvette", "Car"},
      //                           {"Mustang", "Ranger", "Landrover"},
      //                           {"Ferrari", "Lambo", "Tesla"}
      //                         };
      // This would be an equivalent way of creating the same 2D array
      cars_three[0][0] = "Camaro";
      cars_three[0][1] = "Corvette";
      cars_three[0][2] = "Car";

      cars_three[1][0] = "Mustang";
      cars_three[1][1] = "Ranger";
      cars_three[1][2] = "Landrover";

      cars_three[2][0] = "Ferrari";
      cars_three[2][1] = "Lambo";
      cars_three[2][2] = "Tesla";

      for(int i = 0; i < cars_three.length; i++){
        System.out.println(); // just so we can see each set seperately
        for(int j = 0; j < cars_three[i].length; j ++){
          System.out.print(cars_three[i][j] + " "); // use System.out.print so each element in a nested array is printed on the same line
        }
      }

    // STRING METHODS
      String name_two = "Aaron";
      boolean result = name.equals("Aaron"); //equals checks if the string value of a variable and the value of a supplied string match.
      // can also use name.equalsIgnoreCase("") if you'd like to ignore case
      int result_length = name.length();
      char result_char = name.charAt(0); // this is 0 indexed
      int result_index = name.indexOf();
      boolean result_empty = name.isEmpty(); //checks if variable is empty string
      String result_uppercased = name.toUpperCase();
      String result_replace = name.replace('a', 'A') // replaces all instances of first letter with second

  }
}
