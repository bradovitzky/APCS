public class november14
{
	public static int[] DiceRolls(int howMany)
	{
		int[] rolls = new int[howMany];
		for(int roll=0; roll<howMany; roll++)
		{
			rolls[roll] = (int)(Math.random()*6) + 1;
		}
		return rolls;
	}
}
