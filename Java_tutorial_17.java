import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


//CONTENTS: Grid layout, layered pane

public class Java_tutorial_17 {

  public static void main(String args[]){
    // Layout Manager = Defines the natural layout for components in a container
    // GridLayout = Places components in a grid of cells. Each component takes all the available space within
    //              its cell, and each cell is the same size

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,500);
    frame.setLayout(new GridLayout(3,3,10,10)); // n.b. frames by default use BorderLayout manager so components like to take up as much room as possible
    // by default these buttons will be put into one row using GridLayout manager but we can specify the number
    // of rows and columns we want in the brackets GridLayout(rows, columns)

    // we can also add arguments for the margin between components:
    // GridLayout(rows, columns, horizontal margin, vertical margin)



    frame.add(new JButton("1")); // an 'anonymous' button as we didnt create it as a variable first
    frame.add(new JButton("2"));
    frame.add(new JButton("3"));
    frame.add(new JButton("4"));
    frame.add(new JButton("5"));
    frame.add(new JButton("6"));
    frame.add(new JButton("7"));
    frame.add(new JButton("8"));
    frame.add(new JButton("9"));
    // frame.add(new JButton("10"));
    // if we uncomment the line above, we actually end up with 4 columns and 3 rows instead of 3 columns with 3 rows
    // this is because the number of buttons does not divide exactly into our number of rows and columms
    frame.setVisible(true);
  }


}
