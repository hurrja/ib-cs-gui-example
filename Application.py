from PySide6.QtWidgets import QWidget
from PySide6.QtCore import QTimer, Slot

import GUI
import sys

class Application:

    def run(self):
        self.state = False # "state" of app is one boolean variable
        self.gui = GUI.GUI(self)

        # timer running every second; needs to be an attribute so that
        # the timer is not garbage collected
        self.timer = QTimer()
        self.timer.setInterval(1000)
        self.timer.timeout.connect(self.gui.update_and_show_time)
        self.timer.start()

    @Slot()
    def quit(self):
        sys.exit()

    def flip_state(self):
        self.state = not self.state

    def get_state(self):
        return self.state
