package unitTestDemo;

// Scanner is an object we can use to read input from
// the console. To use it, we need to import its class
// from java.util.
import java.util.Scanner;

public class Gizmo 
{
	/*
	 * Waits for the user to type something and press Enter, then 
	 * responds with a greeting. The greeting is different depending 
	 * on what the user types.
	 */
	public void greet()
	{
		// create a Scanner called console and read in one
		// line of text from the user. Store the user's text
		// in a variable called input.
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		console.close();
		
		// print out a greeting to the user. What greeting we
		// offer depends on what the user typed--if she typed
		// "Hello", we say "Hello back", and so on.
		if (input.equals("Hello"))
		{
			System.out.println("Hello back");
		}
		else if (input.equals("Hi, Gizmo!"))
		{
			System.out.println("Hi, you!");
		}
		else
		{
			System.out.println("Hey");
		}
	}
	
	/*
	 * All Java programs start with a main method. In this one, we 
	 * create a new Gizmo object called 'g' and tell it to greet 
	 * the user.
	 */
	public static void main(String[] args)
	{
		Gizmo g = new Gizmo();
		g.greet();
	}
}
