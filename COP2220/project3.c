/*
* Program Name: COP 2220-51014 Project 3
*
* Author: Justin Clark
*
* Description: Simulates a slot machine using a random number generator
*
* Input: bank - integer value of money available
*        bet - integer value of money to be wagered
*
* Output: Simulated slot machine and results.
*
*         Example:
*
*         COP 2220-51014 Project 3 - Justin Clark
*
*         Let's play Lucky Sevens!
*
*         How many dollars do you want to start with (0 to quit)? 100
*
*         How many dollars do you want to bet (enter 0 to cash out)? 25
*
*                _____
*          _____/ 777 \_____
*         /  LUCKY SEVENS   \  __
*         | 777     70x Bet | (  )
*         | Match 3 30x Bet |  ||
*         | Match 2  1x Bet |  ||
*         | Seven    1x Bet |  ||
*         +-----+-----+-----+  ||
*         |  6  |  7  |  5  |  ||
*         +-----+-----+-----+  ||
*         |  WIN! WIN! WIN! |__||
*         |     _______ === |---'
*         |____/       \____|
*         (_________________)
*           V             V
*
*         Lucky Seven! You win $25
*         Your current total is $100
*
*         How many dollars do you want to bet (enter 0 to cash out)? 0
*
*         Payout $100, please come back and play again.
*
* Algorithm
*
*  1. Print greeting.
*  2. Prompt user to enter starting money.
*  3. If input is 0, print exit message and exit program.
*  4. If input is a valid number greater than 0, go to 6.
*  5. If input is not a valid number, print error message and go to 2.
*  6. Prompt user to enter bet.
*  7. If input is 0, print exit message and exit program.
*  8. If input is a valid number greater than 0, go to 10.
*  9. If input is not a valid number, print error message and go to 6.
* 10. Subtract bet from starting amount in bank.
* 11. Randomly generate three integer values from 1 to 7.
* 12. Print slot machine and results.
* 13. If user won money, add to current amount in bank and go to 6.
* 14. If user lost money, check amount remaining in bank.
* 15. If user still has money, go to 6.
* 16. If user has no money, print exit message and exit program.
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

// Function declarations
void getStartingAmount(int* bank);
void getBetAmount(int* bet, int bank);
void displaySlots(int slot1, int slot2, int slot3);
int calcWinnings(int slot1, int slot2, int slot3, int bet);
int spin(int* slot);

// Entry point of program
int main(void)
{
    int bank = 0;
    int bet = 0;
    int slot1, slot2, slot3;

    srand(time(NULL));

    printf("\nCOP 2220-51014 Project 3 - Justin Clark\n");
    printf("\nLet's play Lucky Sevens!\n");

    getStartingAmount(&bank);

    // Loop until money runs out
    do
    {
       getBetAmount(&bet, bank);

       displaySlots(spin(&slot1), spin(&slot2), spin(&slot3));

       bank = (bank - bet) + calcWinnings(slot1, slot2, slot3, bet);

       printf("Your current total is $%d\n", bank);

    } while (bank > 0);

    printf("\nToo bad, you're out of money. Come back when you have more.\n");

    return 0;
} // end main()

/*
* Function Name: getStartingAmount
*
* Input Parameters: bank - integer pointer to current amount of money
*
* Description: Prompts user for starting dollar amount. If a zero is entered, a message is printed and program exits.
*              If a negative number is entered, an error message is printed and user is prompted again.
*              If a positive number is entered, it becomes the user's current bank total.
*
* Return Value: Nothing.
*/
void getStartingAmount(int* bank)
{
    // Loop forever
    while (true)
    {
        // Prompt user and get input
        printf("\nHow many dollars do you want to start with (0 to quit)? ");
        scanf("%d", bank);

        // If input is invalid, print error message.
        if (*bank < 0)
        {
            printf("\nERROR: Enter at least one dollar or zero if you don't want to play.\n");
        }
        // If input is valid and nonzero, return to caller
        else if (*bank > 0)
        {
            return;
        }
        // If input is zero, exit program
        else
        {
            printf("\nGoodbye.\n");
            exit(0);
        }
    }
} // end getStartingAmount()

