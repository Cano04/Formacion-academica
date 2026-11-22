%class Lexer
%unicode
%cup
%line
%column

// Expresiones regulares reutilizables
DIGITO = [0-9]
LETRA = [a-zA-Z_]
ID = {LETRA}({LETRA}|{DIGITO})*
NUM = {DIGITO}+

ESPACIOS = [ \t\r\n]+

%{

// Aquí puedes importar tu enum Token
// import sym;

%}

%%

// Ignorar espacios y saltos de línea
{ESPACIOS}   { /* ignorar */ }

// Palabras reservadas SQL
"DELIMITER"        { return symbol(sym.DELIMITER); }
"CREATE"           { return symbol(sym.CREATE); }
"PROCEDURE"        { return symbol(sym.PROCEDURE); }
"IN"               { return symbol(sym.IN); }
"OUT"              { return symbol(sym.OUT); }
"BEGIN"            { return symbol(sym.BEGIN); }
"END"              { return symbol(sym.END); }
"SELECT"           { return symbol(sym.SELECT); }
"SUM"              { return symbol(sym.SUM); }
"INTO"             { return symbol(sym.INTO); }
"FROM"             { return symbol(sym.FROM); }
"WHERE"            { return symbol(sym.WHERE); }
"CALL"             { return symbol(sym.CALL); }

// Símbolos
"("                { return symbol(sym.LPAREN); }
")"                { return symbol(sym.RPAREN); }
","                { return symbol(sym.COMA); }
";"                { return symbol(sym.PCOMA); }
"//"               { return symbol(sym.DOBLESLASH); }
"@"                { return symbol(sym.ARROBA); }

// Identificadores
{ID}               { return symbol(sym.ID, yytext()); }

// Cadenas (entre comillas dobles)
\"([^\"\\]|\\.)*\" { return symbol(sym.STRING, yytext()); }

// Números
{NUM}              { return symbol(sym.NUM, yytext()); }

// Cualquier otro caracter no reconocido
.                  { System.err.println("Caracter no reconocido: " + yytext()); }
