
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Book {
	protected String title;
	protected String author;
	protected String status;
	protected LocalDate localDate;

	
	public Book(String title, String author, String status, LocalDate localDate) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
		this.localDate = localDate ;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	@Override
	public String toString() {
		return String.format("Title: " + title + " Author: " + author + " Status: " + status);
	}
	
	
}
