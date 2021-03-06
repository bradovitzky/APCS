package karel;

import kareltherobot.*;
import kareltherobot.Directions.Direction;

public class SuperHarvester extends Robot
{
	public SuperHarvester(int street, int avenue, Direction dir, int beeps)
	    {
	        super(street, avenue, dir, beeps);
	    }

	public void turnRight()
	{
		for (int i=0;i<3;i++)
		{
			turnLeft();
		}
	}
	
	// precondition: done with a certain row, facing either East or West
	// postcondition: at the beginning of the next row, facing the opposite direction
	public void faceOppositeAndMove()
	{
		if (facingEast())
		{
			turnLeft();
			move();
			turnLeft();
			move();
		}
		else if (facingWest())
		{
			turnRight();
			move();
			turnRight();
			move();
		}
	}
	
	// precondition: at the beginning of a non-empty line
	// postcondition: at the beginning of the next line
	public void harvestLine()
	{
		// precondition: there is actually a line where the robot is
		// postcondition: the line is cleared
		while (nextToABeeper())
		{
			pickBeeper();
		}
		move();
		
		if (nextToABeeper())
		{
			harvestLine();
		}
		else
		{
			faceOppositeAndMove();
		}
	}
	
	public void returnToOrigin()
	{
		while(!facingWest())
		{
			turnLeft();
		}
		while(frontIsClear())
		{
			move();
		}
		turnLeft();
		while(frontIsClear())
		{
			move();
		}
		turnLeft();
		turnLeft();
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MakeSuperField temp = new MakeSuperField();
		World.readWorld("superx.kwld");
		World.setVisible(true);

    	SuperHarvester Clark = new SuperHarvester(2, 2, East, 0);
    	World.setDelay(1);

    	Clark.move();
    	// precondition: robot is at the beginning of a line of beepers
    	// postcondition: robot is at the beginning of an empty line
    	while (Clark.nextToABeeper())
    	{
    		Clark.harvestLine();
    	}
    	Clark.returnToOrigin();
    	Clark.turnOff();
	}

}
