import javax.swing.*;

public class GUI {
	public static void main(String[] args) {
		
		LibraryApp libraryApp = new LibraryApp();
		SearchByAuthorGUI searchByAuthorGui = new SearchByAuthorGUI(libraryApp); 
		
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
		
		
		
		display.addActionListener(event -> {
			
		});
		
		
		searchByAuthor.addActionListener(event -> {
			searchByAuthorGui.setVisible(true);
		});
		
//		searchByTitle.addActionListener(new ClickListener() {
//			public void actionPerformed(ActionEvent e) {
//			      LibraryApp.lookUpByTitle();
//			   }
//		}
//		);
//		
//		searchByTitle.addActionListener(new ClickListener() {
//			public void actionPerformed(ActionEvent e) {
//			      LibraryApp.lookUpByTitle();
//			   }
//		}
//		);
//		
//		checkoutBook.addActionListener(new ClickListener() {
//			public void actionPerformed(ActionEvent e) {
//			      LibraryApp.bookCheckOut();
//			   }
//		}
//		);
//		
//		returnBook.addActionListener(new ClickListener() {
//			public void actionPerformed(ActionEvent e) {
//			      LibraryApp.bookReturn();
//			   }
//		}
//		);
		
//		donateBook.addActionListener(new ClickListener() {
//			public void actionPerformed(ActionEvent e) {
//			      LibraryApp.addBook();
//			   }
//		}
//		);
		
		donateBook.addActionListener(event -> {
			libraryApp.addBook();
		});
		
//		exit.addActionListener(new ClickListener() {
//			public void actionPerformed(ActionEvent e) {
//			     System.out.println("Thank you for stopping by our humble library!");
//			   System.exit(0);
//			}
//		}
//		);
		
		exit.addActionListener(event -> {
			System.out.println("Thank you for stoping by our humble library!");
			System.exit(0);
		});
		

		
		f.setSize(1000, 1500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}
}
