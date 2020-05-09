import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class DisplayGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	
	JLabel authorNameLabel = new JLabel("List of books we have:");
	JTextArea bookTextArea = new JTextArea(20, 20);
	
	public DisplayGUI(LibraryApp libraryApp) {
		this.setSize(400, 200);
		setModal(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.add(authorNameLabel);
	
		this.add(bookTextArea);
		bookTextArea.setText(libraryApp.listBooks());
		this.pack();
		this.setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
