grammar VarCalculator;
program:
	stat* EOF;

stat: 
	  assignment NEWLINE	#StatAssignment
        | expr NEWLINE		#StatExpr
	| NEWLINE		#StatNone
	;

assignment:  ID '=' expr;
expr:
	  op = ('+' | '-') expr            #ExprUnario
	| expr op = ('*' | ':' | '%') expr #ExprMultDivMod
	| expr op = ('+' | '-') expr 	   #ExprAddSub
	| ID				   #ExprId
	| Number 			   #ExprNumb
	| '(' expr ')' 			   #ExprParent
	;

ID: [a-zA-Z_]+;
Number: [0-9]+; 
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMENT: '#' .*? '\n' -> skip;
