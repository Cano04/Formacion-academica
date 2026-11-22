import tkinter as tk
from tkinter import scrolledtext, messagebox
import serial
import threading
import mysql.connector
import time

class SerialReaderApp:
    def __init__(self, master, port='COM3', baudrate=9600, db_config=None):
        self.master = master
        self.master.title("Serial Data Reader")
        self.port = port
        self.baudrate = baudrate
        self.running = False

        # Setup GUI
        self.text_area = scrolledtext.ScrolledText(master, width=60, height=20, state='disabled')
        self.text_area.pack(padx=10, pady=10)

        self.start_button = tk.Button(master, text="Start Reading", command=self.start_reading)
        self.start_button.pack(side=tk.LEFT, padx=10, pady=5)

        self.stop_button = tk.Button(master, text="Stop Reading", command=self.stop_reading, state='disabled')
        self.stop_button.pack(side=tk.LEFT, padx=10, pady=5)

        # Setup database connection
        if db_config is None:
            db_config = {
                'host': 'localhost',
                'user': 'root',
                'password': '',
                'database': 'serial_data_db'
            }
        self.db_config = db_config

        try:
            self.conn = mysql.connector.connect(**self.db_config)
            self.cursor = self.conn.cursor()
            self.cursor.execute('''
                CREATE TABLE IF NOT EXISTS data (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    timestamp VARCHAR(255),
                    data TEXT
                )
            ''')
            self.conn.commit()
        except mysql.connector.Error as err:
            messagebox.showerror("Database Error", f"Error connecting to MySQL: {err}")
            self.conn = None
            self.cursor = None

        # Serial port object
        self.ser = None
        self.thread = None

    def start_reading(self):
        if self.conn is None or self.cursor is None:
            messagebox.showerror("Error", "No database connection available.")
            return

        try:
            self.ser = serial.Serial(self.port, self.baudrate, timeout=1)
        except serial.SerialException as e:
            messagebox.showerror("Error", f"Could not open serial port {self.port}: {e}")
            return

        self.running = True
        self.start_button.config(state='disabled')
        self.stop_button.config(state='normal')
        self.thread = threading.Thread(target=self.read_serial)
        self.thread.daemon = True
        self.thread.start()

    def stop_reading(self):
        self.running = False
        self.start_button.config(state='normal')
        self.stop_button.config(state='disabled')
        if self.ser and self.ser.is_open:
            self.ser.close()

    def read_serial(self):
        while self.running:
            try:
                if self.ser.in_waiting > 0:
                    line = self.ser.readline().decode('utf-8').strip()
                    if line:
                        timestamp = time.strftime('%Y-%m-%d %H:%M:%S')
                        self.insert_data(timestamp, line)
                        self.update_text_area(f"{timestamp}: {line}")
            except Exception as e:
                self.update_text_area(f"Error reading serial: {e}")
                self.running = False
                self.start_button.config(state='normal')
                self.stop_button.config(state='disabled')
                if self.ser and self.ser.is_open:
                    self.ser.close()
                break

    def insert_data(self, timestamp, data):
        try:
            self.cursor.execute('INSERT INTO data (timestamp, data) VALUES (%s, %s)', (timestamp, data))
            self.conn.commit()
        except mysql.connector.Error as err:
            self.update_text_area(f"Database insert error: {err}")

    def update_text_area(self, text):
        self.text_area.config(state='normal')
        self.text_area.insert(tk.END, text + '\n')
        self.text_area.see(tk.END)
        self.text_area.config(state='disabled')

    def on_closing(self):
        self.stop_reading()
        if self.conn:
            self.conn.close()
        self.master.destroy()

if __name__ == "__main__":
    root = tk.Tk()
    # You can customize the db_config dictionary with your MySQL credentials if needed
    app = SerialReaderApp(root)
    root.protocol("WM_DELETE_WINDOW", app.on_closing)
    root.mainloop()
