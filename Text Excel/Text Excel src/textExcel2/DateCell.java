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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCell extends Cell
{
    Date date;
    
    // constructor
    public DateCell (String userInput) throws ParseException
    {
        super(userInput);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        date = format.parse(userInput);
    }
    
    // returns the sheet value
    public String getSheetValue()
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return format.format(date);
    }
}