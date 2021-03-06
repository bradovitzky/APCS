package karel;

import kareltherobot.*;

public class Filler extends Robot
{

	public Filler(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void putAndMove()
	{
		putBeeper();
		move();
	}

	public void findCorner()
	{
		while (!frontIsClear())
		{
			turnLeft();
			if (frontIsClear())
			{
				putAndMove();
				turnRight();
			}
		}
	}
	public void moveUpAndTurnAround()
	{
		if(facingEast())
		{
			turnLeft();
			move();
			turnLeft();
		}
		else
		{
			turnRight();
			move();
			turnRight();
		}
	}
	public void turnAround()
	{
		turnLeft();
		turnLeft();
	}
	public static void main(String[] args)
	{
		MakeHurdles temp = new MakeHurdles();
		World.readWorld("hurdlesx.kwld");
		World.setVisible(true);

		Filler Frank = new Filler(1, 1, East, infinity);
		World.setDelay(1);
		
		while(!Frank.nextToABeeper())
		{
			Frank.findHurdleOrBeeper();
			if(Frank.nextToABeeper())
			{
				Frank.fillEndSpace();
				break;
			}
			Frank.putBeeper();
			Frank.fillSpace();
			Frank.topOffHurdle();
			Frank.returnToFirstStreet();
		}
	}
	public void returnToFirstStreet()
	{
		while(frontIsClear())
		{
			putAndMove();
		}
		turnLeft();
	}
	public void topOffHurdle()
	{
		move();
		turnRight();
		findCorner();
	}
	//CHANGE THIS METHOD
	public void findHurdleOrBeeper()
	{
		while(frontIsClear() && !nextToABeeper())
		{
			putAndMove();
		}
	}
	public void fillEndSpace()
	{
		int width = 0;
		moveUpAndTurnAround();
		while(frontIsClear())
		{
			move();
			width++;
		}
		turnAround();
		while(nextToABeeper())
		{
			move();
			for(int i=0; i<=width; i++)
			{
				putAndMove();
			}
			putBeeper();
			moveUpAndTurnAround();
			for(int i=0; i<width; i++)
			{
				move();
			}
			moveUpAndTurnAround();
		}
	}
	public void fillSpace()
	{
		while(!frontIsClear())
		{
			int width = 0;
			moveUpAndTurnAround();
			while(frontIsClear())
			{
				move();
				width++;
			}
			turnAround();
			for(int i=0; i<width; i++)
			{
				putAndMove();
			}
			putBeeper();
		}
	}
}
