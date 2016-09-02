grammar Expr;

stat:   expr ';' ;

expr:   expr ('*'|'/') expr         // binary operator, precedence 8
    |   expr ('+'|'-') expr         // binary operator, precedence 7
    |   INT                         // primary
    |   '(' expr ')'                // primary
    ;

ID  :   [a-zA-Z]+ ;
INT :   [0-9]+ ;
WS  :   [ \t\n\r]+ -> skip ;
