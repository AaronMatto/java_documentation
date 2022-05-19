package package2; // remember, a package is simply a collection of classes.
import package1.A; // must do this so Asub can inherit A

public class Asub extends A {
  public static void main(String args []) {
    // C c = new C();
    // System.out.println(c.defaultMessage);
    // If uncommented, the above would work as Asub and C are in the same package, package2.
    // Go to package2/C


    Asub asub = new Asub();
    System.out.println(asub.protectedMessage); // it works!
    }

}
