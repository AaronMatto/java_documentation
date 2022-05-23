import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// CONTENTS: FILE CLASS, Write to file - FILEWRITER CLASS, Read a file - FILEREADER CLASS

public class Java_tutorial_13 {

  public static void main(String[] args) {
    // FILE CLASS
    // File class is an abstract representation of file and directory pathnames

    File file = new File("/Users/master/code/test/trade.rb");
    File file2 = new File("Java_tutorial_12.java");
    // be sure to include the extension!
    // to find a full file path right click on it in finder, click 'get info' then copy 'where'
    if(file.exists()) {
      System.out.println("The file exists");
      System.out.println(file.getPath()); // This prints the same file path specified in the
      // File constructor on line 10 (which happens to be an absolute path in this case)

      System.out.println(file2.getAbsolutePath()); // This prints the full absolute path of the file

      System.out.println(file.isFile()); // returns true if file is actually a file. Useful to see if
      // the file path is accidentally leading to a directory.

      // file.delete(); This would delete the file!
    } else {
      System.out.println("That file does not exist");
    }

    // FILEWRITER
    // use filewriter to create new files and write in them. Filewriter must use try and catch blocks.
    try {
      FileWriter writer = new FileWriter("Example.txt");
      // This creates a new text file in our current directory called "Example"

      writer.write("Hello world \nJava is great");
      // This writes in that new file the string "Hello World"

      // writer.append("blah blah");
      // This appends to the existing text in our new Example file.

      writer.close();
      // Close the writer once we're done with it!
    }
    catch(IOException e) {
      e.printStackTrace();
    }

    // FILE READER
    // FileReader = read the contents of a file as a stream of characters. One by one.
    //              read() returns an int value which contains the byte value for each character.
    //              when read() returns -1, there is no more data to be read.
    // Filereader must use try and catch blocks.
    try {
      FileReader reader = new FileReader("Example.txt");
      int data = reader.read();
      // We are going to read the first character within "Example.txt" and we'd like to continue reading
      // BUT if read() returns -1 it means there's no data left to read. So we continue reading until read()
      // returns -1.
      while (data != -1){
        System.out.print((char)data); // we must resolve the data type of 'data' variable to char.
        data = reader.read(); // we must read the value of the next character and reassign it to our data variable!
      }
      reader.close(); //close reader when done!
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

}
