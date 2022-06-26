// CONTENTS: Mouse Listener, Drag and Drop, Key Bindings

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;

public class Java_tutorial_23 {

  public static void main(String args[]) {

    // Mouse Listener Interface
    // used for listening for mouse events like press, release, full click, enter etc on a component
    // MyFrame frame = new MyFrame();

    // Drag and drop
    // MyFrame2 frame = new MyFrame2();

    // Key bindings
    // Key Bindings = bind an action to a keystroke. Useful for games!
    //                don't require you to click a component to give it focus
    //                all Swing components use keybindings
    //                increased flexibility over KeyListeners
    //                can assign key strokes to individual Swing components e.g. player 1 and 2 have different sets of keys
    //                more difficult to utilize and set up
    Game game = new Game();

  }
}



// Mouse listener
public class MyFrame extends JFrame implements MouseListener {

  JLabel label;

  MyFrame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);

    label = new JLabel();
    label.setBounds(0,0, 100, 100);
    label.setBackground(Color.red);
    label.setOpaque(true);
    label.addMouseListener(this); // this.addMouseListener(this) means the events would
    // be attached to the Jframe itself

    this.setLocationRelativeTo(null); // makes the frame appear in the center of users' screen
    this.add(label);
    this.setSize(500,500);
    this.setVisible(true);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // invoked when mouse has been fully clicked on component
    System.out.println("You clicked the mouse on the label"); // must click on the label
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // invoked when mouse has been pressed down on component
    System.out.println("You pressed the mouse on the label");
    // this applies to left and right click
    label.setBackground(Color.blue);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // invoked when mouse has been released on a component
    System.out.println("Your released the mouse on the label");
    // applies to left and right click
    label.setBackground(Color.green);
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // invoked when the mouse cursor enters the area of a component
    System.out.println("You entered the label");
    label.setBackground(Color.orange);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // invoked when the mouse cursor exits the area of a component
    System.out.println("You exited the component");
    label.setBackground(Color.red);
  }

}

// Drag and Drop
public class MyFrame2 extends JFrame {

  DragPanel dragPanel = new DragPanel();

  MyFrame2() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Drag and drop demo");
    this.setSize(600,600);
    this.add(dragPanel);
    this.setVisible(true);
  }

}

public class DragPanel extends JPanel {

  ImageIcon image = new ImageIcon("YE.png");
  final int WIDTH = image.getIconWidth();
  final int HEIGHT = image.getIconHeight();
  Point imageCorner;
  Point previousPoint;

  DragPanel() {
    imageCorner = new Point(0,0);
    ClickListener clickListener = new ClickListener();
    DragListener dragListener = new DragListener();
    this.addMouseListener(clickListener);
    this.addMouseMotionListener(dragListener);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
  }

  private class ClickListener extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      previousPoint = e.getPoint();
    }
  }

  private class DragListener extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) {
      Point currentPoint = e.getPoint();
      imageCorner.translate(
        (int)(currentPoint.getX() - previousPoint.getX()),
        (int)(currentPoint.getY() - previousPoint.getY())
      );
      previousPoint = currentPoint;
      repaint();
    }
  }

}


// KEY BINDINGS
public class Game {
  // We can bind actions to keystrokes.
  // If we want to create an action, we can create an inner class for a specific action
  // Lets make an action for up down left and right
  Action upAction;
  Action downAction;
  Action rightAction;
  Action leftAction;
  JFrame frame;
  JLabel label;

  Game(){
    frame = new JFrame();
    frame.setTitle("Key Binding Demo");
    frame.setSize(420,420);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    label = new JLabel();
    label.setBackground(Color.red);
    label.setBounds(100,100,100,100);

    upAction = new UpAction();
    downAction = new DownAction();
    leftAction = new LeftAction();
    rightAction = new RightAction();


    // with swing components in java, each component is able to have its own unique mapping
    // of key events to actions. Labels are swing components.
    // the code below associates the UP arrow keystroke event
    // first we type the component we want to associate a key stroke with so label
    // .put takes two args: the key to be associated ("UP") and then actionMapKey
    // actionMapKey is the name we give to this input so that we can map it to an action
    // getAction map then uses the actionMapKey to associate the UP arrow key with our upAction
    // which is an instance of UpAction. UpAction the class detects action events and using
    // the method actionPerformed moves our label up.
    label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
    label.getActionMap().put("upAction", upAction);

    label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
    label.getActionMap().put("downAction", downAction);

    label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
    label.getActionMap().put("leftAction", leftAction);

    // NOTE: If using keys like 'w,s,a,d' the character must be in single quotes
    label.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
    label.getActionMap().put("rightAction", rightAction);

    label.setOpaque(true);
    frame.add(label);
  }

  public class UpAction extends AbstractAction{
    @Override
    public void actionPerformed(ActionEvent e){
      label.setLocation(label.getX(), label.getY() - 10); // moves label up by 10 pixels
    }
  }

  public class DownAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
       label.setLocation(label.getX(), label.getY() + 10);
    }
  }

  public class LeftAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
       label.setLocation(label.getX() - 10, label.getY());
    }
  }

  public class RightAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
       label.setLocation(label.getX() + 10, label.getY());
    }
  }
}
