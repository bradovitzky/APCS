package karel;

import kareltherobot.*;

//This robot task is from page 11 in the text
public class PSet_2b implements Directions
{

public static void main(String[] args)
{
	// World file (leave out the readWorld line if you just want a blank world)
	World.readWorld("WorldFiles/fig2-9.kwld");
	World.setVisible(true);
	World.setDelay(50);

	UrRobot karel = new UrRobot(1,2,East,1);
	// Your instructions to complete this task should go below this line
	karel.move();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.putBeeper();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.move();
	karel.turnLeft();
	karel.turnLeft();
	karel.turnLeft();
	karel.move();
	karel.move();
	karel.turnLeft();
	karel.turnOff();

}

}
