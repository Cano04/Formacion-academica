package codigo;

public enum Tokens {

    // ===== Palabras reservadas =====
    Private,                 // private
    Int,                     // int
    If,                      // if
    Return,                  // return
    GetStickCollisionZone,   // getStickCollisionZone

    // ===== Símbolos =====
    ParentesisAbre,          // (
    ParentesisCierra,        // )
    Coma,                    // ,
    PuntoYcoma,              // ;
    arroba,                  // @
    Comillas,                // "
    Punto,                   // .
    Igriega,                 // &&
    LlaveAbre,               // {
    LlaveCierra,             // }

    // ===== Literales =====
    Identificador,
    NumeroEntero,
    NumeroDecimal,
    Cadena,

    // ===== Errores específicos =====
    ErrorCapivara,
    ErrorMata,
    ErrorApocoSi,
    ErrorMoi,
    ErrorClash,

    // ===== Errores generales =====
    ERROR,
    EOF;

    public String getDescription() {
        switch (this) {
            // ---- Palabras reservadas ----
            case Private: return "Palabra reservada 'private'";
            case Int: return "Palabra reservada 'int'";
            case If: return "Palabra reservada 'if'";
            case Return: return "Palabra reservada 'return'";
            case GetStickCollisionZone: return "Palabra reservada 'getStickCollisionZone'";

            // ---- Símbolos ----
            case ParentesisAbre: return "Paréntesis de apertura '('";
            case ParentesisCierra: return "Paréntesis de cierre ')'";
            case Coma: return "Coma ','";
            case PuntoYcoma: return "Punto y coma ';'";
            case arroba: return "Símbolo arroba '@'";
            case Comillas: return "Comillas '\"'";
            case Punto: return "Punto '.'";
            case Igriega: return "Operador lógico '&&'";
            case LlaveAbre: return "Llave de apertura '{'";
            case LlaveCierra: return "Llave de cierre '}'";

            // ---- Literales ----
            case Identificador: return "Identificador";
            case NumeroEntero: return "Número entero";
            case NumeroDecimal: return "Número decimal";
            case Cadena: return "Cadena de texto";

            // ---- Errores específicos ----
            case ErrorCapivara: return "Error léxico: uso no permitido de 'Capivara'";
            case ErrorMata: return "Error léxico: uso no permitido de 'Mata'";
            case ErrorApocoSi: return "Error léxico: uso no permitido de 'ApocoSi'";
            case ErrorMoi: return "Error léxico: uso no permitido de 'Moi'";
            case ErrorClash: return "Error léxico: uso no permitido de 'Clash'";

            // ---- Errores generales ----
            case ERROR: return "Token no reconocido";
            case EOF: return "Fin de archivo";

            default: return "Token desconocido";
        }
    }

    public boolean isPalabraReservada() {
        return this == Private
                || this == Int
                || this == If
                || this == Return
                || this == GetStickCollisionZone;
    }

    public boolean isDelimitador() {
        return this == ParentesisAbre
                || this == ParentesisCierra
                || this == PuntoYcoma
                || this == Coma
                || this == Punto
                || this == LlaveAbre
                || this == LlaveCierra;
    }

    public boolean isError() {
        return this == ERROR
                || this == ErrorCapivara
                || this == ErrorMata
                || this == ErrorApocoSi
                || this == ErrorMoi
                || this == ErrorClash;
    }
}

