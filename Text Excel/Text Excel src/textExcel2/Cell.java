/**********************************************************
 * Assignment: TextExcel
 *
 * Authors: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/
package textExcel2;

import java.util.*;

public abstract class Cell
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
	public abstract String getSheetValue();
	public String toString()
	{
		return contents;
	}
}
