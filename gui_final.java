
/*
 * File Name:	gui_final.java
 * Authors:		Keara Leibovitz, Vistassja Williams, Aisha Mohammed
 * Purpose:		Runs gui_init, which in turn runs CalendarFrame on Submit,
 * 				which in turn runs gui_final to display results and saves
 * 				the new results to ScheduleMe.json.
 * Date:		October 30, 2018
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class gui_final implements ActionListener {
	public JFrame f; // declare frame JFrame
	private JLabel lbResultExpl; // declare result_expl Label
	private JButton btExit; // declare exit button
	public JPanel p; // panel with grid layout
	private JLabel lbDay1, lbDay2, lbDay3, lbDay4, lbDay5, lbDay6, lbDay7;

	public gui_final(String inputString) {
		f = new JFrame("ScheduleMe final frame");
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
		Font font = new Font("Leelawadee UI", Font.PLAIN, 16);
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
		String l1 = new String();
		String l2 = new String();
		String l3 = new String();
		String l4 = new String();
		String l5 = new String();
		String l6 = new String();
		String l7 = new String();

		// Default. DELETE LATER
		// String defaulttimes = "<HTML>"+"6:00 AM" + " 6:30 AM" + " 7:00 AM" + " 7:30
		// AM" + " 8:00 AM" + " 8:30 AM" + "9:00 AM" +
		// "9:30 AM" + "10:00 AM" + "10:30 AM" + "11:00 AM" + "11:30 AM" + "12:00 AM" +
		// "12:30 AM" +"1:00 PM"+ "1:30 PM"
		// + "2:00 PM"+"2:30 PM"+ "3:00 PM"+"3:30 PM"+ "4:00 PM"+ "4:30 PM"+"5:00
		// PM"+"5:30 PM"+ "6:00 PM"+ "6:30 PM"+
		// "7:00 PM"+ "7:30 PM"+ "8:00 PM"+ "8:30 PM"+ "9:00 PM"+ "9:30 PM"+ "10:00 PM"+
		// "10:30 PM"+"11:00 PM"+
		// "11:30 PM"+"<HTML>";

		String times1 = convertbintotime(inputString, 0);
		String times2 = convertbintotime(inputString, 1);
		String times3 = convertbintotime(inputString, 2);
		String times4 = convertbintotime(inputString, 3);
		String times5 = convertbintotime(inputString, 4);
		String times6 = convertbintotime(inputString, 5);
		String times7 = convertbintotime(inputString, 6);

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
		JLabel timel1 = new JLabel(times1);
		JLabel timel2 = new JLabel(times2);
		JLabel timel3 = new JLabel(times3);
		JLabel timel4 = new JLabel(times4);
		JLabel timel5 = new JLabel(times5);
		JLabel timel6 = new JLabel(times6);
		JLabel timel7 = new JLabel(times7);

		// JLabel timel1 = new JLabel(defaulttimes);
		// JLabel timel2 = new JLabel(defaulttimes);
		// JLabel timel3 = new JLabel(defaulttimes);
		// JLabel timel4 = new JLabel(defaulttimes);
		// JLabel timel5 = new JLabel(defaulttimes);
		// JLabel timel6 = new JLabel(defaulttimes);
		// JLabel timel7 = new JLabel(defaulttimes);

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
		f.setSize(1050, 1000);
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

	// Compresses the times available into time intervals that were much easier to read
	// Than the previous version which just listed all of the times.
	public static String[] compress(String binary) {
		String[] compressed = { new String(), new String(), new String(), new String(), new String(), new String(),
				new String() };
		int mul = 0;
		char t = '1';
		char f = '0';
		char curr = binary.charAt(0);
		int max = binary.length();
		char current;
		int iter = 0;

		if (max != 252) {
			System.out.println("invalid number of input!");
			System.exit(0);
		}

		for (int i = 0; i < 7; i++) {
			curr = binary.charAt(i * 36);
			for (int j = 0; j < 36; j++) {
				current = binary.charAt(iter);
				if (current == curr)
					mul++;
				else {
					compressed[i] += curr + "," + mul + " ";
					mul = 1;
					curr = current;
				}
				iter++;
			}
			compressed[i] += curr + "," + mul + " ";
			mul = 0;
		}
		return compressed;
	}

	public String convertbintotime(String bin, int day) {

		String[] times = { "6:00AM", "6:30AM", "7:00AM", "7:30AM", "8:00AM", "8:30AM", "9:00AM", "9:30AM",
				"10:00AM", "10:30AM", "11:00AM", "11:30AM", "12:00AM", "12:30AM", "1:00PM", "1:30PM", "2:00PM",
				"2:30PM", "3:00PM", "3:30PM", "4:00PM", "4:30PM", "5:00PM", "5:30PM", "6:00PM", "6:30PM",
				"7:00PM", "7:30PM", "8:00PM", "8:30PM", "9:00PM", "9:30PM", "10:00PM", "10:30PM", "11:00PM",
				"11:30PM", "12:00PM" };

		String ret_times = new String();
	
		// parts gets compressed parts together and value gets the left
		// and right values seperately.
		String[] compTimesBin, parts, values;
		String dayValues;
		int increments = 36;

		if (bin.length() != 252) {
			System.out.println("Invalid length!");
			return null;
		}

		compTimesBin = compress(bin);

		dayValues = compTimesBin[day];
		int holdStart = 0;
		parts = dayValues.split(" ");
		int partsLen = parts.length;
		
			
		if (partsLen == 1) {
			values = parts[0].split(",");
			if (values[0].equals("1")) {
				ret_times = "You are completely available on this day.";
			} else if (values[0].equals("0")) {
				ret_times = "You are unavailable on this day.";
			}
		} 
		else {
			ret_times = "<HTML>";
			for (int i = 0; i < partsLen; i++) {
				values = parts[i].split(",");
				int createEnd = Integer.parseInt(values[1]);

				if (values[0].equals("1")) {
					ret_times += times[holdStart] + "-";
					holdStart += createEnd;
					System.out.println("The times[holdStart] is " + times[holdStart]);	
					ret_times += times[holdStart];
					if (times[holdStart] != "12:00PM")
						ret_times += " ; ";
				} 
				else if (values[0].equals("0")) {
					holdStart += createEnd;
				}
			}
			ret_times += "<HTML>";
		}

		return ret_times;
	}

	/*
	 * test method public static void main(String args[]) { String test1 =
	 * "111111111101111111100000000000000000000111111111110000000000000000000000011111111111111111111000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
	 * String test2 =
	 * "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
	 * String test3 =
	 * "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	 * 
	 * new gui_final(test1); }
	 */
}
