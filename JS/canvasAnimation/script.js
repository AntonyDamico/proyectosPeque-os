console.log('hey')

var canvas = document.querySelector("canvas");

canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

var c = canvas.getContext('2d');

//Circle

// var x = Math.random() * (innerWidth);
// var y = Math.random() * (innerHeight);
// var dx = (Math.random() * - 0.5) * 20;
// var dy = (Math.random() * - 0.5) * 20;;
// var r = 30;


// function animate(){
// 	//Loop for the animation
// 	requestAnimationFrame(animate);
// 	//Cleans the canvas each iteration xi, yi, xf, yf
// 	c.clearRect(0, 0, innerWidth, innerHeight);

// 	c.beginPath();
// 	c.arc(x, y, r, 0, Math.PI * 2, false);
// 	c.strokeStyle = 'blue';
// 	c.stroke();

// 	if(x + r > innerWidth || x - r < 0){
// 		dx = -dx;
// 	}

// 	if(y + r > innerHeight || y - r < 0 ){
// 		dy = -dy;
// 	}

// 	x += dx;
// 	y += dy;
// }

// animate();


//Object
function Circle(x, y, dx, dy, r, bol){
	this.x = x;
	this.y = y;
	this.dx = dx;
	this.dy = dy;
	this.r = r;

	this.draw = function(){
		c.beginPath();
		c.arc(this.x, this.y, this.r, 0, Math.PI * 2, false);
		// c.strokeStyle = 'blue';
		c.stroke();
		c.fill();
		if(bol){
			c.fillStyle = this.randomColor();
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

		this.draw();	
	}

	this.randomColor = function(){
		if(this.x + this.r > innerWidth || this.x - this.r < 0 || 
			this.y + this.r > innerHeight || this.y - this.r < 0 ){

			var r = Math.floor(Math.random() * 255);
			var g = Math.floor(Math.random() * 255);
			var b = Math.floor(Math.random() * 255);
			var color = "rgb(" + r + ", " + g + ", " + b + ")";
			console.log(color);
			return color;
			
		}
	}
}



var colorQuestion = true;
var numberOfCircles = prompt("How many balls would you like?");
var circleArray = [];

for(var i = 0; i < numberOfCircles; i++){
	var r = Math.random() * 15;
	var x = Math.random() * (innerWidth - r * 2) + r;
	var y = Math.random() * (innerHeight - r * 2) + r;
	var dx = (Math.random() * - 0.5) * 20;
	var dy = (Math.random() * - 0.5) * 20;;

	circleArray.push(new Circle(x, y, dx, dy, r, colorQuestion));
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


