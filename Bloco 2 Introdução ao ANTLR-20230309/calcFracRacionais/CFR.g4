grammar CFR;
program:
	stat* EOF;

stat: 
	  assignment 		#StatAssignment
        | print 		#StatPrint
//	| NEWLINE		#StatNone
	;
assignment:  expr '->' ID';';
print: 'print' expr';' ;

expr:
	  op = ('+' | '-') expr            #ExprUnario
	| expr op = ('*' | ':' | '%') expr #ExprMultDivMod
	| expr op = ('+' | '-') expr 	   #ExprAddSub
	| expr op = '^' expr		   #ExprPow
	| ID				   #ExprId
	| Number 			   #ExprNumb
	| Fraction                         #ExprFraction
	| '(' expr ')' 			   #ExprParent
       // | 'read' '"'ID'"'		   #ExprRead
	| 'reduce' expr			   #ExprReduce
	;

Fraction: Number '/' Number;  //Ver isso aqui  
ID: [a-zA-Z_]+;
Number: [0-9]+;
//IDN: [a-zA-Z_0-9]+; 
//NEWLINE: '\r'? '\n';
WS: [ \t\r\n]+ -> skip;
COMENT: '//' .*? '\n' -> skip;
