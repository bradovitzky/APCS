/**********************************************************
 * Assignment: Fractional Calculator
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package fracCalc4;
import java.util.*;
public class FractionalCalculator
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.print("Enter an expression (or \"quit\"): ");
		String input = console.nextLine();
		while(!input.equals("quit"))
		{
			//THIS IS EXTRA CREDIT
			if (input.equals("help"))
			{
				System.out.println();
				System.out.println("This program is designed to take fractions or mixed numbers and perform operations to them.");
				System.out.println("It takes mixed numbers in the form a_b/c, and fractions in the form a/b. Negatives are permitted.");
				System.out.println("The only operators that this program accepts are: +, -, *, and /.");
				System.out.println();
				System.out.print("Enter your next operation: ");
				input = console.nextLine();
			}
			
			while (input.indexOf("+") == -1 && input.indexOf("-") == -1  && input.indexOf("*") == -1 && input.indexOf("/") == -1)
			{
				System.out.println("No operator detected. Type \"help\" for information.");
				System.out.println("Try again: ");
				input = console.nextLine();
			}

			//
			
			String frac1 = input.substring(0, input.indexOf(" "));
			String operator = input.charAt(input.indexOf(" ") + 1) + "";
			String frac2 = input.substring(input.indexOf(" ", input.indexOf(" ") + 1) + 1); //Finds second " " and starts frac2 after it

			frac1 = convertToFraction(frac1);
			frac2 = convertToFraction(frac2);

			String answer = calculate(frac1, operator, frac2);

			String reducedAnswer = reduce(answer);
			String finalAnswer = convertToMixed(reducedAnswer);
			
			System.out.println(finalAnswer);
			System.out.print("Enter an expression (or \"quit\"): ");
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
		//int positivity = Positivity(input);
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
			if(numerator < 0 && whole == 0)
			{
				ansNum = (whole * denominator) + numerator;
			}
			else if(whole < 0)
			{
				ansNum = (whole * denominator) - numerator;
			}
			else
			{
				ansNum = (whole * denominator) + numerator;
			}
			String answer = ansNum + "/" + denominator;
			return answer;
		}
	}
	
	public static String multiply(String frac1, String frac2)
	{
		int numerator = getNumerator(frac1) * getNumerator(frac2);
		int denominator = getDenominator(frac1) * getDenominator(frac2);
		String answer = numerator + "/" + denominator;
		return answer;
	}
	public static String divide(String frac1, String frac2)
	{
		int numerator = getNumerator(frac1) * getDenominator(frac2);
		int denominator = getDenominator(frac1) * getNumerator(frac2);
		String answer = numerator + "/" + denominator;
		return answer;
	}
	public static String add(String frac1, String frac2)
	{
		int denominator = getDenominator(frac1) * getDenominator(frac2);
		int numerator = (getNumerator(frac1) * getDenominator(frac2)) + (getNumerator(frac2) * getDenominator(frac1));
		String answer = numerator + "/" + denominator;
		return answer;
	}
	public static String subtract(String frac1, String frac2)
	{
		int denominator = getDenominator(frac1) * getDenominator(frac2);
		int numerator = (getNumerator(frac1) * getDenominator(frac2)) - (getNumerator(frac2) * getDenominator(frac1));
		String answer = numerator + "/" + denominator;
		return answer;
	}
	
	public static String calculate(String left, String operator, String right)
	{
		String answer;
		if (operator.equals("+"))
		{
			answer = add(left, right);
		}
		else if (operator.equals("-"))
		{
			answer = subtract(left, right);
		}
		else if (operator.equals("*"))
		{
			answer = multiply(left, right);
		}
		else if (operator.equals("/"))
		{
			answer = divide(left, right);
		}
		else
		{
			answer = "Incorrect operand!";
		}
		
		return answer;
	}
	
	public static int gcf(int smaller, int bigger)
	{
		int greatestSoFar = 1;

		for (int i = 1; i <= smaller; i++)
		{
			if (smaller % i == 0 && bigger % i == 0)
			{
			    greatestSoFar = i;
			}
		}
		return greatestSoFar;
	}
	
	public static String reduce(String fraction)
	{
		
		int num = getNumerator(fraction);
		int den = getDenominator(fraction);
		int bigger;
		int smaller;
		if(num > den)
		{
			bigger = Math.abs(num);
			smaller = Math.abs(den);
		}
		else
		{
			bigger = Math.abs(den);
			smaller = Math.abs(num);
		}
		num /= gcf(smaller, bigger);
		den /= gcf(smaller, bigger);
		
		return num + "/" + den;
	}

	public static String convertToMixed(String fraction)
	{
		int num = getNumerator(fraction);
		int den = getDenominator(fraction);
		if (num < den && !(num<=0))
		{
			return fraction;
		}
		else
		{
			int whole;
			int newNum = 0;
			int positivity = Positivity(num+ "");
			while (num%den != 0)
			{
				if (num<0)
				{
					num++;
				}
				else
				{
					num--;
				}
				newNum++;
			}
			whole = num/den;
			if (whole == 0 && newNum !=0)
			{
				return positivity*newNum + "/" + den;
			}
			else if (newNum == 0)
			{
				return whole + "";
			}
			else
			{
				return whole + "_" + newNum + "/" + den;
			}
		}
	}
}
