/* Amelie Buc
December 2017
Describes the date (mm/dd/yy) using object-oriented programming and user interface windows.
AP CS - Java
*/
import javax.swing.*;  

public class DateExercise{
  public static void main (String [] args){
    int m = 0;
    m = Input.getInt("Please enter the number of the month: ");
    int d = 0;
    d = Input.getInt("Please enter the day: ");
    int y = 0;
    y = Input.getInt("Please enter the year: ");

    //create a Date object and assign it to theDate
    Date theDate = new Date();

    //display the month/day/year
    theDate.setDate(m,d,y);
    System.out.println(theDate.getMonth());
    JOptionPane.showMessageDialog(null, theDate.displayMessage(m,d,y));
  }
}
