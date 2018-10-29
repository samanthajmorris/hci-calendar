/*import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import CalendarInterface.OneWeek;

public class gui_final implements ActionListener {
 public JFrame f;    // declare frame JFrame
 private JLabel lbResultExpl; // declare result_expl Label
 private JTextArea taResults; // declare results TextField
 private JButton btExit;   // declare exit button
 public JPanel p;    // panel with grid layout
 private JLabel lbDay1, lbDay2, lbDay3, lbDay4, lbDay5, lbDay6, lbDay7;
 
 public gui_final() {
  
  f = new JFrame("ScheduleMe final frame");
  f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
  Font font = new Font("Leelawadee UI", Font.PLAIN, 14);
  Font dateFont = new Font("Leelawadee UI", Font.BOLD, 16);
  Font titleFont = new Font("Leelawadee UI", Font.BOLD, 14);
  Color color = new Color(206, 252, 255);
  
  // top portion of gui
  lbResultExpl = new JLabel("Time availability for this week is as follows:");
  lbResultExpl.setFont(titleFont);
  lbResultExpl.setAlignmentX(Component.CENTER_ALIGNMENT);
  f.add(lbResultExpl);
  f.setBackground(color);
  
  // displays final results
  p = new JPanel();
  f.add(p);
  p.setLayout(new GridLayout(7, 2));
  p.setBackground(color);
  
  OneWeek week = new OneWeek();
  week.createWeek();
  String  l1 = new String();
  String  l2 = new String();
  String  l3 = new String();
  String  l4 = new String();
  String  l5 = new String();
  String  l6 = new String();
  String  l7 = new String();

  // Default. DELETE LATER
  String  sampletimes = "<HTML>"+"6:00 AM" + " 6:30 AM" + " 7:00 AM" + " 7:30 AM" + " 8:00 AM" + " 8:30 AM" + "9:00 AM" + 
    "9:30 AM" + "10:00 AM" +  "10:30 AM" + "11:00 AM" + "11:30 AM" + "12:00 AM" + "12:30 AM" +"1:00 PM"+ "1:30 PM" 
     + "2:00 PM"+"2:30 PM"+ "3:00 PM"+"3:30 PM"+ "4:00 PM"+ "4:30 PM"+"5:00 PM"+"5:30 PM"+ "6:00 PM"+ "6:30 PM"+
    "7:00 PM"+ "7:30 PM"+ "8:00 PM"+ "8:30 PM"+ "9:00 PM"+ "9:30 PM"+ "10:00 PM"+ "10:30 PM"+"11:00 PM"+ 
    "11:30 PM"+"<HTML>";
  
  String times1 = "6:00 AM";
  String times2 = "6:00 AM";
  String times3 = "6:00 AM";
  String times4 = "6:00 AM";
  String times5 = "6:00 AM";
  String times6 = "6:00 AM";
  String times7 = "6:00 AM";
  
  l1 = week.get_month(0) + " " + week.get_day_of_month(0) + " " + week.get_year(0);
  l2 = week.get_month(1) + " " + week.get_day_of_month(1) + " " + week.get_year(1);
  l3 = week.get_month(2) + " " + week.get_day_of_month(2) + " " + week.get_year(2);
  l4 = week.get_month(3) + " " + week.get_day_of_month(3) + " " + week.get_year(3);
  l5 = week.get_month(4) + " " + week.get_day_of_month(4) + " " + week.get_year(4);
  l6 = week.get_month(5) + " " + week.get_day_of_month(5) + " " + week.get_year(5);
  l7 = week.get_month(6) + " " + week.get_day_of_month(6) + " " + week.get_year(6);
  
  // The Month, Day of the Month and the Year.
  lbDay1 = new JLabel(l1);
  lbDay2 = new JLabel(l2);
  lbDay3 = new JLabel(l3);
  lbDay4 = new JLabel(l4);
  lbDay5 = new JLabel(l5);
  lbDay6 = new JLabel(l6);
  lbDay7 = new JLabel(l7);
  

  // The available times for each of the days.
  JLabel timel1 = new JLabel(sampletimes);
  JLabel timel2 = new JLabel(sampletimes);
  JLabel timel3 = new JLabel(sampletimes);
  JLabel timel4 = new JLabel(sampletimes);
  JLabel timel5 = new JLabel(sampletimes);
  JLabel timel6 = new JLabel(sampletimes);
  JLabel timel7 = new JLabel(sampletimes);
  
  lbDay1.setFont(dateFont);
  lbDay2.setFont(dateFont);
  lbDay3.setFont(dateFont);
  lbDay4.setFont(dateFont);
  lbDay5.setFont(dateFont);
  lbDay6.setFont(dateFont);
  lbDay7.setFont(dateFont);
  lbDay1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  lbDay2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  lbDay3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  lbDay4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  lbDay5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  lbDay6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  lbDay7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  
  timel1.setFont(font);
  timel2.setFont(font);
  timel3.setFont(font);
  timel4.setFont(font);
  timel5.setFont(font);
  timel6.setFont(font);
  timel7.setFont(font);
  timel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  timel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  timel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  timel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  timel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  timel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  timel7.setBorder(BorderFactory.createLineBorder(Color.BLACK));

  p.add(lbDay1);
  p.add(timel1);
  p.add(lbDay2);
  p.add(timel2);
  p.add(lbDay3);
  p.add(timel3);
  p.add(lbDay4);
  p.add(timel4);
  p.add(lbDay5);
  p.add(timel5);
  p.add(lbDay6);
  p.add(timel6);
  p.add(lbDay7);
  p.add(timel7);

  // exit button closes application
  btExit = new JButton("Exit");
  btExit.setAlignmentX(Component.CENTER_ALIGNMENT);
  f.add(btExit);
  
  // Exit action
  btExit.addActionListener((ActionListener) this);
  
  // General defaults
  f.setTitle("ScheduleMeResults");
  f.setSize(1000,800);
  f.setLocationRelativeTo(null);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
  
 // ActionEvent handler
 @Override
 public void actionPerformed(ActionEvent e) {
  // exit
  if (e.getSource() == btExit) {
   f.setVisible(false);
   System.exit(0);
  }
 }
 
 // main() method
 public static void main(String args[]) {
  new gui_final();
 }
}