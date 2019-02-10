//define functions
console.log("classic");
var myfunction = function(input) {
	return input +2;
}

console.log(myfunction(5));

var myCoolFunction = input => input +2;

console.log("functional");
console.log(myCoolFunction(4));

//ramda first steps
var result = R.map(x => 2*x, [1,2,3,6]);
console.log(result);

console.log("classic");
var fieldInfos = new Array(9);
for (i = 0; i<9; i++) {
	let info = new FieldInfo(i+1, "val"+i);
	fieldInfos[i] = info;
}
console.log(fieldInfos);

console.log("ramda");
var fieldInfos2 = new Array(9);
R.map(myInt => fieldInfos2[myInt] = new FieldInfo(myInt + 1, "val" + myInt), R.range(0,9));
console.log(fieldInfos2);








function FieldInfo(fieldId, value) {
	this.fieldId = fieldId;
	this.value = value;
}