/*
 * File Name: gui_init.java
 * Author:    Keara Leibovitz
 * Purpose:   Creates the initial gui that you see on screen. Runs the calendar gui on submit.
 * Date:      October 26, 2018
 */

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import CalendarInterface.*;

public class GuiInit extends JFrame implements ActionListener {
 
 private static final long serialVersionUID = 1L;
 private JLabel lbQuestion1, lbQuestion2, lbExistingFile;
 private JButton btUploadFile, btSubmit;
 public String filePath = new String("");
 public String returnString; 

 
 public void GuiInit() {
  createView();
  
  // General defaults
  setTitle("ScheduleMe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(410,160);
        setVisible(true);
    }
 
 public void createView() {
  
  JPanel p = new JPanel();
  getContentPane().add(p);
  
  // Question
  lbQuestion1 = new JLabel("To get started, upload an existing json file");
  p.add(lbQuestion1);
  lbQuestion2 = new JLabel("or submit without one to create a new session.");
  p.add(lbQuestion2);

  // existing file label updates when file selected
  lbExistingFile = new JLabel("Upload a file");
  lbExistingFile.setSize(100,30);
  p.add(lbExistingFile);
  
  // Upload Existing
  btUploadFile = new JButton("Upload");
  p.add(btUploadFile);
  // Upload file action
  btUploadFile.addActionListener((ActionListener) this);
  
  // Submit all
  btSubmit = new JButton("Submit");
  p.add(btSubmit);
  
  // Submit action
  btSubmit.addActionListener((ActionListener) this);
 }
 
 private void updateFileName(String fileName) {
  lbExistingFile.setText(fileName);
 }
 

 
 // ActionEvent handler
 public void actionPerformed(ActionEvent e) {
  // Upload a file
  if (e.getSource() == btUploadFile) {
   JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
   jfc.setDialogTitle("Select a JSON file");
   jfc.setAcceptAllFileFilterUsed(false);
   FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "*.json", "json");
   jfc.addChoosableFileFilter(filter);

   int returnValue = jfc.showOpenDialog(null);
   if (returnValue == JFileChooser.APPROVE_OPTION) {
    System.out.println(jfc.getSelectedFile().getPath());
    filePath = jfc.getSelectedFile().getPath();
    System.out.println(jfc.getSelectedFile().getName());
    updateFileName(jfc.getSelectedFile().getName());
   }
  }
  // Submit and run calendar
  if (e.getSource() == btSubmit) {
   setVisible(false);
   CalendarPanel cal = new CalendarPanel();
   boolean [] [] availability = cal.getAvailability();
   backend(availability, "sampleName", getPath());
  }
 }
 
 public String getPath(){
  return filePath; 
 }
 
 public void backend(boolean [][] array, String name, String path)
  {
    
    convert newCon = new convert();
    returnString = newCon.convertArray(array);
    System.out.println(returnString);
    
    SamsFunctions func = new SamsFunctions();
    func.addEntry(name, returnString, path); 
  }

 // main() method
 public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
   @Override
   public void run() {
    new GuiInit();
   }
  });
 }
}
