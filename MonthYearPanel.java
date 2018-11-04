/*
 * File Name: MonthYearPanel.java
 * Author:    Vistassja Williams
 * Purpose:   This is the class that contains the JLabels that represent the month and the year.
 * Date:      October 23, 2018
 */

import java.awt.*;
import javax.swing.*;

public class MonthYearPanel extends JPanel {
	public MonthYearPanel()	{
		OneWeek week = new OneWeek();

		Font font = new Font("Courier", Font.PLAIN, 40);   
		String total_label = new String();
		String month = new String();
		String year = new String();
		Color panelcol = new Color(252, 252, 252);

		week.createWeek(); 

		if (week.get_month(0) != week.get_month(6))	// If the week stretches over two months
			month = week.get_month(0) + " / " + week.get_month(6);
		else
			month = week.get_month(0);


		if (week.get_year(0) != week.get_year(6))	// If the week stretches over two years
			year = Integer.toString(week.get_year(0)) + " / " + 
					Integer.toString(week.get_year(6));
		else
			year = Integer.toString(week.get_year(0));
		total_label = month + " " + year;

		setLayout(new BorderLayout());
		setBackground(panelcol);
		JLabel label = new JLabel(total_label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(font);
		add(label, BorderLayout.CENTER);  
	}  
}
