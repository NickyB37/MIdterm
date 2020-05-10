package com.grandcircus.library.service;

import java.time.LocalDate;
import java.util.List;
import com.grandcircus.library.fileio.BookLineConverter;
import com.grandcircus.library.fileio.FileHelper;
import com.grandcircus.library.model.Book;

public class LibraryService {

	private static final String ALPHA_STRING_REGEX = "[a-zA-z\\s]*";
	
	private FileHelper<Book> helper = new FileHelper<>("library.txt", new BookLineConverter());
	private LocalDate now = LocalDate.now();

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

	public String listBooks() {
		List<Book> allBook = helper.readAll();
		StringBuilder sb = new StringBuilder();
		
		for (Book b : allBook) {
			sb.append(b);
			sb.append("\n");
		}
		return sb.toString();
	}

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

	public boolean bookReturn(Book book) {
		List<Book> toAllBook = helper.readAll();
		boolean isReturnSuccessful = false;

		for (Book b : toAllBook) {
			if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
				Book userChoice = b;
				if (userChoice.getStatus().startsWith("C")) {
					b.setStatus("Available");
					isReturnSuccessful = true;
					break;
				}
			}
		}
		helper.rewrite(toAllBook);
		return isReturnSuccessful;
	}

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