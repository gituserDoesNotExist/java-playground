var count = 0;
const KEYS = {
	LEFT : 37,
	UP : 38,
	RIGHT : 39,
	DOWN : 40
};

var canvas = document.querySelector('canvas');
var ctx = canvas.getContext('2d');
const pElement = document.querySelector('p');


var width = canvas.width = window.innerWidth;
var height = canvas.height = window.innerHeight;



// function to generate random number

function random(min, max) {
	var num = Math.floor(Math.random() * (max - min)) + min;
	return num;
}



function Shape(x, y, velX, velY) {
	this.x = x;
	this.y = y;
	this.velX = velX;
	this.velY = velY;
}

function Ball(x, y, velX, velY, color, size) {
	Shape.call(this, x, y, velX, velY);
	this.color = color;
	this.size = size;
	this.exists = true;
}
Ball.prototype = Object.create(Shape.prototype);
Ball.prototype.constructor = Ball;

Ball.prototype.draw = drawBall;
Ball.prototype.update = updateBall
Ball.prototype.collisionDetect = collisionDetect;


function EvilCircle(x, y) {
	Shape.call(this, x, y, 20, 20);
	this.color = 'white';
	this.size = 10;
}
EvilCircle.prototype = Object.create(Shape.prototype);
EvilCircle.prototype.constructor = EvilCircle;

EvilCircle.prototype.draw = function() {
	ctx.beginPath();
	ctx.lineWidth = 3;
	ctx.strokeStyle = this.color;
	ctx.arc(this.x, this.y, this.size, 0, 2 * Math.PI);
	ctx.stroke();
}
EvilCircle.prototype.checkBounds = function() {
	if ((this.x - this.size) < 0) {
		this.x = width - this.size;
	}
	if ((this.x + this.size) > width) {
		this.x = this.size;
	}
	if ((this.y - this.size) < 0) {
		this.y = height - this.size;
	}
	if ((this.y + this.size) > height) {
		this.y = this.size;
	}
}
EvilCircle.prototype.controlCircle = function(eventObject) {
	switch (eventObject.keyCode) {
	case KEYS.LEFT:
		this.x -= this.velX;
		break;
	case KEYS.UP:
		this.y -= this.velY;
		break;
	case KEYS.RIGHT:
		this.x += this.velX;
		break;
	case KEYS.DOWN:
		this.y += this.velY;
		break;
	default:
		console.log("hit it");
		break;
	}
}
EvilCircle.prototype.collisionDetect = function(ball) {
	if (ball.exists) {
		const dx = this.x - ball.x;
		const dy = this.y - ball.y;
		const dist = Math.sqrt(dx * dx + dy * dy);
		if (dist <= (this.size + ball.size)) {
			count++;
			ball.exists = false;
			pElement.innerHTML = "Ball count: " + count;
		}
	}
}


const evilCircle = new EvilCircle(random(0, width), random(0, height), true);

window.addEventListener('keydown', function(e) {
	evilCircle.controlCircle(e);
	evilCircle.checkBounds();

}, false);

console.log(evilCircle);
var balls = [];
pElement.innerHTML = "Ball count: " + count;
function loop() {
	ctx.fillStyle = 'rgba(0, 0, 0, 0.25)';
	ctx.fillRect(0, 0, width, height);

	while (balls.length < 25) {
		var ball = new Ball(
			random(0, width),
			random(0, height),
			random(-7, 7),
			random(-7, 7),
			'rgb(' + random(0, 255) + ',' + random(0, 255) + ',' + random(0, 255) + ')',
			random(10, 20)
		);
		balls.push(ball);
	}

	for (var i = 0; i < balls.length; i++) {
		if (balls[i].exists) {
			balls[i].update() ;
			balls[i].collisionDetect();
			balls[i].draw();
			evilCircle.collisionDetect(balls[i]);
		}
	}

	evilCircle.draw();

	requestAnimationFrame(loop);

}

loop();


//this function tells the ball to draw itself on the screen
//the context is like the paper and one commands the pen to draw sth on it
function drawBall() {
	//begin to draw a shape on the paper
	ctx.beginPath();
	//color of the shape which will be drawn
	ctx.fillStyle = this.color;
	//arc(x-center,y-center,radius,start-degree,end-degree)
	//using 0,2*Math.PI will result in a circle
	ctx.arc(this.x, this.y, this.size, 0, 2 * Math.PI);
	//finish everything
	ctx.fill();
}

function updateBall() {
	if ((this.x + this.size) >= width) {
		this.velX = -this.velX;
	}
	if ((this.x - this.size) <= 0) {
		this.velX = -this.velX;
	}
	if ((this.y + this.size) >= height) {
		this.velY = -(this.velY);
	}

	if ((this.y - this.size) <= 0) {
		this.velY = -(this.velY);
	}

	this.x += this.velX;
	this.y += this.velY;
}

function collisionDetect() {
	for (var j = 0; j < balls.length; j++) {
		if (!(this === balls[j])) {
			var dx = this.x - balls[j].x;
			var dy = this.y - balls[j].y;
			var distance = Math.sqrt(dx * dx + dy * dy);

			if (distance < this.size + balls[j].size) {
				balls[j].color = 'rgb(' + random(0, 255) + ',' + random(0, 255) + ',' + random(0, 255) + ')';
				this.color = 'rgb(' + random(0, 255) + ',' + random(0, 255) + ',' + random(0, 255) + ')';
			}
		}
	}
}