/**********************************************************
 * Assignment: StairSweeper
 *
 * Author: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package karel;

import kareltherobot.*;

public class StairSweeper extends UrRobot
{
    public StairSweeper(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }

    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void climbStair()
    {
        turnLeft();
        move();
        turnRight();
        move();
    }

    public static void main(String [] args)
    {
        World.readWorld("WorldFiles/fig3-1.kwld");
        World.setVisible(true);

        StairSweeper Alex = new StairSweeper(1, 1, East, 0);
        World.setDelay(20);

        Alex.climbStair();
        Alex.pickBeeper();
        Alex.climbStair();
        Alex.pickBeeper();
        Alex.climbStair();
        Alex.pickBeeper();
        Alex.turnOff();
    }
}