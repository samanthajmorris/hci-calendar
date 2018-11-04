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
	private JLabel day1 = new JLabel("Sunday");
	private JLabel day2 = new JLabel("Monday");
	private JLabel day3 = new JLabel("Tuesday");
	private JLabel day4 = new JLabel("Wednesday");
	private JLabel day5 = new JLabel("Thursday");
	private JLabel day6 = new JLabel("Friday");
	private JLabel day7 = new JLabel("Saturday");

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

//		JLabel day1 = new JLabel("Sunday");
		
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

		
		//Gets the current size of each JLabel. Will only have to do
		// this once since they all are the same size.


		
	}
	
	// Does the placement of the days according to the placements of the buttons	
	public void doDayPlacements(int [] buttonPlacements)
	{
//		int xplacement = 25;
		int xplacement = 25;
		int yplacement = 50;
		Dimension size = day1.getPreferredSize();
		// Notice all of this had to be done after the addition of the labels.
		xplacement = buttonPlacements[0];
		day1.setBounds(xplacement, yplacement, size.width, size.height); // Sunday
		
		xplacement = buttonPlacements[1];
		day2.setBounds(xplacement, yplacement, size.width, size.height); // Monday
		
		xplacement = buttonPlacements[2];
		day3.setBounds(xplacement, yplacement, size.width, size.height); // Tuesday

		
		xplacement = buttonPlacements[3];
		day4.setBounds(xplacement, yplacement, size.width, size.height); // Wednesday 
		
		xplacement = buttonPlacements[4];
		day5.setBounds(xplacement, yplacement, size.width, size.height); // Thursday 
		
		xplacement = buttonPlacements[5];
		day6.setBounds(xplacement, yplacement, size.width, size.height); // Friday 
		
		xplacement = buttonPlacements[6];
		day7.setBounds(xplacement, yplacement, size.width, size.height); // Saturday
				
	}
}
