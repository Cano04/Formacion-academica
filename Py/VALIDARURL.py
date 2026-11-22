import re
from tkinter import Tk, Label, Entry, Button, StringVar, messagebox

def validate_url(url):
    pattern = re.compile(r'^(http|https)://[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,}(/.*)?$')

    return pattern.match(url) is not None

def validate_email(email):
    pattern = re.compile(r'^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')



    return pattern.match(email) is not None

def validate_password(password):
    if (8 <= len(password) <= 12 and
        re.search(r'[A-Z]', password) and
        re.search(r'\d', password) and
        len(re.findall(r'[@#$%&*]', password)) >= 2):
        return True
    return False

def submit():
    url = url_var.get()
    email = email_var.get()
    password = password_var.get()

    url_valid = validate_url(url)
    email_valid = validate_email(email)
    password_valid = validate_password(password)

    result = f"URL valid: {url_valid}\nEmail valid: {email_valid}\nPassword valid: {password_valid}"
    messagebox.showinfo("Validation Results", result)

def main():
    root = Tk()
    root.title("Validation App")

    global url_var, email_var, password_var
    url_var = StringVar()
    email_var = StringVar()
    password_var = StringVar()

    Label(root, text="INGRESA LA URL:").pack()
    Entry(root, textvariable=url_var, width=30).pack()

    Label(root, text="INGRESA EL EMAIL:").pack()
    Entry(root, textvariable=email_var, width=30).pack()

    Label(root, text="INGRESA LA CONTRASEÑA:").pack()
    Entry(root, textvariable=password_var, width=30).pack()


    Button(root, text="VALIDAR", command=submit).pack()

    root.configure(bg='lightblue')
    root.mainloop()

if __name__ == "__main__":
    main()
