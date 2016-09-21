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
			else
			{
				turnLeft();
			}
		}
	}

	public void jumpHurdle()
	{
		findCorner();
		putAndMove();
		turnRight();
		findCorner();
		putAndMove();
		turnRight();
		findCorner();
	}

	public static void main(String[] args)
	{
		MakeHurdles temp = new MakeHurdles();
		World.readWorld("hurdlesx.kwld");
		World.setVisible(true);

		Filler Frank = new Filler(1, 1, East, infinity);
		World.setDelay(1);

		// pre: Frank is doing street one, starting at the origin facing East
		// post: Frank has finished the first row, and is sitting on top of the
		// beeper on street 1
		while (!Frank.nextToABeeper())
		{
			if (Frank.frontIsClear())
			{
				Frank.putAndMove();
			}
			Frank.jumpHurdle();
		}
		Frank.moveUpAndTurnAround();
		while (!Frank.nextToABeeper())
		{
			Frank.putAndMove();
		}

	}

	private void moveUpAndTurnAround()
	{
		if (facingEast())
		{
			turnLeft();
			move();
			turnLeft();
		}
		else if (facingWest())
		{
			turnRight();
			move();
			turnRight();
		}
	}

}