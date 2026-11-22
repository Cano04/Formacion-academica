import re
import tkinter as tk
from tkinter import messagebox

def validar_coordenadas(entrada):
    patron = re.compile(r"^[A-Z]\(-?\d{1,2},-?\d{1,2}\)$|^[A-Z]\[-?\d{1,2},-?\d{1,2}\]$")



    if patron.match(entrada):
        return True
    else:
        return False

def graficar_coordenadas(entrada):
    messagebox.showerror("Error", "La función de graficar ha sido eliminada.")

    # No need for this else block anymore since we don't plot


def comprobar():
    entrada = entrada_var.get().strip()
    if validar_coordenadas(entrada):
        messagebox.showinfo("Validación", "Las coordenadas son válidas")
    else:
        messagebox.showerror("Error", "Formato incorrecto. Debe ser A(xx,xx) o A[xx,xx]. Asegúrese de no tener espacios adicionales.")

def graficar():
    entrada = entrada_var.get().strip()
    if validar_coordenadas(entrada):
        graficar_coordenadas(entrada)
    else:
        messagebox.showerror("Error", "Formato incorrecto. No se puede graficar. Asegúrese de que las coordenadas sean válidas.")

root = tk.Tk()
root.title("Coordenadas")
root.configure(bg='lightblue')



entrada_var = tk.StringVar()
entrada_var.set("A(xx,xx)")

label = tk.Label(root, text="Ingrese las coordenadas:")
label.pack()

entry = tk.Entry(root, textvariable=entrada_var, width=30)
entry.pack()

boton_comprobar = tk.Button(root, text="Comprobar", command=comprobar)
boton_comprobar.pack()

# boton_graficar = tk.Button(root, text="Graficar", command=graficar)
# boton_graficar.pack()




root.mainloop()
