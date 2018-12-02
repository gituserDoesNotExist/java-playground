var displayedImage = document.querySelector('.displayed-img');
var thumbBar = document.querySelector('.thumb-bar');

btn = document.querySelector('button');
var overlay = document.querySelector('.overlay');

/* Looping through images */
var imageNames = ["pic1.jpg","pic2.jpg","pic3.jpg","pic4.jpg","pic5.jpg"];
var baseFolder = "images/";
var fullPath = "";
for(var i = 0; i < 5; i++) {
	var newImage = document.createElement("img");
	fullPath = baseFolder.concat(imageNames[i]);
	console.log(fullPath);
	newImage.setAttribute("src", fullPath);	
	thumbBar.appendChild(newImage);
	newImage.addEventListener("click", handleEvent, false);
	newImage.addEven
}

function handleEvent(e) {
	var attributeValue = e.target.getAttribute("src");
	displayedImage.setAttribute("src", attributeValue)
}

btn.addEventListener("click", function(e) {
	if (btn.getAttribute("class") == "dark") {
		btn.setAttribute("class","light");
		btn.textContent = "Lighten";
		overlay.style.backgroundColor = "rgba(0,0,0,0.5)";
	} else if (btn.getAttribute("class") == "light") {
		btn.setAttribute("class", "dark");
		btn.textContent = "Darken";
		overlay.style.backgroundColor = "rgba(0,0,0,0)";
	}
}, false)



/* Wiring up the Darken/Lighten button */

