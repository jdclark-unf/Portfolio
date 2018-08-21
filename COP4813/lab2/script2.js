// Initialize variables
var output1;	// First digit of encrypted output
var output2;	// Second digit of encrypted output
var output3;	// Third digit of encrypted output
var output4;	// Fourth digit of encrypted output
var input;		// Data entered by user
var number;		// Number extracted from user input

// Get user input
input = window.prompt("Please enter a four-digit number");

/* Buggy validation code removed :< */

// Data has to be parsed once to convert user input from string to integer values
number = parseInt(input);

// Data has to be parsed again to get from floating point to integer values 
output1 = parseInt(((number / 1000) + 7) % 10); 					// Encrypt thousands digit
output2 = parseInt((((number % 1000) / 100) + 7) % 10);			// Encrypt hundreds digit
output3 = parseInt(((((number % 1000) % 100) / 10) + 7) % 10);	// Encrypt tens digit
output4 = parseInt(((((number % 1000) % 100) % 10) + 7) % 10);	// Encrypt ones digit

// Write output
document.writeln("<p>The code is <strong>" + output3 + output4 + output1 + output2 + "</strong></p>");