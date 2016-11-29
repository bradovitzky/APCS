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

public class Spreadsheet
{
    // these constants make it easy to remember the number of rows and 
    // columns to use
    private final static int ROWS = 10;
    private final static int COLS = 7;
    private final static int CELL_WIDTH = 12;

    // the 2D array of cells
    private Cell[][] data;
    
    int[][] mystructure = new int[2][5];

	String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
    // constructor
    public Spreadsheet()
    {
        data = new Cell[ROWS][COLS]; // all the Cells will start with the value null
    }

    // prints the grid to the console
    public void print()
    {
    	printHeader();
    	for(int rowNum = 0; rowNum < ROWS; rowNum++)
    	{
    		printRow(rowNum);
    	}
        // TODO: code for printing using System.out.println should go here.
        // You can do this with one method call to something that prints
        // the spreadsheet heading, and one loop that for each row calls a
        // method to print the row.
    }
    // used in printing the grid
    private void printHeader()
	{
		printDashLine();
		System.out.print("|");
		System.out.print(repeatedChar(' ', 12));
		System.out.print("|");
		
		for(int colNum = 0; colNum < COLS; colNum++)
		{
			System.out.print(center(letters[colNum], 12));
			System.out.print("|");
		}
		System.out.println();
		printDashLine();
	}
    // also used in printing the grid
	private void printDashLine()
	{
		System.out.print("+");
		for(int colNum = 0; colNum < COLS+1; colNum++)
		{
			System.out.print(repeatedChar('-', 12));

			System.out.print("+");
		}
		System.out.println();
		
	}
	// ALSO used in printing the grid, this one for the non-static values
	private void printRow(int row)
    {
        printNumberCell(row);
        for(int i = 0; i < COLS; i++)
        {
        	printCell(row, i);
        }
        System.out.println();
		printDashLine();
    }
	// another one used in printing the grid, this time for the first cell in each row
    private void printNumberCell(int row)
	{
        System.out.print("|");
		System.out.print(center(row+1+"", 12));
		System.out.print("|");
	}
    // we made this in class, used in "center"
	public static String repeatedChar(char c, int times)
    {
		String temp = "";
    	for(int i = 0; i < times; i++)
    	{
    		temp += c;
    	}
    	return temp;
    }
    // used to put the content of each cell in the center of it, with the right amount of spaces
	public static String center(String s, int width)
    {
    	if(s.length() > width)
    	{
    		return s.substring(0, width-1) + ">";
    	}
    	else
    	{
    		int len = s.length();
        	int spaces = width - len;
        	return repeatedChar(' ', spaces/2) + s + repeatedChar(' ', width-len-spaces/2);
    	}
    }
    // prints a cell with a | at the end (fenceposting)
    private void printCell(int row, int col)
    {
        if (data[row][col] == null)
        {
        	System.out.print(center("", 12));
        }
        else
        {
        	System.out.print(center(data[row][col].getSheetValue(), 12));
        }
        System.out.print("|");
    }

    // Other than the methods above, the rest are for getting the format right.
    // You can organize this in a number of ways, just be sure to use the class
    // constants listed at the top whenever appropriate, and try not to hard-code things.
    // You'll also need to add things to the methods above to tweak the formatting,
    // like adding a println, or figuring out when to print a "|" character, etc.
    // I have methods for things like printing the heading part of the spreadsheet,
    // centering a string in a field, printing the divider between rows, etc.
    // There are lots of ways to think about it. Try to reduce the amount of
    // redundant code by generalizing things in methods with parameters, and
    // test, test, test as you go.
    
    // methods for formatting things are not shown 


	// test code: if you run this class's main instead of your TextExcel, you should
    // see a grid printed that has 3 cells filled in.
    
    // used to create new cells
	public void createCell(String position, Cell cell)
	{
		for(int i = 0; i<letters.length; i++)
		{
			if(position.substring(0,1).equals(letters[i]))
			{
				data[Integer.parseInt(position.substring(1)) - 1][i] = cell;
			}
		}
	}
	// makes sure the cell is among the possibilities
	public boolean isValidCell(String input)
	{
		String[] numbers = new String[ROWS];
		for(int i = 0; i < ROWS; i++)
		{
			numbers[i] = i + "";
		}
		if(input.equals(""))
		{
			return false;
		}
		for(String letter : letters)
		{
			if(letter.equals(input.substring(0, 1)))
			{
				for(String number : numbers)
				{
					if(number.equals(input.substring(1, 2)))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	// gets the value of whatever cell you want it to	
	public void getValue(String position)
	{
		int row;
		int col = 0;
		for(int i = 0; i<letters.length; i++)
		{
			if(letters[i].equals(position.substring(0,1)))
			{
				col = i+1;
			}
		}
		col-=1;
		row = Integer.parseInt(position.substring(1)) -1 ;
		if(data[row][col] == null)
		{
			System.out.println(position + " = <empty>");
		}
		else 
		{
			System.out.println(position + " = " + data[row][col]);
		}
	}

    public static void main(String[] args) 
    {
        // these lines should create a spreadsheet, add 3 cells to it,
        // and print the whole grid. 
    	Spreadsheet sheet = new Spreadsheet();
    	CellFactory factory = new CellFactory();
    	Cell b8 = factory.makeCell("1234");
    	Cell a1 = factory.makeCell("\"hi\"");
    	sheet.createCell("B8", b8);
    	sheet.createCell("A1", a1);
    	sheet.data[3][6] = factory.makeCell("42");
    	sheet.data[7][4] = factory.makeCell("3/30/2016");
    	sheet.print();
    }
}