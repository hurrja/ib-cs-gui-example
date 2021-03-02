import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

// gui extends frame
class GUI extends JFrame
{
  public GUI (Application application)
  {
    super ("A simple GUI demo");
    this.application = application;

    // frame properties
    setSize (800, 600);
    setLayout (new FlowLayout ());

    // menu bar with one item for quitting the program
    menuBar = new JMenuBar ();
    JMenu fileMenu = new JMenu ("File");
    JMenuItem quitMenuItem = new JMenuItem ("Quit");
    quitMenuItem.addActionListener ((ActionEvent e) -> System.exit (0));
    fileMenu.add (quitMenuItem);
    menuBar.add (fileMenu);
    setJMenuBar (menuBar);

    // a label to show time as string, and timer for updating string
    timeLabel = new JLabel ();
    showTime ();
    add (timeLabel);
    timer = new Timer (1000, (ActionEvent e) -> showTime ());
    timer.start ();

    // a label for showing the boolean state of the program
    stateLabel = new JLabel ();
    showState ();
    add (stateLabel);

    // a button for flipping program state
    flipButton = new JButton ("Flip");
    flipButton.addActionListener ((ActionEvent e) -> { application.flipState (); showState (); });
    add (flipButton);

    setVisible (true); // show frame
  }

  void showState ()
  {
    stateLabel.setText (String.valueOf (application.getState ()));
  }

  void showTime ()
  {
    LocalTime now = LocalTime.now ();
    timeLabel.setText (now.getHour () + ":" + now.getMinute () + ":" + now.getSecond ());
  }

  private Application application;
  private JMenuBar menuBar;
  private JLabel stateLabel, timeLabel;
  private JButton flipButton;
  private Timer timer;
}
