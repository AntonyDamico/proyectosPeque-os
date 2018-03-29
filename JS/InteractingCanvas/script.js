console.log('hey')

var canvas = document.querySelector("canvas");

canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

var c = canvas.getContext('2d');

var mouse = {
	x: undefined,
	y: undefined,
}

var maxRadius = 40;
var minRadius = 2;

var colorArr = [
	"#2C3E50",
	"#E74C3C",
	"#ECF0F1",
	"#3498DB",
	"#2980B9",
];

	
window.addEventListener("mousemove", function(event){
	mouse.x = event.x;
	mouse.y = event.y;
	console.log(mouse);
});


//resize
window.addEventListener("resize", function(){
	canvas.width = window.innerWidth;
	canvas.height = window.innerHeight;

	init();
});


//Object
function Circle(x, y, dx, dy, r, bol){
	this.x = x;
	this.y = y;
	this.dx = dx;
	this.dy = dy;
	this.r = r;
	this.minRadius = r
	this.color = colorArr[Math.floor(Math.random() * colorArr.length)];

	this.draw = function(){
		c.beginPath();
		c.arc(this.x, this.y, this.r, 0, Math.PI * 2, false);
		// c.strokeStyle = 'blue';
		// c.stroke();
		c.fill();
		if(bol){
			c.fillStyle = this.color;
		}
	}

	this.update = function(){
		if(this.x + this.r > innerWidth || this.x - this.r < 0){
			this.dx = -this.dx;
		}

		if(this.y + this.r > innerHeight || this.y - this.r < 0 ){
			this.dy = -this.dy;
		}

		this.x += this.dx;
		this.y += this.dy;	

		//Ineractivity
		if(mouse.x - this.x < 50 && mouse.x - this.x > -50 && 
			mouse.y - this.y < 50 && mouse.y - this.y > -50){
			if(this.r < maxRadius){
				this.r += 2;
				this.dx = -this.dx
			}
		} else if(this.r > this.minRadius){
			this.r -= 1;
			this.dy = -this.dy;
		}


		this.draw();	
	}
}



var colorQuestion = true;
var numberOfCircles = 100;
var circleArray = [];


function init() {
	circleArray = [];

	for(var i = 0; i < numberOfCircles; i++){
		var r = Math.random() * 14 + 1;
		var x = Math.random() * (innerWidth - r * 2) + r;
		var y = Math.random() * (innerHeight - r * 2) + r;
		var dx = (Math.random() * - 0.5) * 10;
		var dy = (Math.random() * - 0.5) * 10;;

		circleArray.push(new Circle(x, y, dx, dy, r, colorQuestion));
	}
}




function animate(){
	//Loop for the animation
	requestAnimationFrame(animate);
	//Cleans the canvas each iteration xi, yi, xf, yf
	c.clearRect(0, 0, innerWidth, innerHeight);
	
	for(var i = 0; i < circleArray.length; i++){
		circleArray[i].update();
	}
}



animate();
init();


