package codigo;

public enum Tokens {

    Creacion,
    Procedimiento,
    En,
    Varchar,
    Sobre,
    Dentro,
    Begin,
    Seleccion,
    Desde,
    Donde,
    And,
    Final,
    llamda,
    Ejercicio1,

    DelimitadorPrincipal,
    DelimitadorFinal,
    Comillas,
    Punto,
    PuntoYcoma,
    arroba,
    Coma,
    ParentesisAbre,
    ParentesisCierra,

    Identificador,
    NumeroEntero,
    NumeroDecimal,
    Cadena,

    ErrorIdentificadorMinuscula,
    ErrorPalabraReservadaMin,
    ErrorNumeroIncompleto,
    ErrorCadenaNoCerrada,

    ERROR,
    EOF;

    public String getDescription() {
        switch (this) {
            case Creacion:
                return "Palabra Reservada CREATE";
            case Procedimiento:
                return "Palabra Reservada PROCEDURE";
            case En:
                return "Palabra Reservada IN";
            case Varchar:
                return "Palabra Reservada VARCHAR";
            case Sobre:
                return "Palabra Reservada OUT";
            case Dentro:
                return "Palabra Reservada INT";
            case Begin:
                return "Palabra Reservada BEGIN";
            case Seleccion:
                return "Palabra Reservada SELECT";
            case Desde:
                return "Palabra Reservada FROM";
            case Donde:
                return "Palabra Reservada WHERE";
            case And:
                return "Palabra Reservada AND";
            case Final:
                return "Palabra Reservada END";
            case llamda:
                return "Palabra Reservada CALL";
            case DelimitadorPrincipal:
                return "Palabra Reservada DELIMITER //";
            case DelimitadorFinal:
                return "Palabra Reservada DELIMITER ;";
            case Comillas:
                return "Comillas";
            case Punto:
                return "Punto";
            case PuntoYcoma:
                return "Punto y coma (;)";
            case arroba:
                return "Arroba (@)";
            case Coma:
                return "Coma (,)";
            case ParentesisAbre:
                return "Parentesis Abre (";
            case ParentesisCierra:
                return "Parentesis Cierra )";
            case Ejercicio1:
                return "Identificador";
            case Identificador:
                return "Identificador";
            case NumeroEntero:
                return "Número entero";
            case NumeroDecimal:
                return "Número decimal";
            case Cadena:
                return "Cadena de texto";

            case ErrorIdentificadorMinuscula:
                return "Error: Identificador debe empezar con mayúscula";
            case ErrorPalabraReservadaMin:
                return "Error: Palabra reservada debe empezar con mayúscula";
            case ErrorNumeroIncompleto:
                return "Error: Número mal formado";
            case ErrorCadenaNoCerrada:
                return "Error: Cadena sin cerrar";

            case ERROR:
                return "Token no reconocido";
            case EOF:
                return "Fin de archivo";

            default:
                return "Token desconocido";
        }
    }

    public boolean isError() {
        return this == ERROR
                || this == ErrorIdentificadorMinuscula
                || this == ErrorPalabraReservadaMin
                || this == ErrorNumeroIncompleto
                || this == ErrorCadenaNoCerrada;
    }

    public boolean isPalabraReservada() {
        return this == Creacion
                || this == Procedimiento
                || this == En
                || this == Varchar
                || this == Sobre
                || this == Dentro
                || this == Begin
                || this == Seleccion
                || this == Desde
                || this == Donde
                || this == And
                || this == Final
                || this == llamda;
    }
    
    public boolean isDelimitador() {
        return this == ParentesisAbre
                || this == ParentesisCierra
                || this == PuntoYcoma
                || this == Coma
                || this == Punto;
    }
}