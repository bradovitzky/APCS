package karel;

import kareltherobot.*;

public class HurdleJumper extends Robot
{
	public HurdleJumper(int street, int avenue, Direction dir, int beeps)
    {
        super(street, avenue, dir, beeps);
    }
	
	public void jumpHurdle()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World.readWorld("WorldFiles/fig6-22.kwld");
		World.setVisible(true);

    	HurdleJumper Harry = new HurdleJumper(1, 1, East, 0);
    	World.setDelay(1);
    	
    	// precondition: Harry is not at the end of the file and at the beginning of a hurdle on street 1
    	// postcondition: Harry is at the end of the program
		while (!Harry.nextToABeeper())
		{
			Harry.jumpHurdle();
		}
		Harry.turnOff();
	}

}