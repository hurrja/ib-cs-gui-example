from PySide6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QLabel, QPushButton, QProgressBar
from PySide6.QtGui import QAction
import time

class GUI(QMainWindow):
    def __init__(self, application):
        super().__init__()
        self.application = application

        # menubar with one menu, one action to quit
        file_menu = self.menuBar().addMenu('File')
        quit_action = QAction("Quit", self)
        quit_action.triggered.connect(application.quit)
        file_menu.addAction(quit_action)

        # horizontal layout for components
        layout = QHBoxLayout()
        layout_widget = QWidget()
        layout_widget.setLayout(layout)
        self.setCentralWidget(layout_widget)
        
        # label showing time
        self.time_label = QLabel(layout_widget)
        layout.addWidget(self.time_label)

        # label showing state
        self.state_label = QLabel(layout_widget)
        layout.addWidget(self.state_label)

        # button for flipping state
        button = QPushButton('Flip', layout_widget)
        layout.addWidget(button)
        button.clicked.connect(self._flip_state)

        # cycling progress bar
        self.COUNTER_MAX = 30
        self.counter = 0
        self.progress_bar = QProgressBar(layout_widget)
        self.progress_bar.setMinimum(0)
        self.progress_bar.setMaximum(self.COUNTER_MAX - 1)
        layout.addWidget(self.progress_bar)

        self._show_state()
        self._show_time()
        self.show()

    # update counter and show time and counter status
    def update_and_show_time(self):
        self.counter += 1
        self.counter %= self.COUNTER_MAX
        self._show_time()

    # show the state of the app
    def _show_state(self):
        self.state_label.setText(f'{self.application.get_state()}')

    # flip the state of the app
    def _flip_state(self):
        self.application.flip_state()
        self._show_state()

    # show time and counter status
    def _show_time(self):
        self.time_label.setText(f'{time.strftime("%H:%M:%S")}')
        self.progress_bar.setValue(self.counter)
