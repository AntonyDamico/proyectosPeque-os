console.log('hey')

var canvas = document.querySelector("canvas");

canvas.width = window.innerWidth;
canvas.height = window.innerHeight - 25;

var c = canvas.getContext('2d');

function Circle(x, y, r, dx, dy){
	this.r = r;
	this.x = x;
	this.y = y;
	this.dx = dx;
	this.dy = dy;

	

	this.draw = function(){
		c.beginPath();
		c.arc(this.x, this.y, this.r, 0, Math.PI * 2, false);
		c.stroke();
		c.fillStyle = "black";
		c.fill();
	}

	this.update = function(){
		if(this.y + this.r > canvas.height){
			this.dy = -this.dy * friction; 
			this.dx = this.dx * friction;
		} else {
			this.dy += g;
		}

		if(this.x + this.r > canvas.width || this.x - this.r < 0){
			this.dx = -this.dx;
		} 


		this.x += this.dx
		this.y += this.dy;
		
		console.log(this.dy);

		this.draw();
	}

	this.randomColor = function(){
		if(this.y + this.r > canvas.height){
			var r = Math.floor(Math.random() * 255);
			var g = Math.floor(Math.random() * 255);
			var b = Math.floor(Math.random() * 255);
			var color = "rgb(" + r + ", " + g + ", " + b + ")";
			console.log(color);
			return color;
		}
	}
} 

r = 30;
var x = innerWidth / 2;
var y = -100;

var g = 1;
var friction = 0.95; 


var ball = new Circle(x,  y, r, 10, 5);
var cont = 0;

function animate(){
	//Loop for the animation
	requestAnimationFrame(animate);
	//Cleans the canvas each iteration xi, yi, xf, yf
	c.clearRect(0, 0, innerWidth, innerHeight);
	
	ball.update();
}

animate();