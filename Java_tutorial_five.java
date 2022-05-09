// CONTENTS: Overloaded methods, printf, final keyword

public class Java_tutorial_five {
  public static void main (String args[]) {
    // OVERLOADED METHODS
      // overloaded methods = methods that share the same name but have different parameters.
      //                      Different paramters means they can have the same name in each method
      //                      but be a different type (lines 56 & 66). Or, they can share names in each
      //                      method but there is a different amount of parameters (lines 56, 61)
      //                      method name + paramters = method signature
      //                      so overloaded methods have different signatures due to diff params

      int x = add(1, 2);
      System.out.println(x);

      int y = add(3,4,5,6);
      System.out.println(y);  // It looks like we're calling the same method on lines 15 and 18 but we aren't
      // we have an overloaded add method which can now accept either 2 or 4 int arguments, NOT 3. Or two string args.

      String q = "h"; // MUST use '' to declare a char type and "" for String type
      String w = "5";
      String s = add(q, w);
      System.out.println(s);

      // PRINT F EXAMPLES, see below for theory. Run the file and follow theory!
      System.out.printf("This is a format string %d", 123);

        System.out.println(); // NEW LINE IN TERMINAL

      String myString = "Haha";
      System.out.printf("This is %10s", myString); // --> prints "This is      Haha"

        System.out.println(); // NEW LINE IN TERMINAL

      float myFloat = 9.11436f;
      System.out.printf("You have %.2f dollars", myFloat); // --> prints "You have 9.11 dollars"

        System.out.println(); // NEW LINE IN TERMINAL

      String mySecondString = "Haha";

        System.out.println(); // NEW LINE IN TERMINAL

      System.out.printf("This is %-10s", mySecondString); // --> "This is Haha      "

        System.out.println(); // NEW LINE IN TERMINAL

      double myDouble = -9.14323;
      System.out.printf("You have %+.2f dollars", myDouble); // --> "You have -9.14 dollars"

        System.out.println();
  }

  static int add(int a, int b) {
    System.out.println("Overloaded method one");
    return a + b;
  }

  static int add(int a, int b, int c, int d){
    System.out.println("overloaded method two");
    return a + b + c;
  }

  static String add(String a, String b) {
    return a + b;
  }

  // PRINTF, kind of like interpolation, except it's called formatting
    //printf() = an optional method to control, format and display text to the console
    //           two arguments = format string + (object, variable or value)
    //           format specifier: %, [flags], [precision] OR [width], [conversion-character]
  static void example () {
    System.out.printf("This is a format string %d", 123); // LINE 28
  }

  // breakdown of the example method above:
  // we have the format string we want to print. In this string we have a %d at the end.
  // % is the format specifier and is required for any kind of formating in a string.
  // the location of the % is where our value to be formatted into the string will appear.
  // which in our case is at the end. In this example, we are wanting to format/insert the integer
  // 123. This is why we have %d. The d here tells java we are formatting a decimal number.
  // It is our conversion character and each data type has its own, see below.

  boolean myBoolean = true;
  char myChar = '$';
  String myString = "ha";
  int myInt = 1;
  double myDouble = 9.99;

  // System.out.printf("%b", myBoolean); ---> true as a string will be printed to terminal
  // System.out.printf("%c", myChar);    ---> $ as a string will be printed to terminal
  // System.out.printf("%s", myString);  ---> ha as a string will be printed to terminal
  // System.out.printf("%d", myInt);     ---> 1 as a string will be printed to terminal. d is for integers
  // System.out.printf("%f", myDouble);  ---> 9.99 as a string will be printed to terminal. f is for floats AND doubles


  // [width]
  // sets the minimum number of characters (including the substituted value) to be written in the output/formatted string.
  static void example_two () {
    String myString = "Haha";
    System.out.printf("This is %10s", myString); // --> prints "This is      Haha"
    // Minimum 10 characters in the formatted string, hence we have 6 spaces.
  }

  // [precision] - for floats only. How many decimal places you want of the float to appear.
  // sets number of digits of precision when outputting float values in format string
  static void example_three() {
    float myFloat = 9.11436f;
    System.out.printf("You have %.2f dollars", myFloat); // --> prints "You have 9.11 dollars"
  } // so .2 here specifies we want only the first two decimal places

  // [flags]
  // adds an effect to formatted string based on the flag chosen
  // - : left justifiy. Right justify is default
  // + : output a plus ( + ) or a minus ( - ) sign for a numeric value
  // 0 : numeric values are zero padded
  // , : comma grouping separator if numbers > 1000

  static void example_four() {
    String myString = "Haha";
    System.out.printf("This is %-10s", myString); // --> "This is Haha      "
  }

  static void example_five() {
    double myDouble = -9.14323;
    System.out.printf("You have %+.2f dollars", myDouble); // --> "You have -9.14 dollars"
  } // the plus is put as a flat to include the sign of the value stored in the variable

  // FINAL
  //  the final keyword, used when declaring a variable (before declaring data type) is used
  // to make the value of that variable immutable, e.g.:
  final double PI = 3.14; // common practise to name final variables in UPPERCASE
  // p = 4.00; we could not write this as the value of PI can't be reassigned, results in error if we do

}
