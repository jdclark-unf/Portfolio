var isMouseDown = false;
var obj = null;
var layer = 1;

// Listen for mouse events
document.addEventListener("mousedown", grabImage, false);
document.addEventListener("mousemove", dragImage, false);
document.addEventListener("mouseup", dropImage, false);

// Pick up image
function grabImage(e)
{
	if (e.target.id == "Tux")
	{
		isMouseDown = true;
		obj = e.target;
		obj.style.zIndex = 9999;		
	}
} // end function grabImage()

// Move selected image across screen
function dragImage(e)
{
	if (isMouseDown && obj != null)
	{
		obj.style.position = "absolute";
		obj.style.left = e.clientX - 96 + "px";
		obj.style.top = e.clientY - 105 + "px";
	}
} // end function dragImage()

// Set image at location where mouse button is released
function dropImage(e)
{
	isMouseDown = false;
	if (obj != null)
	{
		obj.style.zIndex = layer;
		layer++;
	}
} // end function dropImage()