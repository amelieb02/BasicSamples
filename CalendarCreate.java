/* Amelie Buc
* November 3
* This program makes a calendar for a given month.
*Contents: main, print the calendar, print the header (get month name), print the body
*(check if leap year, find number of days in month, then get day on which all starts)
*/


import java.lang.*;
import java.util.Scanner;
public class CalendarCreate

{
  public static void main(String[] args){
    //Prompt user for year (y) and month (m)
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a month 1-12: ");
    int m = input.nextInt();
    System.out.print("Enter a year: ");
    int y = input.nextInt();
    printMonthCalendar(m,y);
  }
    //print the calendar
  public static void printMonthCalendar(int m, int y){
    printMonthHeader(m,y);
    printMonthBody(m,y);

  }

  /*Displays the header
  *information ( month, year, line separator, 3-character day names) for a calendar.
  */

  public static void printMonthHeader(int m, int y){
    System.out.println("\t " + getMonthName(m) + "  "+ y);
    System.out.println("----------------------------------");
    System.out.println(" Sun" + " Mon" + " Tue"+ " Wed"+ " Thu"+ " Fri"+ " Sat");
  }

  /* Returns the name of the month for a specified month number (e.g., returns March for m=3).
  */

  public static String getMonthName(int m){
    String month;
    if (m == 1){
      month = "January";
    }
    else if (m == 2){
      month = "February";
    }
    else if (m == 3){
      month = "March";
    }
    else if (m == 4){
      month = "April";
    }
    else if (m == 5){
      month = "May";
    }
    else if (m == 6){
      month = "June";
    }
    else if (m == 7){
      month = "July";
    }
    else if (m == 8){
      month = "August";
    }
    else if (m == 9){
      month = "September";
    }
    else if (m == 10){
      month = "October";
    }
    else if (m == 11){
      month = "November";
    }
    else{
      month = "December";
    }
    return month;
  }

  public static void printMonthBody(int m, int y){
    //get the first day of the calendar to show up in the right spot
    int startDay = getStartDay(m,1,y);
    int spaces = 0;
    if (startDay < 7) {
      spaces = 4  * startDay;
    }
    String spacesString = "";
    for (int ind = 1; ind <= spaces; ind++){
        spacesString += " ";
    }
    System.out.print(spacesString+"   "+1);

    for (int a = 2; a <= getNumDaysInMonth(m,y); a++){
      //base spacing on what number day we're at
      if (a <= 9){
        System.out.print("   "+ a);
      }
      else{
        System.out.print("  "+a);
      }
      //go to next line if you get to Saturday
      if (getStartDay(m,a,y) == 6){
        System.out.print("\n");
      }
    }
    System.out.print("\n");
  }
//    System.out.println(getStartDay(m,d,y) + " "+ getNumDaysInMonth(m,y));



  //check if leap year
  public static boolean isLeapYear(int y){
    //leap years occur every four years
    if (y%4 ==0){
      return true;
    }
    else{
      return false;
    }
  }

  //get the number of days in a month
  public static int getNumDaysInMonth(int m, int y){
    //if it's a leap year, 31, 30 and 29 days in a month possible
    if (isLeapYear(y) == true){
      if (m%2 ==1){
        int d = 31;
        return d;
      }
      else if (m == 2){
        int d = 29;
        return d;
      }
      else {
        int d = 30;
        return d;
      }
    }
    //otherwise, 31, 28 and 30 days in a month possible
    else {
      if (m%2 ==1){
        int d = 31;
        return d;
      }
      else if (m == 2){
        int d = 28;
        return d;
      }
      else {
        int d = 30;
        return d;
      }
    }
  }

  /* Note on getStartDay!:
   The method getStartDay() implements Zeller's Algorithm for determining the day of the
   week the first day of a month is. The method adjusts Zeller's numbering scheme
   for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
   that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)

   Pre-Conditions: The month value, m,  is 1-12
                         The day value, d, is 1-31, or 1-28, 1-29 for February
                         The year value, y, is the full year (e.g., 2012)

  Post-Conditions: A value of 1-7 is returned, representing the first day of the month
                         1 = Monday, ..., 7 = Sunday
   */
  public static int getStartDay( int m, int d, int y )
  {
    // Adjust month number & year to fit Zeller's numbering system
    if ( m < 3 )
    {
      m = m + 12;
      y = y - 1;
    }

    int k = y % 100;      // Calculate year within century
    int j = y / 100;      // Calculate century term
    int h = 0;            // Day number of first day in month 'm'

    h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) + ( 5 * j ) ) % 7;

    // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
    int dayNum = ( ( h + 5 ) % 7 ) + 1;

    return dayNum;
  }
}
