package com.grandcircus.library.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.grandcircus.library.service.LibraryService;

public class SearchByTitleGUI extends JDialog {

	private static final long serialVersionUID = 1L;

	JLabel titleNameLabel = new JLabel("Enter title of a book from list:");
	JTextField titleNameTextField = new JTextField(30);
	JButton titleAuthorButton = new JButton("Enter");
	JTextArea bookTextArea = new JTextArea(20, 75);

	public SearchByTitleGUI(LibraryService libraryApp) {
		this.setSize(400, 200);
		setModal(true);
		this.setTitle("Find a Book by Title");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

		this.add(titleNameLabel);
		this.add(titleNameTextField);
		this.add(titleAuthorButton);
		this.add(bookTextArea);

		this.pack();
		this.setLocationRelativeTo(null);

		titleAuthorButton.addActionListener(event -> {
			String input = titleNameTextField.getText();
			String books = libraryApp.lookUpByTitle(input);
			bookTextArea.setText(books);
		});

		setVisible(true);
	}
}
