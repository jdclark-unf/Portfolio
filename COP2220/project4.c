/*
* Program Name: COP 2220-51014 Project 4
*
* Author: Justin Clark
*
* Description: This program scans a user-supplied text file for up to 75 numerical values, stores
*              these values in a single-dimensional array, organizes the array in numerical order
*              using a Bubble Sort algorithm, and calculates various statistics about these values,
*              which are printed to the screen with a table of the scanned values.
*
*              If invalid data are scanned (e.g. non-numerical values), these data are discarded.
*
*              If data cannot be scanned, the program exits with one of the following error codes:
*
*                  1 - No file name was entered
*                  2 - File could not be opened.
*                  3 - File contains no readable numbers.
*
* Input: fileName - Name of the file to be scanned
*
* Output: Summary of data and statistics, or error messages, as appropriate
*
*         Example:
*
*             COP 2220-51014 Project 4: Justin Clark
*
*             Enter File Name: test
*
*                -949.57    -943.20    -828.57    -815.02    -756.09
*                -742.54    -724.78    -692.92    -688.73    -655.93
*                -559.58    -537.58    -507.79    -424.17    -419.78
*                -384.19    -383.34    -368.02    -316.29    -280.95
*                -254.06    -253.85    -247.32    -219.49    -212.89
*                -167.21    -150.21    -148.26    -134.74    -133.18
*                -117.83    -114.41     -98.51     -59.36     -28.17
*                 -16.36     -13.09      -8.58       5.31      37.90
*                  54.99      91.59     126.16     211.74     211.89
*                 221.99     256.66     272.86     274.36     278.69
*                 327.49     394.48     397.87     432.75     465.98
*                 482.28     531.14     546.89     565.11     617.96
*                 634.47     664.32     668.75     669.97     686.81
*                 750.93     768.05     788.13     799.79     806.11
*                 838.18     839.62     884.51     940.60     974.54
*
*             There were 75 numbers found in file test.
*             The sum of the values is:         4164.30
*             The average of the values is:       55.52
*             The median of the values is:        -8.58
*             The smallest number found was:    -949.57
*             The largest number found was:      974.54
*
*             Process returned 0 (0x0)   execution time : 2.826 s
*             Press any key to continue.
*
* Algorithm:
*
* 1. Print greeting.
* 2. Prompt user to input filename.
* 3. Acquire user input.
* 4. If input is valid, go to 6.
* 5. If input is invalid or file cannot be opened, print error message and exit program.
* 6. Read a numeric value from file into an array until 75 numbers are read or EOF is read.
* 7. If invalid data is read, discard value and remainder of line, print error message and go to 6.
* 8. If no data is read, print message and exit.
* 9. Sort array in ascending numerical order
* 10. Calculate sum of values in array.
* 11. Calculate mean of values in array.
* 12. Calculate median of values in array.
* 13. Get minimum value in array.
* 14. Get maximum value in array.
* 15. Print contents of array in five-column table.
* 16. Print summary of data in array:
*     a. Total number of values in array.
*     b. Sum of values in array.
*     c. Mean of values in array.
*     d. Median of values in array.
*     e. Minimum value in array.
*     f. Maximum value in array.
* 17. Exit program.
*
*/

#include <stdio.h>
#include <stdlib.h>

FILE* getFile(char fileName[]);
int readFile(FILE* fp, double dblAry[]);
void sortArray(double dblAry[], int count);
void calcStats(double dblAry[], int count, double* sum, double* mean, double* med, double* min, double* max);
void printSummary(char fn[], double dblAry[], int count, double sum, double mean, double med, double min, double max);

int main(void)
{
    FILE* filePointer;
    char fileName[FILENAME_MAX];

    double dataArray[75] = {0};
    double sum = 0;
    double mean = 0;
    double median = 0;
    double minimum = 0;
    double maximum = 0;
    int dataPoints = 0;

    printf("\nCOP 2220-51014 Project 4: Justin Clark\n");

    filePointer = getFile(fileName);
    dataPoints = readFile(filePointer, dataArray);

    if (dataPoints == 0)
    {
        printf("\nThere were no numbers found in file %s.\n", fileName);
        exit(3);
    }
    else
    {
        sortArray(dataArray, dataPoints);
        calcStats(dataArray, dataPoints, &sum, &mean, &median, &minimum, &maximum);
        printSummary(fileName, dataArray, dataPoints, sum, mean, median, minimum, maximum);
    }

    return 0;
} // end main()

/*
* Function Name: getFile
*
* Input Parameters: fn[] - character array comprising name of file.
*
* Description: Prompts user for a file name, and attempts to open the named file.
*
* Return Value: Pointer to opened file.
*/
FILE* getFile(char fn[])
{
    FILE* fp;
    int status;

    printf("\nEnter File Name: ");
    status = scanf("%s", fn);

    if (status == EOF)
    {
        printf("\n\nError: No file name entered.\n");
        exit(1);
    }

    fp = fopen(fn, "r");

    if (fp == NULL)
    {
        printf("\nError: Could not open file %s for read.\n", fn);
        exit(2);
    }

    return fp;
} // end getFileName()

