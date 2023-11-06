// Copyright (C) 2021 Jarmo Hurri

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

// gui extends frame and inherits all its methods (e.g., for setting
// size, adding components)

public class GUI extends JFrame
{
  // constructor will create all GUI components and set their properties
  public GUI (Application application)
  {
    super ("A simple GUI demo");
    this.application = application;

    // frame properties
    setSize (400, 300);
    setLayout (new FlowLayout ());

    // menu bar with one item for quitting the program
    menuBar = new JMenuBar ();
    JMenu fileMenu = new JMenu ("File");
    JMenuItem quitItem = new JMenuItem ("Quit");
    quitItem.addActionListener ((ActionEvent e) ->
                                System.exit (0));
    fileMenu.add (quitItem);
    menuBar.add (fileMenu);
    setJMenuBar (menuBar);

    // a label to show time as string, and timer for updating string
    timeLabel = new JLabel ();
    add (timeLabel);

    // a label for showing the boolean state of the program
    stateLabel = new JLabel ();
    showState ();
    add (stateLabel);

    // a button for flipping program state
    flipButton = new JButton ("Flip");
    flipButton.addActionListener ((ActionEvent e) ->
                                  {
                                    application.flipState ();
                                    showState ();
                                  });
    add (flipButton);
    // progress bar tracking elapsed time
    progressBar = new JProgressBar (0, TMAX);
    add (progressBar);
    showTime ();

    setVisible (true); // show frame
  }

  // a method which shows the state 
  private void showState ()
  {
    stateLabel.setText (String.valueOf (application.getState ()));
  }

  public void updateAndShowTime ()
  {
    secs++;
    secs %= TMAX;
    showTime ();
  }
  
  private void showTime ()
  {
    LocalTime now = LocalTime.now ();
    int hours = now.getHour (), minutes = now.getMinute (), seconds = now.getSecond ();
    timeLabel.setText (formatInt (hours) + ":" + formatInt (minutes) + ":" + formatInt (seconds));
    progressBar.setValue (secs);
  }

  // format an int as a string so that the minimum length is 2
  // characters, zero-padded if needed
  private String formatInt (int i)
  {
    return String.format ("%02d", i);
  }
  
  private Application application;
  private JMenuBar menuBar;
  private JLabel stateLabel, timeLabel;
  private JButton flipButton;
  private JProgressBar progressBar;
  private final int TMAX = 30;
  private int secs = 0;
}
