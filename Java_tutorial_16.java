import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;

// CONTENTS: BorderLayouts, margins, nested panels, FlowLayout

public class Java_tutorial_16 {
  // Border layouts
  public static void main (String args[]) {
    // Layout Manager = defines the natural layout for components within a container (panel or frame)
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


    // FLOW LAYOUT
    // FlowLayout = a layout manager that places components in a row, sized at their preferred size. If the
    //              horizontal space in the container is too small, the FlowLayout class uses the next
    //              available row. We can see an exmaple of a flowlayout used on a panel in a frame below.

    // new frame
    JFrame frame2 = new JFrame();
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(500,500);
    frame2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
    // in the brackets of new FlowLayout() we can specify the alignment. LEADING will move the component
    // to the left, CENTER to center and TRAILING to move component to the right.
    // Can also set the vertical and horizontal gaps between components too.

    // NOTE: if we added the buttons to the frame NOT the panel then they will appear in the frame.
    // If we then resize the frame the buttons will dynamically create more or less rows as they need them
    // based on the size of the frame. This doesn't happen when the buttons are inside a panel, but it would
    // happen for multiple panels.

    // new panel
    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(250, 250));
    panel.setBackground(Color.orange);
    panel.setLayout(new FlowLayout()); // HERE


    // add buttons to panel
    panel.add(new JButton("1")); // this is a quicker way of creating a button as opposed to creating a
    // variable for the button JButton button = new JButton(); and then doing panel.add(button)
    panel.add(new JButton("2"));
    panel.add(new JButton("3"));
    panel.add(new JButton("4"));
    panel.add(new JButton("5"));
    panel.add(new JButton("6"));
    panel.add(new JButton("7"));
    panel.add(new JButton("8"));
    panel.add(new JButton("9"));

    // add panel to frame and make frame visible
    frame2.add(panel);
    frame2.setVisible(true);
    // As can be seen, the number of buttons exceeds the width of the panel. If we make the panel narrower,
    // then the buttons will form more rows. Make it wider and the buttons will form less rows.
  }
}
