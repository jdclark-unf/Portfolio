var sieveArray = new Array(100);
var cellCount = 0;

// Initialize all array elements to 1
for (i = 0; i < 100; i++)
{
	sieveArray[i] = 1;
}

// Loop through entire array
for (i = 0; i < 100; i++)
{
	// If index is 0 or 1, set the element to 0, because 0 and 1 are not prime
	if (i < 2)
	{
		sieveArray[i] = 0;
	}
	// If element at current index is 1, test for primality
	else 
	{
		if (sieveArray[i] == 1)
		{
			// Loop through sub-array, starting at index immediately after the current one
			for (j = i + 1; j < 100; j++)
			{
				// If j divides i, j is not prime
				if (j % i == 0)
				{
					sieveArray[j] = 0;
				}
			}
		}
	}
}

// Create table of primes
document.writeln("<table><caption>Prime Numbers Less Than 100</caption>");
document.write("<tr>");

// Generate table cells from array
for (i = 0; i < 100; i++)
{
	if (sieveArray[i] == 1)
	{
		document.write("<td>" + i + "</td>");
		if (++cellCount % 10 == 0)
		{
			document.write("</tr><tr>");
		}
	}
}

// Complete table
document.write("</tr>");
document.writeln("</table>");