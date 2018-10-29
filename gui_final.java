import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import CalendarInterface.OneWeek;

public class gui_final implements ActionListener {
	public JFrame f;				// declare frame JFrame
	private JLabel lbResultExpl;	// declare result_expl Label
	private JTextArea taResults;	// declare results TextField
	private JButton btExit;			// declare exit button
	public JPanel p;				// panel with grid layout
	private JLabel lbDay1, lbDay2, lbDay3, lbDay4, lbDay5, lbDay6, lbDay7;
	
	public gui_final() {
		
		f = new JFrame("ScheduleMe final frame");
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
		
		// top portion of gui
		lbResultExpl = new JLabel("Results for time availability "
				+"for the next week are as follows:");
		lbResultExpl.setAlignmentX(Component.CENTER_ALIGNMENT);
		f.add(lbResultExpl);
		
		// displays final results
		p = new JPanel();
		f.add(p);
		p.setLayout(new GridLayout(7, 2));
		
		OneWeek week = new OneWeek();
		week.createWeek();
		lbDay1 = new JLabel(Integer.toString(week.get_day_of_month(0)));
		p.add(lbDay1);
//		System.out.println(Integer.toString(week.get_day_of_month(0)));
		lbDay2 = new JLabel(Integer.toString(week.get_day_of_month(1)));
		p.add(lbDay2);
//		System.out.println(Integer.toString(week.get_day_of_month(1)));

		
		taResults = new JTextArea();
		p.add(taResults);
		
		// exit button closes application
		btExit = new JButton("Exit");
		btExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		f.add(btExit);
		// Exit action
		btExit.addActionListener((ActionListener) this);
		
		// General defaults
		f.setTitle("SheduleMe");
        f.setSize(500,500);
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
