/**********************************************************
 * Assignment: PSet_2c
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

//This robot task is from page 11 in the text
public class PSet_2c implements Directions
{

public static void main(String[] args)
{
	// World file (leave out the readWorld line if you just want a blank world)
	World.readWorld("WorldFiles/fig2-12.kwld");
	World.setVisible(true);
	World.setDelay(50);
	
	UrRobot karel = new UrRobot(3,5,North,0);
	
	karel.turnLeft();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnOff();
	
}

}