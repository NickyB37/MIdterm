import java.awt.GridLayout;

import javax.swing.*;

public class GUI {
	public static void main(String[] args) {		
		LibraryApp libraryApp = new LibraryApp();

		JFrame frame = new JFrame();// creating instance of JFrame
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JButton display = new JButton("Display books");// creating instance of JButton
		JButton searchByAuthor = new JButton("Search by author");
		JButton searchByTitle = new JButton("Search by title");
		JButton checkoutBook = new JButton("Checkout book");
		JButton returnBook = new JButton("Return book");
		JButton donateBook = new JButton("Donate a book");
		JButton exit = new JButton("Exit");
		
		// 0 in the parameter means unlimited rows
		frame.setLayout(new GridLayout(0, 1));
        
		frame.add(display);
		frame.add(searchByAuthor);
		frame.add(searchByTitle);
		frame.add(checkoutBook);
		frame.add(returnBook);
		frame.add(donateBook);
		frame.add(exit);
        
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//Used lambdas because the ActionListener interface only has one method in it. 
		//Otherwise we could not use lambda.
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
			CheckoutBookGUI checkoutBookGui = new CheckoutBookGUI(libraryApp);
			checkoutBook.setVisible(true);
		});
		
		returnBook.addActionListener(event -> {
			ReturnBookGUI returnBookGui = new ReturnBookGUI(libraryApp);
			returnBook.setVisible(true);
		});
		
		donateBook.addActionListener(event -> {
			DonateBookGUI donateBookGui = new DonateBookGUI(libraryApp);
			donateBook.setVisible(true);
		});
		
		exit.addActionListener(event -> {
			System.out.println("Thank you for stopping by our humble library!");
			frame.setVisible(false);
			frame.dispose();
		});
	}
}
