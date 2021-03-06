/**********************************************************
 * Assignment: Fractional Calculator
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package fracCalc2;
import java.util.*;
public class FractionalCalculator
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.println("Enter an expression (or \"quit\"): ");
		String input = console.nextLine();
		while(!input.equals("quit"))
		{
			String frac1 = input.substring(0, input.indexOf(" "));
			char operator = input.charAt(input.indexOf(" ") + 1);
			String frac2 = input.substring(input.indexOf(" ", input.indexOf(" ") + 1) + 1); //Finds second " " and starts frac2 after it
			
			System.out.println("Left operand: " + frac1);
			System.out.println("Operator: " + operator);
			System.out.println("Right operand: " + frac2);
			
			System.out.println();
			System.out.println("Enter an expression (or \"quit\"): ");
			input = console.nextLine();
		}
		System.out.println("Goodbye!");
	}
	public static int getWhole(String input)
	{
		int underscoreIndex = input.indexOf("_");
		int slashIndex = input.indexOf("/");
		
		if(underscoreIndex == -1 && slashIndex != -1)
		{
			return 0;
		}
		else if(underscoreIndex == -1 && slashIndex == -1)
		{
			return Integer.parseInt(input);
		}
		else
		{
			String number = input.substring(0, underscoreIndex);
			return Integer.parseInt(number);
		}
	}
	
	public static int getNumerator(String input)
	{
		int underscoreIndex = input.indexOf("_");
		int slashIndex = input.indexOf("/");
		
		String numerator;
		if(underscoreIndex == -1)
		{
			numerator = input.substring(0, slashIndex);
			return Integer.parseInt(numerator);
		}
		else
		{
			numerator = input.substring(underscoreIndex + 1, slashIndex);
			return Integer.parseInt(numerator);
		}
	}
	
	public static int getDenominator(String input)
	{
		int slashIndex = input.indexOf("/");
		
		return Integer.parseInt(input.substring(slashIndex + 1));
	}
	public static int Positivity(String input)
	{
		if (input.charAt(0) == '-')
		{
			 return -1;
		}
		else
		{
			return 1;
		}
		
	}
	public static String convertToFraction(String input)
	{
		int positivity = Positivity(input);
		int whole = getWhole(input);
		if(input.indexOf("/") == -1)
		{
			return whole + "/1";
		}
		else
		{
			int numerator = getNumerator(input);
			int denominator = getDenominator(input);
			int ansNum;
			if(numerator < 0 || whole < 0)
			{
				ansNum = (whole * denominator) - numerator;
			}
			else
			{
				ansNum = (whole * denominator) + numerator;
			}
			ansNum *= positivity;
			String answer = ansNum + "/" + denominator;
			return answer;
		}
	}

}
