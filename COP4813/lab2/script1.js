document.writeln("<table>");
document.writeln("<tr><th>Number</th><th>Square</th><th>Cube</th></tr>");

for (i = 0; i < 6; i++)
{
	var square = Math.pow(i, 2);
	var cube = Math.pow(i, 3);
	
	if (i % 2 == 0)
	{
		document.writeln("<tr class = 'even'><td class = 'root'>" + i + 
		"</td><td>" + square + "</td><td>" + cube + "</td></tr>");
	} // end if (i is an odd number)
	else
	{
		document.writeln("<tr><td class = 'root'>" + i + "</td><td>" + 
		square + "</td><td>" + cube + "</td></tr>");
	} // end else (i is an even number)
} // end for

document.writeln("</table>");