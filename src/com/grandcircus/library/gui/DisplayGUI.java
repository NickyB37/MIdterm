package com.grandcircus.library.gui;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.grandcircus.library.model.Book;
import com.grandcircus.library.model.Media;
import com.grandcircus.library.model.Movie;
import com.grandcircus.library.service.LibraryService;

/**
 * Provides a GUI for the user to list books in the library.
 */
public class DisplayGUI extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Displays the DisplayGUI.
	 * @param libraryApp An instance of the library.
	 */
	public DisplayGUI(LibraryService libraryApp) {
		JScrollPane scrollPane = createBookDataTable(libraryApp);

		this.setSize(400, 200);
		this.setModal(true);
		this.setTitle("List of Media");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.add(scrollPane);
		this.pack();
		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

	private JScrollPane createBookDataTable(LibraryService libraryApp) {
		String[] columnNames = { "Title", "Author/Director", "Runtime", "Status", "Date" };

		List<Media> books = libraryApp.getAllBooks();

		Object[][] bookData = new Object[books.size()][];

		for (int i = 0; i < bookData.length; i++) {

			Media media = books.get(i);
			if (media instanceof Book) {
				bookData[i] = new Object[] { media.getTitle(), ((Book) media).getAuthor(), media.getRunTime(),
						media.getStatus(), media.getLocalDate() };
			} else {
				bookData[i] = new Object[] { media.getTitle(), ((Movie) media).getDirector(), media.getRunTime(),
						media.getStatus(), media.getLocalDate().toString() };
			}
		}

		JTable table = new JTable(bookData, columnNames);
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		return scrollPane;
	}
}
