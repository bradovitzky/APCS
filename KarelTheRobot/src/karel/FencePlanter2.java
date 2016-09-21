/**********************************************************
 * Assignment: FencePlanter
 *
 * Authors: Ben Radovitzky and Lucia Sakakibara
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class FencePlanter2 extends Robot
{
	public FencePlanter2(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public static void main(String[] args)
	{
		// these two lines are already set up for the double layer problem
		MakeRectangle2 temp = new MakeRectangle2();
		World.readWorld("rectanglex.kwld");
		World.setVisible(true);

		FencePlanter2 Felix = new FencePlanter2(1, 1, North, 0);
		World.setDelay(1);

		Felix.findThePile();
		Felix.pickUpThePile();
		Felix.findRectangle();
		for (int i = 0; i < 4; i++)
		{
			Felix.plantASide();
			Felix.plantCorner();
		}
		
		// Move on to bigger rectangle
		Felix.turnRight();
		Felix.move();
		Felix.move();
		Felix.turnLeft();
		for (int i=0; i<4;i++)
		{
			Felix.plantBiggerCorner();
			Felix.plantBiggerSide();
		}
		Felix.turnOff();
	}
	// pre: sitting at the end of a side with no 
	// post: on top of the first beeper of the row in the smaller rectangle
	private void plantBiggerCorner() {
		putBeeper();
		move();
		putBeeper();
		turnLeft();
		move();
	}
	// pre: at the beginning of a side, ready to do some planting
	// post: at the end of a side, prepared for the next one
	private void plantBiggerSide()
	{
		// pre: on top of a beeper in the smaller rectangle
		// post: on top of the next beeper in the smaller rectangle, having planted one on the outer
		while (nextToABeeper())
		{
			turnLeft();
			turnLeft();
			move();
			turnLeft();
			move();
			putBeeper();
			turnLeft();
			move();
		}
	}

	// pre: Robot at empty corner facing down the next side to be planted
	// post: Robot has planted a beeper and setup to start new side (facing
	// wall)
	public void plantCorner()
	{
		putBeeper();
		move();
		turnRight();
	}

	// pre: Robot at first section of wall, facing wall
	// post Robot one past last section of wall, beepers dropped along wall
	public void plantASide()
	{
		while (!frontIsClear())
		{
			putBeeper();
			turnLeft();
			move();
			turnRight();
		}
	}

	// pre: Robot holding all beepers, on street south of rectangle
	// post: Robot next to southern-most section of west side of rectangle
	public void findRectangle()
	{
		move();
		turnRight();
		goToWall();
	}

	// pre: Robot facing a wall some distance away
	// post: Robot has moved to be next to wall
	public void goToWall()
	{
		while (frontIsClear())
		{
			move();
		}
	}

	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	// pre: Robot on pile of beepers
	// post: Robot on same corner carrying all the beepers
	public void pickUpThePile()
	{
		while (nextToABeeper())
		{
			pickBeeper();
		}
	}

	// pre: Robot facing north, a pile somewhere above
	// post: Robot on pile of beepers
	public void findThePile()
	{
		while (!nextToABeeper())
		{
			move();
		}
	}
}