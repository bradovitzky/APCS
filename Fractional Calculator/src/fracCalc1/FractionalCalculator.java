package fracCalc1;
import java.util.*;
public class FractionalCalculator
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.println("Enter an expression (or \"quit\"): ");
		String input = console.nextLine();
		
		String frac1 = input.substring(0, input.indexOf(" "));
		char operator = input.charAt(input.indexOf(" ") + 1);
		String frac2 = input.substring(input.indexOf(" ", input.indexOf(" ") + 1) + 1); //Finds second " " and starts frac2 after it
		
		if(!input.equals("quit"))
		{
			System.out.println("Left operand: " + frac1);
			System.out.println("Operator: " + operator);
			System.out.println("Right operand: " + frac2);
			System.out.println();
			
			System.out.println("Goodbye!");
		}

	}public static int getWhole(String input)
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

}
