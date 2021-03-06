
public class Point
{
	int x;
	int y;
	
	/* This here is the constructor method.
	 * He is your friend.
	 * Things to note:
	 * 	- It has no return Type
	 *  - It is named the same way as the class.
	 *  - usually sets some or lal of the instance variables of an object.
	 *  - 
	 */
	public Point (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public Point()
	{
		x = 0;
		y = 0;
	}
	public Point(int coords)
	{
		x = coords;
		y = coords;
	}
	/* These were all constructors
	 * Now, the toString method
	 */
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	public void translate(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	//October 25
	public void invert()
	{
		int value = x;
		x = y;
		y = value;
	}
}
