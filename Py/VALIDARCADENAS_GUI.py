import tkinter as tk
from tkinter import messagebox
import re

def validate_upper_lower_space(s):
    pattern = r'^(?=.*[A-Z])(?=.*[a-z])(?=.*\s).+$'
    return bool(re.match(pattern, s))

def validate_length(s):
    pattern = r'^(?=.*[a-z])(?=.*[A-Z])[A-Za-z]{5,10}$'
    return bool(re.match(pattern, s))

def validate_digits(s):
    pattern = r'^\d{10}$'
    return bool(re.match(pattern, s))

def validate_phone_number(s):
    pattern = r'^\(\d{3}\)-\d{3}-\d{2}-\d{2}$'
    return bool(re.match(pattern, s))

def validate_upper_lower_space_input():
    input_text = entry_upper_lower_space.get()
    result = validate_upper_lower_space(input_text)
    messagebox.showinfo("Resultado de Validación", f"Contiene al menos una mayúscula, una minúscula y un espacio: {result}")

def validate_length_input():
    input_text = entry_length.get()
    result = validate_length(input_text)
    messagebox.showinfo("Resultado de Validación", f"Longitud entre 5 y 10 caracteres: {result}")

def validate_digits_input():
    input_text = entry_digits.get()
    result = validate_digits(input_text)
    messagebox.showinfo("Resultado de Validación", f"Contiene exactamente 10 dígitos: {result}")

def validate_phone_number_input():
    input_text = entry_phone_number.get()
    result = validate_phone_number(input_text)
    messagebox.showinfo("Resultado de Validación", f"Número de teléfono válido: {result}")

# Create the main window
root = tk.Tk()
root.title("Validador de Cadenas")
root.configure(bg='green')

entry_upper_lower_space = tk.Entry(root, width=50, font=('Arial', 12))
entry_upper_lower_space.pack(pady=5, anchor='center')
validate_upper_lower_space_button = tk.Button(root, text="Validar Mayúsculas, Minúsculas y Espacios", command=validate_upper_lower_space_input, font=('Arial', 12))
validate_upper_lower_space_button.pack(pady=5, anchor='center')

entry_length = tk.Entry(root, width=50, font=('Arial', 12))
entry_length.pack(pady=5, anchor='center')
validate_length_button = tk.Button(root, text="Validar Longitud", command=validate_length_input, font=('Arial', 12))
validate_length_button.pack(pady=5, anchor='center')

entry_digits = tk.Entry(root, width=50, font=('Arial', 12))
entry_digits.pack(pady=5, anchor='center')
validate_digits_button = tk.Button(root, text="Validar Dígitos", command=validate_digits_input, font=('Arial', 12))
validate_digits_button.pack(pady=5, anchor='center')

entry_phone_number = tk.Entry(root, width=50, font=('Arial', 12))
entry_phone_number.pack(pady=5, anchor='center')
validate_phone_number_button = tk.Button(root, text="Validar Número de Teléfono", command=validate_phone_number_input, font=('Arial', 12))
validate_phone_number_button.pack(pady=5, anchor='center')

# Run the application
root.mainloop()
