function Person(name) {
	this.name = name;
	this.myfunction = function() {return "hello" };
}
Person.prototype.printName = function() {
	console.log("hello");
};

function Man(name, age) {
	Person.call(this, name);
	this.age = age;
}
Man.prototype = new Person;
Man.prototype.constructor = Man;
Man.prototype.property = "property";

var man = new Man("man1",54);
man.printName();


console.log(man.__proto__);
console.log(Object.getPrototypeOf(man.__proto__));
console.log(Object.getPrototypeOf(man.__proto__.__proto__));
console.log(Object.getPrototypeOf(man.__proto__.__proto__.__proto__));
