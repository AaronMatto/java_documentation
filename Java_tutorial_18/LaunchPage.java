package Java_tutorial_18;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

  }

}
