/*
 * File Name:	CalendarFrame.java
 * Author:		Vistassja Williams
 * Purpose:		This is the main class for the Calendar for Schedule me that adds
 * 				all of the panels: CalendarPanel, DayPanel, and MonthYear Panel to the main
 * 				frame that will make up the window. This class also tells the CalendarPanel
 * 				how to place its buttons based on the placements of the Days in the DayPanel
 * 				class. The layout of the main frame is BoxLayout.
 * Date:		October 23, 2018
 */

import javax.swing.*;
import java.awt.*;

public class CalendarFrame {
	private static JFrame frame = new JFrame("ScheduleMe Calendar");
	
	public static void main() {
		// Do not change any of the dimensions (at least the x's). Bad things will happen.
		MonthYearPanel monthp = new MonthYearPanel();
		monthp.setPreferredSize(new Dimension(100,100));

		DayPanel dayp = new DayPanel();
		dayp.setPreferredSize(new Dimension(100,100));      

		CalendarPanel calp = new CalendarPanel();
		calp.setPreferredSize(new Dimension(500,400));//500 300

		//getting the placements of the buttons from the DayPanel.
		int[] placements = new int[7];
		placements = dayp.getPlacements();
		//Applying the above placements to the buttons in the CalendarPanel.
		calp.doButtonPlacements(placements);

		frame = new JFrame("ScheduleMeCalendar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		// Setting the layout of the main frame.
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		//Adding the panels in different sections of the content pane.
		frame.getContentPane().add(monthp);
		frame.getContentPane().add(dayp);
		frame.getContentPane().add(calp);

		frame.setPreferredSize(new Dimension(985,600));

		// The Window won't be resizable to allow for good button placement.
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void setInvisible() {
		frame.setVisible(false);
	}
}