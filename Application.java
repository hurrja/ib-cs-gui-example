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

import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class Application
{
  // constructor is run at the start of the program
  public Application ()
  {
    gui = new GUI (this);
    state = false;

    // create and start a timer: timers can be used to perform
    // functions without user-initiated events; the given lambda
    // expression is run every 1000 ms
    timer = new Timer (1000, (ActionEvent e) -> gui.showTime ());
    timer.start ();
  }

  // the "state" of this simple application is just a boolean, and
  // this method will change the state by flipping the value
  public void flipState ()
  {
    state = !state;
  }

  public boolean getState () { return state; }
  
  private GUI gui;
  private boolean state;
  private Timer timer;
}
