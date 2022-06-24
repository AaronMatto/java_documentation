import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;

// CONTENTS: JFileChooser, JColorChooser,


public class Java_tutorial_22 {
  public static void main(String args[]) {

    // JFileChooser = A GUI mechanism letting a user choose a file (for opening or saving files)
    // MyFrame frame = new MyFrame();

    // JColorChooser = A GUI mechanism that lets a user choose a color
    MyFrame2 frame2 = new MyFrame2();

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
