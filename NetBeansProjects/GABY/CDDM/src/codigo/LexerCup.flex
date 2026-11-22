package codigo;

import java_cup.runtime.Symbol;

%%

%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%char
%line
%column

// Definición de patrones léxicos
L=[a-zA-Z_]
D=[0-9]
espacio=[ \t\r\n]+
saltoLinea=\r|\n|\r\n

// Patrones específicos del lenguaje Capivara
IDENTIFICADOR_MAYUS=[A-Z]([a-zA-Z0-9])*
NUMERO_ENTERO={D}+
NUMERO_DECIMAL={D}+\.{D}+
CADENA=\"([^\\\"]|\\.)*\"

%{
    public String lexeme;
    
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn, yytext());
    }

    public int line;
    public int column;
    
    // Método para obtener información de posición
    public String getPosition() {
        return "Línea: " + (yyline + 1) + ", Columna: " + (yycolumn + 1);
    }
%}

%%

/* ========== COMENTARIOS ========== */
"//".* {/* Comentario de línea - Ignorar */}
"/*"([^*]|"*"[^/])*"*/" {/* Comentario de bloque - Ignorar */}

/* ========== PALABRAS RESERVADAS PRINCIPALES ========== */
"Vill"          {lexeme = yytext(); return symbol(sym.TipoVariable, yytext());}
"Con"           {lexeme = yytext(); return symbol(sym.TipoConstante, yytext());}
"Nad"           {lexeme = yytext(); return symbol(sym.TipoNulo, yytext());}
"Gen"           {lexeme = yytext(); return symbol(sym.TipoGenerico, yytext());}
"Eje"           {lexeme = yytext(); return symbol(sym.Ejecutar, yytext());}
"Capivara"      {lexeme = yytext(); return symbol(sym.FuncionPrincipal, yytext());}
"Importar"      {lexeme = yytext(); return symbol(sym.Importar, yytext());}
"Clase"         {lexeme = yytext(); return symbol(sym.Clase, yytext());}

/* ========== ESTRUCTURA DEL PROGRAMA ========== */
"INICIO:"       {lexeme = yytext(); return symbol(sym.InicioPrograma, yytext());}
"FINAL"         {lexeme = yytext(); return symbol(sym.FinPrograma, yytext());}

/* ========== ESTRUCTURAS DE CONTROL ========== */
"Si"            {lexeme = yytext(); return symbol(sym.If, yytext());}
"Sino"          {lexeme = yytext(); return symbol(sym.Else, yytext());}
"Mientras"      {lexeme = yytext(); return symbol(sym.While, yytext());}
"Para"          {lexeme = yytext(); return symbol(sym.For, yytext());}
"Hacer"         {lexeme = yytext(); return symbol(sym.DefFuncion, yytext());}
"Retornar"      {lexeme = yytext(); return symbol(sym.Return, yytext());}

/* ========== ENTRADA/SALIDA ========== */
"Leer"          {lexeme = yytext(); return symbol(sym.Input, yytext());}
"Escribir"      {lexeme = yytext(); return symbol(sym.Output, yytext());}

/* ========== VALORES BOOLEANOS ========== */
"Verdadero"     {lexeme = yytext(); return symbol(sym.BoolTrue, yytext());}
"Falso"         {lexeme = yytext(); return symbol(sym.BoolFalse, yytext());}

/* ========== OPERADORES ARITMÉTICOS ========== */
"+"             {lexeme = yytext(); return symbol(sym.Suma, yytext());}
"-"             {lexeme = yytext(); return symbol(sym.Resta, yytext());}
"*"             {lexeme = yytext(); return symbol(sym.Multiplicacion, yytext());}
"/"             {lexeme = yytext(); return symbol(sym.Division, yytext());}
"%"             {lexeme = yytext(); return symbol(sym.Modulo, yytext());}
"++"            {lexeme = yytext(); return symbol(sym.Incremento, yytext());}
"--"            {lexeme = yytext(); return symbol(sym.Decremento, yytext());}

