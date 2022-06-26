import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;

// CONTENTS: JFileChooser, JColorChooser, KeyListener


public class Java_tutorial_22 {
  public static void main(String args[]) {

    // JFileChooser = A GUI mechanism letting a user choose a file (for opening or saving files)
    // MyFrame frame = new MyFrame();

    // JColorChooser = A GUI mechanism that lets a user choose a color
    // MyFrame2 frame2 = new MyFrame2();

    // KeyListners
    MyFrame3 frame3 = new MyFrame3();

  }
}


public class MyFrame extends JFrame implements ActionListener {

  JButton button;

  MyFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());

    button = new JButton("Select File"); // add a button to select a file
    button.addActionListener(this);


    this.add(button);
    this.pack();
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == button){
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.showOpenDialog(null); // as we don't have a parent component. This method selects a file to open.
      // showOpenDialog returns an integer:
      // clicking open on a file returns 0
      // clicking cancel or close returns 1
      // fileChooser.setCurrentDirectory(new File(".")); sets default directory that is opened
      int response = fileChooser.showOpenDialog(null);


      if (response == JFileChooser.APPROVE_OPTION){ // we write JFileChooser.APPROVE_OPTION instead of '0' here
        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        System.out.println(file); // prints absolute path of file opened

      }
    }
  }

}


public class MyFrame2 extends JFrame implements ActionListener {

  JButton button;
  JLabel label;

  MyFrame2() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());

    button = new JButton("Button lol"); // add a button to select a file
    button.addActionListener(this);
    label = new JLabel();
    label.setBackground(Color.white);
    label.setOpaque(true);
    label.setText("This is some text :D");
    label.setFont(new Font("MV Boli", Font.PLAIN, 100));



    this.add(button);
    this.add(label);
    this.pack();
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
      JColorChooser colorChooser = new JColorChooser();

      Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
      // this stores the color chosen by user

      // label.setForeground(color); // this sets the color of the label text to the user choice
      label.setBackground(color);
    }
  }

}


public class MyFrame3 extends JFrame implements KeyListener {

  JLabel label;

  MyFrame3() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null); // as we're going to manually move components via keystroke
    this.setSize(500,500);

    this.addKeyListener(this); // to make this frame respond to key events

    label = new JLabel();
    label.setBounds(0,0,100,100);
    label.setBackground(Color.red);
    label.setOpaque(true); // have to set opacity for background color to display

    this.add(label);

    this.getContentPane().setBackground(Color.black); // set background of frame

    this.setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // called when a key is typed, gives us a character output of what was pressed
    switch(e.getKeyChar()) {
      case 'a': label.setLocation(label.getX() - 10, label.getY()); // This moves our label left by 1 pixel when the user presses 'a'
        break;
      case 'd': label.setLocation(label.getX() + 10, label.getY()); // moves our label right by 1 pixel when 'd' is typed/pressed
        break;
      case 'w': label.setLocation(label.getX(), label.getY() - 10); // moves our label up by 1 pixel when 'w' is typed/pressed. Note that moving up is - !
        break;
      case 's': label.setLocation(label.getX(), label.getY() + 10); // moves our label down by 1 pixel when 's' is typed/pressed
        break;
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    // invoked when a key is pressed down. Uses a keycode and outputs an integer associated with
    // that key. The associated integer is the keycode.
    // Here we do the same, move the label by one pixel up/down/left/right except we use the arrow keys.
    // Arrow keys aren't a character so we use the keyCode(); method
    switch (e.getKeyCode()) {
      case 37:
        label.setLocation(label.getX() - 10, label.getY()); // This moves our label left by 1 pixel when the user presses                                                // 'a'
        break;
      case 39:
        label.setLocation(label.getX() + 10, label.getY()); // moves our label right by 1 pixel when 'd' is typed/pressed
        break;
      case 38:
        label.setLocation(label.getX(), label.getY() - 10); // moves our label up by 1 pixel when 'w' is typed/pressed
        break;
      case 40:
        label.setLocation(label.getX(), label.getY() + 10); // moves our label down by 1 pixel when 's' is typed/pressed
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // invoked when a key is released
    System.out.println("You released key: " + e.getKeyChar());
    System.out.println("You released KEY CODE: " + e.getKeyCode());
  }

}
