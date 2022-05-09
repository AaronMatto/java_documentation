// All of the code in here is source code - meaning, it can be read and written by humans. Source code gets
// COMPLIED into byte code.
// A class is a collection of related code. We will use classes when we get to OOP in java.
// Anything within the outer set of curly braces belongs to the class. All code must be held in a Java class.
// Our file name must also match the name of our master class.
// Convention states that all classes in java begin with a capital letter.
// Within our class, we have what is a called a main method. Our program won't run without this method, as when we
// run the program, we begin by calling the main method. If we were to remove 'public static void main...etc'
// and run the file in terminal we'd encounter an error as our 'main' method would not be found in the class 'Java_tutorial_one'.
//  We'd be asked to define the 'main' method.
// 'public static void main(String[] args) {}' is always required. The instructions in the program, that is, the code
// inside 'public static void main...' are interpreted so the order of statements in the main method matters.
// The name of the class and the file name must match.


import java.util.Scanner; // see line 91. Required for us to store user input.

public class Java_tutorial_one {

  public static void main(String[] args) {

  // PRINTING TO TERMINAL
      // Text inside 'print' must be in double quotes
      System.out.print("Hello World");
      System.out.print("Hell yea");


      // In the example above the terminal outputs "Hello WorldHell yea". The example below prints
      // "Hello world"
      // "Hell yea"
      // We need line 30 otherwise line 31 still prints on the same line as "Hello WorldHell yea".
      System.out.println("");
      System.out.println("Hello world");
      System.out.println("Hell yea");

      // println stands for 'print line' and will add a new line AFTER the string where as a print doesnt
      // we could also use \n on the end of "Hello World" in line 22, this would give the same output as
      // lines 30 to 32

      // if we wanted to literally print "Hello World" with quotes we'd need to escape the second quotes so
      System.out.println("\"Hello World\"");

      // we can shortcut type "System.out" by typing "Sysout" and hitting enter

    // VARIABLES
      // in Java, we must list the data type of the variable. There are 8 date types:
      // boolean (true or false)
      // boolean z = true;

      // byte (-128 to 127)
      // int (integer)
      // int x = 3;

      // long (bigger integers, ranging from -9 quintillion to 9 quintillion) - numbers followed with an L

      // float **numbers assigned as a float need to be as follows 3.1415f  - need the f at the end**
      // float x = 3.12323f;
      // double (float with more digits after the decimal so longer float but does not need f at end)

      // char (any single letter) ** all chars are in '' single quotes **
      // char symbol = '@';

      // String (any sequence of letters) ** all strings are in "" **
      // String lol = "haha";


      // so, as an example:
      int example_variable = 2; // The semi colon follows the declaration and assignment. This is initialisation.
      // we could also do as follows (variable name has changed as to not re-assign)
      int example_variabl; // semi colon follows declartion
      example_variabl = 3; //semi colon follows assignment
      System.out.println(example_variabl); // will print variable value

      // concatenation
      System.out.println("My number is " + example_variable); // will print "My number is 2"

      // swapping variables
        // String x = "water";
        // String y = "cola";

        // x = y; Now both x and y have the value "cola"
        // y = x; Now both variables have the value water
        // so in order to switch we need another placeholder variable
        //String temp;

        // temp = y; // temp is now "cola"
        // y = x; // y is now "water", so is x
        // x = temp; // x is now "cola" and y is still "water"
        // System.out.println("x is: " + x + "\n y is: " + y);


      // User input
        // We must first import the scanner class. See line 16.
        Scanner example_scanner_object = new Scanner(System.in);
        // We can now use our scanner to accept some user input. For example:
        System.out.println("What's your name?");
        String user_name = example_scanner_object.nextLine();
        System.out.println("Hello " + user_name);

        // We can also only accept user input of a certain data type:
        System.out.println("What's your age " + user_name + "?");
        int user_age = example_scanner_object.nextInt(); // here we use nextInt which tells program to expect an int
        // if user puts in anything but an integer we get an 'Exception error'. We have something called exception handling later.
        System.out.println("You are " + user_age + " years old :)");

        // IMPORTANT - Clearing the scanner. Imagine the following scenario:
        Scanner example_scanner_two = new Scanner(System.in);
        System.out.println("What's your name?");
        String name_two = example_scanner_two.nextLine();
        System.out.println("How old are you?");
        int age_two = example_scanner_two.nextInt();
        System.out.println("What's your favorite food?");
        // example_scanner_two.nextLine();  SEE BELOW
        String fav_food = example_scanner_two.nextLine();
        System.out.println("Hello " + name_two + ", you're " + age_two + " years old and your favorite food is " + fav_food);

        //uh oh! "Hello chan, you're 23 years old and your favorite food is" is output to the terminal.
        // Our user doesn't get to enter their favorite food, it was skipped. Why is this happening?
        // In our example_scanner_two object, we use the nextLine(); method to read a line of text.
        // The nextLine(); method stops when it reaches a \n
        // So on line 108, after asking for name, our scanner object is filled with (for example):
        // 'Aaron \n' which is then read by .nextLine();. The \n is added when the user hits enter by default. This input in the scanner is saved into the variable name_two.
        // As the nextLine(); method reads our scanner object, it clears it out to be empty again after reaching \n
        // Line 109 then asks the user how old they are
        // nextInt(); is then used to read the user input in the example_scanner_two object (which is saved in our variable age_two).
        // However, nextInt();, unlike nextLine();, doesn't read the new line character \n
        // So the user has typed in their input e.g. 26 and pressed enter
        // So example_scanner_two object is filled with '26 \n'
        // This is read by nextInt(); which only reads the numeric portion. Upon the number being submitted,
        // the \n gets left behind in our example_scanner_two object.
        // We go to use our nextLine(); method again on line 112 but our example_scanner_two still has
        // '\n' left in it. Hence, nextLine(); thinks the input is blank which is why we see no input for
        // favorite food from the user when the string is printed.

        // How do we fix this?
        // well, we clear our scanner first after newInt(); to get rid of the \n character that gets added by default
        // and left over. How do we do this? Add the following line to line 112:
        // example_scanner_two.nextLine();
        // doing this clears out our example_scanner_two object, getting rid of the leftover \n
  }

}
