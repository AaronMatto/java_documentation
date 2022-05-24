import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

// CONTENTS: GUI (creating a window for an app),

public class Java_tutorial_14 {

  public static void main(String args[]) {

    // GUI - creating windows for an app. To do this we need JFrame
    JFrame frame = new JFrame(); // creates a frame
    frame.setTitle("Jframe title goes here lol"); // sets title of a frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the default is "hide_on_close" which doesn't
    // actually exit the application, it just hides the jframe window
    frame.setSize(420, 420); // sets x and y dimensions of frame
    frame.setResizable(true); // prevents frame from being resized by user with mouse if false
    // ImageIcon logo = new ImageIcon("file path");  - This allows us to replace the java logo on our frame
    // frame.setIconImage(logo.getImage()); - Actually sets the icon from above to replace java logo
    frame.getContentPane().setBackground(new Color(123,50,250)); // set background color for our jframe
    frame.setVisible(true); // make the frame visible as it is not visible by default

    // ANOTHER WAY TO CREATE A J FRAME:
    // Example_Frame frame2 = new Example_Frame();   This does the exact same as above


  }
}


public class Example_Frame extends JFrame {

  // constructor
  Example_Frame(){
    JFrame frame = new JFrame();
    this.setTitle("Jframe title goes here lol");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(420, 420); // sets x and y dimensions of frame
    this.setResizable(false); // prevents frame from being resized by user with mouse
    // ImageIcon logo = new ImageIcon("file path"); - This allows us to replace the java logo on our frame
    // frame.setIconImage(logo.getImage()); - Actually sets the icon from above to replace java logo
    this.getContentPane().setBackground(new Color(0, 0, 0));
    this.setVisible(true);
  }


}
