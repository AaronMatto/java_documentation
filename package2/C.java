package package2;
import package1.*;


public class C {
  // NO MODIFIER
  String defaultMessage = "This is the default";
  // we are using no access modifier which is the default.
  // Which classes can see this message?
  // go to package1/A


  // PUBLIC
  public String publicMessage = "This is public";
  // here we have the public access modifier. Go to package1/A

  // PROTECTED
  // Go to package1/A


  // PRIVATE
  // Go to package1/B
}
