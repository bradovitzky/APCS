package fracCalc1;
import java.util.*;
public class FractionalCalculator
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.println("Enter an expression (or \"quit\"): ");
		String input = console.next();
		while(!input.equals("quit"))
		{
			System.out.println("Left operand: 1_1/2");
			System.out.println("Operator: +");
			System.out.println("Right operand: 3/4");
			System.out.println();
			System.out.println("Left operand: 0");
			System.out.println("Operator: *");
			System.out.println("Right operand: -4_4/5");
			System.out.println("Goodbye!");
		}

	}

}
