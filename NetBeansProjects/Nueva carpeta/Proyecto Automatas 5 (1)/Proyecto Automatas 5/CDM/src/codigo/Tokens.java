package codigo;

public enum Tokens {
    
    TipoVariable,
    TipoConstante,
    TipoNulo,
    TipoGenerico,
    
    InicioPrograma,
    FinPrograma,
    Ejecutar,
    FuncionPrincipal,
    Clase,
    Importar,
    
    If,
    Else,
    While,
    For,
    DefFuncion,
    Return,
    
    Input,
    Output,
    
    BoolTrue,
    BoolFalse,
    
    Suma,
    Resta,
    Multiplicacion,
    Division,
    Modulo,
    Incremento,
    Decremento,
    
    IgualComparacion,
    Diferente,
    MenorIgual,
    MayorIgual,
    Menor,
    Mayor,
    
    And,
    Or,
    Not,
    
    Igual,
    SumaAsignacion,
    RestaAsignacion,
    MultiplicacionAsignacion,
    DivisionAsignacion,
    
    ParentesisAbre,
    ParentesisCierra,
    LlaveAbre,
    LlaveCierra,
    CorcheteAbre,
    CorcheteCierra,
    PuntoyComa,
    Coma,
    DosPuntos,
    Punto,
    
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
            case TipoVariable: return "Tipo de variable (Vill)";
            case TipoConstante: return "Tipo constante (Con)";
            case TipoNulo: return "Tipo nulo (Nad)";
            case TipoGenerico: return "Tipo genérico (Gen)";
            
            case InicioPrograma: return "Inicio del programa (INICIO:)";
            case FinPrograma: return "Fin del programa (FINAL)";
            case Ejecutar: return "Ejecutar función (Eje)";
            case FuncionPrincipal: return "Función principal (Capivara)";
            case Clase: return "Definición de clase (Clase)";
            case Importar: return "Importar módulo (Importar)";
            
            case If: return "Condicional Si";
            case Else: return "Condicional Sino";
            case While: return "Bucle Mientras";
            case For: return "Bucle Para";
            case DefFuncion: return "Definir función (Hacer)";
            case Return: return "Retornar";
            
            case Input: return "Entrada (Leer)";
            case Output: return "Salida (Escribir)";
            
            case BoolTrue: return "Verdadero";
            case BoolFalse: return "Falso";
            
            case Suma: return "Operador suma (+)";
            case Resta: return "Operador resta (-)";
            case Multiplicacion: return "Operador multiplicación (*)";
            case Division: return "Operador división (/)";
            case Modulo: return "Operador módulo (%)";
            case Incremento: return "Operador incremento (++)";
            case Decremento: return "Operador decremento (--)";
            
            case IgualComparacion: return "Operador igual (==)";
            case Diferente: return "Operador diferente (!=)";
            case MenorIgual: return "Operador menor igual (<=)";
            case MayorIgual: return "Operador mayor igual (>=)";
            case Menor: return "Operador menor (<)";
            case Mayor: return "Operador mayor (>)";
            
            case And: return "Operador AND (&&)";
            case Or: return "Operador OR (||)";
            case Not: return "Operador NOT (!)";
            
            case Igual: return "Operador asignación (=)";
            case SumaAsignacion: return "Suma y asignación (+=)";
            case RestaAsignacion: return "Resta y asignación (-=)";
            case MultiplicacionAsignacion: return "Multiplicación y asignación (*=)";
            case DivisionAsignacion: return "División y asignación (/=)";
            
            case ParentesisAbre: return "Paréntesis que abre (";
            case ParentesisCierra: return "Paréntesis que cierra )";
            case LlaveAbre: return "Llave que abre {";
            case LlaveCierra: return "Llave que cierra }";
            case CorcheteAbre: return "Corchete que abre [";
            case CorcheteCierra: return "Corchete que cierra ]";
            case PuntoyComa: return "Punto y coma (;)";
            case Coma: return "Coma (,)";
            case DosPuntos: return "Dos puntos (:)";
            case Punto: return "Punto (.)";
            
            case Identificador: return "Identificador";
            case NumeroEntero: return "Número entero";
            case NumeroDecimal: return "Número decimal";
            case Cadena: return "Cadena de texto";
            
            case ErrorIdentificadorMinuscula: return "Error: Identificador debe empezar con mayúscula";
            case ErrorPalabraReservadaMin: return "Error: Palabra reservada debe empezar con mayúscula";
            case ErrorNumeroIncompleto: return "Error: Número mal formado";
            case ErrorCadenaNoCerrada: return "Error: Cadena sin cerrar";
            
            case ERROR: return "Token no reconocido";
            case EOF: return "Fin de archivo";
            
            default: return "Token desconocido";
        }
    }
    
    public boolean isError() {
        return this == ERROR || 
               this == ErrorIdentificadorMinuscula || 
               this == ErrorPalabraReservadaMin || 
               this == ErrorNumeroIncompleto || 
               this == ErrorCadenaNoCerrada;
    }
    
    public boolean isPalabraReservada() {
        return this == TipoVariable || this == TipoConstante || this == TipoNulo || 
               this == TipoGenerico || this == Ejecutar || this == FuncionPrincipal ||
               this == InicioPrograma || this == FinPrograma || this == If || 
               this == Else || this == While || this == For || this == DefFuncion || 
               this == Return || this == Input || this == Output || 
               this == BoolTrue || this == BoolFalse || this == Clase || 
               this == Importar;
    }
    
    public boolean isOperador() {
        return this == Suma || this == Resta || this == Multiplicacion || 
               this == Division || this == Modulo || this == Incremento || 
               this == Decremento || this == IgualComparacion || this == Diferente || 
               this == MenorIgual || this == MayorIgual || this == Menor || 
               this == Mayor || this == And || this == Or || this == Not ||
               this == Igual || this == SumaAsignacion || this == RestaAsignacion ||
               this == MultiplicacionAsignacion || this == DivisionAsignacion;
    }
    
    public boolean isDelimitador() {
        return this == ParentesisAbre || this == ParentesisCierra || 
               this == LlaveAbre || this == LlaveCierra || 
               this == CorcheteAbre || this == CorcheteCierra ||
               this == PuntoyComa || this == Coma || this == DosPuntos || 
               this == Punto;
    }
}
