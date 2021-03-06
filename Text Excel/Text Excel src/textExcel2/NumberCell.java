/**********************************************************
 * Assignment: TextExcel
 *
 * Authors: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/
package textExcel2;

public class NumberCell extends Cell
{
    double value;
    
    // Constructor
    public NumberCell(String userInput)
    {
        super(userInput);
        value = Double.parseDouble(userInput);
    }
    
    // gets the "sheet value" and returns it as a string
    public String getSheetValue()
    {
        return value+"";
    }
    
    public static void main(String[] args)
    {
    	NumberCell b1 = new NumberCell("1234");
    	System.out.println(b1.getSheetValue());
    }
}