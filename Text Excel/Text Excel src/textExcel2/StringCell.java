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

public class StringCell extends Cell
{
    String value;
    
    // Constructor
    public StringCell (String userInput)
    {
        super(userInput);
        value = userInput.substring(1, userInput.length()-1);
    }
    
    // gets sheet value
    public String getSheetValue()
    {
        return value;
    }
    
    public static void main(String[] args)
    {
    	StringCell c1 = new StringCell("\"asdf\"");
    	System.out.println(c1.getSheetValue());
    }
}