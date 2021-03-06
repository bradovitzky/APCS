/**********************************************************
 * Assignment: Traveller
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class Traveller extends UrRobot
{
	public Traveller(int street, int avenue, Direction direction, int beepers)
	{
		super(street, avenue, direction, beepers);
	}

	public void moveMile()
	{
		// remembering that a mile is 8 blocks long
		move();
		move();
		move();
		move();
		move();
		move();
		move();
		move();
	}
	public void moveDecaMile(){
		moveMile();
		moveMile();
		moveMile();
		moveMile();
		moveMile();
		moveMile();
		moveMile();
		moveMile();
		moveMile();
		moveMile();	
	}
	public void moveHectaMile(){
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
		moveDecaMile();
	}

	public void moveBackward()
	{
		// which moves Karel one block backward, but leaves it facing the same direction
		turnLeft();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
	}

	public void moveKiloMile()
	{
		// which moves Karel 1000 miles forward – use your brain, NOT brute force!
		// you will probably want to include some additional methods in order to do this
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();
		moveHectaMile();	
	}

	public static void main(String[] args)
	{
		World.setVisible(true);
		World.setDelay(42); // There's just something about that number...

		Traveller karel = new Traveller(2,2,East,0);
		karel.moveBackward();
		karel.moveMile();
		karel.moveKiloMile();
		karel.turnOff(); // Don't waste electricity!

	}

}
