import tkinter as tk
from tkinter import messagebox
import re

def validate_name(s):
    pattern = r'^[A-Z][a-z]*(\s[A-Z][a-z]*){1,3}$'
    return bool(re.match(pattern, s))

def validate_card_number(s):
    pattern = r'^\d{4}-\d{4}-\d{4}-\d{4}$'
    return bool(re.match(pattern, s))

def validate_reference_number(s):
    pattern = r'^\d{6}$'
    return bool(re.match(pattern, s))

def validate_verification_number(s):
    pattern = r'^\d{3}$'
    return bool(re.match(pattern, s))

def validate_expiration_date(s):
    pattern = r'^(0[1-9]|1[0-2])\/\d{2}$'
    return bool(re.match(pattern, s))

def validate_balance(s):
    pattern = r'^\d+(\.\d{1,2})?$'
    return bool(re.match(pattern, s))

def submit_form():
    name = entry_name.get()
    card_number = entry_card_number.get()
    reference_number = entry_reference_number.get()
    verification_number = entry_verification_number.get()
    expiration_date = entry_expiration_date.get()
    balance = entry_balance.get()

    if not validate_name(name):
        messagebox.showerror("Error", "Nombre inválido. Debe tener entre 2 y 4 palabras, cada una comenzando con mayúscula.")
        return
    if not validate_card_number(card_number):
        messagebox.showerror("Error", "Número de tarjeta inválido. Debe seguir el formato dddd-dddd-dddd-dddd.")
        return
    if not validate_reference_number(reference_number):
        messagebox.showerror("Error", "Referencia numérica inválida. Debe contener exactamente 6 dígitos.")
        return
    if not validate_verification_number(verification_number):
        messagebox.showerror("Error", "Número de verificación inválido. Debe contener exactamente 3 dígitos.")
        return
    if not validate_expiration_date(expiration_date):
        messagebox.showerror("Error", "Fecha de expiración inválida. Debe seguir el formato MM/AA.")
        return
    if not validate_balance(balance):
        messagebox.showerror("Error", "Saldo o cantidad inválido. Debe ser un número decimal con hasta 2 dígitos después del punto.")
        return

    messagebox.showinfo("Éxito", "Todos los datos son válidos.")

# Create the main window
root = tk.Tk()
root.title("Datos de Pago")
root.configure(bg='lightblue')

# Create input fields
label_name = tk.Label(root, text="Nombre:", font=('Arial', 12), bg='lightblue')
label_name.pack(pady=5)
entry_name = tk.Entry(root, width=50, font=('Arial', 12))

entry_name.pack(pady=5)

label_card_number = tk.Label(root, text="Número de Tarjeta:", font=('Arial', 12), bg='lightblue')
label_card_number.pack(pady=5)
entry_card_number = tk.Entry(root, width=50, font=('Arial', 12))

entry_card_number.pack(pady=5)

label_reference_number = tk.Label(root, text="Referencia numérica:", font=('Arial', 12), bg='lightblue')
label_reference_number.pack(pady=5)
entry_reference_number = tk.Entry(root, width=50, font=('Arial', 12))

entry_reference_number.pack(pady=5)

label_verification_number = tk.Label(root, text="Número de verificación:", font=('Arial', 12), bg='lightblue')
label_verification_number.pack(pady=5)
entry_verification_number = tk.Entry(root, width=50, font=('Arial', 12))

entry_verification_number.pack(pady=5)

label_expiration_date = tk.Label(root, text="Fecha de expiración (MM/AA):", font=('Arial', 12), bg='lightblue')
label_expiration_date.pack(pady=5)
entry_expiration_date = tk.Entry(root, width=50, font=('Arial', 12))

entry_expiration_date.pack(pady=5)

label_balance = tk.Label(root, text="Saldo o Cantidad:", font=('Arial', 12), bg='lightblue')
label_balance.pack(pady=5)
entry_balance = tk.Entry(root, width=50, font=('Arial', 12))

entry_balance.pack(pady=5)

submit_button = tk.Button(root, text="Validar Datos", command=submit_form, font=('Arial', 12))
submit_button.pack(pady=5)

# Run the application
root.mainloop()
