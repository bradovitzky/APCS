package textExcel1;

import java.util.Arrays;

public class Cell
{
	String contents;
	public Cell(String input)
	{
		contents = input;
	}
	public String getValue()
	{
		return "value";
	}
	public String toString()
	{
		return contents;
	}
	
	public static void main(String[] args) 
    {
		Cell a1 = new Cell("*");
		System.out.print(a1.getValue());
    }
}
