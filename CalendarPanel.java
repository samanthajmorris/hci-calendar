/*
 * File Name: CalendarPanel.java
 * Author:    Vistassja Williams
 * Purpose:   This is the class that contains the buttons that represent the actual days in a 
 *            calendar.
 * Date:      October 23, 2018
 * 
 * Notes: The code pertaining to the ComboCheckBoxes was found online at the following link:
 *  https://stackoverflow.com/questions/37175123/creating-jcombobox-with-checkboxes 
 * by StackOverflow user aterai on May 12 2016 at 5:19 AM.
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
  
  private JButton b1;
  private JButton b2;
  private JButton b3;
  private JButton b4;
  private JButton b5;
  private JButton b6;
  private JButton b7;
  private OneWeek week; 
  private JComboCheckBox<CheckableItem> timeBoxSun;
  private JComboCheckBox<CheckableItem> timeBoxMon;
  private JComboCheckBox<CheckableItem> timeBoxTues;
  private JComboCheckBox<CheckableItem> timeBoxWed;
  private JComboCheckBox<CheckableItem> timeBoxThurs;
  private JComboCheckBox<CheckableItem> timeBoxFri;
  private JComboCheckBox<CheckableItem> timeBoxSat;
  private String[] times = { "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM","8:00 AM", "8:30 AM","9:00 AM", 
    "9:30 AM","10:00 AM", "10:30 AM","11:00 AM","11:30 AM", "12:00 AM", "12:30 AM", "1:00 PM", "1:30 PM", 
    "2:00 PM","2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM",
       "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM","11:00 PM", 
       "11:30 PM"}; 
  
   public CalendarPanel()
   { 
     Font font = new Font("Courier", Font.PLAIN, 20);   // This is the Font of the Weekdays and the Buttons.
     Dimension dim = new Dimension(75,50);  // The dimension of each button.
     Dimension comboBoxDim = new Dimension(100,25);   
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
     
     //-------------------------------------------------------------------
     
      CheckableItem[] m1 = new CheckableItem[times.length]; // an array of Checkboxes
      CheckableItem[] m2 = new CheckableItem[times.length]; 
      CheckableItem[] m3 = new CheckableItem[times.length]; 
      CheckableItem[] m4 = new CheckableItem[times.length]; 
      CheckableItem[] m5 = new CheckableItem[times.length]; 
      CheckableItem[] m6 = new CheckableItem[times.length]; 
      CheckableItem[] m7 = new CheckableItem[times.length]; 
      
      for (int i = 0; i < times.length; i++)
      {
        m1[i] = new CheckableItem(times[i],false); // set each checkable item.
        m2[i] = new CheckableItem(times[i],false);
        m3[i] = new CheckableItem(times[i],false);
        m4[i] = new CheckableItem(times[i],false);
        m5[i] = new CheckableItem(times[i],false);
        m6[i] = new CheckableItem(times[i],false);
        m7[i] = new CheckableItem(times[i],false);                           
      }          
      timeBoxSun = new JComboCheckBox<CheckableItem>(m1);
      timeBoxMon = new JComboCheckBox<CheckableItem>(m2);
      timeBoxTues = new JComboCheckBox<CheckableItem>(m3);
      timeBoxWed = new JComboCheckBox<CheckableItem>(m4);
      timeBoxThurs = new JComboCheckBox<CheckableItem>(m5);
      timeBoxFri = new JComboCheckBox<CheckableItem>(m6);
      timeBoxSat = new JComboCheckBox<CheckableItem>(m7);
      
      add(timeBoxSun);
      add(timeBoxMon);
      add(timeBoxTues);
      add(timeBoxWed);
      add(timeBoxThurs);
      add(timeBoxFri);
      add(timeBoxSat);

     // I don't need to set preferred size for these buttons then.
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
     Dimension boxSize = new Dimension(100,25);//size of the Time Boxes
     
     index = week.get_day_of_week(0);
     xplacement = placements[index - 1];
     b1.setBounds(xplacement, yplacement, size.width, size.height); // Sunday 
     // Set bounds of the checkable box.
     timeBoxSun.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);     
     // If the previous index was the last day of the week, the next few buttons will have to go on the 
     // next line.
     if(index == 7) 
       yplacement = 150;
     
     index = week.get_day_of_week(1);
     xplacement = placements[index - 1];
     b2.setBounds(xplacement, yplacement, size.width, size.height); // Monday
     if(index == 7)
       yplacement = 150;
     // Set bounds of the checkable box.
     timeBoxMon.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
      
     index = week.get_day_of_week(2);
     xplacement = placements[index - 1];
     b3.setBounds(xplacement, yplacement, size.width, size.height); // Tuesday
     if(index == 7)
       yplacement = 150;
     // Set bounds of the checkable box.
     timeBoxTues.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
     
     index = week.get_day_of_week(3);
     xplacement = placements[index - 1];
     b4.setBounds(xplacement, yplacement, size.width, size.height); // Wednesday 
     if(index == 7)
       yplacement = 150;
     // Set bounds of the checkable box.
     timeBoxWed.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height); 
     
     index = week.get_day_of_week(4);
     xplacement = placements[index - 1];
     b5.setBounds(xplacement, yplacement, size.width, size.height); // Thursday 
     if(index == 7)
       yplacement = 150;
     // Set bounds of the checkable box.
     timeBoxThurs.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
     
     index = week.get_day_of_week(5);
     xplacement = placements[index - 1];
     b6.setBounds(xplacement, yplacement, size.width, size.height); // Friday 
     if(index == 7)
       yplacement = 150;
     // Set bounds of the checkable box.
     timeBoxFri.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
     
     index = week.get_day_of_week(6);
     xplacement = placements[index - 1];
     b7.setBounds(xplacement, yplacement, size.width, size.height); // Saturday
     // Set bounds of the checkable box.
     timeBoxSat.setBounds(xplacement, yplacement + 55, boxSize.width, boxSize.height);
   }

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
  private boolean shouldntClose;
  private transient ActionListener listener;

  public JComboCheckBox() 
  {
    super();
  }

  public JComboCheckBox(E[] m) 
  {
    super(m);
  }

  @Override public Dimension getPreferredSize() 
  {
    return new Dimension(200, 20);
  }

  @Override public void updateUI() 
  {
    setRenderer(null);
    removeActionListener(listener);
    super.updateUI();
    listener = e -> 
    {
      if (e.getModifiers() == InputEvent.BUTTON1_MASK) 
      {
        System.out.println("Time selected: " + times[getSelectedIndex()]);
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
