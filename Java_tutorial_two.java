// CONTENTS: Expressions, GUI intro, Math methods, random numbers, if statements, switches, logical operators

import javax.swing.JOptionPane; // for the GUI line 32
import java.util.Scanner;
import java.util.Random; // line 80. This imports the random class and its native methods


public class Java_tutorial_two {

  public static void main(String[] args) {
    // Expressions
      // An expression is a combination of operands and operators. An operand is the
      // values/variables in a program.
      // An operator is an arithmetic symbol.
      //example operators: +, -, *, /, %
      int friends = 5;
      friends = friends + 5;
      System.out.println(friends); // will give us 10. There is no +=

      friends++; // increments friends by 1.
      friends--; // -- will decrement by 1.

      System.out.println(friends / 3); // will give us 3.

      // if we want to include the decimal we can assign a new data type to our variable as follows:
      float friends_two = 10; // Note we have to actually create a new variable here. We can't reassign a data type to an already
                              // declared variable. I.e. we can't write float friends = friends; OR float friends = 10;

      System.out.println(friends_two / 3); // Interestingly, we can also write here ((double) friends_two/3); and this will give us
      // a longer decimal 3.3333333. It works because a float and a double are compatible data types.

    // GUI - Graphical User Interface
       String name = JOptionPane.showInputDialog("Enter your name"); // This will make a GUI box pop up that asks the user for their name
       // However, nothing happens after user enters their name. Lets create another dialog box that displays the name variable:
       JOptionPane.showMessageDialog(null, "Your name is: " + name);
       // lets ask for age

       //  int age = JOptionPane.showInputDialog("Enter your age");

       // BUT! This doesn't work because JOptionPane implicitly returns a string as user input
       // and we've declared our variable as an int. We need to convert the string to an int. Uncomment line below to make it work:
       int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
       // we need to use the native parseInt method which is a part of the Integer object hence why we have Integer.parseInt
       JOptionPane.showMessageDialog(null, "Your age is: " + age);

       // lets try with a 'double' data type:
       double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height in cm"));
       JOptionPane.showMessageDialog(null, "You're " + height + "cm tall");
       // So we can see here that to call native methods in java you must first declare the data type of the native method
       // If your variable is assigned to a method outcome, you must ensure the declared data type of the variable is
       // consistent with the data type the method returns.

    // MATH CLASS! :) Native methods
      double x = 3.14;
      double y = -10;
      // Max method compares two numbers and returns the bigger one:
        double max = Math.max(x, y);  // Math.min will find the lesser of two values
        System.out.println(max); // prints 3.14

        System.out.println(Math.abs(y)); // finds absolute value
        System.out.println(Math.sqrt(x)); // finds square root
        // Math.rounded will round according to the decimal. Math.ceil will always round up. Math.floor will always round down.
        // Find the hypotenuse of a triangle and ask the user for side x and side y
        double a = Double.parseDouble(JOptionPane.showInputDialog("length of x?"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("length of y?"));
        double h = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        JOptionPane.showMessageDialog(null, "Hypotenuse is " + h + " long");


        Scanner scanner = new Scanner(System.in);
        System.out.println("What is length x?");
        double i = scanner.nextDouble();
        System.out.println("What is length y?");
        double j = scanner.nextDouble();
        double k = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
        System.out.println("Hypotenuse is: " + k + " long");


        Random random_object_instance = new Random(); // We must decalre the class first when creating a variable that stores an instance of it
        int d = random_object_instance.nextInt(); // can also have nextDouble(); or nextFloat();
        System.out.println(d); // gives a random number
        int p  = random_object_instance.nextInt(6); // this will generate a random value 0 <= p <= 5
        // if we want a random value betwwen 1 and 6 we can just add one to p:
        System.out.println(p + 1);
        boolean q = random_object_instance.nextBoolean();
        System.out.println(q); // random boolean

    // IF statements. They are the same as JavaScript. Comparitive operators are same as usual.
        if (q == true) {
          System.out.println("True!");
        } else {
          System.out.println("False!");
        }

        if (p >= 5) {
          System.out.println("You rolled a 5 or more: " + p);
        } else if (p >= 3) {
          System.out.println("You rolled a 3 or 4: " + p);
        } else {
          System.out.println("You rolled less than 3: " + p);
        }

    // SWITCH statements. You can test a value against a list of other values for equality.
        String day = "Friday";
        switch(day) {
        case "Sunday": System.out.println("It is Sunday!");
        break; // we need a break statement to break out of the switch block statement after our match (if it does match)
        case "Friday": System.out.println("It is " + day + "!");
        break;
        default: System.out.println("That is not a day"); // occurs when there is no match
        }
        // if we omit the break statement what happens is that as soon as there is a match we execute the subset of code
        // for the matching case and ALL the subsets of code after the matching case

    // LOGICAL operators:
        // && = Both conditions must be true AND
        // || = Either condition must be true OR
        // != = Reverses a boolean condition, DOES NOT EQUAL
        System.out.println("You're playing a game! Press 'q' or \"Q\" to quit");
        String response = scanner.next();
        if (!response.equals("Q") && !response.equals("q")) {     // we need the !response.equals() here and NOT !=. != checks the object identity.
          System.out.println("You're still playing *pew pew*");
        } else {
          System.out.println("You quit the game");
        }
        scanner.close(); // good practise to close the scanner when done
  }
}
