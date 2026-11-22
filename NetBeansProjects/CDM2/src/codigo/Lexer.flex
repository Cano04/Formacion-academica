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

// Patrones específicos del lenguaje Capivara
IDENTIFICADOR_MAYUS=[A-Z]([a-zA-Z0-9])*
NUMERO_ENTERO={D}+
NUMERO_DECIMAL={D}+\.{D}+
CADENA=\"([^\\\"]|\\.)*\"

%{
    public String lexeme;
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
"VILL"          {lexeme = yytext(); return Creacion;}
"CON"           {lexeme = yytext(); return Procedimiento;}
"NAD"           {lexeme = yytext(); return En;}
"GEN"           {lexeme = yytext(); return Varchar;}
"EJE"           {lexeme = yytext(); return Sobre;}
"CAPIVARA"      {lexeme = yytext(); return Dentro;}
"INICIO"      {lexeme = yytext(); return Begin;}
"FINAL"      {lexeme = yytext(); return Seleccion;}  
"SI"      {lexeme = yytext(); return Dentro;}  
"SINO"      {lexeme = yytext(); return Desde;}  
"MIENTRAS"      {lexeme = yytext(); return Donde;}  
"HACER"      {lexeme = yytext(); return And;}  
"RETORNAR"      {lexeme = yytext(); return Final;}  
"LEER"      {lexeme = yytext(); return llamda;}  
"ESCRIBIR" {lexeme = yytext(); return ejercicio1;}  
"ESCRIBIR" {lexeme = yytext(); return ejercicio1;}
"ESCRIBIR" {lexeme = yytext(); return ejercicio1;}
"ESCRIBIR" {lexeme = yytext(); return ejercicio1;}
"ESCRIBIR" {lexeme = yytext(); return ejercicio1;}


/* ========== ESTRUCTURA DEL PROGRAMA ========== */
"DELIMITER //"       {lexeme = yytext(); return DelimitadorPrincipal;}
"DELIMITER;"         {lexeme = yytext(); return DelimitadorFinal;}
"."             {lexeme = yytext(); return Punto;}
";"             {lexeme = yytext(); return PuntoYcoma;}
"@"             {lexeme = yytext(); return arroba;}
","             {lexeme = yytext(); return Coma;}
"("             {lexeme = yytext(); return ParentesisAbre;}
")"             {lexeme = yytext(); return ParentesisCierra;}


/* ========== IDENTIFICADORES ========== */
{IDENTIFICADOR_MAYUS}  {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return Identificador;
}

/* ========== NÚMEROS ========== */
{NUMERO_DECIMAL}       {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return NumeroDecimal;
}

{NUMERO_ENTERO}        {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return NumeroEntero;
}

/* ========== CADENAS ========== */
{CADENA}               {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return Cadena;
}

/* ========== ESPACIOS EN BLANCO ========== */
{espacio}              {/* Ignorar espacios en blanco */}

/* ========== ERRORES ESPECÍFICOS ========== */
/* Identificadores que no empiezan con mayúscula */
[a-z]([a-zA-Z0-9])*    {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return ErrorIdentificadorMinuscula;
}

/* Palabras reservadas en minúscula - errores específicos */
"create"                 {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"procedure"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"varchar"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"in"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"out"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"int"             {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"begin"              {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"into"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"from"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"where"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"and"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"select"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"call"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"delimiter //"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"delimiter:"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}

/* Caracteres no reconocidos */
.                      {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return ERROR;
}
