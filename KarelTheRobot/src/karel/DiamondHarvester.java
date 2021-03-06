/**********************************************************
 * Assignment: DiamondHarvester
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class DiamondHarvester extends UrRobot
{
	
    public DiamondHarvester(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }

    // Add methods here to support the plan in your main method to solve the problem

    public void harvestCorner()
    {

    	move();
    	turnLeft();
    	move();
    	turnRight();
    	pickBeeper();
    }
    public void harvestRow()
    {
    	pickBeeper();
    	harvestCorner();
    	harvestCorner();
    	harvestCorner();
    }
    
    public void turnRight()
    {
    	turnLeft();
    	turnLeft();
    	turnLeft();
    }
    
    public void prepForEvenRow()
    {
    	turnLeft();
    	move();
    	turnLeft();
    	move();
    }
    
    public void prepForOddRow()
    {
    	move();
    	turnRight();
    	move();
    	turnRight();
    }
    
    
    public void harvestFour()
    {
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
    	World.readWorld("WorldFiles/fig3-5.kwld");
    	World.setVisible(true);

    	DiamondHarvester Dave = new DiamondHarvester(2, 2, East, 0);
    	World.setDelay(10);
    	
    	Dave.move();
    	Dave.move();
    	Dave.move();
    	Dave.move();
    	Dave.harvestFour();
        Dave.move();
        Dave.turnOff();
    }

}