/**********************************************************
 * Assignment: CompleteProgram
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

// This robot task is from page 11 in the text
public class CompleteProgram extends UrRobot
{
	public CompleteProgram(int street, int avenue, Direction direction, int beepers){
		super(street, avenue, direction, beepers);
	}

	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	public void drawBump()
	{
		putBeeper();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
		turnAround();
	}
	
	public void putFive()
	{
		move();
		putBeeper();
		move();
		putBeeper();
		move();
		putBeeper();
		move();
		putBeeper();
	}
	
	public void turnAround()
	{
		turnLeft();
		turnLeft();
	}
	
	public void drawB()
	{
		putFive();
		turnRight();
		move();
		drawBump();
		drawBump();
		turnAround();
	}
	
	public static void main(String[] args)
	{
		// World file (leave out the readWorld line if you just want a blank world)
		World.readWorld("WorldFiles/fig2-3.kwld");
		World.setVisible(true);
		World.setDelay(10);
		
		CompleteProgram karel = new CompleteProgram(1,4,East,infinity);
		karel.turnLeft();
		karel.drawB();
		karel.move();
		karel.move();
		karel.move();
		karel.move();
		karel.putBeeper();
		karel.turnAround();
		karel.move();
		karel.turnLeft();
		karel.turnOff();
	}
}
