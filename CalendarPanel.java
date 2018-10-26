/*
 * File Name: CalendarPanel.java
 * Author:    Vistassja Williams
 * Purpose:   This is the class that contains the buttons that represent the actual days in a 
 *            calendar.
 * Date:      October 23, 2018
 */
import java.awt.*;
import javax.swing.*;


public class CalendarPanel extends JPanel
{
  
  private JButton b1;
  private JButton b2;
  private JButton b3;
  private JButton b4;
  private JButton b5;
  private JButton b6;
  private JButton b7;
  private OneWeek week; 
   public CalendarPanel()
   {
     // This is the Font of the Weekdays and the Buttons.
     Font font = new Font("Courier", Font.PLAIN, 20); 
     // The dimension of each button.
     Dimension dim = new Dimension(75,50);
     week = new OneWeek();
     // Light pink
     Color panelcol = new Color(229, 193, 188);
          
     week.createWeek(); // Getting a new week.
     setLayout(null); // This layout will be customized.
     setBackground(panelcol);
     
     b1 = new JButton(Integer.toString(week.get_day_of_month(0)));
     b2 = new JButton(Integer.toString(week.get_day_of_month(1)));
     b3 = new JButton(Integer.toString(week.get_day_of_month(2)));
     b4 = new JButton(Integer.toString(week.get_day_of_month(3)));
     b5 = new JButton(Integer.toString(week.get_day_of_month(4)));
     b6 = new JButton(Integer.toString(week.get_day_of_month(5)));
     b7 = new JButton(Integer.toString(week.get_day_of_month(6)));
     
     b1.setPreferredSize(dim);
     b1.setFont(font);
     
     b2.setPreferredSize(dim);
     b2.setFont(font);
     
     b3.setPreferredSize(dim);
     b3.setFont(font);
     
     b4.setPreferredSize(dim);
     b4.setFont(font);
     
     b5.setPreferredSize(dim);
     b5.setFont(font);
     
     b6.setPreferredSize(dim);
     b6.setFont(font);
     
     b7.setPreferredSize(dim);
     b7.setFont(font);
     
     add(b1);
     add(b2);
     add(b3);
     add(b4);
     add(b5);
     add(b6);
     add(b7);
          
   }
   
   // Gets the placements of elements in other panels(in this case, the placements
   // of the weekdays in the DayPanel) and applies those same placements to the buttons of this panel.
   public void doButtonPlacements(int[] placements)
   {
     int xplacement;
     int yplacement = 50; // We will start at this y.
     int index;
     
     // Gets the current size of each JLabel. Will only have to do
     // this once since they all are the same size.
     Dimension size = b1.getPreferredSize();
     
     index = week.get_day_of_week(0);
     xplacement = placements[index - 1];
     b1.setBounds(xplacement, yplacement, size.width, size.height); // Sunday
     // If the previous index was the last day of the week, the next few buttons will have to go on the next line.
     if(index == 7) 
       yplacement = 100;
     
     index = week.get_day_of_week(1);
     xplacement = placements[index - 1];
     b2.setBounds(xplacement, yplacement, size.width, size.height); // Monday
     if(index == 7)
       yplacement = 100;
      
     index = week.get_day_of_week(2);
     xplacement = placements[index - 1];
     b3.setBounds(xplacement, yplacement, size.width, size.height); // Tuesday
     if(index == 7)
       yplacement = 100;
      
     index = week.get_day_of_week(3);
     xplacement = placements[index - 1];
     b4.setBounds(xplacement, yplacement, size.width, size.height); // Wednesday 
     if(index == 7)
       yplacement = 100;
      
     index = week.get_day_of_week(4);
     xplacement = placements[index - 1];
     b5.setBounds(xplacement, yplacement, size.width, size.height); // Thursday 
     if(index == 7)
       yplacement = 100;
      
     index = week.get_day_of_week(5);
     xplacement = placements[index - 1];
     b6.setBounds(xplacement, yplacement, size.width, size.height); // Friday 
     if(index == 7)
       yplacement = 100;
      
     index = week.get_day_of_week(6);
     xplacement = placements[index - 1];
     b7.setBounds(xplacement, 100, size.width, size.height); // Saturday
    
   }
}
