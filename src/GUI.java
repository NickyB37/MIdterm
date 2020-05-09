import javax.swing.*;

public class GUI {
	public static void main(String[] args) {
		
		LibraryApp libraryApp = new LibraryApp();
		//These objects are dependent on the object LibraryApp for functionality
		DisplayGUI displayGui = new DisplayGUI(libraryApp);
		SearchByAuthorGUI searchByAuthorGui = new SearchByAuthorGUI(libraryApp);
		SearchByTitleGUI searchByTitleGui = new SearchByTitleGUI(libraryApp);
		CheckoutBookGUI checkoutBookGui = new CheckoutBookGUI(libraryApp);
		ReturnBookGUI returnBookGui = new ReturnBookGUI(libraryApp);
		DonateBookGUI donateBookGui = new DonateBookGUI(libraryApp);
		
		JFrame f = new JFrame();// creating instance of JFrame
		JButton display = new JButton("Display books");// creating instance of JButton
		JButton searchByAuthor = new JButton("Search by author");
		JButton searchByTitle = new JButton("Search by title");
		JButton checkoutBook = new JButton("Checkout book");
		JButton returnBook = new JButton("Return book");
		JButton donateBook = new JButton("Donate a book");
		JButton exit = new JButton("Exit");
		
		display.setBounds(130, 100, 250, 40);// x axis, y axis, width, height
		searchByAuthor.setBounds(130, 140, 250, 40);
		searchByTitle.setBounds(130, 180, 250, 40);
		checkoutBook.setBounds(130, 220, 250, 40);
		returnBook.setBounds(130, 260, 250, 40);
		donateBook.setBounds(130, 300, 250, 40);
		exit.setBounds(130, 340, 250, 40);

		
		f.add(display);// adding button in JFrame
		f.add(searchByAuthor);
		f.add(searchByTitle);
		f.add(checkoutBook);
		f.add(returnBook);
		f.add(donateBook);
		f.add(exit);
		
		f.setSize(1000, 1500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
		
		display.addActionListener(event -> {
			
		});
		
		searchByAuthor.addActionListener(event -> {
			searchByAuthorGui.setVisible(true);
		});
		
		searchByTitle.addActionListener(event -> {
			searchByTitleGui.setVisible(true);
		});
		
		checkoutBook.addActionListener(event -> {
			checkoutBook.setVisible(true);
		});
		
		returnBook.addActionListener(event -> {
			returnBook.setVisible(true);
		});
		
		donateBook.addActionListener(event -> {
			donateBook.setVisible(true);
		});
		
		exit.addActionListener(event -> {
			System.out.println("Thank you for stoping by our humble library!");
			System.exit(0);
		});
	}
}
