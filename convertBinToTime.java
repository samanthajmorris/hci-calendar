/*
 * File Name:	convertBinToTime
 * Author:		
 * Purpose:		For testing purposes.
 * Date:		October 29, 2018
 */

public class convertBinToTime
{
	public static void main(String args[])
	{
		String[] times = { "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM","8:00 AM", "8:30 AM","9:00 AM", 
				"9:30 AM","10:00 AM", "10:30 AM","11:00 AM","11:30 AM", "12:00 AM", "12:30 AM", "1:00 PM", "1:30 PM", 
				"2:00 PM","2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM",
				"7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM","11:00 PM", 
		"11:30 PM"}; 

	}
	
	// Day must be 0 to 6.
	public String convertbintotime(String bin, int day, String[] times)
	{
		String ret_times = new String();
		int increments = 36;
		int start, end;
		if (bin.length() != 252)
		{
			System.out.println("Invalid length!");
			return null;
		}
		start = increments * day;
		end = increments * (day + 1);
		ret_times = "<HTML>";
		for ( int i = start; i < end; i++)
		{
			if (bin.charAt(i) == '1')
			{
				ret_times += times[i] + "  ";
			}
		}      
		ret_times += "<HTML>";
		return ret_times;
	}
}
