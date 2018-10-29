/*
 *Name: convert:java                              Author: Aishat Mohammed
 *
 *
 *Converts Array form for availability to String format and vice versa. 
 *The times are 6 am to 12am per day for a week.
 */
import java.util.*;

public class convert
{
    public boolean[][] dateArray = new boolean[7][36];
    public String dates = new String();
    public int count = 0;

    public void convert()
    {
      dates = new String();
    }

    /*Name: convertString
     *parameters: String parameter of length 252
     *returns: 7 by 36 boolean array
     *
     *description: converts String to a 7 by 36 array
     */
    
 public boolean[][] convertString(String data)
 {   
     int len = data.length();
     if(len != 252)
     {
       System.out.println("invalid number of input!");
       System.exit(0);
     }
     char part;
     char tru = '1';
     char fal = '0';
     
     for(int i = 0; i < 7; i++)
       for(int j = 0; j < 36; j++)
     {
       part = data.charAt(count);
   
       if(part == tru)
         dateArray[i][j] = true;
       else if(part == fal)
         dateArray[i][j] = false;
       else
       {
         System.out.println("invalid input detected!");
         System.exit(0);
       }
       
       count++;
     }
     
     return dateArray;
 }

    /*Name: convertArray
     *parameters: 7 by 36 boolean array
     *returns: String parameter of length 252
     *
     *description: converts 7 by 36 array to a  String
     */
 public String convertArray(boolean[][] booldateArray)
 {
     for(int i = 0; i < 7; i++)
       for(int j = 0; j < 36; j++)
     {
       if(booldateArray[i][j] == true)
         dates += "1";
       else if(booldateArray[i][j] == false)
       {
         //System.out.println("The date is false");
         dates += "0";
       }
       else
       {
         System.out.println("invalid value in array detected!");
         System.exit(0);
       }
      }
      
     return dates;
 }
}
