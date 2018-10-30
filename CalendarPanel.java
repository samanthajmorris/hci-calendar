/*
 * File Name: CalendarPanel.java
 * Author:    Vistassja Williams
 * Purpose:   This is the class that contains the buttons that represent the actual days in a 
 *            calendar.
 * Date:      October 23, 2018
 * 
 * Notes: The code pertaining to the ComboCheckBoxes was found online at the following link:
 *        https://stackoverflow.com/questions/37175123/creating-jcombobox-with-checkboxes 
 *        by StackOverflow user aterai on May 12 2016 at 5:19 AM.
 * 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.accessibility.*;
import javax.swing.plaf.basic.*;

public class CalendarPanel extends JPanel
{ 
	private static final long serialVersionUID = 1L;
	private JButton b1, b2, b3, b4, b5, b6, b7;
	private JButton calculate;
	private OneWeek week; 
	private JComboCheckBox<CheckableItem> timeBoxSun;
	private JComboCheckBox<CheckableItem> timeBoxMon;
	private JComboCheckBox<CheckableItem> timeBoxTues;
	private JComboCheckBox<CheckableItem> timeBoxWed;
	private JComboCheckBox<CheckableItem> timeBoxThurs;
	private JComboCheckBox<CheckableItem> timeBoxFri;
	private JComboCheckBox<CheckableItem> timeBoxSat;
	private boolean[][] availability = new boolean[7][36];
	private JLabel instructions;
	private JLabel instructions_ext; // If the instructions end up being longer.
	private String[] times = { "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM","8:00 AM", "8:30 AM","9:00 AM", 
			"9:30 AM","10:00 AM", "10:30 AM","11:00 AM","11:30 AM", "12:00 AM", "12:30 AM", "1:00 PM", "1:30 PM", 
			"2:00 PM","2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM",
			"7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM","11:00 PM", 
	"11:30 PM"}; 

	public CalendarPanel()
	{ 
		Font buttonFont = new Font("Courier", Font.PLAIN, 20);   // This is the Font of the Weekdays and the Buttons.
		Font calcfont = new Font("Courier", Font.PLAIN, 14);
		Font instructionsFont = new Font("Leelawadee UI", Font.ITALIC, 16);
		Dimension calcdim = new Dimension(120, 50); // dimension of the Calculate button
		Dimension buttondim = new Dimension(75,50);  // The dimension of each button. 
		Dimension labeldim = new Dimension(1000, 50); // dimension of the instructions label
		String label = "Add times by clicking the drop down box under each day and ticking the checkboxes " +
				"corresponding to the times you are not available.";
		String label_ext = "Once you are all done, click Calculate.";
		instructions = new JLabel(label);
		instructions.setFont(instructionsFont);
		instructions_ext = new JLabel(label_ext);
		instructions_ext.setFont(instructionsFont);
		week = new OneWeek();
		Color panelcol = new Color(229, 193, 188); // Light pink

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
		calculate = new JButton("Calculate");


		CheckableItem[] m1 = new CheckableItem[times.length]; // an array of Checkboxes
		CheckableItem[] m2 = new CheckableItem[times.length]; 
		CheckableItem[] m3 = new CheckableItem[times.length]; 
		CheckableItem[] m4 = new CheckableItem[times.length]; 
		CheckableItem[] m5 = new CheckableItem[times.length]; 
		CheckableItem[] m6 = new CheckableItem[times.length]; 
		CheckableItem[] m7 = new CheckableItem[times.length]; 

		for (int i = 0; i < times.length; i++)
		{
			// set each checkable item to be all of the elements of time array and to be unchecked.
			m1[i] = new CheckableItem(times[i],false);  
			m2[i] = new CheckableItem(times[i],false);
			m3[i] = new CheckableItem(times[i],false);
			m4[i] = new CheckableItem(times[i],false);
			m5[i] = new CheckableItem(times[i],false);
			m6[i] = new CheckableItem(times[i],false);
			m7[i] = new CheckableItem(times[i],false);                           
		}         

		// Let's start the id's at zero for availability computation sake.
		timeBoxSun = new JComboCheckBox<CheckableItem>(m1 , 0); 
		timeBoxMon = new JComboCheckBox<CheckableItem>(m2 , 1);
		timeBoxTues = new JComboCheckBox<CheckableItem>(m3, 2);
		timeBoxWed = new JComboCheckBox<CheckableItem>(m4, 3);
		timeBoxThurs = new JComboCheckBox<CheckableItem>(m5, 4);
		timeBoxFri = new JComboCheckBox<CheckableItem>(m6 , 5);
		timeBoxSat = new JComboCheckBox<CheckableItem>(m7 , 6);

		add(timeBoxSun);
		add(timeBoxMon);
		add(timeBoxTues);
		add(timeBoxWed);
		add(timeBoxThurs);
		add(timeBoxFri);
		add(timeBoxSat);

		b1.setPreferredSize(buttondim);
		b1.setFont(buttonFont);    
		b2.setPreferredSize(buttondim);
		b2.setFont(buttonFont);
		b3.setPreferredSize(buttondim);
		b3.setFont(buttonFont);
		b4.setPreferredSize(buttondim);
		b4.setFont(buttonFont);
		b5.setPreferredSize(buttondim);
		b5.setFont(buttonFont);
		b6.setPreferredSize(buttondim);
		b6.setFont(buttonFont);
		b7.setPreferredSize(buttondim);
		b7.setFont(buttonFont);

		calculate.setPreferredSize(calcdim);  
		calculate.setFont(calcfont);
		calculate.addActionListener(new CalculateActionListener());
		instructions.setPreferredSize(labeldim);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(calculate);
		add(instructions);
		add(instructions_ext);

		// Initializing the availability to all true, or all available.
		for (int i = 0; i < 7; i++) // 7 days
		{
			for (int j = 0; j < 36; j++) // 36 hours
			{
				availability[i][j] = true;
			}
		}
	}

	// Gets the placements of elements in other panels(in this case, the placements
	// of the weekdays in the DayPanel) and applies those same placements to the buttons of this panel.
	public void doButtonPlacements(int[] placements)
	{
		int xplacement;
		int yplacement = 50; // We will start at this y.
		int index;

		// Gets the current size of each JButton. Will only have to do
		// this once since they all are the same size.
		Dimension buttonsize = b1.getPreferredSize(); // size of the buttons
		Dimension boxSize = new Dimension(100,25); //size of the time drop down Boxes
		Dimension calcdim = calculate.getPreferredSize(); // size of the calculate button
		Dimension labeldim = instructions.getPreferredSize(); // size of the instruction label
		int calculate_placement = 0;

		index = week.get_day_of_week(0);
		xplacement = placements[index - 1];
		b1.setBounds(xplacement, yplacement, buttonsize.width, buttonsize.height); // Sunday 
		// Set bounds of the checkable box.
		timeBoxSun.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);     
		// If the previous index was the last day of the week, the next few buttons will have to go on the 
		// next line.
		if(index == 7) 
		{
			calculate_placement = xplacement;
			yplacement = 150;
		}

		index = week.get_day_of_week(1);
		xplacement = placements[index - 1];
		b2.setBounds(xplacement, yplacement, buttonsize.width, buttonsize.height); // Monday    
		timeBoxMon.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
		if(index == 7) 
		{
			calculate_placement = xplacement;
			yplacement = 150;
		}

		index = week.get_day_of_week(2);
		xplacement = placements[index - 1];
		b3.setBounds(xplacement, yplacement, buttonsize.width, buttonsize.height); // Tuesday
		timeBoxTues.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
		if(index == 7) 
		{
			calculate_placement = xplacement;
			yplacement = 150;
		}

		index = week.get_day_of_week(3);
		xplacement = placements[index - 1];
		b4.setBounds(xplacement, yplacement, buttonsize.width, buttonsize.height); // Wednesday 
		timeBoxWed.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height); 
		if(index == 7) 
		{
			calculate_placement = xplacement;
			yplacement = 150;
		}

		index = week.get_day_of_week(4);
		xplacement = placements[index - 1];
		b5.setBounds(xplacement, yplacement, buttonsize.width, buttonsize.height); // Thursday 
		timeBoxThurs.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
		if(index == 7) 
		{
			calculate_placement = xplacement;
			yplacement = 150;
		}

		index = week.get_day_of_week(5);
		xplacement = placements[index - 1];
		b6.setBounds(xplacement, yplacement, buttonsize.width, buttonsize.height); // Friday 
		timeBoxFri.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
		if(index == 7) 
		{
			calculate_placement = xplacement;
			yplacement = 150;
		}

		index = week.get_day_of_week(6);
		xplacement = placements[index - 1];
		b7.setBounds(xplacement, yplacement, buttonsize.width, buttonsize.height); // Saturday
		timeBoxSat.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
		if(index == 7) 
		{
			calculate_placement = xplacement;
			yplacement = 150;
		}

		calculate.setBounds(calculate_placement, 210, calcdim.width, calcdim.height);
		instructions.setBounds(0, 275, labeldim.width, labeldim.height);
		instructions_ext.setBounds(0, 300, labeldim.width, labeldim.height);

	}

	// The action listener for the calculate button. Basically will call the 
	// backend for all of it's calculations.
	private class CalculateActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean [][] avail = getAvailability(); // array of false/true values
			gui_init gui = new gui_init(0);
			String pathToFile = gui.getPath(); // filepath
			String name = gui.getName();   //name	
			System.out.println(pathToFile); // debug stmt
			System.out.println(name);
			convert f = new convert();	// create convert object
			f.backend(avail, name, pathToFile);
		}
	}


	// Whenever the user pressed the checkbox they are toggling the value of their availibility.
	// When they check the check box, they are indicating they are not available, so we change that
	// value to false.  If they uncheck it (they changed their mind) the value should currently be 
	// false so we change it back to true.
	private void toggleAvailability(int dayIndex, int timeIndex)
	{
		if (availability[dayIndex][timeIndex])
			availability[dayIndex][timeIndex] = false;
		else
			availability[dayIndex][timeIndex] = true; 
	}

	// returns the current state of the availability array.
	public boolean[][] getAvailability()
	{
		return availability;
	}

	// Contains a string and a boolean value.
	class CheckableItem 
	{
		public final String text;
		public boolean selected;
		protected CheckableItem(String text, boolean selected) 
		{
			this.text = text;
			this.selected = selected;
		}
		@Override public String toString() {
			return text;
		}
	}

	class CheckBoxCellRenderer<E extends CheckableItem> implements ListCellRenderer<E> {
		private final JLabel label = new JLabel(" ");
		private final JCheckBox check = new JCheckBox(" ");
		@Override public Component getListCellRendererComponent(JList list, CheckableItem value, int index,
				boolean isSelected, boolean cellHasFocus) 
		{
			ListModel model = list.getModel();
			if (index < 0) 
			{
				label.setText(getDataStringRepresentation(model));
				return label;
			} 
			else 
			{
				check.setText(Objects.toString(value, "null"));
				check.setSelected(value.selected);
				if (isSelected) 
				{
					check.setBackground(list.getSelectionBackground());
					check.setForeground(list.getSelectionForeground());
				} 
				else 
				{
					check.setBackground(list.getBackground());
					check.setForeground(list.getForeground());
				}
				return check;
			}
		}
		private String getDataStringRepresentation(ListModel model) 
		{
			List<String> sl = new ArrayList<>();
			for (int i = 0; i < model.getSize(); i++) {
				Object o = model.getElementAt(i);
				if (o instanceof CheckableItem && ((CheckableItem) o).selected) {
					sl.add(o.toString());
				}
			}
			return sl.stream().sorted().collect(Collectors.joining(", "));
		}
	}

	class JComboCheckBox<E extends CheckableItem> extends JComboBox<E> 
	{
		private static final long serialVersionUID = 1L;
		private boolean shouldntClose;
		private transient ActionListener listener;
		private int id; // This tells us which box it is.
		public JComboCheckBox() 
		{
			super();
		}

		public JComboCheckBox(E[] m, int identification) 
		{
			super(m);
			id = identification;
		}

		@Override public Dimension getPreferredSize() 
		{
			return new Dimension(200, 20);
		}
		public int getId()
		{
			return id;
		}

		@Override public void updateUI() 
		{
			setRenderer(null);
			removeActionListener(listener);
			super.updateUI();
			listener = e -> 
			{// determines whether a checkbox was selected.
				if (e.getModifiers() == InputEvent.BUTTON1_MASK) 
				{
					System.out.println(" Box: " + getId() + ", time selected: " + times[getSelectedIndex()]);
					toggleAvailability(getId(),getSelectedIndex());  
					updateItem(getSelectedIndex());
					shouldntClose = true;
				}
			};
			setRenderer(new CheckBoxCellRenderer<CheckableItem>());
			addActionListener(listener);
			getInputMap(JComponent.WHEN_FOCUSED).put(
					KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space-key-select");
			getActionMap().put("space-key-select", new AbstractAction() 
			{
				private static final long serialVersionUID = 1L;
				@Override public void actionPerformed(ActionEvent e) 
				{
					System.out.println("JComboBox#getSelectedIndex()" + getSelectedIndex());
					Accessible a = getAccessibleContext().getAccessibleChild(0);
					if (a instanceof BasicComboPopup) {
						BasicComboPopup pop = (BasicComboPopup) a;
						int i = pop.getList().getSelectedIndex();
						System.out.println("JList#getSelectedIndex() " + i);
						updateItem(i);
					}
				}
			});
		}

		private void updateItem(int index) {
			if (isPopupVisible()) {
				E item = getItemAt(index);
				item.selected ^= true;
				removeItemAt(index);
				insertItemAt(item, index);
				setSelectedItem(item);
			}
		}

		@Override
		public void setPopupVisible(boolean v) {
			if (shouldntClose) {
				shouldntClose = false;
				return;
			} else {
				super.setPopupVisible(v);
			}
		}
	}
}
