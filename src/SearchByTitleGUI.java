import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchByTitleGUI extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	JPanel panel = new JPanel();
	JLabel authorTitleLable = new JLabel();
	JTextField titleTextField = new JTextField(30);
	JButton searchTitleButton = new JButton("Enter");
	
	public SearchByTitleGUI(LibraryApp libraryApp) {
		panel.setVisible(true);
		panel.setSize(400, 200);
		panel.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.add(titleTextField);
		
		panel.add(searchTitleButton);
		
		searchTitleButton.addActionListener(event -> {
			String input = titleTextField.getText();
			libraryApp.lookUpByTitle(input);
		});
		panel.add(authorTitleLable);
		add(panel);
		
	}
}
