import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

// CONTENTS: JCheckBox, JRadioButtons
public class Java_tutorial_20 {

  public static void main(String args[]) {
    // JCheckBox = A GUI component that can be selected or deselected
    // MyFrame frame = new MyFrame();

    // RADIO BUTTONS
    // JRadioButton = One or more buttons in a grouping in which only 1 may be selected per group
    // MyFrame2 frame2 = new MyFrame2();

    // COMBO BOX
    MyFrame3 frame3 = new MyFrame3();

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
public class MyFrame2 extends JFrame implements ActionListener {

  JRadioButton pizzaButton;
  JRadioButton burgerButton;
  JRadioButton hotdogButton;


  MyFrame2() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());

    // Radio button exmaple: 3 buttons and you select one choice
    pizzaButton = new JRadioButton("Pizza");
    burgerButton = new JRadioButton("Burger");
    hotdogButton = new JRadioButton("Hotdog");
      // at this point in the code the user can select all buttons simaltaneously so we need to
      // put them in a group
    ButtonGroup group = new ButtonGroup();
    group.add(pizzaButton);
    group.add(burgerButton);
    group.add(hotdogButton);
      // now we can only select one item

      // add action listeners, actionlistener can't be added to group unfortunately
    pizzaButton.addActionListener(this);
    burgerButton.addActionListener(this);
    hotdogButton.addActionListener(this);
    // can also add custom icons for radio buttons using imageIcon if desired

    this.add(pizzaButton);
    this.add(burgerButton);
    this.add(hotdogButton);

    this.pack(); // so that the size of the frame adjusts to fit the components we add
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == pizzaButton) {
      System.out.println("You chose " + pizzaButton.getText());
    }
  }
}

// COMBO BOX OPTIONS
public class MyFrame3 extends JFrame implements ActionListener {

  JComboBox comboBox;

  MyFrame3() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());

    String[] animals = {"dog", "cat", "bird"};
    comboBox = new JComboBox(animals);
    // to populate the comboBox with options for the user to select from:
    // We can pass into the constructor an array of REFERENCE data types..
    // these can be objects or they can be primitive data types but you have to use the wrapper class
    comboBox.addItem("tiger"); // we can also add items this way

    // adding primitive data types
    // int[] nums = {1,2,3};
    // comboBox = new JComboBox(nums); This would not work! We have to use the Wrapper class
    // Integer[] nums = {1,2,3};
    // comboBox = new JComboBox(nums); This would work

    comboBox.addActionListener(this); // we can pass in this as our class implements the
    // actionlistener interface

    this.add(comboBox);
    this.pack(); // so that the size of the frame adjusts to fit the components we add
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == comboBox) {
      System.out.println(comboBox.getSelectedItem());
      // System.out.println(comboBox.getSelectedIndex()); // dog = 0
      // there are many methods you may use for combo boxes
    }
  }
}
