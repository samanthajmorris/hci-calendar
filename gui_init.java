import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;

public class gui_init extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JLabel lbQuestion1, lbQuestion2, lbExistingFile;
	private JButton btUploadFile, btSubmit;
	
	public void createView() {
		
		JPanel p = new JPanel();
		getContentPane().add(p);
		
		// Question
		lbQuestion1 = new JLabel("To get started, upload an existing text file");
		p.add(lbQuestion1);
		lbQuestion2 = new JLabel("or submit without one to create a new session.");
		p.add(lbQuestion2);
	
		// Upload Existing
		lbExistingFile = new JLabel("Upload the group text file "
				+"to add to an existing file");
		p.add(lbExistingFile);
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
	
	gui_init() {
		createView();
		
		// General defaults
		setTitle("ScheduleMe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
//        setResizable(false);
        setSize(410,160);
        setVisible(true);
    }
	
	// ActionEvent handler
	public void actionPerformed(ActionEvent e) {
		// Upload a file
		if (e.getSource() == btUploadFile) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Select a textfile");
			jfc.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
			jfc.addChoosableFileFilter(filter);

			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				System.out.println(jfc.getSelectedFile().getPath());
				System.out.println(jfc.getSelectedFile().getName());
			}
		}
		// Submit
		if (e.getSource() == btSubmit) {
			setVisible(false);
			System.exit(0);
		}
	}

	// main() method
	public static void main() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new gui_init();
			}
		});
	}
}
