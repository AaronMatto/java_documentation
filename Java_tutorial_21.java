// CONTENTS: JSlider, Progress bar
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Java_tutorial_21 {

  public static void main(String args[]){
    // Slider
    // JSlider = GUI component that lets the user enter a value by using an adjustable slider
    // SliderClass slider = new SliderClass();

    // Progress Bar
    // progress bar = Visual aid to let user know that an operation is processing
    ProgressBarClass progressBar = new ProgressBarClass();
  }

}


// SLIDER
public class SliderClass implements ChangeListener {
  // ChangeListener will allow us to actually update something upon a change
  JFrame frame;
  JPanel panel;
  JLabel label;
  JSlider slider;


  SliderClass(){
    frame = new JFrame("Slider demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new JPanel();
    label = new JLabel();
    slider = new JSlider(0, 100, 50); // 50 is the default value

    slider.setPreferredSize(new Dimension(400, 200));
    slider.setPaintTicks(true);
    slider.setMinorTickSpacing(10); // need these two lines to make ticks appear

    slider.setPaintTrack(true);
    slider.setMajorTickSpacing(25); // shows major ticks every 25 spaces

    slider.setPaintLabels(true); // this makes numbers appear for major ticks
    slider.setFont(new Font("MV Boli", Font.PLAIN, 15));

    slider.setOrientation(SwingConstants.VERTICAL); // Makes the slider vertical not horizontal

    label.setText("Temp = " + slider.getValue()); // this shows the default value of the slider
    label.setFont(new Font("MV Boli", Font.PLAIN, 25));

    // make the label text dynamically update to the selected value of the slider
    slider.addChangeListener(this); // we say 'this' since this class implements ChangeListener

    panel.add(slider);
    panel.add(label);

    frame.add(panel);
    frame.setSize(420, 420);
    frame.setVisible(true);
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    label.setText("Temperature = " + slider.getValue());
  }
}


// PROGRESS BAR
public class ProgressBarClass {

  JFrame frame = new JFrame();
  JProgressBar bar = new JProgressBar(0, 100); // min and max values

  ProgressBarClass(){
    bar.setValue(0); // initial value
    bar.setBounds(0,0, 400, 50);
    bar.setStringPainted(true); // this adds a % to the progress bar based on its fill value
    bar.setFont(new Font("MV Boli", Font.BOLD, 25));
    bar.setForeground(Color.red); // color of fill in progress bar
    bar.setBackground(Color.black); // color before fill takes over it

    frame.add(bar);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420);
    frame.setLayout(null);
    frame.setVisible(true);

    // filling the progress bar
    fill();

  }

  public void fill(){
    int counter = 0;
    while(counter < 101){
    bar.setValue(counter);
    try{
        Thread.sleep(50);
      } catch (InterruptedException e){
        e.printStackTrace();
      }
    counter += 1;
    }
    bar.setString("Done!");
  }


}
