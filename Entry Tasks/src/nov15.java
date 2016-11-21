
public class nov15
{
	public static int rollFrequency(int[] rolls, int target)
	{
		int times = 0;
		for(int i=0; i<rolls.length; i++)
		{
			if(rolls[i] == target)
			{
				times ++;
			}
		}
		return times;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
