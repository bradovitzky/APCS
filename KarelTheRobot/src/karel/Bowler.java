/**********************************************************
 * Assignment: Bowler
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class Bowler extends UrRobot
{
	public Bowler(int street, int avenue, Direction direction, int beepers)
	{
		super(street, avenue, direction, beepers);
	}
	
	public void turnRight(){
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	public void placeRowOne()
	{
		move();
		putBeeper();
		turnLeft();
		move();
		turnRight();
		move();
		turnRight();
	}
	
	public void placeRowTwo()
	{
		putBeeper();
		move();
		move();
		putBeeper();
		move();
		turnLeft();
		move();
		turnLeft();
	}
	
	public void placeRowThree()
	{
		putBeeper();
		move();
		move();
		putBeeper();
		move();
		move();
		putBeeper();
		move();
		turnRight();
		move();
		turnRight();
	}
	
	public void placeRowFour()
	{
		putBeeper();
		move();
		move();
		putBeeper();
		move();
		move();
		putBeeper();
		move();
		move();
		putBeeper();
	}
	
	public void moveToEnd()
	{
		turnLeft();
		move();
		turnLeft();
		move();
		move();
		move();
		turnLeft();
		turnOff();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		World.setVisible(true);
		World.setDelay(20);
		
		Bowler karel = new Bowler(1,5,North,10);
		
		karel.placeRowOne();
		karel.placeRowTwo();
		karel.placeRowThree();
		karel.placeRowFour();
		karel.moveToEnd();
	}

}
