package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
%line
%column

// Definición de patrones léxicos
L=[a-zA-Z_]
D=[0-9]
espacio=[ \t\r\n]+
saltoLinea=\r|\n|\r\n
ID = [a-zA-Z_][a-zA-Z0-9_]*
NUMERO_ENTERO={D}+
NUMERO_DECIMAL={D}+\.{D}+
CADENA=\"([^\\\"]|\\.)*\"


// Variables auxiliares
%{
    public String lexeme;
    public int line;
    public int column;
    
    public String getPosition() {
        return "Línea: " + (yyline + 1) + ", Columna: " + (yycolumn + 1);
    }
%}

%%

/* ========== COMENTARIOS ========== */
"//".*                           {/* Ignorar comentarios de línea */}
"/*"([^*]|"*"[^/])*"*/"          {/* Ignorar comentarios de bloque */}

/* ========== PALABRAS RESERVADAS ========== */
"private"                {lexeme = yytext(); return Private;}
"int"                    {lexeme = yytext(); return Int;}
"if"                     {lexeme = yytext(); return If;}
"return"                 {lexeme = yytext(); return Return;}
"getStickCollisionZone"  {lexeme = yytext(); return GetStickCollisionZone;}

/* ========== ERRORES ESPECÍFICOS ========== */
"Capivara"   {lexeme = yytext(); line = yyline+1; column = yycolumn+1; return ErrorCapivara;}
"Mata"       {lexeme = yytext(); line = yyline+1; column = yycolumn+1; return ErrorMata;}
"ApocoSi"    {lexeme = yytext(); line = yyline+1; column = yycolumn+1; return ErrorApocoSi;}
"Moi"        {lexeme = yytext(); line = yyline+1; column = yycolumn+1; return ErrorMoi;}
"Clash"      {lexeme = yytext(); line = yyline+1; column = yycolumn+1; return ErrorClash;}

/* ========== SÍMBOLOS ========== */
"."        {lexeme = yytext(); return Punto;}
";"        {lexeme = yytext(); return PuntoYcoma;}
"@"        {lexeme = yytext(); return arroba;}
","        {lexeme = yytext(); return Coma;}
"("        {lexeme = yytext(); return ParentesisAbre;}
")"        {lexeme = yytext(); return ParentesisCierra;}
"&&"       {lexeme = yytext(); return Igriega;}
"{"        {lexeme = yytext(); return LlaveAbre;}
"}"        {lexeme = yytext(); return LlaveCierra;}

/* ========== NÚMEROS ========== */
{NUMERO_DECIMAL} {
    lexeme = yytext();
    line = yyline + 1;
    column = yycolumn + 1;
    return NumeroDecimal;
}

{NUMERO_ENTERO} {
    lexeme = yytext();
    line = yyline + 1;
    column = yycolumn + 1;
    return NumeroEntero;
}

/* ========== IDENTIFICADORES Y CADENAS ========== */
{CADENA} {
    lexeme = yytext();
    line = yyline + 1;
    column = yycolumn + 1;
    return Cadena;
}

{ID} {
    lexeme = yytext();
    line = yyline + 1;
    column = yycolumn + 1;
    return Identificador;
}

/* ========== ESPACIOS EN BLANCO ========== */
{espacio} {/* Ignorar */}

/* ========== ERRORES Y CARACTERES NO RECONOCIDOS ========== */
. {
    lexeme = yytext();
    line = yyline + 1;
    column = yycolumn + 1;
    return ERROR;
}

