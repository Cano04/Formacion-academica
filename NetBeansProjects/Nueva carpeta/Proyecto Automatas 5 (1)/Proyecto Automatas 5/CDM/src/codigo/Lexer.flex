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
"Vill"          {lexeme = yytext(); return TipoVariable;}
"Con"           {lexeme = yytext(); return TipoConstante;}
"Nad"           {lexeme = yytext(); return TipoNulo;}
"Gen"           {lexeme = yytext(); return TipoGenerico;}
"Eje"           {lexeme = yytext(); return Ejecutar;}
"Capivara"      {lexeme = yytext(); return FuncionPrincipal;}
"Importar"      {lexeme = yytext(); return Importar;}
"Clase"      {lexeme = yytext(); return Clase;}
"Cano"        {lexeme = yytext(); return FuncionPrincipal;}
"Negro"         {lexeme = yytext(); return FuncionPrincipal;}

/* ========== ESTRUCTURA DEL PROGRAMA ========== */
"INICIO:"       {lexeme = yytext(); return InicioPrograma;}
"FINAL"         {lexeme = yytext(); return FinPrograma;}

/* ========== ESTRUCTURAS DE CONTROL ========== */
"Si"            {lexeme = yytext(); return If;}
"Sino"          {lexeme = yytext(); return Else;}
"Mientras"      {lexeme = yytext(); return While;}
"Para"          {lexeme = yytext(); return For;}
"Hacer"         {lexeme = yytext(); return DefFuncion;}
"Retornar"      {lexeme = yytext(); return Return;}

/* ========== ENTRADA/SALIDA ========== */
"Leer"          {lexeme = yytext(); return Input;}
"Escribir"      {lexeme = yytext(); return Output;}

/* ========== VALORES BOOLEANOS ========== */
"Verdadero"     {lexeme = yytext(); return BoolTrue;}
"Falso"         {lexeme = yytext(); return BoolFalse;}

/* ========== OPERADORES ARITMÉTICOS ========== */
"+"             {lexeme = yytext(); return Suma;}
"-"             {lexeme = yytext(); return Resta;}
"*"             {lexeme = yytext(); return Multiplicacion;}
"/"             {lexeme = yytext(); return Division;}
"%"             {lexeme = yytext(); return Modulo;}
"++"            {lexeme = yytext(); return Incremento;}
"--"            {lexeme = yytext(); return Decremento;}

/* ========== OPERADORES RELACIONALES ========== */
"=="            {lexeme = yytext(); return IgualComparacion;}
"!="            {lexeme = yytext(); return Diferente;}
"<="            {lexeme = yytext(); return MenorIgual;}
">="            {lexeme = yytext(); return MayorIgual;}
"<"             {lexeme = yytext(); return Menor;}
">"             {lexeme = yytext(); return Mayor;}

/* ========== OPERADORES LÓGICOS ========== */
"&&"            {lexeme = yytext(); return And;}
"||"            {lexeme = yytext(); return Or;}
"!"             {lexeme = yytext(); return Not;}

/* ========== OPERADORES DE ASIGNACIÓN ========== */
"="             {lexeme = yytext(); return Igual;}
"+="            {lexeme = yytext(); return SumaAsignacion;}
"-="            {lexeme = yytext(); return RestaAsignacion;}
"*="            {lexeme = yytext(); return MultiplicacionAsignacion;}
"/="            {lexeme = yytext(); return DivisionAsignacion;}

/* ========== DELIMITADORES ========== */
"("             {lexeme = yytext(); return ParentesisAbre;}
")"             {lexeme = yytext(); return ParentesisCierra;}
"{"             {lexeme = yytext(); return LlaveAbre;}
"}"             {lexeme = yytext(); return LlaveCierra;}
"["             {lexeme = yytext(); return CorcheteAbre;}
"]"             {lexeme = yytext(); return CorcheteCierra;}
";"             {lexeme = yytext(); return PuntoyComa;}
","             {lexeme = yytext(); return Coma;}
":"             {lexeme = yytext(); return DosPuntos;}
"."             {lexeme = yytext(); return Punto;}

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
"vill"                 {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"con"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"nad"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"gen"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"eje"                  {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"capivara"             {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"inicio:"              {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"final"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"importar"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}
"clase"                {lexeme = yytext(); return ErrorPalabraReservadaMin;}

/* Números con formato incorrecto */
{D}+\.                 {lexeme = yytext(); return ErrorNumeroIncompleto;}
\.{D}+                 {lexeme = yytext(); return ErrorNumeroIncompleto;}

/* Cadenas no cerradas */
\"[^\"]*$              {lexeme = yytext(); return ErrorCadenaNoCerrada;}

/* Caracteres no reconocidos */
.                      {
    lexeme = yytext(); 
    line = yyline + 1;
    column = yycolumn + 1;
    return ERROR;
}
