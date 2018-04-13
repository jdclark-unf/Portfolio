/*
* Program Name: COP 2220-51014 Project1 - Beyond Hello World
*
* Author: Justin Clark
*
* Description: This program performs several calculations on a group of numbers entered by user.
*
* Input: Two integer values and two floating point values
*
* Output: The results of each calculation.
*/

#include <stdio.h>

int main (void)
{
	// Declare local variables
	int number1;
	int number2;
	float number3;
	float number4;
	float result;
	float sum;
	float average;

	// Prompt user for input
	printf("COP 2220 Project 1 - Justin Clark.\n\n");
	printf("Enter four numbers in the format nnn nnn nnn.nn nnn.nn<enter>: ");

	// Get user input
	scanf("%d %d %f %f", &number1, &number2, &number3, &number4);

	// Calculate and print formula result
	result = (number1 / number2) * number3 - number4;
	printf("\nThe result of the calculation (%d / %d) * %.2f - %.2f is %.2f\n",
        number1, number2, number3, number4, result);

	// Calculate and print sum of all four numbers
	sum = number1 + number2 + number3 + number4;
	printf("\nThe sum of the input numbers is:     %-.2f\n", sum);

	// Calculate average of input numbers
	average = sum / 4;
	printf("The average of the input numbers is: %-.3f\n", average);

	// Display exit message
	printf("\nGoodbye.\n\n");

	return 0;
} // main
