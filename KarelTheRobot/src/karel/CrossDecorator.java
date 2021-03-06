/**********************************************************
 * Assignment: CrossDecorator
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
public class CrossDecorator extends UrRobot {
	
	public CrossDecorator(int street, int avenue, Direction direction, int beepers){
		super(street, avenue, direction, beepers);
	}
	
	public void harvestThree(){
		move();
		putBeeper();
		move();
		putBeeper();
		move();
		putBeeper();
	}
	
	public void turnRight(){
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	public void reachCross(){
		turnLeft();
		move();
		move();
		move();
		move();
		turnLeft();
		putBeeper();
	}
	
	public void traverseAngle(){
		harvestThree();
		turnRight();
		harvestThree();
	}
	
	public void roundCorner(){
		turnLeft();
		move();
		putBeeper();
		turnLeft();
	}
	
	public void traverseCross(){
		traverseAngle();
		roundCorner();
		traverseAngle();
		roundCorner();
		traverseAngle();
		roundCorner();
		traverseAngle();
	}
	public void returnHome(){
		turnRight();
		move();
		move();
		move();
		turnLeft();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World.readWorld("WorldFiles/fig3-8.kwld");
		World.setVisible(true);
		World.setDelay(20);
		
		CrossDecorator karel = new CrossDecorator(2,2,South,28);
		
		karel.reachCross();
		karel.traverseCross();
		karel.returnHome();
		karel.turnOff();
	}

}
