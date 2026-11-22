package codigo;

import java_cup.runtime.Symbol;

%%

%class Lexer
%cup
%line
%column
%type java_cup.runtime.Symbol

// ===== Definición de patrones léxicos =====
L=[a-zA-Z_]
D=[0-9]
espacio=[ \t\r\n]+
saltoLinea=\r|\n|\r\n

// Patrones específicos
IDENTIFICADOR_MAYUS=[A-Z]({L}|{D})*
NUMERO_ENTERO={D}+
NUMERO_DECIMAL={D}+\.{D}+
CADENA=\"([^\\\"]|\\.)*\"

%{
    public String lexeme;

    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1, yytext());
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}

%%

/* ========== COMENTARIOS ========== */
"//".*               { /* Ignorar comentario de línea */ }
"/*"([^*]|"*"[^/])*"*/" { /* Ignorar comentario de bloque */ }

/* ========== PALABRAS RESERVADAS PRINCIPALES ========== */
"Vill"          { return symbol(sym.TipoVariable); }
"Con"           { return symbol(sym.TipoConstante); }
"Nad"           { return symbol(sym.TipoNulo); }
"Gen"           { return symbol(sym.TipoGenerico); }
"Eje"           { return symbol(sym.Ejecutar); }
"Capivara"      { return symbol(sym.FuncionPrincipal); }
"Importar"      { return symbol(sym.Importar); }
"Clase"         { return symbol(sym.Clase); }

/* ========== ESTRUCTURA DEL PROGRAMA ========== */
"INICIO:"       { return symbol(sym.InicioPrograma); }
"FINAL"         { return symbol(sym.FinPrograma); }

/* ========== ESTRUCTURAS DE CONTROL ========== */
"Si"            { return symbol(sym.If); }
"Sino"          { return symbol(sym.Else); }
"Mientras"      { return symbol(sym.While); }
"Para"          { return symbol(sym.For); }
"Hacer"         { return symbol(sym.DefFuncion); }
"Retornar"      { return symbol(sym.Return); }

/* ========== ENTRADA/SALIDA ========== */
"Leer"          { return symbol(sym.Input); }
"Escribir"      { return symbol(sym.Output); }

/* ========== VALORES BOOLEANOS ========== */
"Verdadero"     { return symbol(sym.BoolTrue); }
"Falso"         { return symbol(sym.BoolFalse); }

/* ========== OPERADORES ARITMÉTICOS ========== */
"+"             { return symbol(sym.Suma); }
"-"             { return symbol(sym.Resta); }
"*"             { return symbol(sym.Multiplicacion); }
"/"             { return symbol(sym.Division); }
"%"             { return symbol(sym.Modulo); }
"++"            { return symbol(sym.Incremento); }
"--"            { return symbol(sym.Decremento); }

/* ========== OPERADORES RELACIONALES ========== */
"=="            { return symbol(sym.IgualComparacion); }
"!="            { return symbol(sym.Diferente); }
"<="            { return symbol(sym.MenorIgual); }
">="            { return symbol(sym.MayorIgual); }
"<"             { return symbol(sym.Menor); }
">"             { return symbol(sym.Mayor); }

/* ========== OPERADORES LÓGICOS ========== */
"&&"            { return symbol(sym.And); }
"||"            { return symbol(sym.Or); }
"!"             { return symbol(sym.Not); }

/* ========== OPERADORES DE ASIGNACIÓN ========== */
"="             { return symbol(sym.Igual); }
"+="            { return symbol(sym.SumaAsignacion); }
"-="            { return symbol(sym.RestaAsignacion); }
"*="            { return symbol(sym.MultiplicacionAsignacion); }
"/="            { return symbol(sym.DivisionAsignacion); }

/* ========== DELIMITADORES ========== */
"("             { return symbol(sym.ParentesisAbre); }
")"             { return symbol(sym.ParentesisCierra); }
"{"             { return symbol(sym.LlaveAbre); }
"}"             { return symbol(sym.LlaveCierra); }
"["             { return symbol(sym.CorcheteAbre); }
"]"             { return symbol(sym.CorcheteCierra); }
";"             { return symbol(sym.PuntoyComa); }
","             { return symbol(sym.Coma); }
":"             { return symbol(sym.DosPuntos); }
"."             { return symbol(sym.Punto); }

/* ========== IDENTIFICADORES ========== */
{IDENTIFICADOR_MAYUS} {
    return symbol(sym.Identificador, yytext());
}

/* ========== NÚMEROS ========== */
{NUMERO_DECIMAL} { return symbol(sym.NumeroDecimal, yytext()); }
{NUMERO_ENTERO}  { return symbol(sym.NumeroEntero, yytext()); }

/* ========== CADENAS ========== */
{CADENA} { return symbol(sym.Cadena, yytext()); }

/* ========== ESPACIOS EN BLANCO ========== */
{espacio} { /* Ignorar */ }

/* ========== ERRORES ESPECÍFICOS ========== */
[a-z]({L}|{D})* { return symbol(sym.ErrorIdentificadorMinuscula, yytext()); }

"vill" | "con" | "nad" | "gen" | "eje" | "capivara" | "inicio:" | "final" | "importar" | "clase"
    { return symbol(sym.ErrorPalabraReservadaMin, yytext()); }

{D}+\.  { return symbol(sym.ErrorNumeroIncompleto, yytext()); }
\.{D}+  { return symbol(sym.ErrorNumeroIncompleto, yytext()); }

\"[^\"]*$ { return symbol(sym.ErrorCadenaNoCerrada, yytext()); }

/* ========== CARACTERES NO RECONOCIDOS ========== */
. { return symbol(sym.ERROR, yytext()); }