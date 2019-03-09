function myfun(x,y) {
	console.log("the sum is :" + (x+y));
}

myfun(5,43);

myfun2 = (x,y) => console.log("the sum is2 :" + (x+y));

myfun2(5,4);


var result = R.map(x=>x+1,[1,2,3]);

console.log(result);