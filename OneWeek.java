/*
 * File Name: OneWeekPanel.java
 * Author:    Vistassja Williams
 * Purpose:   This is the class that creates one week of date objects. 
 * Date:      October 23, 2018 
 */

import java.util.*;

public class OneWeek extends Date
{
  private String[] months; // This is the String version of the integer output that the Date object will give me.
  private int[] days_of_month;// This is the number that represents which day of the month it is. 
  private int[] years; // The Year.
  private int[] days_of_week; // indicates which number day of the week it is(eg. 1'st day of the week)
  
  public OneWeek()
  {
          months = new String[7];
          days_of_month = new int[7];
          years= new int[7];
          days_of_week = new int[7];
  }
  
  // Creates a Calendar with 7 days out of the week
  public void createWeek()
  {
    Calendar c1 = Calendar.getInstance();
    int count = 0;
   while(count != 7)
   {
     switch(c1.get(Calendar.MONTH)) // They start at 0 for some reason.
     {
       case 0:
         months[count] = "January";
         break;
       case 1:
         months[count] = "February";
         break;
       case 2:
         months[count] = "March";
         break;
       case 3:
         months[count] = "April";
         break;
       case 4:
         months[count] = "May";
         break;
       case 5:
         months[count] = "June";
         break;
       case 6:
         months[count] = "July";
         break;
       case 7:
         months[count] = "August";
         break;
       case 8:
         months[count] = "September";
         break;
       case 9:
         months[count] = "October";
         break;
       case 10:
         months[count] = "November";
         break;
       case 11:
         months[count] = "December";
         break;
       default:
         months[count] = "";
     }
     days_of_month[count] = c1.get(Calendar.DATE);
     years[count] = c1.get(Calendar.YEAR);
     days_of_week[count] = c1.get(Calendar.DAY_OF_WEEK);    
     c1.add(Calendar.DATE, 1); // Getting the next day.
     count++;
   }
  }
  
  // Gets the year for the index indicated.
  // This is assuming the days begin at 0 and end at 6. 
  public int get_year(int index)
  {
    return years[index];
  }
  // Gets the day of the month for the index indicated.
  // This is assuming the days begin at 0 and end at 6. 
  public int get_day_of_month(int index)
  {
    return days_of_month[index];    
  }
  // Gets the day of the week for the index in the week array.
  // The first element is today. This is assuming the days begin at 0 and end at 6. 
  public int get_day_of_week(int index)
  {
    return days_of_week[index];    
  }
  //Gets the month for the index in the week array.
  public String get_month(int index)
  {
    return months[index];
  }
  //Prints the dates for every day of the week.
  // Purely for debugging purposes.
   public void print_entire_week()
  {
     System.out.println("Date                     Day of Week ");
     for (int i = 0; i < 7; i++)
     {
       System.out.println(get_month(i) +" "+ get_day_of_month(i) +" "+ get_year(i) +"        "+
                          get_day_of_week(i));
     }
  }
}

   
