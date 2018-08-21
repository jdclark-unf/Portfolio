// Declare variables
var button;
var result;
var heads;
var tails;
var total;

//Declare and initialize tally
var headCount = 0;
var tailCount = 0;
var totalCount = 0;

// When page loads, execute start() function
window.addEventListener("load", start, false);

/* start() function initializes page
	params: none
	returns: nothing
*/
function start()
{
	button = document.getElementById("toss");
	result = document.getElementById("result");
	heads = document.getElementById("heads");
	tails = document.getElementById("tails");
	total = document.getElementById("total");

	button.addEventListener("click", update, false);
	result.innerHTML = "Press button to flip a coin";
	heads.innerHTML = headCount;
	tails.innerHTML = tailCount;
	total.innerHTML = totalCount;
} // end start()

/* update() function writes updated values to page elements
	params: none
	returns: nothing
*/
function update()
{
	if (flip())
	{
		result.innerHTML = "You toss a coin and it comes up HEADS";
		heads.innerHTML = ++headCount;
	}
	else 
	{
		result.innerHTML = "You toss a coin and it comes up TAILS";
		tails.innerHTML = ++tailCount;
	}
	
	total.innerHTML = ++totalCount;
} // end update()

/* flip() function simulates a coin toss
	params: none
	returns: boolean true for heads, boolean false for tails
*/
function flip()
{
	return (Math.floor(Math.random() * 2) == 0)
} // end flip()
