package Java_tutorial_18;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

// CONTENTS: Open a new window via event,

public class Main {

  public static void main(String args[]) {
    // we want to open the newWindow
    // lets create an instance of our launchPage which will contain a button. When we click that button it will
    // open the newWindow

    LaunchPage launchPage = new LaunchPage();

  }

}

// SHOULD BE IN ITS OWN FILE BUT DOESNT WORK
public class LaunchPage implements ActionListener {
  // we need a frame to create our launchpage
  JFrame frame = new JFrame();
  JButton button = new JButton("Click for New Window");

  LaunchPage() {
    button.setBounds(100, 160, 200, 40);
    button.setFocusable(false);
    button.addActionListener(this);

    frame.add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420);
    frame.setLayout(null);
    frame.setVisible(true);
  }

  @Override // this is the method that fires when we click on the button
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
      NewWindow myWindow = new NewWindow();
      // every time we click the button we get a new window.
      frame.dispose(); // this gets rid of the launch page
    }
  }

}

// SHOULD BE IN ANOTHER FILE
public class NewWindow {
  JFrame frame = new JFrame();
  JLabel label = new JLabel("Hello!");

  NewWindow(){

    label.setBounds(0,0,100,50);
    label.setFont(new Font(null, Font.PLAIN,25));

    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}
