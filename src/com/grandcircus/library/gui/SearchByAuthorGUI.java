package com.grandcircus.library.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.grandcircus.library.service.LibraryService;

public class SearchByAuthorGUI extends JDialog {
	
	private static final long serialVersionUID = 1L;

	JLabel authorNameLabel = new JLabel("Enter author name from list:");
	JTextField authorNameTextField = new JTextField(30);
	JButton searchAuthorButton = new JButton("Enter");
	JTextArea bookTextArea = new JTextArea(20, 75);
	
	public SearchByAuthorGUI(LibraryService libraryApp) {
		this.setSize(400, 200);
		setModal(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.add(authorNameLabel);
		this.add(authorNameTextField);
		
		this.add(searchAuthorButton);
		this.add(bookTextArea);
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		searchAuthorButton.addActionListener(event -> {
			String input = authorNameTextField.getText();
			String books = libraryApp.lookUpByAuthor(input);
			bookTextArea.setText(books);
		});
		
		setVisible(true);
	}
}
