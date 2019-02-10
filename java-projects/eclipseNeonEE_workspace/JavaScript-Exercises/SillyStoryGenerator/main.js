var customName = document.getElementById("customname");
var button = document.getElementsByClassName("randomize")[0];
var story = document.getElementsByClassName("story")[0];

button.addEventListener("click", result, false);


function randomValueFromArray(array) {
	return array[1]
};

var storyText = "It was 94 farenheit outside, so :insertx: went for a walk. When they got to :inserty:, they stared in horror for a few moments, then :insertz:. Bob saw the whole thing, but he was not surprised — :insertx: weighs 300 pounds, and it was a hot day.";

var insertX = ["Willy the Goblin", "Big Daddy", "Father Christmas" ];
var insertY = ["the soup kitchen", "Disneyland", "the White House" ];
var insertZ = ["spontaneously combusted", "melted into a puddle on the sidewalk", "turned into a slug and crawled away" ];



function lbToStone(weight) {
	return lb/14;
}
function fahrenheitToCelsius(temperatureFH) {
	return (temperatureFH-32)/1.8;
}

function result() {
	var newStory = storyText;
	
	var test ="bob ist dick";
	if (customName.value != "") {
		newStory = newStory.replace("Bob",customName.value);
	}
	

	if(document.getElementById("uk").checked) {
		  var weight = Math.round(32) + "stone";
		  var temperature =  Math.round(33) + "centigrade";
		  newStory = newStory.replace("300 pounds", weight);
		  newStory = newStory.replace("94 fahrenheit", temperature);
	}
	
	
	var xItem = randomValueFromArray(insertX);
	var yItem = randomValueFromArray(insertY);
	var zItem = randomValueFromArray(insertZ);
	
	newStory = newStory.replace(/:insertx:/g, xItem);//replace all occurences
	newStory = newStory.replace(":inserty:", yItem);
	newStory = newStory.replace(":insertz:", zItem);

	story.textContent = newStory;
	story.style.visibility = 'visible';
}