/*
* Function Name: readFile
*
* Input Parameters: fp - pointer to data file.
*                   dblAry[] - array to hold numbers read from file.
*
* Description: Reads the first 75 double-precision floating point values from a plain-text
*              file and stores them in in array for processing. If invalid data is read,
*              discards data until it reaches end of line.
*
* Return Value: Integer value equal to number of values successfully read and stored.
*/
int readFile(FILE* fp, double dblAry[])
{
    int count = 0;  // initialize number of values read to zero
    double temp;    // temporary placeholder for most recently read value
    int readOK;     // number of values successfully read on current iteration

    // Continuously read file until end is reached or 75 items have been read
    while ((readOK = fscanf(fp, "%lf", &temp)) != EOF && count < 75)
    {
        // If bad data is read...
        if (readOK == 1)
        {
            // Copy most recently read value into array and increment counter
            dblAry[count++] = temp;
        }
        // Otherwise...
        else
        {
            // Discard remainder of line
            while (fgetc(fp) != '\n');

            // Print error message
            printf("Error in the input, discarding the rest of the line.\n");
        }
    }

    fclose(fp);

    return count;
} // end readFile()

/*
* Function Name: sortArray
*
* Input Parameters: dblAry[] - array of double-precision floating point values.
*
* Description: Arranges the contents of an array in ascending numeric order using a Bubble Sort.
*
* Return Value: Nothing.
*/
void sortArray(double dblAry[], int count)
{
    // Placeholder for current array element
    double temp;

    // Loop until desired number of array elements are reached
    for (int i = 0; i < count; i++)
    {
        // Loop over array in reverse order
        for (int j = count - 1; j > i; j--)
        {
            // Bubble Sort
            if (dblAry[j] < dblAry[j - 1])
            {
                temp = dblAry[j];
                dblAry[j] = dblAry[j - 1];
                dblAry[j - 1] = temp;
            } // end bubble sort
        } // end inner loop
    } // end outer loop
} // end sortArray()

/*
* Function Name: calcStats
*
* Input Parameters: dblAry[] - array of double-precision floating point values.
*                   count - number of array elements to be considered.
*                   sum - pointer to total of values in array.
*                   mean - pointer to average of values in array.
*                   med - pointer to median of values in array.
*                         NOTE: array must be sorted numerically prior to calling this function.
*                   min - pointer to smallest value in array.
*                   max - pointer to largest value in array.
*
* Description: Calculates various statistics about values in an array and stores them with pointers.
*
* Return Value: Nothing.
*/
void calcStats(double dblAry[], int count, double* sum, double* mean, double* med, double* min, double* max)
{
    int middle = count / 2;

    // Calculate sum of array elements
    for (int i = 0; i < count; i++)
    {
        *sum = *sum + dblAry[i];
    }

    // Calculate mean of array elements
    *mean = *sum / count;

    // Calculate median of array elements
    if (count % 2 == 0)
    {
        // Even number of elements: median is average of center elements
        *med = (dblAry[middle - 1] + dblAry[middle]) / 2.00;
    }
    else
    {
        // Odd number of elements: median is center element.
        *med = dblAry[middle];
    }

    // Get minimum of array elements
    *min = dblAry[0];

    // Get maximum of array elements
    *max = dblAry[count - 1];
} // end calcStats()

/*
* Function Name: printSummary
*
* Input Parameters: fn[] - character array comprising name of file.
*                   dblAry[] - array of double-precision floating point values.
*                   count - number of array elements to be considered.
*                   sum - total of values in array.
*                   mean - average of values in array.
*                   med - median of values in array.
*                   min - smallest value in array.
*                   max - largest value in array.
*
* Description: Displays summary of values in an array and associated statistics.
*
* Return Value: Nothing.
*/
void printSummary(char fn[], double dblAry[], int count, double sum, double mean, double med, double min, double max)
{
    printf("\n");

    for (int column = 1; column <= count; column++)
    {
        if (column % 5 == 0)
        {
            printf("%10.2f\n", dblAry[column - 1]);
        }
        else
        {
            printf("%10.2f ", dblAry[column - 1]);
        }
    }

    printf("\n\nThere were %d numbers found in file %s.\n", count, fn);
    printf("The sum of the values is:\t%9.2f\n", sum);
    printf("The average of the values is:\t%9.2f\n", mean);
    printf("The median of the values is:\t%9.2f\n", med);
    printf("The smallest number found was:\t%9.2f\n", min);
    printf("The largest number found was:\t%9.2f\n", max);
} // end printSummary()
