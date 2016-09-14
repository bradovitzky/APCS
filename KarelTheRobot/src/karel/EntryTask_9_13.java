package karel;

import kareltherobot.*;

public class EntryTask_9_13 extends Robot
{

    public EntryTask_9_13(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }
    
    public void Prob1()
    {
    	if (!frontIsClear())
    	{
    		pickBeeper();
    		move();
    	}
    }
    
    public void Prob2()
    {
    	if (nextToABeeper())
    	{
    		pickBeeper();
    	}
    	else
    	{
    		turnLeft();
    	}
    	move();
    }
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}