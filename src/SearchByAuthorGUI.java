import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchByAuthorGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JPanel panel = new JPanel();
	JLabel authorNameLabel = new JLabel();
	JTextField authorNameTextField = new JTextField(30);
	JButton searchAuthorButton = new JButton("Enter");
	JTextArea bookTextArea = new JTextArea(20, 20);
	
	public SearchByAuthorGUI(LibraryApp libraryApp) {
		panel.setVisible(true);
		panel.setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.add(authorNameTextField);
		
		panel.add(searchAuthorButton);
		panel.add(bookTextArea);
		
		searchAuthorButton.addActionListener(event -> {
			String input = authorNameTextField.getText();
			String books = libraryApp.lookUpByAuthor(input);
			bookTextArea.setText(books);
		});
		
		
		panel.add(authorNameLabel);
		add(panel);
		
	}

}
