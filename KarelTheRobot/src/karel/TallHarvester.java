/**********************************************************
 * Assignment: TallHarvester
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class TallHarvester extends UrRobot
{
	
    public TallHarvester(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }

    // Add methods here to support the plan in your main method to solve the problem

    public void pickFive()
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
    
    public void harvestRow()
    {
    	pickFive();
    }
    
    
    public void harvestEight()
    {
    	harvestRow();
    	prepForEvenRow();
        harvestRow();
        prepForOddRow();
        harvestRow();
        prepForEvenRow();
        harvestRow();
        prepForOddRow();
        harvestRow();
        prepForEvenRow();
        harvestRow();
        prepForOddRow();
        harvestRow();
        prepForEvenRow();
        harvestRow();
    }

    public static void main(String [] args)
    {
    	World.readWorld("WorldFiles/fig3-3b.kwld");
    	World.setVisible(true);

    	TallHarvester Tom = new TallHarvester(2, 2, East, 0);
    	World.setDelay(10);
    	
    	Tom.harvestEight();
        Tom.move();
        Tom.turnOff();
    }

}