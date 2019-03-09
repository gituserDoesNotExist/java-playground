function test() {
	for (var i = 0; i < 10; i++) {
		if(i===5) {
			return;
		}
		console.log(i);
	}
};

test();