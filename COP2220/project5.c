/*
* Program Name: COP 2220-51014 Project 5
*
* Author: Justin Clark
*
* Description: This program scans a user-defined file for student records and reads each line into an
*              array of structures. The user is then prompted with a menu of processing options which
*              can be performed on these records.
*
*              If invalid/badly formed records are scanned, they are discarded.
*
*              Program failures can be diagnosed with the following error codes:
*
*                  1 - No file name was entered
*                  2 - File could not be opened.
*                  3 - No menu item chosen
*                  4 - Submitted menu selection was not a number
*
* Input: fn - Name of the file to be scanned
*
* Output: A summary of scanned records followed by a menu of processing options, and any messages
*         relevant to these functions, or appropriate error messages.
*
*         Example:
*
*              COP 2220-51014 Project5: Justin Clark
*
*              Enter file name: test
*
*              Invalid Record: Eyedee,Isbad,98654,100,34,54,21,34
*              Invalid Record: Score,Bad,25747,155,98,95,100,101
*              Invalid Record: Data,Missing,12345,100,,99,50,
*              Invalid Record: Student,Withnamethatistoolong,11112,100,100,100,100,100
*
*              There are 12 records available.
*
*              The actions available are:
*                  1. Print a report of the records.
*                  2. Sort the records by the Student Name field.
*                  3. Sort the records by the Student ID field.
*                  4. Search for a record by Student name and print the record.
*                  5. Search for a record by Student ID and print the record.
*                  6. Quit
*                  7. Sort the records by the Student Grade Average field.
*                  8. Search for a record by Student Grade Letter field.
*              Choose an action: 1
*
*              +----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+
*              | Student Name               |  ID   | Test 1 | Test 2 | Proj 1 | Proj 2 | Proj 3 | Average | Grade |
*              +----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+
*              | Cool, Joe                  | 32598 |  100   |   43   |   68   |   88   |   75   |  74.80  |  C    |
*              | Slacker, Rufus             | 34312 |   65   |   48   |    0   |   68   |   45   |  45.20  |  F    |
*              | Smart, Maxwell             | 45868 |   55   |   64   |   99   |   99   |   79   |  79.20  |  C    |
*              | Bond, James                | 10007 |   85   |   86   |   90   |   95   |   85   |  88.20  |  B    |
*              | Student, Good              | 11111 |  100   |   98   |  100   |   95   |   99   |  98.40  |  A    |
*              | Smith, John                | 31894 |   85   |   73   |   89   |   85   |   87   |  83.80  |  B    |
*              | Doe, Jane                  | 10112 |   93   |   87   |   73   |   74   |   81   |  81.60  |  B    |
*              | Dropout, College           | 15347 |   54   |    0   |   67   |    0   |    0   |  24.20  |  F    |
*              | Student, Solid             | 46267 |   95   |   93   |   87   |   94   |   96   |  93.00  |  A    |
*              | Student, Purfect           | 11111 |  100   |  100   |  100   |  100   |  100   | 100.00  |  A    |
*              | Zappa, Zelda               | 49999 |   87   |   88   |   89   |   90   |   89   |  88.60  |  B    |
*              | Abernathy, Aaron           | 10000 |    1   |    2   |    3   |    4   |    5   |   3.00  |  F    |
*              +----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+
*
*              There are 12 records available.
*
*              The actions available are:
*                  1. Print a report of the records.
*                  2. Sort the records by the Student Name field.
*                  3. Sort the records by the Student ID field.
*                  4. Search for a record by Student name and print the record.
*                  5. Search for a record by Student ID and print the record.
*                  6. Quit
*                  7. Sort the records by the Student Grade Average field.
*                  8. Search for a record by Student Grade Letter field.
*              Choose an action: 6
*
*              Have a nice day!
*
*              Process returned 0 (0x0)   execution time : 18.835 s
*              Press any key to continue.
*
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct
{
    char lastname[13];
    char firstname[13];
    int studentid;
    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    float average;
    char grade;
    char fullname[27];
} STUDENT;

FILE* getFile(FILE* fp);
int readFile(FILE* fp, STUDENT studentArray[]);
float calcAverage(int num1, int num2, int num3, int num4, int num5);
char calcGrade(float meanScore);
void displayMenu(STUDENT studentArray[], int count);
void printReport(STUDENT studentArray[], int count);
void sortRecords(STUDENT studentArray[], int count, char mode);
void searchRecords(STUDENT studentArray[], int count, char mode);

int main()
{
    FILE* fp;
    int count;
    STUDENT studentArray[50];

    printf("\nCOP 2220-51014 Project5: Justin Clark\n");

    fp = getFile(fp);
    count = readFile(fp, studentArray);

    displayMenu(studentArray, count);

    return 0;
}

/*
* Function Name: getFile
*
* Input Parameters: fp - pointer to a file
*
* Description: Prompts user for a file name and attempts to open a file by that name for reading.
*
* Return Value: Pointer to opened file.
*/
FILE* getFile(FILE* fp)
{
    char fn[FILENAME_MAX];

    printf("\nEnter file name: ");

    scanf("%s", fn);

    if (fn == EOF)
    {
        printf("\nError: No file name entered, exiting...\n");
        exit(1);
    }
    else if ((fp = fopen(fn, "r")) == NULL)
    {
        printf("\nError: Could not open file %s for read.\n", fn);
        exit(2);
    }

    return fp;
}

