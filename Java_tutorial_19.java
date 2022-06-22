import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// CONTENTS: JOptionPane (pop up dialogues), JTextField,


public class Java_tutorial_19 {

  public static void main(String args[]){
    // JOptionPane = pop up for standard dialog box prompting user for value or informs
    //              them of something. There are different types:
    // Plain message
    JOptionPane.showMessageDialog(null, "a message", "TITLE", JOptionPane.PLAIN_MESSAGE);

    // Information message. Only difference is this one has a java icon
    // JOptionPane.showMessageDialog(null, "info message", "TITLE", JOptionPane.INFORMATION_MESSAGE);

    // Question message. This icon has a ?
    // JOptionPane.showMessageDialog(null, "question message", "TITLE", JOptionPane.QUESTION_MESSAGE);

    // Warning message. This icon has a warning sign
    // JOptionPane.showMessageDialog(null, "warning message", "TITLE", JOptionPane.WARNING_MESSAGE);

    // Error message. This icon has an error sign
    // JOptionPane.showMessageDialog(null, "error message", "TITLE", JOptionPane.ERROR_MESSAGE);

    // if we put one of these JOptionPane messages in an infinite loop e.g. while(true) it will keep
    // appearing over and over to the user even if closed lol

    // Confirm dialogue box. Asks user to confirm yes or no or cancel
    System.out.println(JOptionPane.showConfirmDialog(null, "do you even code?", "My title", JOptionPane.YES_NO_CANCEL_OPTION));
    // we can see from this that if the user selects 'yes', 0 is returned
    // selecting 'no', 1 is returned. Selecting 'cancel', 2 is returned. Close returns -1.
    // int answer = JOptionPane.showConfirmDialog(null, "do you even code?", "My title", JOptionPane.YES_NO_CANCEL_OPTION);
    // this would allow us, based on the value of answer, to run conditional logic.

    // Show input dialogue. This allows the user to type something
    String name = JOptionPane.showInputDialog(null, "What's ya name?");
    System.out.println(name);

    // Show option dialogue. This combines them all into one.
    String[] responses = {"Custom one", "custom two", "custom text 3"};
    JOptionPane.showOptionDialog(
    null,
    "option dialogue",
    "Secret message",
    JOptionPane.YES_NO_CANCEL_OPTION, // the option type, 4th argument, defines the response type for the dialogue box
    JOptionPane.INFORMATION_MESSAGE,
    null, // we could use our own image for icon using imageIcon
    responses, // we can define the text that appears on buttons by using an array as above
    0); // determines the button initially selected


    // JTextField = A GUI textbox component that can be used to add, set, or get text
    MyFrame frame = new MyFrame();


  }
}

public class MyFrame extends JFrame implements ActionListener {

  JButton button;
  JTextField textField;

  MyFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());

    button = new JButton("Submit"); // creating a submit button for the text field.
    button.addActionListener(this); // we can pass in 'this' since MyFrame the class is implementing an actionListener interface.

    textField = new JTextField();
    textField.setPreferredSize(new Dimension(250,40));
    textField.setFont(new Font("Consolas", Font.PLAIN, 35)); // font
    textField.setForeground(new Color(0x00FF00)); // set font color
    textField.setBackground(Color.black);
    textField.setCaretColor(Color.white); // sets the color of the white line blinker
    textField.setText("Type here...");

    this.add(button);
    this.add(textField);
    this.pack(); // so that the size of the frame adjusts to fit the components we add
    this.setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    // when this frame detects an event we can check to see if that event takes place on the button
    if (e.getSource() == button) {
      System.out.println(textField.getText());
      button.setEnabled(false); // submit button disabled after first submission
      textField.setEditable(false); // can no longer type after first submission
    }
  }
}
