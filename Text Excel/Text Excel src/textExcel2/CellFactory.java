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

import java.text.SimpleDateFormat;
import java.util.Date;

public class CellFactory
{
    /**
     * Takes the userValue supplied and figures out what kind of Cell to make
     * @param userValue - part of the command on the right side of the equal sign
     * @return the appropriate type of Cell based on the userValue
     */
    public Cell makeCell(String value)
    {
        //replace "true" with a test for quotes at the beginning and end if (text.charAt(0) == '"' && text.charAt(text.length()-1) == '"')

        if (value.charAt(0) == '"' && value.charAt(value.length()-1) == '"')
        {
            return new StringCell(value);
        }
        // the code below correctly prints "It's a number!" if text is
        // a number. You don't need to change it.

        try // see if its a double
        {
            double test = Double.parseDouble(value);
            return new NumberCell(value);
        }
        catch (Exception e)
        {
            // not a double
        }
        // This try/catch block should print It's a date! if the text is a date. 
        try
        {
            // This SimpleDateFormat object is already created for you.
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            
            Date test = format.parse(value);
            return new DateCell(value);
        }
        catch (Exception ex)
        {
            // it wasn't a date
        }
        
        throw new IllegalArgumentException("Not valid for any Cell type: " + value);
    }
}