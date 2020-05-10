package com.grandcircus.library.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.grandcircus.library.model.Book;
import com.grandcircus.library.service.LibraryService;

/**
 * Provides a GUI for the user to checkout a book.
 */
public class CheckoutBookGUI extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Displays the CheckoutBookGUI.
	 * @param libraryApp An instance of the library.
	 */
	public CheckoutBookGUI(LibraryService libraryApp) {
		JComboBox<Book> bookList = new JComboBox(libraryApp.getAllBooks().toArray());
		JButton checkoutBookButton = new JButton("Checkout book");

		this.setSize(800, 100);
		this.setModal(true);
		this.setTitle("Chechout a Book");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.add(bookList);
		this.add(checkoutBookButton);
		this.setLocationRelativeTo(null);

		checkoutBookButton.addActionListener(event -> {
			Book selectedBook = (Book) bookList.getSelectedItem();
			if (libraryApp.checkoutBook(selectedBook)) {
				JOptionPane.showMessageDialog(this, selectedBook + "  has been successfully checked out!");
			} else {
				JOptionPane.showMessageDialog(this, selectedBook + " is not available for checkout.");
			}
		});
		this.setVisible(true);
	}

}
