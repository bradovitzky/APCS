package textExcel1;

import java.util.*;

public class Cell
{
	// instance variable
	private String contents;
	
	// Constructors start
	public Cell()
	{
		contents = "";
	}
	public Cell(String input)
	{
		contents = input;
	}
	// Constructors end
	public void setValue(String input)
	{
		contents = input;
	}
	public String getValue()
	{
		return contents;
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