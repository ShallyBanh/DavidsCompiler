grammar pablo;

expression: baseExpression EOF;

baseExpression: addSubtract;

addSubtract
 : multiplyDivide
 | addSubtract (Plus|Minus) multiplyDivide
 ;

multiplyDivide
 : primaryExpression
 | multiplyDivide (Multiply|Divide) primaryExpression
 ;

primaryExpression
 : number
 | Openbracket baseExpression Closebracket
 ;

number: Number;



Number: Digit+;
fragment Digit: [0-9];

Openbracket: '(';
Closebracket: ')';
Plus: '+';
Minus: '-';
Multiply: '*';
Divide: '/';
Whitespace: [ \n\t]+ -> skip;

