package package1;
import package2.*; // this means import everything from package2 folder.

public class A {
  public static void main(String[] args) {

    C c = new C();
    // System.out.println(c.defaultMessage); doesn't work as defaultMessage is not visible.
    // we get an error here as anything using the default access modifier is only visible to anything
    // within the same package (collection of classes). So, defaultMessage is only visible to anything
    // in package 2. Anything in package1 cannot see anything in package2 that uses default (no) access
    // modifier. defaultMessage is visible to Asub.
    // Go to Asub to see.


    System.out.println(c.publicMessage);
    // This works. Anything that uses the public keyword in one package
    // is visible to any other package in the same level of the file directory.
    // package1 and package2 are at the same level in our "Java" folder, hence publicMessage
    // can be accessed. All of the classes A, B, C and Asub are also public.
    // If we removed public from line 5 in C, i.e. we just made our class C without writing public
    // by writing "class C" instead, it would have the default access modifier (none) and C the class
    // would only be visible to other classes in package2 and this class, A, couldn't create an instance
    // of C.

  }

  // PROTECTED CLASS
  protected String protectedMessage = "This is protected";
  // something that is protected is accessible to a different class in a different package, so long
  // as that class is a subclass of the class containing the protected keyword. So, only Asub
  // has visibility for protectedMessage. Our classes in package2 could too, but they
  // would need to be subclasses of A.
  // Notice how we can't put this in the main method of A since that method is public.

}
