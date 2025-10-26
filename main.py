from PySide6.QtWidgets import QApplication
from PySide6.QtCore import QTimer
import sys
from Application import Application

q_app = QApplication(sys.argv)
# larger font size for better visibility
font = q_app.font()
font.setPointSize(2 * font.pointSize())
q_app.setFont(font)

# eval run() of class Application when QApplication runs
application = Application()
QTimer.singleShot(0, application.run)
q_app.exec()
