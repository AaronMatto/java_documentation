import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
// CONTENTS: Border layouts, margins, nested panels,

public class Java_tutorial_16 {
  // Border layouts
  public static void main (String args[]) {
    // Layout Manager = defines the natural layout for components within a container (panel)
    // There are 3 common managers:

    // BorderLayout = A BorderLayout places components in five areas: NORTH, SOUTH, EAST, WEST, CENTER
    //                So we use this when we use seperate panels as border that are placed in one of those areas
    //                All extra space is placed in the center area.
    //                A central panel will expand proportionally to the frame.
    //                North and South border panels will expand according to width of frame and East and West according to height of frame.
    //                West and East borders with BorderLayout can be used for nav bars. Or N & S.
    //                Use S for a footer. Use a center for main body.

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLayout(new BorderLayout(10, 0)); // This is how we set our frame to have BorderLayout
    // the arguments here set the margin between panels. The first is the horizontal margin, for panels placed left
    // and right of eachother. The second is vertical margin, for panels placed above and below eachother.
    frame.setVisible(true);

    JPanel panelTop = new JPanel();
    JPanel panelEast = new JPanel();
    JPanel panelWest = new JPanel();
    JPanel panelSouth = new JPanel();
    JPanel panelCenter = new JPanel();

    panelTop.setBackground(Color.red);
    panelEast.setBackground(Color.green);
    panelWest.setBackground(Color.yellow);
    panelSouth.setBackground(Color.magenta);
    panelCenter.setBackground(Color.blue);

    frame.add(panelTop, BorderLayout.NORTH);
    frame.add(panelEast, BorderLayout.EAST);
    frame.add(panelWest, BorderLayout.WEST);
    frame.add(panelSouth, BorderLayout.SOUTH);
    frame.add(panelCenter, BorderLayout.CENTER);

    // Changing border dimensions
    panelTop.setPreferredSize(new Dimension(100,80)); // this is width,height. Changing the width won't do anything, only height.
    panelEast.setPreferredSize(new Dimension(60, 100)); // changing the height won't do anything, only width (for east and west)
    panelWest.setPreferredSize(new Dimension(60, 100));
    panelSouth.setPreferredSize(new Dimension(100, 80));
    panelCenter.setPreferredSize(new Dimension(100, 100));

    // Panels within panels - sub or nested panels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    panel1.setBackground(Color.black);
    panel2.setBackground(Color.darkGray);
    panel3.setBackground(Color.gray);
    panel4.setBackground(Color.lightGray);
    panel5.setBackground(Color.white); // comment this out to turn it blue again

    panelCenter.setLayout(new BorderLayout());
    // we have to set the panel we want to nest in with a new BorderLayout. We added it to our frame but now
    // panel 5 is also acting as a container so we set it with its own unique layout manager.

    panel1.setPreferredSize(new Dimension(50,50));
    panel2.setPreferredSize(new Dimension(50,50));
    panel3.setPreferredSize(new Dimension(50,50));
    panel4.setPreferredSize(new Dimension(50,50));
    panel5.setPreferredSize(new Dimension(50,50));
    panelCenter.add(panel1, BorderLayout.NORTH);
    panelCenter.add(panel2, BorderLayout.WEST);
    panelCenter.add(panel3, BorderLayout.EAST);
    panelCenter.add(panel4, BorderLayout.SOUTH);
    panelCenter.add(panel5, BorderLayout.CENTER);
  }
}
