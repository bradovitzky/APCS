/**********************************************************
 * Assignment: SparseHarvester
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class SparseHarvester extends Robot
{
	
    public SparseHarvester(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }

    // Add methods here to support the plan in your main method to solve the problem

    public void checkAndMove()
    {
    	if (nextToABeeper())
    	{
    		pickBeeper();
    		move();
    	}
    	else
    	{
    		move();
    	}
    }
    public void harvestRow()
    {
    	checkAndMove();
    	checkAndMove();
    	checkAndMove();
    	checkAndMove();
    	checkAndMove();
    	checkAndMove();
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
    	World.readWorld("WorldFiles/fig5-1.kwld");
    	World.setVisible(true);

    	SparseHarvester Steve = new SparseHarvester(2, 2, East, 0);
    	World.setDelay(10);
    	
    	Steve.harvestSix();
        Steve.move();
        Steve.turnOff();
    }

}