/* ========== OPERADORES RELACIONALES ========== */
"=="            {lexeme = yytext(); return symbol(sym.IgualComparacion, yytext());}
"!="            {lexeme = yytext(); return symbol(sym.Diferente, yytext());}
"<="            {lexeme = yytext(); return symbol(sym.MenorIgual, yytext());}
">="            {lexeme = yytext(); return symbol(sym.MayorIgual, yytext());}
"<"             {lexeme = yytext(); return symbol(sym.Menor, yytext());}
">"             {lexeme = yytext(); return symbol(sym.Mayor, yytext());}

/* ========== OPERADORES LÓGICOS ========== */
"&&"            {lexeme = yytext(); return symbol(sym.And, yytext());}
"||"            {lexeme = yytext(); return symbol(sym.Or, yytext());}
"!"             {lexeme = yytext(); return symbol(sym.Not, yytext());}

/* ========== OPERADORES DE ASIGNACIÓN ========== */
"="             {lexeme = yytext(); return symbol(sym.Igual, yytext());}
"+="            {lexeme = yytext(); return symbol(sym.SumaAsignacion, yytext());}
"-="            {lexeme = yytext(); return symbol(sym.RestaAsignacion, yytext());}
"*="            {lexeme = yytext(); return symbol(sym.MultiplicacionAsignacion, yytext());}
"/="            {lexeme = yytext(); return symbol(sym.DivisionAsignacion, yytext());}

/* ========== DELIMITADORES ========== */
"("             {lexeme = yytext(); return symbol(sym.ParentesisAbre, yytext());}
")"             {lexeme = yytext(); return symbol(sym.ParentesisCierra, yytext());}
"{"             {lexeme = yytext(); return symbol(sym.LlaveAbre, yytext());}
"}"             {lexeme = yytext(); return symbol(sym.LlaveCierra, yytext());}
"["             {lexeme = yytext(); return symbol(sym.CorcheteAbre, yytext());}
"]"             {lexeme = yytext(); return symbol(sym.CorcheteCierra, yytext());}
";"             {lexeme = yytext(); return symbol(sym.PuntoyComa, yytext());}
","             {lexeme = yytext(); return symbol(sym.Coma, yytext());}
":"             {lexeme = yytext(); return symbol(sym.DosPuntos, yytext());}
"."             {lexeme = yytext(); return symbol(sym.Punto, yytext());}

/* ========== IDENTIFICADORES ========== */
{IDENTIFICADOR_MAYUS}  {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return symbol(sym.Identificador, yytext());
}

/* ========== NÚMEROS ========== */
{NUMERO_DECIMAL}       {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return symbol(sym.NumeroDecimal, yytext());
}

{NUMERO_ENTERO}        {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return symbol(sym.NumeroEntero, yytext());
}

/* ========== CADENAS ========== */
{CADENA}               {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return symbol(sym.Cadena, yytext());
}

/* ========== ESPACIOS EN BLANCO ========== */
{espacio}              {/* Ignorar espacios en blanco */}

/* ========== ERRORES ESPECÍFICOS ========== */
/* Identificadores que no empiezan con mayúscula */
[a-z]([a-zA-Z0-9])*    {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return symbol(sym.ErrorIdentificadorMinuscula, yytext());
}

/* Palabras reservadas en minúscula - errores específicos */
"vill"|"con"|"nad"|"gen"|"eje"|"capivara"|"inicio:"|"final"|"importar"|"clase"|"si"|"sino"|"mientras"|"para"|"hacer"|"retornar"|"leer"|"escribir"|"verdadero"|"falso" {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return symbol(sym.ErrorPalabraReservadaMin, yytext());
}

/* Números con formato incorrecto */
{D}+\.                 {lexeme = yytext(); return symbol(sym.ErrorNumeroIncompleto, yytext());}
\.{D}+                 {lexeme = yytext(); return symbol(sym.ErrorNumeroIncompleto, yytext());}

/* Cadenas no cerradas */
\"[^\"]*$              {lexeme = yytext(); return symbol(sym.ErrorCadenaNoCerrada, yytext());}

/* Caracteres no reconocidos */
.                      {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return symbol(sym.ERROR, yytext());
}