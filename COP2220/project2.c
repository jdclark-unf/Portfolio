/*
* Program Name: COP 2220-51014 Project2 - Future Value using Functions
*
* Author: Justin Clark
*
* Description: This program calculates the future value of a current amount
*       based on yearly compounded interest earned.
*
* Input: The starting amount of money (float), the interest rate (float),
*       the number of years that interest should be compounded (int), and the
*       starting year (int)
*
* Output: The results of each calculation, summarized in a table.
*
*        Example:
*
*               COP 2220-51014 Project 2: Justin Clark
*               Enter a Starting amount (dollars and cents): 25123.5
*               Enter an Interest rate (ex. 2.5 for 2.5%):   3.4
*               Enter the Number of years (integer number):  5
*               Enter the Starting year (four digits):       2014
*
*               +-----------------------------+--------------+
*               | Description                 |  Input Data  |
*               |-----------------------------+--------------|
*               | Starting amount             | $  25123.50  |
*               | Interest rate               |        3.40% |
*               | Number of Years             |        5     |
*               | Starting year               |     2014     |
*               +-----------------------------+--------------+
*               | Future value                |   Results    |
*               +-----------------------------+--------------+
*               | In 2019 the balance will be | $  29694.97  |
*               | Interest earned             | $   4571.47  |
*               | Total percent gained        |       18.20% |
*               +-----------------------------+--------------+
*
*               Process returned 0 (0x0)   execution time : 10.828 s
*               Press any key to continue.
*
* Algorithm:
* 1. Print greeting
* 2. Prompt user for starting amount (float)
* 3. Read starting amount
* 4. Prompt user for interest rate (float)
* 5. Read interest rate
* 6. Prompt user for number of years (int)
* 7. Read number of years
* 8. Prompt user for starting year (int)
* 9. Read starting year
* 10. Validate user data
* 11. Check data
* 12. Print errors
* 13. If there were errors, end program
* 14. If there were no errors, perform these calculations:
*   - future year (starting year + number of years)
*   - future value (starting amount * (1 + interest rate / 100)^number of years)
*   - total interest earned (future value - starting amount)
*   - total percentage gain (interest earned / starting amount * 100)
* 15. Print table of results
* 16. Exit program
*
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

// Function declarations
bool getUserInput (float* startAmount, float* interestRate, int* numYears, int* startYear);
void calcFutureValue(float startAmount, float interestRate, int numYears, int startYear,
                     int* futureYear, float* futureBalance, float* interestEarned, float* percentGain);
void displayResults(float startAmount, float interestRate, int numYears, int startYear,
                    int futureYear, float futureValue, float interestEarned, float percentGain);

int main(void)
{
    // Local variables
    float startAmount, interestRate, futureValue, interestEarned, percentGain;
    int numYears, startYear, futureYear;

    printf("\nCOP 2220-51014 Project 2: Justin Clark\n\n");

    // Get and validate user input
    if (!getUserInput(&startAmount, &interestRate, &numYears, &startYear))
    {
        printf("\nExiting\n\n");
        exit(-1);
    } // end if (invalid user input)
    else {
        calcFutureValue(startAmount, interestRate, numYears, startYear,
                        &futureYear, &futureValue, &interestEarned, &percentGain);
        displayResults(startAmount, interestRate, numYears, startYear,
                       futureYear, futureValue, interestEarned, percentGain);
    }

} //end function main()

/*
* Function Name: getUserInput
*
* Input Parameters: The starting amount of money (float), the interest rate (float),
*       the number of years that interest should be compounded (int), and the starting year (int)
*
* Description: Prompts user to enter four parameters. If user input is valid, the data will be copied
*       to pointer addresses for later use, and the function returns a boolean value of true. If input
*       is invalid, the function returns false.
*
* Return Value: A boolean value of true if user input was valid, or false otherwise.
*/
bool getUserInput(float* startAmount, float* interestRate, int* numYears, int* startYear)
{
    // Set default error state
    bool isValid = true;

    // Get starting dollar amount
    printf("Enter a Starting amount (dollars and cents): ");
    scanf("%f", startAmount);

    // Get interest rate
    printf("Enter an Interest rate (ex. 2.5 for 2.5%%):   ");
    scanf("%f", interestRate);

    // Get number of years
    printf("Enter the Number of years (integer number):  ");
    scanf("%d", numYears);

    // Get starting year
    printf("Enter the Starting year (four digits):       ");
    scanf("%d", startYear);

    // Perform validation
    if (*startAmount < 0.01) {
        printf("\nStarting amount must be at least one cent.");
        isValid = false;
    } // end if (invalid starting amount)
    if (*interestRate < 0.1) {
        printf("\nInterest rate must be at least .1%%.");
        isValid = false;
    } //end if (invalid interest rate)
    if (*numYears < 1) {
        printf("\nNumber of years must be at least 1.");
        isValid = false;
    } // end if (invalid number of years)
    if (*startYear < 1000 || *startYear > 9999) {
        printf("\nYear must be four digits");
        isValid = false;
    } // end if (invalid year)

    return isValid;
} // end function getUserInput()

/*
* Function Name: calcFutureValue
*
* Input Parameters: The starting amount of money (float), the interest rate (float),
*       the number of years that interest should be compounded (int), the starting year (int),
*       and pointers to the future year (int), the future value with compounded interest (float),
*       the total future interest earned (float), and the percentage future interest earned (float)
*
* Description: Calculates the future year, future value with compounded interest, future total interest
*       earned, and future percentage interest earned, and copies the resulting values to pointer addresses.
*
* Return Value: Nothing.
*/
void calcFutureValue(float startAmount, float interestRate, int numYears, int startYear,
                     int* futureYear, float* futureValue, float* interestEarned, float* percentGain)
{
    *futureYear = startYear + numYears;
    *futureValue = startAmount * powf(1 + interestRate / 100, numYears);
    *interestEarned = *futureValue - startAmount;
    *percentGain = *interestEarned / startAmount * 100;

    return;
}

/*
* Function Name: displayResults
*
* Input Parameters: The starting amount of money (float), the interest rate (float),
*       the number of years that interest should be compounded (int), the starting year (int),
*       the future year (int), the future value with compounded interest (float), the total
*       future interest earned (float), and the percentage future interest earned (float)
*
* Description: Generates a table displaying the starting amount of money, the interest rate,
*       the number of years that interest should be compounded, the starting year, the future
*       year, the future value with compounded interest, the total future interest earned, and
*       the percentage future interest earned.
*
* Return Value: Nothing.
*/
void displayResults(float startAmount, float interestRate, int numYears, int startYear,
                    int futureYear, float futureValue, float interestEarned, float percentGain)
{
    printf("\n+-----------------------------+--------------+\n");
    printf("| Description                 |  Input Data  |\n");
    printf("|-----------------------------+--------------|\n");
    printf("| Starting amount             | $%10.2f  |\n", startAmount);
    printf("| Interest rate               |  %10.2f%% |\n", interestRate);
    printf("| Number of Years             |  %7d     |\n", numYears);
    printf("| Starting year               |  %7d     |\n", startYear);
    printf("+-----------------------------+--------------+\n");
    printf("| Future value                |   Results    |\n");
    printf("+-----------------------------+--------------+\n");
    printf("| In %d the balance will be | $%10.2f  |\n", futureYear, futureValue);
    printf("| Interest earned             | $%10.2f  |\n", interestEarned);
    printf("| Total percent gained        |  %10.2f%% |\n", percentGain);
    printf("+-----------------------------+--------------+\n");
} // end function displayResults()
