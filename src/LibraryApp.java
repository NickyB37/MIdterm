
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
	static {

		LocalDate now = LocalDate.now();

		helper.append(new Book("A", "a", "true", now));
		helper.append(new Book("B", "b", "true", now ));
		helper.append(new Book("C", "c", "true", now ));
		helper.append(new Book("D", "d", "true", now ));
		helper.append(new Book("E", "e", "true", now ));
		helper.append(new Book("F", "f", "true", now));
		helper.append(new Book("E", "g", "true", now));
		helper.append(new Book("F", "h", "true", now));
		helper.append(new Book("G", "i", "true", now));
		helper.append(new Book("H", "j", "true", now));
		helper.append(new Book("I", "k", "true", now));
		helper.append(new Book("J", "l", "true", now));

	}

	public static void main(String[] args) {
		fillMenu();
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
		menu.put(6, "Exit");
	}

	private static void printMenu() {
		System.out.println("Welcome to the library");
		System.out.println("==========================");
		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			System.out.printf("%-10d %-10s\n", entry.getKey(), entry.getValue());
		}
	}

	private static void whileLoop() {
		boolean runApp = true;
		while (runApp) {
			printMenu();
			System.out.println();
			System.out.println("Choose a number from the menu.");
			int userInt = scnr.nextInt();
			scnr.nextLine();
			if (userInt == 1) {
				listBooks();
			} else if (userInt == 2) {
				System.out.println("Enter an author");
				String authorName = scnr.nextLine();
				lookUpByAuthor(authorName);
			} else if (userInt == 3) {
				System.out.println("Enter a title");
				String titleName = scnr.nextLine();
				lookUpByTitle(titleName);
			} else if (userInt == 4) {
				System.out.println("Enter a book to check out.");
				String titleName = scnr.nextLine();
				bookCheckOut(titleName);
			} else if (userInt == 5) {
				System.out.println("Enter a book to check out.");
				String titleName = scnr.nextLine();
				bookReturn(titleName);
			} else if (userInt == 6) {
				runApp = false;
				System.out.println("Thanks for visiting! See you next time!");
			}
		}
	}

	private static void lookUpByAuthor(String authorName) {
		List<Book> allBook = helper.readAll();

		for (Book b : allBook) {
			if (b.getAuthor().equalsIgnoreCase(authorName)) {
				System.out.println(b.getTitle());
			}
		}
	}

	private static void lookUpByTitle(String titleName) {
		List<Book> allBook = helper.readAll();

		for (Book b : allBook) {
			if (b.getTitle().equalsIgnoreCase(titleName)) {
				System.out.println(b.getAuthor());
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