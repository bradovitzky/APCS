package textExcel1;

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
    
    private void printHeader()
	{
		printDashLine();
		String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
		System.out.print("|");
		
		repeatedChar(' ', 12);
		
		System.out.print("|");
		
		for(int colNum = 0; colNum < COLS; colNum++)
		{
			center(letters[colNum], 12);
			System.out.print("|");
		}
		System.out.println();
		printDashLine();
	}

	private void printDashLine()
	{
		System.out.print("+");
		for(int colNum = 0; colNum < COLS+1; colNum++)
		{
			repeatedChar('-', 12);

			System.out.print("+");
		}
		System.out.println();
		
	}

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
	
    private void printNumberCell(int row)
	{
        System.out.print("|");
		center(row+1+"", 12);
		System.out.print("|");
	}

	private void repeatedChar(char c, int times)
    {
    	for(int i = 0; i < times; i++)
    	{
    		System.out.print(c);
    	}
    }
    
    private void center(String s, int characters)
    {
    	int len = s.length();
    	int spaces = characters - len;
    	repeatedChar(' ', spaces/2);
    	System.out.print(s);
    	repeatedChar(' ', characters-len-spaces/2);
    }
    	
    private void printCell(int row, int col)
    {
        if (data[row][col] == null)
        {
           // this true branch is left for you to code
        	center("", 12);
        }
        else
        {
           // this false branch is left for you to code
        	center(data[row][col].getValue(), 12);
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
    public boolean isCellCommand(String input)
    {
    	String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
    	for(String letter : letters)
    	{
    		if(letter.equals(input.substring(0,1)))
    		{
    			for(int i = 0; i<ROWS; i++)
    			{
    				if(Integer.parseInt(input.substring(1)) == i)
    				{
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    public static void main(String[] args) 
    {
        // these lines should create a spreadsheet, add 3 cells to it,
        // and print the whole grid. 
        Spreadsheet sheet = new Spreadsheet();
        sheet.data[0][0] = new Cell("hi");
        sheet.data[3][6] = new Cell("text");
        sheet.data[7][4] = new Cell("excel");
        sheet.data[5][1] = new Cell("potato");
        
        sheet.print();
    }

}