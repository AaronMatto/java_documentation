import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// CONTENTS: Jpanels, Jbuttons and events,

public class Java_tutorial_15 {

  public static void main(String[] args) {

    // Lets first make a component by adding a label
    JLabel label = new JLabel();
    label.setText("Hi");
    ImageIcon icon = new ImageIcon("YE.png");
    label.setIcon(icon);

    // JPANEL
    // panels = a GUI component that functions as a container to hold other components (like a wrapper div?)
    JPanel redPanel = new JPanel();
    redPanel.setBackground(Color.red);
    redPanel.setBounds(0, 0, 300, 300); // so our panel's top left corner is in the frame's top left
    // we must do this as setLayout is set to null, see prev tutorial

    JPanel bluePanel = new JPanel();
    bluePanel.setBackground(Color.blue);
    bluePanel.setBounds(300, 0, 300, 300);

    JPanel greenPanel = new JPanel();
    greenPanel.setBackground(Color.green);
    greenPanel.setBounds(0, 300, 600, 300);

    // now we have a square that's red, blue and green! We can add components (labels) to our panels or a frame.
    // lets add it to a panel (although we must do this after all other customisations)

    // we can also move the label around within the panel. However, these panels use a 'flow' layout manager
    // Frames have a 'border' layour manager
    // A container using 'flow' layour manager takes components by default, centers them and sticks them at
    // the top of the container. It will add components until that row is filled, then add to 2nd row.

    greenPanel.setLayout(new BorderLayout()); // for now we're going to work with border layouts
    // as in the last tutorial, this centres components vertically and sticks them to the left of their container
    // horizontally. With borderlayout we can use setVertical and setHorizontal
    label.setVerticalAlignment(JLabel.BOTTOM);
    label.setHorizontalAlignment(JLabel.RIGHT); // so now our label is in bottom right of green panel


    // If we don't want to use a layout manager we can get more specific with positioning a component within
    // a panel. First we setLayout of each panel to null:
      // bluePanel.setLayout(null);
      // redPanel.setLayout(null);
      // greenPanel.setLayout(null);
    // Now we set the bounds of the label
      // label.setBounds(0, 0, 75, 75);
      // Since we are adding the label to the green panel, 0,0 here references the x and y coordinates of where
      // the top left of our label will appear within THAT (green) panel, not the frame. The panel is the container.
      // Coordinates are relative to the top left corner of the container.

    // SUMMARY
    // so you can add components/labels to a panel then add that panel to a frame.

    greenPanel.add(label);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(750,750);
    frame.setVisible(true);
    frame.add(redPanel);
    frame.add(bluePanel);
    frame.add(greenPanel);

    // BUTTONS
    new MyFrame();
  }
}

// jButtons!
public class MyFrame extends JFrame implements ActionListener {
  // our class MyFrame is inheriting from JFrame.
  // Jbutton = a button that performs an action when clicked on
  // We need to add 'implements ActionListener' to grant access to event listener functionality
  // We declare our button in the class so it is globally scoped. We set it up in the constructor.
  JButton button;
  ImageIcon icon = new ImageIcon("YE.png");
  JLabel labelTwo; // we can make this label appear when we click the button. Lines 119-122, 130 & 142!


  MyFrame(){
    button = new JButton();
    button.setBounds(200,100,350,300);
    button.addActionListener(this); //  we pass in "this" since this class is implementing the
    // ActionListener interface.
    button.setText("I'm a button");
    button.setFocusable(false); // gets rid of the box around the button text
    // button.setIcon(icon); // add an image to our button (our image is too big)
    button.setHorizontalTextPosition(JButton.CENTER);
    button.setVerticalTextPosition(JButton.BOTTOM);
    button.setFont(new Font("Comic Sans", Font.BOLD, 25));
    button.setIconTextGap(-10); // reduce space between icon and button text
    button.setForeground(Color.cyan);
    button.setBackground(Color.black);
    button.setBorder(BorderFactory.createEtchedBorder());

    // *** we can do this all with a giant shortcut: a lambda expression
    // We don't need to add 'implements ActionListener' to MyFrame
    // We don't need to create the actionPerformed method
    // button.addActionListener(e -> System.out.println("success!"));
    // the line above is a lambda expression!

    labelTwo = new JLabel();
    labelTwo.setIcon(icon);
    labelTwo.setBounds(150, 250, 150, 150);
    labelTwo.setVisible(false);

    // SETTING UP the button!
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setSize(500,500);
    this.setVisible(true);
    this.add(button);
    this.add(labelTwo);
  }

  // Event listener! actionPerformed is the default method name for when an event occurs hence the override
  // as we're defining what happens here
  // As usual, e is the event object and has multiple native methods e.g. getSource which is e.currentTarget
  // The data type of e in java is ActionEvent!
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == button){
      System.out.println("Success!");
      // button.setEnabled(false); this stops the button being clickable after it has been clicked once!
      labelTwo.setVisible(true);
    }
  }


}
