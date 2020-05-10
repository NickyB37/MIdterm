package com.grandcircus.library.gui;

import java.awt.GridLayout;

import javax.swing.*;

import com.grandcircus.library.service.LibraryService;

public class MenuGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public MenuGUI() {
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// Don't care if the theme can't be changed
		}
		
		LibraryService libraryApp = new LibraryService();

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JButton display = new JButton("Display books");// creating instance of JButton
		JButton searchByAuthor = new JButton("Search by author");
		JButton searchByTitle = new JButton("Search by title");
		JButton checkoutBook = new JButton("Checkout book");
		JButton returnBook = new JButton("Return book");
		JButton donateBook = new JButton("Donate a book");
		JButton exit = new JButton("Exit");

		// 0 in the parameter means unlimited rows
		this.setLayout(new GridLayout(0, 1));

		this.add(display);
		this.add(searchByAuthor);
		this.add(searchByTitle);
		this.add(checkoutBook);
		this.add(returnBook);
		this.add(donateBook);
		this.add(exit);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// Used lambdas because the ActionListener interface only has one method in it.
		// Otherwise we could not use lambda.
		display.addActionListener(event -> {
			new DisplayGUI(libraryApp);
		});

		searchByAuthor.addActionListener(event -> {
			new SearchByAuthorGUI(libraryApp);
		});

		searchByTitle.addActionListener(event -> {
			new SearchByTitleGUI(libraryApp);
		});

		checkoutBook.addActionListener(event -> {
			new CheckoutBookGUI(libraryApp);
		});

		returnBook.addActionListener(event -> {
			new ReturnBookGUI(libraryApp);
		});

		donateBook.addActionListener(event -> {
			new DonateBookGUI(libraryApp);
		});

		exit.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();
		});
	}
}
