/*
 * File Name: CalendarPanel.java
 * Author:    Vistassja Williams
 * Purpose:   This is the class that contains the JLabels that represent the weekdays of the calendar.
 * Date:      October 23, 2018
 */


import java.awt.*;
import javax.swing.*;

public class DayPanel extends JPanel
{
	public int[] placements = new int[7]; // so that other classes will be able to see this.

	public DayPanel()
	{
		// Also the font of the buttons
		Font font = new Font("Courier", Font.PLAIN, 20);    
		Color panelcol = new Color(166, 219, 219);
		//custom layout
		OneWeek week = new OneWeek();

		setLayout(null);
		setBackground(panelcol);
		week.createWeek(); 

		JLabel day1 = new JLabel("Sunday");
		JLabel day2 = new JLabel("Monday");
		JLabel day3 = new JLabel("Tuesday");
		JLabel day4 = new JLabel("Wednesday");
		JLabel day5 = new JLabel("Thursday");
		JLabel day6 = new JLabel("Friday");
		JLabel day7 = new JLabel("Saturday");

		day1.setFont(font);
		day2.setFont(font);
		day3.setFont(font);
		day4.setFont(font);
		day5.setFont(font);
		day6.setFont(font);
		day7.setFont(font);

		int xdim = 125;
		int ydim = 50;
		day1.setPreferredSize(new Dimension(xdim,ydim));
		day2.setPreferredSize(new Dimension(xdim,ydim));
		day3.setPreferredSize(new Dimension(xdim,ydim));
		day4.setPreferredSize(new Dimension(xdim,ydim));
		day5.setPreferredSize(new Dimension(xdim,ydim));
		day6.setPreferredSize(new Dimension(xdim,ydim));

		add(day1);
		add(day2);
		add(day3);
		add(day4);
		add(day5);
		add(day6);
		add(day7);

		int xplacement = 25;
		int yplacement = 50;
		//Gets the current size of each JLabel. Will only have to do
		// this once since they all are the same size.
		Dimension size = day1.getPreferredSize();

		// Notice all of this had to be done after the addition of the labels.
		placements[0] = xplacement;
		day1.setBounds(xplacement, yplacement, size.width, size.height); // Sunday
		xplacement = xplacement + xdim;
		placements[1] = xplacement;
		day2.setBounds(xplacement, yplacement, size.width, size.height); // Monday
		xplacement = xplacement + xdim;
		placements[2] = xplacement;
		day3.setBounds(xplacement, yplacement, size.width, size.height); // Tuesday
		xplacement = xplacement + xdim + 10;
		placements[3] = xplacement;
		day4.setBounds(xplacement, yplacement, size.width, size.height); // Wednesday 
		xplacement = xplacement + xdim + 35;
		placements[4] = xplacement;
		day5.setBounds(xplacement, yplacement, size.width, size.height); // Thursday 
		xplacement = xplacement + xdim + 25;
		placements[5] = xplacement;
		day6.setBounds(xplacement, yplacement, size.width, size.height); // Friday 
		xplacement = xplacement + xdim;
		placements[6] = xplacement;
		day7.setBounds(xplacement, yplacement, size.width, size.height); // Saturday


	}
	// Returns the placements that were given to each of the JLabels (the weekdays).
	public int [] getPlacements()
	{
		return placements;
	}  
}