/*
* Function Name: readFile
*
* Input Parameters: fp - pointer to a file
*                   sr[] - array of student record structures
*
* Description: Reads a file line-by-line, and attempts to process each line into a student record,
*              which is stored in an array of structures. Invalid records are discarded with an
*              appropriate error message.
*
* Return Value: Number of lines successfully read.
*/
int readFile(FILE* fp, STUDENT sr[])
{
    char line[200]; // Current line read from file
    int rc;         // Return code
    int ct = 0;     // Record counter

    printf("\n");

    // Read one line at a time until end of file is reached
    while (fgets(line, 200, fp) != NULL)
    {
        // Attempt to process line into structure
        rc = sscanf(line, "%12[^,],%12[^,],%d,%d,%d,%d,%d,%d",
                    sr[ct].lastname, sr[ct].firstname, &sr[ct].studentid,
                    &sr[ct].score1, &sr[ct].score2, &sr[ct].score3,
                    &sr[ct].score4, &sr[ct].score5);

        // If line contained invalid data...
        if (rc != 8 || sr[ct].studentid < 10000 || sr[ct].studentid > 49999 ||
            sr[ct].score1 < 0 || sr[ct].score1 > 120 || sr[ct].score2 < 0 ||
            sr[ct].score2 > 120 || sr[ct].score3 < 0 || sr[ct].score3 > 120 ||
            sr[ct].score4 < 0 || sr[ct].score4 > 120 || sr[ct].score5 < 0 ||
            sr[ct].score5 > 120)
                // Print error message
                printf("Invalid Record: %s", line);
        // Otherwise...
        else
        {
            // Calculate average of scores
            sr[ct].average = calcAverage(sr[ct].score1, sr[ct].score2, sr[ct].score3, sr[ct].score4, sr[ct].score5);

            // Calculate letter grade
            sr[ct].grade = calcGrade(sr[ct].average);

            // Combine first and last names into full name
            strncpy(sr[ct].fullname, sr[ct].lastname, 12);
            strncat(sr[ct].fullname, ", ", 2);
            strncat(sr[ct].fullname, sr[ct].firstname, 12);

            // Increment record counter and break out of loop when 50 records have been read
            if (++ct == 50)
                break;
        }
    }

    fclose(fp);

    return ct;
}

/*
* Function Name: calcAverage
*
* Input Parameters: num1-num5 - a set of numbers to be averaged
*
* Description: Calculates the average of five integers.
*
* Return Value: The floating-point average of the input numbers.
*/
float calcAverage(int num1, int num2, int num3, int num4, int num5)
{
    return (num1 + num2 + num3 + num4 + num5) / 5.0;
}

/*
* Function Name: calcGrade
*
* Input Parameters: meanScore - the average of a student's scores
*
* Description: Calculates the letter grade associated with a student's score average.
*
* Return Value: The calculated letter grade.
*/
char calcGrade(float meanScore)
{
    char grade;

    if (meanScore >= 90.0)
        grade = 'A';
    else if (meanScore >= 80.0)
        grade = 'B';
    else if (meanScore >= 70.0)
        grade = 'C';
    else if (meanScore >= 60.0)
        grade = 'D';
    else
        grade = 'F';

    return grade;
}

/*
* Function Name: displayMenu
*
* Input Parameters: studentArray[] - array of student structures
*                   count - number of records in array
*
* Description: Displays a menu of options and prompts user to select one.
*
* Return Value: Nothing
*/
void displayMenu(STUDENT studentArray[], int count)
{
    int option;
    int rc;

    while (true)
    {
        printf("\nThere are %d records available.\n", count);
        printf("\nThe actions available are:\n");
        printf("    1. Print a report of the records.\n");
        printf("    2. Sort the records by the Student Name field.\n");
        printf("    3. Sort the records by the Student ID field.\n");
        printf("    4. Search for a record by Student name and print the record.\n");
        printf("    5. Search for a record by Student ID and print the record.\n");
        printf("    6. Quit\n");
        printf("    7. Sort the records by the Student Grade Average field.\n");
        printf("    8. Search for a record by Student Grade Letter field.\n");
        printf("Choose an action: ");

        rc = scanf("%d", &option);

        if (rc == EOF)
        {
            printf("\nNo choice made, exiting...\n");
            exit(3);
        }
        else if (rc == 0)
        {
            printf("\nInvalid input, exiting...\n");
            exit(4);
        }
        else
        {
            switch (option)
            {
                case 1:
                    printReport(studentArray, count);
                    break;
                case 2:
                    sortRecords(studentArray, count, 'a');
                    break;
                case 3:
                    sortRecords(studentArray, count, 'i');
                    break;
                case 4:
                    searchRecords(studentArray, count, 'a');
                    break;
                case 5:
                    searchRecords(studentArray, count, 'i');
                    break;
                case 6:
                    printf("\nHave a nice day!\n");
                    exit(0);
                case 7:
                    sortRecords(studentArray, count, 'g');
                    break;
                case 8:
                    searchRecords(studentArray, count, 'g');
                    break;
                default:
                    printf("\nInvalid option entered, try again.");
                    break;
            }
        }
    }
}

