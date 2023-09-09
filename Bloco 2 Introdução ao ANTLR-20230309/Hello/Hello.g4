grammar Hello; //Define a grammar called Hello
greetings : (('hello' ID+) | ('bye' ID+))+;	//match keyword hello followed by an identifier(('hello'|'bye') ID)+;
ID : [a-zA-Z]+ ;  //match lower-case identifiers
WS : [ \t\r\n]+ -> skip;	//skip spaces, tabs, newlines, \r (windows)

