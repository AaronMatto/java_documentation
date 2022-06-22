import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;

import javax.swing.JButton;
import javax.swing.JFrame;

// CONTENTS: JCheckBox, JRadioButtons
public class Java_tutorial_20 {

  public static void main(String args[]) {
    // JCheckBox = A GUI component that can be selected or deselected
    MyFrame frame = new MyFrame();
  }

}



// CHECKBOX
public class MyFrame extends JFrame implements ActionListener {

  JButton button;
  JCheckBox checkBox;

  MyFrame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());

    checkBox = new JCheckBox("Tick me!");
    checkBox.setFont(new Font("Consolas", Font.PLAIN,35)); // set checkbox text font and size
    // checkBox.addActionListener(this);
    // checkBox.setIcon  We can use this to put an icon in for the check box when unchecked
    // checkBox.setSelectedIcon  We can use this to put an icon in for the check box when checked

    button = new JButton();
    button.setText("Submit");
    button.addActionListener(this);

    this.add(button);
    this.add(checkBox);
    this.pack(); // so that the size of the frame adjusts to fit the components we add
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // when this frame detects an event we can check to see if that event takes
    // place on the checkbox

    // System.out.println(e.getSource());
    // if the source of the event is the button, print out the state of the checkbox.
    if (e.getSource() == button) {
      System.out.println(checkBox.isSelected());
    }
  }
}


// RADIO BUTTONS