/*
* Function Name: printReport
*
* Input Parameters: studentArray[] - array of student structures
*                   count - number of records in array
*
* Description: Displays a table of processed records.
*
* Return Value: Nothing
*/
void printReport(STUDENT studentArray[], int count)
{
    printf("\n+----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+\n");
    printf("| Student Name               |  ID   | Test 1 | Test 2 | Proj 1 | Proj 2 | Proj 3 | Average | Grade |\n");
    printf("+----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+\n");

    for (int i = 0; i < count; i++)
    {
        printf("| %-26s | %5d |  %3d   |  %3d   |  %3d   |  %3d   |  %3d   | %6.2f  |  %c    |\n",
               studentArray[i].fullname, studentArray[i].studentid, studentArray[i].score1,
               studentArray[i].score2, studentArray[i].score3, studentArray[i].score4,
               studentArray[i].score5, studentArray[i].average, studentArray[i].grade);
    }

    printf("+----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+\n");
}

/*
* Function Name: sortRecords
*
* Input Parameters: studentArray[] - array of student structures
*                   count - number of records in array
*                   mode - mode of operation:
*                           a = sort alphabetically by name in ascending order
*                           i = sort numerically by name in ascending order
*                           g = sort numerically in descending order by grade average
*
* Description: Sorts an array of student structures using Bubble Sort algorithm.
*
* Return Value: Nothing
*/
void sortRecords(STUDENT studentArray[], int count, char mode)
{
    STUDENT temp;

    for (int i = 0; i < count; i++)
    {
        for (int j = count - 1; j > i; j--)
        {
            if ((mode == 'a' && strcmp(studentArray[j].lastname, studentArray[j - 1].lastname) < 0) ||
                (mode == 'i' && studentArray[j].studentid < studentArray[j - 1].studentid) ||
                (mode == 'g' && studentArray[j].average > studentArray[j - 1].average))
            {
                temp = studentArray[j];
                studentArray[j] = studentArray[j - 1];
                studentArray[j - 1] = temp;
            }
        }
    }

    switch(mode)
    {
        case 'a':
            printf("\nThe records have been sorted by Student Name field\n");
            break;
        case 'i':
            printf("\nThe records have been sorted by Student ID field\n");
            break;
        case 'g':
            printf("\nThe records have been sorted by the Average Grade field\n");
            break;
        default:
            break;
    }
}

/*
* Function Name: searchRecords
*
* Input Parameters: studentArray[] - array of student structures
*                   count - number of records in array
*                   mode - mode of operation:
*                           a = search for records by last name
*                           i = search for records by student id
*                           g = search for records by grade letter
*
* Description: Prompts user for search criteria, and finds all matching records.
*
* Return Value: Nothing
*/
void searchRecords(STUDENT studentArray[], int count, char mode)
{
    char name[13];
    char grade;
    int id;
    int rc;
    int matches = 0;
    int indices[50] = {0};

    switch(mode)
    {
        case 'a':
            printf("\nEnter Student Name last name or a partial name: ");
            rc = scanf("%s", name);
            break;
        case 'i':
            printf("\nEnter Student ID nnnnn: ");
            rc = scanf("%d", &id);
            break;
        case 'g':
            printf("\nEnter Student Grade A/B/C/D/F: ");
            rc = scanf(" %c", &grade);
            break;
        default:
            break;
    }

    if (rc == EOF)
    {
        printf("\nError: No choice made, exiting...\n");
        exit(3);
    }
    else
    {
        for (int i = 0; i < count; i++)
        {
            if ((mode == 'a' && strncmp(name, studentArray[i].lastname, strlen(name)) == 0) ||
                (mode == 'i' && studentArray[i].studentid == id) ||
                (mode == 'g' && studentArray[i].grade == grade))
            {
                indices[matches++] = i;
            }
        }
    }

    if (matches > 0)
    {
        printf("\n+----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+\n");
        printf("| Student Name               |  ID   | Test 1 | Test 2 | Proj 1 | Proj 2 | Proj 3 | Average | Grade |\n");
        printf("+----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+\n");

        for (int i = 0; i < matches; i++)
        {
            printf("| %-26s | %5d |  %3d   |  %3d   |  %3d   |  %3d   |  %3d   | %6.2f  |  %c    |\n",
                   studentArray[indices[i]].fullname, studentArray[indices[i]].studentid, studentArray[indices[i]].score1,
                   studentArray[indices[i]].score2, studentArray[indices[i]].score3, studentArray[indices[i]].score4,
                   studentArray[indices[i]].score5, studentArray[indices[i]].average, studentArray[indices[i]].grade);
        }

        printf("+----------------------------+-------+--------+--------+--------+--------+--------+---------+-------+\n");
    }
    else
        printf("\nSorry, no matching records found.\n");
}
