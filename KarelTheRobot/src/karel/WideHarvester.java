/**********************************************************
 * Assignment: WideHarvester
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class WideHarvester extends UrRobot
{
	
    public WideHarvester(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }

    public void pickSeven()
    {
    	move();
    	pickBeeper();
    	move();
    	pickBeeper();
    	move();
    	pickBeeper();
    	move();
    	pickBeeper();
    	move();
    	pickBeeper();
    	move();
    	pickBeeper();
    	move();
    	pickBeeper();
    	move();
    	pickBeeper();
    }
    
    public void turnRight()
    {
    	turnLeft();
    	turnLeft();
    	turnLeft();
    }
    
    public void prepForEvenRow()
    {
    	move();
    	turnLeft();
    	move();
    	turnLeft();
    }
    
    public void prepForOddRow()
    {
    	move();
    	turnRight();
    	move();
    	turnRight();
    }
    
    public void harvestSix()
    {
    	pickSeven();
    	prepForEvenRow();
        pickSeven();
        prepForOddRow();
        pickSeven();
        prepForEvenRow();
        pickSeven();
        prepForOddRow();
        pickSeven();
        prepForEvenRow();
        pickSeven();
    }

    public static void main(String [] args)
    {
    	World.readWorld("WorldFiles/fig3-3a.kwld");
    	World.setVisible(true);

    	Harvester Will = new Harvester(2, 2, East, 0);
    	World.setDelay(10);

    	//
    	// Add calls to methods that represent your plan for solving the problem
    	//
    	Will.harvestSix();
        Will.move();
        Will.turnOff();
    }

}