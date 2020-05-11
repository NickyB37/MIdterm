package com.grandcircus.library.service;

import java.time.LocalDate;
import java.util.List;
import com.grandcircus.library.fileio.MediaLineConverter;
import com.grandcircus.library.fileio.FileHelper;
import com.grandcircus.library.model.Book;
import com.grandcircus.library.model.Media;
import com.grandcircus.library.model.Movie;

/**
 * Contains all functionality to run the library.
 */
public class LibraryService {

	private static final String ALPHA_NUMERIC_STRING_REGEX = "[a-zA-Z0-9\\s]*";

	private FileHelper<Media> helper = new FileHelper<>("library.txt", new MediaLineConverter());
	private LocalDate now = LocalDate.now();

	/**
	 * Creates a new library service.
	 */
	public LibraryService() {
		helper.append(new Book("The Great Gatsby", "F. Scott Fitzgerald", "N/A", "Available", now));
		helper.append(new Book("The Catcher in the Rye", "J. D. Salinger", "N/A", "Available", now));
		helper.append(new Book("Brave New World", "Aldous Huxley", "N/A", "Available", now));
		helper.append(new Book("Tail of Two Cites", "Charles Dickens", "N/A", "Available", now));
		helper.append(new Book("Pride and Pregudice", "Jane Austen", "N/A", "Available", now));
		helper.append(new Book("From the Earth to the Moon", "Jules Verne", "N/A", "Available", now));
		helper.append(new Book("1984", "George Orwell", "N/A", "Available", now));
		helper.append(new Book("Animal Farm", "George Orwell", "N/A", "Available", now));
		helper.append(new Book("Never Die Alone", "Donald Goines", "N/A", "Available", now));
		helper.append(new Book("The Adventures of Huckleberry Finn", "Mark Twain", "N/A", "Available", now));
		helper.append(new Book("Goosebumps Series", "R. L. Stine", "N/A", "Available", now));
		helper.append(new Book("To Kill a Mockingbird", "Harper Lee", "N/A", "Available", now));
		helper.append(new Movie("Avatar", "James Cameron", "2hrs 42mins", "Available", now));
		helper.append(new Movie("Jaws", "Steven Spielburg", "2hrs 10mins", "Available", now));
		helper.append(new Movie("Pulp Fiction", "Quenton Tarantino", "2hrs 58mins", "Available", now));
		helper.append(new Movie("The Grand Budapest Hotel", "Wes Anderson", "1hrs 40mins", "Available", now));
		helper.append(new Movie("Mad Max", "George Miller", "2hrs 5min", "Available", now));
		helper.append(new Movie("Forest Gump", "Robert Zemeckis", "2hrs 22mins", "Available", now));
		helper.append(new Movie("Avengers", "Joss Wheldon", "2hrs 23mins", "Available", now));
		helper.append(new Movie("Titanic", "James Cameron", "3hrs 15mins", "Available", now));
		helper.append(new Movie("Goodfellas", "Martin Scorsese", "2hrs 28mins", "Available", now));
		helper.append(new Movie("The Godfather", "Francis Coppola", "2hrs 58mins", "Available", now));
		helper.append(new Movie("The Godfather 2", "Francis Coppola", "3hrs 22 mins", "Available", now));
		helper.append(new Movie("The Godfather 3", "Francis Coppola", "2hrs 50mins", "Available", now));
	}

	/**
	 * @return All the books that are in the library.
	 */
	public String listBooks() {
		List<Media> allMedia = helper.readAll();
		StringBuilder sb = new StringBuilder();

		for (Media b : allMedia) {
			sb.append(b);
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * @param authorName The author to search by.
	 * @return The book(s) that the given author has written that are in the
	 *         library.
	 */
	public String lookUpByAuthor(String authorName) {
		List<Media> allMedia = helper.readAll();
		StringBuilder sb = new StringBuilder();

		for (Media b : allMedia) {
			if (b instanceof Book) {
				if (((Book) b).getAuthor().equalsIgnoreCase(authorName)) {
					sb.append(b);
					sb.append("\n");
				}
			} else if (b instanceof Movie) {
				if (((Movie) b).getDirector().equalsIgnoreCase(authorName)) {
					sb.append(b);
					sb.append("\n");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @param titleName The title of book to search by.
	 * @return The book that the given title matches in the library.
	 */
	public String lookUpByTitle(String titleName) {
		List<Media> allBook = helper.readAll();
		StringBuilder sb = new StringBuilder();

		for (Media b : allBook) {
			if (b.getTitle().toLowerCase().contains(titleName)) {
				sb.append(b);
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/*
	 * @param selectedBook The book that the user would like checkout.
	 * 
	 * @return True if the book was successfully checked out.
	 */
	public boolean checkoutBook(Media selectedBook) {
		List<Media> allBook = helper.readAll();
		boolean isCheckoutSuccessful = false;

		for (Media b : allBook) {
			if (b.getTitle().equalsIgnoreCase(selectedBook.getTitle())) {
				if (b.getStatus().startsWith("A")) {
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
	 * @param selectedBook The book that the user would like to return.
	 * @return True if the book was successfully returned.
	 */
	public boolean bookReturn(Media selectedBook) {
		List<Media> toAllBook = helper.readAll();
		boolean isReturnSuccessful = false;

		for (Media b : toAllBook) {
			if (b.getTitle().equalsIgnoreCase(selectedBook.getTitle())) {
				if (b.getStatus().startsWith("C")) {
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
	 * @param bookTitle  The title of a book the user would like to donate.
	 * @param bookAuthor The author of a book the use would like to donate.
	 * @return True if the title and author entered by the user was successfully
	 *         added to the list of books in the library.
	 */
	public boolean addBook(String bookTitle, String bookAuthor) {

		if (!bookTitle.matches(ALPHA_NUMERIC_STRING_REGEX)) {
			return false;
		}

		if (!bookAuthor.matches(ALPHA_NUMERIC_STRING_REGEX)) {
			return false;
		}

		helper.append(new Book(bookTitle, bookAuthor, "N/A", "Available", now));

		return true;
	}

	public boolean addMovie(String title, String director, String runTime) {

		if (!title.matches(ALPHA_NUMERIC_STRING_REGEX)) {
			return false;
		}

		if (!director.matches(ALPHA_NUMERIC_STRING_REGEX)) {
			return false;
		}

		if (!runTime.matches(ALPHA_NUMERIC_STRING_REGEX)) {
			return false;
		}

		helper.append(new Movie(title, director, runTime, "Available", now));

		return true;
	}

	public List<Media> getAllBooks() {
		return helper.readAll();
	}
}