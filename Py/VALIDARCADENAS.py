import re

def validate_upper_lower_space(s):
    """Validate string with at least one uppercase, one lowercase letter, and one whitespace."""
    pattern = r'^(?=.*[A-Z])(?=.*[a-z])(?=.*\s).+$'


    return bool(re.match(pattern, s))

def validate_length(s):
    """Validate string with uppercase, lowercase letters, length between 5 and 10."""
    pattern = r'^(?=.*[a-z])(?=.*[A-Z])[A-Za-z]{5,10}$'
    return bool(re.match(pattern, s))

def validate_digits(s):
    """Validate string containing exactly 10 digits."""
    pattern = r'^\d{10}$'
    return bool(re.match(pattern, s))

def validate_phone_number(s):
    """Validate phone number in the format (444)-832-45-67."""
    pattern = r'^\(\d{3}\)-\d{3}-\d{2}-\d{2}$'
    return bool(re.match(pattern, s))

def main():
    print("Ingrese una cadena para validar:")
    test_strings = [
        "Hello World",  # Test for uppercase, lowercase, and space
        "Hello",        # Test for length
        "1234567890",   # Test for digits
        "(444)-832-45-67"  # Test for phone number
    ]
    
    for s in test_strings:
        print(f"Validando: {s}")
        print(f"Contiene mayúsculas, minúsculas y espacios: {validate_upper_lower_space(s)}")
        print(f"Longitud entre 5 y 10 caracteres: {validate_length(s)}")
        print(f"Contiene exactamente 10 dígitos: {validate_digits(s)}")
        print(f"Número de teléfono válido: {validate_phone_number(s)}")
        print()

if __name__ == "__main__":
    main()
