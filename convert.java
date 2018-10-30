/*
 * Name:	convert:java
 * Author:	Aisha Mohammed
 *
 * Purpose:	Converts Array form for availability to String format and vice versa. 
 *			The times are 6 am to 12am per day for a week.
 */

public class convert
{
	public boolean[][] dateArray = new boolean[7][36];
	public String dates = new String();
	public int count = 0;

	public void convert()
	{
		dates = new String();
	}

	/* Name:		convertString
	 * Parameters:	String parameter of length 252
	 * Returns:		7 by 36 boolean array
	 *
	 * Description:	converts String to a 7 by 36 array */
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

	/* Name:		convertArray
	 * Parameters:	7 by 36 boolean array
	 * Returns:		String parameter of length 252
	 *
	 * Description:	converts 7 by 36 array to a  String */
	public String convertArray(boolean[][] booldateArray)
	{
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 36; j++)
			{
				if(booldateArray[i][j] == true)
					dates += "1";
				else if(booldateArray[i][j] == false)
				{
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
	
	public void backend(boolean [][] array, String name, String path)
	{
		String returnString = convertArray(array);	// convert from true/false array to 1s&0s
		
		SamsFunctions func = new SamsFunctions(name, returnString, path);
		func.addEntry(name, returnString, path);	// add user info to json file
		
		if (path != null)
			returnString = func.calculate(path);	// calculate availability for entire json content
		
		gui_init final_gui = new gui_init(0);
		final_gui.displayFinal(returnString);		// displays final results
	}
}