/*
* Function Name: getBetAmount
*
* Input Parameters: bet - integer pointer to bet amount
*                   bank - integer value of current bank total
*
* Description: Prompts user for bet amount. If a zero is entered, a message is printed and program exits.
*              If a negative number is entered, an error message is printed and user is prompted again.
*              If an invalid positive number is entered, error message is printed and user is prompted again.
*              If a valid positive number is entered, it becomes the user's current bet amount.
*
* Return Value: Nothing.
*/
void getBetAmount(int* bet, int bank)
{
    // Loop forever
    while (true)
    {
        // Prompt user and get input
        printf("\nHow many dollars do you want to bet (enter 0 to cash out)? ");
        scanf("%d", bet);

        // If input is negative, print error message.
        if (*bet < 0)
        {
            printf("\nERROR: Enter at least one dollar or zero to cash out.\n");
        }
        // if input is greater than available money, print error message.
        else if (*bet > bank)
        {
            printf("Sorry, you can't bet more money than you have.\n");
        }
        // If input is zero, print payout and exit program.
        else if (*bet == 0)
        {
            printf("\nPayout $%d, please come back to play again.\n", bank);
            exit(0);
        }
        // If input was otherwise valid, return to caller
        else
        {
            return;
        }
    }
} // end getBetAmount()

/*
* Function Name: spin
*
* Input Parameters: slot - integer pointer to one of the slot machine's numbers
*
* Description: Sets slot to a randomly generated integer from 1 to 7
*
* Return Value: A random integer from 1 to 7
*/
int spin(int* slot)
{
    *slot = rand() % 7 + 1;
    return *slot;
} // end spin()

/*
* Function Name: displaySlots
*
* Input Parameters: slot1, slot2, slot3 - current integer values of slots
*
* Description: Prints an ASCII image of a slot machine to screen
*
* Return Value: Nothing.
*/
displaySlots(int slot1, int slot2, int slot3)
{
    printf("\n");
    printf("       _____\n");
    printf(" _____/ 777 \\_____\n");
    printf("/  LUCKY SEVENS   \\  __\n");
    printf("| 777     70x Bet | (  )\n");
    printf("| Match 3 30x Bet |  ||\n");
    printf("| Match 2  1x Bet |  ||\n");
    printf("| Seven    1x Bet |  ||\n");
    printf("+-----+-----+-----+  ||\n");
    printf("|  %d  |  %d  |  %d  |  ||\n", slot1, slot2, slot3);
    printf("+-----+-----+-----+  ||\n");
    printf("|  WIN! WIN! WIN! |__||\n");
    printf("|     _______ === |---'\n");
    printf("|____/       \\____|\n");
    printf("(_________________)\n");
    printf("  V             V\n");
} // end displaySlots()

/*
* Function Name: calcWinnings
*
* Input Parameters: slot1, slot2, slot3 - current integer values of slots
*                   bet - integer value of current bet
*
* Description: Calculates winnings based on slot results and bet amount
*
* Return Value: Integer amount of winnings
*/
int calcWinnings(int slot1, int slot2, int slot3, int bet)
{
    int winnings;

    // Triple sevens
    if (slot1 == 7 && slot2 == 7 && slot3 == 7)
    {
        winnings = bet * 70;
        printf("\nJACKPOT! Congratulations, you win $%d\n", winnings);
    }
    // Match three numbers
    else if (slot1 == slot2 && slot1 == slot3)
    {
        winnings = bet * 30;
        printf("\nTriple Match! You win $%d\n", winnings);
    }
    // Match two numbers
    else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3)
    {
        winnings = bet;
        printf("\nMatch Two, you win $%d\n", winnings);
    }
    // Lucky seven
    else if (slot1 == 7 || slot2 == 7 || slot3 == 7)
    {
        winnings = bet;
        printf("\nLucky Seven! You win $%d\n", winnings);
    }
    // No matches
    else
    {
        winnings = 0;
        printf("\nSorry, no match.\n", winnings);
    }

    return winnings;
} // end calcWinnings()
