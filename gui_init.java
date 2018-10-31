/*
 * File Name: gui_init.java
 * Author:  Keara Leibovitz
 * Purpose:  Creates the initial GUI that you see on screen. Runs the calendar GUI on submit.
 *     Contains getter methods for public variables needed in backend calculations.
 * Date:  October 26, 2018
 */

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.Color;

public class gui_init extends JFrame implements ActionListener {

 private static final long serialVersionUID = 1L;
 private JLabel lbQuestion1, lbQuestion2, lbExistingFile, lbName, lbPrompt;
 public JTextField tfName;
 public static String name;
 private JButton btUploadFile, btSubmit;
 private Color lime = new Color(129, 196, 43);
 private Color maroon = new Color(234, 98, 98);
 public static String filePath;
 public String returnString;
 public void createView() {

  JPanel p = new JPanel();
  getContentPane().add(p);

  // Question
  lbPrompt = new JLabel("Hi! Welcome to ScheduleMe.");
  p.add(lbPrompt);
  lbQuestion1 = new JLabel("If you are already part of a group, upload the shared json file.");
  p.add(lbQuestion1);
  lbQuestion2 = new JLabel("If you are starting a new group, submit just your name to create a new session.");
  p.add(lbQuestion2);
  
  // enter name
  lbName = new JLabel("What is your name?");
  p.add(lbName);
  tfName = new JTextField(20);
  p.add(tfName);

  // existing file label updates when file selected
  lbExistingFile = new JLabel("Upload a file");
  lbExistingFile.setForeground(maroon);
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
  lbExistingFile.setForeground(lime);
  lbExistingFile.setText(fileName);
 }

 // If setup is 1 it will display the intro frame. 
 // If not, you can just use gui_init's functions.
 gui_init(int setup) 
 {
  if (setup == 1)
  {
   createView();

   // General defaults
   setTitle("ScheduleMe");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   pack();
   setLocationRelativeTo(null);
   setSize(550,200);
   setBackground(lime);
   setVisible(true);
  }
 }
 
 // ActionEvent handler
 public void actionPerformed(ActionEvent e) {
  // Upload a file
  if (e.getSource() == btUploadFile) {
   JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
   jfc.setDialogTitle("Select a .json file");
   jfc.setAcceptAllFileFilterUsed(false);
   FileNameExtensionFilter filter = new FileNameExtensionFilter("*.json", "json");
   jfc.addChoosableFileFilter(filter);

   int returnValue = jfc.showOpenDialog(null);
   if (returnValue == JFileChooser.APPROVE_OPTION) {
    // set file path for backend use
    filePath = jfc.getSelectedFile().getPath();
    // update JPanel with filename
    updateFileName(jfc.getSelectedFile().getName());
   }
  }
  // Submit and run calendar
  if (e.getSource() == btSubmit) {
   setVisible(false);
   name = tfName.getText();
   System.out.println(name);
   CalendarFrame.main();
  }
 }

 // a way to get file path from anywhere
 public String getPath() {
  return filePath; 
 }
 
 // a way to get user name from anywhere
 public String getName() {
  return name; 
 }
 
 // makes the calendar go away and the displays the final results of the calculations
 public void displayFinal(String ret) {
  CalendarFrame.setInvisible();
  new gui_final(ret);
 }

 // main() method
 public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
   @Override
   public void run() {
    new gui_init(1);
   }
  });
 }
}