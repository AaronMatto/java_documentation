import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// CONTENTS: GUI (creating a window for an app via JFrame), JLabels,

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

    // J LABELS
    // label = an area in a frame used for a string of text, an image, or both
    JLabel label = new JLabel(); // create a label
    label.setText("Bro, do you even code?"); // set the text of the label
    ImageIcon image = new ImageIcon("YE.png");
    label.setIcon(image); // puts the image in our frame
    // by default, images and text are place in the center and aligned to the left side of the frame.
    // Java likes to place text to the right of images too but we can move the text's position relative
    // to the image
    label.setHorizontalTextPosition(JLabel.CENTER); // Now text is in center, RIGHT is default.
    label.setVerticalTextPosition(JLabel.TOP);
    // so now our text is centered on our image horizontally and above it vertically

    // lets change font color and font styling:
    label.setForeground(new Color( 200, 10, 90)); // set color of text
    label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // set font of text

    label.setIconTextGap(10); // this is the gap between our image and our text within their label.
    // This is the same as padding then in CSS, the space between two elements in the same div.
    // a negative number pulls text closer to the image

    label.setBackground(Color.black); // set background color
    label.setOpaque(true); // display background color. This makes every pixel in the jlabel opaque
    // with its' background color.
    // Currently, the label takes up the entire area of the jframe, even when the frame is resized.

    // Borders for a label
    Border border = BorderFactory.createLineBorder(Color.green, 3); // create a border
    label.setBorder(border); // set label border


    // Changing position of text and image within the label
    label.setVerticalAlignment(JLabel.CENTER); // sets vertical alignment of image and text within label
    label.setHorizontalAlignment(JLabel.CENTER); // sets horizontal alignment of image and text within label
    // So now our image and text will always stay within the center of our label, even when it is resized.

    // Resizing the label
    // Our label currently takes up the entirety of our frame due to the default layout manager.
    // We can set the layout manager to null and manually set the size of our label
    frame.setLayout(null);
    label.setBounds(100,0,450,450);
    // 0,0 are the coordinates for the top left pixel in our jframe. So we're saying place the top left
    // corner of our label (as this is how the positioning system works, it refers to the top left corners
    // of labels), at 100,0 - which is the 100 pixels to the right of the top left corner of our frame
    // We also set the size of the label to be 450 x 450
    frame.add(label); // must add jlabel to the jframe!

    // frame.pack() This sets the size of the frame so that it resizes to always contains its components.
    // The size of the frame will adjust to fit all of the components we have. So if we made components/labels bigger
    // the frame gets bigger
    // If you are going to use frame.pack() you MUST use it after using frame.add() for all your components!


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
