import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;

// CONTENTS: Jpanels,

public class Java_tutorial_14 {

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

  }
}
