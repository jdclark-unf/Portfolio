document.writeln("<table>");
document.writeln("<tr><th>Number</th><th>Square</th><th>Cube</th></tr>");

for (i = 0; i <= 6; i++)
{
    document.writeln("<tr><td>" + i + "</td><td>" + Math.pow(i, 2) + 
        "</td><td>" + Math.pow(i, 3) + "</td></tr>");
}

document.writeln("</table>");