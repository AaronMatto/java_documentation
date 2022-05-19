// CONTENTS: Wrapper Classes, ArrayList, 2D ArrayList, For-Each Loop, Methods

import java.util.ArrayList;

public class Java_tutorial_4 {

  public static void main (String[] args) {
    // Wrapper Classes
      // wrapper class = provides a way to use PRIMITVE data types as reference data types.
      //                 - Reference data types contain useful methods (.upCase etc) and can be used with collections e.g. ArrayLists
      //                 - So primitive data types don't have in built object-oriented methods, only reference types do
      //                 - BUT we can use the corresponding wrapper class for a primitive type to gain access to methods or use it in a collection
      //                 - This is less efficient as accessing values contained in wrapper classes involves more steps for the
      //                 - computer to perform so slower code

      //primitive Data type       // wrapper class
      // boolean                     Boolean          capital letter for class
      // char                        Character
      // int                         Integer
      // double                      Double

      // autoboxing = the automatic conversion that Java compiler makes between the primitive data types and their corresponding object wrapper class
      // unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive data type
                    // i.e. converting an object to its primitive data type

      // AUTOBOXING
      Boolean a = true;  // So what's happening here is because we've declared a variable a as a Boolean with a capital B,
                         // Java automatically knows we want this variable a to have access to in built methods
                         // (e.g. a.SOME METHOD) and/or to be used in collections. Hence, the variable is 'wrapped' in the
                         // class "Boolean" that contains these in built methods and allows use in collections. If we declared variable
                         // a as a 'boolean' then it would strictly be a boolean value and not wrapped in the Boolean class, hence
                         // it would not have access to in built methods or be allowed in collections.
                         // Declaring variables with access to a wrapper class in this way is autoboxing.
      Character b = '@';
      Integer c = 123;
      Double d = 3.14;
      String e = "Aaron"; // Strings are already a reference data type


      // UNBOXING
      if (a == true) { // This is unboxing. You simply write an if statement saying if autoboxed variable == its' value
        System.out.println("This is true");
      }

      int f = c; // int z is a primitive type and it is assigned the value of c. C is an Integer object but is unboxed.

      if (b == '@') { // b is unboxed.
        System.out.println("This is true");
      }

    // ARRAY LISTS
      // A type of re-sizeable array. Elements can be added and removed after it has been compiled which we can't normally do
      // with standard arrays. Normally array lengths are fixed.
      // They only store reference data types.
      // Example:
      ArrayList<String> food = new ArrayList<String>();
      // we first decalre we want an ArrayList and we state the reference data type. Then we state the ArrayLists name.
      // Then we create a new ArrayList object followed by ();
      // if we want to store primitive values we still need to use the wrapper class e.g. ArrayList<Integer> and NOT ArrayList<int>

      food.add("pizza"); // will add pizza to our ArrayList food
      food.add("burger");
      food.add("ice cream");
      // food[3] = "lol"; We can do this ONLY for arrays and NOT arrayLists
      for (int i = 0; i < food.size(); i++) { // normally we use .length but with array lists we use .size();
        System.out.println(food.get(i)); // to display we have to use .get and not food[i]
      }

      food.set(0, "sushi"); // this has replaced pizza with sushi
      food.remove(2); // this removes ice cream
      food.clear(); // this clears all the elements in the array list so it is empty


      // 2D Array Lists
      // a dynamic list of lists
      // you can change the size of these lists during runtime
      // lets make shopping list
      ArrayList<String> bakeryList = new ArrayList<String>();
      bakeryList.add("pasta");
      bakeryList.add("garlic bread");
      bakeryList.add("donuts");

      ArrayList<String> produceList = new ArrayList<String>();
      produceList.add("tomatoes");
      produceList.add("zucchini");
      produceList.add("peppers");

      ArrayList<String> drinksList = new ArrayList<String>();
      drinksList.add("Cola");
      drinksList.add("Water");

      System.out.println(drinksList);

      // we can add all these array lists to another array list i.e. a 2D array list. We can all it groceryList and
      // it organises our lists of products by type of product
      ArrayList<ArrayList<String>> groceryList = new ArrayList<>();
      groceryList.add(bakeryList);
      groceryList.add(produceList);
      groceryList.add(drinksList);

      System.out.println(groceryList);
      System.out.println(groceryList.get(0).get(1)); // garlic bread

  // FOR EACH LOOPS
      // enhanced for loops.
      // for each = Traversing technique to iterate through the elements in an array/collections
      //            - Takes less steps than a for loop and is more readable
      //            - Less flexible as we don't have access to index

      String[] animals = {"cat", "dog", "rat", "bird"};

      // We have to declare the data type of the elements first. i refers to each element here (not index), : literally means "in" and
      // then we have the name of the array
      for(String i : animals) {
        System.out.println(i); // cat, dog, rat, bired
      }

      // with a collection
      ArrayList<String> animals_two = new ArrayList<String>();
      animals_two.add("Cat");
      animals_two.add("Dog");
      animals_two.add("Bird");
      for(String i : animals_two) {  // set is same as above
        System.out.println(i);
      }

      hello("Lol");
      String name = "Aaron";
      test(name, 26);

      int x = 3;
      int y = 4;
      int g = add(x, y); // we could call this z not g as variables are local scoped to block statements but would be bad style
      System.out.println(g); // OR, alternatively:
      System.out.println((add(x,y)));
  }

  // METHODS! AKA FUNCTIONS notice we have exited the "main" method in our class, we exited it on line 136
    // convention is first letter lowercase
    // notice how because java is compiled we can call the method above its definition. Called on 127
    // to be able to do this we must have the static keyword when defining the method

    static void hello(String word) { // we MUST list the data type of the paramter the method expects
      System.out.println(word);
    }

    static void test(String name, int number) {
      System.out.println("Hello " + name + ", you're " + number + " years old");
    }

    // return types
    static int add(int num_one, int num_two) {
      int z = num_one + num_two;
      return z;
      // return num_one + num_two; does same
    }
    // WE TYPE VOID WHEN THE METHOD DOESN'T RETURN A VALUE, WE DON'T TYPE IT WHEN IT DOES.
    // IN THIS CASE WE WANT TO RETURN AN INTEGER SO WE TYPE int add, THE DATA TYPE OF THE VALUE WE WANT TO RETURN
    // THE TWO METHODS ABOVE DO NOT RETURN VALUES THEY JUST PRINT DIRECTLY TO THE TERMINAL, add returns z
}
