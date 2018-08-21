var cells;
var isSwapped;

window.addEventListener("load", start, false);

function start()
{
	// Create array of table cells
	cells = new Array(
		[ document.getElementById("xy00"), document.getElementById("xy01"),
		  document.getElementById("xy02"), document.getElementById("xy03")],
		[ document.getElementById("xy10"), document.getElementById("xy11"),
		  document.getElementById("xy12"), document.getElementById("xy13")],
		[ document.getElementById("xy20"), document.getElementById("xy21"),
		  document.getElementById("xy22"), document.getElementById("xy23")],
		[ document.getElementById("xy30"), document.getElementById("xy31"),
		  document.getElementById("xy32"), document.getElementById("xy33")]
		);
	
	// Fill table with random numbers
	scramble();
} // end function start()

function scramble()
{
	var numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
	var randomCell;
	var temp;
	var pointer;
	
	for (i = 0; i < 16; i++)
	{
		randomCell = Math.floor(1 + Math.random() * 15);
		temp = numbers[i];
		numbers[i] = numbers[randomCell];
		numbers[randomCell] = temp;
	} // end for
	
	pointer = 0;
	for (row = 0; row < 4; row++)
	{
		for (column = 0; column < 4; column++)
		{
			if (numbers[pointer] != 0)
			{
				cells[row][column].innerHTML = numbers[pointer];
			}
			else
			{
				cells[row][column].innerHTML = "";
			}
			
			++pointer;
		} // end inner for
	} // end outer for
} // end function scramble()

function clickCell(row, column)
{
	var top = row - 1;
	var bottom = row + 1;
	var left = column - 1;
	var right = column + 1;
	
	isSwapped = false;
	
	if (top != -1 && cells[top][column].innerHTML == "")
	{
		swap(cells[row][column], cells[top][column]);
	}
	else if (right != 4 && cells[row][right].innerHTML == "")
	{
		swap(cells[row][column], cells[row][right]);
	}
	else if (bottom != 4 && cells[bottom][column].innerHTML == "")
	{
		swap(cells[row][column], cells[bottom][column]);
	}
	else if (left != -1 && cells[row][left].innerHTML == "")
	{
		swap(cells[row][column], cells[row][left]);
	}
	else
	{
		alert("Not a valid move");
	}
} // end function clickCell()
	
function swap(cell1, cell2)
{
	isSwapped = true;
	cell2.innerHTML = cell1.innerHTML;
	cell1.innerHTML = "";
} // end function swap()