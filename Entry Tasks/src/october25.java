
public class october25
{	
	public static void main(String[] args)
	{
		Point point = new Point(3, 5);
		System.out.println(point);
		//point.x = 3;
		//point.y = 5;
		point.translate(4, 1);
		point.invert();
		System.out.println("After transformations: " + point);
	}
}
