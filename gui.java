import javax.swing.*;
import java.awt.*;

public class gui extends Frame {
	
	private Label lbQuestion;		// declare question Label
	private Label lbCreateGroup;	// declare create_group Label
	private Label lbJoinExistingGroup;	// declare join_exitsting_group Label
	private Label lbName;			// declare name Label
	private TextField tfGroupName;	// declare group_name TextField
	private Button btUploadGroup;	// declare upload_group Button
	private TextField tfName;		// declare name TextField
	
	public gui() {
		
		setLayout(new FlowLayout());
		
		// Question
		lbQuestion = new Label("To get started, enter your name and "
				+"create a group or upload an existing group text file.");
		add(lbQuestion);
		
		// Name
		lbName = new Label("What is your name?");
		add(lbName);
		tfName = new TextField("your name", 10);
		add(tfName);
		
		// Create group
		lbCreateGroup = new Label("Choose a group name:");
		add(lbCreateGroup);
		tfGroupName = new TextField("group name",10);
		add(tfGroupName);
		
		// Join group
		lbJoinExistingGroup = new Label("Upload the group text file"
				+"to join the existing group");
		add(lbJoinExistingGroup);
		btUploadGroup = new Button("Upload");
		add(btUploadGroup);
       
        setTitle("SheduleMe");
        setSize(350,200);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

	// main() method
	public static void main(String args[]) {
		new gui();
	}
	
	// ActionEvent handler
//	@Override
//	public void actionPerformed(ActionEvent evt) {
//		// Get the String entered into the TextField tfInput, convert to int
//		int numberIn = Integer.parseInt(tfInput.getText());
//		sum += numberIn;      // Accumulate numbers entered into sum
//		tfInput.setText("");  // Clear input TextField
//		tfOutput.setText(sum + ""); // Display sum on the output TextField
//									// convert int to String
//   }
}