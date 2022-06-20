import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Color;


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

    // LAYERED PANES
    // JlayeredPane = Swing container that provides a third dimension for positioning components i.e. depth
    //                So we can stack panes on top of each other


    // lets make some labels to add to our layered pane so that we can see it
    JLabel label1 = new JLabel();
    label1.setOpaque(true);
    label1.setBackground(Color.RED);
    label1.setBounds(50, 50, 200, 200);

    JLabel label2 = new JLabel();
    label2.setOpaque(true);
    label2.setBackground(Color.GREEN);
    label2.setBounds(100, 100, 200, 200);

    JLabel label3 = new JLabel();
    label3.setOpaque(true);
    label3.setBackground(Color.BLUE);
    label3.setBounds(180, 180, 200, 200);

    JLabel label4 = new JLabel();
    label4.setOpaque(true);
    label4.setBackground(Color.orange);
    label4.setBounds(150, 150, 200, 200);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0,0, 500, 500);
    layeredPane.add(label1); // the first component added is the one that appears on the top of the z index
    layeredPane.add(label2); // the order in which components are added is the order they're stacked in the pane
    layeredPane.add(label3);

    // We can change the order in which the labels are stacked on top of eachother. With layeredPanes, there
    // is a name for each layer. See a visual at https://docs.oracle.com/javase/7/docs/api/index.html
    // This is all the layeres inside a JLayeredPane(). We can specify which layer we want to add a component to.

    layeredPane.add(label4, JLayeredPane.DRAG_LAYER);
    // despite adding label4 last it appears at the top because it's in the DRAG_LAYER

    // we can add labels to different layers via a shortcut:
    // layeredPane.add(label4, Integer.valueOf(x);
    // bigger values of x will be a layer higher up in the pane

    // lets make a frame to add our pane to.
    JFrame frame2 = new JFrame("JlayeredPane");
    frame2.add(layeredPane);
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(500,500);
    frame2.setLayout(null);
    frame2.setVisible(true);

    // summary:
    // we add components to a layered pane, specify the level of the pane for each component and then add
    // the layered pane to the frame or other container

  }


}
