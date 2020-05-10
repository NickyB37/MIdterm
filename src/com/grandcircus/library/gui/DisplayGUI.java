package com.grandcircus.library.gui;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.grandcircus.library.model.Book;
import com.grandcircus.library.service.LibraryService;

public class DisplayGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	
	public DisplayGUI(LibraryService libraryApp) {
		JScrollPane scrollPane = createBookDataTable(libraryApp);
		
		this.setSize(400, 200);
		this.setModal(true);
		this.setTitle("List of Books");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.add(scrollPane);
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}

	private JScrollPane createBookDataTable(LibraryService libraryApp) {
		String[] columnNames = {"Title", "Author", "Status", "Date"};
		List<Book> books = libraryApp.getAllBooks();
		
		Object[][] bookData = new Object[books.size()][];
		
		for (int i = 0; i < bookData.length; i++) {
			Book book = books.get(i);
			bookData[i] = new Object[] {book.getTitle(), book.getAuthor(), book.getStatus(), book.getLocalDate()};
		}
		
		JTable table = new JTable(bookData, columnNames);
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		return scrollPane;
	}

}
