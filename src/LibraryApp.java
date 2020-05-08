
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LibraryApp {

	private static Scanner scnr = new Scanner(System.in);
	private static Map<Integer, String> menu = new HashMap<>();
	private static FileHelper<Book> helper = new FileHelper<>("library.txt", new BookLineConverter());
	public static ArrayList<Book> books = new ArrayList<>();
	private static LocalDate now = LocalDate.now();

	static {
		helper.append(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Available", now));
		helper.append(new Book("The Catcher in the Rye", "J. D. Salinger", "Available", now));
		helper.append(new Book("Brave New World", "Aldous Huxley", "Available", now));
		helper.append(new Book("Tail of Two Cites", "Charles Dickens", "Available", now));
		helper.append(new Book("A", "Andrew Adamson", "Available", now));
		helper.append(new Book("From the Earth to the Moon", "Jules Verne", "Available", now));
		helper.append(new Book("1984", "George Orwell", "Available", now));
		helper.append(new Book("Animal Farm", "George Orwell", "Available", now));
		helper.append(new Book("Never Die Alone", "Donald Goines", "Available", now));
		helper.append(new Book("The Adventures of Huckleberry Finn", "Mark Twain", "Available", now));
		helper.append(new Book("Goosebumps Series", "R. L. Stine", "Available", now));
		helper.append(new Book("To Kill a Mockingbird", "Harper Lee", "Available", now));
	}
	
	public static void main(String[] args) {
		fillMenu();
		updateDate();
		whileLoop();

	}

	private static void listBooks() {
		List<Book> allBook = helper.readAll();
		for (Book b : allBook) {
			System.out.println(b);
		}
	}

	private static void fillMenu() {
		menu.put(1, "Display books");
		menu.put(2, "Search by author");
		menu.put(3, "Search by title");
		menu.put(4, "Checkout book");
		menu.put(5, "Return book");
		menu.put(6, "Donate a book");
		menu.put(7, "Exit");
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("Welcome to the library");
		System.out.println("==========================");
		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			System.out.printf("%-10d %-10s\n", entry.getKey(), entry.getValue());
		}
	}
	
	private static void updateDate() {
		List<Book> allBook = helper.readAll();

		for (Book b : allBook) {
			if (b.getStatus().startsWith("A")) {
				b.setLocalDate(now);
			}
		}
		
	}

	private static void whileLoop() {
		boolean runApp = true;
		while (runApp) {
			printMenu();
			System.out.println();
			int userInt = GrandCircusValidator.getInt(scnr, "Choose a number from the menu: ");
			if (userInt == 1) {
				listBooks();
			} else if (userInt == 2) {
				String authorName = GrandCircusValidator.getStringMatchingRegex(scnr, "Enter an author: ", "[a-zA-z\\s]*");
				lookUpByAuthor(authorName);
			} else if (userInt == 3) {
				String titleName = GrandCircusValidator.getStringMatchingRegex(scnr, "Enter a title: ", "[a-zA-z\\s]*");
				lookUpByTitle(titleName);
			} else if (userInt == 4) {
				String titleName = GrandCircusValidator.getStringMatchingRegex(scnr, "Enter a book to check out: ", "[a-zA-z\\s]*");
				bookCheckOut(titleName);
			} else if (userInt == 5) {
				String titleName = GrandCircusValidator.getStringMatchingRegex(scnr, "Enter a book to return: ", "[a-zA-z\\s]*");
				bookReturn(titleName);
			}else if(userInt == 6) {
				addBook();
			}else if (userInt == 7) {
				runApp = false;
				System.out.println("Thanks for visiting! See you next time!");
			}
		}
	}

	private static void addBook(){
	
	System.out.println("Enter the authors name: ");
	String authorToAdd = scnr.nextLine();

	System.out.println("Enter the title: ");
	String titleToAdd = scnr.nextLine();

	helper.append(new Book(titleToAdd, authorToAdd, "Available", now));
	}
	
	private static void lookUpByAuthor(String authorName) {
		List<Book> allBook = helper.readAll();

		for (Book b : allBook) {
			if (b.getAuthor().equalsIgnoreCase(authorName)) {
				System.out.println(b);
			}
		}
	}

	private static void lookUpByTitle(String titleName) {
		List<Book> allBook = helper.readAll();

		for (Book b : allBook) {
			if (b.getTitle().equalsIgnoreCase(titleName)) {
				System.out.println(b);
			}
		}
	}

	private static void bookCheckOut(String titleName) {
		List<Book> allBook = helper.readAll();

		for (Book b : allBook) {
			if (b.getTitle().equalsIgnoreCase(titleName)) {
				System.out.println("Avaiable");
				Book userChoice = b;
				if (userChoice.getStatus().startsWith("A")) {
					System.out.println("Checking book out.");
					b.setStatus("Checked out");
					System.out.println("......");
					System.out.println(userChoice.getTitle() + " has been successfully checked out.");
					b.setLocalDate(b.getLocalDate().plusWeeks(2));;
				} else {
					System.out.println("That book has been checked out.");
				}
			}
		}
		helper.rewrite(allBook);
	}

	private static void bookReturn(String titleName) {
		List<Book> toAllBook = helper.readAll();

		for (Book b : toAllBook) {
			if (b.getTitle().equalsIgnoreCase(titleName)) {
				Book userChoice = b;
				if (userChoice.getStatus().startsWith("C")) {
					System.out.println("Thank you for returning " + userChoice.getTitle());
					b.setStatus("Available");
				} else {
					System.out.println("That book has been checked out.");
				}
			}

		}
		helper.rewrite(toAllBook);
	}
}