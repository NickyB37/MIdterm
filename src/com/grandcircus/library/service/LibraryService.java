package com.grandcircus.library.service;

import java.time.LocalDate;
import java.util.List;
import com.grandcircus.library.fileio.BookLineConverter;
import com.grandcircus.library.fileio.FileHelper;
import com.grandcircus.library.model.Book;

/**
 * Contains all functionality to run the library.
 */
public class LibraryService {

	private static final String ALPHA_STRING_REGEX = "[a-zA-z\\s]*";
	
	private FileHelper<Book> helper = new FileHelper<>("library.txt", new BookLineConverter());
	private LocalDate now = LocalDate.now();

	/**
	 * Creates a new library service.
	 */
	public LibraryService() {
//		helper.append(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Available", now));
//		helper.append(new Book("The Catcher in the Rye", "J. D. Salinger", "Available", now));
//		helper.append(new Book("Brave New World", "Aldous Huxley", "Available", now));
//		helper.append(new Book("Tail of Two Cites", "Charles Dickens", "Available", now));
//		helper.append(new Book("Pride and Pregudice", "Jane Austen", "Available", now));
//		helper.append(new Book("From the Earth to the Moon", "Jules Verne", "Available", now));
//		helper.append(new Book("1984", "George Orwell", "Available", now));
//		helper.append(new Book("Animal Farm", "George Orwell", "Available", now));
//		helper.append(new Book("Never Die Alone", "Donald Goines", "Available", now));
//		helper.append(new Book("The Adventures of Huckleberry Finn", "Mark Twain", "Available", now));
//		helper.append(new Book("Goosebumps Series", "R. L. Stine", "Available", now));
//		helper.append(new Book("To Kill a Mockingbird", "Harper Lee", "Available", now));
	}

	/**
	 * @return All the books that are in the library.
	 */
	public String listBooks() {
		List<Book> allBook = helper.readAll();
		StringBuilder sb = new StringBuilder();
		
		for (Book b : allBook) {
			sb.append(b);
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * @param authorName The author to search by.
	 * @return The book(s) that the given author has written that are in the library.
	 */
	public String lookUpByAuthor(String authorName) {
		List<Book> allBook = helper.readAll();
		StringBuilder sb = new StringBuilder();

		for (Book b : allBook) {
			if (b.getAuthor().equalsIgnoreCase(authorName)) {
				sb.append(b);
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * @param titleName The title of book to search by.
	 * @return The book that the given title matches in the library.
	 */
	public String lookUpByTitle(String titleName) {
		List<Book> allBook = helper.readAll();
		StringBuilder sb = new StringBuilder();

		for (Book b : allBook) {
			if (b.getTitle().equalsIgnoreCase(titleName)) {
				sb.append(b);
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * @param book The book that the user would like  to checkout.
	 * @return True if the book was successfully checked out. 
	 */
	public boolean checkoutBook(Book book) {
		List<Book> allBook = helper.readAll();
		boolean isCheckoutSuccessful = false;
		
		for (Book b : allBook) {
			if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
				Book userChoice = b;
				if (userChoice.getStatus().startsWith("A")) {
					b.setStatus("Checked out");
					b.setLocalDate(b.getLocalDate().plusWeeks(2));
					isCheckoutSuccessful = true;
					break;
				}
			}
		}
		helper.rewrite(allBook);
		return isCheckoutSuccessful;
	}
	
	/**
	 * 
	 * @param book The book that the user would like to return.
	 * @return True if the book was successfully returned.
	 */
	public boolean bookReturn(Book book) {
		List<Book> toAllBook = helper.readAll();
		boolean isReturnSuccessful = false;

		for (Book b : toAllBook) {
			if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
				Book userChoice = b;
				if (userChoice.getStatus().startsWith("C")) {
					b.setStatus("Available");
					b.setLocalDate(now);
					isReturnSuccessful = true;
					break;
				}
			}
		}
		helper.rewrite(toAllBook);
		return isReturnSuccessful;
	}

	/**
	 * @param bookTitle The title of a book the user would like to donate.
	 * @param bookAuthor The author of a book the use would like to donate.
	 * @return True if the title and author entered by the user was successfully added to the list of books in the library.
	 */
	public boolean addBook(String bookTitle, String bookAuthor) {
		
		if(!bookTitle.matches(ALPHA_STRING_REGEX)) {
			return false;
		}
		
		if(!bookAuthor.matches(ALPHA_STRING_REGEX)) {
			return false;
		}

		helper.append(new Book(bookTitle, bookAuthor, "Available", now));
		
		return true;
	}

	public List<Book> getAllBooks() {
		return helper.readAll();
	}
}