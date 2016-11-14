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

public class TextExcel
{

    public static void main(String[] args)
    {
        // show the welcome message
    	System.out.println("Welcome to TextExcel!");
        Scanner console = new Scanner(System.in);
        Spreadsheet sheet = new Spreadsheet();
    	System.out.print("Enter a command: ");
        String command = commandPrompt(console);
        // get a command - you might want to make this a method
        // that shows a prompt and returns the string the user entered
        // while the command does not equal "quit" do the following
    	while(!command.equals("quit"))
        {
    		doCommand(command, sheet);
            // do something with the command - again, you might want to
            //    make this a method
            // get another command
        	System.out.print("Enter a command: ");
        	command = commandPrompt(console);
        }
        
        System.out.println("Farewell!");
        console.close();
    }
    
	// here is where you might define a method that gets a command
    //    and shows a prompt first (you'd need to pass in the console
    //    and return command, of course)
    private static String commandPrompt(Scanner console)
    {
    	String command = console.nextLine();
    	return command;
    }
    
    public static boolean isCellCommand(String input)
    {
    	String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
    	if(input.equals(""))
		{
			return false;
		}
    	for(String letter : letters)
    	{
    		if(letter.equals(input.substring(0,1)))
    		{
    			for(int i = 0; i<=10; i++)
    			{
    				if(input.indexOf("=") == -1)
    				{
    					if(Integer.parseInt(input.substring(1)) == i)
        				{
        					return true;
        				}
    				}
    				else if(Integer.parseInt(input.substring(1,input.indexOf(' '))) == i)
    				{
    					return true;
    				}
    			}
    		}
    	}
		return false;
    }
    
    private static void doCommand(String command, Spreadsheet sheet)
    {
        CellFactory factory = new CellFactory();
    	if(command.equals("print"))
		{
			printSheet(sheet);
		}
    	else if(command.indexOf('=') == -1 && isCellCommand(command))
    	{
    		sheet.getValue(command);
    	}
		else if(isCellCommand(command))
		{
			String position = command.substring(0, command.indexOf(' '));
			String contents = command.substring(command.indexOf('=') + 2);
			Cell newCell = factory.makeCell(contents);
			sheet.createCell(position, newCell);
		}
		else
		{
			System.out.println("Invalid Command.");
		}
    }
    // here is where you might define a method for doing something with
    //    the command (you'd need to pass in the command and the sheet)
    private static void printSheet(Spreadsheet sheet)
    {
        sheet.print();
    }

}