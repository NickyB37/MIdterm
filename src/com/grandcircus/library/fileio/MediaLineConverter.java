package com.grandcircus.library.fileio;

import java.time.LocalDate;

import com.grandcircus.library.model.Book;
import com.grandcircus.library.model.Media;
import com.grandcircus.library.model.Movie;

/**
 * Converts a string to a book model.
 */
public class MediaLineConverter implements LineConverter<Media> {

	@Override
	public String toLine(Media object) {

		if (object instanceof Book) {
			return object.getTitle() + "," + ((Book) object).getAuthor() + "," + object.getRunTime() + ","+ object.getStatus() + ","
					+ object.getLocalDate().toString();
		} else {
			return object.getTitle() + "," + (((Movie) object).getDirector()) + "," + object.getRunTime()
					+ "," + object.getStatus() + "," + object.getLocalDate().toString();
		}
	}

	@Override
	public Media fromLine(String line) {
		String[] parts = line.split(",");
		String title = parts[0];
		String director = parts[1];
		String runTime = parts[2];
		String status = parts[3];
		LocalDate date = LocalDate.parse(parts[4]);
		return new Movie(title, director, runTime, status, date);

	}

}
