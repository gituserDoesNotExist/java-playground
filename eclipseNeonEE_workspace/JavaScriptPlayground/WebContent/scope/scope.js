var globalVar = 2;

(function myFunction() {
    var globalVarInFunction = 5;
    globalVarInFunctionNotDeclared = 10;
	console.log("value of globalVar in function: " + globalVar);
})();

console.log("value of globalVar outside function: " + globalVar);
console.log("value of globalVarInFunctionNotDeclared outside function: " + globalVarInFunctionNotDeclared);
console.log("value of globalVarInFunction outside function: " + globalVarInFunction);