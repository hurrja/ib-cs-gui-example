from PySide6.QtWidgets import QApplication
from PySide6.QtCore import QTimer
import sys
from Application import Application

application = Application()
QTimer.singleShot(0, application.run)
QApplication(sys.argv).exec()
