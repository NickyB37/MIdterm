
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

	private static Scanner scnr = new Scanner(System.in);
	private static FileHelper<Book> helper = new FileHelper<>("library.txt", new BookLineConverter());
	public static ArrayList<Book> books = new ArrayList<>();

	static {

		helper.append(new Book("A", "a", "true"));
		helper.append(new Book("B", "b", "true"));
		helper.append(new Book("C", "c", "true"));
		helper.append(new Book("D", "d", "true"));
		helper.append(new Book("E", "e", "true"));
		helper.append(new Book("F", "f", "true"));
		helper.append(new Book("E", "g", "true"));
		helper.append(new Book("F", "h", "true"));
		helper.append(new Book("G", "i", "true"));
		helper.append(new Book("H", "j", "true"));
		helper.append(new Book("I", "k", "true"));
		helper.append(new Book("J", "l", "true"));

	}

	public static void main(String[] args) {

		listBooks();
		System.out.println("Enter an author");
		String authorName = scnr.nextLine();
		lookUpByAuthor(authorName);
		System.out.println("Enter a title");
		String titleName = scnr.nextLine();
		lookUpByTitle(titleName);
		System.out.println("Enter a book to check out.");
		bookCheckOut(titleName);

	}

	private static void listBooks() {
		List<Book> allBook = helper.readAll();
		for (Book b : allBook) {
			System.out.println(b);
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
				if (userChoice.getStatus().startsWith("t")) {
					System.out.println("Checking book out.");
					b.setStatus("false");
				} else {
					System.out.println("That book has been checked out.");
				}
			}

		}
	}
}
