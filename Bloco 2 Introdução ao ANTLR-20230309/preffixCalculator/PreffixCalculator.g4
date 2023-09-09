grammar PreffixCalculator;
program: stat * EOF;  //Zero ou more repetitions of stat;
stat: expr? NEWLINE;  //Optative expr follwed by an end_of_line;
expr:  op = ('*'| '/'|'+'|'-') expr expr  #ExprPreffix
	| Number			#ExprNumber
	;
Number:	[0-9]+('.'[0-9]+)?; //fixed point real number
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
