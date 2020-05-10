package com.grandcircus.library.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.grandcircus.library.service.LibraryService;

public class DonateBookGUI extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public DonateBookGUI(LibraryService libraryApp) {
		JLabel authorNameLabel = new JLabel("Enter the authors name of the book you would like to donate");
		JTextField authorNameTextField = new JTextField(30);
		JLabel titleNameLabel = new JLabel("Enter the title of the book you would like to donate");
		JTextField titleNameTextField = new JTextField(30);
		JButton donateBookButton = new JButton("Add book");
		
		this.setSize(400, 200);
		this.setModal(true);
		this.setTitle("Donate a Book");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.add(authorNameLabel);
		this.add(authorNameTextField);
		this.add(titleNameLabel);
		this.add(titleNameTextField);
		this.add(donateBookButton);
		this.setLocationRelativeTo(null);
		
		donateBookButton.addActionListener(event -> {
			String authorName = authorNameTextField.getText();
			String titleName = titleNameTextField.getText();
			
			if(libraryApp.addBook(titleName, authorName)) {
				JOptionPane.showMessageDialog(this, "Thank you for your donation!");
			} else {
				JOptionPane.showMessageDialog(this, "Please check your author name and title.");
			}
		});
		this.setVisible(true);
	}

}
