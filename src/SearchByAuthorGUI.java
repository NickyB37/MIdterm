import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchByAuthorGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JPanel jp = new JPanel();
	JLabel jl = new JLabel();
	JTextField jt = new JTextField(30);
	JButton jb = new JButton("Enter");
	
	public SearchByAuthorGUI(LibraryApp libraryApp) {
		jp.setVisible(true);
		jp.setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jp.add(jt);
		
		jp.add(jb);
		
		jb.addActionListener(event -> {
			String input = jt.getText();
			libraryApp.lookUpByAuthor(input);
		});
		jp.add(jl);
		add(jp);
		
	}

}
