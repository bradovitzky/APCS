/**********************************************************
 * Assignment: HurdleJumper
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class HurdleJumper extends Robot
{
	public HurdleJumper(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }
	
	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void findCorner()
	{
		while (!frontIsClear())
		{
			turnLeft();
			if (frontIsClear())
			{
				move();
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
		move();
		turnRight();
		findCorner();
		move();
		turnRight();
		findCorner();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World.readWorld("WorldFiles/fig6-22.kwld");
		World.setVisible(true);

    	HurdleJumper Harry = new HurdleJumper(1, 1, East, 0);
    	World.setDelay(1);
    	
    	System.out.println(4/3);
    	// precondition: Harry is not at the end of the file and on street 1
    	// postcondition: Harry is at the end of the program
		while (true)
		{
			// precondition: Harry is on street 1 facing east
			// postcondition: Harry is in front of a hurdle
			if (Harry.frontIsClear() && !Harry.nextToABeeper())
			{
				Harry.move();
			}
			else if (!Harry.frontIsClear())
			{
				Harry.jumpHurdle();
			}
			else
			{
				Harry.pickBeeper();
				Harry.turnOff();
			}
		}
	}

}
