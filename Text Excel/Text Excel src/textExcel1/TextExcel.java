/**********************************************************
 * Assignment: TextExcel
 *
 * Authors: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/
package textExcel1;

import java.util.*;

public class TextExcel
{

    public static void main(String[] args)
    {
        // create a new spreadsheet first
        Spreadsheet sheet = new Spreadsheet();
        // show the welcome message
    	System.out.println("Welcome to TextExcel!");
        Scanner console = new Scanner(System.in);
        
        String command = commandPrompt(console);
        // get a command - you might want to make this a method
        // that shows a prompt and returns the string the user entered
        // while the command does not equal "quit" do the following
    	while(!command.equals("quit"))
        {
    		if(command.equals("print"))
    		{
    			printSheet(sheet);
    		}
    		else
    		{
    			System.out.println("Invalid Command.");
    		}
            // do something with the command - again, you might want to
            //    make this a method
            // get another command
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
    	System.out.print("Enter a command: ");
    	String command = console.nextLine();
    	return command;
    }
    
    // here is where you might define a method for doing something with
    //    the command (you'd need to pass in the command and the sheet)
    private static void printSheet(Spreadsheet sheet)
    {
        sheet.print();
    }

}