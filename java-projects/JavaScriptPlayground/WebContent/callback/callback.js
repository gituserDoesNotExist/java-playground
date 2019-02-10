"use strict";

function callbackFunction(name) {
	console.log("I am a callback function with name " + name);
}

function mainFunction(callback) {
	let myvar = 2;
	console.log("I am the main function");
	callback(myvar);
}

mainFunction(callbackFunction);
console.log(myvar);